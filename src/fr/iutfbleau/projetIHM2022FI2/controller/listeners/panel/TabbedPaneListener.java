package fr.iutfbleau.projetIHM2022FI2.controller.listeners.panel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import fr.iutfbleau.projetIHM2022FI2.interfaces.ReloadablePanel;

public class TabbedPaneListener implements ChangeListener {

    public TabbedPaneListener(){
        
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() instanceof JTabbedPane) {
            JTabbedPane pane = (JTabbedPane) e.getSource();
            if(pane.getSelectedComponent() instanceof ReloadablePanel){
                ((ReloadablePanel)pane.getSelectedComponent()).reload();
            }
        }
    }
}
