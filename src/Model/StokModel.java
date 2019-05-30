package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.swing.JOptionPane;

import Configuration.StokKartiConfiguration;

public class StokModel {
	private String stokKodu;
	private String stokAdi;
	private int stokTipi;
	private String birimi;
	private String barkodNo;
	private double kdvTipi;
	private String textArea;
	private Date olusTarihi;

	private Connection conn;

	public void insert() {
		try {

			conn = StokKartiConfiguration.getConnection();
			// calendar
			Calendar calendar = Calendar.getInstance();
			// java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
			Timestamp olusTarihi = new java.sql.Timestamp(calendar.getTime().getTime());
			// the mysql insert statement
			String query = "insert into tblstokkart (Stok_Kodu,Stok_Adý,Stok_Tipi,Birim,Barkod,KDV_Tipi,Açýklama,Oluþturma_Tarihi)"
					+ "values(?,?,?,?,?,?,?,?)";

			// create the mysql insert preparedstatement
			PreparedStatement preparedstmt = conn.prepareStatement(query);
			preparedstmt.setString(1, getStokKodu());
			preparedstmt.setString(2, getStokAdi());
			preparedstmt.setInt(3, getStokTipi());
			preparedstmt.setString(4, getBirimi());
			preparedstmt.setString(5, getBarkodNo());
			preparedstmt.setDouble(6, getKdvTipi());
			preparedstmt.setString(7, getTextArea());
			// preparedstmt.setDate(8, getOlusTarihi());
			// preparedstmt.setTimestamp(8, new Timestamp(getCreateon().getTime())); //
			// hatali
			preparedstmt.setTimestamp(8, olusTarihi, calendar);

			if (getStokKodu().equals(null) || getStokKodu().equals("") || getStokAdi().equals("")
					|| getStokAdi().equals(null) || getStokTipi() == 0 || getBarkodNo().equals(null)
					|| getBarkodNo().equals("") || getTextArea().equals(null) || getTextArea().equals("")
					|| getKdvTipi() == 0.0 || getBirimi().equals("") || getBirimi().equals(null)) {
				String errMessage = "Yeni Stok Bilgilerini Girmelisiniz ...";
				JOptionPane.showMessageDialog(null, errMessage);
			}

			else {

				preparedstmt.execute();
				String kaydet = "Stok Kaydedildi...";
				JOptionPane.showMessageDialog(null, kaydet);

				conn.close();
			}
		} catch (SQLException e) {
			if (e instanceof SQLIntegrityConstraintViolationException) {
				// Duplicate entry
				String duplicate = "Bu Stok Kodu sistemde mevcut... Yeni Stok Kodu Girmelisiniz";
				JOptionPane.showMessageDialog(null, duplicate);

			} else {
				// Other SQL Exception
				System.err.println("Got an exception!");
				System.err.println(e.getMessage());
			}
		}
	}

	public void update() {
		try {
			conn = StokKartiConfiguration.getConnection();
			Calendar calendar = Calendar.getInstance();
			// java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
			Timestamp startTime = new java.sql.Timestamp(calendar.getTime().getTime());
			// the mysql update statement
			String query = "update tblstokkart set Stok_Adý = ? , Stok_Tipi = ? , Birim = ? , Barkod = ? , KDV_Tipi = ? , Açýklama = ? , Oluþturma_Tarihi = ?  where Stok_Kodu= ?";
			PreparedStatement preparedstmt = conn.prepareStatement(query);
			preparedstmt.setString(1, getStokAdi());
			preparedstmt.setInt(2, getStokTipi());
			preparedstmt.setString(3, getBirimi());
			preparedstmt.setString(4, getBarkodNo());
			preparedstmt.setDouble(5, getKdvTipi());
			preparedstmt.setString(6, getTextArea());
			preparedstmt.setTimestamp(7, startTime, calendar);
			preparedstmt.setString(8, getStokKodu());

			// execute the preparedstatement
			if (getStokKodu().equals(null) || getStokKodu().equals("")) {
				String sill = "Deðiþtirmek istediðiniz kaydý seçiniz...";
				JOptionPane.showMessageDialog(null, sill);
			} else {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null, "Kaydý deðiþtirmek isediðinize emin misiniz?",
						"Warning", dialogButton);
				if (dialogResult == JOptionPane.YES_OPTION) {
					// Saving code here
			preparedstmt.executeUpdate();
			String degistir = "Stok Deðiþtirildi...";
			JOptionPane.showMessageDialog(null, degistir);
			// btnListele.doClick();

			conn.close();
				}
			}
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}

	}

	public void delete() {

		try {
			conn = StokKartiConfiguration.getConnection();
			String query = "delete from tblstokkart where Stok_Kodu = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, getStokKodu());

			// execute the preparedstatement
			if (getStokKodu().equals(null) || getStokKodu().equals("")) {
				String sill = "Silmek istediðiniz kaydý seçiniz...";
				JOptionPane.showMessageDialog(null, sill);
			} else {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null, "Kaydý silmek isediðinize emin misiniz?",
						"Warning", dialogButton);
				if (dialogResult == JOptionPane.YES_OPTION) {
					// Saving code here
					preparedStmt.execute();
					String sil = "Stok Silindi...";
					JOptionPane.showMessageDialog(null, sil);

					conn.close();
				}
				
			}

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}

	}

	public String getStokKodu() {
		return stokKodu;
	}

	public void setStokKodu(String stokKodu) {
		this.stokKodu = stokKodu;
	}

	public String getStokAdi() {
		return stokAdi;
	}

	public void setStokAdi(String stokAdi) {
		this.stokAdi = stokAdi;
	}

	public int getStokTipi() {
		return stokTipi;
	}

	public void setStokTipi(int stokTipi) {
		this.stokTipi = stokTipi;
	}

	public String getBirimi() {
		return birimi;
	}

	public void setBirimi(String birimi) {
		this.birimi = birimi;
	}

	public String getBarkodNo() {
		return barkodNo;
	}

	public void setBarkodNo(String barkodNo) {
		this.barkodNo = barkodNo;
	}

	public double getKdvTipi() {
		return kdvTipi;
	}

	public void setKdvTipi(double kdvTipi) {
		this.kdvTipi = kdvTipi;
	}

	StokModel(StokModel model) {

	}

	public String getTextArea() {
		return textArea;
	}

	public void setTextArea(String textArea) {
		this.textArea = textArea;
	}

	public Date getOlusTarihi() {
		return olusTarihi;
	}

	public void setOlusTarihi(Date olusTarihi) {
		this.olusTarihi = olusTarihi;
	}

	public StokModel() {
		// TODO Auto-generated constructor stub
	}

}
