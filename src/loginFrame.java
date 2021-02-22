import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * 
 * Klasa loginFrame zaduzena je za kreiranje vizualnih komponentni za unos imena prilikom pokretanja Kina.
 * 
 * 
 * @author odinWolfPerica
 *
 */

public class loginFrame extends JFrame {

	private JButton btnNastavi;
	private JTextField textFieldImePrezime;
	public static Korisnik korisnik;

	public loginFrame() {

		createComponents();
		setTitle("Login");
		setVisible(true);
		activateElements();

	}
	
	/**
	 * Metoda koja stavlja actionListener na bottun. 
	 * Kada se pritisne na gumb nastavi, kreira se novi korisnik kojemu
	 * se dodjeljuje ime koje je uneseno u textField na ekranu, onda se disposa
	 * trenutni prozor i stvara objekt Kino.
	 */

	private void activateElements() {
		// TODO Auto-generated method stub

		btnNastavi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				korisnik = new Korisnik(textFieldImePrezime.getText());
				java.awt.EventQueue.invokeLater(new Runnable() {
					public void run() {

						new Kino().setVisible(true);
						dispose();

					}
				});

			}
		});

	}
	
	/**
	 * Metoda koja kreira sve vizualne komponente loginFramea.
	 * 
	 */

	private void createComponents() {
		// TODO Auto-generated method stub

		setSize(600, 400);
		getContentPane().setFont(new Font("Verdana", Font.PLAIN, 16));
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Dobrodo\u0161li u Kino Pobjedu!");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 564, 49);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Za nastavak molimo unesite va\u0161e ime i prezime.");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 61, 564, 58);
		getContentPane().add(lblNewLabel_1);

		textFieldImePrezime = new JTextField();
		textFieldImePrezime.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldImePrezime.setFont(new Font("Verdana", Font.PLAIN, 16));
		textFieldImePrezime.setBounds(10, 165, 564, 49);
		getContentPane().add(textFieldImePrezime);
		textFieldImePrezime.setColumns(10);

		btnNastavi = new JButton("Nastavi");
		btnNastavi.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnNastavi.setBounds(347, 283, 227, 49);
		getContentPane().add(btnNastavi);

	}
	
}
