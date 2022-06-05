package com.utkuertunc.d14.util;

import com.utkuertunc.d14.entity.Children;
import com.utkuertunc.d14.entity.Citizen;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ChildrenUtil {

    public Children childrenForParent(Citizen citizen) {
        Children children = new Children();
        children.setChildrenId(citizen.getCitizenId());
        children.setName(citizen.getName());
        return children;
    }
}
