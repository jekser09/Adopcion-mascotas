package modelo;

import java.io.Serializable;

public class Solicitud implements Serializable {
    private int idAdoptante;
    private String nombreAdopta;
    private int idMascota;
    private String nombreMascota;
    private boolean aprueba=false;

    public Solicitud() {
    }

    public String getNombreAdopta() {
        return nombreAdopta;
    }

    public void setNombreAdopta(String nombreAdopta) {
        this.nombreAdopta = nombreAdopta;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public int getIdAdoptante() {
        return idAdoptante;
    }

    public void setIdAdoptante(int idAdoptante) {
        this.idAdoptante = idAdoptante;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public boolean isAprueba() {
        return aprueba;
    }

    public void setAprueba(boolean aprueba) {
        this.aprueba = aprueba;
    }
}
