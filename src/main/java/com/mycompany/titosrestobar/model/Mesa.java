package com.mycompany.titosrestobar.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Mesas")
public class Mesa implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id_mesa;
    
    @Column(name = "Num_mesas")
    private Integer num_mesa;
    
    @OneToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;
    
    //Constructores
    public Mesa() {
        
    }
    
    public Mesa(Integer num_mesa) {
        this.num_mesa = num_mesa;
    }
    
    public Integer getID_mesa(){
        return id_mesa;
    }

    public Integer getNum_mesa() {
        return num_mesa;
    }

    public void setNum_mesa(Integer num_mesa) {
        this.num_mesa = num_mesa;
    }
    
    public Pedido getPedido(){
        return pedido;
    }
    
    public void setPedido(Pedido pedido){
        this.pedido = pedido;
    }

  
        
}
