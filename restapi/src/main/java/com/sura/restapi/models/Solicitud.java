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
@Table(name = "solicitud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitud.findAll", query = "SELECT s FROM Solicitud s")
    , @NamedQuery(name = "Solicitud.findByIdSolicitud", query = "SELECT s FROM Solicitud s WHERE s.idSolicitud = :idSolicitud")
    , @NamedQuery(name = "Solicitud.findByX", query = "SELECT s FROM Solicitud s WHERE s.x = :x")
    , @NamedQuery(name = "Solicitud.findByY", query = "SELECT s FROM Solicitud s WHERE s.y = :y")
    , @NamedQuery(name = "Solicitud.findByFechaSolicitud", query = "SELECT s FROM Solicitud s WHERE s.fechaSolicitud = :fechaSolicitud")})
public class Solicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SOLICITUD")
    private Integer idSolicitud;
    @Basic(optional = false)
    @Column(name = "X")
    private int x;
    @Basic(optional = false)
    @Column(name = "Y")
    private int y;
    @Column(name = "FECHA_SOLICITUD")
    @Temporal(TemporalType.DATE)
    private Date fechaSolicitud;
  //  @JoinColumn(name = "ID_CONSTRUCCION", referencedColumnName = "ID_CONSTRUCCION")
   // @ManyToOne(optional = false)
   
    private int idConstruccion;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "idSolicitud")
    //private List<OrdenConstruccion> ordenConstruccionList;

    public Solicitud() {
    }

    public Solicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Solicitud(Integer idSolicitud, int x, int y) {
        this.idSolicitud = idSolicitud;
        this.x = x;
        this.y = y;
    }

    public Integer getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Date getFechaSolicitud() {
    	if(fechaSolicitud==null) {
    		fechaSolicitud= new Date();
    	}
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
    	if(fechaSolicitud==null) {
    		fechaSolicitud= new Date();
    	}
        this.fechaSolicitud = fechaSolicitud;
    }

    public int getIdConstruccion() {
        return idConstruccion;
    }

    public void setIdConstruccion(int idConstruccion) {
        this.idConstruccion = idConstruccion;
    }

   /* @XmlTransient
    public List<OrdenConstruccion> getOrdenConstruccionList() {
        return ordenConstruccionList;
    }

    public void setOrdenConstruccionList(List<OrdenConstruccion> ordenConstruccionList) {
        this.ordenConstruccionList = ordenConstruccionList;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitud != null ? idSolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitud)) {
            return false;
        }
        Solicitud other = (Solicitud) object;
        if ((this.idSolicitud == null && other.idSolicitud != null) || (this.idSolicitud != null && !this.idSolicitud.equals(other.idSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sura.restapi.models.Solicitud[ idSolicitud=" + idSolicitud + " ]";
    }
    
}
