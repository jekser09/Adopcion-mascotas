package co.edu.ucentral.ingsf.springprime.bean;

import logica.UsuariosCtrl;
import lombok.Getter;
import lombok.Setter;
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
public class InicioSesionBean implements Serializable {

    private Integer id=0;
    private String contraseña;

    public String validar(){
        if(id!=0 && contraseña!=null) {
            UsuariosCtrl user = new UsuariosCtrl();
            SesionActual sa=new SesionActual();
            int n = user.iniciarSesion(this.id, this.contraseña);
            if (n == 1){
                sa.guardarArchivo(user.buscarUsuario(id));
                return "administrador";
            }
            if (n == 2){
                sa.guardarArchivo(user.buscarUsuario(id));
                return "empleado";
            }
            if (n == 3){
                sa.guardarArchivo(user.buscarUsuario(id));
                return "adoptante";
            }
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
