
package com.mycompany.titosrestobar.controller;

import com.mycompany.titosrestobar.model.Item;
import com.mycompany.titosrestobar.model.Pedido;
import com.mycompany.titosrestobar.model.Producto;
import com.mycompany.titosrestobar.persistence.PedidoPersistence;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class PedidoController {
    PedidoPersistence pedidoPersis = new PedidoPersistence();
    ProductoController prodControl = new ProductoController();
    ItemController itemControl = new ItemController();
    
    public void crearPedido(){
        Pedido pedido = new Pedido();
        //obtengo fecha actual
        LocalDateTime horaInicio = LocalDateTime.now();
        //convierto LocalDate a Date para poder persistirlo en la base de datosw
        Date fechaInicio = Date.from(horaInicio.atZone(ZoneId.systemDefault()).toInstant());
        pedido.setFechaInicio(fechaInicio);
        //pedido.setFechaCierre(null);
        pedido.setEstado(Boolean.TRUE);
        pedido.setDescuento(0.00);
        pedido.setSubTotal(0.00);
        pedido.setValorTotal(0.00);
        pedidoPersis.crearPedido(pedido);
    }
    
    //metodo para editar pedido
    public void editarPedido(Integer id_pedido){
        pedidoPersis.buscarPedidoPorId(id_pedido);
    }
    
    //metodo para eliminar un pedido
    public void eliminarPedido(Integer id_pedido){
        pedidoPersis.eliminarPedido(id_pedido);
    }
    
    //metodo para buscar un pedido
    public Pedido buscarPedidoPorId(Integer id_pedido){
        return pedidoPersis.buscarPedidoPorId(id_pedido);
    }
    
    //metodo para agregar items a un pedido
    public void agregarItemsAlPedido(Integer id_pedido, List<Item> items) {
        Pedido pedido = pedidoPersis.buscarPedidoPorId(id_pedido);

        if (pedido != null) {
            for (Item item : items) {
                item.setPedido(pedido);
            }

            pedido.getItems().addAll(items);
            System.out.println("items agregados correctamente");

            // Actualizar el pedido en la base de datos
            pedidoPersis.editarPedido(pedido);
        } else {
            System.out.println("Pedido no encontrado");
        }
    }
    
    //trae el pedido activo (parametro estado)
    public Pedido traerPedidoActivo(Boolean estado){
        return pedidoPersis.buscarPedidoActivo(estado);
    }
    
    //metodo para cerrar el pedido
    public void cerrarPedido(Integer id_pedido) {
        Pedido pedido = pedidoPersis.buscarPedidoPorId(id_pedido);

        if (pedido != null) {
            pedido.setEstado(false);
            LocalDateTime horaCierre = LocalDateTime.now();
            //convierto LocalDate a Date para poder persistirlo en la base de datosw
            Date fechaCierre = Date.from(horaCierre.atZone(ZoneId.systemDefault()).toInstant());
            pedido.setFechaCierre(fechaCierre);
            
            pedidoPersis.editarPedido(pedido);
        } else {
            System.out.println("Pedido no encontrado");
        }
    }
    
    //metodo para generar el detalle del pedido
    public void traerDetallePedidoCerrado(Integer id_pedido) {
    Pedido pedidoCerrado = pedidoPersis.buscarPedidoPorId(id_pedido);

    if (pedidoCerrado != null && !pedidoCerrado.getItems().isEmpty()) {
        System.out.println("Detalle del pedido cerrado:");
        
        for (Item item : pedidoCerrado.getItems()) {
            System.out.println("Producto: " + item.getProd().getNombre());
            System.out.println("Cantidad: " + item.getCantidad());
            System.out.println("Subtotal: " + item.getPrecio());
            System.out.println("------------------------");
        }
    } else {
        System.out.println("No se encontró el pedido cerrado o no tiene ítems.");
        }
    }
    
    //metodo para traer el detalle pedido
    public void detallePedido(Integer id_pedido){
        cerrarPedido(id_pedido);
        traerDetallePedidoCerrado(id_pedido);
    }
    
}
