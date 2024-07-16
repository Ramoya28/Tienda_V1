package com.tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data //especificar que es una capa de datos
@Entity //Esta clase esta enlazada a una tabla en la bd
@Table(name = "producto") //Especificar cual entidad
public class Producto implements Serializable {

    private static final long seriaVersionUID = 1L; // auto incremento en Java MySQL (AUTO_INCREMENT)  

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")

    private Long idProducto;
    private String detalle;
    private int existencias;
    private double precio;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;

    //private long idCategoria;
    
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    Categoria categoria;

    public Producto() {
    }

    public Producto(String producto, boolean activo) {
        this.descripcion = producto;
        this.activo = activo;
    }

}
