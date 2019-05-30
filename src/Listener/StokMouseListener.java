package Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import View.StokKartiView;

public class StokMouseListener implements MouseListener {

	private StokKartiView view;

	// private StokModel model;

	public StokMouseListener(StokKartiView view) {
		this.view = view;
		// model = new StokModel();
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		int satir = view.table.getSelectedRow(); // Seçilen satýr bulundu

		view.stokKod.setText(String.valueOf(view.table.getValueAt(satir, 0)));
		view.stokAdi.setText(String.valueOf(view.table.getValueAt(satir, 1)));
		view.cmbStokTipi.setSelectedItem(view.table.getValueAt(satir, 2));
		view.cmbBirimi.setSelectedItem(String.valueOf(view.table.getValueAt(satir, 3)));
		view.barkodNo.setText(String.valueOf(view.table.getValueAt(satir, 4)));
		view.cmbKdvTipi.setSelectedItem((double) (view.table.getValueAt(satir, 5)));
		view.textArea.setText(String.valueOf(view.table.getValueAt(satir, 6)));
		view.olusTarihi.setText(String.valueOf(view.table.getValueAt(satir, 7)));
		
		view.stokKod.setEditable(true);
		view.stokAdi.setEditable(true);
		view.cmbBirimi.setEditable(true);
		view.cmbKdvTipi.setEditable(true);
		view.cmbStokTipi.setEditable(true);
		view.barkodNo.setEditable(true);
		view.textArea.setEditable(true);
		view.olusTarihi.setVisible(true);
		view.lblTarih.setVisible(true);
		view.btnSil.setEnabled(true);
		view.btnKopyala.setEnabled(true);
		view.btnGuncelle.setEnabled(true);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
