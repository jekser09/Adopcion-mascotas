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
                String sesion= "|ID: "+String.valueOf(user.buscarUsuario(id).getId())+" |Nombre: "+user.buscarUsuario(id).getNombre()+
                        " |Email: "+user.buscarUsuario(id).getEmail()+" |Id-Mascota: "+user.buscarUsuario(id).getIdMascota()+
                        " |Tipo-Usuario: "+user.buscarUsuario(id).getTipoUsuario()+" |";
                sa.guardarArchivo(sesion);
                return "administrador";
            }
            if (n == 2){
                String sesion= " ID: "+String.valueOf(user.buscarUsuario(id).getId())+" |Nombre: "+user.buscarUsuario(id).getNombre()+
                        " |Email: "+user.buscarUsuario(id).getEmail()+" |Id-Mascota: "+user.buscarUsuario(id).getIdMascota()+
                        " |Tipo-Usuario: "+user.buscarUsuario(id).getTipoUsuario();
                sa.guardarArchivo(sesion);
                return "empleado";
            }
            if (n == 3){
                String sesion= " ID: "+String.valueOf(user.buscarUsuario(id).getId())+" |Nombre: "+user.buscarUsuario(id).getNombre()+
                        " |Email: "+user.buscarUsuario(id).getEmail()+" |Id-Mascota: "+user.buscarUsuario(id).getIdMascota()+
                        " |Tipo-Usuario: "+user.buscarUsuario(id).getTipoUsuario();
                sa.guardarArchivo(sesion);
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
