package com.sgg.rest.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sgg.rest.model.Evaluate;
import com.sgg.rest.model.Repair;
import com.sgg.rest.repository.EvaluateRepository;
import com.sgg.rest.repository.RepairRepository;
import com.sgg.rest.service.EvaluateService;
@Service
public class EvaluateServiceImpl implements EvaluateService {
	@Resource  
	EvaluateRepository evaluateRepository;
	@Resource  
	RepairRepository repairRepository;
	@Override
	public boolean createEvaluate(Integer repairId, Evaluate evaluate) {
		Repair repair  = repairRepository.findOne(repairId);
		if (repair!=null) {
			evaluate.setRepair(repair);
			evaluateRepository.save(evaluate);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteEvaluate(Integer Id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEvaluate(Integer evaluateId, Evaluate evaluate) {
		// TODO Auto-generated method stub
		return false;
	}

//	@Override
//	public Evaluate getEvaluate(Integer repairId) {
//		return null;
//	}

}
