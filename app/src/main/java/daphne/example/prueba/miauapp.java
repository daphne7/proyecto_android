package daphne.example.prueba;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.HashMap;

import daphne.example.prueba.fragmentos.amigos;
import daphne.example.prueba.fragmentos.anuncios;
import daphne.example.prueba.fragmentos.citas;
import daphne.example.prueba.fragmentos.favoritos;

public class miauapp extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        daphne.example.prueba.fragmentos.anuncios.OnFragmentInteractionListener,
        daphne.example.prueba.fragmentos.citas.OnFragmentInteractionListener,
        daphne.example.prueba.fragmentos.favoritos.OnFragmentInteractionListener,
        daphne.example.prueba.fragmentos.amigos.OnFragmentInteractionListener {

    amigos amigos;
    favoritos favoritos;
    anuncios anuncios;
    citas citas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miauapp);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //perfil perfil;
        anuncios = new anuncios();
        favoritos = new favoritos();
        amigos = new amigos();
        citas = new citas();
        //perfil= new perfil();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor, anuncios).commit();


 /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    });

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
}
*/
        @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.miauapp, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //PARA ENLAZARA BARRA IZQUIERDA
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.calendario) {
            // Handle the camera action
        } else if (id == R.id.configuracion) {

        } else if (id == R.id.galeria) {
            Intent publicar = new Intent(this, BaseDeDatos.class);
            startActivity(publicar);
        } else if (id == R.id.noticias) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.enviar) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


 /*   @Override
    public void onFragmentInteraction(Uri uri) {

    }
}*/



        public void onClick(View v) {

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            switch (v.getId()) {
                case R.id.anuncios:
                    transaction.replace(R.id.contenedor, anuncios);
                    break;

                case R.id.favoritos:
                    transaction.replace(R.id.contenedor, favoritos);
                    break;

                case R.id.amigos:
                    transaction.replace(R.id.contenedor, amigos);
                    break;

                case R.id.citas:
                    transaction.replace(R.id.contenedor, citas);
                    break;
      /*      case R.id.btnperfil:
                transaction.replace(R.id.contenedoroficial,perfil);*/
            }
            transaction.commit();

        }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
};




