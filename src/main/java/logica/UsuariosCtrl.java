package logica;

import persistencia.UsuariosDao;
import modelo.Usuario;

import java.util.ArrayList;

public class UsuariosCtrl {
    private UsuariosDao udao;
    private ArrayList<Usuario> listaUsuarios;
    private Usuario user;

    public UsuariosCtrl(){
        cargarUsuarios();
    }

    public void cargarUsuarios(){
        udao=new UsuariosDao();
        listaUsuarios=udao.abrirArchivo();
    }

    public void actualizarPersistencia(){
        udao=new UsuariosDao();
        udao.guardarArchivo(listaUsuarios);
    }

    public int iniciarSesion(double id, String contraseña){
        if(listaUsuarios==null){
            cargarUsuarios();
            return 0;
        }
        for(int i=0;i<listaUsuarios.size();i++){
            if(id==listaUsuarios.get(i).getId() && contraseña.equals(listaUsuarios.get(i).getContraseña())){
                return listaUsuarios.get(i).getTipoUsuario();
            }
        }
        return 0;
    }

    public boolean agregarUsuario(Usuario user){
        if(user==null){
            return false;
        }
        if(listaUsuarios==null){
            cargarUsuarios();
        }else{
            for(int i=0;i<listaUsuarios.size();i++){
                if(user.getId()==listaUsuarios.get(i).getId()){
                    return false;
                }else{
                    listaUsuarios.add(user);
                    actualizarPersistencia();
                    return true;
                }
            }

        }
         return false;
    }

    public Usuario buscarUsuario(double documento){
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
