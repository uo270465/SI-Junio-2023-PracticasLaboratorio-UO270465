package giitin.uo270394.si.dto;

public class TarifaDTO {
    private int tarifaId;
    private String origen;
    private String destino;
    private double pesoMaximo;
    private double precio;

    public TarifaDTO() {

    }

    public TarifaDTO(int tarifaId, String origen, String destino, double pesoMaximo, double precio) {
        this.tarifaId = tarifaId;
        this.origen = origen;
        this.destino = destino;
        this.pesoMaximo = pesoMaximo;
        this.precio = precio;
    }

    public int getTarifaId() {
        return tarifaId;
    }

    public void setTarifaId(int tarifaId) {
        this.tarifaId = tarifaId;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(double pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}