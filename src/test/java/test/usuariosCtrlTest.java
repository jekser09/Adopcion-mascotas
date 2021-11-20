package test;

import logica.UsuariosCtrl;
import org.junit.jupiter.api.Test;
import modelo.Usuario;
class usuariosCtrlTest {

    @Test
    void cargarUsuarios() {
        UsuariosCtrl prueba=new UsuariosCtrl();
        prueba.cargarUsuarios();
    }

    @Test
    void actualizarPersistencia() {
        UsuariosCtrl prueba=new UsuariosCtrl();
        prueba.actualizarPersistencia();
    }

    @Test
    void agregarUsuario() {
        /*ADMINISTRADOR*/
        Usuario user1=new Usuario();
        UsuariosCtrl ctrl=new UsuariosCtrl();
        user1.setId(1);
        user1.setNombre("jekser");
        user1.setEmail("jekser07@hotmail.com");
        user1.setContraseña("1234");
        user1.setTipoUsuario(1);
        ctrl.agregarUsuario(user1);
    }

    @Test
    void iniciarSesion() {
        UsuariosCtrl ctrl=new UsuariosCtrl();
        ctrl.iniciarSesion(9,"145");


        if(ctrl.iniciarSesion(8,"145")==3) System.out.println("adoptante");
    }

    @Test
    void buscarUsuario() {
        UsuariosCtrl ctrl=new UsuariosCtrl();
        System.out.print(ctrl.buscarUsuario(1016).getContraseña());
        if(ctrl.buscarUsuario(1016)==null){
            System.out.println("oks");
        }else{
            System.out.println("si estoy");
        }
    }
}