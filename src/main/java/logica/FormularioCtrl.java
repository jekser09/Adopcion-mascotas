package logica;

import modelo.Formulario;
import persistencia.FormularioDao;

import java.text.Normalizer;
import java.util.ArrayList;

public class FormularioCtrl {

    ArrayList<Formulario> formularios;

    public FormularioCtrl(){
        cargarFormularios();
    }

    public void cargarFormularios(){
        FormularioDao arch=new FormularioDao();
        formularios=arch.abrirArchivo();
    }

    public void actualizarPersistencia(){
        FormularioDao arch=new FormularioDao();
        arch.guardarArchivo(formularios);
    }

    public boolean guardarFormulario(Formulario formulario){
        if(formulario==null){
            return false;
        }
        for(int i=0;i<formularios.size();i++){
            if(formulario.getIdAdoptante()==formularios.get(i).getIdAdoptante()){
                return true;
            }
        }
        formularios.add(formulario);
        actualizarPersistencia();
        return false;
    }

    public Formulario buscarFormulario(int id){
        if(formularios==null){
            return null;
        }
        for(int i=0;i<formularios.size();i++){
            if(formularios.get(i).getIdAdoptante()==id){
                return formularios.get(i);
            }
        }
        return null;
    }

}
