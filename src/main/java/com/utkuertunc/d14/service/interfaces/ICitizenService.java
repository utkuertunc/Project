package com.utkuertunc.d14.service.interfaces;

import com.utkuertunc.d14.entity.Citizen;

import java.util.List;

public interface ICitizenService {

    List<Citizen> list();

    List<String> listByCitizenship();

    List<String> listByCountOfChildren();

    List<String> findAllByName();

    List<String> findAllByDrivingLicense();

    Citizen save(Citizen citizen);

    Citizen findByCitizenId(Long citizenId);

    String deleteByCitizenId(Long citizenId);

}
