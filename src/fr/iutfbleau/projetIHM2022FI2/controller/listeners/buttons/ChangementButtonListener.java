package fr.iutfbleau.projetIHM2022FI2.controller.listeners.buttons;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Set;

import javax.swing.JOptionPane;
import fr.iutfbleau.projetIHM2022FI2.API.AbstractChangementFactory;
import fr.iutfbleau.projetIHM2022FI2.API.Changement;
import fr.iutfbleau.projetIHM2022FI2.view.etudiant.ChangementButton;
import fr.iutfbleau.projetIHM2022FI2.view.etudiant.ChangementPanel;
import fr.iutfbleau.projetIHM2022FI2.view.etudiant.ShowChangementPanels;

public class ChangementButtonListener implements ActionListener {

    private ShowChangementPanels panneau;
    private AbstractChangementFactory acf;

    public ChangementButtonListener(ShowChangementPanels panneau, AbstractChangementFactory acf) {
        this.panneau = panneau;
        this.acf = acf;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ChangementButton bouton = (ChangementButton) e.getSource();
        if(e.getActionCommand() == ChangementPanel.ACCEPT) { 
            try {
                this.acf.applyChangement(bouton.getChangement());
            } catch (IllegalStateException e1) {
                JOptionPane.showMessageDialog(panneau, "Changement incohérent, veuillez le refuser", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        } 
        else if (e.getActionCommand() == ChangementPanel.DENY) {
            try {
                this.acf.deleteChangement(bouton.getChangement());
            } catch (IllegalStateException e1) {
                JOptionPane.showMessageDialog(panneau, "Changement incohérent, veuillez le refuser", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
        this.panneau.reload();
    }

    public Set<Changement> getChangement() {
        return this.acf.getAllChangements();
    }

}
