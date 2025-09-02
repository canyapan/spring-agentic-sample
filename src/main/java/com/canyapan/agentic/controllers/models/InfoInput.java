package com.canyapan.agentic.controllers.models;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class InfoInput {

    private String question;
}
