package Ecrans;
import Calcul.LoadManager;
import Calcul.Uberclass;
import java.awt.*;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Fenetre extends JFrame {

	private JPanel contentPane;
	
	private JPanel ecran_debut_de_jeu;
	
	private JPanel ecran_parametres;
	
	private JPanel ecran_jeu;
	
	private JPanel ecran_combat;
	
	private JPanel ecran_fin_de_jeu;
	
	private JPanel gameManager;
	
	private LoadManager LM;

	int size;
	


	/**
	 * Launch the application.
	 */
	
	


	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Fenetre() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(784, 651);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		ecran_debut_de_jeu = new Ecran_debut_de_jeu (this);
		ecran_parametres = new Ecran_parametres (this);
		ecran_jeu = new Ecran_jeu (this);
		ecran_fin_de_jeu = new Ecran_fin_de_jeu (this);
		
		// Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		size = 48;
		LM = new LoadManager(size);
		setContentPane(ecran_debut_de_jeu);
	}
	
	public void showEcran_debut_de_jeu() {
		setContentPane(ecran_debut_de_jeu);
		revalidate();
		repaint();
	}
	
	public void showEcran_parametres() {
		setContentPane(ecran_parametres);
		revalidate();
		repaint();
	}
	
	public void showEcran_jeu() {
        setContentPane(ecran_jeu);
        revalidate();
        repaint();
        Uberclass dep = new Uberclass(((Ecran_jeu) ecran_jeu).getPanelDessin(), this.LM, size);
        ((Ecran_jeu) ecran_jeu).getPanelDessin().setDep(dep);
        dep.start();
    }
	
	public void showEcran_fin_de_jeu() {
		setContentPane(ecran_fin_de_jeu);
		revalidate();
		repaint();
	}
	public void showEcran_combat() {
		setContentPane(ecran_combat);
		revalidate();
		repaint();
	}
}
