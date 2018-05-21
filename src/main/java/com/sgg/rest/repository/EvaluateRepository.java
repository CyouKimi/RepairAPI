package com.sgg.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.sgg.rest.model.Evaluate;

public interface EvaluateRepository extends JpaRepository<Evaluate, Integer>,JpaSpecificationExecutor<Evaluate>{
	@Query("select e from Evaluate e where e.repair.id=?1")
	public Evaluate getEvaluateByRepairId(Integer repairId);
}
