package com.sgg.rest.service;

import org.springframework.data.domain.Page;

import com.sgg.rest.model.Repair;
import com.sgg.rest.model.RepairQuery;

public interface RepairService {
	boolean createRepair( String userId,Repair repair);
	boolean deleteRepair(Integer Id);
	boolean updateRepair(Integer repairId,Repair repair);
	boolean updateRepairman(Integer repairId,Integer repairmanId);
    Page<Repair> findRepairNoCriteria(Integer page,Integer size);  
    Page<Repair> findRepairCriteria(Integer page,Integer size,RepairQuery repairQuery);  
}
