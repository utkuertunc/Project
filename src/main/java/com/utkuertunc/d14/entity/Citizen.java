package com.utkuertunc.d14.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Data
@Entity
public class Citizen {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long citizenId;

    private String name;

    private Boolean isCitizen;

    private Boolean hasDrivingLicense;

    @JsonManagedReference
    @OneToMany(mappedBy = "parent",fetch = FetchType.LAZY)
    private Set<Children> children;
}
