package edu.itla.tripdom.Entity;

import android.support.v7.app.AppCompatActivity;

import java.util.Date;

/**
 * Created by David on 14/11/2017.
 */

public class Publicacion extends AppCompatActivity {


     // ID
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // FECHA
    private Date Fecha;

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    // COSTO

    private Double Costo;

    public Double getCosto() {
        return Costo;
    }

    public void setCosto(Double costo) {
        Costo = costo;
    }





    // DESCRIPCION
    private String Descripcion;

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }


    // ESTADO
    private String Estado;

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    // USUARIO ID
    private Usuario Usuario;

    public edu.itla.tripdom.Entity.Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(edu.itla.tripdom.Entity.Usuario usuario) {
        Usuario = usuario;
    }


    // ORIGEN

    private String Origen;

    public String getOrigen() {
        return Origen;
    }

    public void setOrigen(String origen) {
        Origen = origen;
    }
}
