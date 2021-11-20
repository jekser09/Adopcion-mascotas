package test;

import org.junit.jupiter.api.Test;
import util.SesionActual;

import static org.junit.jupiter.api.Assertions.*;

class SesionActualTest {

    @Test
    void crearArchivo() {
        SesionActual sa=new SesionActual();
        sa.crearArchivo();
    }

    @Test
    void guardarArchivo() {
        SesionActual sa=new SesionActual();
        sa.guardarArchivo("probando\nmetodo");
    }

    @Test
    void abrirArchivo() {
        SesionActual sa=new SesionActual();
        String texto=sa.abrirArchivo();
        System.out.print(texto);
    }
}