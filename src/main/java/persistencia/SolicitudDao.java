package persistencia;


import modelo.Solicitud;
import java.io.*;
import java.util.ArrayList;

public class SolicitudDao {
    private final String NOMBREAP = "solicitudes.asi";
    private ArrayList<Solicitud> solicitudes;

    public SolicitudDao() {
        if(abrirArchivo()==null){
            nuevoArchivo();
        }
    }

    private void nuevoArchivo(){
        solicitudes=new ArrayList();
        FileOutputStream fo = null;
        try {
            fo = new FileOutputStream(NOMBREAP);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(solicitudes);
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

    public boolean guardarArchivo(ArrayList<Solicitud> solicitudes) {
        FileOutputStream fo = null;
        this.solicitudes=solicitudes;
        try {
            fo = new FileOutputStream(NOMBREAP);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(this.solicitudes);
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

    public ArrayList<Solicitud> abrirArchivo() {
        FileInputStream fi = null;
        try {
            try {
                fi = new FileInputStream(NOMBREAP);
                ObjectInputStream oi = new ObjectInputStream(fi);
                this.solicitudes = (ArrayList<Solicitud>)oi.readObject();
                oi.close();
                fi.close();
                return solicitudes;
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
