package co.edu.ucentral.ingsf.springprime.bean;

import logica.MascotasCtrl;
import lombok.Getter;
import lombok.Setter;
import modelo.Mascota;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.springframework.stereotype.Component;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
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
        /*FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(file.getFileName()));*/
        MascotasCtrl ctrl=new MascotasCtrl();
        if(nombre!=null && edad!=null && tipo!=null && id!=null){
            Mascota mascota=new Mascota();
            mascota.setNombre(nombre);
            mascota.setId(id);
            mascota.setEdad(edad);
            mascota.setTipoAnimal(tipo);
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

    public void handleFileUpload(FileUploadEvent event) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(event.getFile().getFileName()));
    }
}
