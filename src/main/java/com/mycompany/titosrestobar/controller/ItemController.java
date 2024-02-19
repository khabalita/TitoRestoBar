
package com.mycompany.titosrestobar.controller;

import com.mycompany.titosrestobar.model.Item;
import com.mycompany.titosrestobar.model.Pedido;
import com.mycompany.titosrestobar.model.Producto;
import com.mycompany.titosrestobar.persistence.ItemPersistence;

public class ItemController {
    ItemPersistence itemPersis = new ItemPersistence();
    

    public void editarItem(Integer id_item){
        itemPersis.buscarItemPorId(id_item);
    }
    
    public void eliminarItem(Integer id_item){
        itemPersis.eliminarItem(id_item);
    }
    public void agregarItem(Producto producto, Pedido pedido, Integer cantidad){
        Item item = new Item();
        item.setProd(producto);
        item.setCantidad(cantidad);
        item.setPedido(pedido);
        itemPersis.crearItem(item);
    }
}
