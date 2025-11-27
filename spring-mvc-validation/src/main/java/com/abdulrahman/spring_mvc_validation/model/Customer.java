package com.abdulrahman.spring_mvc_validation.model;

import jakarta.validation.constraints.*;

public class Customer {

    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName;

    @NotNull(message = "is required")
    @Min(value = 1, message = "Age must be more than of equal one.")
    @Max(value = 120, message = "You lived too much.")
    private Integer age;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Postal ode can be only 5 chars/digits.")
    private String postalCode;

    public @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Postal ode can be only 5 chars/digits.") String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Postal ode can be only 5 chars/digits.") String postalCode) {
        this.postalCode = postalCode;
    }

    public @Min(value = 1, message = "Age must be more than of equal one.") @Max(value = 120, message = "You lived too much.") Integer getAge() {
        return age;
    }

    public void setAge(@Min(value = 1, message = "Age must be more than of equal one.") @Max(value = 120, message = "You lived too much.") Integer age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public @NotNull(message = "is required") @Size(min = 1, message = "is required") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotNull(message = "is required") @Size(min = 1, message = "is required") String lastName) {
        this.lastName = lastName;
    }
}
