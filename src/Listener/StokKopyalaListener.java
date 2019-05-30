package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;

import javax.swing.JOptionPane;

import Model.StokModel;
import View.StokKartiView;

public class StokKopyalaListener implements ActionListener {

	private StokKartiView m_view;
	private StokModel m_model;

	private Connection conn;

	public StokKopyalaListener(StokKartiView view) {
		this.m_view = view;
		m_model = new StokModel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			int satir = m_view.table.getSelectedRow(); // Seçilen satýr bulundu
			// m_view.stokKod.setText(String.valueOf(m_view.table.getValueAt(satir, 0)));
			String eskiStokKod = String.valueOf(m_view.table.getValueAt(satir, 0));
			
			System.out.println("e :" + eskiStokKod);
			m_model.setStokKodu(m_view.stokKod.getText());
			m_model.setStokAdi(m_view.stokAdi.getText());
			m_model.setStokTipi(m_view.cmbStokTipi.getSelectedIndex());
			m_model.setBirimi((String) m_view.cmbBirimi.getSelectedItem());
			m_model.setBarkodNo(m_view.barkodNo.getText());
			m_model.setKdvTipi((double) m_view.cmbKdvTipi.getSelectedItem());
			m_model.setTextArea(m_view.textArea.getText());
			m_model.setOlusTarihi((Date) m_view.olusTarihi.getValue());
			System.out.println("burada" + m_view.stokKod.getText() + "x");
			

			if (m_view.stokKod.getText().toString().equals(null) || m_view.stokKod.getText().toString().equals("")) {
				String stokKod = "Bir stok seçmelisiniz...";
				JOptionPane.showMessageDialog(null, stokKod);
			

			} else if ((!m_view.stokKod.getText().toString().equals("")
					|| !m_view.stokKod.getText().toString().equals(null))
					&& m_view.stokKod.getText().toString().equals(eskiStokKod)) {

				System.out.println("burada" + m_view.stokKod.getText() + "y");
				String stokKodH = "Yeni Stok Kodunu Giriniz...";
				JOptionPane.showMessageDialog(null, stokKodH);
				// System.out.println("eski :"+eskiStokKod);
				// System.out.println("yeni :"+m_view.stokKod.getText());
			} else {

				// create the mysql insert preparedstatement
				m_model.insert();
				// String copy = "Stok Kopyalandý...";
				// JOptionPane.showMessageDialog(null, copy);
				m_view.btnListele.doClick();

				conn.close();
			}
		} catch (Exception e1) {

			if (m_view.stokKod.getText().toString().equals(null) || m_view.stokKod.getText().toString().equals("")) {
				String stokKod = "Bir stok seçmelisiniz...";
				JOptionPane.showMessageDialog(null, stokKod);
			

			}
//			System.err.println("Got an exception!");
//			
//			System.err.println(e1.getMessage());
		}

	}

}
