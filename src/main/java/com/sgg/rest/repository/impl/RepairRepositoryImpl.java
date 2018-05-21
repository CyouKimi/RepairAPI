package com.sgg.rest.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.sgg.rest.model.AssertRepair;
import com.sgg.rest.repository.RepairRepositoryCustom;


public class RepairRepositoryImpl implements RepairRepositoryCustom {
	@Autowired
    @PersistenceContext
    private EntityManager entityManager;
	
    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

	@Override
	public List<AssertRepair> getAssertRepairList() {
	      EntityManager em = emf.createEntityManager();
	      //hql not equal sql
          Query query = em.createQuery("select new com.sgg.rest.model.AssertRepair(id,r.applicationUser.name,area,address,repair_status,content,create_time) "
          		+ "from Repair r where r.applicationUser.name like :name ");
          query.setParameter("name", "%"+""+"%");
          List result = query.getResultList();
      return result;
	}

	@Override
	public AssertRepair getAssertRepair(Integer repairId) {
	      EntityManager em = emf.createEntityManager();
	      //hql not equal sql
        Query query = em.createQuery("select new com.sgg.rest.model.AssertRepair(id,r.applicationUser.name,area,address,repair_status,content,telephone,create_time) "
        		+ "from Repair r where r.id= :id ");
//        query.setParameter("name", "%"+""+"%");
         query.setParameter("id", repairId);
         AssertRepair result = (AssertRepair) query.getSingleResult();
    return result;
	}

}
