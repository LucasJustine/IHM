package fr.iutfbleau.projetIHM2022FI2.view.custom.popupmenu;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.event.ActionListener;
import fr.iutfbleau.projetIHM2022FI2.Constants;

public class PopUpMenu extends JPopupMenu{
    
    public PopUpMenu(ActionListener l){
        super();
        JMenuItem groupe = new JMenuItem( "Ajouter groupe" );
        groupe.setActionCommand(Constants.ADD);
        groupe.addActionListener(l);
        this.add(groupe);

        JMenuItem delete = new JMenuItem( "Supprimer un groupe" );
        delete.setActionCommand(Constants.REMOVE);
        delete.addActionListener(l);
        this.add(delete);

        JMenuItem rename = new JMenuItem( "Renommer un groupe" );
        rename.setActionCommand(Constants.RENAME);
        rename.addActionListener(l);
        this.add(rename);
    }
}
