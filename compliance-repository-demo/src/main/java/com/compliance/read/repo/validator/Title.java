package com.compliance.read.repo.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * 
 * @author hp
 *
 */

@Documented
@Constraint(validatedBy = TitleValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Title {

	String message() default "{Title}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
