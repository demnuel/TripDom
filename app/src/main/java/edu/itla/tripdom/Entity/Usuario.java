package edu.itla.tripdom.Entity;

import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by David on 14/11/2017.
 */

//Id, Nombre, TipoUsuario

public class Usuario extends AppCompatActivity{

    // ID DEL USUARIO
    public int Id;

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

    private TipoUsuario TipoUsuario;

    public edu.itla.tripdom.Entity.TipoUsuario getTipoUsuario() {
        return TipoUsuario;
    }

    public void setTipoUsuario(edu.itla.tripdom.Entity.TipoUsuario tipoUsuario) {
        TipoUsuario = tipoUsuario;
    }


   //CLAVE

    private String Clave;

    public String getClave() {
        return Clave;
    }

    public void setClave(String clave) {
        Clave = clave;
    }

    //EMAIL
    private String Email;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    //DESCRIPCION

    private String Descripcion;

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

  // ESTATUS
    private String Estatus;

    public String getEstatus() {
        return Estatus;
    }

    public void setEstatus(String estatus) {
        Estatus = estatus;
    }


     // CUPO
     private String Cupo;

    public String getCupo() {
        return Cupo;
    }

    public void setCupo(String cupo) {
        Cupo = cupo;
    }

    public String getOrigen() {
        return Origen;
    }

    public void setOrigen(String origen) {
        Origen = origen;
    }

    private String Origen;








   // private

}
