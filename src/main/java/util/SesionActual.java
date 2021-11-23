package util;


import modelo.Usuario;
import java.io.*;


public class SesionActual {

    private final String NOMBREAP = "sesionActual.asi";


    public SesionActual() {
        if (abrirArchivo() == null) {
            nuevoArchivo();
        }
    }

    private void nuevoArchivo() {
        Usuario usuario = new Usuario();
        FileOutputStream fo = null;
        try {
            fo = new FileOutputStream(NOMBREAP);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(usuario);
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

    public boolean guardarArchivo(Usuario usuario) {
        FileOutputStream fo = null;
        try {
            fo = new FileOutputStream(NOMBREAP);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.flush();
            oo.writeObject(usuario);
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

    public Usuario abrirArchivo() {
        FileInputStream fi = null;
        Usuario usuario=new Usuario();
        try {
            try {
                fi = new FileInputStream(NOMBREAP);
                ObjectInputStream oi = new ObjectInputStream(fi);
                usuario = (Usuario)oi.readObject();
                oi.close();
                fi.close();
                return usuario;
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
