package Ecrans;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ecran_fin_de_jeu extends JPanel {

    Fenetre fenetre;

    /**
     * Create the panel.
     */
    public Ecran_fin_de_jeu(Fenetre fenetre) {
        JLabel lblNewLabel = new JLabel("ecran 1");
        add(lblNewLabel);

        JButton btnGoEcran2 = new JButton("Suivant");
        btnGoEcran2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                go2();

            }
        });
        add(btnGoEcran2);

    }

    void go2() {

    }

}
