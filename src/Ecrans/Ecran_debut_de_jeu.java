package Ecrans;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ecran_debut_de_jeu extends JPanel {
	private Fenetre fenetre;

	/**
	 * Create the panel.
	 */
	public Ecran_debut_de_jeu(Fenetre fenetre) {
		
		this.fenetre=fenetre;
		
		JLabel lblNewLabel = new JLabel("Ecran_debut_de_jeu");
		add(lblNewLabel);
		
		JButton btnGoEcran_parametres = new JButton("Go 2 Paramètres");
		btnGoEcran_parametres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goEcran_parametres();
				
			}
		});
		add(btnGoEcran_parametres);
		

	}
	private void goEcran_parametres() {
        fenetre.showEcran_parametres();
	}

}
