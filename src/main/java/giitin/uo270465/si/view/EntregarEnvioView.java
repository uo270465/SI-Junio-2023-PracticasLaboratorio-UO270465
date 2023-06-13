package giitin.uo270465.si.view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import giitin.uo270465.si.abs.View;
import giitin.uo270465.si.component.SearchTableComponent;
import giitin.uo270465.si.dto.EnvioDTO;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import java.awt.Panel;
import giitin.uo270465.si.component.SignaturePanelComponent;
import javax.swing.JButton;

public class EntregarEnvioView extends View{

	private static final long serialVersionUID = 1L;
	private JRadioButton rbAlmacenOficina;
	private JRadioButton rbDirDestinatario;
	private SearchTableComponent<EnvioDTO> stcEnvios;
	private JLabel lNombreDestinatario;
	private JLabel lCoste;
	private JLabel lEmailDestinatario;
	private JLabel lNombreRemitente;
	private JLabel lEmailRemitente;
	private JButton bBorrarFirmaRepartidor;
	private JButton bBorrarFirmaDestinatario;
	private SignaturePanelComponent pFirmaDestinatario;
	private SignaturePanelComponent pFirnaRepartidor;
	private JButton bEntregarEnvio;

	public EntregarEnvioView() {
		super();
		setTitle("Entregar envío");
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new MigLayout("", "[grow][][][][][grow 50][grow 50][][][grow]", "[][][][::300px][][][][][][][120px:n,grow][][]"));
		
		JLabel lblNewLabel = new JLabel("Seleccione donde desea realizar el envío:");
		panel.add(lblNewLabel, "cell 0 0 10 1");
		
		rbAlmacenOficina = new JRadioButton("Almacén/Oficina");
		panel.add(rbAlmacenOficina, "cell 0 1 10 1,alignx left");
		
		rbDirDestinatario = new JRadioButton("Dirección del destinatario");
		panel.add(rbDirDestinatario, "cell 0 2 10 1");
		
		stcEnvios = new SearchTableComponent<>(EnvioDTO.class);
		panel.add(stcEnvios, "cell 0 3 10 1,growx");
		
		JLabel lblNewLabel_1 = new JLabel("Información del envío");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblNewLabel_1, "cell 3 4 6 1,alignx center");
		
		JLabel lblNewLabel_2 = new JLabel("Datos del remitente:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(lblNewLabel_2, "flowx,cell 3 5 4 1");
		
		JLabel lblNewLabel_3 = new JLabel("Nombre: ");
		panel.add(lblNewLabel_3, "cell 3 6");
		
		JLabel lblNewLabel_4 = new JLabel("Datos del destinatario:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(lblNewLabel_4, "cell 7 5 3 1");
		
		lNombreRemitente = new JLabel("nombre");
		panel.add(lNombreRemitente, "cell 4 6");
		
		JLabel lblNewLabel_3_1 = new JLabel("Nombre: ");
		panel.add(lblNewLabel_3_1, "cell 7 6");
		
		lNombreDestinatario = new JLabel("nombre");
		panel.add(lNombreDestinatario, "cell 8 6");
		
		JLabel lblNewLabel_5 = new JLabel("Email: ");
		panel.add(lblNewLabel_5, "cell 3 7,aligny center");
		
		lEmailRemitente = new JLabel("email");
		panel.add(lEmailRemitente, "cell 4 7");
		
		JLabel lblNewLabel_5_1 = new JLabel("Email: ");
		panel.add(lblNewLabel_5_1, "cell 7 7");
		
		lEmailDestinatario = new JLabel("email");
		panel.add(lEmailDestinatario, "cell 8 7");
		
		JLabel lblNewLabel_6 = new JLabel("Firma del repartidor:");
		panel.add(lblNewLabel_6, "cell 0 9 5 1");
		
		JLabel lblNewLabel_15 = new JLabel("Coste total: ");
		panel.add(lblNewLabel_15, "cell 5 9,alignx right");
		
		lCoste = new JLabel("coste");
		panel.add(lCoste, "cell 6 9");
		
		JLabel lblNewLabel_7 = new JLabel("Firma del destinatario:");
		panel.add(lblNewLabel_7, "flowx,cell 7 9 3 1");
		
		pFirnaRepartidor = new SignaturePanelComponent();
		panel.add(pFirnaRepartidor, "cell 0 10 5 1,grow");
		
		pFirmaDestinatario = new SignaturePanelComponent();
		panel.add(pFirmaDestinatario, "cell 7 10 3 1,grow");
		
		bBorrarFirmaRepartidor = new JButton("Borrar");
		panel.add(bBorrarFirmaRepartidor, "cell 0 11 5 1,growx");
		
		bBorrarFirmaDestinatario = new JButton("Borrar");
		panel.add(bBorrarFirmaDestinatario, "cell 7 11 3 1,growx");
		
		bEntregarEnvio = new JButton("Confirmar entrega del envío");
		panel.add(bEntregarEnvio, "cell 0 12 10 1,growx");
	}
	
	public EntregarEnvioView(View parent) {
		this();
		this.initParent(parent);
	}
	
	public JRadioButton getRbAlmacenOficina() {
		return rbAlmacenOficina;
	}
	public JRadioButton getRbDirDestinatario() {
		return rbDirDestinatario;
	}
	public SearchTableComponent<EnvioDTO> getStcEnvios() {
		return stcEnvios;
	}
	public JLabel getLNombreDestinatario() {
		return lNombreDestinatario;
	}
	public JLabel getLCoste() {
		return lCoste;
	}
	public JLabel getLEmailDestinatario() {
		return lEmailDestinatario;
	}
	public JLabel getLNombreRemitente() {
		return lNombreRemitente;
	}
	public JLabel getLEmailRemitente() {
		return lEmailRemitente;
	}
	public JButton getBBorrarFirmaRepartidor() {
		return bBorrarFirmaRepartidor;
	}
	public JButton getBBorrarFirmaDestinatario() {
		return bBorrarFirmaDestinatario;
	}
	public SignaturePanelComponent getPFirmaDestinatario() {
		return pFirmaDestinatario;
	}
	public SignaturePanelComponent getPFirnaRepartidor() {
		return pFirnaRepartidor;
	}
	public JButton getBEntregarEnvio() {
		return bEntregarEnvio;
	}
}
