/**
 * 
 * @author DJ-Raven
 * https://github.com/DJ-Raven/raven-project
 */

package fr.iutfbleau.projetIHM2022FI2.view.custom.bar;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollBar;

public class ScrollBarCustom extends JScrollBar {

    public ScrollBarCustom() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(8, 8));
        setForeground(new Color(48,48,48));
        setBackground(new Color(200,200,200));
        setUnitIncrement(15);
    }
}
