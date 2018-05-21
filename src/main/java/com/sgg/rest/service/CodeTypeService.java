package com.sgg.rest.service;

import com.sgg.rest.model.CodeType;

public interface CodeTypeService {
	boolean createCodeType(CodeType codeType);
//	boolean deleteCodeType(Integer Id);
	boolean updateCodeType(Integer Id,CodeType codeType);
}
