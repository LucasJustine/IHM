package fr.iutfbleau.projetIHM2022FI2;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.formdev.flatlaf.util.SystemInfo;
import com.formdev.flatlaf.IntelliJTheme;

import fr.iutfbleau.projetIHM2022FI2.API.AbstractChangementFactory;
import fr.iutfbleau.projetIHM2022FI2.API.AbstractGroupeFactory;
import fr.iutfbleau.projetIHM2022FI2.API.Etudiant;
import fr.iutfbleau.projetIHM2022FI2.MNP.AbstractChangementFactoryNP;
import fr.iutfbleau.projetIHM2022FI2.MNP.AbstractGroupeFactoryNP;
import fr.iutfbleau.projetIHM2022FI2.MNP.EtudiantNP;
import fr.iutfbleau.projetIHM2022FI2.MP.AbstractChangementFactoryP;
import fr.iutfbleau.projetIHM2022FI2.MP.AbstractGroupeFactoryP;


public class Main{


    public static void main(String[] args) {
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            IntelliJTheme.setup( loader.getResourceAsStream("res/themes/Atom_One_Dark_Contrast.theme.json"));
            if( SystemInfo.isLinux ) {
                // enable custom window decorations
                JFrame.setDefaultLookAndFeelDecorated( true );
                JDialog.setDefaultLookAndFeelDecorated( true );
            }
            UIManager.put("TitlePane.centerTitle", true);
            UIManager.put("TitlePane.iconSize", new Dimension(25,25));
            UIManager.put("TitlePane.unifiedBackground", false);
            UIManager.put("Tree.rightChildIndent", 10);
            UIManager.put("Tree.leftChildIndent", 10);
            UIManager.put("Tree.rowHeight", 30);
            Font font = UIManager.getFont("defaultFont");
            font = font.deriveFont((float) font.getSize() + 2);
            UIManager.put("defaultFont", font);

        } catch (Exception e) {

        }   

        AbstractGroupeFactory agf;
        AbstractChangementFactory acf;

        Object[] choix={"Modèle persistant","Modèle non persistant","Annuler"};
        int res = JOptionPane.showOptionDialog(null, "Choisir le modèle voulu", "Choix du modèle", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, choix, choix[0]);
        
        switch (res) {
            case 0:
                agf = new AbstractGroupeFactoryP();
                acf = new AbstractChangementFactoryP(agf);
                break;

            case 1:
                agf = new AbstractGroupeFactoryNP("BUT2 FI", 15, 92);
                acf = new AbstractChangementFactoryNP(agf);
                populateGroupe(agf);
                break;
        
            default:
                return;
        }
       
