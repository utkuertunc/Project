package com.utkuertunc.d14.service;

import com.utkuertunc.d14.entity.Citizen;
import com.utkuertunc.d14.repository.CitizenRepository;
import com.utkuertunc.d14.service.interfaces.ICitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CitizenService implements ICitizenService {

    @Autowired
    private CitizenRepository citizenRepository;

    @Override
    public List<Citizen> list() {
        return citizenRepository.findAll();
    }

    @Override
    public List<String> listByCitizenship() {
        return citizenRepository.findAllByCitizenship();
    }

    @Override
    public List<String> listByCountOfChildren(){
        return citizenRepository.findAllByCountOfChildren();
    }

    @Override
    public List<String> findAllByName(){
        return citizenRepository.findAllByName();
    }

    @Override
    public List<String> findAllByDrivingLicense(){
        return citizenRepository.findAllByDrivingLicense();
    }

    @Override
    public Citizen save(Citizen citizen) {

        return citizenRepository.save(citizen);
    }

    @Override
    public Citizen findByCitizenId(Long citizenId){
        return citizenRepository.findByCitizenId(citizenId);
    }

    @Override
    public String deleteByCitizenId(Long citizenId){
        citizenRepository.deleteById(citizenId);
        return String.format("Citizen by Citizen ID = %d Deleted", citizenId);
    }
}
