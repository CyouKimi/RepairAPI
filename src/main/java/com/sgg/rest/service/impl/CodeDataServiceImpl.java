package com.sgg.rest.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sgg.rest.model.CodeData;
import com.sgg.rest.model.CodeType;
import com.sgg.rest.repository.CodeDataRepository;
import com.sgg.rest.repository.CodeTypeRepository;
import com.sgg.rest.service.CodeDataService;
@Service
public class CodeDataServiceImpl implements CodeDataService{
	@Resource  
    CodeTypeRepository codeTypeRepository;
	@Resource  
    CodeDataRepository codeDataRepository;
	@Override
	public boolean createCodeData(Integer typeId, CodeData codeData) {
		CodeType codeType =codeTypeRepository.findOne(typeId);
		if(codeType !=null) {
			codeData.setType(codeType);
			if(codeDataRepository.save(codeData) != null) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteCodeData(Integer Id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCodeData(Integer UserId, CodeData codeData) {
		// TODO Auto-generated method stub
		return false;
	}

}
