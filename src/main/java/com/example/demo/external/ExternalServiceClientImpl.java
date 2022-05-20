package com.example.demo.external;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ExternalServiceClientImpl implements ExternalClient{

    @Override
    public List<String> getReferenceData(String referenceDataType){
        return Arrays.asList("abc", "def", "ghi");
    }
}
