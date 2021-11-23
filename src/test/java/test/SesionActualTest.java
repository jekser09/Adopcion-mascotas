package test;

import co.edu.ucentral.ingsf.springprime.bean.InicioSesionBean;
import logica.UsuariosCtrl;
import org.junit.jupiter.api.Test;
import util.SesionActual;

class SesionActualTest {

    @Test
    void crearArchivo() {

    }

    @Test
    void guardarArchivo() {
        SesionActual p=new SesionActual();
        UsuariosCtrl ct=new UsuariosCtrl();
        p.guardarArchivo(ct.buscarUsuario(1));
    }

    @Test
    void abrirArchivo() {
        SesionActual p=new SesionActual();
        System.out.print(p.abrirArchivo().getTipoUsuario());
    }
}