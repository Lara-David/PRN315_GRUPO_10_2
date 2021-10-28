/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.ejb;

import java.util.List;
import javax.ejb.Local;
import proyecto.entidades.Empleado;

/**
 *
 * @author luisd
 */
@Local
public interface EmpleadoFacadeLocal {

    void create(Empleado empleado); //crear una tupla de la tabla

    void edit(Empleado empleado);  // editar una tupla de la tabla

    void remove(Empleado empleado);  //eliminar una tupla de la tabla

    Empleado find(Object id);  // busqueda por id de la tabla

    List<Empleado> findAll();  //buscar todos los elementos de la tabla

    List<Empleado> findRange(int[] range);  //buscar por rango

    int count();  // conteo de elementos en tabla
    
    //Función devolverá la lista de registros ordenados alfabéticamente
    List<Empleado> buscarTodosAlfabeticamente();
}
