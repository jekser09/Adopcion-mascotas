package co.edu.ucentral.ingsf.springprime.bean;

import logica.FormularioCtrl;
import lombok.Getter;
import lombok.Setter;
import modelo.Formulario;
import org.springframework.stereotype.Component;
import persistencia.FormularioDao;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

@Component
@ManagedBean
@ViewScoped
@Getter
@Setter
@RequestScoped
public class ListaFormulariosBean implements Serializable {
    List<Formulario> formularios;
    FormularioDao arch;
    public ListaFormulariosBean(){
        arch=new FormularioDao();
        formularios=arch.abrirArchivo();
    }
    @PostConstruct
    public void act(){
        arch=new FormularioDao();
        formularios=arch.abrirArchivo();
    }


    public void aprobar(int id){
        FormularioCtrl ctrl=new FormularioCtrl();
        if(ctrl.aprobarForm(id,true)){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Aprobado"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("No se aprobó"));
        }
    }

    public boolean habilitarBoton(int id){
        FormularioCtrl ctrl=new FormularioCtrl();
        if(ctrl.buscarFormulario(id).isAprobar()){
            return true;
        }else{
            return false;
        }
    }
}
