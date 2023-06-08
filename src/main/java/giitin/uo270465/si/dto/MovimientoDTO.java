package giitin.uo270465.si.dto;

public class MovimientoDTO {

    private int movimientoId;
    private int envioId;
    private String fechaHora;
    private int ubicacionId;
    private String estado;

    public MovimientoDTO() {}

    public MovimientoDTO(int movimientoId, int envioId, String fechaHora, int ubicacionId, String estado) {
        this.movimientoId = movimientoId;
        this.envioId = envioId;
        this.fechaHora = fechaHora;
        this.ubicacionId = ubicacionId;
        this.estado = estado;
    }

    public int getMovimientoId() {
        return movimientoId;
    }

    public void setMovimientoId(int movimientoId) {
        this.movimientoId = movimientoId;
    }

    public int getEnvioId() {
        return envioId;
    }

    public void setEnvioId(int envioId) {
        this.envioId = envioId;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getUbicacionId() {
        return ubicacionId;
    }

    public void setUbicacionId(int ubicacionId) {
        this.ubicacionId = ubicacionId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

