
package com.mycompany.titosrestobar;

import com.mycompany.titosrestobar.controller.ProductoController;
import com.mycompany.titosrestobar.view.Principal;
import java.util.List;


public class TitosRestoBar {

    public static void main(String[] args) {
        
        //ProductoController prodControl = new ProductoController();
        //prodControl.crearProducto();
        
        
        //ejecuta ventana principal
        
        Principal principalView = new Principal();
        principalView.setVisible(true);
        principalView.setLocationRelativeTo(null);
    }
}
