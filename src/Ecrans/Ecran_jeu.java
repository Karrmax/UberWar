package Ecrans;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Ecran_jeu extends JPanel {

    Fenetre fenetre;

    PanelDessin GameManager;

    /**
     * Create the panel.
     */
    public Ecran_jeu(Fenetre fenetre) {
        setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        add(panel, BorderLayout.NORTH);

        JButton btnNewButton = new JButton("Home");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fenetre.showEcran_debut_de_jeu();
            }
        });
        panel.add(btnNewButton);

        JButton Combat = new JButton("Combat");
        Combat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fenetre.showEcran_combat();
            }
        });
        panel.add(Combat);

        GameManager = new PanelDessin();
        add(GameManager, BorderLayout.CENTER);

    }

    public PanelDessin getPanelDessin() {
        return GameManager;
    }

}
