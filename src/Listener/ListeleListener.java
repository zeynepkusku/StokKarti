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

public class ListeleListener implements ActionListener {

	private StokModel m_model;
	private StokKartiView m_view;
	private Connection conn;

	public ListeleListener(StokKartiView view) {

		this.m_view = view;
		setM_model(new StokModel());
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {

			conn = StokKartiConfiguration.getConnection();

			// the mysql select statement
			String query = "SELECT * FROM tblstokkart ORDER BY Oluþturma_Tarihi";
			// create the java statement
			Statement st = conn.createStatement();

			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			int colcount = rs.getMetaData().getColumnCount();
			DefaultTableModel tm = new DefaultTableModel();
			for (int i = 1; i <= colcount; i++) {
				tm.addColumn(rs.getMetaData().getColumnName(i));
			}
			// iterate through the java resultset
			while (rs.next()) {
				Object[] row = new Object[colcount];
				for (int i = 1; i <= colcount; i++) {
					if (i == 3) {
						row[i - 1] = m_view.stokTipiMap.get(rs.getInt(i));
					} else
						row[i - 1] = rs.getObject(i);
				}
				tm.addRow(row);
			}
			m_view.btnKopyala.setEnabled(true);
			m_view.table.setModel(tm);
			m_view.scrollPane.setVisible(true);
			m_view.table.setVisible(true);

			st.close();
			rs.close();
			conn.close();
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