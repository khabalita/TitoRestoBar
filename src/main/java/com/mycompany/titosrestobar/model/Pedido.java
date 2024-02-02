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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Pedidos")
public class Pedido implements Serializable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id_pedido;
    
    //revisar este atributo precio
    @Column(name = "Precio")
    private Double precio;
    @Column(name = "Fecha_Inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "Fecha_Cierre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCierre;
    @Column(name = "Total")
    private Double valorTotal;
    @Column(name = "Descuento")
    private Double descuento = null;
    @Column(name = "Subtotal")
    private Double subTotal;

    @OneToMany(mappedBy = "pedido")
    private List<Item> items;
    
    
    //Constructores
    public Pedido(){
    
    }
    public Pedido(Double precio, Date fechaInicio, Date fechaCierre, Double valorTotal, Double descuento, Double subTotal, List<Item> items) {
        this.precio = precio;
        this.fechaInicio = fechaInicio;
        this.fechaCierre = fechaCierre;
        this.valorTotal = valorTotal;
        this.descuento = descuento;
        this.subTotal = subTotal;
        this.items = items;
    }
    
    //Getter y Setter
    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
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

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }
    
    
}
