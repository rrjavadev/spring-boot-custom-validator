package com.example.demo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = ReferenceDataValidatorImpl.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ReferenceDataValidator {

    String message() default "invalid reference data";

    ReferenceDataType referenceDataType();

    Class<?>[] groups() default{};

    Class<? extends Payload>[] payload() default {};
}
