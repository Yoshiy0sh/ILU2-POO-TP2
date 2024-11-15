package controleur;

import personnages.Chef;
import villagegaulois.Village;

public class test {
	public static void main(String[] args) {
		Village village = new Village("villageGaulois",5,5);
		Chef chef = new Chef("Abraracourcix",5,village);
		village.setChef(chef);
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Asterix", 5);
		System.out.println(controlAfficherVillage.donnerNomsVillageois()[1]);
	}
}
