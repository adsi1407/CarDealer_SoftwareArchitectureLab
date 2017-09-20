/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.cardealer.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DAVID
 */
@Embeddable
public class ClientePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "tipoIdentificacion")
    private int tipoIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "numeroIdentificacion")
    private String numeroIdentificacion;

    public ClientePK() {
    }

    public ClientePK(int tipoIdentificacion, String numeroIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public int getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(int tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) tipoIdentificacion;
        hash += (numeroIdentificacion != null ? numeroIdentificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientePK)) {
            return false;
        }
        ClientePK other = (ClientePK) object;
        if (this.tipoIdentificacion != other.tipoIdentificacion) {
            return false;
        }
        if ((this.numeroIdentificacion == null && other.numeroIdentificacion != null) || (this.numeroIdentificacion != null && !this.numeroIdentificacion.equals(other.numeroIdentificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.cardealer.entity.ClientesPK[ tipoIdentificacion=" + tipoIdentificacion + ", numeroIdentificacion=" + numeroIdentificacion + " ]";
    }
    
}
