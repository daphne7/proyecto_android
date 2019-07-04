package daphne.example.prueba.datainfos;

public class dataAnuncios {
    private Integer img;
    private String title;
    private String descripcion;

    public dataAnuncios(String title, String descripcion, int img) {
        this.title=title;
        this.descripcion=descripcion;
        this.img=img;
    }

    public Integer getImg() {
        return img;
    }

    public void setImg(Integer img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
