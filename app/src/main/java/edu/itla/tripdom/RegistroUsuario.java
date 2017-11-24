package edu.itla.tripdom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.itla.tripdom.Entity.Usuario;

/**
 * Created by David on 24/11/2017.
 */

public class RegistroUsuario extends AppCompatActivity {

    private EditText txtid;
    private EditText txtNombre;
    private EditText txtTipoUs;
    private Button btnGuardar;
    private Button btnCancelar;

    @Override
    protected void onCreate (Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
        setContentView(R.layout.activity_registro_usuario);

        txtid = (EditText) findViewById(R.id.txtId);
        txtNombre = (EditText) findViewById(R.id.TxtNombre);
        txtTipoUs= (EditText) findViewById(R.id.txtTipoUs);
        btnCancelar= (Button) findViewById(R.id.btnCancelar);
        btnGuardar= (Button) findViewById(R.id.BtnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario usuario= new Usuario();
                usuario.setNombre(txtNombre.getText().toString());
                usuario.setTipoUsuario(txtTipoUs.getText().toString());
            }
        });
    }
}

