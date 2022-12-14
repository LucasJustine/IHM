package fr.iutfbleau.projetIHM2022FI2.view.admin;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import fr.iutfbleau.projetIHM2022FI2.Constants;
import fr.iutfbleau.projetIHM2022FI2.API.Etudiant;
import fr.iutfbleau.projetIHM2022FI2.API.Groupe;
import fr.iutfbleau.projetIHM2022FI2.controller.listeners.comboBox.ComboxJTreeListener;
import fr.iutfbleau.projetIHM2022FI2.controller.listeners.comboBox.MoveComboBoxListener;
import fr.iutfbleau.projetIHM2022FI2.interfaces.ComboBoxGroupeInterface;
import fr.iutfbleau.projetIHM2022FI2.interfaces.ReloadablePanel;
import fr.iutfbleau.projetIHM2022FI2.controller.listeners.buttons.MoveStudentListener;
import fr.iutfbleau.projetIHM2022FI2.view.custom.renderer.CustomListRenderer;

import com.formdev.flatlaf.extras.FlatSVGIcon;

public class MoveStudentPanel extends JPanel implements ComboBoxGroupeInterface, ReloadablePanel{
    
    private JComboBox<Groupe> groupeDepart;
    private JComboBox<Groupe> groupeArrivee;
    private JComboBox<Etudiant> studentlist;
    private JButton accueilButton;
    private JButton confirm;

    public MoveStudentPanel(){
        super();
        this.setLayout(new GridBagLayout());
        this.groupeArrivee = new JComboBox<>();
        this.groupeDepart = new JComboBox<>();
        this.studentlist = new JComboBox<>();
        this.accueilButton = new JButton("Accueil");
        this.accueilButton.setActionCommand(Constants.HOME);

        this.groupeArrivee.setRenderer(new CustomListRenderer());
        this.groupeDepart.setRenderer(new CustomListRenderer());
        this.studentlist.setRenderer(new CustomListRenderer());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        
        this.add(studentlist,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;

        this.add(groupeDepart,gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        
        this.add(groupeArrivee,gbc);

        this.confirm = new JButton("Confirmer le déplacement");

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;

        this.add(this.confirm,gbc);


        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        FlatSVGIcon fleche =  new FlatSVGIcon("res/img/fleche.svg",80,56,loader);
        JLabel changementPanel = new JLabel(fleche,JLabel.CENTER);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(changementPanel,gbc);



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
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(tree,gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(tree2,gbc);

    
    }

    public void setComboBoxListener(MoveComboBoxListener listener){
        this.studentlist.addItemListener(listener);
        this.groupeDepart.addItemListener(listener);
    }

    public void setGroupeDepart(Set<Groupe> groupe){
        this.groupeDepart.removeAllItems();
        for(Groupe g : groupe){
            this.groupeDepart.addItem(g);
        }
    }

    public void setGroupeArrivee(Set<Groupe> groupe){
        this.groupeArrivee.removeAllItems();
        for(Groupe g : groupe){
            this.groupeArrivee.addItem(g);
        }
    }

    public void setEtudiant(Set<Etudiant> etudiants){
        this.studentlist.removeAllItems();
        for(Etudiant s : etudiants){
            this.studentlist.addItem(s);
        }
        if(!etudiants.isEmpty())
            this.studentlist.setSelectedIndex(0);
    }

    public void setSelectedEtudiant(Etudiant etu){
        this.studentlist.setSelectedItem(etu);
    }

    public void setMoveStudentListener(MoveStudentListener listener){
        this.confirm.addActionListener(listener);
    }

    public Etudiant getEtudiant(){
        return (Etudiant) this.studentlist.getSelectedItem();
    }

    public Groupe getGroupeDepart(){
        return (Groupe) this.groupeDepart.getSelectedItem();
    }

    public Groupe getGroupeArrivee(){
        return (Groupe) this.groupeArrivee.getSelectedItem();
    }

    public void reload(){
        Etudiant etudiant = (Etudiant) this.studentlist.getSelectedItem();
        this.studentlist.setSelectedItem(null);
        this.studentlist.setSelectedItem(etudiant);
    }

}
