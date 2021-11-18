package util;

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

public class UsuariosDao {


    public class GestorPersistencia {
        private final String NOMBREAP = "usuarios.asi";

        public GestorPersistencia() {
        }

        public boolean guardarArchivo(ArrayList<Usuario> usuarios) {
            FileOutputStream fo = null;

            try {
                fo = new FileOutputStream("usuarios.asi");
                ObjectOutputStream oo = new ObjectOutputStream(fo);
                oo.writeObject(usuarios);
                oo.close();
                boolean var4 = true;
                return var4;
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

        public ArrayList<Usuario> abrirArchivo() {
            ArrayList<Usuario> contactosArchivo = null;
            FileInputStream fi = null;

            try {
                try {
                    fi = new FileInputStream("usuarios.asi");
                    ObjectInputStream oi = new ObjectInputStream(fi);
                    contactosArchivo = (ArrayList)oi.readObject();
                    oi.close();
                    fi.close();
                    return contactosArchivo;
                } catch (FileNotFoundException var10) {
                    JOptionPane.showMessageDialog((Component)null, "Archivo de contactos no encontrado.\nse creera uno nuevo", "Error", 0);
                } catch (IOException var11) {
                    var11.printStackTrace();
                } catch (ClassNotFoundException var12) {
                    var12.printStackTrace();
                }

                return null;
            } finally {
                ;
            }
        }
    }
}
