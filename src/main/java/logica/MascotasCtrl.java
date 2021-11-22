package logica;

import modelo.Mascota;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.shaded.commons.io.FilenameUtils;
import org.primefaces.shaded.commons.io.IOUtils;
import persistencia.MascotaDao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class MascotasCtrl {

    private MascotaDao mdao;
    private ArrayList<Mascota> mascotas;

    public MascotasCtrl() {
        cargarMascota();
    }

    public void cargarMascota(){
        mdao=new MascotaDao();
        mascotas=mdao.abrirArchivo();
    }

    public void actualizarPersistencia(){
        mdao=new MascotaDao();
        mdao.guardarArchivo(mascotas);
    }

    public boolean agregarMascota(Mascota miau){
        if(miau==null){
            return false;
        }
        if(mascotas.isEmpty()){
            cargarMascota();
        }else{
            for(int i=0;i<mascotas.size();i++){
                if(miau.getId()==mascotas.get(i).getId()){
                    return false;
                }
            }
        }
        if(mascotas==null) mascotas=new ArrayList<>();
        mascotas.add(miau);
        actualizarPersistencia();
        return true;
    }

    public Mascota buscarMascota(int id){
        if(mascotas==null){
            cargarMascota();
            return null;
        }
        for(int i=0;i<mascotas.size();i++){
            if(id==mascotas.get(i).getId()){
                return mascotas.get(i);
            }
        }
        return null;
    }




}