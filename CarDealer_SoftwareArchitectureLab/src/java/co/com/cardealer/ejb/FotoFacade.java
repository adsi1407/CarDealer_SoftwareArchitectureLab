/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.cardealer.ejb;

import co.com.cardealer.entity.Foto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author DAVID
 */
@Stateless
public class FotoFacade extends AbstractFacade<Foto> implements FotoFacadeLocal {

    @PersistenceContext(unitName = "CarDealer_SoftwareArchitectureLabPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FotoFacade() {
        super(Foto.class);
    }
    
}
