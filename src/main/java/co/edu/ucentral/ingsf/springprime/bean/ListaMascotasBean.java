package co.edu.ucentral.ingsf.springprime.bean;

import lombok.Getter;
import lombok.Setter;
import modelo.Mascota;
import org.primefaces.PrimeFaces;
import org.primefaces.component.autoupdate.AutoUpdateListener;
import org.springframework.stereotype.Component;
import persistencia.MascotaDao;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

@Component
@ManagedBean
@ViewScoped
@Getter
@Setter
@RequestScoped
public class ListaMascotasBean {

    private List<Mascota> mascotas;
    private MascotaDao mascotaDao;
    public ListaMascotasBean(){
        mascotaDao=new MascotaDao();
        mascotas=mascotaDao.abrirArchivo();
    }

    public void prueba(){
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("no sirve primefaces"));
    }



}
