/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import proyecto.entidades.Empleado;

/**
 *
 * @author luisd
 */
@Stateless
public class EmpleadoFacade extends AbstractFacade<Empleado> implements EmpleadoFacadeLocal {

    @PersistenceContext(unitName = "PRN315_GRUPO_10-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpleadoFacade() {
        super(Empleado.class);
    }

    @Override
    public List<Empleado> buscarTodosAlfabeticamente() {
        //-----------
        try {
            em.getEntityManagerFactory().getCache().evictAll();//Limpiando la memoria
            String consulta = "SELECT * FROM [dbo.empleado] order by apellidos";//Query de consulta
            //Ejecucion de consulta y conversion a entidad
            Query query = em.createNativeQuery(consulta, Empleado.class);
            List<Empleado> listaResultado = query.getResultList();//Pasando el resultado a lista
            return listaResultado;
        } catch (Exception e) {
            return null;
        }
        //------------------
    }

}
