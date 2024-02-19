
package com.mycompany.titosrestobar.controller;

import com.mycompany.titosrestobar.model.Mesa;
import com.mycompany.titosrestobar.persistence.MesaPersistence;
import java.util.List;

public class MesaController {
    MesaPersistence mesaPersis = new MesaPersistence();
    
    public void crearMesa(Integer num_mesa){
        Mesa mesa = new Mesa();
        mesa.setNum_mesa(num_mesa);
        mesaPersis.crearMesa(mesa);
    }
    
    public void eliminarMesa(Integer id_mesa){
        mesaPersis.eliminarMesa(id_mesa);
    }
    
    public void modificarMesa(Mesa mesa){
        mesaPersis.editarMesa(mesa);
    }
    public Mesa traerMesa(Integer id_mesa){
        return mesaPersis.buscarMesaPorId(id_mesa);
    }
    public List<Mesa> traerTodasLasMesas() {
        return mesaPersis.listarMesas();
    }
}
