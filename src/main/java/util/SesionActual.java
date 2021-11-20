/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class SesionActual {

    private final String NA="sesion.txt";
    private BufferedWriter bw;
    private BufferedReader br;

    public SesionActual() {

    }

    public boolean crearArchivo(){

        try{
            bw=new BufferedWriter(new FileWriter(NA,true));
            bw.write("");
            bw.flush();
            bw.close();
        }catch(IOException ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public void guardarArchivo(String datos){

        try{
            bw=new BufferedWriter(new FileWriter(NA));
            bw.append(datos);
            bw.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public String abrirArchivo(){
        String txt="";
        String datos="";
        try{
            br=new BufferedReader(new FileReader(NA));
            datos=txt=br.readLine();
            while((txt=br.readLine())!=null) {
                datos=datos+"\n"+txt;
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return datos;
    }




}
