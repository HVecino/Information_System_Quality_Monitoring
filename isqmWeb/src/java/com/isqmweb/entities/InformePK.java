/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isqmweb.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Ferchito
 */
@Embeddable
public class InformePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idMonitoreos")
    private int idMonitoreos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCapacitaciones")
    private int idCapacitaciones;

    public InformePK() {
    }

    public InformePK(int idMonitoreos, int idCapacitaciones) {
        this.idMonitoreos = idMonitoreos;
        this.idCapacitaciones = idCapacitaciones;
    }

    public int getIdMonitoreos() {
        return idMonitoreos;
    }

    public void setIdMonitoreos(int idMonitoreos) {
        this.idMonitoreos = idMonitoreos;
    }

    public int getIdCapacitaciones() {
        return idCapacitaciones;
    }

    public void setIdCapacitaciones(int idCapacitaciones) {
        this.idCapacitaciones = idCapacitaciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idMonitoreos;
        hash += (int) idCapacitaciones;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InformePK)) {
            return false;
        }
        InformePK other = (InformePK) object;
        if (this.idMonitoreos != other.idMonitoreos) {
            return false;
        }
        if (this.idCapacitaciones != other.idCapacitaciones) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.isqmweb.entities.InformePK[ idMonitoreos=" + idMonitoreos + ", idCapacitaciones=" + idCapacitaciones + " ]";
    }
    
}
