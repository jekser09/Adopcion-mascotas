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
        user1.setId(3);
        user1.setNombre("Adoptante");
        user1.setEmail("gmail");
        user1.setContraseña("1234");
        user1.setTipoUsuario(3);
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