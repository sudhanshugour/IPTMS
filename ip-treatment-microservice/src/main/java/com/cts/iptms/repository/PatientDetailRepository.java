package com.cts.iptms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.iptms.model.PatientDetail;

public interface PatientDetailRepository extends JpaRepository<PatientDetail, Long>{
	
	@Query("Select p from PatientDetail p where p.id =?1")
	PatientDetail getPatientById(long id);
}
