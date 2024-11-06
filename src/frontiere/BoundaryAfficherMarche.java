package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		if(infosMarche.length == 0) System.out.println("Le marché est vide, revenez plus tard");
		else {
			System.out.println(nomAcheteur + ", vous trouverez au marché:");
			for (int i = 0; i < (infosMarche.length/3); i++) {
				StringBuilder chaine = new StringBuilder();
				chaine.append("-" + infosMarche[i]);
				i++;
				chaine.append(" qui vend " + infosMarche[i]);
				i++;
				chaine.append(" " + infosMarche[i]);
				System.out.println(chaine.toString());
			}
		}
	}
}
