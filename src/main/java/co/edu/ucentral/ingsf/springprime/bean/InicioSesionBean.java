package co.edu.ucentral.ingsf.springprime.bean;

import logica.UsuariosCtrl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
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
public class InicioSesionBean implements Serializable {

    private Integer id=0;
    private String contraseña;

    @PostConstruct
    public void init(){

    }

    public String validar(){
        if(id!=0 && contraseña!="") {
            UsuariosCtrl user = new UsuariosCtrl();
            int n = user.iniciarSesion(this.id, this.contraseña);
            if (n == 1) return "administrador";
            if (n == 2) return "empleado";
            if (n == 3) return "adoptante";
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("El usuario no existe"));
            return "";
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Por favor rellene los campos"));
            return "";
        }
    }

}
