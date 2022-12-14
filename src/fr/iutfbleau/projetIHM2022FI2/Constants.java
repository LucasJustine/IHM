package fr.iutfbleau.projetIHM2022FI2;

import fr.iutfbleau.projetIHM2022FI2.API.Etudiant;
import java.awt.datatransfer.DataFlavor;


/**
 * Classe des constantes. 
 */
public class Constants {
    /**
     * Constante qui représente l'étudiant connecté
     */
    public static Etudiant loggedEtudiant;
    
    /**
     * Constante pour l'action command du bouton Accueil
     * @see fr.iutfbleau.projetIHM2022FI2.view.admin.MoveStudentPanel MoveStudentPanel
     */
    public static final String HOME = "accueil";

    /**
     * Constante pour l'action command du bouton Accueil
     * @see fr.iutfbleau.projetIHM2022FI2.view.admin.MoveStudentPanel MoveStudentPanel
     */
    public static final String PANEL = "panel";

    /**
     * Constante pour l'action command du bouton ajouter Groupe ou étudiant
     * @see fr.iutfbleau.projetIHM2022FI2.view.panel.PanelGroupe PanelGroupe
     * @see fr.iutfbleau.projetIHM2022FI2.view.admin.AddStudentPanel AddStudentPanel
     */
    public static final String ADD = "add";
    
    /**
     * Constante pour l'action command du bouton Confirmer
     * @see fr.iutfbleau.projetIHM2022FI2.view.admin.AddStudentPanel AddStudentPanel
     */
    public static final String CONFIRMED = "confirmed";

    /**
     * Constante pour l'action command du bouton Supprimer groupe ou étudiant
     * @see fr.iutfbleau.projetIHM2022FI2.view.admin.AddStudentPanel AddStudentPanel
     */
    public static final String REMOVE = "remove";

    /**
     * Constante pour l'action command du bouton Annuler un choix 
     * @see fr.iutfbleau.projetIHM2022FI2.view.admin.AddStudentPanel AddStudentPanel
     */
    public static final String CANCEL = "cancel";

    /**
     * Constante pour l'action command du bouton Renommer un groupe 
     * @see fr.iutfbleau.projetIHM2022FI2.view.panel.PanelGroupe PanelGroupe
     */
    public static final String RENAME = "rename";

    /**
     * Constante pour contrôler si les données reçues sont du type Étudiant
     * @see fr.iutfbleau.projetIHM2022FI2.view.panel.PanelGroupe PanelGroupe
     */
    public static final DataFlavor DATA_FLAVOR = new DataFlavor(Etudiant.class, "java/ListItem");

    /**
     * Constante pour contrôler si les données reçues sont du type Étudiant
     * @see fr.iutfbleau.projetIHM2022FI2.view.panel.PanelGroupe PanelGroupe
     */
    public static final String ELEVE = "eleve";
    public static final String PROF = "prof";
    public static final String ADMIN = "admin";
    public static final String P = "persistant";
    public static final String NP = "nonpersistant";
}
