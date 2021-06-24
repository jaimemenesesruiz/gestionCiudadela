package com.sura.restapi.service;

import com.sura.restapi.models.*;
import com.sura.restapi.repository.ConstruccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ConstruccionService {
    @Autowired
    private ConstruccionRepository construccionRepository;
    public List<Construccion> listAllConstruccion() {
        return construccionRepository.findAll();
    }

    public void saveConstruccion(Construccion Construccion) {
        construccionRepository.save(Construccion);
    }

    public Construccion getConstruccion(Integer id) {
        return construccionRepository.findById(id).get();
    }

    public void deleteConstruccion(Integer id) {
        construccionRepository.deleteById(id);
    }
}
