package test;

import persistencia.UsuarioDao;
import modelo.Usuario;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class UsuarioDaoTest {
    @Test
    void guardarArchivo(){
        Usuario user=new Usuario();
        ArrayList<Usuario> usuarios=new ArrayList<>();
        UsuarioDao arch=new UsuarioDao();
        user.setId(1);
        user.setContraseña("1234");
        user.setNombre("carlos");
        user.setEmail("gmail");
        user.setTipoUsuario(1);
        user.setIdMascota(0);
        user.setNombreMascota("");
        usuarios.add(user);
        arch.guardarArchivo(usuarios);
    }
    @Test
    void abrirArchivo(){
        UsuarioDao arch=new UsuarioDao();
        if (arch.abrirArchivo().isEmpty()){
            System.out.print("lista vacia");
        }else{
            System.out.print("uno o mas elementos");
        }
    }
}