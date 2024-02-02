package com.mycompany.titosrestobar.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Mesas")
public class Mesa implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id_mesa;
    
    @Column(name = "Num_mesas")
    private Integer num_mesa;

    //Constructores
    public Mesa() {
        
    }

    public Mesa(Integer num_mesa) {
        this.num_mesa = num_mesa;
    }

    public Integer getNum_mesa() {
        return num_mesa;
    }

    public void setNum_mesa(Integer num_mesa) {
        this.num_mesa = num_mesa;
    }
    
    
        
}
