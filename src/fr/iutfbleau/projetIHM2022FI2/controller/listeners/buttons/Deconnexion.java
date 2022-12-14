package fr.iutfbleau.projetIHM2022FI2.controller.listeners.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import java.awt.CardLayout;

import fr.iutfbleau.projetIHM2022FI2.Constants;
import fr.iutfbleau.projetIHM2022FI2.Controller;

public class Deconnexion implements ActionListener{
    

    private JFrame fenetre;
    private CardLayout card;
    
    public Deconnexion(Controller c){
        this.fenetre = c.getFrame();
        this.card = (CardLayout) c.getFrame().getContentPane().getLayout();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fenetre.setJMenuBar(null);
        Constants.loggedEtudiant = null;
        card.show(this.fenetre.getContentPane(),Constants.HOME);
    }
}
