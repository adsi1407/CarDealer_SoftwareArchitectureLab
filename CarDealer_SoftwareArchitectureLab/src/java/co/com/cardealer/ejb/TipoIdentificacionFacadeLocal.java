/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.cardealer.ejb;

import co.com.cardealer.entity.Tipoidentificacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DAVID
 */
@Local
public interface TipoIdentificacionFacadeLocal {

    void create(Tipoidentificacion tipoidentificacion);

    void edit(Tipoidentificacion tipoidentificacion);

    void remove(Tipoidentificacion tipoidentificacion);

    Tipoidentificacion find(Object id);

    List<Tipoidentificacion> findAll();

    List<Tipoidentificacion> findRange(int[] range);

    int count();
    
}
