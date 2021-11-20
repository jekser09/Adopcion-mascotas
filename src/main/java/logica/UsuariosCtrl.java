package logica;

import persistencia.UsuarioDao;
import modelo.Usuario;

import java.util.ArrayList;


public class UsuariosCtrl {

    private UsuarioDao udao;
    private ArrayList<Usuario> listaUsuarios;
    private int sesionActual=0;

    public UsuariosCtrl(){
        cargarUsuarios();
    }
    public int getSesionActual() {
        return sesionActual;
    }

    public void setSesionActual(int sesionActual) {
        this.sesionActual = sesionActual;
    }

    public void cargarUsuarios(){
        udao=new UsuarioDao();
        listaUsuarios=udao.abrirArchivo();
    }

    public void actualizarPersistencia(){
        udao=new UsuarioDao();
        udao.guardarArchivo(listaUsuarios);
    }

    public int iniciarSesion(int id, String contraseña){
        if(listaUsuarios==null){
            cargarUsuarios();
            return 0;
        }
        for(int i=0;i<listaUsuarios.size();i++){
            if(id==listaUsuarios.get(i).getId() && contraseña.equals(listaUsuarios.get(i).getContraseña())){
                sesionActual=id;
                return listaUsuarios.get(i).getTipoUsuario();
            }
        }
        return 0;
    }

    public boolean agregarUsuario(Usuario user){
        if(user==null){
            return false;
        }
        if(listaUsuarios.isEmpty()) {
            cargarUsuarios();
        }else{
            for(int i=0;i<listaUsuarios.size();i++) {
                if (user.getId() == listaUsuarios.get(i).getId()) return false;
            }
        }

        if(listaUsuarios==null) listaUsuarios=new ArrayList<>();

        listaUsuarios.add(user);
        actualizarPersistencia();
        return true;
    }

    public Usuario buscarUsuario(int documento){
        if(listaUsuarios==null){
            cargarUsuarios();
            return null;
        }
        for(int i=0;i<listaUsuarios.size();i++){
            if(documento==listaUsuarios.get(i).getId()){
                return listaUsuarios.get(i);
            }
        }
        return null;
    }
}