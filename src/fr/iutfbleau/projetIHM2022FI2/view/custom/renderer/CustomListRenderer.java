package fr.iutfbleau.projetIHM2022FI2.view.custom.renderer;

import javax.swing.DefaultListCellRenderer;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;

import fr.iutfbleau.projetIHM2022FI2.Constants;
import fr.iutfbleau.projetIHM2022FI2.API.Etudiant;
import fr.iutfbleau.projetIHM2022FI2.API.Groupe;

import com.formdev.flatlaf.extras.FlatSVGIcon;

public class CustomListRenderer extends DefaultListCellRenderer{

    private static ImageIcon groupes;
    private static ImageIcon eleve;
    private boolean tooltip;

    
    static{
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        eleve = new FlatSVGIcon("res/img/feuille.svg",25,25,loader);
        groupes =  new FlatSVGIcon("res/img/noeud.svg",25,25,loader);
    }

    public CustomListRenderer(boolean tooltip) {
        super();
        this.tooltip = tooltip;
    }

    public CustomListRenderer() {
        this(false);
    }

   
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Etudiant) {
            Etudiant etudiant = (Etudiant)value;
            setIcon(CustomListRenderer.eleve);
            setText(etudiant.getNom().toUpperCase() + " " + etudiant.getPrenom());
            if(tooltip)
                setToolTipText(etudiant.monPrint());
            if(etudiant == Constants.loggedEtudiant && !isSelected)
                setBackground(new Color(42,0,255));
        }
        
        else if (value instanceof Groupe) {
            Groupe groupe = (Groupe)value;
            setIcon(CustomListRenderer.groupes);
            setText(groupe.getName() + " (" + groupe.getSize() + ")");
            setToolTipText(null);
        }
        setBorder(new EmptyBorder(5,5,5,5));
        return this;
    }
    
}
