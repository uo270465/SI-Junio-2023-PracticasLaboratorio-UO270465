package giitin.uo270465.si.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import giitin.uo270465.si.abs.View;
import giitin.uo270465.si.component.SearchTableComponent;
import giitin.uo270465.si.dto.EnvioInfoDTO;
import net.miginfocom.swing.MigLayout;

public class InformacionEnviosView extends View{

	private static final long serialVersionUID = 1L;
	private SearchTableComponent<EnvioInfoDTO> stcEnvios;

	public InformacionEnviosView() {
		super();
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new MigLayout("", "[800px:n,grow]", "[grow]"));
		
		stcEnvios = new SearchTableComponent<>(EnvioInfoDTO.class);
		panel.add(stcEnvios, "cell 0 0,grow");
	}
	
	public InformacionEnviosView(View parent) {
		this();
		this.initParent(parent);
	}
	

	

	public SearchTableComponent<EnvioInfoDTO> getStcEnvios() {
		return stcEnvios;
	}
}
