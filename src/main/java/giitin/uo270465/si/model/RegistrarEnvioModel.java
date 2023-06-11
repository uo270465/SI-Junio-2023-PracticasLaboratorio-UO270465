package giitin.uo270465.si.model;

import java.util.List;

import giitin.uo270465.si.abs.Model;
import giitin.uo270465.si.dto.AlmacenOficinaDTO;
import giitin.uo270465.si.dto.ClienteDTO;

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
}
