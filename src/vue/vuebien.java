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

import controleur.Bien;
import modele.modele;
import controleur.Tableau;

public class vuebien extends JPanel implements ActionListener{
	
	private JTable tablebien;
	private JPanel paneledition = new JPanel();
	private JButton btajouter = new JButton("Ajouter");
	private JButton btsupprimer = new JButton("Supprimer");
	private JButton btupdate = new JButton("Editer");
	private JButton btrecherche = new JButton("Rechercher");
	
	private JTextField txtidbien = new JTextField();
	private JTextField txtsurface = new JTextField();
	private JTextField txtprix = new JTextField();
	private JTextField txtadresse = new JTextField();
	private JTextField txtville = new JTextField();
	private JTextField txtpiece = new JTextField();
	private JTextField txtchambre = new JTextField();
	private JTextField txteau = new JTextField();
	private JTextField txtstatut = new JTextField();
	private JTextField txtrecherche = new JTextField();
	private JTextField txttype = new JTextField();
	private JTextField txtetage = new JTextField();
	private JTextField txtascenseur = new JTextField();
	private JTextField txtbalcon = new JTextField();
	private JTextField txtplace_parking = new JTextField();
	private JTextField txtSurface_terrain = new JTextField();
	private JTextField txtcave = new JTextField();
	private JTextField txtgrenier = new JTextField();
	private Tableau untableau;
	
	public vuebien() {
		this.setBounds(50,50,1700,800);
		this.setLayout(null);
		this.setBackground(new Color(239,216,7));
		//construction de la Jtable
		String entete [] = {"ID bien","Adresse","Prix","Surface","Ville","Piece","Chambre","Salle de bain","Statut","Type","Etage","Ascenseur","Balcon","Place de parking","Cave","Grenier","Surface terrain"};
		untableau = new Tableau (this.recupererlesbiens(),entete);
		this.tablebien = new JTable(untableau) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		this.tablebien.setEnabled(true);
		
		this.tablebien.addMouseListener(new MouseListener() {
			
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
					int ligne = tablebien.getSelectedRow();
					txtidbien.setText(tablebien.getValueAt(ligne, 0).toString());
					txtadresse.setText(tablebien.getValueAt(ligne, 1).toString());
					txtprix.setText(tablebien.getValueAt(ligne, 2).toString());
					txtsurface.setText(tablebien.getValueAt(ligne, 3).toString());
					txtville.setText(tablebien.getValueAt(ligne, 4).toString());
					txtpiece.setText(tablebien.getValueAt(ligne, 5).toString());
					txtchambre.setText(tablebien.getValueAt(ligne, 6).toString());
					txteau.setText(tablebien.getValueAt(ligne, 7).toString());
					txtstatut.setText(tablebien.getValueAt(ligne, 8).toString());
					txttype.setText(tablebien.getValueAt(ligne, 9).toString());
					if(tablebien.getValueAt(ligne, 9).equals("appartement")) {
						txtetage.setText(tablebien.getValueAt(ligne, 10).toString());
						txtascenseur.setText(tablebien.getValueAt(ligne, 11).toString());
						txtbalcon.setText(tablebien.getValueAt(ligne, 12).toString());
						txtplace_parking.setText(tablebien.getValueAt(ligne, 13).toString());
					}else if (tablebien.getValueAt(ligne, 9).equals("maison")) {
						txtcave.setText(tablebien.getValueAt(ligne, 14).toString());
						txtgrenier.setText(tablebien.getValueAt(ligne, 15).toString());
						txtSurface_terrain.setText(tablebien.getValueAt(ligne, 16).toString());
					}
			}
		});
		
		//affichage de la Jtable dans une scroll (liste déroulante)
		JScrollPane uneScroll = new JScrollPane(this.tablebien);
		uneScroll.setBounds(0,0,1600,500);
		uneScroll.setBackground(Color.black);
		this.add(uneScroll);
		
