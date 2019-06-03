package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import controleur.main;

public class vuegenerale extends JFrame implements ActionListener{
	
	private JPanel panelMenu = new JPanel();
	// création d'un tableau de bouton pour automatiser
	private JButton tabButton[] = new JButton[4];
	private final String tabNoms[] = {"Utilisateur","Bien","Visites","Quitter"};;
	
	//creation des 3 panels
	private static vueclients unevueclient = new vueclients();
	private static vuevisite unevuevisite = new vuevisite();
	private static vuebien unevuebien = new vuebien();
	
	public vuegenerale(String droits) {
		this.setTitle("Gestion des biens et des utilisateurs");
		this.setLayout(null);
		this.setResizable(false);
		this.setBounds(50,100,1700,800);
		this.getContentPane().setBackground(new Color(239,216,7));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// ajout de l'icone
		ImageIcon logoPetit = new ImageIcon ("src/image/logoSite.png");
		this.setIconImage(logoPetit.getImage());
		
		this.panelMenu.setBounds(0, 20, 1400, 30);
		this.panelMenu.setLayout(new GridLayout(1,4));
		// construction des boutons dans le panel
		for (int i=0;i<4;i++) {
			this.tabButton[i] = new JButton(tabNoms[i]);
			this.panelMenu.add(this.tabButton[i]);
			//rendre les boutons cliquable
			this.tabButton[i].addActionListener(this);
		}
		
		this.panelMenu.setVisible(true);
		this.add(this.panelMenu);
		
		//ajout des 3 panels
		this.add(unevueclient);
		this.add(unevuevisite);
		this.add(unevuebien);
		
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.tabButton[3]) {
			this.dispose();
			main.rendreVisible(true);
		}else if(e.getSource() == this.tabButton[0]) {
			unevueclient.setVisible(true);
			unevuevisite.setVisible(false);
			unevuebien.setVisible(false);
		}else if(e.getSource() == this.tabButton[1]) {
			unevueclient.setVisible(false);
			unevuevisite.setVisible(false);
			unevuebien.setVisible(true);
		}else if(e.getSource() == this.tabButton[2]) {
			unevueclient.setVisible(false);
			unevuevisite.setVisible(true);
			unevuebien.setVisible(false);
		}
	}

}
