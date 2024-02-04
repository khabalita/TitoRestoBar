
package com.mycompany.titosrestobar.persistence;

import com.mycompany.titosrestobar.model.Mesa;
import java.util.List;

public class MesaPersistence extends PersistenceJpa<Mesa>{
    
    public MesaPersistence(){
        super();
    }
    
    public void crearMesa(Mesa mesa){
        super.create(mesa);
    }
    
    public void editarMesa(Mesa mesa){
        super.update(mesa);
    }
    
    public void eliminarMesa(Integer id_mesa){
        Mesa mesa = buscarMesaPorId(id_mesa);
        super.delete(mesa);
    }
    
    public Mesa buscarMesaPorId(Integer id_mesa){
        super.connect();
        Mesa mesa = em.find(Mesa.class, id_mesa);
        super.disconnect();
        return mesa;
    }
    
    public List<Mesa> listarMesas(){
        super.connect();
        List<Mesa> mesas = em.createNamedQuery("Mesa.listarMesas", Mesa.class).getResultList();
        super.disconnect();
        return mesas;
    }
}
