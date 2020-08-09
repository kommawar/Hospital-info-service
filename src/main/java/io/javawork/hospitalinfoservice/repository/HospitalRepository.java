package io.javawork.hospitalinfoservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.javawork.hospitalinfoservice.model.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {

	List<Hospital> findByName(String name);
	List<Hospital> findAll();

}
