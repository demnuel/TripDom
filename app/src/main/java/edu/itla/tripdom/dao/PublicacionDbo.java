package edu.itla.tripdom.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import edu.itla.tripdom.Entity.Fecha;
import edu.itla.tripdom.Entity.Publicacion;

/**
 * Created by David on 28/11/2017.
 */

public class PublicacionDbo {

    private DbConnection connection;

    public PublicacionDbo(Context context) {connection = new DbConnection(context); }

    public void crear (Publicacion publicacion) {

        ContentValues cv = new ContentValues();
        cv.put("fecha", String.valueOf(publicacion.getFecha()));
        cv.put("costo", publicacion.getCosto());
        cv.put("descripcion", publicacion.getDescripcion());
        cv.put("estado", publicacion.getEstado());
        cv.put("origen", publicacion.getOrigen());


        SQLiteDatabase db = connection.getWritableDatabase();
        Long id = db.insert("publicacion", null, cv);

        publicacion.setId(id.intValue());
        db.close();
    }

    public List<Publicacion> buscar () {

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
            p.setUsuario_id(cursor.getInt(cursor.getColumnIndex("usuarioId")));

            publicacions.add(p);

            cursor.moveToNext();
        }

        cursor.close();
        db.close();

        return  publicacions;
    }

}
