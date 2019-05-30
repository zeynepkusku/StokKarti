package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Configuration.StokKartiConfiguration;
import Model.StokModel;
import View.StokKartiView;

public class StokAraListener implements ActionListener {
	private StokModel m_model;
	private StokKartiView m_view;
	private Connection conn;

	public StokAraListener(StokKartiView view) {
		this.m_view = view;
		setM_model(new StokModel());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			conn = StokKartiConfiguration.getConnection();
			// table clear...
			DefaultTableModel model = (DefaultTableModel) m_view.table.getModel();
			// model.addRow(new Object[]{"Stok Kodu", "Stok Adý", "Stok Tipi",
			// "Birimi","Barkod", "Kdv Tipi","Açýklama","Oluþturma Tarihi"});
			model.setRowCount(0);

			// the mysql select statement
			// String ara = JOptionPane.showInputDialog("Aramak istediðiniz stok kodunu
			// giriniz");
		

			// Shows a inputdialog
			String strDialogResponse = JOptionPane.showInputDialog("Aramak istediðiniz stok kodunu giriniz: ");

			// if OK is pushed then (if not strDialogResponse is null)
			if (strDialogResponse != null) {

				// (Code to do something if the user push OK)
				m_view.stokKod.setText(strDialogResponse);

				m_view.scrollPane.setVisible(true);
				m_view.table.setVisible(true);

				String query = "SELECT * FROM tblstokkart WHERE Stok_Kodu = " + m_view.stokKod.getText();

				// create the java statement
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(query);

				int colcount = rs.getMetaData().getColumnCount();
				DefaultTableModel tm = new DefaultTableModel();
				for (int i = 1; i <= colcount; i++)
					tm.addColumn(rs.getMetaData().getColumnName(i));
				// iterate through the java resultset
				while (rs.next()) {
					Object[] row = new Object[colcount];
					for (int i = 1; i <= colcount; i++)
						row[i - 1] = rs.getObject(i);
					tm.addRow(row);
				}
				m_view.table.setModel(tm);

				st.close();
				rs.close();
				conn.close();
			}
			// If cancel button is pressed

		} catch (SQLException hata) {
			Logger.getLogger(JFrame.class.getName()).log(Level.SEVERE, null, hata);
			JOptionPane.showMessageDialog(null, "VeriTabani Baglanti Hatasi");
		}

	}

	public StokModel getM_model() {
		return m_model;
	}

	public void setM_model(StokModel m_model) {
		this.m_model = m_model;
	}

}
