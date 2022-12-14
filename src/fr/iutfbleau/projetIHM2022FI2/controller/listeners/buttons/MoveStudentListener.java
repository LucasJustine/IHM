package fr.iutfbleau.projetIHM2022FI2.controller.listeners.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import fr.iutfbleau.projetIHM2022FI2.API.AbstractGroupeFactory;
import fr.iutfbleau.projetIHM2022FI2.view.admin.MoveStudentPanel;


public class MoveStudentListener implements ActionListener {

    private MoveStudentPanel panel;
    private AbstractGroupeFactory groupeFactory;

    // Je prend le panel et pas les comboBox car je fais reload du panel
    public MoveStudentListener(MoveStudentPanel panel, AbstractGroupeFactory factory){
        this.panel = panel;
        this.groupeFactory = factory;
    }


    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            groupeFactory.addToGroupe(panel.getGroupeArrivee(), panel.getEtudiant());
            groupeFactory.dropFromGroupe(panel.getGroupeDepart(), panel.getEtudiant());
            JOptionPane.showMessageDialog(panel,"L'étudiant " + panel.getEtudiant().getPrenom() + " a été déplacé du groupe " + panel.getGroupeDepart().getName()
                                            + " au groupe " + panel.getGroupeArrivee().getName(), "Déplacement", JOptionPane.INFORMATION_MESSAGE);
            panel.reload();
        } catch (Exception exception) {
           JOptionPane.showMessageDialog(panel, exception.getMessage(), null, 0);
        }
    }
}
