package modelo;

public class Formulario {
    private String fotoCedula="";
    private String papelesCasa="";
    private String fotoLugarMascota="";
    private String documentoInresos="";
    private String documentoCompromiso="";
    private boolean aprobacion=false;
    private double id=0;

    public Formulario() {

    }

    public String getFotoCedula() {
        return fotoCedula;
    }

    public void setFotoCedula(String fotoCedula) {
        this.fotoCedula = fotoCedula;
    }

    public String getPapelesCasa() {
        return papelesCasa;
    }

    public void setPapelesCasa(String papelesCasa) {
        this.papelesCasa = papelesCasa;
    }

    public String getFotoLugarMascota() {
        return fotoLugarMascota;
    }

    public void setFotoLugarMascota(String fotoLugarMascota) {
        this.fotoLugarMascota = fotoLugarMascota;
    }

    public String getDocumentoInresos() {
        return documentoInresos;
    }

    public void setDocumentoInresos(String documentoInresos) {
        this.documentoInresos = documentoInresos;
    }

    public String getDocumentoCompromiso() {
        return documentoCompromiso;
    }

    public void setDocumentoCompromiso(String documentoCompromiso) {
        this.documentoCompromiso = documentoCompromiso;
    }

    public boolean isAprobacion() {
        return aprobacion;
    }

    public void setAprobacion(boolean aprobacion) {
        this.aprobacion = aprobacion;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }
}
