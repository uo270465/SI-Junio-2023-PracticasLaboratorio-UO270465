package giitin.uo270465.si.dto;

public class ClienteDTO {
    
    private int clienteId;
    private String nombre;
    private String email;
    private String direccion;

    public ClienteDTO() {}

    public ClienteDTO(int clienteId, String nombre, String email, String direccion) {
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
