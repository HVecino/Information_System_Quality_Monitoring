/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isqmweb.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ferchito
 */
@Entity
@Table(name = "capacitaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Capacitacion.findAll", query = "SELECT c FROM Capacitacion c"),
    @NamedQuery(name = "Capacitacion.findByIdCapacitaciones", query = "SELECT c FROM Capacitacion c WHERE c.idCapacitaciones = :idCapacitaciones"),
    @NamedQuery(name = "Capacitacion.findByDescripcion", query = "SELECT c FROM Capacitacion c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Capacitacion.findByFechaCapacitacion", query = "SELECT c FROM Capacitacion c WHERE c.fechaCapacitacion = :fechaCapacitacion")})
public class Capacitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCapacitaciones")
    private Integer idCapacitaciones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaCapacitacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCapacitacion;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "justificacion")
    private String justificacion;
    @JoinColumn(name = "idEstados", referencedColumnName = "idEstados")
    @ManyToOne(optional = false)
    private Estado idEstados;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "capacitacion")
    private List<Informe> informeList;

    public Capacitacion() {
    }

    public Capacitacion(Integer idCapacitaciones) {
        this.idCapacitaciones = idCapacitaciones;
    }

    public Capacitacion(Integer idCapacitaciones, String descripcion, Date fechaCapacitacion, String justificacion) {
        this.idCapacitaciones = idCapacitaciones;
        this.descripcion = descripcion;
        this.fechaCapacitacion = fechaCapacitacion;
        this.justificacion = justificacion;
    }

    public Integer getIdCapacitaciones() {
        return idCapacitaciones;
    }

    public void setIdCapacitaciones(Integer idCapacitaciones) {
        this.idCapacitaciones = idCapacitaciones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCapacitacion() {
        return fechaCapacitacion;
    }

    public void setFechaCapacitacion(Date fechaCapacitacion) {
        this.fechaCapacitacion = fechaCapacitacion;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    public Estado getIdEstados() {
        return idEstados;
    }

    public void setIdEstados(Estado idEstados) {
        this.idEstados = idEstados;
    }

    @XmlTransient
    public List<Informe> getInformeList() {
        return informeList;
    }

    public void setInformeList(List<Informe> informeList) {
        this.informeList = informeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCapacitaciones != null ? idCapacitaciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Capacitacion)) {
            return false;
        }
        Capacitacion other = (Capacitacion) object;
        if ((this.idCapacitaciones == null && other.idCapacitaciones != null) || (this.idCapacitaciones != null && !this.idCapacitaciones.equals(other.idCapacitaciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.isqmweb.entities.Capacitacion[ idCapacitaciones=" + idCapacitaciones + " ]";
    }
    
}
