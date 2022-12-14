package fr.iutfbleau.projetIHM2022FI2;

import java.awt.CardLayout;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;

import fr.iutfbleau.projetIHM2022FI2.API.AbstractChangementFactory;
import fr.iutfbleau.projetIHM2022FI2.API.AbstractGroupeFactory;
import fr.iutfbleau.projetIHM2022FI2.controller.listeners.buttons.Deconnexion;
import fr.iutfbleau.projetIHM2022FI2.controller.listeners.buttons.MoveStudentListener;
import fr.iutfbleau.projetIHM2022FI2.controller.listeners.buttons.PopUpButtonListener;
import fr.iutfbleau.projetIHM2022FI2.controller.listeners.comboBox.MoveComboBoxListener;
import fr.iutfbleau.projetIHM2022FI2.controller.listeners.jlist.ListMouseListener;
import fr.iutfbleau.projetIHM2022FI2.controller.listeners.jlist.StudentListMouseListener;
import fr.iutfbleau.projetIHM2022FI2.controller.listeners.key.ResearchBarListener;
import fr.iutfbleau.projetIHM2022FI2.controller.listeners.panel.TabbedPaneListener;
import fr.iutfbleau.projetIHM2022FI2.view.admin.MoveStudentPanel;
import fr.iutfbleau.projetIHM2022FI2.view.custom.popupmenu.PopUpMenuStudent;
import fr.iutfbleau.projetIHM2022FI2.view.custom.tree.CustomJTree;
import fr.iutfbleau.projetIHM2022FI2.view.etudiant.VoirChangements;
import fr.iutfbleau.projetIHM2022FI2.view.panel.VoirGroupes;
import fr.iutfbleau.projetIHM2022FI2.view.professeur.ResearchStudents;

public class Init {
    
    private JTabbedPane tabbedPane;


    public Init(String choix , AbstractGroupeFactory agf, AbstractChangementFactory acf, Controller c){
        
        CustomJTree tree = new CustomJTree(agf); 
        VoirGroupes groupePane = null;
        JFrame fenetre = c.getFrame();
        
        this.tabbedPane = new JTabbedPane();
        tabbedPane.addChangeListener(new TabbedPaneListener());
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(Box.createHorizontalGlue());
        JMenu menu = new JMenu();
        menu.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        JMenuItem e1 = new JMenuItem("Déconnexion");
        e1.addActionListener(new Deconnexion(c));
            
        switch (choix) {
            case Constants.ELEVE:{
                groupePane = new VoirGroupes(tree);
                tabbedPane.addTab("Groupes", groupePane);
                VoirChangements changementPane = new VoirChangements(acf, false);
                tabbedPane.addTab("Changement", changementPane); 
                menu.setText(Constants.loggedEtudiant.getNom().toUpperCase() + " " + Constants.loggedEtudiant.getPrenom() );
                break;
            }
                
            case Constants.PROF:{
                groupePane = new VoirGroupes(tree);
                tabbedPane.addTab("Groupes", groupePane);
                ResearchStudents recherche = new ResearchStudents();
                recherche.setResearchBarListener(new ResearchBarListener(recherche.getListModel(), agf));
                ListMouseListener.setFactory(agf);
                recherche.addListMouseListener(ListMouseListener.getInstance());
                tabbedPane.addTab("Rechercher un élève", recherche);
                menu.setText("Prof");
                break;
            }

            case Constants.ADMIN:{
                groupePane = new VoirGroupes(tree, agf,tabbedPane);
                ActionListener listenerButton = new PopUpButtonListener(tabbedPane, groupePane.getList());
                JPopupMenu pop = new PopUpMenuStudent(listenerButton);
                MouseListener listener = new StudentListMouseListener(pop);
                groupePane.setListener(listener);
                tabbedPane.addTab("Groupes", groupePane);
                VoirChangements changementPane = new VoirChangements(acf, true);
                tabbedPane.addTab("Changement", changementPane);  
                MoveStudentPanel moveStudentPanel = new MoveStudentPanel();
                MoveComboBoxListener listenerComboMove = new MoveComboBoxListener(moveStudentPanel, agf);
                moveStudentPanel.setComboBoxListener(listenerComboMove);
                MoveStudentListener listenerButtonMove = new MoveStudentListener(moveStudentPanel, agf);
                moveStudentPanel.setMoveStudentListener(listenerButtonMove);
                moveStudentPanel.setEtudiant(agf.getPromotion().getEtudiants());
                tabbedPane.addTab("Déplacer Etudiant", moveStudentPanel);  
                menu.setText("Admin");
                break;
            }
        }
        menu.add(e1);
        menuBar.add(menu);
        fenetre.setJMenuBar(menuBar);
    }

    public JTabbedPane getTabbedPane(){
        return this.tabbedPane;
    }
}
