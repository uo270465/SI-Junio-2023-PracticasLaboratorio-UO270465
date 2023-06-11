package giitin.uo270465.si.dto;

public class TransportistaVechiculoDTO {
	private int transportistaId;
	private int vehiculoId;
	private String nombre;
	private String email;
	private String tipo;
	private double capacidad;

	public TransportistaVechiculoDTO() {
	}

	public TransportistaVechiculoDTO(int transportistaId, int vehiculoId, String nombre, String email, String tipo,
			double capacidad) {
		super();
		this.transportistaId = transportistaId;
		this.vehiculoId = vehiculoId;
		this.nombre = nombre;
		this.email = email;
		this.tipo = tipo;
		this.capacidad = capacidad;
	}

	public int getTransportistaId() {
		return transportistaId;
	}

	public void setTransportistaId(int transportistaId) {
		this.transportistaId = transportistaId;
	}

	public int getVehiculoId() {
		return vehiculoId;
	}

	public void setVehiculoId(int vehiculoId) {
		this.vehiculoId = vehiculoId;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(double capacidad) {
		this.capacidad = capacidad;
	}

}
