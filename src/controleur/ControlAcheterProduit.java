package controleur;

import villagegaulois.Village;
import personnages.Gaulois;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public String[] trouverVendeursProduit(String produit) {
		Gaulois[] tabVendeurs = village.rechercherVendeursProduit(produit);
		if(tabVendeurs != null) {
			String[] nomsVendeurs = new String[tabVendeurs.length];
			for (int i = 0; i < tabVendeurs.length; i++) {
				nomsVendeurs[i] = tabVendeurs[i].getNom();
			}
			return nomsVendeurs;
		}
		else return null;
	}
	
	public void acheterProduit(String nomVendeur, int quantite) {
		village.rechercherEtal(village.trouverHabitant(nomVendeur)).acheterProduit(quantite);
	}
	
	public boolean gauloisValide(String nomVendeur) {
		return controlVerifierIdentite.verifierIdentite(nomVendeur);
	}
	
	public boolean etalVide(String nomVendeur) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).getQuantite() == 0;
	}
	
	public int getQuantiteProduitEtal(String nomAcheteur) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomAcheteur).getQuantite();
	}
	
	public boolean quantiteEtalInsuffisante(String nomAcheteur, int quantite) {
		return getQuantiteProduitEtal(nomAcheteur) < quantite;
	}
}
