package fr.iutfbleau.projetIHM2022FI2.view.panel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseListener;

import fr.iutfbleau.projetIHM2022FI2.Constants;
import fr.iutfbleau.projetIHM2022FI2.API.Etudiant;
import fr.iutfbleau.projetIHM2022FI2.controller.listeners.jtree.GroupeTreeListener;
import fr.iutfbleau.projetIHM2022FI2.controller.listeners.jtree.PopUpMenuListener;
import fr.iutfbleau.projetIHM2022FI2.view.custom.renderer.CustomListRenderer;
import fr.iutfbleau.projetIHM2022FI2.view.custom.tree.CustomJTree;

public class PanelGroupe extends JSplitPane {
    
    private CustomJTree tree;
    private JList<Etudiant> list;

    public PanelGroupe(CustomJTree tree, ActionListener listener, ActionListener listenerCard, JPopupMenu pop){
        super(JSplitPane.HORIZONTAL_SPLIT);
        this.tree = tree;
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());

        JScrollPane treePanel = new JScrollPane(tree);
        
        JPanel panelButton = new JPanel();
        JButton addButton = new JButton("Ajouter Groupe");
        addButton.setActionCommand(Constants.ADD);
        addButton.addActionListener(listener);
        
        JButton removeButton = new JButton("Retirer Groupe");
        removeButton.setActionCommand(Constants.REMOVE);
        removeButton.addActionListener(listener);
        
        JButton renameButton = new JButton("Renommer");
        renameButton.setActionCommand(Constants.RENAME);
        renameButton.addActionListener(listener);

        panelButton.add(addButton);
        panelButton.add(removeButton);
        panelButton.add(renameButton);
        JLabel groupe = new JLabel("Groupes");
        groupe.setHorizontalAlignment(JLabel.CENTER);
        leftPanel.add(groupe,BorderLayout.NORTH);
        leftPanel.add(treePanel,BorderLayout.CENTER);  
        leftPanel.add(panelButton,BorderLayout.SOUTH);

        JPanel rightPanel = new JPanel(new BorderLayout());
        DefaultListModel<Etudiant> listModel = new DefaultListModel<>();
        this.list = new JList<>(listModel);
        list.setCellRenderer(new CustomListRenderer());
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL_WRAP);
        list.setVisibleRowCount(0);

        JPanel panelButtonStudent = new JPanel();
     
        JButton studentButton = new JButton("Ajouter / Retirer Etudiant");
        studentButton.setActionCommand(Constants.ELEVE);
        studentButton.addActionListener(listenerCard);

        panelButtonStudent.add(studentButton);
        JScrollPane scrollPane = new JScrollPane(list);
        JLabel eleve = new JLabel("Élèves");
        eleve.setHorizontalAlignment(JLabel.CENTER);
        rightPanel.add(eleve,BorderLayout.NORTH);
        rightPanel.add(scrollPane,BorderLayout.CENTER);  
        rightPanel.add(panelButtonStudent,BorderLayout.SOUTH);

        this.tree.addTreeSelectionListener(new GroupeTreeListener(listModel));
        this.tree.addMouseListener(new PopUpMenuListener(pop));
        this.setLeftComponent(leftPanel);
        this.setRightComponent(rightPanel);
    }

    public PanelGroupe(CustomJTree tree){
        super(JSplitPane.HORIZONTAL_SPLIT);
        this.tree = tree;
        this.setResizeWeight(0.5);
        JScrollPane treePanel = new JScrollPane();
        treePanel.setViewportView(tree);
        DefaultListModel<Etudiant> listModel = new DefaultListModel<>();
        JList<Etudiant> list = new JList<Etudiant>(listModel);
        list.setCellRenderer(new CustomListRenderer());
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL_WRAP);
        list.setVisibleRowCount(0);

        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        scrollPane.getHorizontalScrollBar().setUnitIncrement(10);

        this.tree.addTreeSelectionListener(new GroupeTreeListener(listModel));
        this.setLeftComponent(treePanel);
        this.setRightComponent(scrollPane);
    }

    public JList<Etudiant> getList(){
        return this.list;
    }

    public void setListener(MouseListener listener){
        this.list.addMouseListener(listener);
    }
}
