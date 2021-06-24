package com.sura.restapi.service;

import com.sura.restapi.models.*;
import com.sura.restapi.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class EstadoService {
    @Autowired
    private EstadoRepository estadoRepository;
    public List<Estado> listAllEstado() {
        return estadoRepository.findAll();
    }

    public void saveEstado(Estado Estado) {
        estadoRepository.save(Estado);
    }

    public Estado getEstado(Integer id) {
        return estadoRepository.findById(id).get();
    }

    public void deleteEstado(Integer id) {
        estadoRepository.deleteById(id);
    }
    public Estado getByIdCodigo(String codigo) {
    	 return estadoRepository.getByCodigo(codigo);
    }
}
