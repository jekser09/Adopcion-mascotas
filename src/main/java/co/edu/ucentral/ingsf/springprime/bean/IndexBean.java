package co.edu.ucentral.ingsf.springprime.bean;



import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ManagedBean
@ViewScoped
@Getter
@Setter
@RequestScoped
public class IndexBean implements Serializable {
    private MenuModel model;
    private List<String> images;
    @PostConstruct
    public void init() {
        model = new DefaultMenuModel();

        images = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            images.add("animal"+i+".jpg");
        }

    }

    public List<String> getImages() {
        return images;
    }

}


