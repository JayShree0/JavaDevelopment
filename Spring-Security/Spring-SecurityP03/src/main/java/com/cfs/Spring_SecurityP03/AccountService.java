package com.cfs.Spring_SecurityP03;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @PreAuthorize("hasRole('USER')")
    // method-level authorization annotation hai. Ye method execute hone se pehle check karta hai ki current logged-in user ke paas required permission/role hai ya nahi.
    // Agar role match nahi hua, to request 403 Access Denied de degi.
    public String getBalance()
    {
        return "Your balance is 8000000";
    }

    @PreAuthorize("hasRole('ADMIN')")
    public String closeAccount()
    {
        return "Account closed";
    }

    public String about() {
        return "Hello sir hum lunch pr hai..";
    }
}
