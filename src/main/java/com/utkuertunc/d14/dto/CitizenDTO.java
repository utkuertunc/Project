package com.utkuertunc.d14.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CitizenDTO {

    @NotNull
    private String name;

    private Boolean isCitizen;

    private Boolean hasDrivingLicense;
}
