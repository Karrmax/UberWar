package Calcul;

public class Commande {
    public enum EtatCommande {
        EN_ATTENTE, EN_COURS, LIVREE
    }

    private static int compteur = 0;

    private final int id;
    private int xDepot, yDepot;
    private int xClient, yClient;
    private EtatCommande etat;
    private int valeur;

    public Commande(int xDepot, int yDepot, int xClient, int yClient, int valeur) {
        this.id = ++compteur;
        this.xDepot = xDepot;
        this.yDepot = yDepot;
        this.xClient = xClient;
        this.yClient = yClient;
        this.valeur = valeur;
        this.etat = EtatCommande.EN_ATTENTE;
    }

    public int getId() {
        return id;
    }

    public int getXDepot() {
        return xDepot;
    }

    public int getYDepot() {
        return yDepot;
    }

    public int getXClient() {
        return xClient;
    }

    public int getYClient() {
        return yClient;
    }

    public EtatCommande getEtat() {
        return etat;
    }

    public void setEtat(EtatCommande etat) {
        this.etat = etat;
    }

    public int getValeur() {
        return valeur;
    }

    @Override
    public String toString() {
        return "Commande #" + id + " (" + etat + ") de [" +
               xDepot + "," + yDepot + "] vers [" +
               xClient + "," + yClient + "] - Valeur: " + valeur;
    }
}
