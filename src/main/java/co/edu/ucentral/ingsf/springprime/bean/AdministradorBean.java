package co.edu.ucentral.ingsf.springprime.bean;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import util.SesionActual;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import java.io.Serializable;



@Component
@ManagedBean
@ViewScoped
@Getter
@Setter
@RequestScoped
public class AdministradorBean implements Serializable {

    @PostConstruct
    public void init(){

    }

    public String infoUser(){
        SesionActual sa=new SesionActual();
        return sa.abrirArchivo();
    }


}
