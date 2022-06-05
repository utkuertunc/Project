package com.utkuertunc.d14.service.interfaces;

import com.utkuertunc.d14.entity.Children;

public interface IChildrenService {

    Children save(Long parentId, Children children);

    void deleteByChildrenId(Long children_id);

}
