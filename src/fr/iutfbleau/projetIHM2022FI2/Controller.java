package fr.iutfbleau.projetIHM2022FI2;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.formdev.flatlaf.extras.FlatSVGIcon;

import fr.iutfbleau.projetIHM2022FI2.API.AbstractChangementFactory;
import fr.iutfbleau.projetIHM2022FI2.API.AbstractGroupeFactory;
import fr.iutfbleau.projetIHM2022FI2.view.panel.PanelChoix;
import fr.iutfbleau.projetIHM2022FI2.view.panel.PanelChoixEleves;

public class Controller {

    private JFrame fenetre;
    private JPanel panel;

    public Controller(AbstractGroupeFactory agf,AbstractChangementFactory acf){
        this.fenetre = new JFrame();
        this.fenetre.setTitle("Gestion de groupes");

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        FlatSVGIcon img = new FlatSVGIcon("res/img/logo.svg",50,50,loader);

        this.fenetre.setIconImage(img.getImage());

        CardLayout card = new CardLayout();
        this.fenetre.getContentPane().setLayout(card);

        JPanel panelChoix = new PanelChoix(this,agf,acf);
        JPanel panelChoixEleve = new PanelChoixEleves(agf.getPromotion().getEtudiants(),this,agf,acf);

        fenetre.add(panelChoix,Constants.HOME);
        fenetre.add(panelChoixEleve,Constants.ELEVE);
     

        this.panel = new JPanel(new BorderLayout());
        this.fenetre.add(panel, Constants.PANEL);
        
        this.fenetre.setMinimumSize(new Dimension(800,500));
        this.fenetre.setLocationRelativeTo(null);
        this.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JFrame getFrame(){
        return this.fenetre;
    }

    public void change(JTabbedPane tabbed){
        this.panel.removeAll();
        this.panel.add(tabbed);
    }

    public void visible(){
        fenetre.setVisible(true);
    }
}
