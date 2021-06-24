package com.sura.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sura.restapi.models.Material;

public interface MaterialRepository extends JpaRepository<Material, Integer> {

}
