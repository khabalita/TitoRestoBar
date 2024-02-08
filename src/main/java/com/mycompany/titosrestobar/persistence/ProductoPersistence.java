
package com.mycompany.titosrestobar.persistence;

import com.mycompany.titosrestobar.model.Producto;
import java.util.List;

//<Producto> hace referencia a un object <T> generico
public class ProductoPersistence extends PersistenceJpa<Producto>{

    public ProductoPersistence() {
        super();
    }
    
    public void crearProducto(Producto producto){
        super.create(producto);
    }
    
    public void editarProducto(Producto producto){
        super.update(producto);
    }
    
    public void eliminarProducto(Integer id_producto){
        Producto producto = buscarProductoPorId(id_producto);
        super.delete(producto);
    }
    
    //devuelve un producto por id
    public Producto buscarProductoPorId(Integer id_producto){
        super.connect();
        Producto producto = em.find(Producto.class, id_producto);
        super.disconnect();
        return producto;
        
    }
     
    //devuelve una lista de productos
    public List<Producto> listarProductos(){
        super.connect();
        List<Producto> productos = em.createNamedQuery("Producto.listarProductos", Producto.class)
                .getResultList();
        super.disconnect();
        return productos;
    }
}
