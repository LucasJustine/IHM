package fr.iutfbleau.projetIHM2022FI2.view.custom.dialog;

import fr.iutfbleau.projetIHM2022FI2.API.Etudiant;
import fr.iutfbleau.projetIHM2022FI2.view.custom.renderer.CustomListRenderer;

import java.util.Set;

import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;

@SuppressWarnings("unchecked")
public class ChooseLoggedStudent extends JDialog{

    public ChooseLoggedStudent(JFrame f, String name, String surname, Set<Etudiant> list) {
        super(f, false);
        DefaultComboBoxModel model = new DefaultComboBoxModel<>(list.toArray());
        JComboBox<Etudiant> cb = new JComboBox<Etudiant>(model);
        cb.setRenderer(new CustomListRenderer());
        this.pack();
    }
    
}
