package co.edu.ucentral.ingsf.springprime.bean;

import lombok.Getter;
import lombok.Setter;
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
    private Date edad;
    private String tipo;
    private UploadedFile file;


    public void prueba(){
        if(file!=null){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("sirve primefaces"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("no sirve primefaces"));
        }
    }

    public void handleFileUpload(FileUploadEvent event) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(event.getFile().getFileName()));
    }
}
