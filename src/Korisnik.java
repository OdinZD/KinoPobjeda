
/**
 * Klasa korisnik predstavlja svojevrsni model, odnosno pomocu nje manipuliramo
 * podacima o korisniku.
 * 
 * @author odinWolfPerica
 *
 */
public class Korisnik {

	private String imePrezime;
	private int brojNarubeKorisnika = 0;
	private static int brojNarudbe = 0;
	private String nacinPlacanja;
	private String rezerviranaSjedala;
	private String autorizacijskihBroj;

	public Korisnik(String imePrezime) {
		this.imePrezime = imePrezime;
		brojNarudbe++;
		brojNarubeKorisnika = brojNarudbe;
	}

	/**
	 * Geteri i setteri
	 * 
	 */

	public int getBrojNarudbe() {
		return brojNarudbe;
	}

	public String getNacinPlacanja() {
		return nacinPlacanja;
	}

	public void setNacinPlacanja(String nacinPlacanja) {
		this.nacinPlacanja = nacinPlacanja;
	}

	public String getRezerviranaSjedala() {
		return rezerviranaSjedala;
	}

	public void setRezerviranaSjedala(String rezerviranaSjedala) {
		this.rezerviranaSjedala = rezerviranaSjedala;
	}

	public String getImePrezime() {
		return imePrezime;
	}

	public String getAutorizacijskihBroj() {
		return autorizacijskihBroj;
	}

	public void setAutorizacijskihBroj(String autorizacijskihBroj) {
		this.autorizacijskihBroj = autorizacijskihBroj;
	}

	public int getBrojNarubeKorisnika() {
		return brojNarubeKorisnika;
	}

	public void setBrojNarubeKorisnika(int brojNarubeKorisnika) {
		this.brojNarubeKorisnika = brojNarubeKorisnika;
	}

}
