package daphne.example.prueba;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InciarSesion extends AppCompatActivity {

    private EditText tus, tcs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inciar_sesion);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        tus = (EditText) findViewById(R.id.txt_usuario_sesion);
        tcs = (EditText) findViewById(R.id.txt_password_sesion);
    }
    //metodo para que el usuario y contrasena no queden en blanco

    public void iniciarSesion(View view) {

        String Usuario = tus.getText().toString();
        String password = tcs.getText().toString();
        //mensaje para llenar el formulario
        if (Usuario.length() == 0) {
            Toast.makeText(this, "debes llenar el campo del usuario", Toast.LENGTH_LONG).show();
        }
        if (password.length() == 0) {
            Toast.makeText(this, "debes llenar el campo de la contraseña", Toast.LENGTH_LONG).show();
        }
        if (Usuario.length() != 0 && password.length() != 0) {
            Toast.makeText(this, "Ingresando...", Toast.LENGTH_LONG).show();
        }
    }

    //para el metodo del botton de nombre anterior
    public void btnanteriorsesion (View view){
        Intent btnanteriorsesion = new Intent(this, MainActivity.class);
        startActivity(btnanteriorsesion);
    }
}