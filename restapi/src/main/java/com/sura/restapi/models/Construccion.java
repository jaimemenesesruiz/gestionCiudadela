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
@Table(name = "construccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Construccion.findAll", query = "SELECT c FROM Construccion c")
    , @NamedQuery(name = "Construccion.findByIdConstruccion", query = "SELECT c FROM Construccion c WHERE c.idConstruccion = :idConstruccion")
    , @NamedQuery(name = "Construccion.findByDescripcion", query = "SELECT c FROM Construccion c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "Construccion.findByTiempo", query = "SELECT c FROM Construccion c WHERE c.tiempo = :tiempo")})
public class Construccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CONSTRUCCION")
    private Integer idConstruccion;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "TIEMPO")
    private int tiempo;
    
    public Construccion() {
    }

    public Construccion(Integer idConstruccion) {
        this.idConstruccion = idConstruccion;
    }

    public Construccion(Integer idConstruccion, String descripcion, int tiempo) {
        this.idConstruccion = idConstruccion;
        this.descripcion = descripcion;
        this.tiempo = tiempo;
    }

    public Integer getIdConstruccion() {
        return idConstruccion;
    }

    public void setIdConstruccion(Integer idConstruccion) {
        this.idConstruccion = idConstruccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

       @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConstruccion != null ? idConstruccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Construccion)) {
            return false;
        }
        Construccion other = (Construccion) object;
        if ((this.idConstruccion == null && other.idConstruccion != null) || (this.idConstruccion != null && !this.idConstruccion.equals(other.idConstruccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sura.restapi.models.Construccion[ idConstruccion=" + idConstruccion + " ]";
    }
    
}
