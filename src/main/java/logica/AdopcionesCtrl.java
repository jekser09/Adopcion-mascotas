package logica;

import modelo.Formulario;
import modelo.SolicitudAdopcion;

import java.util.ArrayList;

public class AdopcionesCtrl {

    private ArrayList<SolicitudAdopcion> listaSolicitudes;
    private ArrayList<Formulario> formulariosPendientes;
    private SolicitudAdopcion adopciones=new SolicitudAdopcion();
    private Formulario formularios=new Formulario();

    public AdopcionesCtrl() {

    }

    public boolean llenarFormulario(){
        return false;
    }

    public boolean generarSolicitud(){
        return false;
    }

    public ArrayList<Formulario> buscarFormularios(){
        return null;
    }

    public Formulario buscarFormulario(double id){
        return null;
    }

    public ArrayList<SolicitudAdopcion> buscarSolicitudes(){
        return null;
    }

    public SolicitudAdopcion buscarSolicitud(double idMascota){
        return null;
    }

    public boolean aprobacionFormulario(double id){
        return false;
    }

    public boolean aprobacionAdopcion(double idMascota){
        return false;
    }
}
