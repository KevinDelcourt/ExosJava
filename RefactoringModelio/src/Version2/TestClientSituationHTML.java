package Version2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class TestClientSituationHTML {
	
	private Client client;

	@After
	public void tearDown() throws Exception {
		this.client = null;
	}
	
	private Client creerClientAvec1Film(String nomClient, String nomFilm, int typeFilm, int nbJours) {
		Client unClient = new Client(nomClient);
		Film unFilm = new Film(nomFilm, typeFilm);
		Location uneLocation = new Location(unFilm, nbJours);
		unClient.addLocation(uneLocation);
		return unClient;
	}
	
	private void ajoutLocationAUnClient(Client unClient, String nomFilm, int typeFilm, int nbJours) {
		Film unFilm = new Film(nomFilm, typeFilm);
		Location uneLocation = new Location(unFilm, nbJours);
		unClient.addLocation(uneLocation);
	}
	
	@Test
	public void testSituationPasDeFilm() {
		this.client = new Client("client");
		
		String attendu  = "<h1>Situation du client: client</h1>"
				+ "<h2>Total du 0.0</h2>"
				+ "<h3>Vous gagnez 0 points de fidelite</h3>";
		
		assertEquals(attendu,this.client.situationHTML());
	}
	
	@Test
	public void testLocationFilmNormalMoinsDe3Jours() {
		this.client = creerClientAvec1Film("un client","Taxi Driver",Film.NORMAL,2);
		
		String attendu  = "<h1>Situation du client: un client</h1>"
				+ "<h3>Taxi Driver : 2.0</h3>"
				+ "<h2>Total du 2.0</h2>"
				+ "<h3>Vous gagnez 1 points de fidelite</h3>";
		
		assertEquals(attendu,this.client.situationHTML());
	}
	
	@Test
	public void testLocationFilmNormal3JoursOuPlus() {
		this.client = creerClientAvec1Film("un client","Taxi Driver",Film.NORMAL,3);
		
		String attendu  = "<h1>Situation du client: un client</h1>"
				+ "<h3>Taxi Driver : 3.5</h3>"
				+ "<h2>Total du 3.5</h2>"
				+ "<h3>Vous gagnez 1 points de fidelite</h3>";
		
		assertEquals(attendu,this.client.situationHTML());
	}
	
	@Test
	public void testLocationNouveauteMoinsDe2Jours() {
		this.client = creerClientAvec1Film("un client","11 heures 14",Film.NOUVEAUTE,1);
		
		String attendu  = "<h1>Situation du client: un client</h1>"
				+ "<h3>11 heures 14 : 3.0</h3>"
				+ "<h2>Total du 3.0</h2>"
				+ "<h3>Vous gagnez 1 points de fidelite</h3>";
		
		assertEquals(attendu,this.client.situationHTML());
	}
	
	@Test
	public void testLocationNouveaute2JoursOuPlus() {
		this.client = creerClientAvec1Film("un client","11 heures 14",Film.NOUVEAUTE,4);

		String attendu  = "<h1>Situation du client: un client</h1>"
				+ "<h3>11 heures 14 : 12.0</h3>"
				+ "<h2>Total du 12.0</h2>"
				+ "<h3>Vous gagnez 2 points de fidelite</h3>";
		
		assertEquals(attendu,this.client.situationHTML());
	}
	
	@Test
	public void testLocationFilmEnfantMoinsDe4Jours() {
		this.client = creerClientAvec1Film("un client","Cendrillon",Film.ENFANT,3);

		String attendu   = "<h1>Situation du client: un client</h1>"
				+ "<h3>Cendrillon : 1.5</h3>"
				+ "<h2>Total du 1.5</h2>"
				+ "<h3>Vous gagnez 1 points de fidelite</h3>";
		
		assertEquals(attendu,this.client.situationHTML());
	}
	
	@Test
	public void testLocationFilmEnfant4JoursOuPlus() {
		this.client = creerClientAvec1Film("un client","Cendrillon",Film.ENFANT,4);

		String attendu  = "<h1>Situation du client: un client</h1>"
				+ "<h3>Cendrillon : 3.0</h3>"
				+ "<h2>Total du 3.0</h2>"
				+ "<h3>Vous gagnez 1 points de fidelite</h3>";
		
		assertEquals(attendu,this.client.situationHTML());
	}
	
	@Test
	public void testLocationFilmCoffret() {
		this.client = creerClientAvec1Film("un client","James Bond",Film.COFFRET_SERIES_TV,5);

		String attendu  = "<h1>Situation du client: un client</h1>"
				+ "<h3>James Bond : 2.5</h3>"
				+ "<h2>Total du 2.5</h2>"
				+ "<h3>Vous gagnez 0 points de fidelite</h3>";
		
		assertEquals(attendu,this.client.situationHTML());
	}
	
	@Test
	public void testLocationFilmCinephile1Jour() {
		this.client = creerClientAvec1Film("un client","Un taxi pour Tobrouk",Film.CINEPHILE,1);

		String attendu  = "<h1>Situation du client: un client</h1>"
				+ "<h3>Un taxi pour Tobrouk : 2.0</h3>"
				+ "<h2>Total du 2.0</h2>"
				+ "<h3>Vous gagnez 3 points de fidelite</h3>";
		
		assertEquals(attendu,this.client.situationHTML());
	}
	
	@Test
	public void testLocationFilmCinephilePlusDe1Jour() {
		this.client = creerClientAvec1Film("un client","Un taxi pour Tobrouk",Film.CINEPHILE,3);

		String attendu  = "<h1>Situation du client: un client</h1>"
				+ "<h3>Un taxi pour Tobrouk : 10.0</h3>"
				+ "<h2>Total du 10.0</h2>"
				+ "<h3>Vous gagnez 1 points de fidelite</h3>";
		
		assertEquals(attendu,this.client.situationHTML());
	}
	
	@Test
	public void testLocationCumul() {
		this.client = creerClientAvec1Film("client cumul","Taxi Driver",Film.NORMAL,2);
		ajoutLocationAUnClient(this.client,"11 heures 14",Film.NOUVEAUTE,1);
		ajoutLocationAUnClient(this.client,"Cendrillon",Film.ENFANT,2);
		
		String attendu = "<h1>Situation du client: client cumul</h1>"
				+ "<h3>Taxi Driver : 2.0</h3>"
				+ "<h3>11 heures 14 : 3.0</h3>"
				+ "<h3>Cendrillon : 1.5</h3>"
				+ "<h2>Total du 6.5</h2>"
				+ "<h3>Vous gagnez 3 points de fidelite</h3>";
		
		assertEquals(attendu,this.client.situationHTML());
	}
}
