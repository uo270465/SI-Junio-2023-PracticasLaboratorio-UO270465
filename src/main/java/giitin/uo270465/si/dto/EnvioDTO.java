package giitin.uo270465.si.dto;

public class EnvioDTO {

	private String envioId;
	private int remitenteId;
	private int destinatarioId;
	private int origenId;
	private Integer destinoId;
	private String fechaSolicitud;
	private String fechaRecogida;
	private double peso;
	private String dimensiones;
	private String estado;
	private int transportistaId;

	public EnvioDTO() {
	}

	public EnvioDTO(String envioId, int remitenteId, int destinatarioId, int origenId, Integer destinoId,
			String fechaSolicitud, String fechaRecogida, double peso, String dimensiones, String estado,
			int transportistaId) {
		this.envioId = envioId;
		this.remitenteId = remitenteId;
		this.destinatarioId = destinatarioId;
		this.origenId = origenId;
		this.destinoId = destinoId;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaRecogida = fechaRecogida;
		this.peso = peso;
		this.dimensiones = dimensiones;
		this.estado = estado;
		this.transportistaId = transportistaId;
	}

	public String getEnvioId() {
		return envioId;
	}

	public void setEnvioId(String envioId) {
		this.envioId = envioId;
	}

	public int getRemitenteId() {
		return remitenteId;
	}

	public void setRemitenteId(int remitenteId) {
		this.remitenteId = remitenteId;
	}

	public int getDestinatarioId() {
		return destinatarioId;
	}

	public void setDestinatarioId(int destinatarioId) {
		this.destinatarioId = destinatarioId;
	}

	public int getOrigenId() {
		return origenId;
	}

	public void setOrigenId(int origenId) {
		this.origenId = origenId;
	}

	public Integer getDestinoId() {
		return destinoId;
	}

	public void setDestinoId(Integer destinoId) {
		this.destinoId = destinoId;
	}

	public String getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public String getFechaRecogida() {
		return fechaRecogida;
	}

	public void setFechaRecogida(String fechaRecogida) {
		this.fechaRecogida = fechaRecogida;
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

	public int getTransportistaId() {
		return transportistaId;
	}

	public void setTransportistaId(int transportistaId) {
		this.transportistaId = transportistaId;
	}
}
