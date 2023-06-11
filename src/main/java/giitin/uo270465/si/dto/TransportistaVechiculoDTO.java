package giitin.uo270465.si.dto;

public class TransportistaVechiculoDTO {
    private int transportistaId;
    private int vehiculoId;
    private String transportistaNombre;
    private String transportistaEmail;
    private String vehiculoTipo;
    private double vehiculoCapacidad;
    
    
    public TransportistaVechiculoDTO() {
    }
    
	public TransportistaVechiculoDTO(int transportistaId, int vehiculoId, String transportistaNombre,
			String transportistaEmail, String vehiculoTipo, double vehiculoCapacidad) {
		super();
		this.transportistaId = transportistaId;
		this.vehiculoId = vehiculoId;
		this.transportistaNombre = transportistaNombre;
		this.transportistaEmail = transportistaEmail;
		this.vehiculoTipo = vehiculoTipo;
		this.vehiculoCapacidad = vehiculoCapacidad;
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
	public String getTransportistaNombre() {
		return transportistaNombre;
	}
	public void setTransportistaNombre(String transportistaNombre) {
		this.transportistaNombre = transportistaNombre;
	}
	public String getTransportistaEmail() {
		return transportistaEmail;
	}
	public void setTransportistaEmail(String transportistaEmail) {
		this.transportistaEmail = transportistaEmail;
	}
	public String getVehiculoTipo() {
		return vehiculoTipo;
	}
	public void setVehiculoTipo(String vehiculoTipo) {
		this.vehiculoTipo = vehiculoTipo;
	}
	public double getVehiculoCapacidad() {
		return vehiculoCapacidad;
	}
	public void setVehiculoCapacidad(double vehiculoCapacidad) {
		this.vehiculoCapacidad = vehiculoCapacidad;
	}
    
    

    
    
    
}
