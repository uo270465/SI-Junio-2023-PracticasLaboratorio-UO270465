package giitin.uo270465.si.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import giitin.uo270465.si.dto.ClienteDTO;
import net.miginfocom.swing.MigLayout;

public class SearchTableComponent<DTO> extends JPanel {

	private static final long serialVersionUID = 1L;
	private JScrollPane spTable;
	private JTable table;
	private JTextField tfSearch;
	private JButton bClear;

	private List<DTO> tableDTOs;
	private List<DTO> filterTableDTOs;

	private String currentSearch;

	@SuppressWarnings("unchecked")
	private DTO dto = (DTO) (new Object());
	@SuppressWarnings("unchecked")
	private Class<DTO> type = (Class<DTO>) dto.getClass();

	private Class<ClienteDTO> typeCliente = ClienteDTO.class;

	public SearchTableComponent() {
		setLayout(new MigLayout("", "[][grow,fill][]", "[][grow,fill]"));

		JLabel lSearch = new JLabel("Buscar: ");
		add(lSearch, "cell 0 0,alignx trailing");

		tfSearch = new JTextField();
		add(tfSearch, "cell 1 0");
		tfSearch.setColumns(10);

		bClear = new JButton("Mostrar todos");
		add(bClear, "cell 2 0");

		spTable = new JScrollPane();
		add(spTable, "cell 0 1 3 1,grow");

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		spTable.setViewportView(table);

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

		tableDTOs = new LinkedList<DTO>();
		filterTableDTOs = new LinkedList<DTO>();

		currentSearch = "";

		ActionListener alSearch = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		};

		tfSearch.addActionListener(alSearch);

		tfSearch.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				search(tfSearch.getText());

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

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
		return filterTableDTOs.get(i);
	}

	private void clearModel() {
		while (table.getRowCount() > 0) {
			getModel().removeRow(0);
		}
	}

	private void clearTable() {
		tableDTOs.clear();
		filterTableDTOs.clear();
		clearModel();
	}

	private void clearSearch() {
		currentSearch = "";
		filterTableDTOs.clear();
		filterTableDTOs.addAll(tableDTOs);
		updateTable();
	}

	private List<DTO> search(String s) {
		clearSearch();

		currentSearch = s;

		if (currentSearch.isBlank()) {
			updateTable();
			return filterTableDTOs;
		}
		filterTableDTOs.clear();
		int i = 0;
		for (DTO dto : this.tableDTOs) {
			for (int j = 0; j < table.getColumnCount(); j++) {
				if (((DefaultTableModel) table.getModel()).getValueAt(i, j).toString().toLowerCase()
						.contains(currentSearch)) {
					filterTableDTOs.add(dto);
					break;
				}
			}
			i++;
		}

		updateTable();
		return this.filterTableDTOs;
	}

	public void addDTO(DTO dto) {

		tableDTOs.add(dto);
		search(currentSearch);
		updateTable();

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
	
	public DTO getSelectedDTO(int i) {
		return getDTOByIndex(i);
	}

	public void updateTable() {
		tfSearch.setText(currentSearch);
		clearModel();
		for (DTO dto : filterTableDTOs) {
			if (type.isInstance(typeCliente)) {
				((DefaultTableModel) table.getModel()).addRow(new Object[] { ((ClienteDTO) dto).getNombre(),
						((ClienteDTO) dto).getEmail(), ((ClienteDTO) dto).getDireccion() });
			}
		}
	}
	
	@Override
	public void setEnabled(boolean b) {
		super.setEnabled(b);
		
		if (!b) {
			table.clearSelection();
			clearSearch();
			updateTable();
		}
		
		bClear.setEnabled(b);
		tfSearch.setEnabled(b);
		spTable.setEnabled(b);
		table.setEnabled(b);
	}

}
