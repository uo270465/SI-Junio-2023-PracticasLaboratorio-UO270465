package giitin.uo270465.si.dto;

public class RutaDTO {
    private int rutaId;
    private String origen;
    private String destino;
    private double distancia;
    private int duracionEstimada;

    public RutaDTO() {

    }

    public RutaDTO(int rutaId, String origen, String destino, double distancia, int duracionEstimada) {
        this.rutaId = rutaId;
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
        this.duracionEstimada = duracionEstimada;
    }

    public int getRutaId() {
        return rutaId;
    }

    public void setRutaId(int rutaId) {
        this.rutaId = rutaId;
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

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public int getDuracionEstimada() {
        return duracionEstimada;
    }

    public void setDuracionEstimada(int duracionEstimada) {
        this.duracionEstimada = duracionEstimada;
    }
}
