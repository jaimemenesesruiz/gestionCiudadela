package com.sura.restapi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.sura.restapi.models.ConstruccionMaterial;

public class ConstruccionMaterialRepositoryCustomImpl
		implements ConstruccionMaterialRepositoryCustom<ConstruccionMaterial> {
	@PersistenceContext
    private EntityManager entityManager;

	
	@Override
	public List<ConstruccionMaterial> getByIdConstruccion(Integer id) {
		String hql = "SELECT e FROM ConstruccionMaterial e where e.idConstruccion= :id";
	    TypedQuery<ConstruccionMaterial> query = entityManager.createQuery(hql, ConstruccionMaterial.class);
	    query.setParameter("id", id);     
	    return query.getResultList();
	}

}
