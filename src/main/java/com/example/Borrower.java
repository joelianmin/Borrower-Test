package com.example;

import java.util.UUID;

public class Borrower {
    private String id;
    private String email;
    private int creditScore;
    private String status;

    private Borrower(String id, String email, int creditScore, String status) {
        this.id = id;
        this.email = email;
        this.creditScore = creditScore;
        this.status = status;
    }

    public static Borrower register(String email, String phone, String password) {
        if (!email.contains("@")) {
            throw new RuntimeException("Invalid email format");
        }

        if (phone.length() < 10 || phone.length() > 15) {
            throw new RuntimeException("Phone number must be 10-15 digits");
        }

        if (password.length() < 8) {
            throw new RuntimeException("Password must be at least 8 characters long");
        }

        return new Borrower(
                UUID.randomUUID().toString(),
                email,
                500,
                "PENDING_VERIFICATION");
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public String getStatus() {
        return status;
    }
}
