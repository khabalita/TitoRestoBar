
package com.mycompany.titosrestobar.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@DiscriminatorValue (value = "no elaborado")

//REVISAR SI LA QUERY VA ACA O VA EN LA CLASE PRODUCTO

public class ProductoNoElaborado extends Producto implements Serializable{
    
    @Column(name = "Stock")
    private Integer stock;
    
    //Constructores
    public ProductoNoElaborado() {
        
    }

    public ProductoNoElaborado(Integer stock) {
        this.stock = stock;
    }

    public ProductoNoElaborado(Integer stock, String nombre, String descripcion, Double costo, Double precio) {
        super(nombre, descripcion, costo, precio);
        this.stock = stock;
    }
    
    //Getter y Setter
    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
    
    //ToString
    @Override
    public String toString() {
        return "ProductoNoElaborado{" + "stock=" + stock + '}';
    }    
    
}
