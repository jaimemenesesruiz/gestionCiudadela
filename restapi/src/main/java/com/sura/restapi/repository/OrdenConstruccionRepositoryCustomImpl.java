package com.sura.restapi.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.sura.restapi.models.OrdenConstruccion;
import com.sura.restapi.models.ReportePorTipo;

public class OrdenConstruccionRepositoryCustomImpl implements OrdenConstruccionRepositoryCustom<OrdenConstruccion> {
	  @PersistenceContext
	    private EntityManager entityManager;
	@Override
	public int countAll() {
		String hql = "SELECT e FROM OrdenConstruccion e ";
        TypedQuery<OrdenConstruccion> query = entityManager.createQuery(hql, OrdenConstruccion.class)
        		.setMaxResults(1);       
        return query.getResultList().size();

	}
	@Override
	public List<OrdenConstruccion> list(int id1, int id2) {
		String hql = "SELECT e FROM OrdenConstruccion e where e.idOrdenConstruccion= (select max(oc.idOrdenContruccion) from OrdenConstruccion oc))";
        TypedQuery<OrdenConstruccion> query = entityManager.createQuery(hql, OrdenConstruccion.class)
        		.setMaxResults(1);       
        return query.getResultList();
	}
	@Override
	public List<OrdenConstruccion> getLast() {
		String hql = "SELECT e FROM OrdenConstruccion e where e.idOrdenConstruccion= (select max(oc.idOrdenConstruccion) from OrdenConstruccion oc)";
        TypedQuery<OrdenConstruccion> query = entityManager.createQuery(hql, OrdenConstruccion.class)
        		.setMaxResults(1);       
        return query.getResultList();
	}
	@Override
	public int getOrdenConstruccionXY(int x, int y) {
		String hql = "SELECT e FROM OrdenConstruccion e where e.idEstado in(select es.idEstado from Estado es where es.codigo  in ('pr','fi','en')) and exists (select oc.idSolicitud from OrdenConstruccion oc inner join Solicitud s on oc.idSolicitud=s.idSolicitud where s.x=:x and s.y=:y and e.idSolicitud=s.idSolicitud)";
        TypedQuery<OrdenConstruccion> query = entityManager.createQuery(hql, OrdenConstruccion.class);
        query.setParameter("x",x); 
        query.setParameter("y",y); 
        		query.setMaxResults(1);       
        return query.getResultList().size();
	}
	@Override
	public List<OrdenConstruccion> getOrdenConstruccionPorIniciar() {
		Date fecha=new Date();
		String hql = "SELECT e FROM OrdenConstruccion e where e.idEstado in(select es.idEstado from Estado es where es.codigo  ='pe') and e.fechaInicio <= :fecha";
		TypedQuery<OrdenConstruccion> query = entityManager.createQuery(hql, OrdenConstruccion.class);
		query.setParameter("fecha", fecha);
		return  query.getResultList();
	}
	@Override
	public List<OrdenConstruccion> getOrdenConstruccionPorFinalizar() {
		Date fecha=new Date();
		String hql = "SELECT e FROM OrdenConstruccion e where e.idEstado in(select es.idEstado from Estado es where es.codigo  ='en') and e.fechaFin <= :fecha";
		TypedQuery<OrdenConstruccion> query = entityManager.createQuery(hql, OrdenConstruccion.class);
		query.setParameter("fecha", fecha);
		return  query.getResultList();
	}
	@Override
	public List<OrdenConstruccion> getPendiente() {
		String hql = "SELECT e FROM OrdenConstruccion e where e.idEstado in(select es.idEstado from Estado es where es.codigo  ='pe') ";
		TypedQuery<OrdenConstruccion> query = entityManager.createQuery(hql, OrdenConstruccion.class);
		return  query.getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ReportePorTipo> getEnProgreso() {
		String queryStringBaseAll = "SELECT COUNT(oc.id_Solicitud) AS cantidad,e.DESCRIPCION as estado,c.descripcion as tipo FROM orden_Construccion oc INNER JOIN solicitud s ON s.id_Solicitud=oc.id_Solicitud  inner join construccion c on c.id_construccion=s.id_construccion inner join estado e on e.id_estado=oc.id_estado where e.CODIGO='en' GROUP BY s.id_Construccion";
		List<ReportePorTipo> listEntradas = null;
		try {
			listEntradas = entityManager.createNativeQuery(queryStringBaseAll, ReportePorTipo.class).getResultList();
		} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("error()");
		}

		if (listEntradas == null) {
			listEntradas = new ArrayList<ReportePorTipo>();
		}
		 return listEntradas ;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ReportePorTipo> getFinalizado() {
		String queryStringBaseAll = "SELECT COUNT(oc.id_Solicitud) AS cantidad,e.DESCRIPCION as estado,c.descripcion as tipo FROM orden_Construccion oc INNER JOIN solicitud s ON s.id_Solicitud=oc.id_Solicitud  inner join construccion c on c.id_construccion=s.id_construccion inner join estado e on e.id_estado=oc.id_estado where e.CODIGO='fi' GROUP BY s.id_Construccion";
		List<ReportePorTipo> listEntradas = null;
		try {
			listEntradas = (List<ReportePorTipo>)(entityManager.createNativeQuery(queryStringBaseAll, ReportePorTipo.class).getResultList());
		} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("error()");
		}

		if (listEntradas == null) {
			listEntradas = new ArrayList<ReportePorTipo>();
		}
		 return listEntradas ;

	}

}
