package com.sura.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sura.restapi.models.Solicitud;

public interface SolicitudRepository extends JpaRepository<Solicitud, Integer> {

}
