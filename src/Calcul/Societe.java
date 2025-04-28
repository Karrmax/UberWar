package Calcul;

import java.util.ArrayList;
import java.util.List;

public class Societe {

    private String nomSociete;
    private int idSociete;
    private List<Livreur> livreurs;
    private int commandesLivrees;
    private Position depot;

    public Societe(String nomSociete, int idSociete, Position depot) {
        this.nomSociete = nomSociete;
        this.idSociete = idSociete;
        this.livreurs = new ArrayList<>();
        this.commandesLivrees = 0;
        this.depot = depot;
    }

    // === Gestion des livreurs associ�s ===
    public void ajouterLivreur(Livreur l) {
        if (!livreurs.contains(l)) {
            livreurs.add(l);
        }
    }

    public List<Livreur> getLivreurs() {
        return livreurs;
    }

    public void resetLivreurs() {
        livreurs.clear();
    }

    // === Score (commandes livr�es) ===
    public void incrementerLivraisons() {
        commandesLivrees++;
    }

    public int getCommandesLivrees() {
        return commandesLivrees;
    }

    public String getNomSociete() {
        return nomSociete;
    }

    public void setNomSociete(String nomSociete) {
        this.nomSociete = nomSociete;
    }

    public int getIdSociete() {
        return idSociete;
    }

    public void setIdSociete(int idSociete) {
        this.idSociete = idSociete;
    }

    public Position getDepot() {
        return depot;
    }

    @Override
    public String toString() {
        return nomSociete + " (ID: " + idSociete + ") - Livreurs: " + livreurs.size()
                + ", Commandes livrées: " + commandesLivrees;
    }
}
