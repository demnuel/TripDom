package edu.itla.tripdom;

import android.app.Notification;
import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button btnUsuarios;
    Button BtonPublicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnUsuarios = (Button) findViewById(R.id.btnUsuarios);
        BtonPublicacion = (Button) findViewById(R.id.btonPublicacion);



        btnUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast mensaje = Toast.makeText(MainActivity.this, "Hola "+ txtNombre.getText(), Toast.LENGTH_LONG);
               // mensaje.show();

                Intent visualizar = new Intent(MainActivity.this , Visualizar2.class);
                visualizar.putExtra("nombre", btnUsuarios.getText().toString());
                startActivity(visualizar);
            }
        });



    }
}
