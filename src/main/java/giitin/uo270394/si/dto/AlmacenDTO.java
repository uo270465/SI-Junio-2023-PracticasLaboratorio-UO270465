package giitin.uo270394.si.dto;

public class AlmacenDTO {
    private int almacenId;
    private String nombre;
    private String direccion;

    public AlmacenDTO() {

    }

    public AlmacenDTO(int almacenId, String nombre, String direccion) {
        this.almacenId = almacenId;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public int getAlmacenId() {
        return almacenId;
    }

    public void setAlmacenId(int almacenId) {
        this.almacenId = almacenId;
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
}

