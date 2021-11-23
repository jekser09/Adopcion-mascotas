package co.edu.ucentral.ingsf.springprime.bean;

import logica.FormularioCtrl;
import logica.MascotasCtrl;
import logica.SolicitudCtrl;
import lombok.Getter;
import lombok.Setter;
import modelo.Solicitud;
import org.springframework.stereotype.Component;
import util.SesionActual;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@Component
@ManagedBean
@ViewScoped
@Getter
@Setter
@RequestScoped
public class AdoptanteBean implements Serializable {

    public String info(){
        SesionActual sa=new SesionActual();
        return "|NOMBRE:"+sa.abrirArchivo().getNombre()+
                " |Id:"+sa.abrirArchivo().getId()+
                " |Email:"+sa.abrirArchivo().getEmail()+
                " |tipo Usuario:"+sa.abrirArchivo().getTipoUsuario()+
                " |Id Mascota:"+sa.abrirArchivo().getIdMascota()+
                " |Nombre Mascota:"+sa.abrirArchivo().getNombreMascota();
    }

    public void adopciones(int id,String nombreM){
        Solicitud solicitud=new Solicitud();
        SolicitudCtrl ctrl=new SolicitudCtrl();
        SesionActual sa=new SesionActual();
        MascotasCtrl ctrlM=new MascotasCtrl();
        FormularioCtrl ctrlF=new FormularioCtrl();

        solicitud.setIdAdoptante(sa.abrirArchivo().getId());
        solicitud.setNombreAdopta(sa.abrirArchivo().getNombre());
        solicitud.setIdMascota(id);
        solicitud.setNombreMascota(nombreM);
        if(ctrlF.buscarFormulario(sa.abrirArchivo().getId())!=null && ctrlF.buscarFormulario(sa.abrirArchivo().getId()).isAprobar()){
            if(ctrl.guardarSolicitud(solicitud)){
                ctrlM.estadoMascota(id,"Pendiente");
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("Solicitud Creada"));
            }else{
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("No se creo la solicitud y no se creeara si este usuario ya generó una solicitud previamente"));
            }
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("No se permite generar la solicitud de adopcion si su formulario no ha sido aprobado o si usted no lo ha enviado, intentelo en otro momento"));
        }

    }

    public boolean habilitarBoton(int id){
        MascotasCtrl ctrlM=new MascotasCtrl();
        SolicitudCtrl ctrlS=new SolicitudCtrl();
        SesionActual sa=new SesionActual();
        if(ctrlM.buscarMascota(id).getAdoptado().equals("Pendiente")){
            return true;
        }
        if(ctrlM.buscarMascota(id).getAdoptado().equals("Si")){
            return true;
        }
        if(ctrlS.buscarSolicitud(sa.abrirArchivo().getId())!=null){
            return true;
        }
        return false;
    }
}
