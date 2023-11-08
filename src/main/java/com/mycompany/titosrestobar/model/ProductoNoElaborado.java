
package com.mycompany.titosrestobar.model;


public class ProductoNoElaborado extends Producto{
    private int stock;
    
    //Constructor

    public ProductoNoElaborado() {
    }

    public ProductoNoElaborado(String nombre, String descripcion, Double costo, Double precio, int stock) {
        super(nombre, descripcion, costo, precio);
        this.stock = stock;
    }
    
    //Getter y Setter
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
}
