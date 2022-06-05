package com.utkuertunc.d14.service.interfaces;

import com.utkuertunc.d14.dto.ChildrenDTO;
import com.utkuertunc.d14.dto.CitizenDTO;
import com.utkuertunc.d14.dto.ParentDTO;
import com.utkuertunc.d14.entity.Citizen;

public interface IMapperService {

    Citizen citizenMapper(CitizenDTO citizenDTO);

    Citizen childrenMapper(ChildrenDTO childrenDTO);

    Citizen parentMapper(ParentDTO parentDTO);

}
