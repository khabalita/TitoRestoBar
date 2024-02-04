
package com.mycompany.titosrestobar.persistence;

import com.mycompany.titosrestobar.model.Pedido;
import java.util.List;

public class PedidoPersistence extends PersistenceJpa<Pedido>{

    public PedidoPersistence() {
        super();
    }
    
    public void crearPedido(Pedido pedido){
        super.create(pedido);
    }
    
    public void editarPedido(Pedido pedido){
        super.update(pedido);
    }
    
    //primer verifica que el pedido con el id exista, luego llama a la funcion delete
    public void eliminarPedido(int id_pedido){
       Pedido pedido = em.find(Pedido.class, id_pedido);
       super.delete(pedido);
    }
    public Pedido buscarProductoPorId(Integer id_pedido){
        super.connect();
        Pedido pedido = em.find(Pedido.class, id_pedido);
        super.disconnect();
        return pedido;
    }
    //conecta a la base de datos, crea una query y la asigna a un listado de pedidos
    public List<Pedido> listarPedidos(int id_producto){
        super.connect();
        List<Pedido> pedidos = em.createNamedQuery("Pedido.listarPedidos").getResultList();
        super.disconnect();
        return pedidos;
    }
}
