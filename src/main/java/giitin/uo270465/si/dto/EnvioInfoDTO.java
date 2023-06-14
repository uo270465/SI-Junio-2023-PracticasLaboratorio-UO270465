package giitin.uo270465.si.dto;

public class EnvioInfoDTO {
	private String envioId;
	private double peso;
	private String dimensiones;
	private String estado;
	private String remitenteNombre;
	private String remitenteDireccion;
	private String destinatarioNombre;
	private String destinatarioDireccion;
	private String origenNombre;
	private String origenDireccion;
	private String transportistaNombre;
	private String transportistaEmail;

	public EnvioInfoDTO() {
	}

	public EnvioInfoDTO(String envioId, double peso, String dimensiones, String estado, String remitenteNombre,
			String remitenteDireccion, String destinatarioNombre, String destinatarioDireccion, String origenNombre,
			String origenDireccion, String transportistaNombre, String transportistaEmail) {
		this.envioId = envioId;
		this.peso = peso;
		this.dimensiones = dimensiones;
		this.estado = estado;
		this.remitenteNombre = remitenteNombre;
		this.remitenteDireccion = remitenteDireccion;
		this.destinatarioNombre = destinatarioNombre;
		this.destinatarioDireccion = destinatarioDireccion;
		this.origenNombre = origenNombre;
		this.origenDireccion = origenDireccion;
		this.transportistaNombre = transportistaNombre;
		this.transportistaEmail = transportistaEmail;
	}

	public String getEnvioId() {
		return envioId;
	}

	public void setEnvioId(String envioId) {
		this.envioId = envioId;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getRemitenteNombre() {
		return remitenteNombre;
	}

	public void setRemitenteNombre(String remitenteNombre) {
		this.remitenteNombre = remitenteNombre;
	}

	public String getRemitenteDireccion() {
		return remitenteDireccion;
	}

	public void setRemitenteDireccion(String remitenteDireccion) {
		this.remitenteDireccion = remitenteDireccion;
	}

	public String getDestinatarioNombre() {
		return destinatarioNombre;
	}

	public void setDestinatarioNombre(String destinatarioNombre) {
		this.destinatarioNombre = destinatarioNombre;
	}

	public String getDestinatarioDireccion() {
		return destinatarioDireccion;
	}

	public void setDestinatarioDireccion(String destinatarioDireccion) {
		this.destinatarioDireccion = destinatarioDireccion;
	}

	public String getOrigenNombre() {
		return origenNombre;
	}

	public void setOrigenNombre(String origenNombre) {
		this.origenNombre = origenNombre;
	}

	public String getOrigenDireccion() {
		return origenDireccion;
	}

	public void setOrigenDireccion(String origenDireccion) {
		this.origenDireccion = origenDireccion;
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

}
