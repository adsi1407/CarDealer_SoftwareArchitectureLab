/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.cardealer.ejb;

import co.com.cardealer.entity.Foto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author DAVID
 */
@Stateless
public class FotoFacade extends AbstractFacade<Foto> implements FotoFacadeLocal {

    @PersistenceContext(unitName = "CarDealer_SoftwareArchitectureLabPU")
    private EntityManager em;
    private CriteriaBuilder cb;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FotoFacade() {
        super(Foto.class);
    }
    
    public List<Foto> findByVehicle(String matricula) {
        
        cb = em.getCriteriaBuilder();
        CriteriaQuery<Foto> cq = cb.createQuery(Foto.class);
        Root<Foto> foto = cq.from(Foto.class);
        cq.where(cb.equal(foto.get("vehiculo"), matricula));
        return getEntityManager().createQuery(cq).getResultList();
    }
    
}
