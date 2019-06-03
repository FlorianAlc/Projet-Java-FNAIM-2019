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

import controleur.Client;
import modele.modele;
import controleur.Tableau;

public class vueclients extends JPanel implements ActionListener{
	
	private JTable tableclients;
	private JPanel paneledition = new JPanel();
	private JButton btajouter = new JButton("Ajouter");
	private JButton btsupprimer = new JButton("Supprimer");
	private JButton btupdate = new JButton("Editer");
	
	private JTextField txtidclient = new JTextField();
	private JTextField txtnom = new JTextField();
	private JTextField txtprenom = new JTextField();
	private JTextField txtemail = new JTextField();
	private JTextField txttelephone = new JTextField();
	private JTextField txtpassword = new JTextField();
	private JTextField txtsexe = new JTextField();
	private JTextField txtdatenaissance = new JTextField();
	private JTextField txtdroits = new JTextField();
	private JTextField txtstatut = new JTextField();
	private JTextField txtdate_insc = new JTextField();
	private JTextField txtdepartement = new JTextField();
	private JTextField txtperimetre_action = new JTextField();
	private JTextField txtdate_embauche = new JTextField();
	private Tableau untableau;
	
	public vueclients() {
		this.setBounds(50,50,1350,700);
		this.setLayout(null);
		this.setBackground(new Color(239,216,7));
		//construction de la Jtable
		String entete [] = {"ID utilisateur","Nom utilisateur","Prenom utilisateur","email","Telephone","Password","Sexe","Date de naissance","droits","Statut","Date inscription","Departement","Perimètre d'action","Date embauche"};
		untableau = new Tableau (this.recupererlesclients(),entete);
		this.tableclients = new JTable(untableau) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		this.tableclients.setEnabled(true);
		
		this.tableclients.addMouseListener(new MouseListener() {
			
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
					int ligne = tableclients.getSelectedRow();
					txtidclient.setText(tableclients.getValueAt(ligne, 0).toString());
					txtnom.setText(tableclients.getValueAt(ligne, 1).toString());
					txtprenom.setText(tableclients.getValueAt(ligne, 2).toString());
					txtemail.setText(tableclients.getValueAt(ligne, 3).toString());
					txttelephone.setText(tableclients.getValueAt(ligne, 4).toString());
					txtpassword.setText(tableclients.getValueAt(ligne, 5).toString());
					txtsexe.setText(tableclients.getValueAt(ligne, 6).toString());
					txtdatenaissance.setText(tableclients.getValueAt(ligne, 7).toString());
					txtdroits.setText(tableclients.getValueAt(ligne, 8).toString());
					txtstatut.setText(tableclients.getValueAt(ligne, 9).toString());
					if (Integer.parseInt(txtstatut.getText()) == 1) {
						txtdate_insc.setText(tableclients.getValueAt(ligne, 10).toString());
						txtdepartement.setText(tableclients.getValueAt(ligne, 11).toString());
					}else if (Integer.parseInt(txtstatut.getText()) == 2) {
						txtperimetre_action.setText(tableclients.getValueAt(ligne, 12).toString());
						txtdate_embauche.setText(tableclients.getValueAt(ligne, 13).toString());
					}
			}
		});
		
		//affichage de la Jtable dans une scroll (liste déroulante)
		JScrollPane uneScroll = new JScrollPane(this.tableclients);
		uneScroll.setBounds(0,0,1300,500);
		uneScroll.setBackground(Color.black);
		this.add(uneScroll);
		
		//construction du panel edition
		this.paneledition.setBounds(20, 540, 1300, 120);
		this.paneledition.setLayout(new GridLayout(2,9));
		this.paneledition.add(new JLabel("ID utilisateur"));
		this.paneledition.add(txtidclient);
		this.paneledition.add(new JLabel("Nom"));
		this.paneledition.add(txtnom);
		this.paneledition.add(new JLabel("Prenom"));
		this.paneledition.add(txtprenom);
		this.paneledition.add(new JLabel("Email"));
		this.paneledition.add(txtemail);
		this.paneledition.add(new JLabel("telephone"));
		this.paneledition.add(txttelephone);
		this.paneledition.add(new JLabel("password"));
		this.paneledition.add(txtpassword);
		this.paneledition.add(new JLabel("sexe"));
		this.paneledition.add(txtsexe);
		this.paneledition.add(new JLabel("date de naissance"));
		this.paneledition.add(txtdatenaissance);
		this.paneledition.add(new JLabel("droits"));
		this.paneledition.add(txtdroits);
		this.paneledition.add(new JLabel("Statut"));
		this.paneledition.add(txtstatut);
		this.paneledition.add(new JLabel("Date inscription"));
		this.paneledition.add(txtdate_insc);
		this.paneledition.add(new JLabel("Departement"));
		this.paneledition.add(txtdepartement);
		this.paneledition.add(new JLabel("Perimètre Action"));
		this.paneledition.add(txtperimetre_action);
		this.paneledition.add(new JLabel("Date embauche"));
		this.paneledition.add(txtdate_embauche);
		this.add(this.paneledition);
		
