package com.bci.gestionusuarios.dto;

import lombok.*;

@Data
@Builder
public class PhoneDto {

    private long number;
    private int cityCode;
    private String countryCode;

}
