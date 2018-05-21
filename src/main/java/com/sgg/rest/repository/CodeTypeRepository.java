package com.sgg.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sgg.rest.model.CodeType;

public interface CodeTypeRepository extends JpaRepository<CodeType, Integer>,JpaSpecificationExecutor<CodeType> {

}
