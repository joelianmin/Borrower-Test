Feature: Borrower Registration
  As a user
  I want to register as a borrower
  So that I can apply for a loan

  Scenario: Successfully register borrower with valid data
    Given I want to register as a borrower
    When I register with email "john.doe@example.com" and phone "081234567890" and password "SecurePass123"
    Then the borrower should be registered successfully
    And the borrower should have a unique ID
    And the borrower email should be "john.doe@example.com"
    And the borrower credit score should be 500
    And the borrower status should be "PENDING_VERIFICATION"

  Scenario: Registration fails with invalid email format
    Given I want to register as a borrower
    When I try to register with email "invalid-email" and phone "081234567890" and password "SecurePass123"
    Then the registration should fail with error "Invalid email format"

  Scenario: Registration fails with invalid phone number
    Given I want to register as a borrower
    When I try to register with email "john@example.com" and phone "123" and password "SecurePass123"
    Then the registration should fail with error "Phone number must be 10-15 digits"

  Scenario: Registration fails with weak password
    Given I want to register as a borrower
    When I try to register with email "john@example.com" and phone "081234567890" and password "weak"
    Then the registration should fail with error "Password must be at least 8 characters long"
