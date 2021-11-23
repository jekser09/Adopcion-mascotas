package co.edu.ucentral.ingsf.springprime.bean;

import logica.FormularioCtrl;
import lombok.Getter;
import lombok.Setter;
import modelo.Formulario;
import org.springframework.stereotype.Component;
import util.SesionActual;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@Component
@ManagedBean
@ViewScoped
@Getter
@Setter
@RequestScoped
public class FormularioBean {
    Formulario form=new Formulario();
    FormularioCtrl ctrl=new FormularioCtrl();
    SesionActual sa=new SesionActual();

    public void guardar(){
        form.setIdAdoptante(sa.abrirArchivo().getId());
        form.setNombreAdoptante(sa.abrirArchivo().getNombre());
        if(form.isAcepta()){
            if(ctrl.guardarFormulario(form)){
                form.setIngresosMes(0);
                form.setMascotasPrevias(false);
                form.setCantMascotasPrevias(0);
                form.setAcepta(false);
                form.setEmail("");
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("Formulario guardado"));
            }else{
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("No se guardo el formulario, y no se guardara el formulario si este usuario ya envio uno previamente"));
            }
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("para guardar el formulario debe aceptar el compromiso"));
        }

    }
}
