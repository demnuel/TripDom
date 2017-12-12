package edu.itla.tripdom.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import edu.itla.tripdom.Entity.TipoUsuario;
import edu.itla.tripdom.Entity.Usuario;

/**
 * Created by David on 26/11/2017.
 */


public class UsuarioDbo {

    private DbConnection connection;

    public UsuarioDbo(Context context) {
        connection = new DbConnection(context);
    }

    public boolean crear(Usuario usuario) {

            //TODO: CREA TODAS LAS TABLAS DE LA BASE DE DATOS CON EL PUBLIC VOID CREAR

            //   SQLiteDatabase db = connection.getWritableDatabase();

            ContentValues cv = new ContentValues();
            cv.put("Id", usuario.getId());
            cv.put("nombre", usuario.getNombre());
            cv.put("tipoUsuario", String.valueOf(usuario.getTipoUsuario()));
            cv.put("descripcion", usuario.getDescripcion());
            cv.put("estatus", usuario.getEstatus());
            cv.put("cupo", usuario.getCupo());
            cv.put("origen", usuario.getOrigen());
            cv.put("email", usuario.getEmail());
            //  cv.put("TipoUsuario", usuario.getTipoUsuario());
            // cv.put("UsuarioId", usuario.getTipoUsua);


            SQLiteDatabase db = connection.getWritableDatabase();

            if (usuario.getId() <= 0) {

                Long id = db.insert("usuario", null, cv);
                usuario.setId(id.intValue());
            } else {
                db.update("usuario", cv, "id = " + usuario.getId(), null);
            }




                //Long id =db.insert("usuario", null, cv);

                //usuario.setId(id.intValue());
                // preguntar si el parametro es diferente de nulo
                // if parametros!= null &&


                db.close();


            return true;


        }

        /** public boolean guardar (Usuario usuario) {
         ContentValues cv = new ContentValues();
         cv.put(Usuario.);
         } **/

        public List<Usuario> buscar () {
            //LISTA DONDE SE IRAN AGREGANDO LOS USUARIOS
            List<Usuario> usuarios = new ArrayList<>();

            //COLUMNA A BUSCAR EN LA BASE DE DATOS
            String columnas[] = new String[]{"id", "nombre", "email", "tipoUsuario", "cupo", "estatus", "origen"};

            //ABRIR CONEXION A LA BASE DE DATOS (SOLO LECURA)
            SQLiteDatabase db = connection.getReadableDatabase();

            //EJECUTAR LA COSNSULTS
            Cursor cursor = db.query("usuario", columnas, null, null, null, null, null);

            cursor.moveToFirst();

            while (!cursor.isAfterLast()) {

                Usuario u = new Usuario();
                u.setId(cursor.getInt(cursor.getColumnIndex("id")));
                u.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
                u.setEmail(cursor.getString(cursor.getColumnIndex("email")));
                u.setTipoUsuario(TipoUsuario.valueOf(cursor.getString(cursor.getColumnIndex("tipoUsuario"))));
                u.setCupo(cursor.getString(cursor.getColumnIndex("cupo")));
                u.setEstatus(cursor.getString(cursor.getColumnIndex("estatus")));
                u.setOrigen(cursor.getString(cursor.getColumnIndex("origen")));

                //AGREGAR ESTOS USUARIOS, A LA LISTA
                usuarios.add(u);


                cursor.moveToNext();
            }

            cursor.close();
            db.close();

            return usuarios;
        }
    }



