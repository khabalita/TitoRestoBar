package com.mycompany.titosrestobar.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Pedidos")
public class Pedido implements Serializable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id_pedido;
    
    @Column(name = "Fecha_Inicio")
    @Temporal(TemporalType.TIME)
    private Date fechaInicio;
    @Column(name = "Fecha_Cierre")
    @Temporal(TemporalType.TIME)
    private Date fechaCierre;
    @Column(name = "Total")
    private Double valorTotal;
    @Column(name = "Descuento")
    private Double descuento;
    @Column(name = "Subtotal")
    private Double subTotal;
    @Column(name = "estado")
    private Boolean estado;

    @OneToMany(mappedBy = "pedido")
    private List<Item> items;
    
    @OneToOne
    @JoinColumn(name = "id_mesa")
    private Mesa mesa;
    
    
    //Constructor vacio
    public Pedido(){
    
    }
    
    //Getter y Setter
    public Integer getId_pedido() {
        return id_pedido;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
     public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
    
    

    @Override
    public String toString() {
        return "Pedido{" + "id_pedido=" + id_pedido + ", fechaInicio=" + fechaInicio + ", fechaCierre=" + fechaCierre + ", valorTotal=" + valorTotal + ", descuento=" + descuento + ", subTotal=" + subTotal + ", estado=" + estado + ", items=" + items + ", mesa=" + mesa + '}';
    }
    
    
    
}
