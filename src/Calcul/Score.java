package Calcul;

public class Score {

    private int pointsSociete1;
    private int pointsSociete2;

    public Score() {
        this.pointsSociete1 = 0;
        this.pointsSociete2 = 0;
    }

    public void ajouterPointSociete1(int points) {
        this.pointsSociete1 += points;
    }

    public void ajouterPointSociete2(int points) {
        this.pointsSociete2 += points;
    }

    public int getPointsSociete1() {
        return pointsSociete1;
    }

    public int getPointsSociete2() {
        return pointsSociete2;
    }

    public String enregistrerResultatCombat(Combat combat) {
        if (combat == null) {
            return "Combat invalide.";
        }

        String resultat = combat.demarrerCombat();
        Livreur gagnant = null;

        String nom1 = combat.getLivreur1().getNomLivreur();
        String nom2 = combat.getLivreur2().getNomLivreur();

        // S�lection du gagnant selon le texte retourn�
        if (resultat.contains(nom1)) {
            gagnant = combat.getLivreur1();
        } else if (resultat.contains(nom2)) {
            gagnant = combat.getLivreur2();
        }

        if (gagnant == null) {
            return resultat + "\n�galit� d�tect�e, aucun point attribu�.";
        }

        if (gagnant.getMaSociete().getIdSociete() == 1) {
            ajouterPointSociete1(10);
        } else {
            ajouterPointSociete2(10);
        }

        return resultat + "\nPoint attribu� � : " + gagnant.getMaSociete().getNomSociete();
    }

    public String getGagnant(String nom1, String nom2) {
        if (pointsSociete1 > pointsSociete2) {
            return nom1 + " gagne avec " + pointsSociete1 + " points !";
        } else if (pointsSociete2 > pointsSociete1) {
            return nom2 + " gagne avec " + pointsSociete2 + " points !";
        } else {
            return "�galit� parfaite entre les deux soci�t�s !";
        }
    }

    @Override
    public String toString() {
        return "Score : " + pointsSociete1 + " pts pour Societe1 | "
                + pointsSociete2 + " pts pour Societe2";
    }
}
