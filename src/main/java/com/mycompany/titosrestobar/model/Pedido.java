package com.mycompany.titosrestobar.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Pedidos")
//consulta que devuelve los pedidos activos
@NamedQueries({
    @NamedQuery(name = "Pedido.buscarPedidoActivo", query = "SELECT p FROM Pedido p WHERE p.estado = :estado")

})
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

    @OneToMany(mappedBy = "pedido",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Item> items;
    
    //Constructor vacio
    public Pedido(){
    
    }
    
    public Pedido(Date fechaInicio, Date fechaCierre, Double valorTotal, Double descuento, Double subTotal, Boolean estado){
        this.fechaInicio = fechaInicio;
        this.fechaCierre = fechaCierre;
        this.valorTotal = valorTotal;
        this.descuento = descuento;
        this.subTotal = subTotal;
        this.estado = estado;
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
    
    //METODOS
    
    //calcula el valor total de pedido ten
    public Double calculaTotalPedido(){
        this.valorTotal = 0.0;
        for(Item item: items){
            this.valorTotal =+ item.calcularSubTotal();
        }
        return valorTotal;
    }   

    @Override
    public String toString() {
        return "Pedido{" + "id_pedido=" + id_pedido + ", fechaInicio=" + fechaInicio + ", fechaCierre=" + fechaCierre + ", valorTotal=" + valorTotal + ", descuento=" + descuento + ", subTotal=" + subTotal + ", estado=" + estado + ", items=" + items + '}';
    }
    
    
    
}
