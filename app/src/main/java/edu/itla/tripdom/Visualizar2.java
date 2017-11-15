package edu.itla.tripdom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Visualizar2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar2);

        Bundle parametros = getIntent().getExtras();
        TextView txtVisualizarNombre = (TextView) findViewById(R.id.txtVisualizarNombre);
        txtVisualizarNombre.setText(parametros.getString("nombre"));
    }
}
