package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	
	private ControlAfficherVillage controlAfficherVillage;
	private Village village;
	private Chef chef;
	
	@BeforeEach
	void initialiser() {
		village = new Village("villageGaulois",5,5);
		chef = new Chef("Abraracourcix",5,village);
		village.setChef(chef);
		controlAfficherVillage = new ControlAfficherVillage(village);
	}

	@Test
	void testControlAfficherVIllage() {
		assertNotNull(controlAfficherVillage);
	}
	
	@Test
	void testDonnerNomsVillageois() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Asterix", 5);
		
		assertEquals(controlAfficherVillage.donnerNomsVillageois()[0],"Abraracourcix");
		assertEquals(controlAfficherVillage.donnerNomsVillageois()[1],"Asterix");
		
		
		//vérifier que le troisième habitant s'appelle bien Astérix
		controlEmmenager.ajouterGaulois("Asterix", 5);
		assertEquals(controlAfficherVillage.donnerNomsVillageois()[2], "Asterix");
		
	}
	
	@Test
	void testDonnerNomVillage() {
		assertEquals(controlAfficherVillage.donnerNomVillage(),"villageGaulois");
	}
	
	@Test
	void testDonnerNbEtals() {
		assertEquals(controlAfficherVillage.donnerNbEtals(), 5);
	}

}
