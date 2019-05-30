package Controller;

import Listener.CikisListener;
import Listener.ListeleListener;
import Listener.StokAraListener;
import Listener.StokGuncelleListener;
import Listener.StokKaydetListener;
import Listener.StokKopyalaListener;
import Listener.StokMouseListener;
import Listener.StokSilListener;
import Listener.StokYeniListener;
import Listener.TemizleListener;
import View.StokKartiView;

public class StokController {
	StokKartiView m_view;

	// Constructor
	public StokController() {

		m_view = new StokKartiView();
		m_view.setVisible(true);

		// add listeners to the view
		this.m_view.btnKaydet.addActionListener(new StokKaydetListener(m_view));
		this.m_view.btnGuncelle.addActionListener(new StokGuncelleListener(m_view));
		this.m_view.btnListele.addActionListener(new ListeleListener(m_view));
		this.m_view.btnSil.addActionListener(new StokSilListener(m_view));
		this.m_view.addStokAraListener(new StokAraListener(m_view));
		this.m_view.btnKopyala.addActionListener(new StokKopyalaListener(m_view));
		this.m_view.table.addMouseListener(new StokMouseListener(m_view));
		this.m_view.addCikisListener(new CikisListener(m_view));
		this.m_view.addYeniListener(new StokYeniListener(m_view));
		this.m_view.addMouseListener(new TemizleListener(m_view));

	}

}
