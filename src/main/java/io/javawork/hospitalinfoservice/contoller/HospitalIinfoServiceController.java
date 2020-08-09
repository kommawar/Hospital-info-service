package io.javawork.hospitalinfoservice.contoller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.javawork.hospitalinfoservice.model.Hospital;
import io.javawork.hospitalinfoservice.repository.HospitalRepository;

@RestController
public class HospitalIinfoServiceController {
	
	@Autowired
	private HospitalRepository hospitalRepository;

	@GetMapping("hospitals/{hospitalId}")
	public Hospital getHospital(@PathVariable("hospitalId") int hospitalId){
		
		Hospital mayo = new Hospital("Mayo", "Rochester");
		Hospital optum = new Hospital("optum", "Minneapolis");
		Hospital care = new Hospital("Care", "Hyderabad");
		
		if(hospitalId == 1) {
			return mayo;
		}else if(hospitalId == 2) {
			return optum;
		}else {
			return care;
		}

	}
	
	@GetMapping("hospitals")
	public List<Hospital> getHospitals(){
		
//		Hospital mayo = new Hospital(1, "Mayo", "Rochester");
//		Hospital optum = new Hospital(2, "optum", "Minneapolis");
//		Hospital care = new Hospital(3, "Care", "Hyderabad");
//		
//		List<Hospital> hospitals = new ArrayList<Hospital>();
//		hospitals.add(mayo);
//		hospitals.add(optum);
//		hospitals.add(care);
		
		return hospitalRepository.findAll();

	}
	
	@GetMapping("hospitals/bulk-create")
	public List<Hospital> createHospitals(){
		
		Hospital mayo = new Hospital("Mayo", "Rochester");
		Hospital optum = new Hospital("optum", "Minneapolis");
		Hospital care = new Hospital("Care", "Hyderabad");
		
		List<Hospital> hospitals = new ArrayList<Hospital>();
		hospitals.add(mayo);
		hospitals.add(optum);
		hospitals.add(care);
		
		hospitalRepository.saveAll(hospitals);
		
		return hospitals;

	}
	
}
