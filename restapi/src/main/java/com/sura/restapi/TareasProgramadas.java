package com.sura.restapi;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sura.restapi.models.Estado;
import com.sura.restapi.models.OrdenConstruccion;
import com.sura.restapi.service.EstadoService;
import com.sura.restapi.service.OrdenConstruccionService;

@Component
public class TareasProgramadas {
	@Autowired
	OrdenConstruccionService ordenConstruccionService;
	@Autowired
	EstadoService estadoService;
	
	@Scheduled(cron = "0 5 7 * * ?")
	   public void iniciarOrden() {
	      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	      Date now = new Date();
	      String strDate = sdf.format(now);
	      System.out.println("iniciarOrden: " + strDate);
	      Estado estadoNuevo=estadoService.getByIdCodigo("en");
	      List<OrdenConstruccion> ordenConstruccionList=ordenConstruccionService.getOrdenConstruccionPorIniciar();
	      if(ordenConstruccionList!=null) {
	    	  for(OrdenConstruccion ordenConstruccion:ordenConstruccionList) {
	    	  ordenConstruccion.setIdEstado(estadoNuevo.getIdEstado());
	    	  ordenConstruccionService.saveOrdenConstruccion(ordenConstruccion);
	    	  //System.out.println("iniciarOrden : " + strDate);
	    	  }
	      }
	   }
	
	@Scheduled(cron = "0 50 23 * * ?")
	   public void finalizarOrden() {
	      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	      Date now = new Date();
	      String strDate = sdf.format(now);
	      System.out.println("finalizarOrden: " + strDate);
	      Estado estadoNuevo=estadoService.getByIdCodigo("fi");
	      List<OrdenConstruccion> ordenConstruccionList=ordenConstruccionService.getOrdenConstruccionPorFinalizar();
	      if(ordenConstruccionList!=null) {
	    	  for(OrdenConstruccion ordenConstruccion:ordenConstruccionList) {
	    	  ordenConstruccion.setIdEstado(estadoNuevo.getIdEstado());
	    	  ordenConstruccionService.saveOrdenConstruccion(ordenConstruccion);
	    	  //System.out.println("finalizarOrden : " + strDate);
	    	  }
	      }
	   }
}
