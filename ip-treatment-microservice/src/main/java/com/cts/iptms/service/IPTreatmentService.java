package com.cts.iptms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.iptms.model.PatientDetail;
import com.cts.iptms.model.TreatmentPlan;

@Service
public interface IPTreatmentService {
	
	TreatmentPlan getTreatmentPlan(PatientDetail patientDetail , int cost);
	
	List<TreatmentPlan> getAllPlans();
	
	PatientDetail getPatient(long ptId);
	
	TreatmentPlan getPlan(long ptId);
	
	void updatePlan(long pId);
	}
