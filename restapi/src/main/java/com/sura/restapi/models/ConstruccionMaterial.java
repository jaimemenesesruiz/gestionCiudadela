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
@Table(name = "construccion_material")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConstruccionMaterial.findAll", query = "SELECT c FROM ConstruccionMaterial c")
    , @NamedQuery(name = "ConstruccionMaterial.findByIdConstruccionMaterial", query = "SELECT c FROM ConstruccionMaterial c WHERE c.idConstruccionMaterial = :idConstruccionMaterial")
    , @NamedQuery(name = "ConstruccionMaterial.findByCantidad", query = "SELECT c FROM ConstruccionMaterial c WHERE c.cantidad = :cantidad")})
public class ConstruccionMaterial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CONSTRUCCION_MATERIAL")
    private Integer idConstruccionMaterial;
    @Column(name = "CANTIDAD")
    private Integer cantidad;
    @Column(name = "ID_MATERIAL")
    private Integer idMaterial;
    @Column(name = "ID_CONSTRUCCION")
    private Integer idConstruccion;

    public ConstruccionMaterial() {
    }

    public ConstruccionMaterial(Integer idConstruccionMaterial) {
        this.idConstruccionMaterial = idConstruccionMaterial;
    }

    public Integer getIdConstruccionMaterial() {
        return idConstruccionMaterial;
    }

    public void setIdConstruccionMaterial(Integer idConstruccionMaterial) {
        this.idConstruccionMaterial = idConstruccionMaterial;
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

    public Integer getIdConstruccion() {
        return idConstruccion;
    }

    public void setIdConstruccion(Integer idConstruccion) {
        this.idConstruccion = idConstruccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConstruccionMaterial != null ? idConstruccionMaterial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConstruccionMaterial)) {
            return false;
        }
        ConstruccionMaterial other = (ConstruccionMaterial) object;
        if ((this.idConstruccionMaterial == null && other.idConstruccionMaterial != null) || (this.idConstruccionMaterial != null && !this.idConstruccionMaterial.equals(other.idConstruccionMaterial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sura.restapi.models.ConstruccionMaterial[ idMaterialConstruccion=" + idConstruccionMaterial + " ]";
    }
    
}
