package co.edu.ucentral.ingsf.springprime.bean;

import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.file.UploadedFile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

@Component
@ManagedBean
@ViewScoped
@Getter
@Setter
@RequestScoped
public class AgregarMascotaBean {

    private UploadedFile file;

    @PostConstruct
    public void init() {

    }


}
