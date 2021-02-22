import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * Klasa Kino glavni je prozor aplikacije. Frame je podjeljen na dva dijela. Lijevi s podatcima o korisniku i odabranim sjedalima, 
 * a s desne strane imamo ikonu platna i moguca sjedala koja idu od A1 do C4. pritiskom na sijedalo (odnosno Jbutton koji ima ikonu sjedala) 
 * dodaje se u odabrana sjedala korisnika. Korisnik kada izabere nacin placanja i rezervira sjedalo ili njih vi�e,
 * dobija broj s kojim treba preuzeti karte. 
 * 
 * @author odinWolfPerica
 *
 */
public class Kino extends JFrame {

	private JMenuBar menuBar;
	private JMenu mnFile;
	private JPanel glavniPanel;
	private JPanel userPanel;
	private JPanel kinoPanel;
	private JTextField txtImeIPrezime;
	private JTextField txtBrojNarudbe;
	private JButton btnKupi;
	private JTextField txtOdabranaSjedala;
	private JComboBox karticeBox;
	private JLabel lblPlatno;
	private JButton btnA1;
	private JButton btnA2;
	private JButton btnA3;
	private JButton btnA4;
	private JButton btnB1;
	private JButton btnB2;
	private JButton btnB3;
	private JButton btnB4;
	private JButton btnC1;
	private JButton btnC2;
	private JButton btnC3;
	private JButton btnC4;

	File output = new File("output.txt");

	ImageIcon chair = new ImageIcon("icons/chair.png");
	ImageIcon chairClicked = new ImageIcon("icons/chairClicked.png");

	private Korisnik korisnik;

	public static ArrayList<Korisnik> listaKorisnika = new ArrayList<>();
	private JMenuItem mntmSaveToFile;
	private JMenuItem mntmExit;

	public Kino() {

		createComponents();
		getKorisnikInfo();
		activateElements();
		setVisible(true);

	}
	
	/**
	 * Metoda koja na txtFieldove postavlja podatke o korisniku.
	 */

	private void getKorisnikInfo() {
		// TODO Auto-generated method stub

		korisnik = loginFrame.korisnik;
		listaKorisnika.add(korisnik);
		txtImeIPrezime.setText(korisnik.getImePrezime());
		txtBrojNarudbe.setText(String.valueOf(korisnik.getBrojNarudbe()));
	}

	
	/**
	 * Metoda koja kreira sve vizualne komponente.
	 */
	private void createComponents() {

		setSize(850, 600);
		setResizable(false);
		getContentPane().setLayout(null);

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 844, 22);
		getContentPane().add(menuBar);

		mnFile = new JMenu("File");
		menuBar.add(mnFile);

		mntmSaveToFile = new JMenuItem("Save to file");
		mnFile.add(mntmSaveToFile);

		JSeparator separator = new JSeparator();
		mnFile.add(separator);

		mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);

		glavniPanel = new JPanel();
		glavniPanel.setBounds(10, 29, 824, 531);
		getContentPane().add(glavniPanel);
		glavniPanel.setLayout(null);

		userPanel = new JPanel();
		userPanel.setBorder(new LineBorder(new Color(0, 0, 255), 4));
		userPanel.setBounds(0, -11, 411, 520);
		glavniPanel.add(userPanel);
		userPanel.setLayout(null);

		JLabel lblPodatciKorisnik = new JLabel("Podatci o korisniku");
		lblPodatciKorisnik.setFont(new Font("Verdana", Font.BOLD, 24));
		lblPodatciKorisnik.setHorizontalAlignment(SwingConstants.CENTER);
		lblPodatciKorisnik.setBounds(10, 22, 391, 39);
		userPanel.add(lblPodatciKorisnik);

		Canvas canvas = new Canvas();
		canvas.setBackground(Color.BLUE);
		canvas.setBounds(0, 67, 411, 4);
		userPanel.add(canvas);

		Canvas canvas_1 = new Canvas();
		canvas_1.setBounds(0, 10, 411, 4);
		userPanel.add(canvas_1);
		canvas_1.setBackground(Color.BLUE);

		txtImeIPrezime = new JTextField();
		txtImeIPrezime.setEditable(false);
		txtImeIPrezime.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtImeIPrezime.setText("Ime i Prezime");
		txtImeIPrezime.setBounds(107, 99, 294, 33);
		userPanel.add(txtImeIPrezime);
		txtImeIPrezime.setColumns(10);

		txtBrojNarudbe = new JTextField();
		txtBrojNarudbe.setEditable(false);
		txtBrojNarudbe.setText("Broj narud\u017Ebe");
		txtBrojNarudbe.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtBrojNarudbe.setColumns(10);
		txtBrojNarudbe.setBounds(107, 162, 294, 33);
		userPanel.add(txtBrojNarudbe);

		karticeBox = new JComboBox();
		karticeBox.setFont(new Font("Verdana", Font.PLAIN, 14));
		karticeBox.setModel(
				new DefaultComboBoxModel(new String[] { "Visa", "Mastercard", "American Express", "Paypall" }));
		karticeBox.setBounds(107, 222, 294, 33);
		userPanel.add(karticeBox);

		txtOdabranaSjedala = new JTextField();
		txtOdabranaSjedala.setEditable(false);
		txtOdabranaSjedala.setText("Odabrana sjedala:");
		txtOdabranaSjedala.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtOdabranaSjedala.setColumns(10);
		txtOdabranaSjedala.setBounds(107, 346, 294, 33);
		userPanel.add(txtOdabranaSjedala);

		btnKupi = new JButton("Kupi");
		btnKupi.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnKupi.setBounds(174, 432, 151, 33);
		userPanel.add(btnKupi);

		kinoPanel = new JPanel();
		kinoPanel.setBorder(new LineBorder(Color.BLUE, 4));
		kinoPanel.setBounds(409, 0, 415, 509);
		glavniPanel.add(kinoPanel);
		kinoPanel.setLayout(null);

		lblPlatno = new JLabel("");
		lblPlatno.setBounds(10, 34, 395, 105);
		lblPlatno.setIcon(new ImageIcon("icons/kinoPlatno.png"));
		kinoPanel.add(lblPlatno);

		btnA1 = new JButton("A1");
		btnA1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnA1.setBounds(10, 190, 90, 75);
		btnA1.setIcon(chair);
		kinoPanel.add(btnA1);

		btnA2 = new JButton("A2");
		btnA2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnA2.setBounds(115, 190, 90, 75);
		btnA2.setIcon(chair);
		kinoPanel.add(btnA2);

		btnA3 = new JButton("A3");
		btnA3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnA3.setBounds(215, 190, 90, 75);
		btnA3.setIcon(chair);
		kinoPanel.add(btnA3);

		btnA4 = new JButton("A4");
		btnA4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnA4.setBounds(315, 190, 90, 75);
		btnA4.setIcon(chair);
		kinoPanel.add(btnA4);

		btnB1 = new JButton("B1");
		btnB1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnB1.setBounds(10, 276, 90, 75);
		btnB1.setIcon(chair);
		kinoPanel.add(btnB1);

		btnB2 = new JButton("B2");
		btnB2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnB2.setBounds(117, 276, 90, 75);
		btnB2.setIcon(chair);
		kinoPanel.add(btnB2);

		btnB3 = new JButton("B3");
		btnB3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnB3.setBounds(216, 276, 90, 75);
		btnB3.setIcon(chair);
		kinoPanel.add(btnB3);

		btnB4 = new JButton("B4");
		btnB4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnB4.setBounds(315, 276, 90, 75);
		btnB4.setIcon(chair);
		kinoPanel.add(btnB4);

		btnC1 = new JButton("C1");
		btnC1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnC1.setBounds(10, 362, 90, 75);
		btnC1.setIcon(chair);
		kinoPanel.add(btnC1);

		btnC2 = new JButton("C2");
		btnC2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnC2.setBounds(117, 362, 90, 75);
		btnC2.setIcon(chair);
		kinoPanel.add(btnC2);

		btnC3 = new JButton("C3");
		btnC3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnC3.setBounds(217, 362, 90, 75);
		btnC3.setIcon(chair);
		kinoPanel.add(btnC3);

		btnC4 = new JButton("C4");
		btnC4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnC4.setBounds(315, 362, 90, 75);
		btnC4.setIcon(chair);
		kinoPanel.add(btnC4);

	}
	
	/**
	 * Metoda koja dodaje action listenere na Jbuttone.
	 * 
	 * btnA1 - btnC4 ---> Provjerava dali je ikona na botunu postavljena u dostupno sjedalo, ukoliko je, stavlja mu ikonu u nedostupno sjedalo.
	 * 
	 * btnKupi ---> Izvr�ava kupovinu karata za odabrana sjedala i daje korisniku rezervacijski broj nakon cega provjerava
	 * zelimo li kreirati novog kupca.
	 * 
	 * mntmSaveToFile ---> Sprema u tekstualnu datoteku podatke o svim kupcima u trenutnoj sesiji programa.
	 */

	private void activateElements() {

		btnA1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (btnA1.getIcon() == chair) {

					btnA1.setIcon(chairClicked);
					txtOdabranaSjedala.setText(txtOdabranaSjedala.getText() + " " + btnA1.getText());

				}

			}
		});

		btnA2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (btnA2.getIcon() == chair) {

					btnA2.setIcon(chairClicked);
					txtOdabranaSjedala.setText(txtOdabranaSjedala.getText() + " " + btnA2.getText());

				}

			}
		});

		btnA3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (btnA3.getIcon() == chair) {

					btnA3.setIcon(chairClicked);
					txtOdabranaSjedala.setText(txtOdabranaSjedala.getText() + " " + btnA3.getText());

				}

			}
		});

		btnA4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (btnA4.getIcon() == chair) {

					btnA4.setIcon(chairClicked);
					txtOdabranaSjedala.setText(txtOdabranaSjedala.getText() + " " + btnA4.getText());

				}

			}
		});

		btnB1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (btnB1.getIcon() == chair) {

					btnB1.setIcon(chairClicked);
					txtOdabranaSjedala.setText(txtOdabranaSjedala.getText() + " " + btnB1.getText());

				}

			}
		});

		btnB2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (btnB2.getIcon() == chair) {

					btnB2.setIcon(chairClicked);
					txtOdabranaSjedala.setText(txtOdabranaSjedala.getText() + " " + btnB2.getText());

				}

			}
		});

		btnB3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (btnB3.getIcon() == chair) {

					btnB3.setIcon(chairClicked);
					txtOdabranaSjedala.setText(txtOdabranaSjedala.getText() + " " + btnB3.getText());

				}

			}
		});
		btnB4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (btnB4.getIcon() == chair) {

					btnB4.setIcon(chairClicked);
					txtOdabranaSjedala.setText(txtOdabranaSjedala.getText() + " " + btnB4.getText());

				}

			}
		});

		btnC1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (btnC1.getIcon() == chair) {

					btnC1.setIcon(chairClicked);
					txtOdabranaSjedala.setText(txtOdabranaSjedala.getText() + " " + btnC1.getText());

				}

			}
		});

		btnC2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (btnC2.getIcon() == chair) {

					btnC2.setIcon(chairClicked);
					txtOdabranaSjedala.setText(txtOdabranaSjedala.getText() + " " + btnC2.getText());

				}

			}
		});

		btnC3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (btnC3.getIcon() == chair) {

					btnC3.setIcon(chairClicked);
					txtOdabranaSjedala.setText(txtOdabranaSjedala.getText() + " " + btnC3.getText());

				}

			}
		});

		btnC4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (btnC4.getIcon() == chair) {

					btnC4.setIcon(chairClicked);
					txtOdabranaSjedala.setText(txtOdabranaSjedala.getText() + " " + btnC4.getText());

				}

			}
		});

		btnKupi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				korisnik.setNacinPlacanja(karticeBox.getSelectedItem().toString());
				korisnik.setRezerviranaSjedala(txtOdabranaSjedala.getText());
				korisnik.setAutorizacijskihBroj(getRandomString());
				JOptionPane.showMessageDialog(null,
						"Hvala vam na kupnji, molimo vas zapamtite svoj autorizacijski broj da bi mogli preuzeti ulaznice! Va� broj je: "
								+ korisnik.getAutorizacijskihBroj());

				String name = JOptionPane.showInputDialog("Molimo vas unesite va�e ime i prezime!");

				if (name == null) {

//					System.out.println("Cancel is pressed!");
//					System.out.println("Program is terminated!");
//
//					try {
//						FileWriter writer = new FileWriter(output, true);
//						for (Korisnik korisnik : listaKorisnika) {
//
//							writer.write("Ime i prezime kupca: " + korisnik.getImePrezime() + "\n");
//							writer.write("Broj narudbe: " + String.valueOf(korisnik.getBrojNarubeKorisnika()) + "\n");
//							writer.write("Nacin placanja: " + korisnik.getNacinPlacanja() + "\n");
//							writer.write("Autorizacijski broj: " + korisnik.getAutorizacijskihBroj() + "\n\n");
//							writer.flush();
//						}
//
//						writer.close();
//
//					} catch (IOException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//
//					System.exit(1);
				} else {

					korisnik = new Korisnik(name);
					// korisnik.setBrojNarudbe(korisnik.getBrojNarudbe() + 1);
					txtImeIPrezime.setText(korisnik.getImePrezime());
					txtBrojNarudbe.setText(String.valueOf(korisnik.getBrojNarudbe()));
					txtOdabranaSjedala.setText("Odabrana sjedala:");
					listaKorisnika.add(korisnik);

				}
			}
		});

		mntmExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				System.out.println("Exit is clicked...");
				System.exit(1);

			}
		});

		mntmSaveToFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				try {
					FileWriter writer = new FileWriter(output, true);
					for (Korisnik korisnik : listaKorisnika) {

						writer.write("Ime i prezime kupca: " + korisnik.getImePrezime() + "\n");
						writer.write("Broj narudbe: " + String.valueOf(korisnik.getBrojNarubeKorisnika()) + "\n");
						writer.write("Nacin placanja: " + korisnik.getNacinPlacanja() + "\n");
						writer.write("Autorizacijski broj: " + korisnik.getAutorizacijskihBroj() + "\n\n");
						writer.flush();
					}

					writer.close();

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public static ArrayList<Korisnik> getListaKorisnika() {
		return listaKorisnika;
	}

	public String getRandomString() {

		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 6;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		String generatedString = buffer.toString();
		return generatedString;

	}
}
