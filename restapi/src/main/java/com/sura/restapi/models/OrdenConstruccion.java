/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sura.restapi.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author to
 */
@Entity
@Table(name = "orden_construccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenConstruccion.findAll", query = "SELECT o FROM OrdenConstruccion o")
    , @NamedQuery(name = "OrdenConstruccion.findByIdOrdenConstruccion", query = "SELECT o FROM OrdenConstruccion o WHERE o.idOrdenConstruccion = :idOrdenConstruccion")
    , @NamedQuery(name = "OrdenConstruccion.findByFechaInicio", query = "SELECT o FROM OrdenConstruccion o WHERE o.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "OrdenConstruccion.findByFechaFin", query = "SELECT o FROM OrdenConstruccion o WHERE o.fechaFin = :fechaFin")})
public class OrdenConstruccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ORDEN_CONSTRUCCION")
    private Integer idOrdenConstruccion;
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @JoinColumn(name = "ID_ESTADO")
    private Integer idEstado;
    @Basic(optional = false)
    @Column(name = "ID_SOLICITUD")

    private int idSolicitud;

    public OrdenConstruccion() {
    }

    public OrdenConstruccion(Integer idOrdenConstruccion) {
        this.idOrdenConstruccion = idOrdenConstruccion;
    }

    public Integer getIdOrdenConstruccion() {
        return idOrdenConstruccion;
    }

    public void setIdOrdenConstruccion(Integer idOrdenConstruccion) {
        this.idOrdenConstruccion = idOrdenConstruccion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdenConstruccion != null ? idOrdenConstruccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenConstruccion)) {
            return false;
        }
        OrdenConstruccion other = (OrdenConstruccion) object;
        if ((this.idOrdenConstruccion == null && other.idOrdenConstruccion != null) || (this.idOrdenConstruccion != null && !this.idOrdenConstruccion.equals(other.idOrdenConstruccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sura.restapi.models.OrdenConstruccion[ idOrdenConstruccion=" + idOrdenConstruccion + " ]";
    }
    
}
