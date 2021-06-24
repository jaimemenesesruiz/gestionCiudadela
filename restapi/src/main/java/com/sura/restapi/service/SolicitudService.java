package com.sura.restapi.service;

import com.sura.restapi.models.*;
import com.sura.restapi.repository.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class SolicitudService {
    @Autowired
    private SolicitudRepository solicitudRepository;
    public List<Solicitud> listAllSolicitud() {
        return solicitudRepository.findAll();
    }

    public void saveSolicitud(Solicitud Solicitud) {
        solicitudRepository.save(Solicitud);
    }

    public Solicitud getSolicitud(Integer id) {
        return solicitudRepository.findById(id).get();
    }

    public void deleteSolicitud(Integer id) {
        solicitudRepository.deleteById(id);
    }
}
