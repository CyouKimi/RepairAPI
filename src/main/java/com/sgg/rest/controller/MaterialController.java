package com.sgg.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sgg.rest.model.Material;
import com.sgg.rest.repository.MaterialRepository;

@RestController
@RequestMapping("/material")
public class MaterialController {
	@Autowired  
	MaterialRepository materialRepository;
//	@RequestMapping(value="/create", method= {RequestMethod.POST})
//	public ResponseEntity<Map<String,Object>> createMaterial(@RequestBody Material material) {
//		materialRepository.save(material);
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("result","success");
//		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
//	}
	
	@RequestMapping(value="/create", method= {RequestMethod.POST})
	public ResponseEntity<Map<String,Object>> createMaterial(@RequestBody List<Material> materialList) {
		materialRepository.save(materialList);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("result"," materialList create success");
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
}
