/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.forms;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import proyecto.entidades.Empleado;

/**
 *
 * @author luisd
 */
@Named(value = "empleadoForm")
@SessionScoped
public class EmpleadoForm implements Serializable {

    private Empleado empleado;

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @PostConstruct
    public void init() {
        try {
            //Codigo de inicializacion de formulario
        } catch (Exception e) {
        }
    }

    public EmpleadoForm() {
    }

}
