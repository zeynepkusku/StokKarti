package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import Model.StokModel;
import View.StokKartiView;

public class StokSilListener implements ActionListener {

	private StokKartiView m_view;
	private StokModel m_model;

	public StokSilListener(StokKartiView view) {
		this.m_view = view;
		m_model = new StokModel();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		m_model.setStokKodu(m_view.stokKod.getText());
		m_model.setStokAdi(m_view.stokAdi.getText());
		m_model.setStokTipi(m_view.cmbStokTipi.getSelectedIndex());
		m_model.setBirimi((String) m_view.cmbBirimi.getSelectedItem());
		m_model.setBarkodNo(m_view.barkodNo.getText());
		m_model.setKdvTipi((double) m_view.cmbKdvTipi.getSelectedItem());
		m_model.setTextArea(m_view.textArea.getText());
		m_model.setOlusTarihi((Date) m_view.olusTarihi.getValue());

		m_model.delete();
		m_view.btnListele.doClick();
	}

}
