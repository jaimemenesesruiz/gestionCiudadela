package com.sura.restapi.service;

import com.sura.restapi.models.*;
import com.sura.restapi.repository.ConstruccionMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ConstruccionMaterialService {
    @Autowired
    private ConstruccionMaterialRepository construccionMaterialRepository;
    public List<ConstruccionMaterial> listAllConstruccionMaterial() {
        return construccionMaterialRepository.findAll();
    }

    public void saveConstruccionMaterial(ConstruccionMaterial ConstruccionMaterial) {
        construccionMaterialRepository.save(ConstruccionMaterial);
    }

    public ConstruccionMaterial getConstruccionMaterial(Integer id) {
        return construccionMaterialRepository.findById(id).get();
    }

    public void deleteConstruccionMaterial(Integer id) {
        construccionMaterialRepository.deleteById(id);
    }
    public List<ConstruccionMaterial> getByIdConstruccion(Integer id){
        return construccionMaterialRepository.getByIdConstruccion(id);
    }
}
