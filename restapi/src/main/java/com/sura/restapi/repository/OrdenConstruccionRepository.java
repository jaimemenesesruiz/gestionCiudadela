package com.sura.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sura.restapi.models.OrdenConstruccion;

public interface OrdenConstruccionRepository extends JpaRepository<OrdenConstruccion, Integer> ,OrdenConstruccionRepositoryCustom<OrdenConstruccion>{

}
