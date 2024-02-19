
package com.mycompany.titosrestobar.controller;

import com.mycompany.titosrestobar.model.Producto;
import com.mycompany.titosrestobar.model.ProductoNoElaborado;
import com.mycompany.titosrestobar.persistence.ProductoNoElaboradoPersistence;
import com.mycompany.titosrestobar.persistence.ProductoPersistence;
import java.util.List;

public class ProductoController {
    
    ProductoPersistence prodPersis = new ProductoPersistence();
    ProductoNoElaboradoPersistence prodNoElabPersis = new ProductoNoElaboradoPersistence();
    
    //metodo para crear productos elaborados
    public void crearProducto(String nombre, String descripcion, Double costo, Double precio){
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setCosto(costo);
        producto.setPrecio(precio);
        prodPersis.crearProducto(producto);
    }
    
    //metodo para crear productos no elaborados
    public void crearProductoNoElaborado(String nombre, String descripcion, Double costo, Double precio, Integer stock){
        ProductoNoElaborado productoNoElaborado = new ProductoNoElaborado();
        productoNoElaborado.setNombre(nombre);
        productoNoElaborado.setDescripcion(descripcion);
        productoNoElaborado.setCosto(costo);
        productoNoElaborado.setPrecio(precio);
        productoNoElaborado.setStock(stock);
        prodPersis.crearProducto(productoNoElaborado);
    }
    
    //metodo para eliminar producto
    public void eliminarProducto(Integer id_producto) {
        prodPersis.eliminarProducto(id_producto);
    }
    
    //metodo para eliminar producto
    public void editarProducto(Producto producto, String nombre, String descripcion, Double costo, Double precio){
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setCosto(costo);
        producto.setPrecio(precio);
        prodPersis.editarProducto(producto);
    }
    
    //metodo que devuelve lista de productos a la tabla
    public List<Producto> traerTodosLosProductos(){
        return prodPersis.listarProductos();
    }
    
    //metodo que devuelve un producto por id
    public Producto traerProducto(Integer id_producto) {
        return prodPersis.buscarProductoPorId(id_producto);
    }
    /*
    public ProductoNoElaborado traerProductosNoElaborados(){
        return (ProductoNoElaborado) prodNoElabPersis.listarProductosNoElaborados();
    }
    */
    

    
}