        Controller c = new Controller(agf,acf);
        c.visible();
    }
    
    public static void populateGroupe(AbstractGroupeFactory agf) {
        
        Etudiant e1=new EtudiantNP("césar","lycurgus");
        Etudiant e2=new EtudiantNP("denis","uranus");
        Etudiant e3=new EtudiantNP("marcel","castor");
        Etudiant e4=new EtudiantNP("marin","eurydice");
        Etudiant e5=new EtudiantNP("constantin","akoni");
        Etudiant e6=new EtudiantNP("donat","anakoni");
        Etudiant e7=new EtudiantNP("alexandre","apikalia");
        Etudiant e8=new EtudiantNP("andré","ekewaka");
        Etudiant e9=new EtudiantNP("renard","elikapeka");
        Etudiant e10=new EtudiantNP("achille","haukea");

        
        
        Etudiant e11=new EtudiantNP("agathe","iakopa");
        Etudiant e12=new EtudiantNP("sabine","spartacus");
        Etudiant e13=new EtudiantNP("michel","caligula");
        Etudiant e14=new EtudiantNP("marthe","alaric");
        Etudiant e15=new EtudiantNP("juliane","hannibal");
        Etudiant e16=new EtudiantNP("anne","juvenal");
        Etudiant e17=new EtudiantNP("sophie","bede");
        Etudiant e18=new EtudiantNP("louis","hamilcar");
        Etudiant e19=new EtudiantNP("diane","ladislas");
        Etudiant e20=new EtudiantNP("christine","mahatma");


        
        Etudiant e21=new EtudiantNP("francine","napoleon");
        Etudiant e22=new EtudiantNP("louise","lalita");
        Etudiant e23=new EtudiantNP("chantal","laxman");
        Etudiant e24=new EtudiantNP("giselle","laxmi");
        Etudiant e25=new EtudiantNP("caroline","leela");
        Etudiant e26=new EtudiantNP("claude","lila");
        Etudiant e27=new EtudiantNP("pauline","lilavati");
        Etudiant e28=new EtudiantNP("avril","lochan");
        Etudiant e29=new EtudiantNP("jacqueline","madhav");
        Etudiant e30=new EtudiantNP("denise","turlough");

        
        
        Etudiant e31=new EtudiantNP("gabrielle","uaithne");
        Etudiant e32=new EtudiantNP("julie","uilleag");
        Etudiant e33=new EtudiantNP("madeleine","uilliam");
        Etudiant e34=new EtudiantNP("charlotte","uinseann");
        Etudiant e35=new EtudiantNP("bertrand","ulick");
        Etudiant e36=new EtudiantNP("lucile","ultan");
        Etudiant e37=new EtudiantNP("nicole","firdaus");
        Etudiant e38=new EtudiantNP("blanche","yasmin");
        Etudiant e39=new EtudiantNP("jeanine","javed");
        Etudiant e40=new EtudiantNP("roxane","naveed");

        
        
        Etudiant e41=new EtudiantNP("adeline","shahnaz");
        Etudiant e42=new EtudiantNP("dion","ardashir");
        Etudiant e43=new EtudiantNP("liane","atefeh");
        Etudiant e44=new EtudiantNP("myriam","luigina");
        Etudiant e45=new EtudiantNP("danielle","luigino");
        Etudiant e46=new EtudiantNP("arlette","maddalena");
        Etudiant e47=new EtudiantNP("michelle","manfredo");
        Etudiant e48=new EtudiantNP("justine","manlio");
        Etudiant e49=new EtudiantNP("natalie","marcellino");
        Etudiant e50=new EtudiantNP("aline","mariangela");

        
        
        Etudiant e51=new EtudiantNP("prosper","marzio");
        Etudiant e52=new EtudiantNP("mirabelle","massimiliano");
        Etudiant e53=new EtudiantNP("carine","matteo");
        Etudiant e54=new EtudiantNP("jeannine","melchiorre");
        Etudiant e55=new EtudiantNP("dianne","micaela");
        Etudiant e56=new EtudiantNP("evette","michela");
        Etudiant e57=new EtudiantNP("gisselle","michelangela");

        

        agf.addToGroupe(agf.getPromotion(),e1);
        agf.addToGroupe(agf.getPromotion(),e2);
        agf.addToGroupe(agf.getPromotion(),e3);
        agf.addToGroupe(agf.getPromotion(),e4);
        agf.addToGroupe(agf.getPromotion(),e5);
        agf.addToGroupe(agf.getPromotion(),e6);
        agf.addToGroupe(agf.getPromotion(),e7);
        agf.addToGroupe(agf.getPromotion(),e8);
        agf.addToGroupe(agf.getPromotion(),e9);
        agf.addToGroupe(agf.getPromotion(),e10);


        agf.addToGroupe(agf.getPromotion(),e11);
        agf.addToGroupe(agf.getPromotion(),e12);
        agf.addToGroupe(agf.getPromotion(),e13);
        agf.addToGroupe(agf.getPromotion(),e14);
        agf.addToGroupe(agf.getPromotion(),e15);
        agf.addToGroupe(agf.getPromotion(),e16);
        agf.addToGroupe(agf.getPromotion(),e17);
        agf.addToGroupe(agf.getPromotion(),e18);
        agf.addToGroupe(agf.getPromotion(),e19);
        agf.addToGroupe(agf.getPromotion(),e20);

        
        
        agf.addToGroupe(agf.getPromotion(),e21);
        agf.addToGroupe(agf.getPromotion(),e22);
        agf.addToGroupe(agf.getPromotion(),e23);
        agf.addToGroupe(agf.getPromotion(),e24);
        agf.addToGroupe(agf.getPromotion(),e25);
        agf.addToGroupe(agf.getPromotion(),e26);
        agf.addToGroupe(agf.getPromotion(),e27);
        agf.addToGroupe(agf.getPromotion(),e28);
        agf.addToGroupe(agf.getPromotion(),e29);
        agf.addToGroupe(agf.getPromotion(),e30);
        agf.addToGroupe(agf.getPromotion(),e31);
        agf.addToGroupe(agf.getPromotion(),e32);
        agf.addToGroupe(agf.getPromotion(),e33);
        agf.addToGroupe(agf.getPromotion(),e34);
        agf.addToGroupe(agf.getPromotion(),e35);
        agf.addToGroupe(agf.getPromotion(),e36);
        agf.addToGroupe(agf.getPromotion(),e37);
        agf.addToGroupe(agf.getPromotion(),e38);
        agf.addToGroupe(agf.getPromotion(),e39);

        
        
        agf.addToGroupe(agf.getPromotion(),e40);
        agf.addToGroupe(agf.getPromotion(),e41);
        agf.addToGroupe(agf.getPromotion(),e42);
        agf.addToGroupe(agf.getPromotion(),e43);
        agf.addToGroupe(agf.getPromotion(),e44);
        agf.addToGroupe(agf.getPromotion(),e45);
        agf.addToGroupe(agf.getPromotion(),e46);
        agf.addToGroupe(agf.getPromotion(),e47);
        agf.addToGroupe(agf.getPromotion(),e48);
        agf.addToGroupe(agf.getPromotion(),e49);
        agf.addToGroupe(agf.getPromotion(),e50);
        agf.addToGroupe(agf.getPromotion(),e51);
        agf.addToGroupe(agf.getPromotion(),e52);
        agf.addToGroupe(agf.getPromotion(),e53);
        agf.addToGroupe(agf.getPromotion(),e54);
        agf.addToGroupe(agf.getPromotion(),e55);
        agf.addToGroupe(agf.getPromotion(),e56);
        agf.addToGroupe(agf.getPromotion(),e57);

        agf.createPartition(agf.getPromotion(), "TD",3);
    }
}
