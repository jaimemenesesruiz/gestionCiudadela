package com.sura.restapi.service;

import com.sura.restapi.models.*;
import com.sura.restapi.repository.ExistenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ExistenciaService {
    @Autowired
    private ExistenciaRepository existenciaRepository;
    public List<Existencia> listAllExistencia() {
        return existenciaRepository.findAll();
    }

    public void saveExistencia(Existencia Existencia) {
        existenciaRepository.save(Existencia);
    }

    public Existencia getExistencia(Integer id) {
        return existenciaRepository.findById(id).get();
    }

    public void deleteExistencia(Integer id) {
        existenciaRepository.deleteById(id);
    }
    
    public List<Existencia> getByIdMaterial(Integer id)
    {
        return existenciaRepository.getByIdMaterial(id);
    }
}
