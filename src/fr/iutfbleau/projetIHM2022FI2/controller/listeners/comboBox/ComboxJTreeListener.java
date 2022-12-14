package fr.iutfbleau.projetIHM2022FI2.controller.listeners.comboBox;


import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.LinkedList;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import fr.iutfbleau.projetIHM2022FI2.API.Groupe;

public class ComboxJTreeListener implements ItemListener {
    
    private DefaultTreeModel model;
    private JTree tree;

    public ComboxJTreeListener(JTree tree){
        this.model = (DefaultTreeModel) tree.getModel();
        this.tree = tree;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED){
            Groupe groupe = (Groupe) e.getItem();
            LinkedList<Groupe> list = new LinkedList<>();
            list.offerFirst(groupe);
            do{
                groupe = groupe.getPointPoint();
                list.offerFirst(groupe);
            } while(!groupe.getPointPoint().equals(groupe));
            DefaultMutableTreeNode node;
            DefaultMutableTreeNode root = new DefaultMutableTreeNode(list.poll().getName());
            this.model.setRoot(root);
            while(!list.isEmpty()){
                node = new DefaultMutableTreeNode(list.poll().getName());
                root.add(node);
                root = node;
            }
            model.reload();
            expandAllNodes();
        }
        else {
            model.setRoot(null);
            model.reload();
        }
    }
    
    private void expandAllNodes() {
        int j = tree.getRowCount();
        int i = 0;
        while(i < j) {
            tree.expandRow(i);
            i += 1;
            j = tree.getRowCount();
        }
    }
}