package giitin.uo270465.si.dto;

public class PaqueteDTO {
    private int paqueteId;
    private String descripcion;
    private double peso;
    private String dimensiones;
    private String fechaEnvio;
    private String estado;

    public PaqueteDTO() {

    }

    public PaqueteDTO(int paqueteId, String descripcion, double peso, String dimensiones, String fechaEnvio, String estado) {
        this.paqueteId = paqueteId;
        this.descripcion = descripcion;
        this.peso = peso;
        this.dimensiones = dimensiones;
        this.fechaEnvio = fechaEnvio;
        this.estado = estado;
    }

    public int getPaqueteId() {
        return paqueteId;
    }

    public void setPaqueteId(int paqueteId) {
        this.paqueteId = paqueteId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public String getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(String fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}