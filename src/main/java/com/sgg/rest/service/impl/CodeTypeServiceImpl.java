package com.sgg.rest.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sgg.rest.model.CodeType;
import com.sgg.rest.repository.CodeTypeRepository;
import com.sgg.rest.service.CodeTypeService;
@Service
public class CodeTypeServiceImpl implements CodeTypeService{
	@Resource  
    CodeTypeRepository codeTypeRepository;
	@Override
	public boolean createCodeType(CodeType codeType) {
		if(codeType!=null) {
			codeTypeRepository.save(codeType);
			return true;
		}
		return false;
	}

//	@Override
//	public boolean deleteCodeType(Integer Id) {
//		// TODO Auto-generated method stub
//		return false;
//	}

	@Override
	public boolean updateCodeType(Integer Id, CodeType codeType) {
		CodeType f_codeType = codeTypeRepository.findOne(Id);
		if (f_codeType !=null) {
			f_codeType.setCode(codeType.getCode());
			f_codeType.setName(codeType.getName());
			codeTypeRepository.save(f_codeType);
			return true;
		}
		return false;
	}

}
