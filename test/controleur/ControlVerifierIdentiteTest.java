package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	
	private ControlVerifierIdentite controlVerifierIdentite;
	private Village village;
	private Chef chef;
	
	@BeforeEach
	void initialisation(){
		village = new Village("villageGaulois",5,5);
		chef = new Chef("Abraracourcix",5,village);
		village.setChef(chef);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
	}
	
	@Test
	void testControlVerifierIdentite() {
		assertNotNull(controlVerifierIdentite);
	}
	
	@Test
	void testVerifierIdentite() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Asterix", 5);
		assertTrue(controlVerifierIdentite.verifierIdentite("Asterix"));
		assertFalse(controlVerifierIdentite.verifierIdentite("rien"));
		
		//test pour un villageois dupliqué
		controlEmmenager.ajouterGaulois("Asterix", 5);
		assertTrue(controlVerifierIdentite.verifierIdentite("Asterix"));
		
		//test pour un second villageois druide
		controlEmmenager.ajouterDruide("Panoramix", 5, 5, 6);
		assertTrue(controlVerifierIdentite.verifierIdentite("Panoramix"));
	}
}
