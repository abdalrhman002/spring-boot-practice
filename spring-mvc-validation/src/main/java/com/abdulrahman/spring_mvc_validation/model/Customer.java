package com.abdulrahman.spring_mvc_validation.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Customer {

    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName;

    @Min(value = 1, message = "Age must be more than of equal one.")
    @Max(value = 120, message = "You lived too much.")
    private Integer age;

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
