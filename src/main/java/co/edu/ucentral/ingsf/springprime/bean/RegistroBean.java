package co.edu.ucentral.ingsf.springprime.bean;

import logica.UsuariosCtrl;
import lombok.Getter;
import lombok.Setter;
import modelo.Usuario;
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
public class RegistroBean implements Serializable {

    private int id=0;
    private String nombre;
    private String contraseña;
    private String email;

    @PostConstruct
    public void init(){

    }

    public void registro(){
        Usuario user=new Usuario();
        user.setId(id);
        user.setNombre(nombre);
        user.setContraseña(contraseña);
        user.setEmail(email);
        user.setTipoUsuario(3);
        if(id!=0 || nombre!="" || contraseña!="" || email!=""){
            UsuariosCtrl ct=new UsuariosCtrl();
            if(ct.agregarUsuario(user)){
                id=0;
                nombre="";
                contraseña="";
                email="";
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("Bienvenido " + nombre));
            }else{
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("El usuario ya existe"));
            }
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Por favor rellene todos los campos"));
        }
    }



}
