package com.abdulrahman.spring_mvc_validation.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePref;

    @Override
    public void initialize(CourseCode constraintAnnotation) {

        coursePref = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        if (s != null){
            return s.startsWith(coursePref);
        }

        return true;
    }
}
