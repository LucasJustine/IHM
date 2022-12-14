package fr.iutfbleau.projetIHM2022FI2.controller.listeners.buttons;

import javax.swing.JList;
import javax.swing.JTabbedPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.iutfbleau.projetIHM2022FI2.API.Etudiant;
import fr.iutfbleau.projetIHM2022FI2.view.admin.MoveStudentPanel;

public class PopUpButtonListener implements ActionListener{
    
    private JTabbedPane tabbedPane;
    private  JList<Etudiant> list;

    public PopUpButtonListener(JTabbedPane pane, JList<Etudiant> list){
        this.tabbedPane = pane;
        this.list = list;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MoveStudentPanel panel = (MoveStudentPanel) tabbedPane.getComponentAt(2);
        panel.setSelectedEtudiant(this.list.getSelectedValue());
        tabbedPane.setSelectedIndex(2);
    }
}
