package giitin.uo270465.si.component;

import java.awt.Color;
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
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import giitin.uo270465.si.dto.AlmacenOficinaDTO;
import giitin.uo270465.si.dto.ClienteDTO;
import giitin.uo270465.si.dto.EnvioDTO;
import giitin.uo270465.si.dto.TarifaDTO;
import giitin.uo270465.si.dto.TransportistaVechiculoDTO;
import net.miginfocom.swing.MigLayout;

public class SearchTableComponent<DTO> extends JPanel {

	private static final long serialVersionUID = 1L;
	private JScrollPane spTable;
	private JTable table;
	private JTextField tfSearch;
	private JButton bClear;
	private JLabel lSearch;

	private List<DTO> tableDTOs;
	private List<DTO> filterTableDTOs;

	private String currentSearch;

	private Class<DTO> type;

	public SearchTableComponent(Class<DTO> type) {
		this.type = type;

		setLayout(new MigLayout("", "[][grow,fill][]", "[][grow,fill]"));

		lSearch = new JLabel("Buscar: ");
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

		if (type == ClienteDTO.class) {
			table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Email", "Direción" }) {
				private static final long serialVersionUID = 1L;
				boolean[] columnEditables = new boolean[] { false, false, false };

				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			lSearch.setText("Buscar clientes: ");
		} else if (type == AlmacenOficinaDTO.class) {
			table.setModel(
					new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Direcci\u00F3n", "Ciudad" }) {
						private static final long serialVersionUID = 1L;
						boolean[] columnEditables = new boolean[] { false, false, false };

						public boolean isCellEditable(int row, int column) {
							return columnEditables[column];
						}
					});
			lSearch.setText("Buscar almacenes y oficinas: ");

		} else if (type == TarifaDTO.class) {
			table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Concepto", "Precio (€)" }) {
				private static final long serialVersionUID = 1L;
				boolean[] columnEditables = new boolean[] { false, false };

				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			lSearch.setText("Buscar tarifas: ");
		} else if (type == TransportistaVechiculoDTO.class) {
			table.setModel(new DefaultTableModel(new Object[][] {},
					new String[] { "Nombre", "Email", "Tipo vehiculo", "Capacidad vehiculo" }) {
				private static final long serialVersionUID = 1L;
				boolean[] columnEditables = new boolean[] { false, false, false, false };

				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			lSearch.setText("Buscar transportistas: ");
		} else if (type == EnvioDTO.class) {
			table.setModel(new DefaultTableModel(new Object[][] {},
					new String[] { "Nº Seguimiento", "Fecha solicitud", "Peso(g)", "Dimensiones(cm)", "Estado" }) {
				private static final long serialVersionUID = 1L;
				boolean[] columnEditables = new boolean[] { false, false, false, false, false };

				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			lSearch.setText("Buscar envios: ");
		} else {
			throw new IllegalArgumentException(String.format("Parametric type %s is not supported on class %s",
					type.getName(), this.getClass().getName()));
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

	public DTO getSelectedDTO() {
		int i = table.getSelectedRow();
		if (i < 0 || i >= filterTableDTOs.size())
			return null;
		return getDTOByIndex(i);
	}

	public void updateTable() {
		tfSearch.setText(currentSearch);
		clearModel();
		for (DTO dto : filterTableDTOs) {
			if (type == ClienteDTO.class) {
				ClienteDTO cliente = (ClienteDTO) dto;
				getModel().addRow(new Object[] { cliente.getNombre(), cliente.getEmail(), cliente.getDireccion() });
			} else if (type == AlmacenOficinaDTO.class) {
				AlmacenOficinaDTO almacenOficina = (AlmacenOficinaDTO) dto;
				getModel().addRow(new Object[] { almacenOficina.getNombre(), almacenOficina.getDireccion(),
						almacenOficina.getCiudad() });
			} else if (type == TarifaDTO.class) {
				TarifaDTO tarifa = (TarifaDTO) dto;
				getModel().addRow(new Object[] { tarifa.getConcepto(), String.format("%.2f", tarifa.getPrecio()) });
			} else if (type == TransportistaVechiculoDTO.class) {
				TransportistaVechiculoDTO transportistaVechiculo = (TransportistaVechiculoDTO) dto;
				getModel().addRow(new Object[] { transportistaVechiculo.getNombre(), transportistaVechiculo.getEmail(),
						transportistaVechiculo.getTipo(), transportistaVechiculo.getCapacidad() });
			} else if (type == EnvioDTO.class) {
				EnvioDTO envio = (EnvioDTO) dto;
				getModel().addRow(new Object[] { envio.getEnvioId(), envio.getFechaSolicitud(), envio.getPeso(),
						envio.getDimensiones(), envio.getEstado()});
			} else {
				throw new IllegalArgumentException(String.format("Parametric type %s is not supported on class %s",
						type.getName(), this.getClass().getName()));
			}
		}
	}

	@Override
	public void setEnabled(boolean b) {
		super.setEnabled(b);

		table.setSelectionForeground((b ? Color.BLACK : Color.GRAY));
		table.setForeground((b ? Color.BLACK : Color.GRAY));
		lSearch.setForeground((b ? Color.BLACK : Color.GRAY));
		bClear.setEnabled(b);
		tfSearch.setEnabled(b);
		spTable.setEnabled(b);
		table.setEnabled(b);
	}

	public void setSelectionMode(int selectioMode) {
		table.setSelectionMode(selectioMode);
	}

	public List<DTO> getSelectedDTOs() {
		int indexes[] = table.getSelectedRows();
		List<DTO> dtos = new LinkedList<>();
		for (int i = 0; i < indexes.length; i++) {
			dtos.add(filterTableDTOs.get(indexes[i]));
		}
		return dtos;
	}

	public void addListSelectionListener(ListSelectionListener listener) {
		table.getSelectionModel().addListSelectionListener(listener);
	}
	
	public void clearSelection() {
		table.clearSelection();
	}
	
}
