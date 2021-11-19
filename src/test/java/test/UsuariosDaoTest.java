package test;

import persistencia.UsuariosDao;
import modelo.Usuario;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class UsuariosDaoTest {
    @Test
    void guardarArchivo(){
        Usuario user=new Usuario();
        ArrayList<Usuario> usuarios=new ArrayList<>();
        UsuariosDao arch=new UsuariosDao();
        user.setId(1);
        user.setContraseña("1234");
        user.setNombre("carlos");
        user.setEmail("gmail");
        user.setTipoUsuario(1);
        user.setIdMascota("ramon");
        usuarios.add(user);
        arch.guardarArchivo(usuarios);
    }
    @Test
    void abrirArchivo(){
        UsuariosDao arch=new UsuariosDao();
        System.out.print(arch.abrirArchivo().get(0).getTipoUsuario());
    }
}