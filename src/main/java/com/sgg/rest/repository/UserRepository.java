package com.sgg.rest.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sgg.rest.model.ApplicationUser;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface UserRepository extends JpaRepository<ApplicationUser, Integer>,JpaSpecificationExecutor<ApplicationUser>  {

    Long countByName(String name);

    @Transactional
    Long deleteByName(String name);

    @Transactional
    List<ApplicationUser> removeByName(String name);
    
    @Transactional
    ApplicationUser findByName(String name);
    
    @Transactional
    ApplicationUser findBySno(String sno);
    
    @Query(value="select * from application_user", nativeQuery=true )
    public List<ApplicationUser> findallAccounts();
    
    //@Query(value=" select * from application_user where role = :role", nativeQuery=true)
	@Query(" select u from ApplicationUser u where role = :role")
	List<ApplicationUser> findUsersByRole(@Param("role") Integer role);
}
