package com.sgg.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sgg.rest.model.CodeData;

public interface CodeDataRepository extends JpaRepository<CodeData, Integer>,JpaSpecificationExecutor<CodeData> {

}
