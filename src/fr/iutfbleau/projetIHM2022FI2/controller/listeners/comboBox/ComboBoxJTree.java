package fr.iutfbleau.projetIHM2022FI2.controller.listeners.comboBox;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.LinkedList;

import javax.swing.JComboBox;

import fr.iutfbleau.projetIHM2022FI2.API.Groupe;

public class ComboBoxJTree implements ItemListener {

    public ComboBoxJTree(){
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Groupe groupe = (Groupe) e.getItem();
        if(groupe != null){
            Groupe depart = groupe;
            LinkedList<Groupe> list = new LinkedList<>();
            list.offerFirst(depart);
            do{
                depart = depart.getPointPoint();
                list.offerFirst(depart);
            } while(!depart.getPointPoint().equals(depart));
            System.out.println("test");
        } 
    }
}
