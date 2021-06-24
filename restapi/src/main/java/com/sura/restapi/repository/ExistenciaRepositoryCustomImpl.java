package com.sura.restapi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.sura.restapi.models.Existencia;

public class ExistenciaRepositoryCustomImpl implements ExistenciaRepositoryCustom<Existencia> {
	 @PersistenceContext
	    private EntityManager entityManager;
	@Override
	public List<Existencia> getByIdMaterial(Integer id) {
		String hql = "SELECT e FROM Existencia e where e.idMaterial= :id";
        TypedQuery<Existencia> query = entityManager.createQuery(hql, Existencia.class);
        query.setParameter("id", id);
        query.setMaxResults(1);       
        return query.getResultList();
	}

}
