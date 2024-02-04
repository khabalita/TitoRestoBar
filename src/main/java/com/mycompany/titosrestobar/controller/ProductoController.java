
package com.mycompany.titosrestobar.controller;

import com.mycompany.titosrestobar.model.Producto;
import com.mycompany.titosrestobar.model.ProductoNoElaborado;
import com.mycompany.titosrestobar.persistence.ProductoNoElaboradoPersistence;
import com.mycompany.titosrestobar.persistence.ProductoPersistence;

public class ProductoController {
    ProductoPersistence prodPersis = new ProductoPersistence();
    ProductoNoElaboradoPersistence prodNoElabPersis = new ProductoNoElaboradoPersistence();
    
    public void crearProductoElaborado(String nombre, String descripcion, Double costo, Double precio){
        Producto prod = new Producto();
        prod.setNombre(nombre);
        prod.setDescripcion(descripcion);
        prod.setCosto(costo);
        prod.setPrecio(precio);
        prodPersis.crearProducto(prod);
    }
    
    public void crearProductoNoElaborado(String nombre, String descripcion, Double costo, Double precio, Integer stock){
        ProductoNoElaborado prodNoElab = new ProductoNoElaborado();
        prodNoElab.setNombre(nombre);
        prodNoElab.setDescripcion(descripcion);
        prodNoElab.setCosto(costo);
        prodNoElab.setPrecio(precio);
        prodNoElab.setStock(stock);
        prodNoElabPersis.crearProductoNoElaborado(prodNoElab);
    }
}
