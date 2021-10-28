/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.ejb;

import java.util.List;
import javax.ejb.Local;
import proyecto.entidades.RotacionPersonal;

/**
 *
 * @author luisd
 */
@Local
public interface RotacionPersonalFacadeLocal {

    void create(RotacionPersonal rotacionPersonal);

    void edit(RotacionPersonal rotacionPersonal);

    void remove(RotacionPersonal rotacionPersonal);

    RotacionPersonal find(Object id);

    List<RotacionPersonal> findAll();

    List<RotacionPersonal> findRange(int[] range);

    int count();
    
}
