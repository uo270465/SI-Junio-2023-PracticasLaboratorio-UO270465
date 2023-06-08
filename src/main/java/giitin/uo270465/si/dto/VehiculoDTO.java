package giitin.uo270465.si.dto;

public class VehiculoDTO {

    private int vehiculoId;
    private String tipo;
    private double capacidad;

    public VehiculoDTO() {}

    public VehiculoDTO(int vehiculoId, String tipo, double capacidad) {
        this.vehiculoId = vehiculoId;
        this.tipo = tipo;
        this.capacidad = capacidad;
    }

    public int getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(int vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }
}
