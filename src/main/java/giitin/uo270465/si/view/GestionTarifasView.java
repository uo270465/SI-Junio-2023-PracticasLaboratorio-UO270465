package giitin.uo270465.si.view;

import giitin.uo270465.si.abs.View;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import giitin.uo270465.si.component.SearchTableComponent;
import giitin.uo270465.si.dto.TarifaDTO;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Component;
import javax.swing.Box;

public class GestionTarifasView extends View{
	private SearchTableComponent<TarifaDTO> stcTarifas;
	private JButton bQuitarSeleccion;
	private JLabel lAccionTarifaInfo;
	private JLabel lblNewLabel;
	private JTextField tfConcepto;
	private JLabel lblNewLabel_1;
	private JSpinner sPrecio;
	private Component verticalStrut;
	private JButton bAccionTarifa;
	private Component verticalStrut_1;
	private JButton bRestablecer;
	
	public GestionTarifasView() {
		super();
		setTitle("Gestionar tarifas");
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new MigLayout("", "[][][grow][][80px:n]", "[::200px,grow][][][][][][]"));
		
		stcTarifas = new SearchTableComponent<>(TarifaDTO.class);
		panel.add(stcTarifas, "cell 0 0 5 1,grow");
		
		bQuitarSeleccion = new JButton("Quitar selección");
		panel.add(bQuitarSeleccion, "cell 0 1 5 1,growx");
		
		lAccionTarifaInfo = new JLabel("Crear nueva tarifa");
		lAccionTarifaInfo.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lAccionTarifaInfo, "cell 0 2 5 1,alignx left,aligny baseline");
		
		verticalStrut = Box.createVerticalStrut(20);
		panel.add(verticalStrut, "cell 3 3,alignx center");
		
		bRestablecer = new JButton("Restablecer");
		panel.add(bRestablecer, "cell 0 4,alignx right");
		
		lblNewLabel = new JLabel("Concepto: ");
		panel.add(lblNewLabel, "cell 1 4,alignx trailing");
		
		tfConcepto = new JTextField();
		panel.add(tfConcepto, "cell 2 4,growx");
		tfConcepto.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Precio(€): ");
		panel.add(lblNewLabel_1, "cell 3 4,alignx left");
		
		sPrecio = new JSpinner();
		sPrecio.setModel(new SpinnerNumberModel(Double.valueOf(0), Double.valueOf(0), null, Double.valueOf(1)));
		panel.add(sPrecio, "cell 4 4,growx");
		
		verticalStrut_1 = Box.createVerticalStrut(20);
		panel.add(verticalStrut_1, "cell 3 5,alignx center");
		
		bAccionTarifa = new JButton("Crear tarifa");
		panel.add(bAccionTarifa, "cell 0 6 5 1,growx");
	}
	
	public GestionTarifasView(View parent) {
		this();
		this.initParent(parent);
	}

	public SearchTableComponent<TarifaDTO> getStcTarifas() {
		return stcTarifas;
	}
	public JButton getBQuitarSeleccion() {
		return bQuitarSeleccion;
	}
	public JLabel getLAccionTarifaInfo() {
		return lAccionTarifaInfo;
	}
	public JTextField getTfConcepto() {
		return tfConcepto;
	}
	public JSpinner getSPrecio() {
		return sPrecio;
	}
	public JButton getBRestablecer() {
		return bRestablecer;
	}
	public JButton getBAccionTarifa() {
		return bAccionTarifa;
	}
}
