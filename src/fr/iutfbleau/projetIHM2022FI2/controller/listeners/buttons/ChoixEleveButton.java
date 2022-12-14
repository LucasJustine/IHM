package fr.iutfbleau.projetIHM2022FI2.controller.listeners.buttons;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JList;

import fr.iutfbleau.projetIHM2022FI2.Constants;
import fr.iutfbleau.projetIHM2022FI2.Controller;
import fr.iutfbleau.projetIHM2022FI2.Init;
import fr.iutfbleau.projetIHM2022FI2.API.AbstractChangementFactory;
import fr.iutfbleau.projetIHM2022FI2.API.AbstractGroupeFactory;
import fr.iutfbleau.projetIHM2022FI2.API.Etudiant;

public class ChoixEleveButton implements ActionListener {

    private Controller controller;
    private CardLayout card;
    private AbstractChangementFactory acf;
    private AbstractGroupeFactory agf;
    private JList<Etudiant> list;

    public ChoixEleveButton(Controller controller, AbstractGroupeFactory agf, AbstractChangementFactory acf, JList<Etudiant> list) {
        this.controller = controller;
        this.card = (CardLayout) controller.getFrame().getContentPane().getLayout();
        this.agf = agf;
        this.acf = acf;
        this.list = list;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(list.getSelectedValue() != null) {
            Constants.loggedEtudiant = list.getSelectedValue();
            Init choix = new Init(Constants.ELEVE, agf, acf,controller);
            controller.change(choix.getTabbedPane());
            card.show(controller.getFrame().getContentPane(),Constants.PANEL);
        }
    }
}
