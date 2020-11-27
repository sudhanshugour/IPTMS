package com.cts.iptms.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IPTreatmentPackage {

private long id;
private String ailmentCategory;
PackageDetail packageDetail;
 }