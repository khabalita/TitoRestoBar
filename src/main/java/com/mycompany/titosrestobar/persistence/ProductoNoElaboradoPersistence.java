
package com.mycompany.titosrestobar.persistence;

import com.mycompany.titosrestobar.model.ProductoNoElaborado;
import java.util.List;


public class ProductoNoElaboradoPersistence extends PersistenceJpa<ProductoNoElaborado>{
    
    public ProductoNoElaboradoPersistence() {
        super();
    }
    
    public void crearProducto(ProductoNoElaborado producto){
        super.create(producto);
    }
    
    public void editarProducto(ProductoNoElaborado producto){
        super.update(producto);
    }
    
    public void eliminarProducto(Integer id_producto){
        ProductoNoElaborado producto = buscarProductoPorId(id_producto);
        super.delete(producto);
    }
    
    //devuelve un producto por id
    public ProductoNoElaborado buscarProductoPorId(Integer id_producto){
        super.connect();
        ProductoNoElaborado producto = em.find(ProductoNoElaborado.class, id_producto);
        super.disconnect();
        return producto;
    }
    
    //devuelve una lista de productos con el stock
    //PUEDE ESTAR REPETIDO - REVISAR
    public List<ProductoNoElaborado> listarTodosLosTipoDeProducto(){
        super.connect();
        List<ProductoNoElaborado> productos = em.createNamedQuery("ProductoNoElaborado.listarTodosLosTiposDeProductos", ProductoNoElaborado.class)
                .getResultList();
        super.disconnect();
        return productos;
    }
}
