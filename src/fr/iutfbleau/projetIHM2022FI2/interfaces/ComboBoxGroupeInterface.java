package fr.iutfbleau.projetIHM2022FI2.interfaces;

import java.util.Set;
import fr.iutfbleau.projetIHM2022FI2.API.Groupe;

public interface ComboBoxGroupeInterface {

    public void setGroupeDepart(Set<Groupe> groupes);

    public void setGroupeArrivee(Set<Groupe> groupes);

}
