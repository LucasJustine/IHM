package fr.iutfbleau.projetIHM2022FI2.view.etudiant;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Set;

import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import fr.iutfbleau.projetIHM2022FI2.API.Groupe;
import fr.iutfbleau.projetIHM2022FI2.controller.listeners.comboBox.ComboxJTreeListener;
import fr.iutfbleau.projetIHM2022FI2.interfaces.ComboBoxGroupeInterface;
import fr.iutfbleau.projetIHM2022FI2.view.custom.renderer.CustomListRenderer;

public class CreateChangementPanel extends JPanel implements ComboBoxGroupeInterface{
    
    private JComboBox<Groupe> groupeDepart;
    private JComboBox<Groupe> groupeArrivee;
    private JTextArea explications;
    private JButton button;

    public CreateChangementPanel() {
        super();
        JLabel titre = new JLabel("Demander un changement");
        titre.setHorizontalAlignment(JLabel.CENTER);
        this.groupeDepart = new JComboBox<Groupe>();
        this.groupeArrivee = new JComboBox<Groupe>();
        this.groupeDepart.setRenderer(new CustomListRenderer());
        this.groupeArrivee.setRenderer(new CustomListRenderer());
        this.button = new JButton("Envoyer la demande");
        this.explications = new JTextArea(5,5);
        this.explications.setLineWrap(true);

        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.NONE;
        this.add(titre, gbc);


        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.NONE;
        this.add(groupeDepart, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.NONE;
        this.add(groupeArrivee, gbc);

        DefaultTreeModel model = new DefaultTreeModel(new DefaultMutableTreeNode(""));
        JTree tree = new JTree(model);
        tree.setEnabled(false);

        DefaultTreeModel model2 = new DefaultTreeModel(new DefaultMutableTreeNode(""));
        JTree tree2 = new JTree(model2);
        tree2.setEnabled(false);

        this.groupeDepart.addItemListener(new ComboxJTreeListener(tree));
        this.groupeArrivee.addItemListener(new ComboxJTreeListener(tree2));

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.NONE;
        this.add(tree,gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.NONE;
        this.add(tree2,gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        JScrollPane scrollPane = new JScrollPane(this.explications);
        this.add(scrollPane, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.NONE;
        this.add(this.button, gbc);

    }

    public void setGroupeDepart(Set<Groupe> groupes) {
        this.groupeDepart.removeAllItems();
        for(Groupe g : groupes)
            this.groupeDepart.addItem(g);
        if(!groupes.isEmpty())
            this.groupeDepart.setSelectedIndex(0);
    }

    public void setGroupeArrivee(Set<Groupe> groupes) {
        this.groupeArrivee.removeAllItems();
        for(Groupe g : groupes)
            this.groupeArrivee.addItem(g);
        if(!groupes.isEmpty())
            this.groupeArrivee.setSelectedIndex(0);
    }

    public void setButtonListener(ActionListener l) {
        this.button.addActionListener(l);
    }

    public void setComboBoxListener(ItemListener l) {
        this.groupeDepart.addItemListener(l);
    }

    public Groupe getSelectedGroupeDepart() {
        return (Groupe) this.groupeDepart.getSelectedItem();
    }

    public Groupe getSelectedGroupeArrivee() {
        return (Groupe) this.groupeArrivee.getSelectedItem();
    }

    public String getExplications() {
        return this.explications.getText();
    }
    
    public void reset() {
        this.explications.setText("");
    }

}
