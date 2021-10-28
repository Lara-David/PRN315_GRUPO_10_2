/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
 * @author luisd
 */
@Entity
@Table(name = "salario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salario.findAll", query = "SELECT s FROM Salario s")
    , @NamedQuery(name = "Salario.findBySalarioId", query = "SELECT s FROM Salario s WHERE s.salarioId = :salarioId")
    , @NamedQuery(name = "Salario.findByMonto", query = "SELECT s FROM Salario s WHERE s.monto = :monto")
    , @NamedQuery(name = "Salario.findByFechaPago", query = "SELECT s FROM Salario s WHERE s.fechaPago = :fechaPago")
    , @NamedQuery(name = "Salario.findByFechaCreacion", query = "SELECT s FROM Salario s WHERE s.fechaCreacion = :fechaCreacion")})
public class Salario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "salario_id")
    private BigDecimal salarioId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto")
    private BigDecimal monto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_pago")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @JoinColumn(name = "empleado_id", referencedColumnName = "empleado_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleado empleadoId;

    public Salario() {
    }

    public Salario(BigDecimal salarioId) {
        this.salarioId = salarioId;
    }

    public Salario(BigDecimal salarioId, BigDecimal monto, Date fechaPago, Date fechaCreacion) {
        this.salarioId = salarioId;
        this.monto = monto;
        this.fechaPago = fechaPago;
        this.fechaCreacion = fechaCreacion;
    }

    public BigDecimal getSalarioId() {
        return salarioId;
    }

    public void setSalarioId(BigDecimal salarioId) {
        this.salarioId = salarioId;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Empleado getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Empleado empleadoId) {
        this.empleadoId = empleadoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salarioId != null ? salarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salario)) {
            return false;
        }
        Salario other = (Salario) object;
        if ((this.salarioId == null && other.salarioId != null) || (this.salarioId != null && !this.salarioId.equals(other.salarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyecto.entidades.Salario[ salarioId=" + salarioId + " ]";
    }
    
}
