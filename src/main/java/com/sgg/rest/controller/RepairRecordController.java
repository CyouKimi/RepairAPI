package com.sgg.rest.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sgg.rest.model.BaseQuery;
import com.sgg.rest.model.RepairRecord;
import com.sgg.rest.service.RepairRecordService;
import static com.sgg.rest.util.SystemConstants.PAGESIZE;
@RestController
@RequestMapping("/repairRecord")
public class RepairRecordController {
	@Autowired  
	RepairRecordService repairRecordService;
	@RequestMapping(value="/create", method= {RequestMethod.POST})
	public ResponseEntity<Map<String,Object>> createRepairRecord(@RequestParam Integer repairId,@RequestBody RepairRecord repairRecord) {
		boolean res =repairRecordService.createRepairRecord(repairId, repairRecord);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("result",res);
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
    @RequestMapping(value = "querylist",method = RequestMethod.POST)  
    public  ResponseEntity<Map<String,Object>> getRepairRecordQueryList(@RequestParam Integer page, @RequestBody BaseQuery baseQuery){  
    		Map<String,Object> map = new HashMap<String,Object>();
        Page<RepairRecord> paginationRepairRecord = repairRecordService.findRepairRecordCriteria(page, PAGESIZE, baseQuery);
        map.put("result", paginationRepairRecord);
        return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);  
    }
}
