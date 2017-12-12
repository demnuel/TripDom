package edu.itla.tripdom.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.widget.LinearLayout;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.itla.tripdom.Entity.Fecha;
import edu.itla.tripdom.Entity.Publicacion;
import edu.itla.tripdom.Entity.Usuario;
import edu.itla.tripdom.UsuarioActual;

/**
 * Created by David on 28/11/2017.
 */

public class PublicacionDbo {

    private DbConnection connection;

    private static final SimpleDateFormat DF = new SimpleDateFormat("dd-MM-yyyy");

    public PublicacionDbo(Context context) {connection = new DbConnection(context); }

    public void crear (Publicacion publicacion) {

        //publicacion.setUsuario(UsuarioActual.getUsuario());
       // SQLiteDatabase db = connection.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("fecha", DF.format(publicacion.getFecha()));
      //  cv.put("fechaViaje", DF.format(publicacion.getFechaViaje()));
        cv.put("costo", publicacion.getCosto());
        cv.put("descripcion", publicacion.getDescripcion());
        cv.put("estado", publicacion.getEstado());
        cv.put("origen", publicacion.getOrigen());
        cv.put("usuarioId", UsuarioActual.getUsuario().getId());


        SQLiteDatabase db = connection.getWritableDatabase();
        Long id = db.insert("publicacion", null, cv);

        publicacion.setId(id.intValue());
        db.close();
    }

   /** public List<Publicacion> buscar () {

        List<Publicacion> publicacions = new ArrayList<>();

        String columnas[] = new String[] {"fecha", "costo", "descripcion", "estado","origen" };

        SQLiteDatabase db= connection.getReadableDatabase();

        Cursor cursor = db.query("publicacion", columnas, null, null, null, null, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()){

            Publicacion p = new Publicacion();
            p.setId(cursor.getInt(cursor.getColumnIndex("id")));
        //  p.setFecha(cursor.get(cursor.getColumnIndex("fecha")));
            p.setDescripcion(cursor.getString(cursor.getColumnIndex("descripcion")));
            p.setCosto(cursor.getInt(cursor.getColumnIndex("costo")));
            p.setEstado(cursor.getString(cursor.getColumnIndex("estado")));
           // p.setUsuario(Usuario(cursor.getInt(cursor.getColumnIndex())));
         //   p.setUsuario(cursor.getInt(cursor.getColumnIndex("usuarioId")));

            publicacions.add(p);

            cursor.moveToNext();
        }

        cursor.close();
        db.close();

        return  publicacions;
    } **/

    public List<Publicacion> getPublicaciones(){
        SQLiteDatabase db = connection.getReadableDatabase();

        ///es lo que quiero que muestre la consulta

        Cursor cursor = db.rawQuery("SELEECT p.*, u.nombre, u.email" +
                "FROM publicacion p INNER JOIN usuario u ON p.usuario_id = u.id", null);

        cursor.moveToNext();

        List<Publicacion> publicacions = new ArrayList<>();
        while (!cursor.isAfterLast()){
            Publicacion p = new Publicacion();
            Usuario u = new Usuario();

            try {
                p.setFecha(DF.parse(cursor.getString(cursor.getColumnIndex("fecha"))));
            } catch (ParseException ex) {
                p.setFecha(new Date());
            }

            u.setId(cursor.getInt(cursor.getColumnIndex("usuarioId")));
            u.setNombre("");
            u.setEmail("");

            p.setUsuario(u);

            //
            //

            publicacions.add(p);

            cursor.moveToNext();
        }
        return publicacions;
    }

}
