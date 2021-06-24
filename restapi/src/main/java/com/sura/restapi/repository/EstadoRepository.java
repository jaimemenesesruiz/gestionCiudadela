package com.sura.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sura.restapi.models.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Integer>,EstadoRepositoryCustom<Estado> {
	public Estado getByCodigo(String codigo);
}
