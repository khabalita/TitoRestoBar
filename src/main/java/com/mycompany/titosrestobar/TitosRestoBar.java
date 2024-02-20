
package com.mycompany.titosrestobar;

import com.mycompany.titosrestobar.controller.ItemController;
import com.mycompany.titosrestobar.controller.MesaController;
import com.mycompany.titosrestobar.controller.PedidoController;
import com.mycompany.titosrestobar.controller.ProductoController;
import com.mycompany.titosrestobar.model.Item;
import com.mycompany.titosrestobar.model.Pedido;
import com.mycompany.titosrestobar.model.Producto;
import com.mycompany.titosrestobar.view.Principal;
import java.util.List;


public class TitosRestoBar {

    public static void main(String[] args) {
        
        /*Principal principalView = new Principal();
        principalView.setVisible(true);
        principalView.setLocationRelativeTo(null);
        */
        
        
        PedidoController pedidoControl = new PedidoController();
        ProductoController prodControl = new ProductoController();
        MesaController mesaControl = new MesaController();
        
        pedidoControl.crearPedido();
        Producto producto1 = prodControl.traerProducto(1);
        Pedido pedido = pedidoControl.traerPedidoActivo(Boolean.TRUE);
        Item item1 = new Item();
        item1.setProd(producto1);
        item1.setCantidad(2);
        item1.setPedido(pedido);
        item1.calcularSubTotal();
        Double subTotalItem1 = producto1.getPrecio();
        item1.setPrecio(subTotalItem1);
        
        pedidoControl.agregarItemsAlPedido(pedido.getId_pedido(), List.of(item1));
        

            List<Item> items = pedido.getItems();

            // Verifica si hay ítems en la lista
            if (!items.isEmpty()) {
                System.out.println("Items del pedido activo:");

                // Itera sobre la lista e imprime cada ítem
                for (Item item : items) {
                    System.out.println("Producto: " + item.getProd().getNombre());
                    System.out.println("Cantidad: " + item.getCantidad());
                    System.out.println("Subtotal: " + item.getPrecio());
                    System.out.println("------------------------");
                }
            } else {
                System.out.println("El pedido activo no tiene ítems.");
            }
            mesaControl.agregarPedidoALaMesa(1, pedido.getId_pedido());
            pedidoControl.detallePedido(pedido.getId_pedido());

        }

                
}
