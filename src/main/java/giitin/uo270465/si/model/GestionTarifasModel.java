package giitin.uo270465.si.model;

import java.util.List;

import giitin.uo270465.si.abs.Model;
import giitin.uo270465.si.dto.TarifaDTO;

public class GestionTarifasModel extends Model{
	
	
	public GestionTarifasModel() {
		super();
	}
	
	public List<TarifaDTO> getTarifas() {
		final String QUERY = "SELECT * FROM Tarifas";
		return db.executeQueryPojo(TarifaDTO.class, QUERY);
	}
	
	public void addTarifa(String concepto, double precio) {
		String QUERY = "INSERT INTO Tarifas (concepto, precio) VALUES (?, ?)";
		db.executeUpdate(QUERY, concepto, precio);

	}
	
	public void alterTarifa(int tarifaId, String concepto, double precio) {
		String QUERY = "UPDATE Tarifas SET concepto = ?, precio = ?	WHERE tarifaId = ?";
		db.executeUpdate(QUERY, concepto, precio, tarifaId);
	}
}
