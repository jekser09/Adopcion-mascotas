package persistencia;

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

public class MascotaDao {

    private final String NOMBREAP = "mascotas.asi";
    private ArrayList<Mascota> mascotas;

    public MascotaDao() {
        if(abrirArchivo()==null){
            nuevoArchivo();
        }
    }

    private void nuevoArchivo(){
        mascotas=new ArrayList();
        FileOutputStream fo = null;

        try {
            fo = new FileOutputStream("mascotas.asi");
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(mascotas);
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

    public boolean guardarArchivo(ArrayList<Mascota> mascotas) {
        FileOutputStream fo = null;
        this.mascotas=mascotas;
        try {
            fo = new FileOutputStream("mascotas.asi");
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(this.mascotas);
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

    public ArrayList<Mascota> abrirArchivo() {
        FileInputStream fi = null;
        try {
            try {
                fi = new FileInputStream("mascotas.asi");
                ObjectInputStream oi = new ObjectInputStream(fi);
                this.mascotas = (ArrayList<Mascota>)oi.readObject();
                oi.close();
                fi.close();
                return mascotas;
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
