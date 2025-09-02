package com.canyapan.agentic.controllers.models;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class AppInput {

    private String service;
    private String instance;
    private Float memoryUsage;
    private Float cpuUsageAverageLast1Min;
    private Long latencyInMillisAverageLast1Min;
}
