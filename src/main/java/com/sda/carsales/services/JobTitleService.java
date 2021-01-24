package com.sda.carsales.services;

import java.util.List;
import java.util.Optional;

import com.sda.carsales.models.JobTitle;
import com.sda.carsales.repositories.JobTitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobTitleService {
	@Autowired
	private JobTitleRepository jobTitleRepository;
	
	//Return list of countries
	public List<JobTitle> getJobTitles(){
		return jobTitleRepository.findAll();
	}
	
	//Save new JobTitle
	public void save(JobTitle jobTitle) {
		jobTitleRepository.save(jobTitle);
	}
	
	//Get by id
	public Optional<JobTitle> findById(int id) {
		return jobTitleRepository.findById(id);
	}

	public void delete(Integer id) {
		jobTitleRepository.deleteById(id);
	}

}
