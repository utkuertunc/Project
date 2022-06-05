package com.utkuertunc.d14.controller;

import com.utkuertunc.d14.dto.ChildrenDTO;
import com.utkuertunc.d14.entity.Citizen;
import com.utkuertunc.d14.response.RestResponse;
import com.utkuertunc.d14.service.ChildrenService;
import com.utkuertunc.d14.service.CitizenService;
import com.utkuertunc.d14.service.MapperService;
import com.utkuertunc.d14.util.ChildrenUtil;
import com.utkuertunc.d14.util.ValidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/children")
public class ChildrenController {

    @Autowired
    private ChildrenService childrenService;

    @Autowired
    private CitizenService citizenService;

    @Autowired
    private MapperService mapperService;

    @PostMapping("/add")
    public RestResponse<Citizen> addChildren(@RequestBody ChildrenDTO childrenDTO, @RequestParam Long parentId) {
        Citizen citizen = mapperService.childrenMapper(childrenDTO);

        if(!ValidUtil.validCitizenshipForChildren(citizen)){
            return new RestResponse<>(HttpStatus.NOT_ACCEPTABLE.name(),"Children Must Be Citizen", citizen);
        }

        citizenService.save(citizen);
        childrenService.save(parentId, ChildrenUtil.childrenForParent(citizen));

        return new RestResponse<>(citizen);
    }
}
