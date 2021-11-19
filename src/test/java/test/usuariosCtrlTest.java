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
        user1.setId(8);
        user1.setNombre("carlos");
        user1.setEmail("carlos@carlos.com");
        user1.setContraseña("145");
        user1.setTipoUsuario(2);
        user1.setIdMascota("paco");
        ctrl.agregarUsuario(user1);
    }

    @Test
    void iniciarSesion() {
        UsuariosCtrl ctrl=new UsuariosCtrl();
        ctrl.iniciarSesion(8,"145");
        if(ctrl.iniciarSesion(1,"1234")==0) System.out.print("no existe");
        if(ctrl.iniciarSesion(1,"1234")==1) System.out.println("admin");
        if(ctrl.iniciarSesion(2,"1234")==2) System.out.print("empleado");
        if(ctrl.iniciarSesion(3,"145")==3) System.out.println("adoptante");
    }

    @Test
    void buscarUsuario() {
        UsuariosCtrl ctrl=new UsuariosCtrl();
        System.out.println(ctrl.buscarUsuario(8).getNombre());
        System.out.println(ctrl.buscarUsuario(8).getTipoUsuario());

        if(ctrl.buscarUsuario(8)==null){
            System.out.println("oks");
        }else{
            System.out.println("si estoy");
        }
    }
}