package daphne.example.prueba;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

  public class Abministrardatos extends SQLiteOpenHelper {

      public Abministrardatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
          super(context, name, factory, version);
      }

      @Override
      //cambiamosa de litedatobase BaseDeDatos
      public void onCreate(SQLiteDatabase BaseDeDatos) {
       //creacion de tabla donde se guardara los productos
          BaseDeDatos.execSQL("create table articulos(codigo int primary key, descripcion text, precio real)");
      }

      @Override
      public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

      }
  }
