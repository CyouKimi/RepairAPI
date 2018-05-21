package com.sgg.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sgg.rest.model.Repair;

public interface RepairRepository extends JpaRepository<Repair, Integer>,JpaSpecificationExecutor<Repair>{
	Long countByArea(Integer repair_status);
	
	@Query(" select count(r) from Repair r where repair_status = :repairStatus")
    Integer countByRepairStatus(@Param("repairStatus") Integer repairStatus);
}
