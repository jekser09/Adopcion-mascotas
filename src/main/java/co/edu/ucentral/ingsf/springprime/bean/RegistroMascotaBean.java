package co.edu.ucentral.ingsf.springprime.bean;

import logica.MascotasCtrl;
import lombok.Getter;
import lombok.Setter;
import modelo.Mascota;
import org.primefaces.model.file.UploadedFile;
import org.springframework.stereotype.Component;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.Date;

@Component
@ManagedBean
@ViewScoped
@Getter
@Setter
@RequestScoped
@SessionScoped
public class RegistroMascotaBean implements Serializable {
    private String nombre;
    private Integer id;
    private Date edad;
    private String tipo;
    private UploadedFile file;


    public void registrar(){

        MascotasCtrl ctrl=new MascotasCtrl();
        if(nombre!=null && edad!=null && tipo!=null && id!=null){
            Mascota mascota=new Mascota();
            mascota.setId(id);
            mascota.setNombre(nombre);
            mascota.setEdad(edad);
            mascota.setTipoAnimal(tipo);
            mascota.setAdoptado("No");
            mascota.setFoto("imagenes/mascotas/pronto.png");

            if(ctrl.agregarMascota(mascota)){
                nombre="";
                id=0;
                edad=null;
                tipo="";
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("Mascota guardada <3"));
            }else{
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("Esta mascota ya esta registrada"));
            }
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Rellene todos los campos"));
        }
    }
}
