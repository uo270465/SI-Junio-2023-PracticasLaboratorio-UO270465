package giitin.uo270465.si.model;

import java.util.Date;
import java.util.List;

import giitin.uo270465.si.abs.Model;
import giitin.uo270465.si.dto.AlmacenOficinaDTO;
import giitin.uo270465.si.dto.ClienteDTO;
import giitin.uo270465.si.dto.TarifaDTO;
import giitin.uo270465.si.dto.TransportistaVechiculoDTO;
import giitin.uo270465.si.util.Util;

public class RegistrarEnvioModel extends Model {

	public RegistrarEnvioModel() {
		super();
	}

	public List<ClienteDTO> getClientes() {
		final String QUERY = "SELECT * FROM Clientes";
		return db.executeQueryPojo(ClienteDTO.class, QUERY);
	}

	public List<AlmacenOficinaDTO> getAlmacenesOficinas() {
		final String QUERY = "SELECT * FROM AlmacenesOficinas";
		return db.executeQueryPojo(AlmacenOficinaDTO.class, QUERY);
	}

	public List<TarifaDTO> getTarifas() {
		final String QUERY = "SELECT * FROM Tarifas";
		return db.executeQueryPojo(TarifaDTO.class, QUERY);
	}

	public List<TransportistaVechiculoDTO> getTransportistasVehiculos() {
		final String QUERY = "SELECT t.transportistaId, v.vehiculoId, t.nombre, t.email, v.tipo, v.capacidad FROM Transportistas t INNER JOIN Vehiculos v ON t.vehiculoId = v.vehiculoId";
		return db.executeQueryPojo(TransportistaVechiculoDTO.class, QUERY);
	}

	public boolean isEmailTaken(String email) {
		final String QUERY = "SELECT * FROM Clientes WHERE email = ?";
		return db.executeQueryPojo(ClienteDTO.class, QUERY, email).size() > 0;
	}

	public boolean addCliente(String nombre, String email, String direccion) {
		if (nombre == null || email == null || direccion == null) {
			return false;
		}
		String QUERY = "INSERT INTO Clientes (nombre, email, direccion) VALUES (?, ?, ?)";
		db.executeUpdate(QUERY, nombre, email, direccion);
		return true;
	}

	public boolean addEnvio(int remitenteId, int destinatarioId, int origenId, int destinoId, Date fechaSolicitud,
			double peso, String dimensiones, String estado, int transportistaId) {
		if (fechaSolicitud == null || estado == null) {
			return false;
		}
		String QUERY = "INSERT INTO Envios (envioId, remitenteId, destinatarioId, origenId, destinoId, "
				+ "fechaSolicitud, peso, dimensiones, estado, transportistaId) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		db.executeUpdate(QUERY, Util.generarNumeroSeguimiento(), remitenteId, destinatarioId, origenId,
				(destinoId < 0 ? null : destinoId), Util.dateToIsoString(fechaSolicitud), peso, dimensiones, estado,
				transportistaId);
		return true;
	}

	public ClienteDTO getClienteByEmail(String email) {
		final String QUERY = "SELECT * FROM Clientes WHERE email = ?";
		return db.executeQueryPojo(ClienteDTO.class, QUERY, email).get(0);
	}

}
