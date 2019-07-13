package daphne.example.prueba;

import java.util.Map;

public class mensajeEnviar extends mensaje {
    private Map hora;


    public mensajeEnviar() {
    }

    public mensajeEnviar(Map hora) {
        this.hora = hora;
    }

    public mensajeEnviar(String menssaje, String nombre, String fotoPerfil, String type_mensaje, String urlfoto, Map hora) {
        super(menssaje, nombre, fotoPerfil, type_mensaje, urlfoto);
        this.hora = hora;
    }

    public mensajeEnviar(String menssaje, String nombre, String fotoPerfil, String type_mensaje, Map hora) {
        super(menssaje, nombre, fotoPerfil, type_mensaje);
        this.hora = hora;
    }

    public Map getHora() {
        return hora;
    }

    public void setHora(Map hora) {
        this.hora = hora;
    }
}
