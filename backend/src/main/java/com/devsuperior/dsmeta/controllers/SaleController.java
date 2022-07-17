package com.devsuperior.dsmeta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.service.SalesService;

@RestController /* defindo que essa classe será o controlador */
@RequestMapping(value = "/sales") /* nomeando pagina */
public class SaleController {

	@Autowired /* auto instanciar */
	private SalesService service;

	@GetMapping /* config para resposta via http */
	public List<Sale> findSales() {
		return service.findSales();
	}
}
