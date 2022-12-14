package fr.iutfbleau.projetIHM2022FI2.controller.listeners.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import com.formdev.flatlaf.util.SwingUtils;

import fr.iutfbleau.projetIHM2022FI2.Constants;
import fr.iutfbleau.projetIHM2022FI2.API.AbstractGroupeFactory;
import fr.iutfbleau.projetIHM2022FI2.API.Etudiant;
import fr.iutfbleau.projetIHM2022FI2.API.Groupe;
import fr.iutfbleau.projetIHM2022FI2.view.admin.AddStudentPanel;
import fr.iutfbleau.projetIHM2022FI2.view.custom.worker.CustomWorker;
import fr.iutfbleau.projetIHM2022FI2.controller.handlers.MyTransferHandler;
import fr.iutfbleau.projetIHM2022FI2.interfaces.SwingWorkerInterface;

public class AddStudentListener implements ActionListener, SwingWorkerInterface{

    private JList<Etudiant> listParent;
    private JList<Etudiant> list;
    private List<Etudiant> newStudents;
    private List<Etudiant> removeStudents;
    private AddStudentPanel panel;
    private AbstractGroupeFactory factory;
    private Groupe groupe;
    private JProgressBar bar;
    private JDialog dialog;

    public AddStudentListener(AddStudentPanel panel , AbstractGroupeFactory factory){
        this.listParent = panel.getListStudentRoot();
        this.list = panel.getListStudent();
        this.newStudents = panel.getNewStudents();
        this.removeStudents = panel.getRemoveStudents();
        this.panel = panel;
        this.factory = factory;
        this.dialog = new JDialog((JFrame)null," Modifications en cours" ,true);
        this.dialog.setLayout(new BorderLayout());
        this.bar = new JProgressBar(0,100);
        this.dialog.add(new JLabel("Chargement",JLabel.CENTER),BorderLayout.NORTH);
        this.dialog.add(bar,BorderLayout.CENTER);
        this.dialog.pack();
        this.dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
    }

    public void setGroupe(Groupe groupe){
        this.groupe = groupe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        DefaultListModel<Etudiant> model = (DefaultListModel<Etudiant>) list.getModel();
        DefaultListModel<Etudiant> modelParent = (DefaultListModel<Etudiant>) listParent.getModel();
        switch(command){
            case Constants.ADD : {
                List<Etudiant> selected = this.listParent.getSelectedValuesList(); 
                Integer i = null;
                if(e.getSource() instanceof MyTransferHandler ){
                    i = e.getID();
                    int i2 = e.getID();
                    for(Etudiant student : selected){
                        newStudents.add(student);
                        removeStudents.remove(student);
                        model.insertElementAt(student, i);
                        i += 1;
                        modelParent.removeElement(student);                  
                    }
                    //Tres mal fait mais c'était pour voir
                    int[] tab = new int[selected.size()];
                    for(int j = i2 ; j < selected.size() + i2; j++) {
                        tab[(j % selected.size())] = j;
                    }
                    list.setSelectedIndices(tab);
                }  
                else{
                    for(Etudiant student : selected){
                        newStudents.add(student);
                        removeStudents.remove(student);
                        model.addElement(student);
                        modelParent.removeElement(student); 
                    }                 
                    int[] tab = new int[selected.size()];
                    for(int j = model.getSize() - selected.size(); j < model.getSize(); j++) {
                        tab[(j % selected.size())] = j;
                    }
                    list.setSelectedIndices(tab);
                }
            
                break;
            }

            case Constants.REMOVE : {
                List<Etudiant> selected = this.list.getSelectedValuesList(); 
                Integer i = null;
                if(e.getSource() instanceof MyTransferHandler ){
                    i = e.getID();
                    int i2 = e.getID();
                    for(Etudiant student : selected ){
                        newStudents.remove(student);
                        removeStudents.add(student);
                        model.removeElement(student);
                        modelParent.insertElementAt(student, i);
                        i += 1;
                    }
                    //Tres mal fait mais c'était pour voir
                    int[] tab = new int[selected.size()];
                    for(int j = i2 ; j < selected.size() + i2; j++) {
                        tab[(j % selected.size())] = j;
                    }
                    listParent.setSelectedIndices(tab);
                }  
                else{
                    for(Etudiant student : selected ){
                        newStudents.remove(student);
                        removeStudents.add(student);
                        model.removeElement(student);
                        modelParent.addElement(student);
                        listParent.setSelectedValue(student, true);
                    }
                    int[] tab = new int[selected.size()];
                    for(int j = modelParent.getSize() - selected.size(); j < modelParent.getSize(); j++) {
                        tab[(j % selected.size())] = j;
                    }
                    listParent.setSelectedIndices(tab);
                }

                break;
            }
            
            case Constants.CANCEL :
                if(newStudents.isEmpty() && removeStudents.isEmpty())
                    return;
                panel.reload();
                break;
            
            case Constants.CONFIRMED :
                //Taille des listes
                int sizeNew = newStudents.size();
                int sizeRemove = removeStudents.size();
                bar.setMaximum(sizeNew + sizeRemove);
                if(sizeNew == 0 && sizeRemove == 0)
                    return;
                //Positionnement de la fenêtre modale
                this.dialog.setLocationRelativeTo(panel);
                // Création du SwingWorker
                SwingWorker<Void,Void> worker = new CustomWorker(this);
                worker.execute();
                //Affichage de la fenêtre modale
                this.dialog.setVisible(true);
        }
        this.panel.revalidate();
    }

    @Override
    public void whenBackground() {
        for(Etudiant student : newStudents){
            factory.addToGroupe(groupe, student);
            bar.setValue(bar.getValue() + 1);
        }
        for(Etudiant student : removeStudents){
            factory.dropFromGroupe(groupe, student);
            bar.setValue(bar.getValue() + 1);
        }
        removeStudents.clear();
        newStudents.clear();   
    }

    @Override
    public void whenDone() {
        bar.setValue(0);
        dialog.setVisible(false);
    }
}
