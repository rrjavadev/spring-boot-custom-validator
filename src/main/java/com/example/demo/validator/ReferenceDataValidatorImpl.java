package com.example.demo.validator;

import com.example.demo.external.ExternalClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.nonNull;

@Component
public class ReferenceDataValidatorImpl implements ConstraintValidator<ReferenceDataValidator, Object> {

    @Autowired
    private ReferenceDataType referenceDataType;

    @Autowired
    private ExternalClient externalClient;

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
        List<String> referenceData = externalClient.getReferenceData(referenceDataType).orElse(null);
        return nonNull(referenceData) && isValid(value, referenceData);
    }

    private boolean isValid(Object value, List<String> referenceData){
        return referenceData.stream().anyMatch(e -> e.equals(String.valueOf(value)));
    }
}
