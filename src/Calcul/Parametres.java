package Calcul;

public class Parametres {

    private int nbLivreur;
    private int nbRival;
    private int nbDepot;
    private Combat modeCombat;

    // Attributs pour les dimensions de la carte
    private int tailleCarteX;
    private int tailleCarteY;

    public Parametres(int nbLivreur, int nbRival, int nbDepot, Combat modeCombat) {
        this.nbLivreur = nbLivreur;
        this.nbRival = nbRival;
        this.nbDepot = nbDepot;
        this.modeCombat = modeCombat;

        // Dimensions par d�faut
        this.tailleCarteX = 10;
        this.tailleCarteY = 10;
    }

    public int getNbLivreur() {
        return nbLivreur;
    }

    public void setNbLivreur(int nbLivreur) {
        this.nbLivreur = nbLivreur;
    }

    public int getNbRival() {
        return nbRival;
    }

    public void setNbRival(int nbRival) {
        this.nbRival = nbRival;
    }

    public int getNbDepot() {
        return nbDepot;
    }

    public void setNbDepot(int nbDepot) {
        this.nbDepot = nbDepot;
    }

    public Combat getModeCombat() {
        return modeCombat;
    }

    public void setModeCombat(Combat modeCombat) {
        this.modeCombat = modeCombat;
    }

    // Getters et Setters pour taille de carte
    public int getTailleCarteX() {
        return tailleCarteX;
    }

    public void setTailleCarteX(int tailleCarteX) {
        this.tailleCarteX = tailleCarteX;
    }

    public int getTailleCarteY() {
        return tailleCarteY;
    }

    public void setTailleCarteY(int tailleCarteY) {
        this.tailleCarteY = tailleCarteY;
    }

    @Override
    public String toString() {
        return "Param�tres [nbLivreur=" + nbLivreur
                + ", nbRival=" + nbRival
                + ", nbDepot=" + nbDepot
                + ", tailleCarte=" + tailleCarteX + "x" + tailleCarteY
                + ", modeCombat=" + (modeCombat != null ? modeCombat.getNomCombat() : "null") + "]";
    }
}
