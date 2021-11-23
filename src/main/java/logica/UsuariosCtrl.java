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
        }
        if(listaUsuarios.isEmpty()){
            return null;
        }
        for(int i=0;i<listaUsuarios.size();i++){
            if(documento==listaUsuarios.get(i).getId()){
                return listaUsuarios.get(i);
            }
        }
        return null;
    }

    public boolean asignarMascota(int idAdopta,int idMascota,String nombreM){
        if(listaUsuarios.isEmpty()){
            return false;
        }
        for(int i=0;i<listaUsuarios.size();i++){
            if(listaUsuarios.get(i).getId()==idAdopta){
                Usuario usuario=listaUsuarios.get(i);
                usuario.setIdMascota(idMascota);
                usuario.setNombreMascota(nombreM);
                listaUsuarios.set(i,usuario);
                actualizarPersistencia();
                return true;
            }
        }
        return false;
    }
}