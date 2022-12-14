package fr.iutfbleau.projetIHM2022FI2.view.etudiant;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Color;
import java.awt.GridBagConstraints;

import fr.iutfbleau.projetIHM2022FI2.Constants;
import fr.iutfbleau.projetIHM2022FI2.API.Changement;

public class ChangementPanel extends JPanel {
    public static final String ACCEPT = "accept";
    public static final String DENY = "deny";
    private Changement changement;
    private JButton acceptButton;
    private JButton denyButton;

    public ChangementPanel(Changement c) {
        super();
        this.changement = c;
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        StringBuilder sb = new StringBuilder();
        sb.append("L'étudiant ");
        sb.append(c.getEtu().getNom());
        sb.append(" ");
        sb.append(c.getEtu().getPrenom());
        if(Constants.loggedEtudiant != null && Constants.loggedEtudiant.equals(c.getEtu()))
            sb.append(" (vous) ");
        sb.append(" voudrait passer du groupe ");
        sb.append(c.getA().getName());
        sb.append(" (");
        sb.append(c.getA().getSize());
        sb.append(")");
        sb.append(" au groupe ");
        sb.append(c.getB().getName());
        sb.append(" (");
        sb.append(c.getB().getSize());
        sb.append(")");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JTextArea texte = new JTextArea();
        texte.setEditable(false);  
        texte.setCursor(null);  
        texte.setOpaque(true);  
        texte.setFocusable(false);
        texte.setLineWrap(true);
        texte.setWrapStyleWord(true);
        texte.append(sb.toString());
        texte.setOpaque(false);
        texte.setBorder(BorderFactory.createEmptyBorder());
        this.add(texte, gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
    
        JTextArea explication = new JTextArea(10,20);
        explication.setEditable(false);  
        explication.setCursor(null);  
        explication.setOpaque(true);  
        explication.setFocusable(false);
        explication.setLineWrap(true);
        explication.setWrapStyleWord(true);
        explication.append("Explications : \n" + c.getExplication());
        JScrollPane scroll = new JScrollPane(explication);

        this.add(scroll, gbc);
    }

    public ChangementPanel(Changement c, boolean isAdmin) {
        this(c);
        if(isAdmin)
            this.addButtons();
    }


    private void addButtons() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        this.acceptButton = new ChangementButton("Accepter", this);
        this.acceptButton.setActionCommand(ChangementPanel.ACCEPT);
        this.add(this.acceptButton,gbc);
        gbc.anchor = GridBagConstraints.EAST;
        this.denyButton = new ChangementButton("Refuser", this);
        this.denyButton.setActionCommand(ChangementPanel.DENY);
        this.add(this.denyButton,gbc);
        
    }

    public void addButtonsListener(ActionListener l) {
        this.acceptButton.addActionListener(l);
        this.denyButton.addActionListener(l);
    }

    public Changement getChangement() {
        return changement;
    }

}
