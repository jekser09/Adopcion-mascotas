package logica;

import modelo.Solicitud;
import persistencia.SolicitudDao;

import java.util.ArrayList;

public class SolicitudCtrl {

    private ArrayList<Solicitud> solicitudes;

    public SolicitudCtrl() {
        cargarSolicitudes();
    }

    public void cargarSolicitudes(){
        SolicitudDao arch=new SolicitudDao();
        solicitudes=arch.abrirArchivo();
    }

    public void actualizarPersistencia(){
        SolicitudDao arch=new SolicitudDao();
        arch.guardarArchivo(solicitudes);
    }

    public boolean guardarSolicitud(Solicitud solicitud){
        if(solicitudes==null){
            return false;
        }
        for(int i=0;i<solicitudes.size();i++){
            if(solicitudes.get(i).getIdAdoptante()==solicitud.getIdAdoptante()){
                return false;
            }
        }
        solicitudes.add(solicitud);
        actualizarPersistencia();
        return true;
    }

    public Solicitud buscarSolicitud(int idAdoptante){
        if(solicitudes.isEmpty()){
            return null;
        }
        for(int i=0;i<solicitudes.size();i++){
            if(solicitudes.get(i).getIdAdoptante()==idAdoptante){
                return solicitudes.get(i);
            }
        }
        return null;
    }

    public boolean aprobarSolicitud(int idAdoptante,boolean aprobar){
        if(solicitudes.isEmpty()){
            return false;
        }
        for(int i=0;i<solicitudes.size();i++){
            if(solicitudes.get(i).getIdAdoptante()==idAdoptante){
                Solicitud solicitud=solicitudes.get(i);
                solicitud.setAprueba(aprobar);
                solicitudes.set(i,solicitud);
                actualizarPersistencia();
                return true;
            }
        }
        return false;
    }
}
