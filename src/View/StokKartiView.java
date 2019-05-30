package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Model.StokModel;

public class StokKartiView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextField stokKod;
	public JTextField stokAdi;
	public JTextField barkodNo;
	public JComboBox<String> cmbStokTipi;
	public JComboBox<String> cmbBirimi;
	public JComboBox<Double> cmbKdvTipi;
	public JTextArea textArea;
	public JFormattedTextField olusTarihi;
	public JLabel lblTarih;

	public JButton btnKaydet;
	public JButton btnStokAra;
	public JButton btnGuncelle;
	public JButton btnSil;
	public JButton btnKopyala;

	public JScrollPane scrollPane;
	public JTable table;

	public HashMap<Integer, String> stokTipiMap;
	public JMenuItem btnListele = new JMenuItem("Listele");
	public JMenuItem btnYeni = new JMenuItem("Yeni");

	public JMenuItem btnCikis = new JMenuItem("Çýkýþ");
	StokModel model;

	Calendar calendar = Calendar.getInstance();
	// java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
	Timestamp startTime = new java.sql.Timestamp(calendar.getTime().getTime());

	public StokKartiView() {
		model = new StokModel();

		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menubar = new JMenuBar();

		this.setJMenuBar(menubar);
		JMenu dosya = new JMenu("Dosya");

		menubar.add(dosya);
		dosya.add(btnListele);
		dosya.add(btnYeni);
		dosya.add(btnCikis);

		JLabel lblNewLabel = new JLabel("Stok Kodu");
		lblNewLabel.setBounds(10, 27, 84, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Stok Ad\u0131");
		lblNewLabel_1.setBounds(10, 52, 84, 14);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Stok Tipi");
		lblNewLabel_2.setBounds(10, 77, 84, 14);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Birim");
		lblNewLabel_3.setBounds(10, 102, 84, 14);
		getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Barkod");
		lblNewLabel_4.setBounds(10, 127, 84, 14);
		getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Kdv Tipi");
		lblNewLabel_5.setBounds(10, 152, 84, 14);
		getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("A\u00E7\u0131klama");
		lblNewLabel_6.setBounds(10, 177, 84, 14);
		getContentPane().add(lblNewLabel_6);

		lblTarih = new JLabel("Olu\u015Fturma Tarihi");
		lblTarih.setBounds(10, 252, 112, 14);
		lblTarih.setVisible(false);
		getContentPane().add(lblTarih);

		stokKod = new JTextField();
		stokKod.setBounds(104, 21, 128, 20);
		getContentPane().add(stokKod);
		stokKod.setColumns(10);
		stokKod.setEditable(false);

		stokAdi = new JTextField();
		stokAdi.setBounds(104, 46, 128, 20);
		getContentPane().add(stokAdi);
		stokAdi.setColumns(10);
		stokAdi.setEditable(false);

		// String[] stokTip = new String[] { " ", "Kumaþ", "iplik", "mamül", "ürün" };
		cmbStokTipi = new JComboBox<>();
		cmbStokTipi.addItem(" ");
		cmbStokTipi.addItem("Kumaþ");
		cmbStokTipi.addItem("iplik");
		cmbStokTipi.addItem("mamül");
		cmbStokTipi.addItem("ürün");
		cmbStokTipi.setBounds(104, 71, 128, 20);
		getContentPane().add(cmbStokTipi);
		cmbStokTipi.setEditable(false);
		
		stokTipiMap = new HashMap<>();
		stokTipiMap.put(1, "Kumaþ");
		stokTipiMap.put(2, "iplik");
		stokTipiMap.put(3, "mamül");
		stokTipiMap.put(4, "ürün");

		// String[] birimi = new String[] { " ", "gr", "cm", "adet" };
		cmbBirimi = new JComboBox<>();
		cmbBirimi.addItem(" ");
		cmbBirimi.addItem("gr");
		cmbBirimi.addItem("cm");
		cmbBirimi.addItem("adet");
		cmbBirimi.setEditable(false);

		cmbBirimi.setBounds(104, 96, 128, 20);
		getContentPane().add(cmbBirimi);

		barkodNo = new JTextField();
		barkodNo.setBounds(104, 121, 128, 20);
		getContentPane().add(barkodNo);
		barkodNo.setColumns(10);
		barkodNo.setEditable(false);

		// Double[] kdv = { 0.0, 1.0, 8.0, 18.0 };
		cmbKdvTipi = new JComboBox<>();
		cmbKdvTipi.addItem(0.0);
		cmbKdvTipi.addItem(1.0);
		cmbKdvTipi.addItem(8.0);
		cmbKdvTipi.addItem(18.0);

		cmbKdvTipi.setBounds(104, 146, 128, 20);
		getContentPane().add(cmbKdvTipi);
		cmbKdvTipi.setEditable(false);

		textArea = new JTextArea();
		textArea.setBounds(104, 174, 128, 61);
		textArea.setEditable(false);
		getContentPane().add(textArea);

		olusTarihi = new JFormattedTextField();
		olusTarihi.setBounds(114, 249, 128, 20);
		olusTarihi.setVisible(false);
		olusTarihi.setEditable(false);
		getContentPane().add(olusTarihi);

		btnKaydet = new JButton("KAYDET");
		btnKaydet.setBounds(10, 350, 114, 38);
		btnKaydet.setEnabled(false);
		getContentPane().add(btnKaydet);

		btnStokAra = new JButton("STOK ARA");
		btnStokAra.setBounds(10, 292, 114, 38);
		// btnStokAra.setEnabled(false);
		getContentPane().add(btnStokAra);

		btnGuncelle = new JButton("G\u00DCNCELLE");
		btnGuncelle.setBounds(10, 399, 114, 38);
		btnGuncelle.setEnabled(false);
		getContentPane().add(btnGuncelle);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(344, 48, 708, 327);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setForeground(Color.BLACK);
		scrollPane.setViewportView(table);

		btnSil = new JButton("S\u0130L");
		btnSil.setBounds(163, 292, 114, 38);
		btnSil.setEnabled(false);
		getContentPane().add(btnSil);

		btnKopyala = new JButton("KOPYALA");
		btnKopyala.setBounds(163, 350, 114, 38);
		btnKopyala.setEnabled(false);
		getContentPane().add(btnKopyala);

		table.setForeground(Color.BLACK);
		scrollPane.setViewportView(table);
		scrollPane.setVisible(false);
		setTitle("Stok Listesi");
		table.setVisible(false);

		setSize(new Dimension(1084, 502));

	}
	public void ComponentTemizle() {
		stokKod.setText("");
		stokAdi.setText("");
		cmbBirimi.setSelectedItem("");
		cmbKdvTipi.setSelectedItem(0.0);
		cmbStokTipi.setSelectedItem("");
		barkodNo.setText("");
		textArea.setText("");
		olusTarihi.setText("");
	}

	public void addListeleListener(ActionListener listenForbtnListele) {
		btnListele.addActionListener(listenForbtnListele);
	}
	public void addYeniListener(ActionListener listenForbtnYeni) {
		btnYeni.addActionListener(listenForbtnYeni);
	}

	public void addKaydetListener(ActionListener listenForbtnKaydet) {
		btnKaydet.addActionListener(listenForbtnKaydet);
	}

	public void addGuncelleListener(ActionListener listenForbtnGuncelle) {
		btnGuncelle.addActionListener(listenForbtnGuncelle);
	}

	public void addStokAraListener(ActionListener listenForbtnStokAra) {
		btnStokAra.addActionListener(listenForbtnStokAra);
	}

	public void addStokSilListener(ActionListener listenForbtnStokSil) {
		btnSil.addActionListener(listenForbtnStokSil);
	}

	public void addCikisListener(ActionListener listenForbtnCikis) {
		btnCikis.addActionListener(listenForbtnCikis);
	}
}
