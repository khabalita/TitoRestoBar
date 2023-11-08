
package com.mycompany.titosrestobar.model;

import com.mycompany.titosrestobar.persistence.ControladoraPersistencia;
import java.util.ArrayList;


public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    /*
    public void crearProducto(Producto p){
        controlPersis.crearProducto(p);
    }
    */
    
    public void eliminarProducto(int id_producto){
        controlPersis.eliminarProducto(id_producto);
    }
    
    public void editarProducto(Producto p){
        controlPersis.editarProducto(p);
    }
    
    public Producto leerProductoPorId(int id){
        return controlPersis.leerProducto(id);
    }
    
    public ArrayList<Producto> leerListaProductos(){
        return controlPersis.leerProductos();
    }

    public void crearProducto(String nombre, String descripcion, Double costo, Double precio) {
        Producto producto = new  Producto();
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setCosto(costo);
        producto.setPrecio(precio);
        
        controlPersis.crearProducto(producto);
    }

    public Producto traerProducto(int id_producto){
        return controlPersis.leerProducto(id_producto);
    }

    public void modificarProducto(Producto producto, String nombre, String descripcion, 
            Double costo, Double precio) {
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setCosto(costo);
        producto.setPrecio(precio);
        
        controlPersis.editarProducto(producto);
    }
}
