package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import Version1.*;

public class TestSituationClient {
	
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
		
		String attendu  = "Situation du client: client\n"
				+ "Total du 0.0\n"
				+ "Vous gagnez 0 points de fidelite\n";
		
		assertEquals(attendu,this.client.situation());
	}
	
	@Test
	public void testLocationFilmNormalMoinsDe3Jours() {
		this.client = creerClientAvec1Film("un client","Taxi Driver",Film.NORMAL,2);
		
		String attendu  = "Situation du client: un client\n"
				+ "\tTaxi Driver\t2.0\n"
				+ "Total du 2.0\n"
				+ "Vous gagnez 1 points de fidelite\n";
		
		assertEquals(attendu,this.client.situation());
	}
	
	@Test
	public void testLocationFilmNormal3JoursOuPlus() {
		this.client = creerClientAvec1Film("un client","Taxi Driver",Film.NORMAL,3);
		
		String attendu  = "Situation du client: un client\n"
				+ "\tTaxi Driver\t3.5\n"
				+ "Total du 3.5\n"
				+ "Vous gagnez 1 points de fidelite\n";
		
		assertEquals(attendu,this.client.situation());
	}
	
	@Test
	public void testLocationNouveauteMoinsDe2Jours() {
		this.client = creerClientAvec1Film("un client","11 heures 14",Film.NOUVEAUTE,1);
		
		String attendu  = "Situation du client: un client\n"
				+ "\t11 heures 14\t3.0\n"
				+ "Total du 3.0\n"
				+ "Vous gagnez 1 points de fidelite\n";
		
		assertEquals(attendu,this.client.situation());
	}
	
	@Test
	public void testLocationNouveaute2JoursOuPlus() {
		this.client = creerClientAvec1Film("un client","11 heures 14",Film.NOUVEAUTE,4);

		String attendu  = "Situation du client: un client\n"
				+ "\t11 heures 14\t12.0\n"
				+ "Total du 12.0\n"
				+ "Vous gagnez 2 points de fidelite\n";
		
		assertEquals(attendu,this.client.situation());
	}
	
	@Test
	public void testLocationFilmEnfantMoinsDe4Jours() {
		this.client = creerClientAvec1Film("un client","Cendrillon",Film.ENFANT,3);

		String attendu   = "Situation du client: un client\n"
				+ "\tCendrillon\t1.5\n"
				+ "Total du 1.5\n"
				+ "Vous gagnez 1 points de fidelite\n";
		
		assertEquals(attendu,this.client.situation());
	}
	
	@Test
	public void testLocationFilmEnfant4JoursOuPlus() {
		this.client = creerClientAvec1Film("un client","Cendrillon",Film.ENFANT,4);

		String attendu  = "Situation du client: un client\n"
				+ "\tCendrillon\t3.0\n"
				+ "Total du 3.0\n"
				+ "Vous gagnez 1 points de fidelite\n";
		
		assertEquals(attendu,this.client.situation());
	}
	
	@Test
	public void testLocationCumul() {
		this.client = creerClientAvec1Film("client cumul","Taxi Driver",Film.NORMAL,2);
		ajoutLocationAUnClient(this.client,"11 heures 14",Film.NOUVEAUTE,1);
		ajoutLocationAUnClient(this.client,"Cendrillon",Film.ENFANT,2);
		
		String attendu = "Situation du client: client cumul\n"
				+ "\tTaxi Driver\t2.0\n"
				+ "\t11 heures 14\t3.0\n"
				+ "\tCendrillon\t1.5\n"
				+ "Total du 6.5\n"
				+ "Vous gagnez 3 points de fidelite\n";
		
		assertEquals(attendu,this.client.situation());
	}
}
