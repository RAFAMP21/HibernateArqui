package com.demo.model.persistencia;
// Generated Oct 3, 2019, 11:56:53 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * Presentacion generated by hbm2java
 */
public class Presentacion  implements java.io.Serializable {


     private int idPresentacion;
     private String descripcion;
     private Set productos = new HashSet(0);

    public Presentacion() {
    }

	
    public Presentacion(int idPresentacion, String descripcion) {
        this.idPresentacion = idPresentacion;
        this.descripcion = descripcion;
    }
    public Presentacion(int idPresentacion, String descripcion, Set productos) {
       this.idPresentacion = idPresentacion;
       this.descripcion = descripcion;
       this.productos = productos;
    }
   
    public int getIdPresentacion() {
        return this.idPresentacion;
    }
    
    public void setIdPresentacion(int idPresentacion) {
        this.idPresentacion = idPresentacion;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy="presentacion")
    public Set getProductos() {
        return this.productos;
    }
    
    public void setProductos(Set productos) {
        this.productos = productos;
    }




}


