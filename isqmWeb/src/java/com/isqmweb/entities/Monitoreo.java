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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ferchito
 */
@Entity
@Table(name = "monitoreos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Monitoreo.findAll", query = "SELECT m FROM Monitoreo m"),
    @NamedQuery(name = "Monitoreo.findByIdMonitoreos", query = "SELECT m FROM Monitoreo m WHERE m.idMonitoreos = :idMonitoreos"),
    @NamedQuery(name = "Monitoreo.findByFechaMonitoreo", query = "SELECT m FROM Monitoreo m WHERE m.fechaMonitoreo = :fechaMonitoreo"),
    @NamedQuery(name = "Monitoreo.findByCalificacionMonitoreo", query = "SELECT m FROM Monitoreo m WHERE m.calificacionMonitoreo = :calificacionMonitoreo"),
    @NamedQuery(name = "Monitoreo.findByTranscripcion", query = "SELECT m FROM Monitoreo m WHERE m.transcripcion = :transcripcion")})
public class Monitoreo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMonitoreos")
    private Integer idMonitoreos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaMonitoreo")
    @Temporal(TemporalType.DATE)
    private Date fechaMonitoreo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "calificacionMonitoreo")
    private int calificacionMonitoreo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "transcripcion")
    private int transcripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMonitoreos")
    private List<Feedback> feedbackList;
    @JoinColumn(name = "idEstados", referencedColumnName = "idEstados")
    @ManyToOne(optional = false)
    private Estado idEstados;
    @JoinColumn(name = "idPlantillas", referencedColumnName = "idPlantillas")
    @ManyToOne(optional = false)
    private Plantilla idPlantillas;
    @JoinColumn(name = "idAnalistaDeCalidad", referencedColumnName = "idUsuarios")
    @ManyToOne(optional = false)
    private Usuario idAnalistaDeCalidad;
    @JoinColumn(name = "idAsesor", referencedColumnName = "idUsuarios")
    @ManyToOne(optional = false)
    private Usuario idAsesor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "monitoreo")
    private List<Informe> informeList;

    public Monitoreo() {
    }

    public Monitoreo(Integer idMonitoreos) {
        this.idMonitoreos = idMonitoreos;
    }

    public Monitoreo(Integer idMonitoreos, Date fechaMonitoreo, int calificacionMonitoreo, int transcripcion) {
        this.idMonitoreos = idMonitoreos;
        this.fechaMonitoreo = fechaMonitoreo;
        this.calificacionMonitoreo = calificacionMonitoreo;
        this.transcripcion = transcripcion;
    }

    public Integer getIdMonitoreos() {
        return idMonitoreos;
    }

    public void setIdMonitoreos(Integer idMonitoreos) {
        this.idMonitoreos = idMonitoreos;
    }

    public Date getFechaMonitoreo() {
        return fechaMonitoreo;
    }

    public void setFechaMonitoreo(Date fechaMonitoreo) {
        this.fechaMonitoreo = fechaMonitoreo;
    }

    public int getCalificacionMonitoreo() {
        return calificacionMonitoreo;
    }

    public void setCalificacionMonitoreo(int calificacionMonitoreo) {
        this.calificacionMonitoreo = calificacionMonitoreo;
    }

    public int getTranscripcion() {
        return transcripcion;
    }

    public void setTranscripcion(int transcripcion) {
        this.transcripcion = transcripcion;
    }

    @XmlTransient
    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(List<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }

    public Estado getIdEstados() {
        return idEstados;
    }

    public void setIdEstados(Estado idEstados) {
        this.idEstados = idEstados;
    }

    public Plantilla getIdPlantillas() {
        return idPlantillas;
    }

    public void setIdPlantillas(Plantilla idPlantillas) {
        this.idPlantillas = idPlantillas;
    }

    public Usuario getIdAnalistaDeCalidad() {
        return idAnalistaDeCalidad;
    }

    public void setIdAnalistaDeCalidad(Usuario idAnalistaDeCalidad) {
        this.idAnalistaDeCalidad = idAnalistaDeCalidad;
    }

    public Usuario getIdAsesor() {
        return idAsesor;
    }

    public void setIdAsesor(Usuario idAsesor) {
        this.idAsesor = idAsesor;
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
        hash += (idMonitoreos != null ? idMonitoreos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Monitoreo)) {
            return false;
        }
        Monitoreo other = (Monitoreo) object;
        if ((this.idMonitoreos == null && other.idMonitoreos != null) || (this.idMonitoreos != null && !this.idMonitoreos.equals(other.idMonitoreos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.isqmweb.entities.Monitoreo[ idMonitoreos=" + idMonitoreos + " ]";
    }
    
}
