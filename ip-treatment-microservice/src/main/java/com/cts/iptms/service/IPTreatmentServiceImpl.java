package com.cts.iptms.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.iptms.client.AuthClient;
import com.cts.iptms.exception.InvalidTokenException;
import com.cts.iptms.model.AuthResponse;
import com.cts.iptms.model.PatientDetail;
import com.cts.iptms.model.TreatmentPlan;
import com.cts.iptms.repository.PatientDetailRepository;
import com.cts.iptms.repository.TreatmentPlanRepository;

@Service
public class IPTreatmentServiceImpl implements IPTreatmentService {

	@Autowired
	PatientDetailRepository patientdetailRepository;

	@Autowired
	AuthClient authClient;

	@Autowired
	TreatmentPlanRepository tPRepo;

	public AuthResponse validateToken(String token) {

		AuthResponse authResponse = null;
		try {
			authResponse = authClient.getValidity(token);
			if (!authResponse.isValid()) {
				throw new InvalidTokenException();
			}
		} catch (Exception e) {
			throw new InvalidTokenException();
		}

		return authResponse;
	}

	@Override
	public TreatmentPlan getTreatmentPlan(PatientDetail patientDetail, int cost) {

		Calendar now = Calendar.getInstance();
		String cDate = reviewDateAndMonth(now.get(Calendar.DATE)) + "/"
				+ reviewDateAndMonth(now.get(Calendar.MONTH) + 1) + "/" + now.get(Calendar.YEAR);

		patientDetail.setTreatmentCommencementDate(cDate);
		
		patientdetailRepository.save(patientDetail);

		
		String specialist = "None";
		if (patientDetail.getTreatmentPackageName().equalsIgnoreCase("package1")) {
			specialist = "Senior Specialist";
			now.add(Calendar.WEEK_OF_YEAR, 6);
		} else if (patientDetail.getTreatmentPackageName().equalsIgnoreCase("package2")) {
			specialist = "Junior Specialist";
			now.add(Calendar.WEEK_OF_YEAR, 4);
		}

		String eDate = reviewDateAndMonth(now.get(Calendar.DATE)) + "/"
				+ reviewDateAndMonth(now.get(Calendar.MONTH) + 1) + "/" + now.get(Calendar.YEAR);
		
		TreatmentPlan plan = new TreatmentPlan(0, patientDetail, "Test1 , Test2", patientDetail.getTreatmentPackageName(), specialist,
				cost, "In progress", cDate, eDate);
		
		tPRepo.save(plan);
		return plan;
	}

	public String reviewDateAndMonth(int dateOrMonth) {
		if (dateOrMonth < 10)
			return "0" + Integer.toString(dateOrMonth);
		else
			return Integer.toString(dateOrMonth);
	}

	@Override
	public List<TreatmentPlan> getAllPlans() {

		return tPRepo.getAllplans();
	}

	@Override
	public PatientDetail getPatient(long ptId) {

		return patientdetailRepository.getPatientById(ptId);
	}

	@Override
	public TreatmentPlan getPlan(long ptId) {

		return tPRepo.getPlanUser(ptId);
	}

	@Override
	public void updatePlan(long pId) {

		TreatmentPlan tp = tPRepo.getPlanUser(pId);
		tp.setStatus("Completed");
		tPRepo.save(tp);
	}

}
