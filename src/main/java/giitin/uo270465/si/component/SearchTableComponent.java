package giitin.uo270465.si.component;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import giitin.uo270465.si.dto.ClienteDTO;
import net.miginfocom.swing.MigLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class SearchTableComponent<DTO> extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField tfSearch;

	private Set<DTO> tableDTOs;
	private Set<DTO> filterTableDTOs;

	private String currentSearch;

	private Class<DTO> type;

	private Class<ClienteDTO> typeCliente;

	public SearchTableComponent() {
		setLayout(new MigLayout("", "[][grow,fill][][]", "[][grow,fill]"));
		
		JLabel lSearch = new JLabel("Buscar: ");
		add(lSearch, "cell 0 0,alignx trailing");

		tfSearch = new JTextField();
		add(tfSearch, "cell 1 0");
		tfSearch.setColumns(10);

		JButton bSearch = new JButton("Buscar");
		add(bSearch, "cell 2 0");

		JButton bClear = new JButton("Mostrar todos");
		add(bClear, "cell 3 0");

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 1 4 1,grow");

		table = new JTable();

		scrollPane.setViewportView(table);

		if (type.isInstance(typeCliente)) {
			table.setModel(
					new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Direcci\u00F3n", "Ciudad" }) {
						private static final long serialVersionUID = 1L;
						boolean[] columnEditables = new boolean[] { false, false, false };

						public boolean isCellEditable(int row, int column) {
							return columnEditables[column];
						}
					});
			lSearch.setText("Buscar clientes: ");
		}

		tableDTOs = new TreeSet<DTO>();
		filterTableDTOs = new TreeSet<DTO>();

		currentSearch = "";
		
		bSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				search(tfSearch.getText());
			}
		});
		
		bClear.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				clearSearch();
			}
		});
		
		

	}

	private DefaultTableModel getModel() {
		return (DefaultTableModel) table.getModel();
	}

	public DTO getDTOByIndex(int i) {
		if (i < 0 || i >= filterTableDTOs.size())
			throw new ArrayIndexOutOfBoundsException();

		int j = 0;
		for (DTO dto : filterTableDTOs) {
			if (j == i)
				return dto;
			j++;
		}

		return null;
	}

	private void clearTable() {
		tableDTOs.clear();
		filterTableDTOs.clear();
		while (table.getRowCount() > 0) {
			getModel().removeRow(0);
		}
	}

	private void clearSearch() {
		currentSearch = "";
		filterTableDTOs.clear();
		filterTableDTOs.addAll(tableDTOs);
	}

	private Set<DTO> search(String s) {
		clearSearch();

		currentSearch = s;

		int i = 0;
		for (DTO dto : this.tableDTOs) {
			for (int j = 0; j < table.getColumnCount(); j++) {
				if (((DefaultTableModel) table.getModel()).getValueAt(i, j).toString().contains(currentSearch)) {
					filterTableDTOs.add(dto);
					break;
				}
			}
			i++;
		}

		return this.filterTableDTOs;
	}

	public void addDTO(DTO dto) {

		tableDTOs.add(dto);

		if (type.isInstance(typeCliente)) {
			((DefaultTableModel) table.getModel()).addRow(new Object[] { ((ClienteDTO) dto).getNombre(),
					((ClienteDTO) dto).getEmail(), ((ClienteDTO) dto).getDireccion() });
		}
	}
	
	public void addDTOs(List<DTO> dtos) {
		for (DTO dto : dtos) {
			addDTO(dto);
		}
	}
	
	public void newTable(List<DTO> dtos) {
		clearTable();
		addDTOs(dtos);
	}

}
