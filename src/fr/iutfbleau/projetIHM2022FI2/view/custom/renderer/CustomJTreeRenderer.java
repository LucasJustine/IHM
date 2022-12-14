package fr.iutfbleau.projetIHM2022FI2.view.custom.renderer;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import fr.iutfbleau.projetIHM2022FI2.API.Groupe;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

import com.formdev.flatlaf.extras.FlatSVGIcon;

public class CustomJTreeRenderer extends DefaultTreeCellRenderer {

    private static FlatSVGIcon closeIcon;
    private static FlatSVGIcon leafIcon;
    private static FlatSVGIcon openIcon;
    
    static{
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        closeIcon = new FlatSVGIcon("res/img/noeud.svg",25,25,loader);
        leafIcon =  new FlatSVGIcon("res/img/feuille.svg",25,25,loader);
        openIcon =  new FlatSVGIcon("res/img/ouvert.svg",25,25,loader);
    }

    public CustomJTreeRenderer(){
        super();
        setClosedIcon(closeIcon);
        setLeafIcon(leafIcon);
        setOpenIcon(openIcon);
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded,
                                                  boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row,hasFocus);
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
        if (node.getUserObject()  instanceof Groupe) {
            Groupe groupe = (Groupe) node.getUserObject() ;
            this.setText(groupe.getName());
            this.setToolTipText("Nombre d'élèves : " + groupe.getSize());
        }
        return this;
    }
}
