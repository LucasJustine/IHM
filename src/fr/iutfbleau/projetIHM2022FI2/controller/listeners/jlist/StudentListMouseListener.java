package fr.iutfbleau.projetIHM2022FI2.controller.listeners.jlist;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;
import javax.swing.JPopupMenu;

public class StudentListMouseListener extends MouseAdapter {

    JPopupMenu pop;

    public StudentListMouseListener(JPopupMenu pop){
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
            JList list = (JList) e.getSource();
            int x = list.locationToIndex(e.getPoint());
            list.setSelectedIndex(x);
            list.ensureIndexIsVisible(x);
            if(list.getSelectedValue() != null)
                pop.show(e.getComponent(),e.getX(), e.getY());
        }
    }
    
}
