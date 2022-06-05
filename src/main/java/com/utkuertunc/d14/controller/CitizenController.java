package com.utkuertunc.d14.controller;

import com.utkuertunc.d14.dto.CitizenDTO;
import com.utkuertunc.d14.entity.Citizen;
import com.utkuertunc.d14.response.RestResponse;
import com.utkuertunc.d14.service.CitizenService;

import com.utkuertunc.d14.service.MapperService;
import com.utkuertunc.d14.util.CitizenUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/citizen")
public class CitizenController {

    @Autowired
    private MapperService mapperService;

    @Autowired
    private CitizenService citizenService;

    @GetMapping("/list")
    public RestResponse<List<Citizen>> listAllCitizens(){
        return new RestResponse<>(citizenService.list());
    }

    @GetMapping("/list/citizenship")
    public RestResponse<List<String>> listAllCitizensByCitizenship(){
        return new RestResponse<>(citizenService.listByCitizenship());
    }

    @GetMapping("/list/count-of-children")
    public RestResponse<List<String>> listAllCitizensByCountOfChildren(){
        return new RestResponse<>(citizenService.listByCountOfChildren());
    }

    @GetMapping("/list/name")
    public RestResponse<List<String>> listAllCitizensByName(){
        return new RestResponse<>(citizenService.findAllByName());
    }

    @GetMapping("/list/driving-license")
    public RestResponse<List<String>> listAllCitizensByDrivingLicense(){
        return new RestResponse<>(citizenService.findAllByDrivingLicense());
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse<Citizen> addCitizen(@Valid @RequestBody CitizenDTO citizenDTO){
        return new RestResponse<>(citizenService.save(mapperService.citizenMapper(citizenDTO)));
    }

    @GetMapping("/id")
    public RestResponse<Citizen> getCitizenById(@RequestParam Long citizenId){
        if(Objects.isNull(citizenService.findByCitizenId(citizenId))){
            return new RestResponse<>(HttpStatus.NO_CONTENT.name(), "Can't find any citizen with", null);
        }
        return new RestResponse<>(citizenService.findByCitizenId(citizenId));
    }

    //If citizen has children, it throws exception(not totally completed)
    @DeleteMapping("/id/delete")
    public RestResponse<String> deleteCitizenById(@RequestParam Long citizenId){
        return new RestResponse<>(citizenService.deleteByCitizenId(citizenId));
    }

    //Return Error message when citizenId or children changed (not totally completed)
    @PutMapping("/id/update")
    public RestResponse<Citizen> updateCitizenById(@Valid @RequestParam Long citizenId, @RequestBody CitizenDTO newCitizen){
        Citizen oldcitizen = citizenService.findByCitizenId(citizenId);
        CitizenUtil.mappingForUpdate(newCitizen,oldcitizen);
        return new RestResponse<>(citizenService.save(oldcitizen));
    }
}
