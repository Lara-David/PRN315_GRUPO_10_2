/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.ejb;

import java.util.List;
import javax.ejb.Local;
import proyecto.entidades.Salario;

/**
 *
 * @author luisd
 */
@Local
public interface SalarioFacadeLocal {

    void create(Salario salario);

    void edit(Salario salario);

    void remove(Salario salario);

    Salario find(Object id);

    List<Salario> findAll();

    List<Salario> findRange(int[] range);

    int count();
    
}
