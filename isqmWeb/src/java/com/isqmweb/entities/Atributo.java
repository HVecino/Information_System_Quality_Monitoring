/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isqmweb.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ferchito
 */
@Entity
@Table(name = "atributos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Atributo.findAll", query = "SELECT a FROM Atributo a"),
    @NamedQuery(name = "Atributo.findByIdAtributos", query = "SELECT a FROM Atributo a WHERE a.idAtributos = :idAtributos"),
    @NamedQuery(name = "Atributo.findByNombreAtributo", query = "SELECT a FROM Atributo a WHERE a.nombreAtributo = :nombreAtributo"),
    @NamedQuery(name = "Atributo.findByValorAtributo", query = "SELECT a FROM Atributo a WHERE a.valorAtributo = :valorAtributo")})
public class Atributo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAtributos")
    private Integer idAtributos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombreAtributo")
    private String nombreAtributo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorAtributo")
    private int valorAtributo;
    @JoinColumn(name = "idCategorias", referencedColumnName = "idCategorias")
    @ManyToOne(optional = false)
    private Categoria idCategorias;
    @JoinColumn(name = "idEstados", referencedColumnName = "idEstados")
    @ManyToOne(optional = false)
    private Estado idEstados;
    @JoinColumn(name = "idTipoAtributo", referencedColumnName = "idTipoAtributo")
    @ManyToOne(optional = false)
    private Tipoatributo idTipoAtributo;

    public Atributo() {
    }

    public Atributo(Integer idAtributos) {
        this.idAtributos = idAtributos;
    }

    public Atributo(Integer idAtributos, String nombreAtributo, int valorAtributo) {
        this.idAtributos = idAtributos;
        this.nombreAtributo = nombreAtributo;
        this.valorAtributo = valorAtributo;
    }

    public Integer getIdAtributos() {
        return idAtributos;
    }

    public void setIdAtributos(Integer idAtributos) {
        this.idAtributos = idAtributos;
    }

    public String getNombreAtributo() {
        return nombreAtributo;
    }

    public void setNombreAtributo(String nombreAtributo) {
        this.nombreAtributo = nombreAtributo;
    }

    public int getValorAtributo() {
        return valorAtributo;
    }

    public void setValorAtributo(int valorAtributo) {
        this.valorAtributo = valorAtributo;
    }

    public Categoria getIdCategorias() {
        return idCategorias;
    }

    public void setIdCategorias(Categoria idCategorias) {
        this.idCategorias = idCategorias;
    }

    public Estado getIdEstados() {
        return idEstados;
    }

    public void setIdEstados(Estado idEstados) {
        this.idEstados = idEstados;
    }

    public Tipoatributo getIdTipoAtributo() {
        return idTipoAtributo;
    }

    public void setIdTipoAtributo(Tipoatributo idTipoAtributo) {
        this.idTipoAtributo = idTipoAtributo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAtributos != null ? idAtributos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atributo)) {
            return false;
        }
        Atributo other = (Atributo) object;
        if ((this.idAtributos == null && other.idAtributos != null) || (this.idAtributos != null && !this.idAtributos.equals(other.idAtributos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.isqmweb.entities.Atributo[ idAtributos=" + idAtributos + " ]";
    }
    
}