		this.btajouter.setBounds(200, 675, 100, 20);
		this.add(btajouter);
		this.btsupprimer.setBounds(350, 675, 100, 20);
		this.add(btsupprimer);
		this.btupdate.setBounds(470, 675, 100, 20);
		this.add(btupdate);
		this.txtidclient.setEditable(false);
		
		// rendre les boutons cliquables
		this.btajouter.addActionListener(this);
		this.btsupprimer.addActionListener(this);
		this.btupdate.addActionListener(this);
		
		this.setVisible(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btajouter) {
			if(Integer.parseInt(txtstatut.getText()) == 1) {
				Client unclient = new Client (txtnom.getText(), txtprenom.getText(), txtemail.getText(),txttelephone.getText(), txtpassword.getText(), txtsexe.getText(), txtdatenaissance.getText(), txtdroits.getText(), Integer.parseInt(txtstatut.getText()),txtdate_insc.getText(), Integer.parseInt(txtdepartement.getText()));
				modele.insertClient(unclient);
				Object data [] = {1,unclient.getNom(),unclient.getPrenom(),unclient.getEmail(),unclient.getTelephone(),unclient.getPassword(),unclient.getSexe(),unclient.getDate_naissance(),unclient.getDroits(),unclient.getStatut(),unclient.getDate_insc(),unclient.getDepartement(),"",""};
				this.untableau.add(data);
				JOptionPane.showMessageDialog(this, "Insertion réussie");
			}else if (Integer.parseInt(txtstatut.getText()) == 2) {
				Client unclient = new Client (txtnom.getText(), txtprenom.getText(), txtemail.getText(),txttelephone.getText(), txtpassword.getText(), txtsexe.getText(), txtdatenaissance.getText(), txtdroits.getText(), Integer.parseInt(txtstatut.getText()),txtperimetre_action.getText(), txtdate_embauche.getText());
				modele.insertClient(unclient);
				Object data [] = {1,unclient.getNom(),unclient.getPrenom(),unclient.getEmail(),unclient.getTelephone(),unclient.getPassword(),unclient.getSexe(),unclient.getDate_naissance(),unclient.getDroits(),unclient.getStatut(),"","",unclient.getPerimetre_action(),unclient.getDate_embauche()};
				this.untableau.add(data);
				JOptionPane.showMessageDialog(this, "Insertion réussie");
			}else {
				JOptionPane.showMessageDialog(this, "Insertion failure");
			}
			
			txtnom.setText("");
			txtprenom.setText("");
			txtemail.setText("");
			txttelephone.setText("");
			txtpassword.setText("");
			txtsexe.setText("");
			txtdatenaissance.setText("");
			txtdroits.setText("");
			txtstatut.setText("");
			txtdate_insc.setText("");
			txtdepartement.setText("");
			txtperimetre_action.setText("");
			txtdate_embauche.setText("");
		}else if (e.getSource() == this.btsupprimer) {
			int idclient = Integer.parseInt(txtidclient.getText());
			if (Integer.parseInt(txtstatut.getText()) == 1) {
				Client unclient = new Client (idclient,Integer.parseInt(txtstatut.getText()));
				modele.deleteclient(unclient);
				int rowIndex = tableclients.getSelectedRow();
				untableau.remove(rowIndex);
				JOptionPane.showMessageDialog(this, "Suppression réussie");
			}else if (Integer.parseInt(txtstatut.getText()) == 2) {
				Client unclient = new Client (idclient,Integer.parseInt(txtstatut.getText()));
				modele.deleteclient(unclient);
				int rowIndex = tableclients.getSelectedRow();
				untableau.remove(rowIndex);
				JOptionPane.showMessageDialog(this, "Suppression réussie");
			}else {
				JOptionPane.showMessageDialog(this, "Suppression failure");
			}
			txtidclient.setText("");
			txtnom.setText("");
			txtprenom.setText("");
			txtemail.setText("");
			txttelephone.setText("");
			txtpassword.setText("");
			txtsexe.setText("");
			txtdatenaissance.setText("");
			txtdroits.setText("");
			txtstatut.setText("");
			txtdate_insc.setText("");
			txtdepartement.setText("");
			txtperimetre_action.setText("");
			txtdate_embauche.setText("");

		}else if(e.getSource() == this.btupdate) {
			int idclient = Integer.parseInt(txtidclient.getText());
			if(Integer.parseInt(txtstatut.getText()) == 1) {
				Client unclient = new Client (idclient, txtnom.getText(), txtprenom.getText(), txtemail.getText(), Integer.parseInt(txttelephone.getText()), txtpassword.getText(), txtsexe.getText(), txtdatenaissance.getText(), txtdroits.getText(), Integer.parseInt(txtstatut.getText()), Integer.parseInt(txtdepartement.getText()));
				modele.updatePersonne(unclient);
				Object data [] = {idclient,unclient.getNom(),unclient.getPrenom(),unclient.getEmail(),unclient.getTelephone(),unclient.getPassword(),unclient.getSexe(),unclient.getDate_naissance(),unclient.getDroits(),unclient.getStatut(),unclient.getDate_insc(),unclient.getDepartement(),"",""};
				int rowIndex = tableclients.getSelectedRow();
				this.untableau.update(rowIndex,data);
				JOptionPane.showMessageDialog(this, "Mise à jour réussie");
			}else if (Integer.parseInt(txtstatut.getText()) == 2) {
				Client unclient = new Client (idclient, txtnom.getText(), txtprenom.getText(), txtemail.getText(), txttelephone.getText(), txtpassword.getText(), txtsexe.getText(), txtdatenaissance.getText(), txtdroits.getText(),Integer.parseInt(txtstatut.getText()), txtperimetre_action.getText());
				modele.updatePersonne(unclient);
				Object data [] = {1,unclient.getNom(),unclient.getPrenom(),unclient.getEmail(),unclient.getTelephone(),unclient.getPassword(),unclient.getSexe(),unclient.getDate_naissance(),unclient.getDroits(),unclient.getStatut(),"","",unclient.getPerimetre_action(),unclient.getDate_embauche()};
				int rowIndex = tableclients.getSelectedRow();
				this.untableau.update(rowIndex,data);
				JOptionPane.showMessageDialog(this, "Mise à jour réussie");
			}else {
				JOptionPane.showMessageDialog(this, "Mise à jour échoué");
			}
			txtidclient.setText("");
			txtnom.setText("");
			txtprenom.setText("");
			txtemail.setText("");
			txttelephone.setText("");
			txtpassword.setText("");
			txtsexe.setText("");
			txtdatenaissance.setText("");
			txtdroits.setText("");
			txtstatut.setText("");
			txtdate_insc.setText("");
			txtdepartement.setText("");
			txtperimetre_action.setText("");
			txtdate_embauche.setText("");
		}
	}
	// récuperer les données sous forme de matrice (tableau)
	private Object [][] recupererlesclients(){
		ArrayList<Client> lesPersonnes = modele.selectAllPersonne();
		Object [][] donnees = new Object[lesPersonnes.size()][Client.getNbchampsclients()];
		int i = 0;
		for(Client unePersonne : lesPersonnes) {
			if(unePersonne.getStatut() == 1) {
				ArrayList<Client> lesclients = modele.SelectJoinClient(unePersonne.getIdclient());
				for (Client unClient : lesclients) {
					donnees[i][0] = unClient.getIdclient()+"";
					donnees[i][1] = unClient.getNom();
					donnees[i][2] = unClient.getPrenom();
					donnees[i][3] = unClient.getEmail();
					donnees[i][4] = unClient.getTelephone();
					donnees[i][5] = unClient.getPassword();
					donnees[i][6] = unClient.getSexe();
					donnees[i][7] = unClient.getDate_naissance();
					donnees[i][8] = unClient.getDroits();
					donnees[i][9] = unClient.getStatut();
					donnees[i][10] = unClient.getDate_insc();
					donnees[i][11] = unClient.getDepartement();
					donnees[i][12] = "";
					donnees[i][13] = "";
					i++;
				}
			}else if (unePersonne.getStatut() == 2) {
				ArrayList<Client> lescommerciales = modele.SelectJoinCommerciale(unePersonne.getIdclient());
				for (Client unCommerciale : lescommerciales) {
					donnees[i][0] = unCommerciale.getIdclient()+"";
					donnees[i][1] = unCommerciale.getNom();
					donnees[i][2] = unCommerciale.getPrenom();
					donnees[i][3] = unCommerciale.getEmail();
					donnees[i][4] = unCommerciale.getTelephone();
					donnees[i][5] = unCommerciale.getPassword();
					donnees[i][6] = unCommerciale.getSexe();
					donnees[i][7] = unCommerciale.getDate_naissance();
					donnees[i][8] = unCommerciale.getDroits();
					donnees[i][9] = unCommerciale.getStatut();
					donnees[i][10] = "";
					donnees[i][11] = "";
					donnees[i][12] = unCommerciale.getPerimetre_action();
					donnees[i][13] = unCommerciale.getDate_embauche();
					i++;
				}
			}
		}
		return donnees;
	}
}
