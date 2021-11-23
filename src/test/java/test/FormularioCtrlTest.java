package test;

import logica.FormularioCtrl;
import modelo.Formulario;
import org.junit.jupiter.api.Test;
import persistencia.FormularioDao;

import static org.junit.jupiter.api.Assertions.*;

class FormularioCtrlTest {

    @Test
    public void prueba(){
        FormularioCtrl ctrl=new FormularioCtrl();
        Formulario form=new Formulario();
        form.setNombreAdoptante("Gian");
        form.setAprobar(false);
        form.setAcepta(true);
        form.setMascotasPrevias(false);
        form.setCantMascotasPrevias(0);
        form.setEmail("algo");
        ctrl.guardarFormulario(form);
    }

    @Test
    public void pruebaForms(){
        FormularioCtrl ctrl=new FormularioCtrl();
        FormularioDao forms=new FormularioDao();
        for(int i=0;i<forms.abrirArchivo().size();i++){
            System.out.println(forms.abrirArchivo().get(i).getNombreAdoptante());
        }
    }

}