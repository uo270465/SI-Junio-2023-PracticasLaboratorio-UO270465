package giitin.uo270465.si.model;

import java.util.Date;
import java.util.List;

import giitin.uo270465.si.abs.Model;
import giitin.uo270465.si.dto.AlmacenOficinaDTO;
import giitin.uo270465.si.dto.EnvioDTO;
import giitin.uo270465.si.dto.MovimientoDTO;
import giitin.uo270465.si.util.Util;

public class RegistrarMovimientoModel extends Model {

	public static final String ESTADOS_MOVIMIENTO[] = { "Pendiente", "Recogido", "Esperando entrega", "Entregado" };

	public RegistrarMovimientoModel() {
		super();
	}
/*
	public List<EnvioDTO> getEnvios() {
		//String QUERY = "SELECT * FROM Envios where fechaRecogida IS NULL AND destinoId";
		String QUERY = "SELECT e.* FROM Envios e " +
				"JOIN (SELECT envioId, MAX(fechaHora) as UltimaFecha FROM Movimientos GROUP BY envioId) m " +
				"ON e.envioId = m.envioId " +
				"JOIN Movimientos mo ON m.envioId = mo.envioId AND m.UltimaFecha = mo.fechaHora "+
				"WHERE e.fechaRecogida IS NULL AND mo.ubicacionId != e.destinoId";
		return db.executeQueryPojo(EnvioDTO.class, QUERY);
	}
*/
	public List<EnvioDTO> getEnvios() {
	    String QUERY = "SELECT e.* FROM Envios e " +
	            "LEFT JOIN (SELECT envioId, MAX(fechaHora) as UltimaFecha FROM Movimientos GROUP BY envioId) m " +
	            "ON e.envioId = m.envioId " +
	            "LEFT JOIN Movimientos mo ON m.envioId = mo.envioId AND m.UltimaFecha = mo.fechaHora "+
	            "WHERE e.fechaRecogida IS NULL AND (mo.ubicacionId != e.destinoId OR e.destinoId IS NULL OR e.estado = 'Pendiente')";
	    return db.executeQueryPojo(EnvioDTO.class, QUERY);
	}

	public MovimientoDTO getUltimoMovimiento(String EnvioId) {
		String QUERY = "SELECT * FROM Movimientos WHERE envioId = ? ORDER BY movimientoId DESC LIMIT 1 ";
		// return db.executeQueryMap(QUERY, EnvioId).get(0).get("estado").toString();
		List<MovimientoDTO> movimientos = db.executeQueryPojo(MovimientoDTO.class, QUERY, EnvioId);
		if (movimientos.size() == 0) {
			return null;
		}
		return movimientos.get(0);

	}

	public List<AlmacenOficinaDTO> getAlmacenesOficinas() {
		final String QUERY = "SELECT * FROM AlmacenesOficinas";
		return db.executeQueryPojo(AlmacenOficinaDTO.class, QUERY);
	}

	public void addMovimiento(String envioId, Date fechaHora, int ubicacionId, String estado) {
		String QUERY = "INSERT INTO Movimientos (envioId, fechaHora, ubicacionId, estado) VALUES (?, ?, ?, ?)";
		db.executeUpdate(QUERY, envioId, Util.dateToIsoString(fechaHora), ubicacionId, estado);
	}
	
	public void updateEstadoEnvio(String envioId, String estado) {
		String QUERY = "UPDATE Envios SET estado = ? WHERE envioId = ?";
		db.executeUpdate(QUERY, estado, envioId);

	}

}
