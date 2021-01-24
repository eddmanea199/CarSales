package com.sda.carsales.services;

import java.util.List;
import java.util.Optional;

import com.sda.carsales.repositories.InvoiceStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sda.carsales.models.InvoiceStatus;

@Service
public class InvoiceStatusService {
	@Autowired
	private InvoiceStatusRepository invoiceStatusRepository;
	
	//Return list of countries
	public List<InvoiceStatus> getInvoiceStatuses(){
		return invoiceStatusRepository.findAll();
	}
	
	//Save new InvoiceStatus
	public void save(InvoiceStatus invoiceStatus) {
		invoiceStatusRepository.save(invoiceStatus);
	}
	
	//Get by id
	public Optional<InvoiceStatus> findById(int id) {
		return invoiceStatusRepository.findById(id);
	}

	public void delete(Integer id) {
		invoiceStatusRepository.deleteById(id);
	}

}
