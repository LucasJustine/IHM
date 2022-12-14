package fr.iutfbleau.projetIHM2022FI2.view.admin;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import fr.iutfbleau.projetIHM2022FI2.Constants;
import fr.iutfbleau.projetIHM2022FI2.API.Etudiant;
import fr.iutfbleau.projetIHM2022FI2.API.Groupe;
import fr.iutfbleau.projetIHM2022FI2.controller.handlers.MyTransferHandler;
import fr.iutfbleau.projetIHM2022FI2.controller.listeners.panel.AddStudentListener;
import fr.iutfbleau.projetIHM2022FI2.view.custom.renderer.CustomListRenderer;

public class AddStudentPanel extends JSplitPane {
    
  
    private JList<Etudiant> listStudentRoot;
    private JList<Etudiant> listStudent;
    private DefaultListModel<Etudiant> listModelRoot;
    private DefaultListModel<Etudiant> listModel;
    private List<Etudiant> newStudents;
    private List<Etudiant> removeStudents;
    private JButton home;
    private Groupe tmpGroupe;
    private Groupe tmpParent;
    private JButton addStudent;
    private JButton remove;
    private JButton confirmed;
    private JButton clear;
    private AddStudentListener listener;

    public AddStudentPanel(){
        super(JSplitPane.HORIZONTAL_SPLIT);
        this.setResizeWeight(0.5);
        JPanel right = new JPanel(new BorderLayout());
    

        this.home = new JButton("Accueil");
        this.home.setActionCommand(Constants.HOME);

        addStudent = new JButton("Ajouter Etudiant");
        addStudent.setActionCommand(Constants.ADD);

        confirmed = new JButton("Confirmer");
        confirmed.setActionCommand(Constants.CONFIRMED);

        remove = new JButton("Retirer Etudiant");
        remove.setActionCommand(Constants.REMOVE);

        clear = new JButton("Annuler");
        clear.setActionCommand(Constants.CANCEL);

        JPanel panelButton = new JPanel(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(5,0,0,0);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        panelButton.add(addStudent,gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        panelButton.add(confirmed,gbc);
      
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        panelButton.add(remove,gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(10,0,10,0);
        panelButton.add(clear,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(0,0,0,0);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;

        panelButton.add(home,gbc);

        CustomListRenderer renderer = new CustomListRenderer();
        this.newStudents = new ArrayList<Etudiant>();
        this.removeStudents = new ArrayList<Etudiant>();

        this.listModel = new DefaultListModel<>();
        this.listModelRoot = new DefaultListModel<>();

        this.listStudent = new JList<>(listModel);
        this.listStudent.putClientProperty("List.isFileList", Boolean.TRUE);

        this.listStudentRoot = new  JList<>(listModelRoot);
        this.listStudentRoot.putClientProperty("List.isFileList", Boolean.TRUE);

        this.listStudent.setLayoutOrientation(JList.VERTICAL_WRAP);
        this.listStudent.setVisibleRowCount(0);

        this.listStudentRoot.setLayoutOrientation(JList.VERTICAL_WRAP);
        this.listStudentRoot.setVisibleRowCount(0);

        this.listStudent.setCellRenderer(renderer);
        this.listStudentRoot.setCellRenderer(renderer);
        
        this.listStudent.setDragEnabled(true);
        this.listStudentRoot.setDragEnabled(true);

        listStudent.setDropMode(DropMode.INSERT);
        listStudentRoot.setDropMode(DropMode.INSERT);

        JScrollPane rightScroll = new JScrollPane(listStudent);
        JScrollPane leftScroll = new JScrollPane(listStudentRoot);

        right.add(rightScroll, BorderLayout.CENTER);
        right.add(panelButton,BorderLayout.SOUTH);
        
        this.setLeftComponent(leftScroll);
        this.setRightComponent(right);
    }


    public List<Etudiant> getNewStudents() {
        return newStudents;
    }

    public List<Etudiant> getRemoveStudents() {
        return removeStudents;
    }

    public JList<Etudiant> getListStudent() {
        return listStudent;
    }

    public JList<Etudiant> getListStudentRoot() {
        return listStudentRoot;
    }

    public void setAddStudentListener(AddStudentListener listener){
        this.listener = listener;
        this.addStudent.addActionListener(listener);
        this.confirmed.addActionListener(listener);
        this.remove.addActionListener(listener);
        this.clear.addActionListener(listener);
        this.listStudent.setTransferHandler(new MyTransferHandler(false, listener));
        this.listStudentRoot.setTransferHandler(new MyTransferHandler(true, listener));
    }

    public void setSwitchListener(ActionListener listener){
        this.home.addActionListener(listener);
    }

    public void setGroupe(Groupe groupe){
        this.listener.setGroupe(groupe);
    }

    public void choice(Groupe parent, Groupe groupe){
        this.tmpParent = parent;
        this.tmpGroupe = groupe;
        this.newStudents.clear();
        this.removeStudents.clear();
        listModel.removeAllElements();
        listModelRoot.removeAllElements();
        Set<Etudiant> parentEtudiant = new LinkedHashSet<Etudiant>(parent.getEtudiants());
        parentEtudiant.removeAll(groupe.getEtudiants());
        for(Etudiant etu : groupe.getEtudiants())
            this.listModel.addElement(etu);
        for(Etudiant etu : parentEtudiant)
            this.listModelRoot.addElement(etu);
        this.revalidate();
    }

    public void reload(){
        choice(this.tmpParent, this.tmpGroupe);
    }
}
