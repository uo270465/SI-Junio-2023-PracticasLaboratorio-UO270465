package giitin.uo270465.si.model;

import java.util.Date;
import java.util.List;

import giitin.uo270465.si.abs.Model;
import giitin.uo270465.si.dto.ClienteDTO;
import giitin.uo270465.si.dto.EnvioDTO;
import giitin.uo270465.si.dto.TarifaDTO;
import giitin.uo270465.si.util.Util;

public class EntregarEnvioModel extends Model{

	public EntregarEnvioModel() {
		super();
	}
	
	public List<EnvioDTO> getEnviosOficinaAlmacen() {
	    String QUERY = "SELECT e.* FROM Envios e " +
	        "JOIN (SELECT envioId, MAX(fechaHora) as UltimaFecha FROM Movimientos GROUP BY envioId) m " +
	        "ON e.envioId = m.envioId " +
	        "JOIN Movimientos mo ON m.envioId = mo.envioId AND m.UltimaFecha = mo.fechaHora " +
	        "WHERE e.fechaRecogida IS NULL AND mo.ubicacionId = e.destinoId";
	    return db.executeQueryPojo(EnvioDTO.class, QUERY);
	}
	
	public List<EnvioDTO> getEnviosDirDestinatario() {
	    String QUERY = "SELECT * FROM Envios WHERE fechaRecogida IS NULL AND destinoId IS NULL AND estado = 'En tránsito'";
	    return db.executeQueryPojo(EnvioDTO.class, QUERY);
	}

	public ClienteDTO getClienteById(int clienteId) {
		String QUERY = "SELECT * FROM Clientes where clienteId = ?";
		return db.executeQueryPojo(ClienteDTO.class, QUERY, clienteId).get(0);
	}
	
	public List<TarifaDTO> getTafifasFromEnvio(String envioId){
		String QUERY = "SELECT t.* FROM Tarifas t JOIN EnviosTarifas et ON et.tarifaId = t.tarifaId WHERE et.envioId = ?";
		return db.executeQueryPojo(TarifaDTO.class, QUERY, envioId);

	}


	public void updateEnvio(String envioId, Date fecha) {
	    // Preparamos la fecha actual
	    
	    final String QUERY = "UPDATE Envios SET estado = ?, fechaRecogida = ? WHERE envioId = ?";
	    db.executeUpdate(QUERY, "Entregado", Util.dateToIsoString(fecha), envioId);
	}


	
}
