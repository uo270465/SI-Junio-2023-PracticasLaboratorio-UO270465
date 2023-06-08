package giitin.uo270465.si.dto;

public class TransportistaDTO {

    private int transportistaId;
    private String nombre;
    private int vehiculoId;
    private String email;

    public TransportistaDTO() {}

    public TransportistaDTO(int transportistaId, String nombre, int vehiculoId, String email) {
        this.transportistaId = transportistaId;
        this.nombre = nombre;
        this.vehiculoId = vehiculoId;
        this.email = email;
    }

    public int getTransportistaId() {
        return transportistaId;
    }

    public void setTransportistaId(int transportistaId) {
        this.transportistaId = transportistaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(int vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
