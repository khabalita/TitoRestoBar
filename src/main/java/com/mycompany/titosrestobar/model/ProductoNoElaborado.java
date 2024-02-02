
package com.mycompany.titosrestobar.model;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "no_elaborado")
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
    

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ProductoNoElaborado{" + "stock=" + stock + '}';
    }    
    
}
