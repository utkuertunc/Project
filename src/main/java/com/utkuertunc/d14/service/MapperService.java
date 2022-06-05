package com.utkuertunc.d14.service;

import com.utkuertunc.d14.dto.ChildrenDTO;
import com.utkuertunc.d14.dto.CitizenDTO;
import com.utkuertunc.d14.dto.ParentDTO;
import com.utkuertunc.d14.entity.Children;
import com.utkuertunc.d14.entity.Citizen;
import com.utkuertunc.d14.service.interfaces.IMapperService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapperService implements IMapperService {

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Citizen citizenMapper(CitizenDTO citizenDTO){
        return modelMapper.map(citizenDTO, Citizen.class);
    }

    @Override
    public Citizen childrenMapper(ChildrenDTO childrenDTO){
        Citizen citizen = modelMapper.map(childrenDTO, Citizen.class);
        return citizen;
    }

    @Override
    public Citizen parentMapper(ParentDTO parentDTO){
        return modelMapper.map(parentDTO, Citizen.class);
    }
}
