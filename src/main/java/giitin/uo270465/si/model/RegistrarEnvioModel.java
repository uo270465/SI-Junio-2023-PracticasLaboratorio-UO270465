package giitin.uo270465.si.model;

import java.util.List;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import giitin.uo270465.si.abs.Model;
import giitin.uo270465.si.dto.AlmacenOficinaDTO;
import giitin.uo270465.si.dto.ClienteDTO;
import giitin.uo270465.si.dto.TarifaDTO;
import giitin.uo270465.si.dto.TransportistaVechiculoDTO;

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
	
	public List<TransportistaVechiculoDTO> getTransportistasVehiculos(){
		final String QUERY = "SELECT t.transportistaId, v.vehiculoId, t.nombre, t.email, v.tipo, v.capacidad FROM Transportistas t INNER JOIN Vehiculos v ON t.vehiculoId = v.vehiculoId";
		return db.executeQueryPojo(TransportistaVechiculoDTO.class, QUERY);
	}
	
	public boolean isEmailTaken(String email) {
		final String QUERY = "SELECT * FROM Clientes WHERE email = ?";
		return db.executeQueryPojo(ClienteDTO.class, QUERY, email).size()>0;
	}
}
