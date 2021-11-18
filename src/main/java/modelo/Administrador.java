package modelo;

public class Administrador extends Usuario {

    private String nombreCargo;

    public Administrador() {
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }
}
