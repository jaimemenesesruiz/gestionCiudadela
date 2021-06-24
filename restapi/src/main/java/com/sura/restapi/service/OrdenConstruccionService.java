package com.sura.restapi.service;

import com.sura.restapi.models.*;
import com.sura.restapi.repository.OrdenConstruccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OrdenConstruccionService {
    @Autowired
    private OrdenConstruccionRepository ordenConstruccionRepository;
    public List<OrdenConstruccion> listAllOrdenConstruccion() {
        return ordenConstruccionRepository.findAll();
    }

    public void saveOrdenConstruccion(OrdenConstruccion OrdenConstruccion) {
        ordenConstruccionRepository.save(OrdenConstruccion);
    }

    public OrdenConstruccion getOrdenConstruccion(Integer id) {
        return ordenConstruccionRepository.findById(id).get();
    }

    public void deleteOrdenConstruccion(Integer id) {
        ordenConstruccionRepository.deleteById(id);
    }
    public int countAll() {
        return Integer.parseInt( ""+ordenConstruccionRepository.countAll());
    }
    public List<OrdenConstruccion> getLast() {
        return ordenConstruccionRepository.getLast();
    }
    public int getOrdenConstruccionXY(int x, int y) {
        return ordenConstruccionRepository.getOrdenConstruccionXY(x,y);
    }
    public List<OrdenConstruccion> getOrdenConstruccionPorIniciar(){
        return  ordenConstruccionRepository.getOrdenConstruccionPorIniciar();
    }
    public List<OrdenConstruccion> getOrdenConstruccionPorFinalizar(){
        return ordenConstruccionRepository.getOrdenConstruccionPorFinalizar();
    }
    public List<OrdenConstruccion> getPendiente(){
        return ordenConstruccionRepository.getPendiente();
    }
    public List<ReportePorTipo> getEnProgreso(){
        return ordenConstruccionRepository.getEnProgreso();
    }
    public List<ReportePorTipo> getFinalizado(){
        return ordenConstruccionRepository.getFinalizado();
    }
}
