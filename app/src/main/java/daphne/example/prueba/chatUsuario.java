package daphne.example.prueba;

import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;



import javax.xml.transform.Result;

import daphne.example.prueba.adaptadores.adaptersMensajes;

public class chatUsuario extends AppCompatActivity {
/*
    private CircleImageView fotoPerfil;
    private TextView nombre;
    private RecyclerView mensajes;
    private EditText txt_mensajes;
    private Button btn_enviar;

    private ImageButton enviarfoto;

    //para la base de datos importante
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    //llamada a adaptersmensaje
    private adaptersMensajes adapter;
    //para poner archivos en base de datos

    private FirebaseStorage storage;
    private StorageReference storageReference;
    //para no olvidar el numero 1 que llama
    private static final int PHOTO_SEND = 1;
    private  static final int photo_perfil = 2;
    private String fotoPerfilCadena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_usuario);

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
      fotoPerfil = (CircleImageView) findViewById(R.id.fotoPerfil);
    //  nombre = (TextView) findViewById(R.id.nombre);
      mensajes = (RecyclerView)findViewById(R.id.mensajes);
      txt_mensajes = (EditText) findViewById(R.id.txt_mensajes);
      btn_enviar = (Button)findViewById(R.id.btn_enviar);
      enviarfoto = (ImageButton)findViewById(R.id.enviarfotos);

      fotoPerfilCadena = "";
//        FirebaseApp.initializeApp(this);
      //para referencial al la base de datos
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("chat");//sala de chat nombre donde se guarda los ms

       //aqui lo de archivos
        storage = FirebaseStorage.getInstance();


      adapter = new adaptersMensajes(this);
        LinearLayoutManager l = new LinearLayoutManager(this);
        mensajes.setLayoutManager(l);
        mensajes.setAdapter(adapter);

        //para poner un mensaje nuevo
        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //comentado por si acaso
               // adapter.addmensaje(new mensaje(txt_mensajes.getText().toString(), nombre.getText().toString(),"","1","00:00"));

                databaseReference.push().setValue(new mensajeEnviar(txt_mensajes.getText().toString(), nombre.getText().toString(),fotoPerfilCadena,"1", ServerValue.TIMESTAMP));
                //para limiar el mensaje
                txt_mensajes.setText("");
            }
        });
        //este sera el oyente de enviar foto en ensaje
        enviarfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                i.setType("image.jpeg");
                i.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
                startActivityForResult(Intent.createChooser(i,"Selecciona una foto"),PHOTO_SEND);
            }
        });
        //para cambiar la fot del mensaje el perfil

        fotoPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                i.setType("image.jpeg");
                i.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
                startActivityForResult(Intent.createChooser(i,"Selecciona una foto"),photo_perfil);

            }
        });
        //para evitar que la pantalla se llene de mensajes
        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                //este metodo es para llamar al isertar un objeto
                super.onItemRangeInserted(positionStart, itemCount);
                setScrollbar();
            }
        });
     //es para q se vea todos los mensaje
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                mensajeRecibir m =dataSnapshot.getValue(mensajeRecibir.class);
                adapter.addmensaje(m);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    private void setScrollbar(){
        mensajes.scrollToPosition(adapter.getItemCount()-1);
    }
    //para eviar foto
    //@Override

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PHOTO_SEND && resultCode == RESULT_OK){
            Uri u = data.getData();
            storageReference = storage.getReference("imagenes chat"); //imagenes del chat
             //aqui can=mbie storereference con datareferece
            final  StorageReference fotoReferencia = storageReference.child(u.getLastPathSegment());
            fotoReferencia.putFile(u).addOnSuccessListener(this, new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                  Uri u = taskSnapshot.getDownloadUrl();
                  mensajeEnviar m= new mensajeEnviar("usuario te envio un mensaje",u.toString(),nombre.getText().toString(),"","2",ServerValue.TIMESTAMP);
                  databaseReference.push().setValue(m);
                }
            });
        } else if (requestCode == photo_perfil && resultCode == RESULT_OK){

            Uri u = data.getData();
            storageReference = storage.getReference("foto_perfil"); //imagenes del chat
            //aqui can=mbie storereference con datareferece
            final StorageReference fotoReferencia = storageReference.child(u.getLastPathSegment());
            fotoReferencia.putFile(u).addOnSuccessListener(this, new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Uri u = taskSnapshot.getDownloadUrl();
                    fotoPerfilCadena = u.toString();
                    mensajeEnviar m= new mensajeEnviar("el usuario ha actualizado su foto de perfil",u.toString(),nombre.getText().toString(),fotoPerfilCadena,"2",ServerValue.TIMESTAMP);
                    databaseReference.push().setValue(m);
                    Glide.with(chatUsuario.this).load(u.toString()).into(fotoPerfil);
                }
            });
        }
    }
*/
}
