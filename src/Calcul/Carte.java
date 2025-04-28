package Calcul;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.awt.Graphics;
public class Carte {

    public enum TypeCase {
        ROUTE('R'),
        HERBE('H'),
        BATIMENT('B'),
        BATIMENT_RECEPTION('L'),
        VIDE('V'),
        DEPOT('D');

        private final char symbole;
        private boolean peutMarcher;
        private String imageName;

        TypeCase(char symbole) {
            this.symbole = symbole;
            if (this.symbole == 'R') {
                peutMarcher = true;
            } else {
                peutMarcher = false;
            }

            switch(symbole) {
                case 'R':
                    this.imageName = "Route";
                    break;
                case 'H':
                    this.imageName = "Herbe";
                    break;
                case 'B':
                    this.imageName = "Batiment";
                    break;
                case'D':
                    this.imageName = "depot";
                    break;
                case 'L':
                    this.imageName = "Batiment";
                    break;
                default:
                    

              }
        }


        // getters 
        public String getImageName() {
            return this.imageName;
        }
        public char getSymbole() {
            return symbole;
        }

        public boolean peutMarcher() {
            return peutMarcher;
        }
    }

    private int lignes;
    private int colonnes;
    private TypeCase[][] grille;
    private loadManager LM;
    int size;


    public Carte(int colonnes, int lignes, loadManager LM, int size) {
        this.LM = LM;
        this.lignes = lignes;
        this.colonnes = colonnes;
        this.grille = new TypeCase[lignes][colonnes];
        this.size = size;
        // loadMap("src\\Resources\\map.txt");
    }

    public void initialiserGrille() {
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                grille[i][j] = TypeCase.ROUTE;
            }
        }
    }

    public void setCase(int x, int y, TypeCase type) {
        if (dansLimites(x, y)) {
            grille[x][y] = type;
        }
    }

    public TypeCase getCase(int x, int y) {
        if (dansLimites(x, y)) {
            return grille[x][y];
        }
        return TypeCase.VIDE;
    }

    public void loadMap(String filePath) {
    try {
        BufferedReader br = new BufferedReader(new FileReader(filePath));

        int row = 0;
        String line;
        while ((line = br.readLine()) != null && row < this.lignes) {
            String[] numbers = line.split(" ");
            for (int col = 0; col < numbers.length; col++) {
                char num = numbers[col].charAt(0);
                System.err.println(num == 'R');
                System.err.println(grille);
                // this.grille[col][row] = TypeCase.ROUTE;
                // System.err.println(this.grille[col][row]);
                switch (num) {
                    case 'R':
                        this.grille[col][row] = TypeCase.ROUTE;
                        break;
                    case 'H':
                        this.grille[col][row] = TypeCase.HERBE;
                        break;
                    case 'B':
                        this.grille[col][row] = TypeCase.BATIMENT;
                        break;
                    case 'D':
                        this.grille[col][row] = TypeCase.DEPOT;
                        break;
                    case 'L':
                        this.grille[col][row] = TypeCase.BATIMENT_RECEPTION;
                        break;
                    default:
                        this.grille[col][row] = TypeCase.VIDE;
                        break;
                }
            }
            row++;
        }

        br.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}



    public void drawMap(Graphics g) {
        afficherCarteConsole();
        // System.out.println("zzzzzzzzzzzzzzzzzzz");
        // System.out.println(LM.images.get("E:\\perso\\PIERRE\\projet java\\Projet JAVA interfaces graphiques aidé par A.Gagneux-20250428T080133Z-001\\Projet JAVA interfaces graphiques aidé par A.Gagneux\\src\\Resources\\mur.png"));
        for (int i = 0; i < this.lignes; i++) {
            for (int j = 0; j < this.colonnes; j++) {
                g.drawImage(LM.images.get(grille[i][j].getImageName()), i*size, j*size, null);
            }
        }
    }
    public void afficherCarteConsole() {
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                System.out.print(grille[i][j].getSymbole() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private boolean dansLimites(int x, int y) {
        return x >= 0 && x < lignes && y >= 0 && y < colonnes;
    }

    public int getLignes() {
        return lignes;
    }

    public int getColonnes() {
        return colonnes;
    }

    public TypeCase[][] getGrille() {
        return grille;
    }
}
