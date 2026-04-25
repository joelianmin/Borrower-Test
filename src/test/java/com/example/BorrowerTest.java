package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BorrowerTest {

    @Test
    void should_register_borrower_successfully_with_valid_data() {

        Borrower borrower = Borrower.register(
                "john.doe@example.com",
                "081234567890",
                "SecurePass123");

        assertNotNull(borrower);
        assertNotNull(borrower.getId());
        assertEquals("john.doe@example.com", borrower.getEmail());
        assertEquals(500, borrower.getCreditScore());
        assertEquals("PENDING_VERIFICATION", borrower.getStatus());
    }

    @Test
    void should_fail_when_email_invalid() {
        assertThrows(RuntimeException.class, () -> {
            Borrower.register("invalid-email", "081234567890", "SecurePass123");
        });

        assertEquals("Invalid email format", ex.getMessage());
    }

    @Test
    void should_fail_when_phone_invalid() {
        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            Borrower.register("john@example.com", "123", "SecurePass123");
        });

        assertEquals("Phone number must be 10-15 digits", ex.getMessage());
    }

    @Test
    void should_fail_when_password_invalid() {
        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            Borrower.register("john@example.com", "081234567890", "weakpass");
        });

        assertEquals("Password must be at least 8 characters long", ex.getMessage());
    }
}
