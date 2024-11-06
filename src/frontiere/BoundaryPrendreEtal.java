package frontiere;


import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis d�sol�e" + nomVendeur + " mais il faut �tre un ha"
					+ "bitant de notre village pour commercer ici.");
		} else {
			System.out.println("Bonjour " + nomVendeur + " je vais regarder si je peux vous"
					+ "trouver un �tal.");
			if (!controlPrendreEtal.resteEtals()) {
				System.out.println("D�sol�e "+nomVendeur+" je n'ai plus d'�tal qui ne soit "
						+ "d�j� occup�");
			} else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me reste un �tal pour vous !\n"
				+ "Il me faudrait quelques renseignements :");
		String produit = Clavier.entrerChaine("Quel produit souhaitez vous vendre ?");
		int nbProduit = Clavier.entrerEntier("Combien souhaitez vous en vendre ?");
		
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit,nbProduit);
		if(numeroEtal != -1) {
			System.out.println("Le vendeur "+nomVendeur+" s'est install� � l'�tal n�" + (numeroEtal+1));
		}
	}
}
