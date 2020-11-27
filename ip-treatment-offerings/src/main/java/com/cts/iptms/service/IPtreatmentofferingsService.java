package com.cts.iptms.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.iptms.exception.InvalidTokenException;
import com.cts.iptms.exception.PackageDetailNotFoundException;
import com.cts.iptms.model.AuthResponse;
import com.cts.iptms.model.IPTreatmentPackage;

import com.cts.iptms.model.SpecialistDetail;
import com.cts.iptms.repository.IPtreatmentofferingsPackageDetailRepository;
import com.cts.iptms.repository.IPtreatmentofferingsSpecialistDetail;

@Service
public class IPtreatmentofferingsService {
	private static final Logger LOGGER = LoggerFactory.getLogger(IPtreatmentofferingsService.class);
	@Autowired
	IPtreatmentofferingsPackageDetailRepository iptreatmentofferingsRepository;
	@Autowired
	IPtreatmentofferingsSpecialistDetail iptreatmentofferingsSpecialistDetaiRepository;

	@Autowired
	AuthClient authClient;

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

	public List<IPTreatmentPackage> getIPTreatmentPackages() {
		LOGGER.info("Start");
		List<IPTreatmentPackage> packagedetail = iptreatmentofferingsRepository.findAll();
		LOGGER.info("packagedetail{}:", packagedetail);
		LOGGER.info("End");
		return packagedetail;
	}

	public IPTreatmentPackage getIPTreatmentPackageByAilmentCategoryAndName(String packageName, String category) {
		LOGGER.info("Start");
		IPTreatmentPackage packagedetail = null;
		if (packageName.equalsIgnoreCase("package1"))
			packagedetail = iptreatmentofferingsRepository.findByName("Package 1", category);
		else
			packagedetail = iptreatmentofferingsRepository.findByName("Package 2", category);
		
		
		
		if (packagedetail == null) {
			throw new PackageDetailNotFoundException(packageName);
		}

		LOGGER.info("packagedetail{}:", packagedetail);
		LOGGER.info("End");
		return packagedetail;
	}

	public List<SpecialistDetail> getSpecialists() {
		LOGGER.info("Start");
		List<SpecialistDetail> specialistdetail = iptreatmentofferingsSpecialistDetaiRepository.findAll();
		LOGGER.info("packagedetail{}:", specialistdetail);
		LOGGER.info("End");
		return specialistdetail;
	}

}
