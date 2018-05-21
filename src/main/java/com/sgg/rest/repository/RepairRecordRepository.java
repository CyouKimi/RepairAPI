package com.sgg.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sgg.rest.model.RepairRecord;

public interface RepairRecordRepository extends JpaRepository<RepairRecord, Integer>,JpaSpecificationExecutor<RepairRecord>{

}
