package giitin.uo270394.si.dto;

public class EnvioDTO {
    private int envioId;
    private int solicitudId;
    private String fechaRecogida;
    private String fechaEntrega;
    private String estado;

    public EnvioDTO() {

    }

    public EnvioDTO(int envioId, int solicitudId, String fechaRecogida, String fechaEntrega, String estado) {
        this.envioId = envioId;
        this.solicitudId = solicitudId;
        this.fechaRecogida = fechaRecogida;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
    }

    public int getEnvioId() {
        return envioId;
    }

    public void setEnvioId(int envioId) {
        this.envioId = envioId;
    }

    public int getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(int solicitudId) {
        this.solicitudId = solicitudId;
    }

    public String getFechaRecogida() {
        return fechaRecogida;
    }

    public void setFechaRecogida(String fechaRecogida) {
        this.fechaRecogida = fechaRecogida;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
