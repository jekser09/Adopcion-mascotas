package modelo;

public class SolicitudAdopcion {

    private double idAdoptante;
    private double idMascota;
    private boolean aprobacion;

    public SolicitudAdopcion() {
    }

    public double getIdAdoptante() {
        return idAdoptante;
    }

    public void setIdAdoptante(double idAdoptante) {
        this.idAdoptante = idAdoptante;
    }

    public double getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(double idMascota) {
        this.idMascota = idMascota;
    }

    public boolean isAprobacion() {
        return aprobacion;
    }

    public void setAprobacion(boolean aprobacion) {
        this.aprobacion = aprobacion;
    }
}
