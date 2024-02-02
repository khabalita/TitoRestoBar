
package com.mycompany.titosrestobar;

import com.mycompany.titosrestobar.model.Producto;
import com.mycompany.titosrestobar.model.ProductoNoElaborado;
import com.mycompany.titosrestobar.persistence.ProductoNoElaboradoPersistence;
import com.mycompany.titosrestobar.persistence.ProductoPersistence;


public class TitosRestoBar {

    public static void main(String[] args) {
    
        Producto prod = new Producto();
        ProductoNoElaborado prodNoElab = new ProductoNoElaborado();
        ProductoPersistence prodPersis = new ProductoPersistence();
        ProductoNoElaboradoPersistence prodNoPersis = new ProductoNoElaboradoPersistence();
        
        prod.setNombre("cafe");
        prod.setDescripcion("descafeinado");
        prod.setCosto(100.00);
        prod.setPrecio(150.00);
        prodPersis.crearProducto(prod);
        
        prodNoElab.setNombre("Torta Negra");
        prodNoElab.setDescripcion("facturita");
        prodNoElab.setCosto(100.00);
        prodNoElab.setPrecio(500.00);
        prodNoElab.setStock(10);
        prodNoPersis.crearProductoNoElaborado(prodNoElab);
        
    }
}
