
package com.mycompany.titosrestobar.controller;

import com.mycompany.titosrestobar.model.Mesa;
import com.mycompany.titosrestobar.persistence.MesaPersistence;
import java.util.Scanner;

public class MesaController {
    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    MesaPersistence mesaPersis = new MesaPersistence();
    
    public void crearMesa(){
        Mesa mesa = new Mesa();
        System.out.println("Ingrese la mesa");
        System.out.println("numero de mesa");
        Integer numero= sc.nextInt();
        mesa.setNum_mesa(numero);
        
        mesaPersis.crearMesa(mesa);
        
    }
}
