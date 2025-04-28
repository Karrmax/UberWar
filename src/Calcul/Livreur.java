package Calcul;

import java.awt.*;

public class Livreur {

    private String nomLivreur;
    private int idLivreur;
    private Societe maSociete;
    private String commande; // Texte repr�sentant la commande actuelle
    private Position position;
    private char symbole; // Pour affichage si besoin (ex: 'A', 'M', etc.)
    private Position cible;
    private loadManager LM;

    public Livreur(String nomLivreur, int idLivreur, Societe maSociete, loadManager LM) {
        this.LM = LM;
        this.nomLivreur = nomLivreur;
        this.idLivreur = idLivreur;
        this.maSociete = maSociete;
        this.commande = null;
        this.symbole = nomLivreur.charAt(0); // Prend la 1ère lettre du nom
        this.position = new Position(maSociete.getDepot().getX(), maSociete.getDepot().getY()); // Position par défaut
        this.cible = new Position(25, 25); // Position par défaut

    }

    // === Getrs et setters ===
    public String getNomLivreur() {
        return nomLivreur;
    }

    public void setNomLivreur(String nomLivreur) {
        this.nomLivreur = nomLivreur;
    }

    public int getIdLivreur() {
        return idLivreur;
    }

    public void setIdLivreur(int idLivreur) {
        this.idLivreur = idLivreur;
    }

    public Societe getMaSociete() {
        return maSociete;
    }

    public void setMaSociete(Societe maSociete) {
        this.maSociete = maSociete;
    }

    public String getCommande() {
        return commande;
    }

    public void setCommande(String commande) {
        this.commande = commande;
    }

    public boolean transporteCommande() {
        return commande != null;
    }

    public void perdreCommande() {
        System.out.println(nomLivreur + " perd sa commande et retourne � son d�p�t !");
        this.commande = null;
    }

    public void prendreCommande(String commande) {
        this.commande = commande;
        System.out.println(nomLivreur + " prend la commande et continue son trajet !");
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public char getSymbole() {
        return symbole;
    }

    public void setSymbole(char symbole) {
        this.symbole = symbole;
    }

    public void draw(Graphics g) {
        g.drawImage(LM.images.get("livreur"), LM.size, LM.size, null);
    }

    @Override
    public String toString() {
        return nomLivreur + " [ID: " + idLivreur + ", Societe: " + maSociete.getNomSociete()
                + ", Pos: " + position + ", Cmd: " + (commande != null ? commande : "aucune") + "]";
    }
    // === Déplacement intelligent (si utile plus tard) ===

    public void deplacerVers() {
        if (position.getX() < cible.getX()) {
            position.setX(position.getX() + 1);
        };
        /*  else if (x > cibleX) x--;
        if (y < cibleY) y++;
        else if (y > cibleY) y--;*/
    }

}
