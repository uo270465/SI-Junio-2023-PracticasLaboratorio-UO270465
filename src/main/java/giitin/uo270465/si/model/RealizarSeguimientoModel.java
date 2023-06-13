package giitin.uo270465.si.model;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import giitin.uo270465.si.abs.Model;
import giitin.uo270465.si.dto.AlmacenOficinaDTO;
import giitin.uo270465.si.dto.ClienteDTO;
import giitin.uo270465.si.dto.EnvioDTO;
import giitin.uo270465.si.dto.MovimientoDTO;

public class RealizarSeguimientoModel extends Model {

	public RealizarSeguimientoModel() {
		super();
	}

	public EnvioDTO getEnvioById(String envioId) {
		String QUERY = "SELECT * FROM Envios WHERE envioId = ?";
		List<EnvioDTO> envios = db.executeQueryPojo(EnvioDTO.class, QUERY, envioId);
		EnvioDTO envio = null;
		if (envios.size() == 1) {
			envio = envios.get(0);
		}
		return envio;
	}
	
	public List<MovimientoDTO> getMovimientosFromEnvio(String envioId){
		String QUERY = "SELECT * FROM Movimientos where envioId = ?";
		return db.executeQueryPojo(MovimientoDTO.class, QUERY, envioId);
	}
	
	public List<AlmacenOficinaDTO> getAlmacenesOficinas() {
		final String QUERY = "SELECT * FROM AlmacenesOficinas";
		return db.executeQueryPojo(AlmacenOficinaDTO.class, QUERY);
	}
	
	public Map<Integer, AlmacenOficinaDTO> getMapAlmacenesOficinas(){
		Map<Integer, AlmacenOficinaDTO> mapAlmacenesOficinas = new TreeMap<>();
		List<AlmacenOficinaDTO> almacenesoficinas = getAlmacenesOficinas();
		for (AlmacenOficinaDTO almacenOficina : almacenesoficinas) {
			mapAlmacenesOficinas.put(almacenOficina.getAlmacenesOficinasId(), almacenOficina);
		}
		return mapAlmacenesOficinas;
	}
	
	public ClienteDTO getClienteById(int clienteId) {
		String QUERY = "SELECT * FROM Clientes where clienteId = ?";
		return db.executeQueryPojo(ClienteDTO.class, QUERY, clienteId).get(0);
	}
	
}
