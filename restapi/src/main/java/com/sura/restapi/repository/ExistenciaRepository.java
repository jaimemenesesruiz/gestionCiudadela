package com.sura.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sura.restapi.models.Existencia;

public interface ExistenciaRepository extends JpaRepository<Existencia, Integer>,ExistenciaRepositoryCustom<Existencia> {
	public List<Existencia>getByIdMaterial(Integer id);
}
