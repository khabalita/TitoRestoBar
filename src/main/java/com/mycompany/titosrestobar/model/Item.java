package com.mycompany.titosrestobar.model;


import java.io.Serializable;
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
public class Item implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_item;
    
    @Column(name = "Cantidad")
    private Integer cantidad;
    
    @OneToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;
    
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    //Constructor vacio
    public Item(){
    
    }
    public Item(Integer cantidad, Double precio, Producto producto, Pedido pedido) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.pedido = pedido;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
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

    @Override
    public String toString() {
        return "Item{" + "id_item=" + id_item + ", cantidad=" + cantidad + ", producto=" + producto + ", pedido=" + pedido + '}';
    }
    
    //calcula el precio por la cantidad de items
    public Double calcularSubTotal(){
        return producto.getPrecio()*cantidad;
    }
    
}
