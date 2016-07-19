/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isqmweb.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ferchito
 */
@Entity
@Table(name = "estados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e"),
    @NamedQuery(name = "Estado.findByIdEstados", query = "SELECT e FROM Estado e WHERE e.idEstados = :idEstados"),
    @NamedQuery(name = "Estado.findByTipoEstado", query = "SELECT e FROM Estado e WHERE e.tipoEstado = :tipoEstado"),
    @NamedQuery(name = "Estado.findByNombreEstado", query = "SELECT e FROM Estado e WHERE e.nombreEstado = :nombreEstado")})
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEstados")
    private Integer idEstados;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipoEstado")
    private int tipoEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nombreEstado")
    private String nombreEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstados")
    private List<Capacitacion> capacitacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstados")
    private List<Categoria> categoriaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstados")
    private List<Rol> rolList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstados")
    private List<Feedback> feedbackList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstados")
    private List<Monitoreo> monitoreoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstados")
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstados")
    private List<Atributo> atributoList;

    public Estado() {
    }

    public Estado(Integer idEstados) {
        this.idEstados = idEstados;
    }

    public Estado(Integer idEstados, int tipoEstado, String nombreEstado) {
        this.idEstados = idEstados;
        this.tipoEstado = tipoEstado;
        this.nombreEstado = nombreEstado;
    }

    public Integer getIdEstados() {
        return idEstados;
    }

    public void setIdEstados(Integer idEstados) {
        this.idEstados = idEstados;
    }

    public int getTipoEstado() {
        return tipoEstado;
    }

    public void setTipoEstado(int tipoEstado) {
        this.tipoEstado = tipoEstado;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    @XmlTransient
    public List<Capacitacion> getCapacitacionList() {
        return capacitacionList;
    }

    public void setCapacitacionList(List<Capacitacion> capacitacionList) {
        this.capacitacionList = capacitacionList;
    }

    @XmlTransient
    public List<Categoria> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<Categoria> categoriaList) {
        this.categoriaList = categoriaList;
    }

    @XmlTransient
    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    @XmlTransient
    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(List<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }

    @XmlTransient
    public List<Monitoreo> getMonitoreoList() {
        return monitoreoList;
    }

    public void setMonitoreoList(List<Monitoreo> monitoreoList) {
        this.monitoreoList = monitoreoList;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
    public List<Atributo> getAtributoList() {
        return atributoList;
    }

    public void setAtributoList(List<Atributo> atributoList) {
        this.atributoList = atributoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstados != null ? idEstados.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estado)) {
            return false;
        }
        Estado other = (Estado) object;
        if ((this.idEstados == null && other.idEstados != null) || (this.idEstados != null && !this.idEstados.equals(other.idEstados))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.isqmweb.entities.Estado[ idEstados=" + idEstados + " ]";
    }
    
}
