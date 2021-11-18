package modelo;

public class Empleado extends Usuario{

    private String cargoEmpleado;

    public Empleado() {
    }

    public String getCargoEmpleado() {
        return cargoEmpleado;
    }

    public void setCargoEmpleado(String cargoEmpleado) {
        this.cargoEmpleado = cargoEmpleado;
    }
}
