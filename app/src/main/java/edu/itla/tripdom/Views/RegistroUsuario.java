package edu.itla.tripdom.Views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import edu.itla.tripdom.Entity.TipoUsuario;
import edu.itla.tripdom.Entity.Usuario;
import edu.itla.tripdom.R;
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
    UsuarioDbo usuarioDbo;
    private Button btnListar;

    @Override
    protected void onCreate (Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
        setContentView(R.layout.activity_registro_usuario);

        txtid = (EditText) findViewById(R.id.txtId);
        txtNombre = (EditText) findViewById(R.id.TxtNombre);
        txtTipoUs= (EditText) findViewById(R.id.txtTipoUs);
        btnCancelar= (Button) findViewById(R.id.btnCancelar);

        usuarioDbo= new UsuarioDbo(this  );

        btnGuardar= (Button) findViewById(R.id.BtnGuardar);
        btnListar = (Button) findViewById(R.id.btonListar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario usuario= new Usuario();
                usuario.setNombre(txtNombre.getText().toString());
                usuario.setTipoUsuario(TipoUsuario.valueOf(txtTipoUs.getText().toString()));
               // usuario.setTipoUsuario(txtTipoUs.getText().toString());
            //  cv.put("TipoUsuario", String.valueOf(usuario.getTipoUsuario()));

              //  Usuario usuario = new Usuario();
               // usuario.setNombre(txtNombre.getText().toString());
            }
        });

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<Usuario> usuarios = usuarioDbo.buscar();

                for (Usuario u: usuarios) {
                    Log.i("ListUsuarios", u.toString());
                }

            }
        });


    }
}

