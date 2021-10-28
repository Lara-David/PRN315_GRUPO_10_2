/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import proyecto.entidades.Categoria;

/**
 *
 * @author luisd
 */
@Stateless
public class CategoriaFacade extends AbstractFacade<Categoria> implements CategoriaFacadeLocal {

    @PersistenceContext(unitName = "PRN315_GRUPO_10-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriaFacade() {
        super(Categoria.class);
    }
    
}
