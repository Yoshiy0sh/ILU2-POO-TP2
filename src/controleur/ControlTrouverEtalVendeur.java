package controleur;

import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlTrouverEtalVendeur {
	private Village village;

	public ControlTrouverEtalVendeur(Village village) {
		this.village = village;
	}

	public Etal trouverEtalVendeur(String nomVendeur) {
		if(village.trouverHabitant(nomVendeur) != null) return village.rechercherEtal(village.trouverHabitant(nomVendeur));
		else return null;
	}
	
	public String[] trouverDonneesEtal(String nomVendeur) {
		Etal etal =  village.rechercherEtal(village.trouverHabitant(nomVendeur));
		if(etal != null) return etal.etatEtal();
		else return null;
	}
}
