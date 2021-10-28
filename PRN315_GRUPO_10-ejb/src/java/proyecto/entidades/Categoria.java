/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author luisd
 */
@Entity
@Table(name = "categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c")
    , @NamedQuery(name = "Categoria.findByCategoriaId", query = "SELECT c FROM Categoria c WHERE c.categoriaId = :categoriaId")
    , @NamedQuery(name = "Categoria.findByCategoria", query = "SELECT c FROM Categoria c WHERE c.categoria = :categoria")
    , @NamedQuery(name = "Categoria.findByFechaCreacion", query = "SELECT c FROM Categoria c WHERE c.fechaCreacion = :fechaCreacion")})
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "categoria_id")
    private BigDecimal categoriaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "categoria")
    private String categoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoriaId", fetch = FetchType.LAZY)
    private List<Empleado> empleadoList;

    public Categoria() {
    }

    public Categoria(BigDecimal categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Categoria(BigDecimal categoriaId, String categoria, Date fechaCreacion) {
        this.categoriaId = categoriaId;
        this.categoria = categoria;
        this.fechaCreacion = fechaCreacion;
    }

    public BigDecimal getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(BigDecimal categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @XmlTransient
    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoriaId != null ? categoriaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.categoriaId == null && other.categoriaId != null) || (this.categoriaId != null && !this.categoriaId.equals(other.categoriaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyecto.entidades.Categoria[ categoriaId=" + categoriaId + " ]";
    }
    
}
