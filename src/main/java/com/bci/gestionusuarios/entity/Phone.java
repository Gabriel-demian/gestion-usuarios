package com.bci.gestionusuarios.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Phone {

    private long number;
    private int cityCode;
    private String countryCode;

}
