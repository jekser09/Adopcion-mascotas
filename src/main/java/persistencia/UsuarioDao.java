package persistencia;

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

public class UsuarioDao {

        private final String NOMBREAP = "usuarios.asi";
        private ArrayList<Usuario> usuarios;

        public UsuarioDao() {
            if(abrirArchivo()==null){
                nuevoArchivo();
            }
        }

        private void nuevoArchivo(){
            usuarios=new ArrayList();
            FileOutputStream fo = null;

            try {
                fo = new FileOutputStream("usuarios.asi");
                ObjectOutputStream oo = new ObjectOutputStream(fo);
                oo.writeObject(usuarios);
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

        public boolean guardarArchivo(ArrayList<Usuario> usuarios) {
            FileOutputStream fo = null;
            this.usuarios=usuarios;
            try {
                fo = new FileOutputStream("usuarios.asi");
                ObjectOutputStream oo = new ObjectOutputStream(fo);
                oo.writeObject(this.usuarios);
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

        public ArrayList<Usuario> abrirArchivo() {
            FileInputStream fi = null;
            try {
                try {
                    fi = new FileInputStream("usuarios.asi");
                    ObjectInputStream oi = new ObjectInputStream(fi);
                    this.usuarios = (ArrayList<Usuario>)oi.readObject();
                    oi.close();
                    fi.close();
                    return usuarios;
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

