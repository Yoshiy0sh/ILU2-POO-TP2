package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private Village village;
	private Chef chef;
	
	@BeforeEach
	void initialisation(){
		village = new Village("villageGaulois",5,5);
		chef = new Chef("Abraracourcix",5,village);
		village.setChef(chef);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
	}
	

	@Test
	void testControltrouverEtalVendeur() {
		assertNotNull(controlTrouverEtalVendeur);
	}
	
	@Test
	void testTrouverEtalVendeur() {
		assertNull(controlTrouverEtalVendeur.trouverEtalVendeur("rien"));
		
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Asterix", 5);
		assertNull(controlTrouverEtalVendeur.trouverEtalVendeur("Asterix"));
		
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(new ControlVerifierIdentite(village), village);
		controlPrendreEtal.prendreEtal("Asterix", "sanglier", 1);
		
		assertNotNull(controlTrouverEtalVendeur.trouverEtalVendeur("Asterix"));
	}
	
	@Test
	
	void testTrouverDonneesEtal() {
		assertNull(controlTrouverEtalVendeur.trouverDonneesEtal("Asterix"));
	}
}
