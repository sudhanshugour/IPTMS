package com.cts.iptms.model;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "initiate_claim")
public class InitiateClaim {

	@Id
	private long id;
	private String specialist;
	private String treatmentCommencementDate;
	private String treatmentEndDate;
	private String patientName;
	private String patientStatus;
	private String ailment;
	private String treatmentPackageName;
	private String testDetail;
	private String insurerName;
	private String insurerPackageName;
	private int insuranceAmountLimit;
	private int disbursementDuration;
	private int treatmentEndDateCost;
	private int treatmentDurationinWeeks;
	private int age;
	private int finalCost;

}
