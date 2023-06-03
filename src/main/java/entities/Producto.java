package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Diego Alejandro Rubiano
 */
@Entity(name = "PRODUCTOS")
@Table(name = "PRODUCTOS")
public class Producto implements Serializable{
    @Id
    @Column(name = "ID_PRODUCTO")
    private int id_producto;
    @Column(name = "NOMBRE_PRODUCTO")
    private String nombre_producto;
    @Column(name = "PRECIO_PRODUCTO")
    private float precio_producto;
    @Column(name = "DESCRIPCION_PRODUCTO")
    private String descripcion_producto;

    public Producto() {
    }
    
    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public float getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(float precio_producto) {
        this.precio_producto = precio_producto;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }
}
