package com.sgg.rest.repository;

import java.util.List;


import com.sgg.rest.model.AssertRepair;


public interface RepairRepositoryCustom {
	public List<AssertRepair> getAssertRepairList();
	public AssertRepair getAssertRepair(Integer repairId);
}
