
package com.mycompany.titosrestobar.persistence;

import com.mycompany.titosrestobar.model.Producto;
import com.mycompany.titosrestobar.persistence.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {
    
    ProductoJpaController prodJpa = new ProductoJpaController();

    //Crear Producto
    public void crearProducto(Producto p) {
        prodJpa.create(p);
    }

    //Eliminar Productos
    public void eliminarProducto(int id_producto) {
        try {
            prodJpa.destroy(id_producto);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Modificar Producto
    public void editarProducto(Producto p) {
        try {
            prodJpa.edit(p);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Leer un Producto
    public Producto leerProducto(int id) {
        return prodJpa.findProducto(id);
    }
    
    //Leer una Lista de Productos
    public ArrayList<Producto> leerProductos(){
        List<Producto> productos = prodJpa.findProductoEntities();
        ArrayList<Producto> listaProductos = new ArrayList<Producto>(productos);
        
        return listaProductos;
    }
    
}
