package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	
	private ControlAfficherMarche controlAfficherMarche;
	private Village village;
	private Chef chef;
	
	@BeforeEach
	void initialisation(){
		village = new Village("villageGaulois",5,5);
		chef = new Chef("Abraracourcix",5,village);
		village.setChef(chef);
		controlAfficherMarche = new ControlAfficherMarche(village);
	}

	@Test
	void testControlAfficherMarche() {
		assertNotNull(controlAfficherMarche);
	}
	
	@Test
	void testDonnerInfosMarche() {
		
	}

}
