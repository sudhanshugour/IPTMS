package com.cts.iptms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SpecialistDetail {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String name;
private String areaOfExpertise;
private int experienceInYear;
private String contactNumber;
}
