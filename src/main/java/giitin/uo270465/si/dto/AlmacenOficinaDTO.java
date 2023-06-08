package giitin.uo270465.si.dto;

public class AlmacenOficinaDTO {

    private int almacenesOficinasId;
    private String nombre;
    private String direccion;
    private String ciudad;

    public AlmacenOficinaDTO() {}

    public AlmacenOficinaDTO(int almacenesOficinasId, String nombre, String direccion, String ciudad) {
        this.almacenesOficinasId = almacenesOficinasId;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }

    public int getAlmacenesOficinasId() {
        return almacenesOficinasId;
    }

    public void setAlmacenesOficinasId(int almacenesOficinasId) {
        this.almacenesOficinasId = almacenesOficinasId;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
