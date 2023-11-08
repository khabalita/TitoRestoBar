
package com.mycompany.titosrestobar.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id_producto; 
    @Basic
    private String nombre;
    private String descripcion;
    private Double costo;
    private Double precio;

    public Producto() {
    }

    public Producto(String nombre, String descripcion, Double costo, Double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
        this.precio = precio;
    }

    public int getId(){
        return id_producto;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{nombre=" + nombre + ", descripcion=" + descripcion + ", costo=" + costo + ", precio=" + precio + '}';
    }
    
    
    
    
}
