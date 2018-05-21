package com.sgg.rest.service;

import org.springframework.data.domain.Page;

import com.sgg.rest.model.ApplicationUser;
import com.sgg.rest.model.UserQuery;

public interface UserService {
//	boolean createEquipment( Integer locationId,Equipment equipment);
	boolean deleteApplicationUser(Integer UserId);
	boolean updateApplicationUser(Integer UserId,ApplicationUser applicationUser);
    Page<ApplicationUser> findUserNoCriteria(Integer page,Integer size);  
    Page<ApplicationUser> findUserCriteria(Integer page,Integer size,UserQuery userQuery);  
}
