package edu.itla.tripdom.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListViewCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import edu.itla.tripdom.Entity.Usuario;
import edu.itla.tripdom.R;
import edu.itla.tripdom.Views.Listadapter.UsuarioListAdapter;
import edu.itla.tripdom.dao.UsuarioDbo;

/**
 * Created by David on 03/12/2017.
 */

public class ListaUsuario extends AppCompatActivity {

    private  static final String LOG_T = ListaUsuario.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuario);

        UsuarioDbo usuarioDbo = new UsuarioDbo(this);
        List<Usuario> usuarios = usuarioDbo.buscar();

        Log.i(LOG_T, "Cantidad de usuarios =" + usuarios.size());

        ListView listView = (ListView) findViewById(R.id.ListaUsuario);

        listView.setAdapter(new UsuarioListAdapter(this, usuarios));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

              Usuario u = (Usuario)  adapterView.getItemAtPosition(i);
                Intent intent = new Intent(ListaUsuario.this, RegistroUsuario.class);
                intent.putExtra("usuario", u);

                startActivity(intent);
            }
        });

    }
}
