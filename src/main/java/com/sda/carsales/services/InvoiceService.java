package com.sda.carsales.services;

import java.util.List;
import java.util.Optional;

import com.sda.carsales.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sda.carsales.models.Invoice;

@Service
public class InvoiceService {
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	//Return list of invoices
	public List<Invoice> getInvoices(){
		return invoiceRepository.findAll();
	}
	
	//Save new invoice
	public void save(Invoice invoice) {
		invoiceRepository.save(invoice);
	}
	
	//Get by id
	public Optional<Invoice> findById(int id) {
		return invoiceRepository.findById(id);
	}

	public void delete(Integer id) {
		invoiceRepository.deleteById(id);
	}

}
