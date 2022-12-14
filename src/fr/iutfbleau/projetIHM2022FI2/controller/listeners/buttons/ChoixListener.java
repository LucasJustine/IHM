package fr.iutfbleau.projetIHM2022FI2.controller.listeners.buttons;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import fr.iutfbleau.projetIHM2022FI2.Constants;
import fr.iutfbleau.projetIHM2022FI2.Controller;
import fr.iutfbleau.projetIHM2022FI2.Init;
import fr.iutfbleau.projetIHM2022FI2.API.AbstractChangementFactory;
import fr.iutfbleau.projetIHM2022FI2.API.AbstractGroupeFactory;
import fr.iutfbleau.projetIHM2022FI2.API.Etudiant;

public class ChoixListener implements ActionListener {

    private Controller controller;
    private CardLayout card;
    private AbstractChangementFactory acf;
    private AbstractGroupeFactory agf;

    public ChoixListener(Controller controller, AbstractGroupeFactory agf, AbstractChangementFactory acf){
        this.controller = controller;
        this.card = (CardLayout) controller.getFrame().getContentPane().getLayout();
        this.agf = agf;
        this.acf = acf;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Init choix = null;
        switch (e.getActionCommand()) {
            case Constants.ELEVE:
                card.show(controller.getFrame().getContentPane(), Constants.ELEVE);
                return;
        
            case Constants.PROF:
                choix = new Init(Constants.PROF, agf, acf,controller);
                break;

            case Constants.ADMIN:
                choix = new Init(Constants.ADMIN, agf, acf,controller);
                break;
        }
        controller.change(choix.getTabbedPane());
        card.show(controller.getFrame().getContentPane(),Constants.PANEL);
    } 
}
