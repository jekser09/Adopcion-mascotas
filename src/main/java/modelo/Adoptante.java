package modelo;

public class Adoptante extends Usuario{

    private String direccion;
    private String foto;
    private double idMascota;

    public Adoptante() {
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }


    public double getIdMascota() {
        return idMascota;
    }


    public void setIdMascota(double id) {
        this.idMascota = id;
    }
}
