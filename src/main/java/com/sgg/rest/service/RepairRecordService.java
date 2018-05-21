package com.sgg.rest.service;

import org.springframework.data.domain.Page;

import com.sgg.rest.model.BaseQuery;
import com.sgg.rest.model.RepairRecord;

public interface RepairRecordService {
	boolean createRepairRecord(Integer repairId,RepairRecord repairRecord);
	boolean deleteRepairRecord(Integer Id);
	boolean updateRepairRecord(Integer repairRecordId,RepairRecord repairRecord);
    Page<RepairRecord> findRepairRecordNoCriteria(Integer page,Integer size);  
    Page<RepairRecord> findRepairRecordCriteria(Integer page,Integer size,BaseQuery baseQuery);  
}
