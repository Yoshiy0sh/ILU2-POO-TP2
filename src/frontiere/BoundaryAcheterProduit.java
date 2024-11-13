package frontiere;


import controleur.ControlAcheterProduit;
import exceptions.InvalidGauloisException;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		try {
			verifierGaulois(nomAcheteur);
			String produit = Clavier.entrerChaine("Quel produit souhaitez-vous acheter?");
			String[] nomsVendeurs = affichageVendeurs(produit);
			int indiceVendeur = (Clavier.entrerEntier("Chez quel commer�ant souhaitez vous acheter des " + produit + " ?") - 1);
			
			String nomVendeur = nomsVendeurs[indiceVendeur];
			verifierGaulois(nomVendeur);
			System.out.println(nomAcheteur + " se d�place jusqu'� l'�tal du vendeur " + nomVendeur);
			int nbProduit = Clavier.entrerEntier("Bonjour " + nomAcheteur + "\nCombien de " + produit + " voulez vous acheter?");
			verifierEtal(nomAcheteur,nomVendeur,nbProduit,produit);
		}
		catch(NullPointerException | InvalidGauloisException e) {
		}
		
	}
		
	private void verifierGaulois(String nomGaulois) throws InvalidGauloisException{
		if(!controlAcheterProduit.gauloisValide(nomGaulois)) {
			System.out.println("Je suis d�sol� " + nomGaulois + " mais il faut �tre un habitant de notre village pour commercer ici");
			throw new InvalidGauloisException();
		}
	}
	
	private String[] affichageVendeurs(String produit) throws NullPointerException {
		String[] nomsVendeurs = controlAcheterProduit.trouverVendeursProduit(produit);
		if(nomsVendeurs == null) {
			System.out.println("Désolé, personne ne vend ce produit au marché");
			throw new NullPointerException();
		}
		else {
			StringBuilder optionsVendeurs = new StringBuilder();
			for (int i = 0; i < nomsVendeurs.length; i++) {
				optionsVendeurs.append((i+1) + " - " + nomsVendeurs[i] + '\n');
			}
			System.out.println(optionsVendeurs.toString());
			return nomsVendeurs;
		}
	}
	
	private void verifierEtal(String nomAcheteur, String nomVendeur,int nbProduit,String produit) {
		if(controlAcheterProduit.etalVide(nomVendeur)) System.out.println(nomAcheteur + " veut acheter " + nbProduit + " malheureusement il n'y en a plus !");
		else if(controlAcheterProduit.quantiteEtalInsuffisante(nomVendeur,nbProduit)) { System.out.println(nomAcheteur + " veut acheter " + nbProduit + " malheureusement il n'y en a plus que "
				+ controlAcheterProduit.getQuantiteProduitEtal(nomVendeur) + ". " + nomAcheteur + " ach�te tout le stock de " + nomVendeur);
		
			controlAcheterProduit.acheterProduit(nomVendeur,nbProduit);
		}
		else {
			System.out.println(nomAcheteur + " ach�te " + nbProduit + " " + produit + " � " + nomVendeur);
			controlAcheterProduit.acheterProduit(nomVendeur,nbProduit);
		}
	}
}
