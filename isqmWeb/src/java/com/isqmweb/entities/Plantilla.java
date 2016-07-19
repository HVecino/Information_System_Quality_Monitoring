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
@Table(name = "plantillas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plantilla.findAll", query = "SELECT p FROM Plantilla p"),
    @NamedQuery(name = "Plantilla.findByIdPlantillas", query = "SELECT p FROM Plantilla p WHERE p.idPlantillas = :idPlantillas"),
    @NamedQuery(name = "Plantilla.findByNombrePlantilla", query = "SELECT p FROM Plantilla p WHERE p.nombrePlantilla = :nombrePlantilla"),
    @NamedQuery(name = "Plantilla.findByFechaCreacionPlantilla", query = "SELECT p FROM Plantilla p WHERE p.fechaCreacionPlantilla = :fechaCreacionPlantilla"),
    @NamedQuery(name = "Plantilla.findByValorPlantilla", query = "SELECT p FROM Plantilla p WHERE p.valorPlantilla = :valorPlantilla")})
public class Plantilla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPlantillas")
    private Integer idPlantillas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombrePlantilla")
    private String nombrePlantilla;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaCreacionPlantilla")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacionPlantilla;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorPlantilla")
    private int valorPlantilla;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlantillas")
    private List<Categoria> categoriaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlantillas")
    private List<Monitoreo> monitoreoList;

    public Plantilla() {
    }

    public Plantilla(Integer idPlantillas) {
        this.idPlantillas = idPlantillas;
    }

    public Plantilla(Integer idPlantillas, String nombrePlantilla, Date fechaCreacionPlantilla, int valorPlantilla) {
        this.idPlantillas = idPlantillas;
        this.nombrePlantilla = nombrePlantilla;
        this.fechaCreacionPlantilla = fechaCreacionPlantilla;
        this.valorPlantilla = valorPlantilla;
    }

    public Integer getIdPlantillas() {
        return idPlantillas;
    }

    public void setIdPlantillas(Integer idPlantillas) {
        this.idPlantillas = idPlantillas;
    }

    public String getNombrePlantilla() {
        return nombrePlantilla;
    }

    public void setNombrePlantilla(String nombrePlantilla) {
        this.nombrePlantilla = nombrePlantilla;
    }

    public Date getFechaCreacionPlantilla() {
        return fechaCreacionPlantilla;
    }

    public void setFechaCreacionPlantilla(Date fechaCreacionPlantilla) {
        this.fechaCreacionPlantilla = fechaCreacionPlantilla;
    }

    public int getValorPlantilla() {
        return valorPlantilla;
    }

    public void setValorPlantilla(int valorPlantilla) {
        this.valorPlantilla = valorPlantilla;
    }

    @XmlTransient
    public List<Categoria> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<Categoria> categoriaList) {
        this.categoriaList = categoriaList;
    }

    @XmlTransient
    public List<Monitoreo> getMonitoreoList() {
        return monitoreoList;
    }

    public void setMonitoreoList(List<Monitoreo> monitoreoList) {
        this.monitoreoList = monitoreoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlantillas != null ? idPlantillas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plantilla)) {
            return false;
        }
        Plantilla other = (Plantilla) object;
        if ((this.idPlantillas == null && other.idPlantillas != null) || (this.idPlantillas != null && !this.idPlantillas.equals(other.idPlantillas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.isqmweb.entities.Plantilla[ idPlantillas=" + idPlantillas + " ]";
    }
    
}