		//construction du panel edition
		this.paneledition.setBounds(20, 540, 1300, 120);
		this.paneledition.setLayout(new GridLayout(4,18));
		this.paneledition.add(new JLabel("ID bien"));
		this.paneledition.add(txtidbien);
		this.paneledition.add(new JLabel("Adresse"));
		this.paneledition.add(txtadresse);
		this.paneledition.add(new JLabel("Prix"));
		this.paneledition.add(txtprix);
		this.paneledition.add(new JLabel("Statut"));
		this.paneledition.add(txtstatut);
		this.paneledition.add(new JLabel("Ville"));
		this.paneledition.add(txtville);
		this.paneledition.add(new JLabel("Pieces"));
		this.paneledition.add(txtpiece);
		this.paneledition.add(new JLabel("Chambre"));
		this.paneledition.add(txtchambre);
		this.paneledition.add(new JLabel("Salle de bains"));
		this.paneledition.add(txteau);
		this.paneledition.add(new JLabel("Surface"));
		this.paneledition.add(txtsurface);
		this.paneledition.add(new JLabel("Type"));
		this.paneledition.add(txttype);
		this.paneledition.add(new JLabel("Etage"));
		this.paneledition.add(txtetage);
		this.paneledition.add(new JLabel("Ascenseur"));
		this.paneledition.add(txtascenseur);
		this.paneledition.add(new JLabel("Balcon"));
		this.paneledition.add(txtbalcon);
		this.paneledition.add(new JLabel("Place de parking"));
		this.paneledition.add(txtplace_parking);
		this.paneledition.add(new JLabel("Cave"));
		this.paneledition.add(txtcave);
		this.paneledition.add(new JLabel("Grenier"));
		this.paneledition.add(txtgrenier);
		this.paneledition.add(new JLabel("Surface terrain"));
		this.paneledition.add(txtSurface_terrain);
		this.paneledition.add(new JLabel("Recherche"));
		this.paneledition.add(txtrecherche);
		this.add(this.paneledition);
		
		
		this.btajouter.setBounds(200, 675, 100, 20);
		this.add(btajouter);
		this.btsupprimer.setBounds(350, 675, 100, 20);
		this.add(btsupprimer);
		this.btupdate.setBounds(500, 675, 100, 20);
		this.add(btupdate);
		this.btrecherche.setBounds(650, 675, 100, 20);
		this.add(btrecherche);
		this.txtidbien.setEditable(false);
		
		// rendre les boutons cliquables
		this.btajouter.addActionListener(this);
		this.btsupprimer.addActionListener(this);
		this.btupdate.addActionListener(this);
		this.btrecherche.addActionListener(this);
		
