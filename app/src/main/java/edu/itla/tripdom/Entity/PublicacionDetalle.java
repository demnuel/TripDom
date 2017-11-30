package edu.itla.tripdom.Entity;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by David on 14/11/2017.
 */

public class PublicacionDetalle extends AppCompatActivity{

   // ID DE LA PUBLICACION DETALLE
    private int Id;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    // LUGAR
    private String Lugar;

    public String getLugar() {
        return Lugar;
    }

    public void setLugar(String lugar) {
        Lugar = lugar;
    }

    private String Descripcion;

    //Id de la Publicacion

    private int PublicacionId;

    public int getPublicacionId() {
        return PublicacionId;
    }

    public void setPublicacionId(int publicacionId) {
        PublicacionId = publicacionId;
    }




}
