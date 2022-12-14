package fr.iutfbleau.projetIHM2022FI2.controller.listeners.jtree;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPopupMenu;
import javax.swing.JTree;

public class PopUpMenuListener extends MouseAdapter {

    JPopupMenu pop;

    public PopUpMenuListener(JPopupMenu pop){
        this.pop = pop;
    }

    public void mousePressed(MouseEvent e) {
        maybeShowPopup(e);
    }

    public void mouseReleased(MouseEvent e) {
        maybeShowPopup(e);
    }

    private void maybeShowPopup(MouseEvent e) {
        if(e.isPopupTrigger()) {
            JTree tree = (JTree) e.getSource();
            tree.setSelectionPath(tree.getClosestPathForLocation(e.getX(), e.getY()));
            pop.show(e.getComponent(), e.getX(), e.getY());
        }
    }
}
