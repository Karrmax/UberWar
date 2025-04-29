package Ecrans;

import Calcul.Livreur;
import Calcul.Societe;
import Calcul.Uberclass;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class PanelDessin extends JPanel  {

	private Uberclass dep;

    public PanelDessin() {
     
    }

    
    
   public void setDep(Uberclass dep) {
		this.dep = dep;
	}



	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);

		// System.out.println("test");
        if (dep!=null) {
			dep.drawMap(g);
        	g.setColor(Color.GREEN);
			
			ArrayList<Societe> societe = dep.getSociete();

			System.out.println(societe);



			for (int index = 0; index < societe.size(); index++) {
				Societe s = societe.get(index);
				List<Livreur> livreurs = s.getLivreurs();
				 
				// int size=10;  //taille de tableau ratio taille de l'écran
				for(int i=0;i<livreurs.size();i++) {
					livreurs.get(i).draw(g);
					// g.fillRect((int)livreurs.get(i).getPosition().getX(),(int)livreurs.get(i).getPosition().getY(), size, size);
				}
				// System.out.println("he");
			}

        }
       
    }
	

    
}
