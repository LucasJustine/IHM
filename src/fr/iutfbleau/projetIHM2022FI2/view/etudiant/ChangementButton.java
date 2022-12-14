package fr.iutfbleau.projetIHM2022FI2.view.etudiant;

import javax.swing.JButton;
import fr.iutfbleau.projetIHM2022FI2.API.Changement;

public class ChangementButton extends JButton{
    private ChangementPanel parent;

    public ChangementButton(String string, ChangementPanel vc) {
        super(string);
        this.parent = vc;
    }

    public Changement getChangement() {
        return this.parent.getChangement();
    }
}
