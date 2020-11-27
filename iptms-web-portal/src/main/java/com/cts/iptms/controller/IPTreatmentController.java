package com.cts.iptms.controller;

import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cts.iptms.client.AuthClient;
import com.cts.iptms.client.ICClient;
import com.cts.iptms.client.IPTFClient;
import com.cts.iptms.client.IPTOFClient;
import com.cts.iptms.model.IPTreatmentPackage;
import com.cts.iptms.model.InitiateClaim;
import com.cts.iptms.model.InsurerDetail;
import com.cts.iptms.model.PatientDetail;
import com.cts.iptms.model.TreatmentPlan;
import com.cts.iptms.model.UserHospital;
import com.cts.iptms.model.UserLoginCredential;

import lombok.extern.slf4j.Slf4j;



@Controller
@Slf4j
public class IPTreatmentController {
	
	
	@Autowired
	AuthClient authClient;
	
	@Autowired
	IPTFClient iPTFClient;
	
	@Autowired
	IPTOFClient iPTFOClient;
	
	@Autowired
	ICClient iCClient;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(IPTreatmentController.class);

	
	@PostMapping(value = "/register")
	public ModelAndView getRegister(@RequestParam("pId") String id,@RequestParam("cost") int cost, @RequestParam("pName") String pack, @RequestParam("aName") String ailment) {
		ModelAndView mAV = new ModelAndView("registration");
		mAV.addObject("pack", pack);
		mAV.addObject("ailment", ailment);
		mAV.addObject("cost", cost);
		return mAV;
	}
	
	@GetMapping(value = "/")
	public ModelAndView getLoginPage() {
		
		return new ModelAndView("login");
	}
	
	@PostMapping(value = "/login")
	public ModelAndView getLogin(@ModelAttribute("user") UserHospital user, HttpServletRequest request) {
		UserHospital userHospital = null;
		
		try {
			LinkedHashMap<String, String> map = (LinkedHashMap<String, String>)authClient.login(user).getBody();
			userHospital = new UserHospital(map.get("userid"), map.get("upassword"), map.get("uname"), map.get("authToken"));
		
		} catch (Exception e) {
			return new ModelAndView("redirect:/");
		}
		request.getSession().setAttribute("token", "Bearer " +userHospital.getAuthToken());
		request.getSession().setAttribute("name", userHospital.getUserid());
		return getIPTreatmentPackages(request);
	}
	
	@PostMapping(value = "/registerSubmit")
	public ModelAndView registerPatient(@RequestParam("name") String name,@RequestParam("age") int age, @RequestParam("ailment") String ailment,
			@RequestParam("treatmentPackageName") String pkg, @RequestParam("cost") int cost,
			HttpServletRequest request) {
		PatientDetail patient = new PatientDetail(0, name, age, ailment, pkg, null);
		
				
		if(patient.getTreatmentPackageName().equalsIgnoreCase("Package 1"))
			patient.setTreatmentPackageName("package1");
		else if(patient.getTreatmentPackageName().equalsIgnoreCase("Package 2"))
			patient.setTreatmentPackageName("package2");
		String token = (String) request.getSession().getAttribute("token");
		TreatmentPlan tp = iPTFClient.formulateTreatmentTimetable(token,patient, cost);
		System.out.println(tp);
		ModelAndView mAV = new ModelAndView("treatplan");
		mAV.addObject("plan", tp);
		return mAV;
	}
	
	
	@RequestMapping(path = "/IPTreatmentPackages", method = RequestMethod.GET)
	public ModelAndView getIPTreatmentPackages(HttpServletRequest request) {
		String token = (String) request.getSession().getAttribute("token");
		String name = (String) request.getSession().getAttribute("name");
		if (token !=null) {
			List<IPTreatmentPackage> pckgresponse = (List<IPTreatmentPackage>)iPTFOClient.getIPTreatmentPackages(token).getBody();
			
			ModelAndView modelandview = new ModelAndView("packages");
			modelandview.addObject("plist", pckgresponse);
			modelandview.addObject("name", name);
			return modelandview;
		} else {
			return new ModelAndView("redirect:/");
		}
}
	
