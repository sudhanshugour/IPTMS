package com.cts.iptms.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.cts.iptms.exception.InvalidTokenException;
import com.cts.iptms.exception.PackageDetailNotFoundException;
import com.cts.iptms.model.AuthResponse;
import com.cts.iptms.model.IPTreatmentPackage;
import com.cts.iptms.model.SpecialistDetail;
import com.cts.iptms.repository.IPtreatmentofferingsPackageDetailRepository;
import com.cts.iptms.repository.IPtreatmentofferingsSpecialistDetail;

@ExtendWith(MockitoExtension.class)
class IPtreatmentofferingsServiceTest {

	@Mock
	IPtreatmentofferingsPackageDetailRepository iptreatmentofferingsRepository;
	@Mock
	IPtreatmentofferingsSpecialistDetail iptreatmentofferingsSpecialistDetaiRepository;

	@Mock
	AuthClient authClient;
	@InjectMocks
	IPtreatmentofferingsService iPtreatmentofferingsService;

	
	

	@Test
	void testValidateToken() {
		when( authClient.getValidity("token")).thenReturn(new AuthResponse("sud", "name", true));
		assertEquals( "name",iPtreatmentofferingsService.validateToken("token").getName());
		
		
	}
	
	@Test
	void testValidateTokenWithInvalidToken() {
		when( authClient.getValidity("token")).thenReturn(new AuthResponse("sud", "name", false));

		assertThrows( InvalidTokenException.class, ()->iPtreatmentofferingsService.validateToken("token"));
	}
	@Test
	void testValidateTokenThrowsException() {
		when( authClient.getValidity("token")).thenThrow(RuntimeException.class);
		assertThrows( InvalidTokenException.class, ()->iPtreatmentofferingsService.validateToken("token"));
	}
	
	

	@Test
	void testGetIPTreatmentPackages() {
	List<IPTreatmentPackage> ipTreatmentPackages = new ArrayList<IPTreatmentPackage>();
		when( iptreatmentofferingsRepository.findAll()).thenReturn(ipTreatmentPackages);
		
		assertEquals( ipTreatmentPackages,iPtreatmentofferingsService.getIPTreatmentPackages());
		
	}

	@Test
	void testGetIPTreatmentPackageByAilmentCategoryAndName() {
		IPTreatmentPackage iPTreatmentPackage1 = new IPTreatmentPackage();
		IPTreatmentPackage iPTreatmentPackage2 = new IPTreatmentPackage();
	
		when(iptreatmentofferingsRepository.findByName("Package 1", "c1")).thenReturn(iPTreatmentPackage1);
		when(iptreatmentofferingsRepository.findByName("Package 2", "c2")).thenReturn(iPTreatmentPackage2);
		when(iptreatmentofferingsRepository.findByName("Package 2", "c3")).thenReturn(null);
		assertEquals(iPTreatmentPackage1, iPtreatmentofferingsService.getIPTreatmentPackageByAilmentCategoryAndName("package1", "c1"));
	assertEquals(iPTreatmentPackage2, iPtreatmentofferingsService.getIPTreatmentPackageByAilmentCategoryAndName("package2", "c2"));

		assertThrows(PackageDetailNotFoundException.class, ()-> iPtreatmentofferingsService.getIPTreatmentPackageByAilmentCategoryAndName("package2", "c3"));
	}

	@Test
	void testGetSpecialists() {
		List<SpecialistDetail> specialistDetails = new ArrayList<SpecialistDetail>();
	when( iptreatmentofferingsSpecialistDetaiRepository.findAll()).thenReturn(specialistDetails);
		
		assertEquals( specialistDetails,iPtreatmentofferingsService.getSpecialists());
	
	}

}
