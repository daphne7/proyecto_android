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

public class Registro extends AppCompatActivity {

    private EditText etn, eta,etco, etu, etc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
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
        etn = (EditText)findViewById(R.id.txt_nombre);
        eta = (EditText)findViewById(R.id.txt_apellido);
        etco =(EditText)findViewById(R.id.text_correo);
        etu =(EditText)findViewById(R.id.txt_usurio);
        etc = (EditText)findViewById(R.id.txt_password);
    }
     //metodo para el boton
    public void Registrar (View view){
        String nombre = etn.getText().toString();
        String apellido=eta.getText().toString();
        String correo=etco.getText().toString();
        String usuario=etu.getText().toString();
        String password=etc.getText().toString();


        //cmensaje para llenar el formulario
        if (nombre.length()==0){
            Toast.makeText(this, "debes llenar el campo del nombre",Toast.LENGTH_LONG).show();
        }if (apellido.length()==0){
            Toast.makeText(this,"debes llenar el campo del apellido",Toast.LENGTH_LONG).show();
        }if (correo.length()==0){
            Toast.makeText(this,"debes llenar el correo",Toast.LENGTH_LONG).show();
        }if (usuario.length()==0){
            Toast.makeText(this,"debes llenar el campo del usuario", Toast.LENGTH_LONG).show();
        }if (password.length()==0) {
            Toast.makeText(this, "debes llenar el campo de la contraseña", Toast.LENGTH_LONG).show();
        }if (nombre.length()!= 0 && nombre.length() != 0 &&apellido.length() != 0 && correo.length() != 0 && password.length() != 0){
            Toast.makeText(this,"registro en proceso...",Toast.LENGTH_LONG).show();
        }

    }

    //para el metodo del botton de nombre anterior
    public void btnanterior (View view){
        Intent btnanterior = new Intent(this, MainActivity.class);
        startActivity(btnanterior);
    }
}
