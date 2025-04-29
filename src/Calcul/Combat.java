package Calcul;

import java.util.concurrent.ThreadLocalRandom;

public class Combat {

    private int idCombat;
    private String nomCombat;
    private Livreur livreur1;
    private Livreur livreur2;
    private String typeCombat;

    private int victoire1;
    private int victoire2;

    public Combat(int idCombat, String nomCombat, Livreur livreur1, Livreur livreur2, String typeCombat) {
        if (livreur1.getMaSociete().getIdSociete() == livreur2.getMaSociete().getIdSociete()) {
            throw new IllegalArgumentException("Les deux livreurs ne peuvent pas appartenir à la même société.");
        }

        this.idCombat = idCombat;
        this.nomCombat = nomCombat;
        this.livreur1 = livreur1;
        this.livreur2 = livreur2;
        this.typeCombat = typeCombat;
        this.victoire1 = 0;
        this.victoire2 = 0;
    }

    public String getNomCombat() {
        return nomCombat;
    }

    public Livreur getLivreur1() {
        return livreur1;
    }

    public Livreur getLivreur2() {
        return livreur2;
    }

    public String demarrerCombat() {
        System.out.println("Début du combat entre " + livreur1.getNomLivreur() + " et " + livreur2.getNomLivreur());

        return switch (typeCombat) {
            case "PierreFeuilleCiseaux" -> pierreFeuilleCiseaux();
            case "PileOuFace" -> pileOuFace();
            case "LanceDeDes" -> lanceDeDes();
            default -> "Type de combat inconnu.";
        };
    }

    private String pierreFeuilleCiseaux() {
        int choix1 = ThreadLocalRandom.current().nextInt(1, 4);
        int choix2 = ThreadLocalRandom.current().nextInt(1, 4);

        while (choix1 == choix2) {
            choix1 = ThreadLocalRandom.current().nextInt(1, 4);
            choix2 = ThreadLocalRandom.current().nextInt(1, 4);
        }

        boolean victoireL1 = (choix1 == 1 && choix2 == 3) || (choix1 == 2 && choix2 == 1) || (choix1 == 3 && choix2 == 2);

        if (victoireL1) {
            victoire1++;
            livreur2.perdreCommande();
            livreur1.prendreCommande("Commande gagnée sur " + traduction(choix1));
            return livreur1.getNomLivreur() + " gagne avec " + traduction(choix1) + " contre " + traduction(choix2);
        } else {
            victoire2++;
            livreur1.perdreCommande();
            livreur2.prendreCommande("Commande gagnée sur " + traduction(choix2));
            return livreur2.getNomLivreur() + " gagne avec " + traduction(choix2) + " contre " + traduction(choix1);
        }
    }

    private String pileOuFace() {
        int result = ThreadLocalRandom.current().nextInt(0, 2);
        if (result == 0) {
            victoire1++;
            livreur2.perdreCommande();
            livreur1.prendreCommande("Pile gagnante");
            return "Pile ! " + livreur1.getNomLivreur() + " gagne.";
        } else {
            victoire2++;
            livreur1.perdreCommande();
            livreur2.prendreCommande("Face gagnante");
            return "Face ! " + livreur2.getNomLivreur() + " gagne.";
        }
    }

    private String lanceDeDes() {
        int des1 = ThreadLocalRandom.current().nextInt(1, 7);
        int des2 = ThreadLocalRandom.current().nextInt(1, 7);

        if (des1 > des2) {
            victoire1++;
            livreur2.perdreCommande();
            livreur1.prendreCommande("De " + des1);
            return livreur1.getNomLivreur() + " gagne avec " + des1 + " contre " + des2;
        } else if (des2 > des1) {
            victoire2++;
            livreur1.perdreCommande();
            livreur2.prendreCommande("De " + des2);
            return livreur2.getNomLivreur() + " gagne avec " + des2 + " contre " + des1;
        } else {
            return "égalite parfaite au lancer de des.";
        }
    }

    private String traduction(int val) {
        return switch (val) {
            case 1 -> "Pierre";
            case 2 -> "Feuille";
            case 3 -> "Ciseaux";
            default -> "?";
        };
    }
}
