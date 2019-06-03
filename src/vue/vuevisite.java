package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.Tableau;
import controleur.Visite;
import modele.modele;

public class vuevisite extends JPanel implements ActionListener{

	private JTable tablevisite;
	private JPanel paneledition = new JPanel();
	private JButton btajouter = new JButton("Ajouter");
	private JButton btsupprimer = new JButton("Supprimer");
	private JButton btupdate = new JButton("Editer");
	
	private JTextField txtidvisite = new JTextField();
	private JTextField txtidbien = new JTextField();
	private JTextField txtidpersonne = new JTextField();
	private JTextField txtetat = new JTextField();
	private JTextField txtdate = new JTextField();
	private JTextField txtheure = new JTextField();
	private Tableau untableau;
	
	public vuevisite() {
		this.setBounds(50,50,1350,700);
		this.setLayout(null);
		this.setBackground(new Color(239,216,7));
		//construction de la Jtable
		String entete [] = {"ID visite","ID client","ID bien","etat","date","heure"};
		untableau = new Tableau (this.recupererlesvisites(),entete);
		this.tablevisite = new JTable(untableau) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		this.tablevisite.setEnabled(true);
		
		this.tablevisite.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent m) {
				// TODO Auto-generated method stub
					int ligne = tablevisite.getSelectedRow();
					txtidvisite.setText(tablevisite.getValueAt(ligne, 0).toString());
					txtidpersonne.setText(tablevisite.getValueAt(ligne, 1).toString());
					txtidbien.setText(tablevisite.getValueAt(ligne, 2).toString());
					txtetat.setText(tablevisite.getValueAt(ligne, 3).toString());
					txtdate.setText(tablevisite.getValueAt(ligne, 4).toString());
					txtheure.setText(tablevisite.getValueAt(ligne, 5).toString());

			}
		});
		
		//affichage de la Jtable dans une scroll (liste déroulante)
		JScrollPane uneScroll = new JScrollPane(this.tablevisite);
		uneScroll.setBounds(0,0,1300,500);
		uneScroll.setBackground(Color.black);
		this.add(uneScroll);
		
		//construction du panel edition
		this.paneledition.setBounds(20, 540, 1300, 120);
		this.paneledition.setLayout(new GridLayout(2,6));
		this.paneledition.add(new JLabel("ID visite"));
		this.paneledition.add(txtidvisite);
		this.paneledition.add(new JLabel("Etat"));
		this.paneledition.add(txtetat);
		this.paneledition.add(new JLabel("Date visite"));
		this.paneledition.add(txtdate);
		this.paneledition.add(new JLabel("Heure visite"));
		this.paneledition.add(txtheure);
		this.paneledition.add(new JLabel("ID personne"));
		this.paneledition.add(txtidpersonne);
		this.paneledition.add(new JLabel("ID bien"));
		this.paneledition.add(txtidbien);
		this.add(this.paneledition);
		
		this.btajouter.setBounds(200, 675, 100, 20);
		this.add(btajouter);
		this.btsupprimer.setBounds(350, 675, 100, 20);
		this.add(btsupprimer);
		this.btupdate.setBounds(470, 675, 100, 20);
		this.add(btupdate);
		this.txtidvisite.setEditable(false);
		
		// rendre les boutons cliquables
		this.btajouter.addActionListener(this);
		this.btsupprimer.addActionListener(this);
		this.btupdate.addActionListener(this);

		this.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == this.btajouter) {
			Visite unevisite = new Visite (Integer.parseInt(txtidpersonne.getText()),Integer.parseInt(txtidbien.getText()),txtetat.getText(),txtdate.getText(),txtheure.getText());
			modele.insertVisite(unevisite);
			JOptionPane.showMessageDialog(this, "Insertion réussie");
			txtetat.setText("");
			txtdate.setText("");
			txtheure.setText("");
			txtidpersonne.setText("");
			txtidbien.setText("");
			Object [] data = {unevisite.getId_visite()+"",unevisite.getId_bien()+"",unevisite.getId_personne()+"",unevisite.getEtat(),unevisite.getDate(),unevisite.getHeure()};
			this.untableau.add(data);
		}else if (e.getSource() == this.btsupprimer) {
			int idvisite = Integer.parseInt(txtidvisite.getText());
			modele.deletevisite(idvisite);
			JOptionPane.showMessageDialog(this, "Suppression réussie");
			txtidvisite.setText("");
			txtetat.setText("");
			txtdate.setText("");
			txtheure.setText("");
			txtidbien.setText("");
			txtidpersonne.setText("");
			int rowIndex = tablevisite.getSelectedRow();
			untableau.remove(rowIndex);
		}else if(e.getSource() == this.btupdate) {
			int idvisite = Integer.parseInt(txtidvisite.getText());
			Visite unevisite = new Visite (idvisite, Integer.parseInt(txtidpersonne.getText()),Integer.parseInt(txtidbien.getText()),txtetat.getText().toString(),txtdate.getText().toString(),txtheure.getText().toString());
			modele.updatevisite(unevisite);
			JOptionPane.showMessageDialog(this, "Mise à jour réussie");
			Object data []= {unevisite.getId_visite()+"",unevisite.getId_bien()+"",unevisite.getId_personne()+"",unevisite.getEtat(),unevisite.getDate(),unevisite.getHeure()};
			int rowIndex = tablevisite.getSelectedRow();
			this.untableau.update(rowIndex,data);
			txtidvisite.setText("");
			txtidbien.setText("");
			txtidpersonne.setText("");
			txtetat.setText("");
			txtdate.setText("");
			txtheure.setText("");

		}
	}
	// récuperer les données sous forme de matrice (tableau)
	private Object [][] recupererlesvisites(){
		ArrayList<Visite> lesvisites = modele.SelectAllVisite();
		Object [][] donnees = new Object[lesvisites.size()][Visite.getNbchampsvisites()];
		int i = 0;
		for(Visite unevisite : lesvisites) {
			donnees[i][0] = unevisite.getId_visite()+"";
			donnees[i][1] = unevisite.getId_personne()+"";
			donnees[i][2] = unevisite.getId_bien()+"";
			donnees[i][3] = unevisite.getEtat();
			donnees[i][4] = unevisite.getDate();
			donnees[i][5] = unevisite.getHeure();
			i++;
		}
		return donnees;
	}
}
