package modelo;

import java.io.Serializable;

public class Formulario implements Serializable {
    private int IdAdoptante;
    private String nombreAdoptante;
    private double ingresosMes;
    private String email;
    private boolean mascotasPrevias;
    private int cantMascotasPrevias;
    private boolean aprobar=false;
    private boolean acepta;

    public Formulario() {
    }

    public boolean isAcepta() {
        return acepta;
    }

    public void setAcepta(boolean acepta) {
        this.acepta = acepta;
    }

    public boolean isAprobar() {
        return aprobar;
    }

    public void setAprobar(boolean aprobar) {
        this.aprobar = aprobar;
    }

    public double getIngresosMes() {
        return ingresosMes;
    }

    public void setIngresosMes(double ingresosMes) {
        this.ingresosMes = ingresosMes;
    }

    public int getIdAdoptante() {
        return IdAdoptante;
    }

    public void setIdAdoptante(int idAdoptante) {
        IdAdoptante = idAdoptante;
    }

    public String getNombreAdoptante() {
        return nombreAdoptante;
    }

    public void setNombreAdoptante(String nombreAdoptante) {
        this.nombreAdoptante = nombreAdoptante;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isMascotasPrevias() {
        return mascotasPrevias;
    }

    public void setMascotasPrevias(boolean mascotasPrevias) {
        this.mascotasPrevias = mascotasPrevias;
    }

    public int getCantMascotasPrevias() {
        return cantMascotasPrevias;
    }

    public void setCantMascotasPrevias(int cantMascotasPrevias) {
        this.cantMascotasPrevias = cantMascotasPrevias;
    }
}
