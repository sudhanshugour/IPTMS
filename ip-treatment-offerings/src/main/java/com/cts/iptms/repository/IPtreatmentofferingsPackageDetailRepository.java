package com.cts.iptms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.iptms.model.IPTreatmentPackage;



@Repository
public interface IPtreatmentofferingsPackageDetailRepository extends JpaRepository<IPTreatmentPackage, Long>{

	@Query(value=" from IPTreatmentPackage p where p.packageDetail.treatmentPackageName=:packageName and p.ailmentCategory=:category")
	IPTreatmentPackage findByName(@Param("packageName") String packageName, String category);
}
