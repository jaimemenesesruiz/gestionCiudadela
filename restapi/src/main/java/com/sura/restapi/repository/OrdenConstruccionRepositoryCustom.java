package com.sura.restapi.repository;

import java.util.List;

import com.sura.restapi.models.ReportePorTipo;

public interface OrdenConstruccionRepositoryCustom<OrdenConstruccion> {
	public int countAll();
	
	public List<OrdenConstruccion>  list(int id1,int id2);
	public List<OrdenConstruccion> getLast();
	public int getOrdenConstruccionXY(int x,int y);
	public List<OrdenConstruccion> getOrdenConstruccionPorIniciar();
	public List<OrdenConstruccion> getOrdenConstruccionPorFinalizar();
	public List<OrdenConstruccion> getPendiente();
	public List<ReportePorTipo> getEnProgreso();
	public List<ReportePorTipo> getFinalizado();
}
