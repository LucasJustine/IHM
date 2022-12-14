package fr.iutfbleau.projetIHM2022FI2.view.etudiant;

import fr.iutfbleau.projetIHM2022FI2.Constants;
import fr.iutfbleau.projetIHM2022FI2.API.*;
import fr.iutfbleau.projetIHM2022FI2.controller.listeners.buttons.ChangementButtonListener;
import fr.iutfbleau.projetIHM2022FI2.interfaces.ReloadablePanel;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.JPanel;
import javax.swing.Scrollable;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;

public class ShowChangementPanels extends JPanel implements ReloadablePanel, Scrollable{
    private ChangementButtonListener cl;
    private boolean isAdmin;

    public ShowChangementPanels(boolean isAdmin) {
        super();
        this.isAdmin = isAdmin;
        this.setLayout(new GridBagLayout());
    }

    public void setListener(ChangementButtonListener cl) {
        this.cl = cl;
        this.reload();
    }

    public void reload() {
        GridBagConstraints gbc = new GridBagConstraints();
        int x = 0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;

        this.removeAll();
        for(Changement c : this.cl.getChangement()) {
            ChangementPanel vc = new ChangementPanel(c,this.isAdmin);
            gbc.gridy = x;
            if(this.isAdmin)
                vc.addButtonsListener(this.cl);  
            else {
                if(c.getA().getSize() < c.getB().getSize() && Constants.loggedEtudiant != c.getEtu())
                    continue;
            }
            this.add(vc,gbc);
            x++;
        }
        this.revalidate();
        this.repaint();
    }

    @Override
    public Dimension getPreferredScrollableViewportSize() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
        // TODO Auto-generated method stub
        return 10;
    }

    @Override
    public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
        // TODO Auto-generated method stub
        return 10;
    }

    @Override
    public boolean getScrollableTracksViewportWidth() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean getScrollableTracksViewportHeight() {
        // TODO Auto-generated method stub
        return false;
    }

}
