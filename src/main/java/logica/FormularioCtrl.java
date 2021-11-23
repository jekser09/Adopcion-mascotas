package logica;

import modelo.Formulario;
import persistencia.FormularioDao;
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
                return false;
            }
        }
        formularios.add(formulario);
        actualizarPersistencia();
        return true;
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

    public boolean aprobarForm(int idAdoptante,boolean aprobar){
        if(formularios.isEmpty()){
            return false;
        }

        for(int i=0;i<formularios.size();i++){
            if(formularios.get(i).getIdAdoptante()==idAdoptante){
                Formulario formulario=formularios.get(i);
                formulario.setAprobar(aprobar);
                formularios.set(i,formulario);
                actualizarPersistencia();
                return true;
            }
        }
        return false;
    }
}
