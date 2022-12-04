package com.example.demo.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

@Component
public class ReferenceDataValidatorImpl implements ConstraintValidator<ReferenceDataValidator, Object> {

    @Autowired
    private ReferenceDataType referenceDataType;

    @Override
    public void initialize(ReferenceDataValidator referenceDataValidator) {
        ConstraintValidator.super.initialize(referenceDataValidator);
        this.referenceDataType = referenceDataValidator.referenceDataType();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        if(Objects.isNull(referenceDataType)){
            return true;
        }
        return false;
    }
}
