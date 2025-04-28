package Ecrans;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ecran_parametres extends JPanel {
	Fenetre fenetre;

	/**
	 * Create the panel.
	 */
	public Ecran_parametres(Fenetre fenetre) {
		JLabel lblNewLabel = new JLabel("Écran Paramètres");
		add(lblNewLabel);
		
		JButton btnGoHome = new JButton("Home");
		btnGoHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fenetre.showEcran_debut_de_jeu();
				
			}
		});
		JButton btnGoEcran_jeu = new JButton("Jouons");
		btnGoEcran_jeu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fenetre.showEcran_jeu();
				
			}
		});
		add(btnGoHome);
		add(btnGoEcran_jeu);
		

	}


}