		this.setVisible(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btajouter) {
			if(txttype.getText().equals("appartement")) {
				Bien unbien = new Bien (txtadresse.getText().toString(),txtprix.getText().toString(),txtsurface.getText().toString(),txtville.getText().toString(),txtpiece.getText().toString(),txtchambre.getText().toString(),txteau.getText().toString(),txtstatut.getText().toString(),txttype.getText(),0,Integer.parseInt(txtetage.getText()),Integer.parseInt(txtascenseur.getText()),Integer.parseInt(txtbalcon.getText()),Integer.parseInt(txtplace_parking.getText()));
				modele.insertbien(unbien);
				//Object data [] = {1,unbien.getAdresse(),unbien.getPrix(),unbien.getSurface(),unbien.getVille(),unbien.getPiece(),unbien.getChambre(),unbien.getEau(),unbien.getStatut(),unbien.getType(),unbien.getEtage(),unbien.getAscenseur(),unbien.getBalcon(),unbien.getParking()};
				//this.untableau.add(data);
				JOptionPane.showMessageDialog(this, "Insertion réussie");
			}else if (txttype.getText().equals("maison")) {
				Bien unbien = new Bien (txtadresse.getText().toString(),txtprix.getText().toString(),txtsurface.getText().toString(),txtville.getText().toString(),Integer.parseInt(txtpiece.getText()),Integer.parseInt(txtchambre.getText()),Integer.parseInt(txteau.getText()),txtstatut.getText().toString(),txttype.getText(),0,Integer.parseInt(txtSurface_terrain.getText()),Integer.parseInt(txtcave.getText()),Integer.parseInt(txtgrenier.getText()));
				modele.insertbien(unbien);
				Object data [] = {1,unbien.getAdresse(),unbien.getPrix(),unbien.getSurface(),unbien.getVille(),unbien.getPiece(),unbien.getChambre(),unbien.getEau(),unbien.getStatut(),unbien.getType(),"","","","",unbien.getCave(),unbien.getGrenier()};
				this.untableau.add(data);
				JOptionPane.showMessageDialog(this, "Insertion réussie");
			}else {
				JOptionPane.showMessageDialog(this, "Insertion Failure");
			}
			txtadresse.setText("");
			txtprix.setText("");
			txtsurface.setText("");
			txtville.setText("");
			txtpiece.setText("");
			txtchambre.setText("");
			txteau.setText("");
			txtstatut.setText("");
			txttype.setText("");
			txtetage.setText("");
			txtascenseur.setText("");
			txtbalcon.setText("");
			txtplace_parking.setText("");
			txtSurface_terrain.setText("");
			txtcave.setText("");
			txtgrenier.setText("");
		}else if (e.getSource() == this.btsupprimer) {
			int idbien = Integer.parseInt(txtidbien.getText());
			Bien unbien = new Bien (idbien,txttype.getText());
			modele.deletebien(unbien);
			JOptionPane.showMessageDialog(this, "Suppression réussie");
			txtadresse.setText("");
			txtprix.setText("");
			txtsurface.setText("");
			txtville.setText("");
			txtpiece.setText("");
			txtchambre.setText("");
			txteau.setText("");
			txtstatut.setText("");
			txttype.setText("");
			txtetage.setText("");
			txtascenseur.setText("");
			txtbalcon.setText("");
			txtplace_parking.setText("");
			txtSurface_terrain.setText("");
			txtcave.setText("");
			txtgrenier.setText("");
			int rowIndex = tablebien.getSelectedRow();
			untableau.remove(rowIndex);
		}else if(e.getSource() == this.btupdate) {
			int idbien = Integer.parseInt(txtidbien.getText());
			if(txttype.getText().equals("appartement")){
				Bien unbien = new Bien (idbien,txtadresse.getText().toString(),Integer.parseInt(txtprix.getText()),Integer.parseInt(txtsurface.getText()),txtville.getText().toString(),Integer.parseInt(txtpiece.getText()),Integer.parseInt(txtchambre.getText()),Integer.parseInt(txteau.getText()),txtstatut.getText().toString(),txttype.getText().toString(),Integer.parseInt(txtetage.getText()), Integer.parseInt(txtascenseur.getText()),Integer.parseInt(txtbalcon.getText()), Integer.parseInt(txtplace_parking.getText()));
				modele.updatebien(unbien);
				JOptionPane.showMessageDialog(this, "Mise à jour réussie");
				//Object data [] = {unbien.getIdBien()+"",unbien.getAdresse(),unbien.getPrix(),unbien.getSurface(),unbien.getVille(),unbien.getPiece(),unbien.getChambre(),unbien.getEau(),unbien.getStatut(),unbien.getType(),unbien.getEtage(),unbien.getAscenseur(),unbien.getBalcon(),unbien.getParking(),"",""};
				//int rowIndex = tablebien.getSelectedRow();
				//this.untableau.update(rowIndex,data);
			}else if (txttype.getText().equals("maison")) {
				Bien unbien = new Bien (idbien,txtadresse.getText().toString(),Integer.parseInt(txtprix.getText()),Integer.parseInt(txtsurface.getText()),txtville.getText().toString(),Integer.parseInt(txtpiece.getText()),Integer.parseInt(txtchambre.getText()),Integer.parseInt(txteau.getText()),txtstatut.getText().toString(),txttype.getText().toString(),Integer.parseInt(txtSurface_terrain.getText()), Integer.parseInt(txtcave.getText()),Integer.parseInt(txtgrenier.getText()));
				modele.updatebien(unbien);
				JOptionPane.showMessageDialog(this, "Mise à jour réussie");
				//Object data [] = {unbien.getIdBien()+"",unbien.getAdresse(),unbien.getPrix(),unbien.getSurface(),unbien.getVille(),unbien.getPiece(),unbien.getChambre(),unbien.getEau(),unbien.getStatut(),unbien.getType(),"","","","",unbien.getCave(),unbien.getGrenier()};
				//int rowIndex = tablebien.getSelectedRow();
				//this.untableau.update(rowIndex,data);
			}
			txtadresse.setText("");
			txtprix.setText("");
			txtsurface.setText("");
			txtville.setText("");
			txtpiece.setText("");
			txtchambre.setText("");
			txteau.setText("");
			txtstatut.setText("");
			txttype.setText("");
			txtetage.setText("");
			txtascenseur.setText("");
			txtbalcon.setText("");
			txtplace_parking.setText("");
			txtSurface_terrain.setText("");
			txtcave.setText("");
			txtgrenier.setText("");
		}else if(e.getSource() == this.btrecherche) {
			String motcle = txtrecherche.getText();
			Object data [][] = this.recupererrecherche(motcle);
			untableau.setData(data);
			
		}
	}
	// récuperer les données sous forme de matrice (tableau)
	private Object [][] recupererlesbiens(){
		ArrayList<Bien> lesbiens = modele.SelectAllBien();
		Object [][] donnees = new Object[lesbiens.size()][Bien.getNbchampsbiens()];
		int i = 0;
		for(Bien unbien : lesbiens) {
			if (unbien.getType().equals("appartement")) {
				ArrayList<Bien> lesappart = modele.SelectJoinAppart(unbien.getIdBien());
				for(Bien l_appart : lesappart) {
					donnees[i][0] = l_appart.getIdBien()+"";
					donnees[i][1] = l_appart.getAdresse();
					donnees[i][2] = l_appart.getPrix();
					donnees[i][3] = l_appart.getSurface();
					donnees[i][4] = l_appart.getVille();
					donnees[i][5] = l_appart.getPiece2();
					donnees[i][6] = l_appart.getChambre2();
					donnees[i][7] = l_appart.getEau2();
					donnees[i][8] = l_appart.getStatut();
					donnees[i][9] = l_appart.getType();
					donnees[i][10] = l_appart.getEtage();
					donnees[i][11] = l_appart.getAscenseur();
					donnees[i][12] = l_appart.getBalcon();
					donnees[i][13] = l_appart.getParking();
					i++;
				}
			}else if (unbien.getType().equals("maison")) {
				ArrayList<Bien> lesMaisons = modele.SelectJoinMaison(unbien.getIdBien());
				for(Bien laMaison : lesMaisons) {
					donnees[i][0] = laMaison.getIdBien()+"";
					donnees[i][1] = laMaison.getAdresse();
					donnees[i][2] = laMaison.getPrix();
					donnees[i][3] = laMaison.getSurface();
					donnees[i][4] = laMaison.getVille();
					donnees[i][5] = laMaison.getPiece2();
					donnees[i][6] = laMaison.getChambre2();
					donnees[i][7] = laMaison.getEau2();
					donnees[i][8] = laMaison.getStatut();
					donnees[i][9] = laMaison.getType();
					donnees[i][10] = "";
					donnees[i][11] = "";
					donnees[i][12] = "";
					donnees[i][13] = "";
					donnees[i][14] = laMaison.getCave();
					donnees[i][15] = laMaison.getGrenier();
					donnees[i][16] = laMaison.getSurface_terrain();
					i++;
				}
			}

		}
		return donnees;
	}
	private Object [][] recupererrecherche(String motcle){
		ArrayList<Bien> lesbiens = modele.recherchebien(motcle);
		Object [][] donnees = new Object[lesbiens.size()][Bien.getNbchampsbiens()];
		int i = 0;
		for(Bien unbien : lesbiens) {
			donnees[i][0] = unbien.getIdBien()+"";
			donnees[i][1] = unbien.getAdresse();
			donnees[i][2] = unbien.getPrix2();
			donnees[i][3] = unbien.getSurface2();
			donnees[i][4] = unbien.getVille();
			donnees[i][5] = unbien.getPiece2();
			donnees[i][6] = unbien.getChambre2();
			donnees[i][7] = unbien.getEau2();
			donnees[i][8] = unbien.getStatut();
			i++;
		}
		return donnees;
	}
}
