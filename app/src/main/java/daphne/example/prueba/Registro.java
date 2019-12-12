package daphne.example.prueba;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import daphne.example.prueba.conexion.myData;

public class Registro extends AppCompatActivity {
    ArrayList<String> sexo;
    private EditText etn, eta, etco, etc,sex;
Button aceptar,cancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);  /*aqui*/
        setSpinner(); //para el sexo hombre o mujer

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Snackbar.make(view, "Registrando espere por favor", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                //para enviar el formulario
                sendData();
            }
        });


        etn = (EditText)findViewById(R.id.txt_nombre);
        eta = (EditText)findViewById(R.id.txt_apellido);
        etco =(EditText)findViewById(R.id.text_correo);
        //etu =(EditText)findViewById(R.id.txt_usuario);
        etc = (EditText)findViewById(R.id.txt_password);
        aceptar= findViewById(R.id.aceptar);
        cancelar= findViewById(R.id.cancelar);



       /* AsyncHttpClient registro= new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("txt_nombre", etn.getText().toString());
        params.add("txt_apellido", eta.getText().toString());
        params.add("txt_correo", etco.getText().toString());
        params.add("txt_password", etc.getText().toString());

        registro.post(myData.HOST_USER, params, new JsonHttpResponseHandler() {
                    public void onSucess(int statusCode, Header[] headers, JSONObject response) {
                        if (response.has("message")) {
                            Toast.makeText(Registro.this, "usuariooijoj", Toast.LENGTH_SHORT);
                        }
                    }


                    public void onFailure(int statusCode, Header[] headers, JSONObject response) {
                    }

                });
       */

                    //metodo para el boton
                /*    public void Registrar(View view) {
                        String nombre = etn.getText().toString();
                        String apellido = eta.getText().toString();
                        String correo = etco.getText().toString();
                        //String usuario=etu.getText().toString();
                        String password = etc.getText().toString();

                    }
                */
    }
    //para el envio de dato
    private void sendData(){

        EditText etn = findViewById(R.id.txt_nombre);
        EditText eta = findViewById(R.id.txt_apellido);
        EditText etco = findViewById(R.id.text_correo);
        EditText etc = findViewById(R.id.txt_password);
        Spinner sexs = findViewById(R.id.sex);



        AsyncHttpClient registro= new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("txt_nombre", etn.getText().toString());
        params.add("txt_apellido", eta.getText().toString());
        params.add("txt_correo", etco.getText().toString());
        params.add("txt_password", etc.getText().toString());

       //agregando parametros
        RequestParams params = new RequestParams();
        params.add("txt_nombre", etn.getText().toString());
        params.add("txt_apellido", eta.getText().toString());
        params.add("txt_correo", etco.getText().toString());
        params.add("txt_password", etc.getText().toString());
        params.add("sex", sexo.get(sexs.getSelectedItemPosition()));
        //para el envio
        registro.post(myData.HOST_USER, params, new JsonHttpResponseHandler() {

            public void onFailure(int statusCode, Header[] headers, JSONObject response) {


            }
            public void onSucess(int statusCode, Header[] headers, JSONObject response) {
                if (response.has("message")) {
                    Toast.makeText(Registro.this, "usuario registrado exitosamente", Toast.LENGTH_SHORT);
                    //llamada al login
                    Intent Login = new Intent(Registro.this, login.class);
                    startActivity(Login);
                }
            }
        });

    }

    //para el sexo hombre o mujer
    private void setSpinner() {
        ArrayList<String> sexo =new ArrayList<>();
        sexo.add("hombre");
        sexo.add("mujer");
        ArrayAdapter<String>adapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, sexo);
        Spinner spinner = findViewById(R.id.sex);
        spinner.setAdapter (adapter);
        //rescatando la posicion del adaptador
        spinner.setAdapter(adapter);
       // spinner.getSelectedItemPosition();


    }

    //cmensaje para llenar el formulario
     /*   if (nombre.length()==0){
            Toast.makeText(this, "debes llenar el campo del nombre",Toast.LENGTH_LONG).show();
        }if (apellido.length()==0){
            Toast.makeText(this,"debes llenar el campo del apellido",Toast.LENGTH_LONG).show();
        }if (correo.length()==0){
            Toast.makeText(this,"debes llenar el correo",Toast.LENGTH_LONG).show();
        }
        /*if (usuario.length()==0){
            Toast.makeText(this,"debes llenar el campo del usuario", Toast.LENGTH_LONG).show()};*/
      /*if (password.length()==0) {
            Toast.makeText(this, "debes llenar el campo de la contraseña", Toast.LENGTH_LONG).show();
        }if (nombre.length()!= 0 && nombre.length() != 0 &&apellido.length() != 0 && correo.length() != 0 && password.length() != 0){
            Toast.makeText(this,"registro en proceso...",Toast.LENGTH_LONG).show();
        }

    }
*/
    //para el metodo del botton de nombre anterior
    public void btnanterior (View view){
        Intent btnanterior = new Intent(this, login.class);
        startActivity(btnanterior);
    }

public void aceptar(View v){
        Intent aceptar = new Intent(this,miauapp.class);
        startActivity(aceptar);
        }
    }

/*    public void btnanterior (View view){
        Intent btnanterior = new Intent(this, MainActivity.class);
        startActivity(btnanterior);
    }
*/







