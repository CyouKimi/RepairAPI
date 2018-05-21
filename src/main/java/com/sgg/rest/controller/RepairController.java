package com.sgg.rest.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sgg.rest.model.Repair;
import com.sgg.rest.model.RepairQuery;
import com.sgg.rest.repository.RepairRepository;
import com.sgg.rest.repository.RepairRepositoryCustom;
import com.sgg.rest.service.RepairService;
import static com.sgg.rest.util.SystemConstants.PAGESIZE;
@RestController
@RequestMapping("/repair")
public class RepairController {
	@Autowired  
	RepairService repairService;
	@Autowired  
	RepairRepositoryCustom repairRepositoryCustom;  
	@Autowired  
	RepairRepository repairRepository;  
	@RequestMapping(value="/create", method= {RequestMethod.POST})
	public ResponseEntity<Map<String,Object>> createRepair(@RequestParam String userId,@RequestBody Repair repair) {
		boolean res =repairService.createRepair(userId, repair);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("result",res);
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> updateRepair(@RequestBody Repair repair) {
		Map<String,Object> map = new HashMap<String,Object>();
		boolean res = repairService.updateRepair(repair.getId(), repair);
		map.put("result", res);
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
    @RequestMapping(value = "querylist",method = RequestMethod.POST)  
    public  ResponseEntity<Map<String,Object>> getRepairQueryList(@RequestParam Integer page, @RequestBody RepairQuery repairQuery){  
    		Map<String,Object> map = new HashMap<String,Object>();
        Page<Repair> paginationRepair = repairService.findRepairCriteria(page, PAGESIZE, repairQuery);
        map.put("result", paginationRepair);
        return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);  
    }
	@GetMapping(path="/assertRepairList")
	public ResponseEntity<Map<String,Object>> getAssertRepairList() {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("AssertRepairList",repairRepositoryCustom.getAssertRepairList() );
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	@GetMapping(path="/detail4Assert")
	public ResponseEntity<Map<String,Object>> getAssertRepairDetail(@RequestParam Integer repairId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("result", repairRepositoryCustom.getAssertRepair(repairId));
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	@GetMapping(path="/detail")
	public ResponseEntity<Map<String,Object>> getRepairDetail(@RequestParam Integer repairId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("result", repairRepository.findOne(repairId));
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	@GetMapping(path="/countByRepairStatus")
	public ResponseEntity<Map<String,Object>> getCountByRepairStatus(@RequestParam Integer repairStatus) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("result", repairRepository.countByRepairStatus(repairStatus));
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	@RequestMapping(value="/update")
	public ResponseEntity<Map<String,Object>> updateRepairman(@RequestParam Integer repairId, @RequestParam Integer repairmanId) {
		Map<String,Object> map = new HashMap<String,Object>();
		boolean res = repairService.updateRepairman(repairId, repairmanId);
		map.put("result", res);
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
}
