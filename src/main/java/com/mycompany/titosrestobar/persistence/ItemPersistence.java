
package com.mycompany.titosrestobar.persistence;

import com.mycompany.titosrestobar.model.Item;

public class ItemPersistence extends PersistenceJpa<Item>{
    
    public ItemPersistence(){
        super();
    }
    
    public void crearItem(Item item){
        super.create(item);
    }
    
    public void editarItem(Item item){
        super.update(item);
    }
    
    public void eliminarItem(Integer id_item){
        Item item = buscarItemPorId(id_item);
        super.delete(item);
    }
    
    public Item buscarItemPorId(Integer id_item){
        super.connect();
        Item item = em.find(Item.class, id_item);
        super.disconnect();
        return item;
    }
}
