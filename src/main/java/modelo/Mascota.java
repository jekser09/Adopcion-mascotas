package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Mascota {

    private String nombre="";
    private String tipoAnimal="";
    private String raza="";
    private ArrayList vacunas;
    private ArrayList fotos;
    private ArrayList enfermedades;
    private int edad;
    private Date fechaAdopcion;
    private double id=0;

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

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public ArrayList getVacunas() {
        return vacunas;
    }

    public void setVacunas(ArrayList vacunas) {
        this.vacunas = vacunas;
    }

    public ArrayList getFotos() {
        return fotos;
    }

    public void setFotos(ArrayList fotos) {
        this.fotos = fotos;
    }

    public ArrayList getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(ArrayList enfermedades) {
        this.enfermedades = enfermedades;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
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

    public void setId(double id) {
        this.id = id;
    }
}
