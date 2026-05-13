package com.cfs.Payment_Gateway.service;

import com.cfs.Payment_Gateway.entity.PaymentOrder;
import com.cfs.Payment_Gateway.repo.PaymentRepo;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PaymentService {

    @Value("${razorpay.api.key}")
    private String keyId;

    @Value("${razorpay.api.secret}")
    private String keySecret;

    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private EmailService emailService;

    public String createOrder(PaymentOrder orderDetails) throws RazorpayException {

        // Step 1: Initialize Razorpay client (used to communicate with Razorpay API)
        RazorpayClient client = new RazorpayClient(keyId, keySecret);

        // Step 2: Prepare request data to create an order in Razorpay system
        JSONObject orderRequest = new JSONObject();

        // Razorpay requires amount in paise (smallest currency unit)
        orderRequest.put("amount", (int)(orderDetails.getAmount() * 100));
        orderRequest.put("currency", "INR");

        // Unique receipt ID for identifying this transaction in Razorpay
        orderRequest.put("receipt", "txn_" + UUID.randomUUID());

        // Step 3: Create order on Razorpay server
        // 👉 This generates a Razorpay Order (used for actual payment processing)
        Order razorpayOrder = client.orders.create(orderRequest);

        System.out.println(razorpayOrder.toString());

        // ================== IMPORTANT CONCEPT ==================

        //  Razorpay Order:
        // This is created on Razorpay's server.
        // It is required to process payment via Razorpay UI / Checkout.

        //  Your Database Order (PaymentOrder):
        // This is your internal record to track:
        // - user details (name, email)
        // - course info
        // - payment status
        // - mapping with Razorpay order

        // ======================================================

        // Step 4: Save Razorpay order ID into your database
        // This links your system with Razorpay system
        orderDetails.setOrderId(razorpayOrder.get("id"));

        // Step 5: Initially, payment is not done yet → status is CREATED
        orderDetails.setStatus("CREATED");

        // Step 6: Store timestamp for tracking
        orderDetails.setCreatedAt(LocalDateTime.now());

        // Step 7: Save your internal order in database
        paymentRepo.save(orderDetails);

        // Step 8: Return Razorpay order response to frontend
        // Frontend will use this to open Razorpay payment gateway
        return razorpayOrder.toString();
    }

    public void updateOrderStatus(String paymentId, String orderId, String status)
    {
        PaymentOrder order = paymentRepo.findByOrderId(orderId);

        order.setPaymentId(paymentId);
        order.setStatus(status);

        paymentRepo.save(order);

        if ("SUCCESS".equalsIgnoreCase(order.getStatus()))
        {
            System.out.println("Sending email to: " + order.getEmail());
            emailService.sendEmail(
                    order.getEmail(),
                    order.getName(),
                    order.getCourseName(),
                    order.getAmount()
            );
        }
    }

}
