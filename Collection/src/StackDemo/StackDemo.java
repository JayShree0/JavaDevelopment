package StackDemo;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {

        // ✅ Stack create karna
        // Stack use LIFO
        Stack<String> stack = new Stack<>();

        // ✅ push(): elements ko stack me dalna
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        System.out.println("Initial Stack: " + stack);
        // [A, B, C, D]

        // ✅ peek(): top element dekhna (remove nahi karta)
        System.out.println("Top element (peek): " + stack.peek());
        // D

        // ✅ pop(): top element nikalna (remove karta hai)
        System.out.println("Popped element: " + stack.pop());
        // D
        System.out.println("After pop: " + stack);
        // [A, B, C]

        // ✅ search(): element ka position (1-based index from top)
        System.out.println("Position of B: " + stack.search("B"));
        // 2 (C is at top=1, B is next=2)

        // ✅ empty(): check if stack is empty
        System.out.println("Is stack empty? " + stack.empty());
        // false

        // ✅ pop all to make it empty
        stack.pop(); // C
        stack.pop(); // B
        stack.pop(); // A
        System.out.println("Is stack empty after removing all? " + stack.empty());
        // true
    }
}
