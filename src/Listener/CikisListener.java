package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.StokModel;
import View.StokKartiView;

public class CikisListener implements ActionListener {

	private StokModel m_model;

	private StokKartiView m_view;

	public CikisListener(StokKartiView view) {
		this.setM_view(view);
		setM_model(new StokModel());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);

	}

	public StokModel getM_model() {
		return m_model;
	}

	public void setM_model(StokModel m_model) {
		this.m_model = m_model;
	}

	public StokKartiView getM_view() {
		return m_view;
	}

	public void setM_view(StokKartiView m_view) {
		this.m_view = m_view;
	}

}