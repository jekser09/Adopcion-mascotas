package persistencia;

import modelo.Formulario;
import modelo.Mascota;
import modelo.Usuario;
import java.awt.Component;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FormularioDao{

    private final String NOMBREAP = "formularios.asi";
    private ArrayList<Formulario> formularios;

    public FormularioDao() {
        if(abrirArchivo()==null){
            nuevoArchivo();
        }
    }

    private void nuevoArchivo(){
        formularios=new ArrayList();
        FileOutputStream fo = null;

        try {
            fo = new FileOutputStream("formularios.asi");
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(formularios);
            oo.close();
        } catch (FileNotFoundException var16) {
            var16.printStackTrace();
        } catch (IOException var17) {
            var17.printStackTrace();
        } finally {
            try {
                fo.close();
            } catch (IOException var15) {
            }
        }
    }

    public boolean guardarArchivo(ArrayList<Formulario> formularios) {
        FileOutputStream fo = null;
        this.formularios=formularios;
        try {
            fo = new FileOutputStream("formularios.asi");
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(this.formularios);
            oo.close();
            return true;
        } catch (FileNotFoundException var16) {
            var16.printStackTrace();
        } catch (IOException var17) {
            var17.printStackTrace();
        } finally {
            try {
                fo.close();
            } catch (IOException var15) {
            }
        }
        return false;
    }

    public ArrayList<Formulario> abrirArchivo() {
        FileInputStream fi = null;
        try {
            try {
                fi = new FileInputStream("formularios.asi");
                ObjectInputStream oi = new ObjectInputStream(fi);
                this.formularios = (ArrayList<Formulario>)oi.readObject();
                oi.close();
                fi.close();
                return formularios;
            } catch (FileNotFoundException var10) {
                nuevoArchivo();
            } catch (IOException var11) {
                var11.printStackTrace();
            } catch (ClassNotFoundException var12) {
                var12.printStackTrace();
            }
            return null;
        } finally {

        }
    }
}