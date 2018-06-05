package com.sgg.rest.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sgg.rest.model.Material;

public interface MaterialRepository extends JpaRepository<Material, Integer>,JpaSpecificationExecutor<Material>{
    @Transactional
    Material findByCode(String code);
}
