package giitin.uo270465.si.view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import giitin.uo270465.si.abs.View;
import giitin.uo270465.si.component.SearchTableComponent;
import giitin.uo270465.si.dto.AlmacenOficinaDTO;
import giitin.uo270465.si.dto.EnvioDTO;
import net.miginfocom.swing.MigLayout;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class RegistrarMovimientoView extends View{
	public RegistrarMovimientoView() {
		setTitle("Registrar movimiento");
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new MigLayout("", "[][grow]", "[][::300px][][][][][::300px][][]"));
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione un envío");
		panel.add(lblNewLabel_1, "cell 0 0 2 1");
		
		stcEnvios = new SearchTableComponent<>(EnvioDTO.class);
		panel.add(stcEnvios, "cell 0 1 2 1,growx");
		
		lEnvioSeleccionadoInfo = new JLabel("No hay hay ningún envío seleccionado");
		panel.add(lEnvioSeleccionadoInfo, "cell 0 2 2 1");
		
		JLabel lblNewLabel = new JLabel("Seleccione un tipo de movimiento:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(lblNewLabel, "cell 0 3 2 1,alignx left");
		
		rbRecogida = new JRadioButton("Recogida");
		rbRecogida.setMnemonic('1');
		panel.add(rbRecogida, "cell 0 4");
		
		rbEntrega = new JRadioButton("Entrega");
		rbEntrega.setMnemonic('2');
		panel.add(rbEntrega, "cell 1 4");
		
		lAlmacenOficinaInfo = new JLabel("Almacen/Oficina de entrega:");
		lAlmacenOficinaInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(lAlmacenOficinaInfo, "cell 0 5 2 1");
		
		stcAlmacenesOficinas = new SearchTableComponent<>(AlmacenOficinaDTO.class);
		panel.add(stcAlmacenesOficinas, "cell 0 6 2 1,grow");
		stcAlmacenesOficinas.setEnabled(false);
		
		cbIntentoEntrega = new JCheckBox("Intento de entrega");
		cbIntentoEntrega.setEnabled(false);
		panel.add(cbIntentoEntrega, "cell 0 7 2 1");
		
		bRegistrarMovimiento = new JButton("Registrar movimiento");
		bRegistrarMovimiento.setEnabled(false);
		panel.add(bRegistrarMovimiento, "cell 0 8 2 1,growx");
	}

	private static final long serialVersionUID = 1L;
	private SearchTableComponent<EnvioDTO> stcEnvios;
	private JRadioButton rbRecogida;
	private JRadioButton rbEntrega;
	private SearchTableComponent<AlmacenOficinaDTO> stcAlmacenesOficinas;
	private JLabel lAlmacenOficinaInfo;
	private JCheckBox cbIntentoEntrega;
	private JButton bRegistrarMovimiento;
	private JLabel lEnvioSeleccionadoInfo;
	

	public SearchTableComponent<EnvioDTO> getStcEnvios() {
		return stcEnvios;
	}
	public JRadioButton getRbRecogida() {
		return rbRecogida;
	}
	public JRadioButton getRbEntrega() {
		return rbEntrega;
	}
	public SearchTableComponent<AlmacenOficinaDTO> getStcAlmacenesOficinas() {
		return stcAlmacenesOficinas;
	}
	public JLabel getLAlmacenOficinaInfo() {
		return lAlmacenOficinaInfo;
	}
	public JCheckBox getCbIntentoEntrega() {
		return cbIntentoEntrega;
	}
	public JButton getBRegistrarMovimiento() {
		return bRegistrarMovimiento;
	}
	public JLabel getLEnvioSeleccionadoInfo() {
		return lEnvioSeleccionadoInfo;
	}
}
