package com.mycompany.titosrestobar.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Productos")
//creo una sola tabla
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//asigno una columna para diferenciar los tipos de productos
@DiscriminatorColumn(
        name = "tipo",
        discriminatorType = DiscriminatorType.STRING
)
@NamedQueries({
    @NamedQuery(name = "Producto.listarProductos", query = "SELECT p FROM Producto p")
        //REVISAR ESTA QUERY
    //@NamedQuery(name = "Producto.listar", query = "SELECT p FROM Producto p")
})
public class Producto implements Serializable{
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id_producto;
    
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "Costo")
    private Double costo;
    @Column(name = "Precio")
    private Double precio;

    //Constructores
    public Producto() {
        
    }

    public Producto(String nombre, String descripcion, Double costo, Double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
        this.precio = precio;
    }

    public Integer getId_Producto(){
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
        return "Producto{" + "id_producto=" + id_producto + ", nombre=" + nombre + ", descripcion=" + descripcion + ", costo=" + costo + ", precio=" + precio + '}';
    }
    
    
    
}
