package com.devsuperior.dsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.service.SalesService;

@RestController /* defindo que essa classe será o controlador */
@RequestMapping(value = "/sales") /* nomeando pagina */
public class SaleController {

	@Autowired /* auto instanciar */
	private SalesService service;

	@GetMapping /* método que vai buscar a informação config para resposta via http */
	public Page<Sale> findSales(
			@RequestParam(value="minDate", defaultValue="")  String minDate, 
			@RequestParam (value="maxDate", defaultValue="")String maxDate, 
			Pageable pageable) {
		return service.findSales(minDate,maxDate, pageable);
	}
}