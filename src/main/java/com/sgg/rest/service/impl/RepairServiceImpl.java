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

import com.sgg.rest.model.ApplicationUser;
import com.sgg.rest.model.Repair;
import com.sgg.rest.model.RepairQuery;
import com.sgg.rest.repository.RepairRepository;
import com.sgg.rest.repository.UserRepository;
import com.sgg.rest.service.RepairService;
import com.sgg.rest.util.StringUtils;
import  static com.sgg.rest.util.SystemConstants.EIGTHTEEN;;
@Service
public class RepairServiceImpl implements RepairService {
	@Resource  
    UserRepository userRepository;
	@Resource  
    RepairRepository repairRepository;
	
	@Override
	public boolean createRepair(String userId, Repair repair) {
		ApplicationUser user = userRepository.findBySno(userId);
		if (user!=null) {
			repair.setApplicationUser(user);
			repair.setCreate_time(new Date());
			repairRepository.save(repair);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteRepair(Integer Id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateRepair(Integer repairId, Repair repair) {
		Repair f_repair = repairRepository.findOne(repairId);
		if (f_repair!= null) {
			if (StringUtils.IsNull(repair.getAddress())) {
				f_repair.setAddress(repair.getAddress());
			}
			if (StringUtils.IsNull(repair.getArea())) {
				f_repair.setArea(repair.getArea());
			}
			if (StringUtils.IsNull(repair.getContent())) {
				f_repair.setContent(repair.getContent());
			}
			if (StringUtils.IsNull(repair.getCode())) {
				f_repair.setCode(repair.getCode());
			}
			if (StringUtils.IsNull(repair.getTelephone())) {
				f_repair.setTelephone(repair.getTelephone());
			}
			if (StringUtils.IsNull(repair.getComments())) {
				f_repair.setComments(repair.getComments());
			}
			if (StringUtils.IsNull(repair.getResult())) {
				f_repair.setResult(repair.getResult());
			}
			if (StringUtils.IsNull(repair.getRepair_status())) {
				f_repair.setRepair_status(repair.getRepair_status());
			}
			if (StringUtils.IsNull(repair.getMaterial())) {
				f_repair.setMaterial(repair.getMaterial());
			}
			if (StringUtils.IsNull(repair.getUsecount())) {
				f_repair.setUsecount(repair.getUsecount());
			}
			if (StringUtils.IsNull(repair.getRate())) {
				f_repair.setRate(repair.getRate());
			}
			if (StringUtils.IsNull(repair.getIsEvaluate())) {
				f_repair.setIsEvaluate(repair.getIsEvaluate());
			}
			f_repair.setUpdate_time(new Date());
			repairRepository.save(f_repair);
			return true;
		}
		return false;
	}

	@Override
	public Page<Repair> findRepairNoCriteria(Integer page, Integer size) {
		  Pageable pageable = new PageRequest(page, size, Sort.Direction.DESC, "id");  
        return repairRepository.findAll(pageable);  
	}

	@Override
	public Page<Repair> findRepairCriteria(Integer page, Integer size, RepairQuery repairQuery) {
        Pageable pageable = new PageRequest(page, size, Sort.Direction.DESC, "id");  
        Page<Repair> repairPage = repairRepository.findAll(new Specification<Repair>(){  
            @Override  
            public Predicate toPredicate(Root<Repair> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {  
            	Predicate p2 = criteriaBuilder.like(root.get("content").as(String.class), "%"+ repairQuery.getContent() + "%"); 
//            	Predicate p5 = criteriaBuilder.like(root.get("area").as(String.class), repairQuery.getArea()+ "%"); 
            	Predicate p5 = null;
            	if (StringUtils.IsNull(repairQuery.getUserName())) {
                	p5 = criteriaBuilder.between(root.get("area").as(Integer.class), repairQuery.getArea(), EIGTHTEEN);
            	}else {
            		if (repairQuery.getArea() == null) {
            			p5 = criteriaBuilder.like(root.get("area").as(String.class), "%"); 
            		}else {
            			p5 = criteriaBuilder.like(root.get("area").as(String.class), "%"+ repairQuery.getArea()+ "%"); 
            		}
            	}

            	if(StringUtils.IsNull(repairQuery.getSno())) {
            		Predicate p1 = criteriaBuilder.equal(root.get("applicationUser").get("sno").as(String.class), repairQuery.getSno());
            		if(StringUtils.IsNull(repairQuery.getRepair_status())) {
            				Predicate p3 = criteriaBuilder.equal(root.get("repair_status").as(String.class), repairQuery.getRepair_status());
            			if(StringUtils.IsNull(repairQuery.getIsEvaluate())) {
            				Predicate p4 = criteriaBuilder.equal(root.get("isEvaluate").as(String.class), repairQuery.getIsEvaluate());
            				query.where(criteriaBuilder.and(p5,p4,p3,p2,p1));  
            			}else {
            				query.where(criteriaBuilder.and(p5,p3,p2,p1)); 
            			}
            		}else {
            			if(StringUtils.IsNull(repairQuery.getIsEvaluate())) {
            				Predicate p4 = criteriaBuilder.equal(root.get("isEvaluate").as(String.class), repairQuery.getIsEvaluate());
            				query.where(criteriaBuilder.and(p5,p4,p2,p1));  
            			}else {
            				query.where(criteriaBuilder.and(p5,p2,p1)); 
            			}
            		}
            	} else {
            		if(StringUtils.IsNull(repairQuery.getRepair_status())) {
            			Predicate p3 = criteriaBuilder.equal(root.get("repair_status").as(String.class), repairQuery.getRepair_status());
            			if(StringUtils.IsNull(repairQuery.getIsEvaluate())){
            				Predicate p4 = criteriaBuilder.equal(root.get("isEvaluate").as(String.class), repairQuery.getIsEvaluate());
            				query.where(criteriaBuilder.and(p5,p4,p3,p2));  
            			}else {
            				query.where(criteriaBuilder.and(p5,p3,p2));  
            			}
            		}else {
            			if(StringUtils.IsNull(repairQuery.getIsEvaluate())){
            				Predicate p4 = criteriaBuilder.equal(root.get("isEvaluate").as(String.class), repairQuery.getIsEvaluate());
            				query.where(criteriaBuilder.and(p5,p4,p2));  
            			}else {
            				query.where(criteriaBuilder.and(p5,p2)); 
            			}
            		}
            	}
                return query.getRestriction();  
            }  
        },pageable);  
        return repairPage;  
	}

	@Override
	public boolean updateRepairman(Integer repairId, Integer repairmanId) {
		Repair f_repair = repairRepository.findOne(repairId);
		ApplicationUser repairman = userRepository.findOne(repairmanId);
		if(repairman !=null) {
			f_repair.setRepairman(repairman);
			repairRepository.save(f_repair);
			return true;
		}
		return false;
	}

}
