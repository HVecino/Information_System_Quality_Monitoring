/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isqmweb.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ferchito
 */
@Entity
@Table(name = "informes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Informe.findAll", query = "SELECT i FROM Informe i"),
    @NamedQuery(name = "Informe.findByIdMonitoreos", query = "SELECT i FROM Informe i WHERE i.informePK.idMonitoreos = :idMonitoreos"),
    @NamedQuery(name = "Informe.findByIdCapacitaciones", query = "SELECT i FROM Informe i WHERE i.informePK.idCapacitaciones = :idCapacitaciones"),
    @NamedQuery(name = "Informe.findByFechaCapacitacion", query = "SELECT i FROM Informe i WHERE i.fechaCapacitacion = :fechaCapacitacion")})
public class Informe implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InformePK informePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaCapacitacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCapacitacion;
    @JoinColumn(name = "idCapacitaciones", referencedColumnName = "idCapacitaciones", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Capacitacion capacitacion;
    @JoinColumn(name = "idMonitoreos", referencedColumnName = "idMonitoreos", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Monitoreo monitoreo;

    public Informe() {
    }

    public Informe(InformePK informePK) {
        this.informePK = informePK;
    }

    public Informe(InformePK informePK, Date fechaCapacitacion) {
        this.informePK = informePK;
        this.fechaCapacitacion = fechaCapacitacion;
    }

    public Informe(int idMonitoreos, int idCapacitaciones) {
        this.informePK = new InformePK(idMonitoreos, idCapacitaciones);
    }

    public InformePK getInformePK() {
        return informePK;
    }

    public void setInformePK(InformePK informePK) {
        this.informePK = informePK;
    }

    public Date getFechaCapacitacion() {
        return fechaCapacitacion;
    }

    public void setFechaCapacitacion(Date fechaCapacitacion) {
        this.fechaCapacitacion = fechaCapacitacion;
    }

    public Capacitacion getCapacitacion() {
        return capacitacion;
    }

    public void setCapacitacion(Capacitacion capacitacion) {
        this.capacitacion = capacitacion;
    }

    public Monitoreo getMonitoreo() {
        return monitoreo;
    }

    public void setMonitoreo(Monitoreo monitoreo) {
        this.monitoreo = monitoreo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (informePK != null ? informePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Informe)) {
            return false;
        }
        Informe other = (Informe) object;
        if ((this.informePK == null && other.informePK != null) || (this.informePK != null && !this.informePK.equals(other.informePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.isqmweb.entities.Informe[ informePK=" + informePK + " ]";
    }
    
}
