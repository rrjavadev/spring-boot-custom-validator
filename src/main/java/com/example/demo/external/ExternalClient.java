package com.example.demo.external;

import com.example.demo.validator.ReferenceDataType;

import java.util.List;
import java.util.Optional;

public interface ExternalClient {
    Optional<List<String>> getReferenceData(ReferenceDataType referenceDataType);
}
