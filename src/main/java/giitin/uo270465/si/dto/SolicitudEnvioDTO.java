package giitin.uo270465.si.dto;

public class SolicitudEnvioDTO {
    private int solicitudId;
    private int clienteId;
    private int paqueteId;
    private int rutaId;
    private int vehiculoId;
    private String fechaSolicitud;

    public SolicitudEnvioDTO() {

    }

    public SolicitudEnvioDTO(int solicitudId, int clienteId, int paqueteId, int rutaId, int vehiculoId, String fechaSolicitud) {
        this.solicitudId = solicitudId;
        this.clienteId = clienteId;
        this.paqueteId = paqueteId;
        this.rutaId = rutaId;
        this.vehiculoId = vehiculoId;
        this.fechaSolicitud = fechaSolicitud;
    }

    public int getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(int solicitudId) {
        this.solicitudId = solicitudId;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getPaqueteId() {
        return paqueteId;
    }

    public void setPaqueteId(int paqueteId) {
        this.paqueteId = paqueteId;
    }

    public int getRutaId() {
        return rutaId;
    }

    public void setRutaId(int rutaId) {
        this.rutaId = rutaId;
    }

    public int getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(int vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }
}