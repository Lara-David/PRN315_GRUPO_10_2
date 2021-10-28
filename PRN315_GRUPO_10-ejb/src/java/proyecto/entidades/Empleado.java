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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")
    , @NamedQuery(name = "Empleado.findByEmpleadoId", query = "SELECT e FROM Empleado e WHERE e.empleadoId = :empleadoId")
    , @NamedQuery(name = "Empleado.findByNombres", query = "SELECT e FROM Empleado e WHERE e.nombres = :nombres")
    , @NamedQuery(name = "Empleado.findByApellidos", query = "SELECT e FROM Empleado e WHERE e.apellidos = :apellidos")
    , @NamedQuery(name = "Empleado.findByFechaNacimiento", query = "SELECT e FROM Empleado e WHERE e.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Empleado.findByGenero", query = "SELECT e FROM Empleado e WHERE e.genero = :genero")
    , @NamedQuery(name = "Empleado.findByEmail", query = "SELECT e FROM Empleado e WHERE e.email = :email")
    , @NamedQuery(name = "Empleado.findByActivo", query = "SELECT e FROM Empleado e WHERE e.activo = :activo")
    , @NamedQuery(name = "Empleado.findByFechaCreacion", query = "SELECT e FROM Empleado e WHERE e.fechaCreacion = :fechaCreacion")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "empleado_id")
    private BigDecimal empleadoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "genero")
    private String genero;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private int activo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @JoinColumn(name = "categoria_id", referencedColumnName = "categoria_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Categoria categoriaId;
    @OneToMany(mappedBy = "managerId", fetch = FetchType.LAZY)
    private List<Empleado> empleadoList;
    @JoinColumn(name = "manager_id", referencedColumnName = "empleado_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Empleado managerId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoId", fetch = FetchType.LAZY)
    private List<Salario> salarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoEmpleadoId", fetch = FetchType.LAZY)
    private List<RotacionPersonal> rotacionPersonalList;

    public Empleado() {
    }

    public Empleado(BigDecimal empleadoId) {
        this.empleadoId = empleadoId;
    }

    public Empleado(BigDecimal empleadoId, String nombres, String apellidos, Date fechaNacimiento, String genero, String email, int activo, Date fechaCreacion) {
        this.empleadoId = empleadoId;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.email = email;
        this.activo = activo;
        this.fechaCreacion = fechaCreacion;
    }

    public BigDecimal getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(BigDecimal empleadoId) {
        this.empleadoId = empleadoId;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Categoria getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Categoria categoriaId) {
        this.categoriaId = categoriaId;
    }

    @XmlTransient
    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    public Empleado getManagerId() {
        return managerId;
    }

    public void setManagerId(Empleado managerId) {
        this.managerId = managerId;
    }

    @XmlTransient
    public List<Salario> getSalarioList() {
        return salarioList;
    }

    public void setSalarioList(List<Salario> salarioList) {
        this.salarioList = salarioList;
    }

    @XmlTransient
    public List<RotacionPersonal> getRotacionPersonalList() {
        return rotacionPersonalList;
    }

    public void setRotacionPersonalList(List<RotacionPersonal> rotacionPersonalList) {
        this.rotacionPersonalList = rotacionPersonalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empleadoId != null ? empleadoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.empleadoId == null && other.empleadoId != null) || (this.empleadoId != null && !this.empleadoId.equals(other.empleadoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyecto.entidades.Empleado[ empleadoId=" + empleadoId + " ]";
    }
    
}
