package frontiere;


import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if(controlAcheterProduit.gauloisValide(nomAcheteur)) {
			String produit = Clavier.entrerChaine("Quel produit souhaitez-vous acheter?");
			
			String[] nomsVendeurs = controlAcheterProduit.trouverVendeursProduit(produit);
			if(nomsVendeurs != null) {
				StringBuilder optionsVendeurs = new StringBuilder();
				for (int i = 0; i < nomsVendeurs.length; i++) {
					optionsVendeurs.append((i+1) + " - " + nomsVendeurs[i] + '\n');
				}
				
				int indiceVendeur = (Clavier.entrerEntier(optionsVendeurs.toString() + "Chez quel commerçant souhaitez vous acheter des " + produit + " ?") - 1);
				if(controlAcheterProduit.gauloisValide(nomsVendeurs[indiceVendeur])) {
					System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + nomsVendeurs[indiceVendeur]);
					int nbProduit = Clavier.entrerEntier("Bonjour " + nomAcheteur + "\nCombien de " + produit + " voulez vous acheter?");
					
					if(controlAcheterProduit.etalVide(nomsVendeurs[indiceVendeur])) System.out.println(nomAcheteur + " veut acheter " + nbProduit + " malheureusement il n'y en a plus !");
					else if(controlAcheterProduit.quantiteEtalInsuffisante(nomsVendeurs[indiceVendeur],nbProduit)) { System.out.println(nomAcheteur + " veut acheter " + nbProduit + " malheureusement il n'y en a plus que "
							+ controlAcheterProduit.getQuantiteProduitEtal(nomsVendeurs[indiceVendeur]) + ". " + nomAcheteur + " achète tout le stock de " + nomsVendeurs[indiceVendeur]);
					
						controlAcheterProduit.acheterProduit(nomsVendeurs[indiceVendeur],nbProduit);
					}
					else {
						System.out.println(nomAcheteur + " achète " + nbProduit + " " + produit + " à " + nomsVendeurs[indiceVendeur]);
						controlAcheterProduit.acheterProduit(nomsVendeurs[indiceVendeur],nbProduit);
					}
				}
				else System.out.println("Je suis désolé " + nomsVendeurs[indiceVendeur] + " mais il faut être un habitant de notre village pour commercer ici");
			}
			else System.out.println("Désolé, personne ne vend ce produit au marché");
		}
		else System.out.println("Je suis désolé " + nomAcheteur + " mais il faut être un habitant de notre village pour commercer ici");
	}
}
