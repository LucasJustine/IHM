package fr.iutfbleau.projetIHM2022FI2.controller.listeners.jtree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.iutfbleau.projetIHM2022FI2.Constants;
import fr.iutfbleau.projetIHM2022FI2.view.custom.tree.CustomJTree;

public class JTreeButtonsListener implements ActionListener{

    private CustomJTree tree ; 
    
    public JTreeButtonsListener(CustomJTree tree){
        this.tree = tree;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
            
        if (Constants.ADD.equals(command))
            tree.question();
        else if(Constants.REMOVE.equals(command))
            tree.removeNode();
        else if(Constants.RENAME.equals(command))
            tree.rename();
    }
}
