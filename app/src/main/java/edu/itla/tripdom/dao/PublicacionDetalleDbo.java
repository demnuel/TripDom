package edu.itla.tripdom.dao;

import android.app.DialogFragment;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.LinearLayout;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.DoubleToLongFunction;

import edu.itla.tripdom.Entity.Publicacion;
import edu.itla.tripdom.Entity.PublicacionDetalle;
import edu.itla.tripdom.Entity.Usuario;
import edu.itla.tripdom.Views.Listadapter.PublicacionListAdapter;

/**
 * Created by David on 30/11/2017.
 */

public class PublicacionDetalleDbo {

    private DbConnection connection;

    public PublicacionDetalleDbo(Context context) {
        connection = new DbConnection(context);
    }

    public void crear(PublicacionDetalle publicacionDetalle) {

        ContentValues cv = new ContentValues();
        cv.put("id", publicacionDetalle.getId());
        cv.put("lugar", publicacionDetalle.getLugar());
        cv.put("publicacionId", publicacionDetalle.getPublicacionId());


        SQLiteDatabase db = connection.getWritableDatabase();
        Long id = db.insert("publicacionDetalle", null, cv);

        publicacionDetalle.setId(id.intValue());

        db.close();

    }

    public List<PublicacionDetalle> buscar() {

        List<PublicacionDetalle> publicacionDetalles = new ArrayList<>();

        String columnas[] = new String[]{"id", "lugar", "publicacionId"};

        SQLiteDatabase db = connection.getReadableDatabase();

        Cursor cursor = db.query("publicacionDetalle", columnas, null, null, null, null, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {

            PublicacionDetalle pd = new PublicacionDetalle();
            pd.setId(cursor.getInt(cursor.getColumnIndex("id")));
            pd.setLugar(cursor.getString(cursor.getColumnIndex("lugar")));
            pd.setPublicacionId(cursor.getColumnIndex("publicacionId"));

            publicacionDetalles.add(pd);

            cursor.moveToNext();
        }

        cursor.close();
        db.close();

        return publicacionDetalles;

    }


}

