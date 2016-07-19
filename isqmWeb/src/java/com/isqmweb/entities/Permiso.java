/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isqmweb.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "permisos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permiso.findAll", query = "SELECT p FROM Permiso p"),
    @NamedQuery(name = "Permiso.findByIdPermisos", query = "SELECT p FROM Permiso p WHERE p.idPermisos = :idPermisos"),
    @NamedQuery(name = "Permiso.findByNombrePermisos", query = "SELECT p FROM Permiso p WHERE p.nombrePermisos = :nombrePermisos")})
public class Permiso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPermisos")
    private Integer idPermisos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombrePermisos")
    private String nombrePermisos;
    @JoinTable(name = "rolespermisos", joinColumns = {
        @JoinColumn(name = "idPermisos", referencedColumnName = "idPermisos")}, inverseJoinColumns = {
        @JoinColumn(name = "idRoles", referencedColumnName = "idRoles")})
    @ManyToMany
    private List<Rol> rolList;

    public Permiso() {
    }

    public Permiso(Integer idPermisos) {
        this.idPermisos = idPermisos;
    }

    public Permiso(Integer idPermisos, String nombrePermisos) {
        this.idPermisos = idPermisos;
        this.nombrePermisos = nombrePermisos;
    }

    public Integer getIdPermisos() {
        return idPermisos;
    }

    public void setIdPermisos(Integer idPermisos) {
        this.idPermisos = idPermisos;
    }

    public String getNombrePermisos() {
        return nombrePermisos;
    }

    public void setNombrePermisos(String nombrePermisos) {
        this.nombrePermisos = nombrePermisos;
    }

    @XmlTransient
    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPermisos != null ? idPermisos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permiso)) {
            return false;
        }
        Permiso other = (Permiso) object;
        if ((this.idPermisos == null && other.idPermisos != null) || (this.idPermisos != null && !this.idPermisos.equals(other.idPermisos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.isqmweb.entities.Permiso[ idPermisos=" + idPermisos + " ]";
    }
    
}
