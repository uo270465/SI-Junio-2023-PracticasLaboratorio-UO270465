package giitin.uo270465.si.dto;

public class EntregaFallidaDTO {
    private int entregaId;
    private int envioId;
    private String fechaEntregaFallida;
    private int numeroIntentos;

    public EntregaFallidaDTO() {

    }

    public EntregaFallidaDTO(int entregaId, int envioId, String fechaEntregaFallida, int numeroIntentos) {
        this.entregaId = entregaId;
        this.envioId = envioId;
        this.fechaEntregaFallida = fechaEntregaFallida;
        this.numeroIntentos = numeroIntentos;
    }

    public int getEntregaId() {
        return entregaId;
    }

    public void setEntregaId(int entregaId) {
        this.entregaId = entregaId;
    }

    public int getEnvioId() {
        return envioId;
    }

    public void setEnvioId(int envioId) {
        this.envioId = envioId;
    }

    public String getFechaEntregaFallida() {
        return fechaEntregaFallida;
    }

    public void setFechaEntregaFallida(String fechaEntregaFallida) {
        this.fechaEntregaFallida = fechaEntregaFallida;
    }

    public int getNumeroIntentos() {
        return numeroIntentos;
    }

    public void setNumeroIntentos(int numeroIntentos) {
        this.numeroIntentos = numeroIntentos;
    }
}

