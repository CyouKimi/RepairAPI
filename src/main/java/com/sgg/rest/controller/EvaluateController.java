package com.sgg.rest.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sgg.rest.model.Evaluate;
import com.sgg.rest.repository.EvaluateRepository;
import com.sgg.rest.service.EvaluateService;

@RestController
@RequestMapping("/evaluate")
public class EvaluateController {
	@Autowired  
	EvaluateService evaluateService;
	@Autowired  
	EvaluateRepository evaluateRepository;
	@RequestMapping(value="/create", method= {RequestMethod.POST})
	public ResponseEntity<Map<String,Object>> createEvaluate(@RequestParam Integer repairId,@RequestBody Evaluate evaluate) {
		boolean res =evaluateService.createEvaluate(repairId, evaluate);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("result",res);
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	@GetMapping(path="/detail")
	public ResponseEntity<Map<String,Object>> getRepairDetail(@RequestParam Integer repairId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("result", evaluateRepository.getEvaluateByRepairId(repairId));
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
}
