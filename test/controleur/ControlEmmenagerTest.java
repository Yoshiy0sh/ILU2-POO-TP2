package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlEmmenagerTest {
	
	private Village village;
	private Chef chef;
	private ControlEmmenager controlEmmenager;
	
	@BeforeEach
	void initialiser() {
		village = new Village("villageGaulois",5,5);
		chef = new Chef("Abraracourcix",5,village);
		village.setChef(chef);
		controlEmmenager = new ControlEmmenager(village);
	}

	@Test
	void testControlEmmenager() {
		assertNotNull(controlEmmenager);
	}
	
	@Test
	void testIsHabitant() {
		controlEmmenager.ajouterGaulois("Bonemine",5);
		assertTrue(controlEmmenager.isHabitant("Bonemine"));
		assertFalse(controlEmmenager.isHabitant("rien"));
		controlEmmenager.ajouterDruide("Panoramix", 4, 4, 5);
		assertTrue(controlEmmenager.isHabitant("Panoramix"));
	}
	
	@Test
	void testAjouterDruide() {
		controlEmmenager.ajouterDruide("Panoramix", 4, 5, 6);
		assertTrue(controlEmmenager.isHabitant("Panoramix"));
		
		//test pour un second ajout similaire
		controlEmmenager.ajouterDruide("Panoramix", 4, 5, 6);
		assertTrue(controlEmmenager.isHabitant("Panoramix"));
		
		//test pour l'ajout d'un gaulois classique en plus
		controlEmmenager.ajouterGaulois("Bonemine", 4);
		assertTrue(controlEmmenager.isHabitant("Bonemine"));
		
		//test pour un autre druide (intéressant de remarquer que la potion min > potion max)
		controlEmmenager.ajouterDruide("Prolix", 4, 8, 7);
		assertTrue(controlEmmenager.isHabitant("Prolix"));
		assertTrue(controlEmmenager.isHabitant("Panoramix"));
	}
	
	@Test
	void testAjouterGaulois() {
		controlEmmenager.ajouterGaulois("Asterix", 5);
		assertTrue(controlEmmenager.isHabitant("Asterix"));
		

		controlEmmenager.ajouterGaulois("Asterix", 5);
		assertTrue(controlEmmenager.isHabitant("Asterix"));
	}

}
