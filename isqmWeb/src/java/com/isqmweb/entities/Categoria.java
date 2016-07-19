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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "categorias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c"),
    @NamedQuery(name = "Categoria.findByIdCategorias", query = "SELECT c FROM Categoria c WHERE c.idCategorias = :idCategorias"),
    @NamedQuery(name = "Categoria.findByNombreCategoria", query = "SELECT c FROM Categoria c WHERE c.nombreCategoria = :nombreCategoria"),
    @NamedQuery(name = "Categoria.findByValorCategoria", query = "SELECT c FROM Categoria c WHERE c.valorCategoria = :valorCategoria")})
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCategorias")
    private Integer idCategorias;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombreCategoria")
    private String nombreCategoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorCategoria")
    private int valorCategoria;
    @JoinColumn(name = "idEstados", referencedColumnName = "idEstados")
    @ManyToOne(optional = false)
    private Estado idEstados;
    @JoinColumn(name = "idPlantillas", referencedColumnName = "idPlantillas")
    @ManyToOne(optional = false)
    private Plantilla idPlantillas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategorias")
    private List<Atributo> atributoList;

    public Categoria() {
    }

    public Categoria(Integer idCategorias) {
        this.idCategorias = idCategorias;
    }

    public Categoria(Integer idCategorias, String nombreCategoria, int valorCategoria) {
        this.idCategorias = idCategorias;
        this.nombreCategoria = nombreCategoria;
        this.valorCategoria = valorCategoria;
    }

    public Integer getIdCategorias() {
        return idCategorias;
    }

    public void setIdCategorias(Integer idCategorias) {
        this.idCategorias = idCategorias;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public int getValorCategoria() {
        return valorCategoria;
    }

    public void setValorCategoria(int valorCategoria) {
        this.valorCategoria = valorCategoria;
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
        hash += (idCategorias != null ? idCategorias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.idCategorias == null && other.idCategorias != null) || (this.idCategorias != null && !this.idCategorias.equals(other.idCategorias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.isqmweb.entities.Categoria[ idCategorias=" + idCategorias + " ]";
    }
    
}
