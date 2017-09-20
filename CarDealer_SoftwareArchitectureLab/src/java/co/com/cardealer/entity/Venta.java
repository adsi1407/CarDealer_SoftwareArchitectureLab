/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.cardealer.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DAVID
 */
@Entity
@Table(name = "ventas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v")
    , @NamedQuery(name = "Venta.findByCodigo", query = "SELECT v FROM Venta v WHERE v.codigo = :codigo")
    , @NamedQuery(name = "Venta.findByFecha", query = "SELECT v FROM Venta v WHERE v.fecha = :fecha")
    , @NamedQuery(name = "Venta.findByValorBruto", query = "SELECT v FROM Venta v WHERE v.valorBruto = :valorBruto")
    , @NamedQuery(name = "Venta.findByPorcentajeIva", query = "SELECT v FROM Venta v WHERE v.porcentajeIva = :porcentajeIva")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorBruto")
    private long valorBruto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "porcentajeIva")
    private double porcentajeIva;
    @JoinColumns({
        @JoinColumn(name = "tipoIdentificacionCliente", referencedColumnName = "tipoIdentificacion")
        , @JoinColumn(name = "numeroIdentificacionCliente", referencedColumnName = "numeroIdentificacion")})
    @ManyToOne(optional = false)
    private Cliente cliente;
    @JoinColumn(name = "vehiculo", referencedColumnName = "matricula")
    @ManyToOne(optional = false)
    private Vehiculo vehiculo;

    public Venta() {
    }

    public Venta(String codigo) {
        this.codigo = codigo;
    }

    public Venta(String codigo, Date fecha, long valorBruto, double porcentajeIva) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.valorBruto = valorBruto;
        this.porcentajeIva = porcentajeIva;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public long getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(long valorBruto) {
        this.valorBruto = valorBruto;
    }

    public double getPorcentajeIva() {
        return porcentajeIva;
    }

    public void setPorcentajeIva(double porcentajeIva) {
        this.porcentajeIva = porcentajeIva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.cardealer.entity.Venta[ codigo=" + codigo + " ]";
    }
    
}
