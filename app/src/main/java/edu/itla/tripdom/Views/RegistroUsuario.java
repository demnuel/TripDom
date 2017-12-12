package edu.itla.tripdom.Views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import edu.itla.tripdom.Entity.TipoUsuario;
import edu.itla.tripdom.Entity.Usuario;
import edu.itla.tripdom.R;
import edu.itla.tripdom.UsuarioActual;
import edu.itla.tripdom.dao.UsuarioDbo;

/**
 * Created by David on 24/11/2017.
 */

public class RegistroUsuario extends AppCompatActivity {

    private EditText txtid;
    private EditText txtNombre;
    private EditText txtTipoUs;
    private Button btnGuardar;
    private Button btnCancelar;
    private EditText txtDescripcion;
   // UsuarioDbo usuarioDbo;
    private Button btnListar;
    private  Usuario usuario;
    private static final String LOG_T = "RegistroUsuario";
    private UsuarioDbo usuarioDbo;

   // public  boolean guardar ()
    @Override
    protected void onCreate (Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
        setContentView(R.layout.activity_registro_usuario);

        txtid = (EditText) findViewById(R.id.txtId);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtTipoUs= (EditText) findViewById(R.id.txtTipoUs);
        btnCancelar= (Button) findViewById(R.id.btnCancelar);
        txtDescripcion = (EditText) findViewById(R.id.txtDescripcio);



        btnGuardar= (Button) findViewById(R.id.btnGuardar);
        btnListar = (Button) findViewById(R.id.btonListar);

        Bundle parametros= getIntent().getExtras();

        if (parametros!=null && parametros.containsKey("usuario")) {

            usuario = (Usuario) parametros.getSerializable("usuario");

            txtNombre.setText(usuario.getNombre());
            txtDescripcion.setText(usuario.getDescripcion());


        }

        usuarioDbo= new UsuarioDbo(this);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (usuario== null) {
                    //id = 0
                    usuario= new Usuario();
                }

                Usuario usuario= new Usuario();
                usuario.setNombre(txtNombre.getText().toString());
                usuario.setTipoUsuario(TipoUsuario.valueOf(txtTipoUs.getText().toString()));

                Log.i(LOG_T, "Registrando Usuario : " + usuario.toString());
                usuarioDbo.crear(usuario);
               // usuarioDbo.guardar(usuario);

               // usuario.setTipoUsuario(txtTipoUs.getText().toString());
            //  cv.put("TipoUsuario", String.valueOf(usuario.getTipoUsuario()));

              //  Usuario usuario = new Usuario();
               // usuario.setNombre(txtNombre.getText().toString());
            }
        });

       /** btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<Usuario> usuarios = usuarioDbo.buscar();

                for (Usuario u: usuarios) {
                    Log.i("ListUsuarios", u.toString());
                }

            }
        }); **/


        Button btnCambiar = (Button) findViewById(R.id.btonCambiar);

        btnCambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (usuario!=null && usuario.getId()> 0) {

                    UsuarioActual.setUsuario(usuario);

                } else {
                 Toast.makeText(RegistroUsuario.this, "Usuario no permitido o no existe",Toast.LENGTH_LONG);

                }

            }
        });


    }
}

