package giis.demo.dto;

public class VehiculoDTO {
    private int vehiculoId;
    private String tipo;
    private double capacidadCarga;

    public VehiculoDTO() {

    }

    public VehiculoDTO(int vehiculoId, String tipo, double capacidadCarga) {
        this.vehiculoId = vehiculoId;
        this.tipo = tipo;
        this.capacidadCarga = capacidadCarga;
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

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }
}
