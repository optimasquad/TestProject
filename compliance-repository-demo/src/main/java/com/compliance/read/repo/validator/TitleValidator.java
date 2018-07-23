package com.compliance.read.repo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class TitleValidator implements ConstraintValidator<Title, String> {
    public void initialize(Title constraintAnnotation) {

    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        if ("jatin".equalsIgnoreCase(value)) {
            return false;
        }
        return true;
    }
}
