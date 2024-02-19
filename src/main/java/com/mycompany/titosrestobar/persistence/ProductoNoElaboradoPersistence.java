
package com.mycompany.titosrestobar.persistence;

import com.mycompany.titosrestobar.model.Producto;
import com.mycompany.titosrestobar.model.ProductoNoElaborado;
import java.util.List;


public class ProductoNoElaboradoPersistence extends PersistenceJpa<ProductoNoElaborado>{
    
    public ProductoNoElaboradoPersistence(){
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
    public ProductoNoElaborado buscarProductoPorId(Integer id_producto){
        super.connect();
        ProductoNoElaborado producto = em.find(ProductoNoElaborado.class, id_producto);
        super.disconnect();
        return producto;
    }
}
