package Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import View.StokKartiView;

public class TemizleListener implements MouseListener {

	private StokKartiView view;

	// private StokModel model;

	public TemizleListener(StokKartiView view) {
		this.view = view;
		// model = new StokModel();
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
//		int satir = view.table.getSelectedRow(); // Seçilen satýr bulundu

		// TODO Auto-generated method stub
		view.ComponentTemizle();


	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
