
package com.mycompany.titosrestobar.controller;

import com.mycompany.titosrestobar.model.Pedido;
import com.mycompany.titosrestobar.persistence.PedidoPersistence;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class PedidoController {
    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    PedidoPersistence pedidoPersis = new PedidoPersistence();
    
    public void crearPedido(){
        Pedido pedido = new Pedido();
        pedido.setFechaInicio(crearHora(15,30));
        pedido.setFechaCierre(crearHora(16,30));
        pedido.setEstado(Boolean.TRUE);
        pedido.setDescuento(0.00);
        pedido.setSubTotal(0.00);
        pedido.setValorTotal(0.00);
        pedidoPersis.crearPedido(pedido);
    }
    
    
    private Date crearHora(int horas, int minutos){
        LocalTime hora = LocalTime.of(horas, minutos);
        Date fecha = Date.from(hora.atDate(LocalDate.now()).atZone(ZoneId.systemDefault()).toInstant());
        return fecha;    
    }
}
