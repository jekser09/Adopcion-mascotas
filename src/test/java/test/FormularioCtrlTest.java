package test;

import logica.FormularioCtrl;
import modelo.Formulario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormularioCtrlTest {

    @Test
    public void prueba(){
        FormularioCtrl ctrl=new FormularioCtrl();
        Formulario form=new Formulario();
        form.setNombreAdoptante("carlos");
        form.setAprobar(false);
        form.setAcepta(true);
        form.setMascotasPrevias(true);
        form.setCantMascotasPrevias(1);
        form.setEmail("algo");
        ctrl.guardarFormulario(form);
    }

}