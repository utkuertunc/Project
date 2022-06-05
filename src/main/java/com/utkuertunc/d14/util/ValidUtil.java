package com.utkuertunc.d14.util;

import com.utkuertunc.d14.entity.Citizen;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ValidUtil {

    public Boolean validCitizenshipForChildren(Citizen citizen){
        if (citizen.getIsCitizen()) {
            return true;
        }
        return false;
    }
}
