package com.mycompany.titosrestobar.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Items")
public class Item {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_item;
    
    @Column(name = "Cantidad")
    private Integer cantidad;
    @Column(name = "Precio")
    private Double precio;
    
    @OneToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;
    
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    //Constructores
    public Item(){
    
    }
    public Item(Integer cantidad, Double precio, Producto producto, Pedido pedido) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.producto = producto;
        this.pedido = pedido;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Producto getProd() {
        return producto;
    }

    public void setProd(Producto prod) {
        this.producto = prod;
    }
    
    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    
}
