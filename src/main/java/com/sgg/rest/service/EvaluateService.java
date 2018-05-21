package com.sgg.rest.service;

import com.sgg.rest.model.Evaluate;

public interface EvaluateService {
	boolean createEvaluate(Integer repairId,Evaluate evaluate);
	boolean deleteEvaluate(Integer Id);
	boolean updateEvaluate(Integer evaluateId,Evaluate evaluate);
//	Evaluate getEvaluate(Integer repairId);
}
