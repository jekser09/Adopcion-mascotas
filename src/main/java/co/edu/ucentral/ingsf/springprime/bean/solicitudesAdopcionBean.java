package co.edu.ucentral.ingsf.springprime.bean;

import logica.MascotasCtrl;
import logica.SolicitudCtrl;
import logica.UsuariosCtrl;
import lombok.Getter;
import lombok.Setter;
import modelo.Solicitud;
import org.springframework.stereotype.Component;
import persistencia.SolicitudDao;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@Component
@ManagedBean
@ViewScoped
@Getter
@Setter
@RequestScoped
public class solicitudesAdopcionBean {
    List<Solicitud> solicitudes;
    SolicitudDao arch;

    public solicitudesAdopcionBean(){
        arch=new SolicitudDao();
        solicitudes=arch.abrirArchivo();
    }
    @PostConstruct
    public void act(){
        arch=new SolicitudDao();
        solicitudes=arch.abrirArchivo();
    }

    public void aprobar(int idAdopta,int idMascota,String nombreM){
        UsuariosCtrl ctrlU=new UsuariosCtrl();
        MascotasCtrl ctrlM=new MascotasCtrl();
        SolicitudCtrl ctrlS=new SolicitudCtrl();
        if(ctrlU.asignarMascota(idAdopta,idMascota,nombreM)){
            ctrlM.estadoMascota(idMascota,"Si");
            ctrlS.aprobarSolicitud(idAdopta,true);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Aprobado"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("No se pudo aprobar"));
        }

    }

    public boolean habilitarBoton(int id){
        SolicitudCtrl ctrlS=new SolicitudCtrl();
        return ctrlS.buscarSolicitud(id).isAprueba();
    }
}
