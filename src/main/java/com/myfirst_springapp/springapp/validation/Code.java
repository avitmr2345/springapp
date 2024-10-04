package com.myfirst_springapp.springapp.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = CodeConstraintValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Code {
    public String value() default "XYZ";

    public String message() default "must start with XYZ";

    // group validation constraints or related constraints together
    // define default groups
    public Class<?>[] groups() default {};

    // additional info about the validation error
    // define default payloads
    public Class<? extends Payload>[] payload() default {};
}
