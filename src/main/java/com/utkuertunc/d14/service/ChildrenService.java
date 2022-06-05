package com.utkuertunc.d14.service;

import com.utkuertunc.d14.dto.ParentDTO;
import com.utkuertunc.d14.entity.Children;
import com.utkuertunc.d14.entity.Citizen;
import com.utkuertunc.d14.repository.ChildrenRepository;
import com.utkuertunc.d14.service.interfaces.IChildrenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChildrenService implements IChildrenService {

    @Autowired
    private MapperService mapperService;

    @Autowired
    private ChildrenRepository childrenRepository;

    @Override
    public Children save(Long parentId, Children children){
        Citizen parent = mapperService.parentMapper(new ParentDTO());
        parent.setCitizenId(parentId);
        children.setParent(parent);
        return childrenRepository.save(children);
    }

    @Override
    public void deleteByChildrenId(Long children_id) {
        childrenRepository.deleteById(children_id);
    }

}
