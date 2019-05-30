package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.StokModel;
import View.StokKartiView;

public class StokYeniListener implements ActionListener {

	private StokModel m_model;

	private StokKartiView m_view;
	


	public StokYeniListener(StokKartiView view) {
		this.m_view = view;
		setM_model(new StokModel());
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		m_view.stokKod.setEditable(true);
		m_view.stokAdi.setEditable(true);
		m_view.cmbBirimi.setEditable(true);
		m_view.cmbKdvTipi.setEditable(true);
		m_view.cmbStokTipi.setEditable(true);
		m_view.barkodNo.setEditable(true);
		m_view.textArea.setEditable(true);
		m_view.btnKaydet.setEnabled(true);
		//m_view.btnKopyala.setEnabled(true);
		
		m_view.ComponentTemizle();

	}

	public StokModel getM_model() {
		return m_model;
	}

	public void setM_model(StokModel m_model) {
		this.m_model = m_model;
	}

}
