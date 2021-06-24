/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sura.restapi.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author to
 */
@Entity
@Table(name = "existencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Existencia.findAll", query = "SELECT e FROM Existencia e")
    , @NamedQuery(name = "Existencia.findByIdExistencia", query = "SELECT e FROM Existencia e WHERE e.idExistencia = :idExistencia")
    , @NamedQuery(name = "Existencia.findByCantidad", query = "SELECT e FROM Existencia e WHERE e.cantidad = :cantidad")})
public class Existencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_EXISTENCIA")
    private Integer idExistencia;
    @Column(name = "CANTIDAD")
    private  Integer cantidad;
    @Column(name = "ID_MATERIAL")
    private Integer idMaterial;

    public Existencia() {
    }

    public Existencia(Integer idExistencia) {
        this.idExistencia = idExistencia;
    }

    public Integer getIdExistencia() {
        return idExistencia;
    }

    public void setIdExistencia(Integer idExistencia) {
        this.idExistencia = idExistencia;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Integer idMaterial) {
        this.idMaterial = idMaterial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExistencia != null ? idExistencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Existencia)) {
            return false;
        }
        Existencia other = (Existencia) object;
        if ((this.idExistencia == null && other.idExistencia != null) || (this.idExistencia != null && !this.idExistencia.equals(other.idExistencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sura.restapi.models.Existencia[ idExistencia=" + idExistencia + " ]";
    }
    
}
