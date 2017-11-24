package edu.itla.tripdom.Entity;

import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by David on 14/11/2017.
 */

//Id, Nombre, TipoUsuario

public class Usuario extends AppCompatActivity{

     // ID DEL USUARIO
    private int Id;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    // NOMBRE
    private String Nombre;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    //TIPO

    private String TipoUsuario;

    public String getTipoUsuario() {
        return TipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        TipoUsuario = tipoUsuario;
    }
}
