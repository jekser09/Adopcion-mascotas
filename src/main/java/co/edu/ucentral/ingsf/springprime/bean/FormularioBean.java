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

    FormularioCtrl ctrl=new FormularioCtrl();

    private int idAdopta;
    private String nombreAdopta;
    private int ingresos;
    private String email;
    private boolean algunaMascota;
    private int mascotas;
    private boolean acepta;

    public void guardar(){
        Formulario form=new Formulario();
        SesionActual sa=new SesionActual();
        idAdopta=sa.abrirArchivo().getId();
        nombreAdopta=sa.abrirArchivo().getNombre();
        form.setIngresosMes(ingresos);
        form.setEmail(email);
        form.setMascotasPrevias(algunaMascota);
        form.setCantMascotasPrevias(mascotas);
        form.setAcepta(acepta);
        form.setIdAdoptante(idAdopta);
        form.setNombreAdoptante(nombreAdopta);
        if(acepta){
            if(ctrl.guardarFormulario(form)){
                idAdopta=0;
                nombreAdopta="";
                ingresos=0;
                email="";
                algunaMascota=false;
                mascotas=0;
                acepta=false;
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
