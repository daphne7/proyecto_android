package daphne.example.prueba;

public class mensajeRecibir extends mensaje {
    private Long hora;

    public mensajeRecibir() {
    }

    public mensajeRecibir(Long hora) {
        this.hora = hora;
    }

    public mensajeRecibir(String menssaje, String nombre, String fotoPerfil, String type_mensaje, String urlfoto, Long hora) {
        super(menssaje, nombre, fotoPerfil, type_mensaje, urlfoto);
        this.hora = hora;
    }

    public Long getHora() {
        return hora;
    }

    public void setHora(Long hora) {
        this.hora = hora;
    }
}
