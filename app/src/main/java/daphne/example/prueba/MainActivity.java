package daphne.example.prueba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //para poner el icono en la parte superior   ic_laucher es el nombre del icono nombre por defecto
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

    }
    //metodo para el boton registrate ahora
    public void registrar(View view){
        Intent registrar = new Intent(this, Registro.class);
        startActivity(registrar);
    }
    //metodo para el boton YA ESTOY REGISTRADO
     public void iniciarSesion(View view){
        Intent iniciarSesion = new Intent(this, InciarSesion.class);
        startActivity(iniciarSesion);
     }

}