	@GetMapping(value = "/demo")
	public ModelAndView getDemo() {
		return new ModelAndView("base");
	}
	
	@GetMapping(value = "/packages")
	public ModelAndView getPackages() {
		return new ModelAndView("packages");
	}
	
	@GetMapping(value = "/insurer")
	public ModelAndView getInsurer() {
		return new ModelAndView("insurer");
	}
	
	@GetMapping(value = "/patients")
	public ModelAndView getPatients(HttpServletRequest request) {
		String token = (String) request.getSession().getAttribute("token");
		String name = (String) request.getSession().getAttribute("name");
		if(token != null) {
			List<TreatmentPlan> tlist = iPTFClient.getAllPatients(token);
			ModelAndView mAV = new ModelAndView("patients");
			mAV.addObject("tlist", tlist);
			return mAV;
		}
		else
			return new ModelAndView("redirect:/");
	}
	
	@GetMapping(value = "/claimInsurance")
	public ModelAndView claimInsurance(@RequestParam("id") int ptId, HttpServletRequest request) {
		LOGGER.debug("start");
		String token = (String) request.getSession().getAttribute("token");
		String name = (String) request.getSession().getAttribute("name");
		if(token != null) {
			ModelAndView mAV = new ModelAndView("claim");
			List<InsurerDetail> insurers = iCClient.getAllInsurerDetail(token);
			mAV.addObject("ptId", ptId);
			mAV.addObject("insurers", insurers);
			return mAV;
		}
		else
			return new ModelAndView("redirect:/");
	}
	
	
	@PostMapping(value="/initiateClaim")
	public ModelAndView initiateClaim(@RequestParam long ptId, @RequestParam int insId ,HttpServletRequest request) {
		LOGGER.debug("start");
		String token = (String) request.getSession().getAttribute("token");
		String name = (String) request.getSession().getAttribute("name");
		if(token != null) {
			InsurerDetail ins = iCClient.getInsurerDetail(token, insId);
			PatientDetail pt = iPTFClient.getPatient(ptId, token);
			TreatmentPlan tp =  iPTFClient.getAPlan(ptId, token);
			System.out.println(pt);
			System.out.println(tp);
			System.out.println(tp.getTreatmentCommencementDate());
			System.out.println(pt.getId()+" "+ tp.getSpecialist()+" "+ tp.getTreatmentCommencementDate()+" "+ tp.getTreatmentEndDate()+ " "+ pt.getName() +" "+ tp.getStatus()+" "+ pt.getAilment()+" "+ tp.getPackageName()+ " "+ tp.getTestDetails()+" "+ ins.getInsurerName()+ " "+ ins.getInsurerPackageName()+" "+ ins.getInsuranceAmountLimit()+" "+ ins.getDisbursementDuration()+" "+ tp.getCost() +" "+6+" "+ pt.getAge()+" "+ 0);
			InitiateClaim ic = new InitiateClaim(1, tp.getSpecialist(), tp.getTreatmentCommencementDate(), tp.getTreatmentEndDate(), pt.getName(), tp.getStatus(), pt.getAilment(), tp.getPackageName(), tp.getTestDetails(), ins.getInsurerName(), ins.getInsurerPackageName(), ins.getInsuranceAmountLimit(), ins.getDisbursementDuration(), tp.getCost() ,6, pt.getAge(), 0);
			int amt = iCClient.initiateClaim(token, ic);
			iPTFClient.updatePlan(token, ptId);
			ModelAndView mAV = new ModelAndView("final");
			mAV.addObject("Outstanding", amt);
			mAV.addObject("InsurAmt",ins.getInsuranceAmountLimit());
			mAV.addObject("total", tp.getCost() );
			LOGGER.debug("End");

			return  mAV;
		}
		else
			return new ModelAndView("redirect:/");
			
	}

	
	@GetMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest request) {
		request.getSession().invalidate();
		//new ModelAndView("login")
		return new ModelAndView("redirect:/");
	}
	
	
}
