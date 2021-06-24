package com.sura.restapi.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.sura.restapi.models.Estado;

public class EstadoRepositoryCustomImpl implements EstadoRepositoryCustom<Estado>{
	@PersistenceContext
    private EntityManager entityManager;
	@Override
	public Estado getByCodigo(String codigo) {
		String hql = "SELECT e FROM Estado e where e.codigo= :codigo";
        TypedQuery<Estado> query = entityManager.createQuery(hql, Estado.class);
        query.setParameter("codigo", codigo);
        query.setMaxResults(1);       
        return query.getSingleResult();
	}

}
