package giitin.uo270465.si.model;

import java.util.List;

import giitin.uo270465.si.abs.Model;
import giitin.uo270465.si.dto.EnvioInfoDTO;

public class InformacionEnviosModel extends Model{
	
	public InformacionEnviosModel() {
		super();
	}
	
	public List<EnvioInfoDTO> getEnviosInfos(){
		String QUERY = "  SELECT  e.envioId,  e.peso,  e.dimensiones,  e.estado, r.nombre AS remitenteNombre,  r.direccion AS remitenteDireccion, d.nombre AS destinatarioNombre,  COALESCE(dest.direccion, d.direccion) AS destinatarioDireccion, o.nombre AS origenNombre,  o.direccion AS origenDireccion, t.nombre AS transportistaNombre, t.email AS transportistaEmail FROM  Envios e INNER JOIN Clientes r ON e.remitenteId = r.clienteId INNER JOIN Clientes d ON e.destinatarioId = d.clienteId INNER JOIN AlmacenesOficinas o ON e.origenId = o.almacenesOficinasId LEFT JOIN AlmacenesOficinas dest ON e.destinoId = dest.almacenesOficinasId INNER JOIN Transportistas t ON e.transportistaId = t.transportistaId;";
		return db.executeQueryPojo(EnvioInfoDTO.class, QUERY);
	}
	

	
}
