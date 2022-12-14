package fr.iutfbleau.projetIHM2022FI2.view.panel;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import java.awt.event.MouseListener;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import fr.iutfbleau.projetIHM2022FI2.API.Etudiant;
import fr.iutfbleau.projetIHM2022FI2.Constants;
import fr.iutfbleau.projetIHM2022FI2.API.AbstractGroupeFactory;
import fr.iutfbleau.projetIHM2022FI2.controller.listeners.jtree.JTreeButtonsListener;
import fr.iutfbleau.projetIHM2022FI2.controller.listeners.panel.AddStudentListener;
import fr.iutfbleau.projetIHM2022FI2.controller.listeners.panel.SwitchAddStudentListener;
import fr.iutfbleau.projetIHM2022FI2.interfaces.ReloadablePanel;
import fr.iutfbleau.projetIHM2022FI2.view.admin.AddStudentPanel;
import fr.iutfbleau.projetIHM2022FI2.view.custom.popupmenu.PopUpMenu;
import fr.iutfbleau.projetIHM2022FI2.view.custom.tree.CustomJTree;



public class VoirGroupes extends JPanel implements ReloadablePanel {
   
    private CardLayout card;
    private CustomJTree tree;
    private PanelGroupe mainPane;

    public VoirGroupes(CustomJTree tree, AbstractGroupeFactory factory,JTabbedPane tabbedPane){
        super();
        this.card = new CardLayout();
        this.tree = tree;
        this.setLayout(card);

        JTreeButtonsListener listenerRoot = new JTreeButtonsListener(tree);
        AddStudentPanel addStudentPane = new AddStudentPanel();
        AddStudentListener listenerAddStudentListener = new AddStudentListener(addStudentPane, factory);
        addStudentPane.setAddStudentListener(listenerAddStudentListener);
        SwitchAddStudentListener listener = new SwitchAddStudentListener(addStudentPane,this,tree);
        addStudentPane.setSwitchListener(listener);
        PopUpMenu pop = new PopUpMenu(listenerRoot);
        this.mainPane = new PanelGroupe(tree,listenerRoot,listener,pop);
        this.add(mainPane,Constants.HOME);
        this.add(addStudentPane,Constants.ELEVE);
    }

    public VoirGroupes(CustomJTree tree){
        super(new BorderLayout());
        this.tree = tree;
        PanelGroupe mainPane = new PanelGroupe(tree);
        this.add(mainPane);
    }

    @Override
    public void reload() {
        this.tree.reload();
    }

    public void switchPanel(String txt){
        this.card.show(this, txt);
    }

    public JList<Etudiant> getList(){
        return this.mainPane.getList();
    }

    public void setListener(MouseListener listener){
        this.mainPane.setListener(listener);
    }
}
