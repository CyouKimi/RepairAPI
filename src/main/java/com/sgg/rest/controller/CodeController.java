package com.sgg.rest.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sgg.rest.model.CodeData;
import com.sgg.rest.model.CodeType;
import com.sgg.rest.service.CodeDataService;
import com.sgg.rest.service.CodeTypeService;

@RestController
@RequestMapping("/code")
public class CodeController {
	@Autowired  
    CodeTypeService codeTypeService;  
	@Autowired  
    CodeDataService codeDataService;  
	@RequestMapping(value="/createCodeType", method=RequestMethod.POST)
	public ResponseEntity<Map<String,Object>>  getNewUser( @RequestBody CodeType codeType) {
		Map<String,Object> map = new HashMap<String,Object>();
		boolean res = codeTypeService.createCodeType(codeType);
		map.put("result", res);
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value="/createCodeData", method= {RequestMethod.POST,RequestMethod.GET})
	public ResponseEntity<Map<String,Object>> createNewLocation(@RequestParam Integer typeId,@RequestBody CodeData codeData) {
		boolean res =codeDataService.createCodeData(typeId,codeData);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("result",res);
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
}
