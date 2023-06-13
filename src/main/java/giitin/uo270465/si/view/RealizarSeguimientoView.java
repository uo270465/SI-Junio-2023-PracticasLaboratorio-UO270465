package giitin.uo270465.si.view;

import giitin.uo270465.si.abs.View;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

public class RealizarSeguimientoView extends View{

	private static final long serialVersionUID = 1L;
	private JTextField lBuscarEnvio;
	private JButton bBuscarEnvio;
	private JList<String> lSeguimiento;
	private JLabel lInfoSeguimiento;
	
	public RealizarSeguimientoView() {
		super();
		setTitle("Realizar seguimiento");
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new MigLayout("", "[grow][grow][]", "[][][grow,fill]"));
		
		JLabel lblNewLabel = new JLabel("Introduce número de segimiento:");
		panel.add(lblNewLabel, "cell 0 0");
		
		lBuscarEnvio = new JTextField();
		panel.add(lBuscarEnvio, "cell 1 0,growx");
		lBuscarEnvio.setColumns(10);
		
		bBuscarEnvio = new JButton("Buscar");
		panel.add(bBuscarEnvio, "cell 2 0,alignx center,aligny baseline");
		
		lInfoSeguimiento = new JLabel("");
		lInfoSeguimiento.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(lInfoSeguimiento, "cell 0 1 3 1,alignx center");
		
		lSeguimiento = new JList<>();
		lSeguimiento.setModel(new DefaultListModel<String>());
		lSeguimiento.setBackground(SystemColor.control);
		panel.add(lSeguimiento, "cell 0 2 3 1,grow");
	}
	
	public RealizarSeguimientoView(View parent) {
		this();
		this.initParent(parent);
	}

	public JButton getBBuscarEnvio() {
		return bBuscarEnvio;
	}
	public JTextField getLBuscarEnvio() {
		return lBuscarEnvio;
	}
	
	public JList<String> getLSeguimiento() {
		return lSeguimiento;
	}
	public JLabel getLInfoSeguimiento() {
		return lInfoSeguimiento;
	}
}
