package com.cts.iptms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cts.iptms.model.TreatmentPlan;

public interface TreatmentPlanRepository extends JpaRepository<TreatmentPlan, Long> {
	
	@Query("select t from TreatmentPlan t left join fetch t.ptDetail p where p.id= :id")
	public TreatmentPlan getPlanUser(@Param("id") long id);
	
	
	@Query("select t from TreatmentPlan t where t.status = 'In progress'")
	public List<TreatmentPlan> getAllplans();
	
	
}
