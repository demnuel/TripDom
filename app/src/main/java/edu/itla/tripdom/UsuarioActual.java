package edu.itla.tripdom;

import edu.itla.tripdom.Entity.Usuario;

/**
 * Created by David on 10/12/2017.
 */

public class UsuarioActual {
    private static Usuario USUARIO;

    public static Usuario getUsuario(){
        return USUARIO;
    }

    public static void setUsuario(Usuario usuario) {
        UsuarioActual.USUARIO  = usuario;
    }
}
