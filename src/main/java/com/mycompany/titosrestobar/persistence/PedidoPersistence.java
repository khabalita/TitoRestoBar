
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
    
    //primero verifica que el pedido con el id exista, luego llama a la funcion delete
    public void eliminarPedido(int id_pedido){
       Pedido pedido = em.find(Pedido.class, id_pedido);
       super.delete(pedido);
    }
    
    public Pedido buscarPedidoPorId(Integer id_pedido){
        super.connect();
        Pedido pedido = em.find(Pedido.class, id_pedido);
        super.disconnect();
        return pedido;
    }
    
    //conecta a la base de datos, crea una query y la asigna a un listado de pedidos
    public List<Pedido> listarPedidos(){
        super.connect();
        List<Pedido> pedidos = em.createNamedQuery("Pedido.listarPedidos")
                .getResultList();
        super.disconnect();
        return pedidos;
    }
    
    //conecta la base de datos, busca el pedido con el estado "true" y lo devuelve si lo encuentra
    public Pedido buscarPedidoActivo(Boolean estado) {
        super.connect();
        try {
            Pedido pedido = em.createNamedQuery("Pedido.buscarPedidoActivo",Pedido.class)
                    .setParameter("estado", Boolean.TRUE)
                    .getSingleResult();
            if (pedido != null && pedido.getEstado()) {
                return pedido;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error al buscar el pedido por estado: " + e.getMessage());
            return null;
        } finally {
        super.disconnect();
        }
        
    }

}
