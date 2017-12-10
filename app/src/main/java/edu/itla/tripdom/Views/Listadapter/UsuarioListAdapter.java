package edu.itla.tripdom.Views.Listadapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import edu.itla.tripdom.Entity.Usuario;
import edu.itla.tripdom.R;

/**
 * Created by David on 03/12/2017.
 */

public class UsuarioListAdapter extends BaseAdapter {


    private Activity context;
    private List<Usuario> usuarios;

    public UsuarioListAdapter(Activity context, List<Usuario> usuarios) {
        this.context = context;
        this.usuarios = usuarios;
    }


    @Override
    public int getCount() {
        return usuarios.size();
    }

    @Override
    public Object getItem(int i) {
        return usuarios.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {

            LayoutInflater inflater = context.getLayoutInflater();
            view= inflater.inflate(R.layout.listview_usuario_row, null, true);

        }


        TextView lvEmail =(TextView) view.findViewById(R.id.txtEmail);
       TextView lvNombre = (TextView) view.findViewById(R.id.txtNombreUs);
        TextView lvTipoUs = (TextView) view.findViewById(R.id.txtTipoUs);


        Usuario u = usuarios.get(i);

       lvNombre.setText(u.getNombre());
        lvEmail.setText(u.getEmail());
        lvTipoUs.setText(u.getTipoUsuario().toString());


        return view;
    }
}
