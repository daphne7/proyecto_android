package daphne.example.prueba;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import daphne.example.prueba.conexion.myData;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Enviando solicitud", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                sendLogin();
            }
        });
    }
     private void sendLogin(){
         final EditText email = findViewById(R.id.email_txt);
         EditText password = findViewById(R.id.password_txt);
         //para poner en nombre del usuario de bienvenida
         final TextView welcome = findViewById(R.id.welcome);
         welcome.setVisibility(View.GONE);

         AsyncHttpClient client = new AsyncHttpClient();
         RequestParams params = new RequestParams();
         params.add("email",email.getText().toString());
         params.add("password",password.getText().toString());
         client.post(myData.LOGIN_SERVICE,params, new JsonHttpResponseHandler(){

             public void onSucess(int statusCode, Header[] headers, JSONObject response) {
                 if (response.has("token")) {
                     //myData.TOKEN = response.getString("token");
                     try {
                          myData.TOKEN = response.getString("token");
                         Toast.makeText(login.this, "usuario logueado con exito",Toast.LENGTH_SHORT);
                         //recibira la bienvenida welcome
                         welcome.setVisibility(View.VISIBLE);
                         welcome.setText("Bienvenido"+ email.getText());
                     } catch (JSONException e) {
                         e.printStackTrace();
                     }
                     //Toast.makeText(Registro.this, "usuario registrado exitosamente", Toast.LENGTH_SHORT);
                     //llamada al login
                     //Intent Login = new Intent(Registro.this, login.class);
                     //startActivity(Login);
                 }
             }

                 });
     }
}
