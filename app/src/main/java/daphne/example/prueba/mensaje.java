package daphne.example.prueba;

public class mensaje {
    private String menssaje;
    private String nombre;
    private String fotoPerfil;
    private String type_mensaje;
    //private String hora;
    private String urlfoto;

    public mensaje() {
    }

    public mensaje(String menssaje, String nombre, String fotoPerfil, String type_mensaje) {
        this.menssaje = menssaje;
        this.nombre = nombre;
        this.fotoPerfil = fotoPerfil;
        this.type_mensaje = type_mensaje;
        //this.hora = hora;
    }
    //aqui parametros para foto

    public mensaje(String menssaje, String nombre, String fotoPerfil, String type_mensaje, String urlfoto) {
        this.menssaje = menssaje;
        this.nombre = nombre;
        this.fotoPerfil = fotoPerfil;
        this.type_mensaje = type_mensaje;
        this.urlfoto = urlfoto;
    }

    public String getMenssaje() {
        return menssaje;
    }

    public void setMenssaje(String menssaje) {
        this.menssaje = menssaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getType_mensaje() {
        return type_mensaje;
    }

    public void setType_mensaje(String type_mensaje) {
        this.type_mensaje = type_mensaje;
    }

    //public String getHora() {
    //return Hora;}

    //public void setHora(String hora) {this.hora = hora;}

    public String getUrlfoto() {
        return urlfoto;
    }

    public void setUrlfoto(String urlfoto) {
        this.urlfoto = urlfoto;
    }
}
