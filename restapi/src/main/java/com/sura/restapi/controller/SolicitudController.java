package com.sura.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import com.sura.restapi.models.Construccion;
import com.sura.restapi.models.ConstruccionMaterial;
import com.sura.restapi.models.Estado;
import com.sura.restapi.models.Existencia;
import com.sura.restapi.models.OrdenConstruccion;
import com.sura.restapi.models.Solicitud;
import com.sura.restapi.service.ConstruccionMaterialService;
import com.sura.restapi.service.ConstruccionService;
import com.sura.restapi.service.EstadoService;
import com.sura.restapi.service.ExistenciaService;
import com.sura.restapi.service.OrdenConstruccionService;
import com.sura.restapi.service.SolicitudService;

@RestController
@RequestMapping("/solicitud")
public class SolicitudController {
	@Autowired
	SolicitudService solicitudService;
	@Autowired
	OrdenConstruccionService ordenConstruccionService;
	@Autowired
	ConstruccionService construccionService;
	@Autowired
	ExistenciaService existenciaService;
	@Autowired
	ConstruccionMaterialService construccionMaterialService;
	@Autowired
	EstadoService estadoService;

	@GetMapping("")
	public List<Solicitud> list() {
		return solicitudService.listAllSolicitud();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Solicitud> get(@PathVariable Integer id) {
		try {
			Solicitud Solicitud = solicitudService.getSolicitud(id);
			return new ResponseEntity<Solicitud>(Solicitud, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Solicitud>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/")
	public ResponseEntity<?> add(@RequestHeader(value = "role") String role, @RequestBody Solicitud Solicitud) {
		System.out.println("@PostMapping add");
		System.out.println("role:" + role);

		try {
			if (role == null || !role.equalsIgnoreCase("arquitecto")) {
				System.out.println("role:["+role+"] NO Acpetado");
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}

			System.out.println("role:["+role+"] Acpetado");

			Date fechaBase = null;
			Date fechaInicio = null;
			Date fechaFin = null;
			Boolean alcanzaMaterial = true;
			List<ConstruccionMaterial> ConstruccionMaterialList = null;
			OrdenConstruccion OrdenConstruccionNew = new OrdenConstruccion();
			Construccion construccionNew = new Construccion();
			Calendar c = Calendar.getInstance();

			// buscar solicitudes con coordenada x,y en los 3 estados
			int cantidadOrdenesXY = ordenConstruccionService.getOrdenConstruccionXY(Solicitud.getX(), Solicitud.getY());
			if (cantidadOrdenesXY == 0) {
				construccionNew = construccionService.getConstruccion(Solicitud.getIdConstruccion());
				ConstruccionMaterialList = construccionMaterialService
						.getByIdConstruccion(construccionNew.getIdConstruccion());
				for (ConstruccionMaterial construccionMaterial : ConstruccionMaterialList) {
					Existencia existencia = (existenciaService.getByIdMaterial(construccionMaterial.getIdMaterial()))
							.get(0);
					if ((existencia.getCantidad() - construccionMaterial.getCantidad()) < 0) {
						alcanzaMaterial = false;
						break;
					}
				}
				if (alcanzaMaterial) {
					// inicia el siguiente dia
					fechaBase = Solicitud.getFechaSolicitud();
					int cantidadOrdenes = ordenConstruccionService.countAll();
					if (cantidadOrdenes > 0) {// inicia despues del ultimo
						List<OrdenConstruccion> ordenFinal = ordenConstruccionService.getLast();
						if (ordenFinal.get(0).getFechaFin().compareTo(fechaBase) > 0) {
							fechaBase = ordenFinal.get(0).getFechaFin();
						}
					}
					c.setTime(fechaBase);
					c.add(Calendar.DATE, 1);
					fechaInicio = c.getTime();

					c.setTime(fechaBase);
					c.add(Calendar.DATE, construccionNew.getTiempo());
					fechaFin = c.getTime();

					solicitudService.saveSolicitud(Solicitud);
					System.out.println("Solicitud Creada");
					OrdenConstruccionNew.setIdSolicitud(Solicitud.getIdSolicitud());
					OrdenConstruccionNew.setFechaInicio(fechaInicio);
					OrdenConstruccionNew.setFechaFin(fechaFin);
					Estado estado = estadoService.getByIdCodigo("pe");
					OrdenConstruccionNew.setIdEstado(estado.getIdEstado());
					ordenConstruccionService.saveOrdenConstruccion(OrdenConstruccionNew);
					for (ConstruccionMaterial construccionMaterial : ConstruccionMaterialList) {
						Existencia existencia = (existenciaService
								.getByIdMaterial(construccionMaterial.getIdMaterial())).get(0);
						existencia.setCantidad(existencia.getCantidad() - construccionMaterial.getCantidad());
						existenciaService.saveExistencia(existencia);
					}
				} else {
					System.out.println("Error, No alcanzan los materiales");
					throw new NoSuchElementException();
				}
			} else {
				System.out.println("Error, ya hay construccion en X,Y=>" + Solicitud.getX() + "," + Solicitud.getY());
				throw new NoSuchElementException();
			}

			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Solicitud Solicitud, @PathVariable Integer id) {
		try {
			Solicitud.setIdSolicitud(id);
			solicitudService.saveSolicitud(Solicitud);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {

		solicitudService.deleteSolicitud(id);
	}
}