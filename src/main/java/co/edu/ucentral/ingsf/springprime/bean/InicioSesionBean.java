package co.edu.ucentral.ingsf.springprime.bean;

import modelo.Usuario;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

public class InicioSesionBean {
    private ArrayList<Usuario> listaUsuarios;
    @PostConstruct
    public void init(){

    }

    public void iniciarSesion(double documento,String contraseña){

    }
}
