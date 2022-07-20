package com.devsuperior.dsmeta.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
@Service
public class SalesService {
	
	@Autowired
	private SaleRepository repository ; /*instancia auto..*/
	
	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault()) ; /*metodo para capturar hora atual do sistema*/
		LocalDate max ; 
		LocalDate min ; 
//		LocalDate min =LocalDate.parse(minDate);
//		LocalDate max =LocalDate.parse(maxDate);
        if(maxDate.equals("")) {
        	max = today ; 
        }else {
        	max = LocalDate.parse(maxDate); 
        }
        
        if(minDate.equals("")) {
        	min = today.minusYears(1) ; 
        }else {
        	min = LocalDate.parse(minDate);
        }
        
		
		return repository.findSales(min, max, pageable) ; 
	}
 
	
	
}
 