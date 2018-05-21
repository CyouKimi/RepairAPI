package com.sgg.rest.service.impl;

import java.util.Date;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.sgg.rest.model.BaseQuery;
import com.sgg.rest.model.Repair;
import com.sgg.rest.model.RepairRecord;
import com.sgg.rest.repository.RepairRecordRepository;
import com.sgg.rest.repository.RepairRepository;
import com.sgg.rest.service.RepairRecordService;
@Service
public class RepairRecordServiceImpl implements RepairRecordService {
	@Resource  
	RepairRecordRepository repairRecordRepository;
	@Resource  
	RepairRepository repairRepository;
	@Override
	public boolean createRepairRecord(Integer repairId, RepairRecord repairRecord) {
		Repair repair = repairRepository.findOne(repairId);
		if (repair!= null) {
			repairRecord.setRepair(repair);
			repairRecord.setCreate_time(new Date());
			repairRecord.setUpdate_time(new Date());
			repairRecordRepository.save(repairRecord);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteRepairRecord(Integer Id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateRepairRecord(Integer repairRecordId, RepairRecord repairRecord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page<RepairRecord> findRepairRecordNoCriteria(Integer page, Integer size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<RepairRecord> findRepairRecordCriteria(Integer page, Integer size, BaseQuery baseQuery) {
        Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");  
        Page<RepairRecord> repairRecordPage = repairRecordRepository.findAll(new Specification<RepairRecord>(){  
            @Override  
            public Predicate toPredicate(Root<RepairRecord> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {  
            	    Predicate p1 = criteriaBuilder.equal(root.get("repair").get("id").as(String.class), baseQuery.getId());
            	    Predicate p2 = criteriaBuilder.like(root.get("repair_progress").as(String.class), "%"+ baseQuery.getInfo() + "%"); 
            	    query.where(criteriaBuilder.and(p1,p2));
                return query.getRestriction();  
            }  
        },pageable);  
        return repairRecordPage;  
	}

}
