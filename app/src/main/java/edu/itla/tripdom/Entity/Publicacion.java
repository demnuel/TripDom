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

    private int Costo;

    public int getCosto() {
        return Costo;
    }

    public void setCosto(int costo) {
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
    private int Usuario_id;

    public int getUsuario_id() {
        return Usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        Usuario_id = usuario_id;
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
