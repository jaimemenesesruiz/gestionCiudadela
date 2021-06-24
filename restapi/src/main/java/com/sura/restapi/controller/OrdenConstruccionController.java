package com.sura.restapi.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sura.restapi.models.OrdenConstruccion;
import com.sura.restapi.models.ReportePorTipo;
import com.sura.restapi.service.OrdenConstruccionService;
@RestController
@RequestMapping("/ordenConstruccion")
public class OrdenConstruccionController {
	@Autowired
	OrdenConstruccionService ordenConstruccionService;
	@GetMapping("")
	public List<OrdenConstruccion> list() {
		return ordenConstruccionService.listAllOrdenConstruccion();
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrdenConstruccion> get(@PathVariable Integer id) {
		try {
			OrdenConstruccion ordenConstruccion = ordenConstruccionService.getOrdenConstruccion(id);
			return new ResponseEntity<OrdenConstruccion>(ordenConstruccion, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<OrdenConstruccion>(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/final")
	public ResponseEntity<OrdenConstruccion> getLast() {
		List<OrdenConstruccion> ordenConstruccionList=ordenConstruccionService.getLast();
		OrdenConstruccion ordenConstruccion=null;
		try {
			if( ordenConstruccionList!=null && !ordenConstruccionList.isEmpty()) {
				ordenConstruccion=ordenConstruccionList.get(0);
			} 
			return new ResponseEntity<OrdenConstruccion>(ordenConstruccion, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<OrdenConstruccion>(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/pe")
	public ResponseEntity<List<OrdenConstruccion>> getPendiente() {
		List<OrdenConstruccion> ordenConstruccionList=ordenConstruccionService.getPendiente();
		try {
			return new ResponseEntity<List<OrdenConstruccion>>(ordenConstruccionList, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<List<OrdenConstruccion>>(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/en")
	public ResponseEntity<List<ReportePorTipo>> getEnProgreso() {
		List<ReportePorTipo> reportePorTipoList=ordenConstruccionService.getEnProgreso();
		try {
			return new ResponseEntity<List<ReportePorTipo>>(reportePorTipoList, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<List<ReportePorTipo>>(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/fi")
	public ResponseEntity<List<ReportePorTipo>> getFinalizado() {
		List<ReportePorTipo> reportePorTipoList=ordenConstruccionService.getFinalizado();
		try {			 
			return new ResponseEntity<List<ReportePorTipo>>(reportePorTipoList, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<List<ReportePorTipo>>(HttpStatus.NOT_FOUND);
		}
	}
}
