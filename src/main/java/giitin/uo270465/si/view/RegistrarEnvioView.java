package giitin.uo270465.si.view;

import giitin.uo270465.si.abs.View;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RegistrarEnvioView extends View{
	private JTable table;
	public RegistrarEnvioView() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		getContentPane().add(scrollPane_1);
		
		JPanel panel = new JPanel();
		scrollPane_1.setViewportView(panel);
		panel.setLayout(new MigLayout("", "[grow][grow]", "[][][grow]"));
		
		JLabel lblNewLabel = new JLabel("Seleccione una opción:");
		panel.add(lblNewLabel, "cell 0 0 2 1");
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Nuevo cliente");
		panel.add(tglbtnNewToggleButton, "flowx,cell 0 1,growx");
		
		JToggleButton tglbtnNewToggleButton_1 = new JToggleButton("Cliente Existente");
		panel.add(tglbtnNewToggleButton_1, "cell 1 1,growx");
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 1 2,grow");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Nombre", "Email", "Direcci\u00F3n"
			}
		));
		scrollPane.setViewportView(table);
	}

}
