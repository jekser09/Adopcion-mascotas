package test;

import org.junit.jupiter.api.Test;
import persistencia.MascotaDao;

import static org.junit.jupiter.api.Assertions.*;

class MascotasCtrlTest {

    @Test
    public void prueba(){
        MascotaDao ar=new MascotaDao();
        for(int i=0;i<ar.abrirArchivo().size();i++){
            System.out.println(ar.abrirArchivo().get(i).getNombre());
            System.out.println(ar.abrirArchivo().get(i).getFoto());
        }

    }

}