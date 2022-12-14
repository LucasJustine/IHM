package fr.iutfbleau.projetIHM2022FI2.controller.listeners.comboBox;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.LinkedHashSet;
import java.util.Set;

import fr.iutfbleau.projetIHM2022FI2.API.AbstractGroupeFactory;
import fr.iutfbleau.projetIHM2022FI2.API.Etudiant;
import fr.iutfbleau.projetIHM2022FI2.API.Groupe;
import fr.iutfbleau.projetIHM2022FI2.API.TypeGroupe;
import fr.iutfbleau.projetIHM2022FI2.interfaces.ComboBoxGroupeInterface;

public class MoveComboBoxListener implements ItemListener {
    
    private ComboBoxGroupeInterface panel;
    private AbstractGroupeFactory groupeFactory;
    private Set<Groupe> studentGroupes;

    public MoveComboBoxListener(ComboBoxGroupeInterface panel, AbstractGroupeFactory factory){
        this.panel = panel;
        this.groupeFactory = factory;
    }
    
    @Override
    public void itemStateChanged(ItemEvent e){
        if(e.getStateChange() == ItemEvent.SELECTED){
            if(e.getItem() instanceof Etudiant){
                Etudiant selectStudent = (Etudiant) e.getItem();
                Set<Groupe> allGroupes = this.groupeFactory.getGroupesOfEtudiant(selectStudent);
                this.studentGroupes = new LinkedHashSet<Groupe>();
                for(Groupe groupe : allGroupes){
                    if(groupe.getPointPoint().getType() == TypeGroupe.PARTITION)
                        this.studentGroupes.add(groupe);
                }
                if (this.studentGroupes.isEmpty())
                    this.panel.setGroupeArrivee(studentGroupes);
                this.panel.setGroupeDepart(studentGroupes);
                
        
            }
            else if(e.getItem() instanceof Groupe){
                Groupe selectGroup= (Groupe) e.getItem();
                Set<Groupe> newGroup = new LinkedHashSet<>();
                for(Groupe groupe : selectGroup.getPointPoint().getSousGroupes()){
                    if(!groupe.equals(selectGroup))
                        newGroup.add(groupe);
                }
                this.panel.setGroupeArrivee(newGroup);
            }
        }
    }
}
