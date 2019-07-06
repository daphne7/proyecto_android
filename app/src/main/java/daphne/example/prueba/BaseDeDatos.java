package daphne.example.prueba;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BaseDeDatos extends AppCompatActivity {

    private EditText bcp, bdp, bpp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_de_datos);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        bcp = (EditText) findViewById(R.id.txt_codigo);
        bdp = (EditText) findViewById(R.id.txt_descripcion);
        bpp = (EditText) findViewById(R.id.txt_precio);

    }

    //metodo para el boton
    public void BaseDeDatos(View view) {
        String codigo = bcp.getText().toString();
        String descripcion = bdp.getText().toString();
        String precio = bpp.getText().toString();

        // condicion de campo vacio
        if (codigo.length() == 0) {
            Toast.makeText(this, "debes llenar el campo del codigo del precio", Toast.LENGTH_LONG).show();
        }
        if (descripcion.length() == 0) {
            Toast.makeText(this, "debes llenar el campo del descripcion del producto", Toast.LENGTH_LONG).show();
        }
        if (precio.length() == 0) {
            Toast.makeText(this, "debes llenar el campo del precio del producto", Toast.LENGTH_LONG).show();
        }
        if (codigo.length() != 0 && descripcion.length() != 0 && precio.length() != 0) {
            Toast.makeText(this, "registro en proceso...", Toast.LENGTH_LONG).show();
        }

    }

    //metodo para dar de alta los productos
    public void RegistrarProductos(View view)
    {          //nombre de bd es administracion
        Abministrardatos admin = new Abministrardatos(this,"administracion", null, 1);
                                     // getReadableDatabase  dejara que la base de datos se habra en mmodo lectura y escritura
        SQLiteDatabase BaseDeDatos = admin.getReadableDatabase();
        //se trabajara con los datos
        String codigo = bcp.getText().toString();
        String descripcion = bdp.getText().toString();
        String precio = bpp.getText().toString();

        if(!codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty()){
            ContentValues registro =new ContentValues();
            registro.put("codigo", codigo);
            registro.put("descripcion", descripcion);
            registro.put("precio", precio);

            BaseDeDatos.insert("articulos", null, registro);


            BaseDeDatos.close();
            bcp.setText("");
            bdp.setText("");
            bpp.setText("");
            Toast.makeText(this,"Registro exitoso", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"debes llenar todos los espacios",Toast.LENGTH_SHORT).show();
        }
    }
     //metodo para consultar un pruducto o articulo

    public void Buscar(View view){
        Abministrardatos admin = new Abministrardatos
                 (this,"administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        //se recuperara el valor q se busca
        String codigo = bcp.getText().toString();
        if (!codigo.isEmpty()){
            Cursor fila = BaseDeDatos.rawQuery
                    ("select descripcion, precio from articulo where codigo="+codigo,
                            null);
            if(fila.moveToFirst()){
                bcp.setText(fila.getString(0));
                bpp.setText(fila.getString(1));
                BaseDeDatos.close();
            }else {
                Toast.makeText(this,"No existe el articulo", Toast.LENGTH_SHORT).show();
                BaseDeDatos.close();
            }
        } else{
            Toast.makeText(this, "debes introducir el codigo del articulo", Toast.LENGTH_SHORT).show();
        }

    }

    //metodo para eliminar un producto o articulo

    public void Eliminar(View view){
        Abministrardatos admin = new Abministrardatos
                (this,"administracion",null,1);
        SQLiteDatabase BaseDatabase = admin.getWritableDatabase();

        //recuperar el valor para identificar el producto
        String codigo = bcp.getText().toString();
        if (!codigo.isEmpty()){
            int cantidad = BaseDatabase.delete
             ("articulo", "codigo="+ codigo, null);
             BaseDatabase.close();

             //limpiar campos
            bcp.setText("");
            bdp.setText("");
            bpp.setText("");
        if (cantidad == 1){
            Toast.makeText(this,"el producto a sido eliminado exitosamente",
                    Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"el producto no existe",
                    Toast.LENGTH_SHORT).show();
        }

        }else {
            Toast.makeText
             (this, "debes introducir el codigo del articulo",
                     Toast.LENGTH_SHORT).show();
        }
    }
    //metodo para modificar un producto o articulo

    public void Modificar (View view){
        Abministrardatos admin = new Abministrardatos(this, "admintracion", null,1);
        SQLiteDatabase BaseDatabase = admin.getWritableDatabase();

        String codigo = bcp.getText().toString();
        String descripcion = bdp.getText().toString();
        String precio = bpp.getText().toString();

        if (!codigo.isEmpty() &&!descripcion.isEmpty() && !precio.isEmpty()){
           ContentValues registro = new ContentValues();
           registro.put("codigo", codigo);
           registro.put("descripcion",descripcion);
           registro.put("precio",precio);
           //se guardaran dentro de la base de datos
            int cantidad = BaseDatabase.update("articulo", registro, "codigo="+ codigo, null);
            BaseDatabase.close();

            //se vera si se modifico el producto
            if (cantidad == 1){
                Toast.makeText(this,"el articulo ha sido modificado correctamente", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this,"Debes llenar los campos todos los campos", Toast.LENGTH_SHORT).show();
            }

        } else {
        Toast.makeText(this,"debes llenar todos los campos",Toast.LENGTH_SHORT).show();
        }
    }
    //para el metodo del botton de nombre anterior

    public void btnanteriorbd (View view){
        Intent btnanteriorbd = new Intent(this, MainActivity.class);
        startActivity(btnanteriorbd);
    }

}