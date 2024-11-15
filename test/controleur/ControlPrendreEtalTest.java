package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	
	private ControlPrendreEtal controlPrendreEtal;
	private Village village;
	private Chef chef;
	
	@BeforeEach
	void initialisation(){
		village = new Village("villageGaulois",5,5);
		chef = new Chef("Abraracourcix",5,village);
		village.setChef(chef);
		controlPrendreEtal = new ControlPrendreEtal(new ControlVerifierIdentite(village),village);
	}

	@Test
	void testControlPrendreEtal() {
		assertNotNull(controlPrendreEtal);
	}
	
	@Test
	void testResteEtals() {
		assertTrue(controlPrendreEtal.resteEtals());
		
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Asterix", 5);
		//Asterix vend 10 sangliers
		controlPrendreEtal.prendreEtal("Asterix", "sanglier", 10);
		
		assertTrue(controlPrendreEtal.resteEtals());
		controlPrendreEtal.prendreEtal("Asterix", "sanglier", 10);
		
		assertTrue(controlPrendreEtal.resteEtals());
		
		controlPrendreEtal.prendreEtal("Asterix", "sanglier", 10);
		controlPrendreEtal.prendreEtal("Asterix", "sanglier", 10);
		controlPrendreEtal.prendreEtal("Asterix", "sanglier", 10);
		
		assertFalse(controlPrendreEtal.resteEtals());
	}
	
	@Test
	void testPrendreEtal() {
		assertEquals(controlPrendreEtal.prendreEtal("Asterix", "sanglier", 10),0);
		
		//cas où l'on veut prendre un étal pour vendre -1 pomme
		assertEquals(controlPrendreEtal.prendreEtal("Asterix", "fleur", -1),1);
		
		//cas où l'on veut prendre un étal pour vendre 0 pommes
		assertEquals(controlPrendreEtal.prendreEtal("Bonemine", "pomme", 0),2);
		
		controlPrendreEtal.prendreEtal("Asterix", "fleur", 3);
		controlPrendreEtal.prendreEtal("Asterix", "fleur", 3);
		
		assertEquals(controlPrendreEtal.prendreEtal("Asterix", "fleur", 3),-1);
	}
	
	@Test
	void testVerifierIdentite() {
		assertFalse(controlPrendreEtal.verifierIdentite("Asterix"));
		
		controlPrendreEtal.prendreEtal("Asterix", "sanglier", 5);
		assertFalse(controlPrendreEtal.verifierIdentite("Asterix"));
		
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Asterix", 5);
		
		assertTrue(controlPrendreEtal.verifierIdentite("Asterix"));
	}

}
