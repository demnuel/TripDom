package edu.itla.tripdom.Views.Listadapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Objects;

import edu.itla.tripdom.Entity.Publicacion;
import edu.itla.tripdom.R;

/**
 * Created by David on 10/12/2017.
 */

public class PublicacionListAdapter extends BaseAdapter {

    private Activity context;
    private List<Publicacion> publicacions;

    public PublicacionListAdapter(Activity context, List<Publicacion> publicacions) {
        this.context = context;
        this.publicacions = publicacions;
    }

    @Override
    public  int getCount() {return  publicacions.size();}

    @Override
    public Object getItem (int i) {return publicacions.get(i);}

    @Override
    public  long getItemId (int i) {return  i;}

    @Override
    public View getView (int in, View view, ViewGroup viewGroup) {
        if (view == null) {

            LayoutInflater inflater = context.getLayoutInflater();
            view= inflater.inflate(R.layout.listview_publicacion_row, null, true);
        }

        TextView lvCosto = (TextView) view.findViewById(R.id.txtCosto);
        TextView lvEstado = (TextView) view.findViewById(R.id.txtEstado);
     //   TextView lvFecha = (TextView) view.findViewById(R.id.txtFecha);

        Publicacion p = publicacions.get(in); // LA VARIABLE NO ES I, DEBO DE AVERIGUAR PORQUE

        lvCosto.setText(Double.valueOf(p.getCosto()).toString());
        lvEstado.setText(p.getEstado());
       // lvFecha.setText(p.getFecha());

        return  view;
    }




}

