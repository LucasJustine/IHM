package fr.iutfbleau.projetIHM2022FI2.view.professeur;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentListener;

import java.awt.BorderLayout;
import java.awt.event.MouseListener;

import fr.iutfbleau.projetIHM2022FI2.API.Etudiant;
import fr.iutfbleau.projetIHM2022FI2.interfaces.ReloadablePanel;
import fr.iutfbleau.projetIHM2022FI2.view.custom.renderer.CustomListRenderer;

public class ResearchStudents extends JPanel implements ReloadablePanel{

    private JTextField researchBar;
    private DefaultListModel<Etudiant> listModel;
    private JList<Etudiant> list;

    public ResearchStudents() {
        super();
        this.setLayout(new BorderLayout());
        this.researchBar = new JTextField(20);
        researchBar.putClientProperty("JTextField.showClearButton", true);   
        researchBar.putClientProperty("JTextField.placeholderText", "Entrez un nom");   

        this.listModel = new DefaultListModel<Etudiant>();
        this.list = new JList<Etudiant>(this.listModel);

        this.list.setCellRenderer(new CustomListRenderer());
        this.list.setLayoutOrientation(JList.VERTICAL_WRAP);
        this.list.setVisibleRowCount(-1);
        this.list.putClientProperty("List.isFileList", Boolean.TRUE);

        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(20,5,20,5));

        panel.add(researchBar);
        this.add(panel,BorderLayout.NORTH);
      
        JScrollPane scrollPane = new JScrollPane(list);
        this.add(scrollPane,BorderLayout.CENTER);

    }

    public DefaultListModel<Etudiant> getListModel() {
        return listModel;
    }

    public void setResearchBarListener(DocumentListener kl) {
        this.researchBar.getDocument().addDocumentListener(kl);
    }

    public void addListMouseListener(MouseListener ml) {
        this.list.addMouseListener(ml);
    }

    @Override
    public void reload() {
        this.researchBar.getText();
    }
}
