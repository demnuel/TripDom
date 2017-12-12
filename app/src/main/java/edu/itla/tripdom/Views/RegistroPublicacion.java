package edu.itla.tripdom.Views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import edu.itla.tripdom.Entity.Publicacion;
import edu.itla.tripdom.R;
import edu.itla.tripdom.dao.PublicacionDbo;

/**
 * Created by David on 30/11/2017.
 */

public class RegistroPublicacion extends AppCompatActivity{

    private TextView txtId;
    private EditText txtFecha;
    private EditText txtFechaViaje;
    private EditText txtEstado;
    private EditText txtCosto;
    private EditText txtIdUs;
    PublicacionDbo publicacionDbo;
    private  Button btnGuardar;
    private  Button btnCambiar;
    private Publicacion publicacion;

    @Override
    protected void onCreate (Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
        setContentView(R.layout.activity_registro_publicacion);

        txtId= (TextView) findViewById(R.id.txtId);
        txtCosto = (EditText) findViewById(R.id.txtCosto);
        txtFecha = (EditText) findViewById(R.id.txtFecha);
        txtEstado = (EditText) findViewById(R.id.txtEstado);
        txtFechaViaje = (EditText) findViewById(R.id.txtFechaViaje);

        publicacionDbo = new PublicacionDbo(this);

        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnCambiar = (Button) findViewById(R.id.btonCambiar);

        Bundle parametros = getIntent().getExtras();

        if(parametros!=null && parametros.containsKey("publicacion")) {

            publicacion = (Publicacion) parametros.getSerializable("publicacion");

            txtEstado.setText(publicacion.getEstado());
            txtCosto.setText(Double.valueOf(publicacion.getCosto()).toString());
        }

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (publicacion==null) {

                    publicacion= new Publicacion();

                }

                Publicacion publicacion = new Publicacion();
                publicacion.setEstado(txtEstado.getText().toString());
                publicacion.setCosto(Double.parseDouble(txtCosto.getText().toString()));
            }
        });

        btnCambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (publicacion!=null && publicacion.getId()> 0) {

                }
            }
        });


    }

}
