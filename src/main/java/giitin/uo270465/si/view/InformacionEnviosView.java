package giitin.uo270465.si.view;

import java.util.List;

import giitin.uo270465.si.abs.View;

public class InformacionEnviosView extends View{

	private static final long serialVersionUID = 1L;

	public InformacionEnviosView() {
		super();
	}
	
	public InformacionEnviosView(View parent) {
		this();
		this.initParent(parent);
	}
	
	public List<EnvioInfoDTO> getEnviosInfos(){
		String QUERY = "  SELECT  e.envioId,  e.peso,  e.dimensiones,  e.estado, r.nombre AS remitenteNombre,  r.direccion AS remitenteDireccion, d.nombre AS destinatarioNombre,  COALESCE(dest.direccion, d.direccion) AS destinatarioDireccion, o.nombre AS origenNombre,  o.direccion AS origenDireccion, t.nombre AS transportistaNombre, t.email AS transportistaEmail FROM  Envios e INNER JOIN Clientes r ON e.remitenteId = r.clienteId INNER JOIN Clientes d ON e.destinatarioId = d.clienteId INNER JOIN AlmacenesOficinas o ON e.origenId = o.almacenesOficinasId LEFT JOIN AlmacenesOficinas dest ON e.destinoId = dest.almacenesOficinasId INNER JOIN Transportistas t ON e.transportistaId = t.transportistaId;";
		return null;
	}
	

}
