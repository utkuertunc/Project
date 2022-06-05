package com.utkuertunc.d14.util;

import com.utkuertunc.d14.dto.CitizenDTO;
import com.utkuertunc.d14.entity.Citizen;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CitizenUtil {

    public Citizen mappingForUpdate(CitizenDTO newCitizen, Citizen oldCitizen) {
        oldCitizen.setIsCitizen(newCitizen.getIsCitizen());
        oldCitizen.setName(newCitizen.getName());
        oldCitizen.setHasDrivingLicense(newCitizen.getHasDrivingLicense());
        return oldCitizen;
    }
}
