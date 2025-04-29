package Calcul;

import Ecrans.PanelDessin;
import java.awt.*;
import java.util.ArrayList;
public class Uberclass extends Thread{
	


	ArrayList<Societe> societes = new ArrayList<>();

	private Carte map;
	private int tailleX;
	private int tailleY;
	PanelDessin dessin;
	
	private LoadManager LM;
	
	
	public Uberclass(PanelDessin dessin, LoadManager LM, int size) {

		this.LM = LM;
		
		tailleX = 50;
		tailleY = 50;

		map = new Carte(12, 16, LM, size);
		map.loadMap("src\\ressources\\maps\\map.txt");

		 // Création des sociétés
        Societe societe1 = new Societe("SpeedExpress", 1,new Position(5,5));
		societes.add(societe1);

        Societe societe2 = new Societe("FastDelivery", 2,new Position(45,45));
		societes.add(societe2);

        // Création des livreurs
        Livreur livreur10 = new Livreur("Alex", 101, societe1, LM);
        societe1.ajouterLivreur(livreur10);
        
        Livreur livreur11 = new Livreur("Laurentin", 102, societe1, LM);
        societe1.ajouterLivreur(livreur11);
        
        Livreur livreur12 = new Livreur("Pierre", 103, societe1, LM);
        societe1.ajouterLivreur(livreur12);

        Livreur livreur20 = new Livreur("Maya", 201, societe2, LM);
        societe2.ajouterLivreur(livreur20);
        
        Livreur livreur21 = new Livreur("Valentin", 202, societe2, LM);
        societe2.ajouterLivreur(livreur21);
        
        Livreur livreur22 = new Livreur("François", 203, societe2, LM);
        societe2.ajouterLivreur(livreur22);
		
        this.dessin = dessin;
	}
	
	public void run( ) {
		while(true) {
			faireetape();
			dessin.repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void drawMap(Graphics g) {
		this.map.drawMap(g);
	}

	private void faireetape() {
		// TODO Auto-generated method stub
		
	}
	public void combattre(Livreur a, Livreur b) {
		
	}

	public ArrayList<Societe> getSociete() {
		return this.societes;
	}

	public int getTailleX() {
		return tailleX;
	}

	public int getTailleY() {
		return tailleY;
	}

}