package daphne.example.prueba;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;

public class InciarSesion extends AppCompatActivity {

     EditText tus, tcs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inciar_sesion);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        loadComponents();


    }/**aqui anotar mas en registro**/
    public void loadComponents() {
        tus = (EditText) findViewById(R.id.email_txt);
        tcs = (EditText) findViewById(R.id.password_txt);
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("txt_usuario_sesion", tus.getText().toString());
        params.add("txt_password_sesion", tcs.getText().toString());
        //metodo para que el usuario y contrasena no queden en blanco

    }  public void irmiau (View v){
            Intent irmiau = new Intent(this, miauapp.class);
            startActivity(irmiau);
        }}
/*
    public void iniciarsesion (View v) {
     if (tus.getText().toString().isEmpty() || tcs.getText().toString().isEmpty()) {
            Toast.makeText(this, " pueden estar vacios", Toast.LENGTH_SHORT).show();
            return;
        }
        String email = tus.getText().toString();
        String password = tcs.getText().toString();
        AsyncHttpClient client = new AsyncHttpClient();

        RequestParams params = new RequestParams();
        params.put("email", email);
        params.put("password", password);


        final RequestHandle post = client.post(myData.HOST_USER_LOGIN, params, new JsonHttpResponseHandler() {
         @Override
            public void onSuccess(int statusCode, PreferenceActivity.Header[] headers, JSONObject response) {
                try {
                    String message = response.getString("message");
                    if (message != null) {
                        Toast.makeText(InciarSesion.this, message, Toast.LENGTH_SHORT).show();
                        myData.TOKEN = response.getString("token");
                        myData.USER_ID = response.getString("idUsuario");
                        if (response.getString("tipo") == "comprador") {
                            Intent Iniciarsesion = new Intent(InciarSesion.this, miauapp.class);
                            startActivity(Iniciarsesion);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, PreferenceActivity.Header[] headers, Throwable throwable, JSONObject errorResponse) {
                try {
                    if (errorResponse.getString("error") != null) {
                        Toast.makeText(InciarSesion.this, errorResponse.getString("error"), Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
*/