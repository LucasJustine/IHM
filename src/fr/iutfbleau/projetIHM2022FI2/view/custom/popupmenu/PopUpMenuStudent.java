package fr.iutfbleau.projetIHM2022FI2.view.custom.popupmenu;

import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PopUpMenuStudent extends JPopupMenu {
    
    public PopUpMenuStudent(ActionListener l){
        super();
        JMenuItem move = new JMenuItem( "Déplacer cet étudiant" );
        move.addActionListener(l);
        this.add(move);
    }
}
