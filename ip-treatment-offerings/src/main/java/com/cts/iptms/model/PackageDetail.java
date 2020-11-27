package com.cts.iptms.model;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class PackageDetail {


private String treatmentPackageName;
private String testDetail;
private int cost;
private int treatmentDurationinWeeks;
}
