package com.example.demo.external;

import com.example.demo.validator.ReferenceDataType;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class ExternalServiceClientImpl implements ExternalClient{

    @Override
    public Optional<List<String>> getReferenceData(ReferenceDataType referenceDataType){
        return Optional.of(Arrays.asList("abc", "def", "ghi"));
    }
}
