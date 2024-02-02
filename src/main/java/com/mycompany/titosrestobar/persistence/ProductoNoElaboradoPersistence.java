
package com.mycompany.titosrestobar.persistence;

import com.mycompany.titosrestobar.model.ProductoNoElaborado;
import java.util.List;


public class ProductoNoElaboradoPersistence extends PersistenceJpa<ProductoNoElaborado> {
    
    public ProductoNoElaboradoPersistence(){
        super();
    }
    
    public void crearProductoNoElaborado(ProductoNoElaborado productoNoElaborado){
        super.create(productoNoElaborado);
    }
    
    public void editarProductoNoElaborado(ProductoNoElaborado productoNoElaborado){
        super.update(productoNoElaborado);
    }
    
    public void eliminarProductoNoElaborado(Integer id_producto){
        ProductoNoElaborado productoNoElaborado = buscarProductoNoElaboradoPorId(id_producto);
        super.delete(productoNoElaborado);
    }
    
    public ProductoNoElaborado buscarProductoNoElaboradoPorId(Integer id_producto){
        super.connect();
        ProductoNoElaborado productoNoElaborado = em.find(ProductoNoElaborado.class, id_producto);
        super.disconnect();
        return productoNoElaborado;
    }
    
    public List<ProductoNoElaborado> listarProductosNoElaborados(){
        super.connect();
        List<ProductoNoElaborado> productosNoElaborados = em.createNamedQuery
                            ("ProductosNoElaborados.listarProductosNoElaborados", 
                            ProductoNoElaborado.class).getResultList();
        super.disconnect();
        return productosNoElaborados;
    }
}
