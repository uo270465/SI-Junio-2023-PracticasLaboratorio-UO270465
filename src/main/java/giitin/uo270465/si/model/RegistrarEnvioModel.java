package giitin.uo270465.si.model;

import java.util.List;

import giitin.uo270465.si.abs.Model;
import giitin.uo270465.si.dto.ClienteDTO;

public class RegistrarEnvioModel extends Model{
	
	public RegistrarEnvioModel() {
		super();
	}
	
	public List<ClienteDTO> getClientes(){
		final String QUERY = "SELECT * FROM clientes";
		return db.executeQueryPojo(ClienteDTO.class, QUERY);
	}
}
