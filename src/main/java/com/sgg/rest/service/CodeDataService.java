package com.sgg.rest.service;

import com.sgg.rest.model.CodeData;

public interface CodeDataService {
	boolean createCodeData( Integer typeId,CodeData codeData);
	boolean deleteCodeData(Integer Id);
	boolean updateCodeData(Integer UserId,CodeData codeData);
}
