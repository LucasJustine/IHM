package fr.iutfbleau.projetIHM2022FI2.view.custom.dialog;

import java.awt.Insets;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import fr.iutfbleau.projetIHM2022FI2.API.Groupe;
import fr.iutfbleau.projetIHM2022FI2.view.custom.renderer.CustomListRenderer;

public class CustomDialogEtudiant extends JDialog {

    public CustomDialogEtudiant(Frame f, String name, String surname, Set<Groupe> groupes) {
        super(f, false);
        this.setLayout(new GridBagLayout());
        this.setTitle("Informations sur l'élève");
        DefaultListModel<Groupe> listModel = new DefaultListModel<Groupe>();
        for(Groupe groupe : groupes)
            listModel.addElement(groupe);
        JList<Groupe> list = new JList<Groupe>(listModel); 
        list.setCellRenderer(new CustomListRenderer());
        list.putClientProperty("List.isFileList", Boolean.TRUE);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(list);

        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel label = new JLabel("Etudiant : ");
        label.setHorizontalAlignment(JLabel.CENTER);
        this.add(label, gbc);

        gbc.gridy = 1;
        this.add(new JLabel( name + " " + surname), gbc);

        JLabel groupe = new JLabel("Groupes auxquels il appartient : ");
        groupe.setHorizontalAlignment(JLabel.CENTER);
        gbc.gridy = 2;
        this.add(groupe, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        this.add(scrollPane, gbc);
        this.pack();
        this.setResizable(false);
    }
    
}
