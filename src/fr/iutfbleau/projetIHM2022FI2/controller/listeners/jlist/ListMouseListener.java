package fr.iutfbleau.projetIHM2022FI2.controller.listeners.jlist;

import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JList;
import javax.swing.SwingUtilities;

import fr.iutfbleau.projetIHM2022FI2.API.AbstractGroupeFactory;
import fr.iutfbleau.projetIHM2022FI2.API.Etudiant;
import fr.iutfbleau.projetIHM2022FI2.view.custom.dialog.CustomDialogEtudiant;

@SuppressWarnings("unchecked")
public class ListMouseListener implements MouseListener {

    private static ListMouseListener instance = null;
    private static AbstractGroupeFactory agf = null;

    private ListMouseListener() {

    }

    public static void setFactory(AbstractGroupeFactory agf) {
        if(ListMouseListener.agf == null) {
            ListMouseListener.agf = agf;
        }
    }

    public static ListMouseListener getInstance() throws IllegalStateException{
        if(ListMouseListener.agf == null)
            throw new IllegalStateException("Pas de Factory");
        if(ListMouseListener.instance == null) {
            ListMouseListener.instance = new ListMouseListener();
        }
        return ListMouseListener.instance;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount() == 2) {
            if(!(e.getSource() instanceof JList))
                return;
            JList<Etudiant> list = (JList<Etudiant>) e.getSource();
            if(list.getSelectedValuesList().size() == 1) {
                //(Tester si c'est l'objet est un élève)
                Etudiant etu = (Etudiant) list.getSelectedValue();
                CustomDialogEtudiant d = new CustomDialogEtudiant((Frame)SwingUtilities.getRoot(list), etu.getNom(), etu.getPrenom(), agf.getGroupesOfEtudiant(etu));
                d.setLocation(e.getXOnScreen() - d.getWidth() / 2, e.getYOnScreen());
                d.setVisible(true);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
