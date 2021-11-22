package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Mascota implements Serializable {

    private String nombre="";
    private int id;
    private String tipoAnimal="";
    private String foto="";
    private Date edad;
    private Date fechaAdopcion=null;


    public Mascota() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public String getFoto() {
        return foto;
    }

    public void setFotos(String foto) {
        this.foto = foto;
    }

    public Date getEdad() {
        return edad;
    }

    public void setEdad(Date edad) {
        this.edad = edad;
    }

    public Date getFechaAdopcion() {
        return fechaAdopcion;
    }

    public void setFechaAdopcion(Date fechaAdopcion) {
        this.fechaAdopcion = fechaAdopcion;
    }

    public double getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
