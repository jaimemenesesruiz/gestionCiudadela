package com.sura.restapi.service;

import com.sura.restapi.models.*;
import com.sura.restapi.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class MaterialService {
    @Autowired
    private MaterialRepository materialRepository;
    public List<Material> listAllMaterial() {
        return materialRepository.findAll();
    }

    public void saveMaterial(Material Material) {
        materialRepository.save(Material);
    }

    public Material getMaterial(Integer id) {
        return materialRepository.findById(id).get();
    }

    public void deleteMaterial(Integer id) {
        materialRepository.deleteById(id);
    }
}
