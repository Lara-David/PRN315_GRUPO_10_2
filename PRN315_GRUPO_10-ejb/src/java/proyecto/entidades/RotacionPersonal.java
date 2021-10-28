/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luisd
 */
@Entity
@Table(name = "rotacion_personal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RotacionPersonal.findAll", query = "SELECT r FROM RotacionPersonal r")
    , @NamedQuery(name = "RotacionPersonal.findByRotacionPersonalId", query = "SELECT r FROM RotacionPersonal r WHERE r.rotacionPersonalId = :rotacionPersonalId")
    , @NamedQuery(name = "RotacionPersonal.findByDiaLaboral", query = "SELECT r FROM RotacionPersonal r WHERE r.diaLaboral = :diaLaboral")})
public class RotacionPersonal implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "rotacion_personal_id")
    private BigDecimal rotacionPersonalId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "dia_laboral")
    private String diaLaboral;
    @JoinColumn(name = "empleado_empleado_id", referencedColumnName = "empleado_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleado empleadoEmpleadoId;
    @JoinColumn(name = "tienda_tienda_id", referencedColumnName = "tienda_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tienda tiendaTiendaId;

    public RotacionPersonal() {
    }

    public RotacionPersonal(BigDecimal rotacionPersonalId) {
        this.rotacionPersonalId = rotacionPersonalId;
    }

    public RotacionPersonal(BigDecimal rotacionPersonalId, String diaLaboral) {
        this.rotacionPersonalId = rotacionPersonalId;
        this.diaLaboral = diaLaboral;
    }

    public BigDecimal getRotacionPersonalId() {
        return rotacionPersonalId;
    }

    public void setRotacionPersonalId(BigDecimal rotacionPersonalId) {
        this.rotacionPersonalId = rotacionPersonalId;
    }

    public String getDiaLaboral() {
        return diaLaboral;
    }

    public void setDiaLaboral(String diaLaboral) {
        this.diaLaboral = diaLaboral;
    }

    public Empleado getEmpleadoEmpleadoId() {
        return empleadoEmpleadoId;
    }

    public void setEmpleadoEmpleadoId(Empleado empleadoEmpleadoId) {
        this.empleadoEmpleadoId = empleadoEmpleadoId;
    }

    public Tienda getTiendaTiendaId() {
        return tiendaTiendaId;
    }

    public void setTiendaTiendaId(Tienda tiendaTiendaId) {
        this.tiendaTiendaId = tiendaTiendaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rotacionPersonalId != null ? rotacionPersonalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RotacionPersonal)) {
            return false;
        }
        RotacionPersonal other = (RotacionPersonal) object;
        if ((this.rotacionPersonalId == null && other.rotacionPersonalId != null) || (this.rotacionPersonalId != null && !this.rotacionPersonalId.equals(other.rotacionPersonalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyecto.entidades.RotacionPersonal[ rotacionPersonalId=" + rotacionPersonalId + " ]";
    }
    
}
