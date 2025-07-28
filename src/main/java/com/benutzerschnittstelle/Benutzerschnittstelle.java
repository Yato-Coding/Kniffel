package com.benutzerschnittstelle;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import main.java.com.fachkonzept.Endstand;
import main.java.com.steuerung.Steuerung;

public class Benutzerschnittstelle extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JCheckBox cbxWuerfel1;
	private JCheckBox cbxWuerfel2;
	private JCheckBox cbxWuerfel3;
	private JCheckBox cbxWuerfel4;
	private JCheckBox cbxWuerfel5;
	private JCheckBox[] cbxWuerfel;
	private JLabel lblWuerfel1;
	private JLabel lblWuerfel2;
	private JLabel lblWuerfel3;
	private JLabel lblWuerfel4;
	private JLabel lblWuerfel5;
	private JLabel[] lblWuerfel;
	private JButton btnWuerfeln;
	private JButton btnEintragen;
	private JTextArea txtBestenliste;
	private JButton btnNeuesSpiel;
	private JRadioButton rbtEinser;
	private JTextField txtEinser;
	private JRadioButton rbtZweier;
	private JTextField txtZweier;
	private JRadioButton rbtDreier;
	private JTextField txtDreier;
	private JRadioButton rbtVierer;
	private JTextField txtVierer;
	private JRadioButton rbtFuenfer;
	private JTextField txtFuenfer;
	private JRadioButton rbtSechser;
	private JTextField txtSechser;
	private JLabel lblSumme;
	private JTextField txtSummeOben;
	private JLabel lblBonus;
	private JTextField txtBonus;
	private JLabel lblSummeObenMitBonus;
	private JTextField txtSummeObenMitBonus;
	private JRadioButton rbtDreierPasch;
	private JTextField txtDreierPasch;
	private JRadioButton rbtViererPasch;
	private JTextField txtViererPasch;
	private JRadioButton rbtFullHouse;
	private JTextField txtFullHouse;
	private JRadioButton rbtKleineStrasse;
	private JTextField txtKleineStrasse;
	private JRadioButton rbtGrosseStrasse;
	private JTextField txtGrosseStrasse;
	private JRadioButton rbtKniffel;
	private JTextField txtKniffel;
	private JRadioButton rbtChance;
	private JTextField txtChance;
	private JLabel lblSummeUnten;
	private JTextField txtSummeUnten;
	private JTextField txtEndsumme;
	private JTextField[] txtFiguren;
	private JTextField[] txtSummen;
	private JLabel lblEndSumme;
	private JRadioButton[] rbtFiguren;
	private ButtonGroup rbtGroup;

	private Steuerung dieSteuerung;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Benutzerschnittstelle frame = new Benutzerschnittstelle();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Benutzerschnittstelle() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		cbxWuerfel1 = new JCheckBox("");
		cbxWuerfel1.setBounds(23, 62, 21, 25);
		contentPane.add(cbxWuerfel1);

		lblWuerfel1 = new JLabel("");
		lblWuerfel1.setBounds(12, 19, 35, 35);
		contentPane.add(lblWuerfel1);

		cbxWuerfel2 = new JCheckBox("");
		cbxWuerfel2.setBounds(80, 62, 21, 25);
		contentPane.add(cbxWuerfel2);

		lblWuerfel2 = new JLabel("");
		lblWuerfel2.setBounds(66, 19, 35, 35);
		contentPane.add(lblWuerfel2);

		cbxWuerfel3 = new JCheckBox("");
		cbxWuerfel3.setBounds(135, 62, 21, 25);
		contentPane.add(cbxWuerfel3);

		lblWuerfel3 = new JLabel("");
		lblWuerfel3.setBounds(121, 19, 35, 35);
		contentPane.add(lblWuerfel3);

		cbxWuerfel4 = new JCheckBox("");
		cbxWuerfel4.setBounds(183, 62, 21, 25);
		contentPane.add(cbxWuerfel4);

		lblWuerfel4 = new JLabel("");
		lblWuerfel4.setBounds(173, 19, 35, 35);
		contentPane.add(lblWuerfel4);

		cbxWuerfel5 = new JCheckBox("");
		cbxWuerfel5.setBounds(229, 62, 21, 25);
		contentPane.add(cbxWuerfel5);

		cbxWuerfel = new JCheckBox[] {
				cbxWuerfel1,
				cbxWuerfel2,
				cbxWuerfel3,
				cbxWuerfel4,
				cbxWuerfel5
		};

		lblWuerfel5 = new JLabel("");
		lblWuerfel5.setBounds(219, 19, 35, 35);
		contentPane.add(lblWuerfel5);

		lblWuerfel = new JLabel[] {
				lblWuerfel1,
				lblWuerfel2,
				lblWuerfel3,
				lblWuerfel4,
				lblWuerfel5
		};

		zeigeWuerfel(new int[]{1, 2, 3, 4, 5});

		btnWuerfeln = new JButton("Wuerfeln");
		btnWuerfeln.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				geklicktWuerfeln();
			}
		});
		btnWuerfeln.setBounds(23, 108, 227, 27);
		contentPane.add(btnWuerfeln);

		btnEintragen = new JButton("Eintragen als >>");
		btnEintragen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				geklicktEintragen();
			}
		});
		btnEintragen.setBounds(23, 147, 227, 27);
		contentPane.add(btnEintragen);

		txtBestenliste = new JTextArea();
		txtBestenliste.setBounds(23, 232, 227, 196);
		contentPane.add(txtBestenliste);

		btnNeuesSpiel = new JButton("Neues Spiel");
		btnNeuesSpiel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				geklicktNeuesSpiel();
			}
		});
		btnNeuesSpiel.setBounds(23, 440, 227, 27);
		contentPane.add(btnNeuesSpiel);

		rbtEinser = new JRadioButton("1er");
		rbtEinser.setBounds(319, 29, 49, 25);
		contentPane.add(rbtEinser);

		txtEinser = new JTextField();
		txtEinser.setEditable(false);
		txtEinser.setBounds(376, 34, 56, 15);
		contentPane.add(txtEinser);
		txtEinser.setColumns(10);

		rbtZweier = new JRadioButton("2er");
		rbtZweier.setBounds(319, 45, 49, 25);
		contentPane.add(rbtZweier);

		txtZweier = new JTextField();
		txtZweier.setEditable(false);
		txtZweier.setColumns(10);
		txtZweier.setBounds(376, 50, 56, 15);
		contentPane.add(txtZweier);

		rbtDreier = new JRadioButton("3er");
		rbtDreier.setBounds(319, 62, 49, 25);
		contentPane.add(rbtDreier);

		txtDreier = new JTextField();
		txtDreier.setEditable(false);
		txtDreier.setColumns(10);
		txtDreier.setBounds(376, 67, 56, 15);
		contentPane.add(txtDreier);

		rbtVierer = new JRadioButton("4er");
		rbtVierer.setBounds(319, 79, 49, 25);
		contentPane.add(rbtVierer);

		txtVierer = new JTextField();
		txtVierer.setEditable(false);
		txtVierer.setColumns(10);
		txtVierer.setBounds(376, 84, 56, 15);
		contentPane.add(txtVierer);

		rbtFuenfer = new JRadioButton("5er");
		rbtFuenfer.setBounds(319, 96, 49, 25);
		contentPane.add(rbtFuenfer);

		txtFuenfer = new JTextField();
		txtFuenfer.setEditable(false);
		txtFuenfer.setColumns(10);
		txtFuenfer.setBounds(376, 101, 56, 15);
		contentPane.add(txtFuenfer);

		rbtSechser = new JRadioButton("6er");
		rbtSechser.setBounds(319, 122, 49, 25);
		contentPane.add(rbtSechser);

		txtSechser = new JTextField();
		txtSechser.setEditable(false);
		txtSechser.setColumns(10);
		txtSechser.setBounds(376, 127, 56, 15);
		contentPane.add(txtSechser);

		lblSumme = new JLabel("Summe");
		lblSumme.setBounds(319, 138, 49, 25);
		contentPane.add(lblSumme);

		txtSummeOben = new JTextField();
		txtSummeOben.setEditable(false);
		txtSummeOben.setColumns(10);
		txtSummeOben.setBounds(376, 143, 56, 15);
		contentPane.add(txtSummeOben);

		lblBonus = new JLabel("Bonus");
		lblBonus.setBounds(319, 159, 49, 25);
		contentPane.add(lblBonus);

		txtBonus = new JTextField();
		txtBonus.setEditable(false);
		txtBonus.setColumns(10);
		txtBonus.setBounds(376, 164, 56, 15);
		contentPane.add(txtBonus);

		lblSummeObenMitBonus = new JLabel("Summe Oben");
		lblSummeObenMitBonus.setBounds(281, 181, 87, 25);
		contentPane.add(lblSummeObenMitBonus);

		txtSummeObenMitBonus = new JTextField();
		txtSummeObenMitBonus.setEditable(false);
		txtSummeObenMitBonus.setColumns(10);
		txtSummeObenMitBonus.setBounds(376, 186, 56, 15);
		contentPane.add(txtSummeObenMitBonus);

		rbtDreierPasch = new JRadioButton("DreierPasch");
		rbtDreierPasch.setBounds(272, 207, 96, 25);
		contentPane.add(rbtDreierPasch);

		txtDreierPasch = new JTextField();
		txtDreierPasch.setEditable(false);
		txtDreierPasch.setColumns(10);
		txtDreierPasch.setBounds(376, 212, 56, 15);
		contentPane.add(txtDreierPasch);

		rbtViererPasch = new JRadioButton("ViererPasch");
		rbtViererPasch.setBounds(272, 228, 96, 25);
		contentPane.add(rbtViererPasch);

		txtViererPasch = new JTextField();
		txtViererPasch.setEditable(false);
		txtViererPasch.setColumns(10);
		txtViererPasch.setBounds(376, 230, 56, 15);
		contentPane.add(txtViererPasch);

		rbtFullHouse = new JRadioButton("FullHouse");
		rbtFullHouse.setBounds(272, 243, 96, 25);
		contentPane.add(rbtFullHouse);

		txtFullHouse = new JTextField();
		txtFullHouse.setEditable(false);
		txtFullHouse.setColumns(10);
		txtFullHouse.setBounds(376, 248, 56, 15);
		contentPane.add(txtFullHouse);

		rbtKleineStrasse = new JRadioButton("kl. Strasse");
		rbtKleineStrasse.setBounds(272, 263, 96, 25);
		contentPane.add(rbtKleineStrasse);

		txtKleineStrasse = new JTextField();
		txtKleineStrasse.setEditable(false);
		txtKleineStrasse.setColumns(10);
		txtKleineStrasse.setBounds(376, 268, 56, 15);
		contentPane.add(txtKleineStrasse);

		rbtGrosseStrasse = new JRadioButton("gr. Strasse");
		rbtGrosseStrasse.setBounds(272, 281, 96, 25);
		contentPane.add(rbtGrosseStrasse);

		txtGrosseStrasse = new JTextField();
		txtGrosseStrasse.setEditable(false);
		txtGrosseStrasse.setColumns(10);
		txtGrosseStrasse.setBounds(376, 286, 56, 15);
		contentPane.add(txtGrosseStrasse);

		rbtKniffel = new JRadioButton("Kniffel");
		rbtKniffel.setBounds(272, 299, 96, 25);
		contentPane.add(rbtKniffel);

		txtKniffel = new JTextField();
		txtKniffel.setEditable(false);
		txtKniffel.setColumns(10);
		txtKniffel.setBounds(376, 304, 56, 15);
		contentPane.add(txtKniffel);

		rbtChance = new JRadioButton("Chance");
		rbtChance.setBounds(272, 317, 96, 25);
		contentPane.add(rbtChance);

		rbtFiguren = new JRadioButton[] {
				rbtEinser,
				rbtZweier,
				rbtDreier,
				rbtVierer,
				rbtFuenfer,
				rbtSechser,
				rbtDreierPasch,
				rbtViererPasch,
				rbtFullHouse,
				rbtKleineStrasse,
				rbtGrosseStrasse,
				rbtKniffel,
				rbtChance
		};
		rbtGroup = new ButtonGroup();
		for(JRadioButton btn : rbtFiguren){
			rbtGroup.add(btn);
		}

		txtChance = new JTextField();
		txtChance.setEditable(false);
		txtChance.setColumns(10);
		txtChance.setBounds(376, 322, 56, 15);
		contentPane.add(txtChance);

		lblSummeUnten = new JLabel("Summe Unten");
		lblSummeUnten.setBounds(272, 338, 96, 25);
		contentPane.add(lblSummeUnten);

		txtSummeUnten = new JTextField();
		txtSummeUnten.setEditable(false);
		txtSummeUnten.setColumns(10);
		txtSummeUnten.setBounds(376, 343, 56, 15);
		contentPane.add(txtSummeUnten);

		txtEndsumme = new JTextField();
		txtEndsumme.setEditable(false);
		txtEndsumme.setColumns(10);
		txtEndsumme.setBounds(376, 365, 56, 15);
		contentPane.add(txtEndsumme);

		lblEndSumme = new JLabel("Endsumme");
		lblEndSumme.setBounds(272, 360, 96, 25);
		contentPane.add(lblEndSumme);

		txtFiguren = new JTextField[] {
				txtEinser,
				txtZweier,
				txtDreier,
				txtVierer,
				txtFuenfer,
				txtSechser,
				txtDreierPasch,
				txtViererPasch,
				txtFullHouse,
				txtKleineStrasse,
				txtGrosseStrasse,
				txtKniffel,
				txtChance,
		};

		txtSummen = new JTextField[] {
				txtSummeOben,
				txtBonus,
				txtSummeObenMitBonus,
				txtSummeUnten,
				txtEndsumme
		};

		dieSteuerung = new Steuerung(this);
	}

	public void aktiviereEintragen(boolean pAktiv) {
		btnEintragen.setEnabled(pAktiv);
	}

	public void aktiviereWuerfelauswahl(boolean pAktiv) {
		for(int i = 0; i < 5; i++){
			cbxWuerfel[i].setEnabled(pAktiv);
		}
	}

	public void aktiviereWuerfel(boolean pAktiv) {
		btnWuerfeln.setEnabled(pAktiv);
	}

	public void aktiviereFiguren(boolean pAktiv){
		for(JRadioButton rbtFigur : rbtFiguren){
			rbtFigur.setEnabled(pAktiv);
		}
	}

	public String erfrageSpielername() {
		return JOptionPane.showInputDialog("Geben sie hier ihren Namen ein");
	}

	private void geklicktEintragen() {
		for (int i = 0; i < rbtFiguren.length; i++) {
			if (rbtFiguren[i].isSelected()) {
				dieSteuerung.geklicktEintragen(i);
				rbtFiguren[i].setEnabled(false);
			}
		}
	}

	private void geklicktNeuesSpiel() {
		int antwort = JOptionPane.showConfirmDialog(null, "willst du wirklich?");
		if (antwort == JOptionPane.YES_OPTION) {
			dieSteuerung.geklicktNeuesSpiel();
		}
	}

	private void geklicktWuerfeln() {
		boolean[] wuerfelWerfen = new boolean[5];
		for (int i = 0; i < 5; i++) {
			wuerfelWerfen[i] = cbxWuerfel[i].isSelected();
		}
		dieSteuerung.geklicktWuerfeln(wuerfelWerfen);
	}

	public void waehleAlleWuerfelAus() {
		for (JCheckBox w : cbxWuerfel) {
			w.setSelected(true);
		}
	}

	public void zeigeBestenliste(Endstand[] bestenliste) {
		txtBestenliste.setText("");
		for (Endstand e : bestenliste) {
			txtBestenliste.append(e.liesName() + " : " + e.liesPunkte() + System.lineSeparator());
		}
		txtBestenliste.setCaretPosition(0);
	}

	public void zeigeGewinnkarte(boolean[] pEingetragen, int[] pPunktzahl) {
		int punktZahlIndex = 0;

		while(punktZahlIndex < pEingetragen.length){
			if(pEingetragen[punktZahlIndex] == true){
				txtFiguren[punktZahlIndex].setText(Integer.toString(pPunktzahl[punktZahlIndex]));
			}
			else{
				txtFiguren[punktZahlIndex].setText(null);
			}
			punktZahlIndex++;
		}
		for(int i = 0; i < txtSummen.length; i++){
			txtSummen[i].setText(Integer.toString(pPunktzahl[punktZahlIndex]));
			punktZahlIndex++;
		}
	}

	public void zeigeNachricht(String pNachricht) {
		JOptionPane.showMessageDialog(null, pNachricht);
	}

	public void zeigeWuerfel(int[] pAugenzahl) {
		for (int i = 0; i < 5; i++) {
			URL dateiname = getClass().getResource("/images/wuerfel" + pAugenzahl[i] + ".png");
			ImageIcon icon = new ImageIcon(dateiname);
			Image img = icon.getImage().getScaledInstance(
					lblWuerfel[i].getWidth(),
					lblWuerfel[i].getHeight(),
					java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(img);
			lblWuerfel[i].setIcon(icon);
		}
	}
}
