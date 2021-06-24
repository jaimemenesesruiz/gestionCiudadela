package com.sura.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sura.restapi.models.ConstruccionMaterial;

public interface ConstruccionMaterialRepository extends JpaRepository<ConstruccionMaterial, Integer>,ConstruccionMaterialRepositoryCustom<ConstruccionMaterial> {
	public List<ConstruccionMaterial>getByIdConstruccion(Integer id);
}
