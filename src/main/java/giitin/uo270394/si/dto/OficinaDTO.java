package giitin.uo270394.si.dto;

public class OficinaDTO {
    private int oficinaId;
    private String nombre;
    private String direccion;
    private String telefono;

    public OficinaDTO() {

    }

    public OficinaDTO(int oficinaId, String nombre, String direccion, String telefono) {
        this.oficinaId = oficinaId;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getOficinaId() {
        return oficinaId;
    }

    public void setOficinaId(int oficinaId) {
        this.oficinaId = oficinaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}