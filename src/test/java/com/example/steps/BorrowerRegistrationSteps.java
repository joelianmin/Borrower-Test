package com.example.steps;

import io.cucumber.java.en.*;
import com.example.Borrower;
import static org.junit.jupiter.api.Assertions.*;

public class BorrowerRegistrationSteps {
    private Borrower borrower;
    private RuntimeException exception;

    @Given("I want to register as a borrower")
    public void i_want_to_register_as_a_borrower() {
        borrower = null;
        exception = null;
    }

    @When("I register with email {string} and phone {string} and password {string}")
    public void i_register_with_valid_data(String email, String phone, String password) {
        try {
            borrower = Borrower.register(email, phone, password);
        } catch (RuntimeException e) {
            exception = e;
        }
    }

    @When("I try to register with email {string} and phone {string} and password {string}")
    public void i_try_to_register_with_invalid_data(String email, String phone, String password) {
        try {
            borrower = Borrower.register(email, phone, password);
        } catch (RuntimeException e) {
            exception = e;
        }
    }

    @Then("the borrower should be registered successfully")
    public void the_borrower_should_be_registered_successfully() {
        assertNotNull(borrower, "Borrower should not be null");
    }

    @And("the borrower should have a unique ID")
    public void the_borrower_should_have_a_unique_id() {
        assertNotNull(borrower.getId(), "Borrower ID should not be null");
        assertFalse(borrower.getId().isEmpty(), "Borrower ID should not be empty");
    }

    @And("the borrower email should be {string}")
    public void the_borrower_email_should_be(String expectedEmail) {
        assertEquals(expectedEmail, borrower.getEmail(), "Email should match");
    }

    @And("the borrower credit score should be {int}")
    public void the_borrower_credit_score_should_be(int expectedScore) {
        assertEquals(expectedScore, borrower.getCreditScore(), "Credit score should match");
    }

    @And("the borrower status should be {string}")
    public void the_borrower_status_should_be(String expectedStatus) {
        assertEquals(expectedStatus, borrower.getStatus(), "Status should match");
    }

    @Then("the registration should fail with error {string}")
    public void the_registration_should_fail_with_error(String expectedError) {
        assertNotNull(exception, "Exception should be thrown");
        assertEquals(expectedError, exception.getMessage(), "Error message should match");
    }
}
