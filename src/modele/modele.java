package modele;

import java.io.UnsupportedEncodingException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Formatter;

import controleur.Client;
import controleur.Visite;
import controleur.Bien;

public class modele {
	private static String user_bdd = "root";
	private static String mdp_bdd = "";
	private static String encryptPassword(String password)
	{
	    String sha1 = "";
	    try
	    {
	        MessageDigest crypt = MessageDigest.getInstance("SHA-1");
	        crypt.reset();
	        crypt.update(password.getBytes("UTF-8"));
	        sha1 = byteToHex(crypt.digest());
	    }	
	    catch(NoSuchAlgorithmException e)
	    {
	        e.printStackTrace();
	    }
	    catch(UnsupportedEncodingException e)
	    {
	        e.printStackTrace();
	    }
	    return sha1;
	}

	private static String byteToHex(final byte[] hash)
	{
	    Formatter formatter = new Formatter();
	    for (byte b : hash)
	    {
	        formatter.format("%02x", b);
	    }
	    String result = formatter.toString();
	    formatter.close();
	    return result;
	}
	
	public static String verifConnection (String login, String mdp) {
		mdp = encryptPassword(mdp);
		String requete =  "Select count(*) as nb, droits from personne where email = '"+login+"'and password = '"+mdp+"';";
		String droits = "";
		Bdd uneBdd = new Bdd ("localhost","essaippe",modele.user_bdd,modele.mdp_bdd);
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnection().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if(unRes.next()) {
				int nb = unRes.getInt("nb");
				if(nb==0) droits ="";
				else droits = unRes.getString("droits");
			}
			unRes.close();
			unStat.close();
			uneBdd.seDeconnecter();
		}catch(SQLException exp) {
			System.out.println("Erreur : "+requete); //affiche la requete de l'erreur
			exp.printStackTrace(); // affiche l'erreur
		}
		return droits;
	}
	/*--------------------------- Modèle des personnes------------------------------ */
	
	public static ArrayList<Client> selectAllPersonne(){
		ArrayList<Client> lesclients = new ArrayList<Client>();
		String requete = "Select * from personne;";
		Bdd uneBdd = new Bdd ("localhost","essaippe",modele.user_bdd,modele.mdp_bdd);
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnection().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			while(unRes.next()) {
				lesclients.add(new Client(unRes.getInt("id_personne"),unRes.getString("nom"),unRes.getString("prenom"),unRes.getString("email"),unRes.getString("telephone"),unRes.getString("password"),unRes.getString("sexe"),unRes.getString("date_naissance"),unRes.getString("droits"),unRes.getInt("statut")));
			}
			unStat.close();
			unRes.close();
			uneBdd.seDeconnecter();
		}catch(SQLException exp) {
			exp.printStackTrace();
			System.out.println("Erreur de selection dans la base de données : "+requete);
		}
		return lesclients;
	}
	
	public static ArrayList<Client> SelectJoinClient(int l_id_client){
		ArrayList <Client> lesclients = new ArrayList<Client>();
		String requeteClient ="Select * from personne p INNER JOIN client c ON p.id_personne ="+l_id_client+" and c.id_personne="+l_id_client+";";
		Bdd uneBdd = new Bdd ("localhost","essaippe",modele.user_bdd,modele.mdp_bdd);
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnection().createStatement();;
			ResultSet unRes = unStat.executeQuery(requeteClient);
			while(unRes.next()) {
				int id_personne = unRes.getInt("id_personne");
				String nom = unRes.getString("nom");
				String prenom = unRes.getString("prenom");
				String email = unRes.getString("email");
				String telephone = unRes.getString("telephone");
				String password = unRes.getString("password");
				String sexe = unRes.getString("sexe");
				String date_naissance = unRes.getString("date_naissance");
				String droits = unRes.getString("droits");
				int statut = unRes.getInt("statut");
				String date_inscription= unRes.getString("date_inscription");
				int departement = unRes.getInt("departement");
				Client unclient = new Client(id_personne,nom,prenom,email,telephone,password,sexe,date_naissance,droits,statut,date_inscription,departement);
				lesclients.add(unclient);

			}
			unStat.close();
			unRes.close();
			uneBdd.seDeconnecter();
		}catch(SQLException exp) {
			System.out.println("Erreur de requete : "+requeteClient);
		}
		
		return lesclients;
	}
	public static ArrayList<Client> SelectJoinCommerciale(int l_id_client){
		ArrayList <Client> lescommerciales = new ArrayList<Client>();
		String requeteClient ="Select * from personne p INNER JOIN commercial c ON p.id_personne ="+l_id_client+" and c.id_personne="+l_id_client+";";
		Bdd uneBdd = new Bdd ("localhost","essaippe",modele.user_bdd,modele.mdp_bdd);
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnection().createStatement();;
			ResultSet unRes = unStat.executeQuery(requeteClient);
			while(unRes.next()) {
				int id_personne = unRes.getInt("id_personne");
				String nom = unRes.getString("nom");
				String prenom = unRes.getString("prenom");
				String email = unRes.getString("email");
				String telephone = unRes.getString("telephone");
				String password = unRes.getString("password");
				String sexe = unRes.getString("sexe");
				String date_naissance = unRes.getString("date_naissance");
				String droits = unRes.getString("droits");
				int statut = unRes.getInt("statut");
				String perimetre_action= unRes.getString("perimetre_action");
				String date_embauche = unRes.getString("date_embauche");
				Client unclient = new Client(id_personne,nom,prenom,email,telephone,password,sexe,date_naissance,droits,statut,perimetre_action,date_embauche);
				lescommerciales.add(unclient);

			}
			unStat.close();
			unRes.close();
			uneBdd.seDeconnecter();
		}catch(SQLException exp) {
			System.out.println("Erreur de requete : "+requeteClient);
		}
		
		return lescommerciales;
	}
	public static void insertClient(Client unclient) {
		if (unclient.getStatut() == 1) {
			String requete = "{call insertclient (?,?,?,?,?,?,?,?,?,?,?)};";
			Bdd uneBdd = new Bdd ("localhost","essaippe",modele.user_bdd,modele.mdp_bdd);
			try {
				uneBdd.seConnecter();
				CallableStatement unStat =  uneBdd.getMaConnection().prepareCall(requete);
			    unStat.setString(1,unclient.getNom());
			    unStat.setString(2,unclient.getPrenom());
			    unStat.setString(3,unclient.getEmail());
			    unStat.setString(4,unclient.getTelephone());
			    unStat.setString(5,unclient.getPassword());
			    unStat.setString(6,unclient.getSexe());
			    unStat.setString(7,unclient.getDate_naissance());
			    unStat.setString(8,unclient.getDroits());
			    unStat.setString(9,unclient.getDate_insc());
			    unStat.setInt(10,unclient.getDepartement());
			    unStat.setInt(11,unclient.getStatut());
				unStat.executeUpdate();
				unStat.close();
				uneBdd.seDeconnecter();
			}catch(SQLException exp) {
				System.out.println("Erreur dans l'éxecution de la requete : "+ requete);
				exp.printStackTrace();
			}
		}else if (unclient.getStatut() == 2) {
			String requete = "{call insertcommercial (?,?,?,?,?,?,?,?,?,?,?,?)};";
			Bdd uneBdd = new Bdd ("localhost","essaippe",modele.user_bdd,modele.mdp_bdd);
			try {
				uneBdd.seConnecter();
				CallableStatement unStat =  uneBdd.getMaConnection().prepareCall(requete);
			    unStat.setString(1,unclient.getNom());
			    unStat.setString(2,unclient.getPrenom());
			    unStat.setString(3,unclient.getEmail());
			    unStat.setString(4,unclient.getTelephone());
			    unStat.setString(5,unclient.getPassword());
			    unStat.setString(6,unclient.getSexe());
			    unStat.setString(7,unclient.getDate_naissance());
			    unStat.setString(8,unclient.getDroits());
			    unStat.setString(9,unclient.getPerimetre_action());
			    unStat.setString(10,unclient.getDate_embauche());
			    unStat.setInt(11, 0);
			    unStat.setInt(12, unclient.getStatut());
				unStat.executeUpdate();
				unStat.close();
				uneBdd.seDeconnecter();
			}catch(SQLException exp) {
				System.out.println("Erreur dans l'éxecution de la requete : "+ requete);
			}
		}
	}	
	public static void deleteclient(Client unclient) {
		if (unclient.getStatut() == 1) {
			String requete = "{call deleteclient (?)};";
			Bdd uneBdd = new Bdd ("localhost","essaippe",modele.user_bdd,modele.mdp_bdd);
			try {
				uneBdd.seConnecter();
				CallableStatement unStat =  uneBdd.getMaConnection().prepareCall(requete);
				unStat.setInt(1, unclient.getIdclient());
				unStat.executeUpdate();
				unStat.close();
				uneBdd.seDeconnecter();
			}catch(SQLException exp) {
				System.out.println("Erreur dans l'éxecution de la requete : "+ requete);
			}
		}else if (unclient.getStatut() == 2) {
			String requete = "{call deletecommercial (?)";
			Bdd uneBdd = new Bdd ("localhost","essaippe",modele.user_bdd,modele.mdp_bdd);
			try {
				uneBdd.seConnecter();
				CallableStatement unStat =  uneBdd.getMaConnection().prepareCall(requete);
				unStat.setInt(1, unclient.getIdclient());
				unStat.executeUpdate();
				unStat.close();
				uneBdd.seDeconnecter();
			}catch(SQLException exp) {
				System.out.println("Erreur dans l'éxecution de la requete : "+ requete);
			}
		}
	}
	public static void updatePersonne(Client unclient) {
		if (unclient.getStatut() == 1) {
			String requete = "{call updateclient (?,?,?,?,?,?,?,?,?,?)};";
			Bdd uneBdd = new Bdd ("localhost","essaippe",modele.user_bdd,modele.mdp_bdd);
			try {
				uneBdd.seConnecter();
				CallableStatement unStat = uneBdd.getMaConnection().prepareCall(requete);
				unStat.setInt(1, unclient.getIdclient());
				unStat.setString(2, unclient.getNom());
				unStat.setString(3, unclient.getPrenom());
				unStat.setString(4, unclient.getEmail());
				unStat.setInt(5, unclient.getTelephone2());
				unStat.setString(6, unclient.getPassword());
				unStat.setString(7, unclient.getSexe());
				unStat.setString(8,unclient.getDate_naissance());
				unStat.setString(9, unclient.getDroits());
				unStat.setInt(10, unclient.getDepartement());
				unStat.executeUpdate();
				unStat.close();
				uneBdd.seDeconnecter();
			}catch(SQLException exp) {
				System.out.println("Erreur dans l'éxecution de la requete : "+ requete);
			}
		}else if(unclient.getStatut() == 2){
			String requete = "{call updatecommercial (?,?,?,?,?,?,?,?,?,?)};";
			Bdd uneBdd = new Bdd ("localhost","essaippe",modele.user_bdd,modele.mdp_bdd);
			try {
				uneBdd.seConnecter();
				CallableStatement unStat = uneBdd.getMaConnection().prepareCall(requete);
				unStat.setInt(1, unclient.getIdclient());
				unStat.setString(2, unclient.getNom());
				unStat.setString(3, unclient.getPrenom());
				unStat.setString(4, unclient.getEmail());
				unStat.setString(5, unclient.getTelephone());
				unStat.setString(6, unclient.getPassword());
				unStat.setString(7, unclient.getSexe());
				unStat.setString(8, unclient.getDate_naissance());
				unStat.setString(9, unclient.getDroits());
				unStat.setString(10, unclient.getPerimetre_action());
				unStat.executeUpdate();
				unStat.close();
				uneBdd.seDeconnecter();
			}catch(SQLException exp) {
				System.out.println("Erreur dans l'éxecution de la requete : "+ requete);
			}
		}
	}
	
	/* ------------------------------------------------ Modèle des biens ------------------------------------------------ */
	
	public static ArrayList<Bien> SelectAllBien(){
		ArrayList <Bien> lesbiens = new ArrayList<Bien>();
		String requete ="Select * from bien;";
		Bdd uneBdd = new Bdd ("localhost","essaippe",modele.user_bdd,modele.mdp_bdd);
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnection().createStatement();;
			ResultSet unRes = unStat.executeQuery(requete);
			while(unRes.next()) {
				int id_bien = unRes.getInt("id_bien");
				String adresse = unRes.getString("adresse");
				String prix = unRes.getString("prix");
				String statut = unRes.getString("statut");
				String surface = unRes.getString("surface");
				String ville = unRes.getString("ville");
				int piece = unRes.getInt("piece");
				int chambre = unRes.getInt("chambre");
				int eau = unRes.getInt("eaux");
				String type = unRes.getString("type");
				Bien unbien = new Bien(id_bien,surface,prix,statut,adresse,ville,piece,chambre,eau,type);
				lesbiens.add(unbien);

			}
			unStat.close();
			unRes.close();
			uneBdd.seDeconnecter();
			
		}catch(SQLException exp) {
			System.out.println("Erreur de requete : "+requete);
		}
		return lesbiens;
	}
	
	public static ArrayList<Bien> SelectJoinAppart(int l_id_bien){
		ArrayList <Bien> lesappart = new ArrayList<Bien>();
		String requeteAppart ="Select * from bien b INNER JOIN appartement a ON b.id_bien ="+l_id_bien+" and a.id_bien="+l_id_bien+";";
		Bdd uneBdd = new Bdd ("localhost","essaippe",modele.user_bdd,modele.mdp_bdd);
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnection().createStatement();;
			ResultSet unRes = unStat.executeQuery(requeteAppart);
			while(unRes.next()) {
				int id_bien = unRes.getInt("id_bien");
				String adresse = unRes.getString("adresse");
				String prix = unRes.getString("prix");
				String statut = unRes.getString("statut");
				String surface = unRes.getString("surface");
				String ville = unRes.getString("ville");
				String type = unRes.getString("type");
				int piece = unRes.getInt("piece");
				int chambre = unRes.getInt("chambre");
				int eau = unRes.getInt("eaux");
				int nbvisite= unRes.getInt("nbvisites");
				int etage= unRes.getInt("etage");
				int ascenseur= unRes.getInt("ascenseur");
				int balcon= unRes.getInt("balcon");
				int place_parking= unRes.getInt("place_parking");
				Bien unbien = new Bien(id_bien,adresse,prix,surface,ville,piece,chambre,eau,statut,type,nbvisite,etage,ascenseur,balcon,place_parking);
				lesappart.add(unbien);

			}
			unStat.close();
			unRes.close();
			uneBdd.seDeconnecter();
		}catch(SQLException exp) {
			System.out.println("Erreur de requete : "+requeteAppart);
		}
		
		return lesappart;
	}
	public static ArrayList<Bien> SelectJoinMaison(int l_id_bien){
		ArrayList <Bien> lesmaisons = new ArrayList<Bien>();
		String requeteMaison ="Select * from bien b INNER JOIN maison m ON b.id_bien ="+l_id_bien+" and m.id_bien="+l_id_bien+";";
		Bdd uneBdd = new Bdd ("localhost","essaippe",modele.user_bdd,modele.mdp_bdd);
		try {
			uneBdd.seConnecter();
			Statement unStatMaison = uneBdd.getMaConnection().createStatement();;
			ResultSet unResMaison = unStatMaison.executeQuery(requeteMaison);
			while(unResMaison.next()) {
				
				int id_bien = unResMaison.getInt("id_bien");
				String adresse = unResMaison.getString("adresse");
				String prix = unResMaison.getString("prix");
				String statut = unResMaison.getString("statut");
				String surface = unResMaison.getString("surface");
				String ville = unResMaison.getString("ville");
				String type = unResMaison.getString("type");
				int piece = unResMaison.getInt("piece");
				int chambre = unResMaison.getInt("chambre");
				int eau = unResMaison.getInt("eaux");
				int nbvisite= unResMaison.getInt("nbvisites");
				int surface_terrain = unResMaison.getInt("surface_terrain");
				int cave= unResMaison.getInt("cave");
				int grenier= unResMaison.getInt("grenier");
				Bien unbien = new Bien(id_bien,adresse,prix,surface,ville,piece,chambre,eau,statut,type,nbvisite,surface_terrain,cave,grenier);
				lesmaisons.add(unbien);
				
			}
			unStatMaison.close();
			unResMaison.close();
			uneBdd.seDeconnecter();
		}catch(SQLException exp) {
			System.out.println("Erreur de requete : "+requeteMaison);
		}
		return lesmaisons;
	}

	public static void insertbien(Bien unbien) {
		if (unbien.getType().equals("appartement")) {
			System.out.println("OUI");
			String requete = "{call insertappart (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)};";
			Bdd uneBdd = new Bdd ("localhost","essaippe",modele.user_bdd,modele.mdp_bdd);
			try {
				uneBdd.seConnecter();
				CallableStatement unStat = uneBdd.getMaConnection().prepareCall(requete);
				int surface = Integer.parseInt(unbien.getSurface());
				int prix = Integer.parseInt(unbien.getPrix());
				int piece = Integer.parseInt(unbien.getPiece());
				int chambre = Integer.parseInt(unbien.getChambre());
				int eau = Integer.parseInt(unbien.getEau());
				unStat.setInt(1, surface);
				unStat.setInt(2, prix);
				unStat.setString(3, unbien.getStatut());
				unStat.setString(4, unbien.getAdresse());
				unStat.setString(5, unbien.getVille());
				unStat.setInt(6, 1);
				unStat.setInt(7, piece);
				unStat.setInt(8, chambre);
				unStat.setInt(9, eau);
				unStat.setInt(10, 0);
				unStat.setInt(11, unbien.getEtage());
				unStat.setInt(12, unbien.getAscenseur());
				unStat.setInt(13, unbien.getBalcon());
				unStat.setInt(14, unbien.getParking());
				unStat.setString(15, unbien.getType());
				unStat.executeUpdate();
				unStat.close();
				uneBdd.seDeconnecter();
			}catch(SQLException exp) {
				System.out.println("Erreur dans l'éxecution de la requete : "+ requete);
			}
		}else if(unbien.getType().equals("maison")) {
			String requete = "{call insertmaison (?,?,?,?,?,?,?,?,?,?,?,?,?,?)};";
			Bdd uneBdd = new Bdd ("localhost","essaippe",modele.user_bdd,modele.mdp_bdd);
			try {
				uneBdd.seConnecter();
				CallableStatement unStat = uneBdd.getMaConnection().prepareCall(requete);
				int surface = Integer.parseInt(unbien.getSurface());
				int prix = Integer.parseInt(unbien.getPrix());
				unStat.setInt(1, surface);
				unStat.setInt(2, prix);
				unStat.setString(3, unbien.getStatut());
				unStat.setString(4, unbien.getAdresse());
				unStat.setString(5, unbien.getVille());
				unStat.setInt(6, 1);
				unStat.setInt(7, unbien.getPiece2());
				unStat.setInt(8, unbien.getChambre2());
				unStat.setInt(9, unbien.getEau2());
				unStat.setInt(10, 0);
				unStat.setInt(11, unbien.getSurface_terrain());
				unStat.setInt(12, unbien.getCave());
				unStat.setInt(13, unbien.getGrenier());
				unStat.setString(14, unbien.getType());
				unStat.executeUpdate();
				unStat.close();
				uneBdd.seDeconnecter();
			}catch(SQLException exp) {
				System.out.println("Erreur dans l'éxecution de la requete : "+ requete);
			}
		}
	}
	public static void deletebien(Bien unbien) {
		if (unbien.getType().equals("appartement")) {
			System.out.println(unbien.getType());
			String requete = "{call deleteappart(?)};";
			Bdd uneBdd = new Bdd ("localhost","essaippe",modele.user_bdd,modele.mdp_bdd);
			try {
				uneBdd.seConnecter();
				CallableStatement unStat = uneBdd.getMaConnection().prepareCall(requete);
				unStat.setInt(1, unbien.getIdBien());
				unStat.executeUpdate();
				unStat.close();
				uneBdd.seDeconnecter();
			}catch(SQLException exp) {
				System.out.println("Erreur dans l'éxecution de la requete : "+ requete);
			}
		}else if(unbien.getType().equals("maison")) {
			String requete = "{call deletemaison(?)};";
			Bdd uneBdd = new Bdd ("localhost","essaippe",modele.user_bdd,modele.mdp_bdd);
			try {
				uneBdd.seConnecter();
				CallableStatement unStat = uneBdd.getMaConnection().prepareCall(requete);
				unStat.setInt(1, unbien.getIdBien());
				unStat.executeUpdate();
				unStat.close();
				uneBdd.seDeconnecter();
			}catch(SQLException exp) {
				System.out.println("Erreur dans l'éxecution de la requete : "+ requete);
			}
		}
	}
	public static void updatebien(Bien unbien) {
		if (unbien.getType().equals("appartement")) {
			String requete = "{call updateappart (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)};";
			Bdd uneBdd = new Bdd ("localhost","essaippe",modele.user_bdd,modele.mdp_bdd);
			try {
				uneBdd.seConnecter();
				CallableStatement unStat = uneBdd.getMaConnection().prepareCall(requete);
				unStat.setInt(1, unbien.getIdBien());
				unStat.setInt(2, unbien.getSurface2());
				unStat.setInt(3, unbien.getPrix2());
				unStat.setString(4, unbien.getStatut());
				unStat.setString(5, unbien.getAdresse());
				unStat.setString(6, unbien.getVille());
				unStat.setInt(7,1);
				unStat.setInt(8, unbien.getPiece2());
				unStat.setInt(9, unbien.getChambre2());
				unStat.setInt(10, unbien.getEau2());
				unStat.setInt(11, unbien.getAscenseur());
				unStat.setInt(12, unbien.getBalcon());
				unStat.setInt(13, unbien.getParking());
				unStat.setString(14,unbien.getType());
				unStat.setInt(15, unbien.getEtage());
				unStat.executeUpdate();
				unStat.close();
				uneBdd.seDeconnecter();
			}catch(SQLException exp) {
				System.out.println("Erreur dans l'éxecution de la requete : "+ requete);
			}
		}else if(unbien.getType().equals("maison")){
			String requete = "{call updatemaison (?,?,?,?,?,?,?,?,?,?,?,?,?,?)};";
			Bdd uneBdd = new Bdd ("localhost","essaippe",modele.user_bdd,modele.mdp_bdd);
			try {
				uneBdd.seConnecter();
				CallableStatement unStat = uneBdd.getMaConnection().prepareCall(requete);
				unStat.setInt(1, unbien.getIdBien());
				unStat.setInt(2, unbien.getSurface2());
				unStat.setInt(3, unbien.getPrix2());
				unStat.setString(4, unbien.getStatut());
				unStat.setString(5, unbien.getAdresse());
				unStat.setString(6, unbien.getVille());
				unStat.setInt(7,1);
				unStat.setInt(8, unbien.getPiece2());
				unStat.setInt(9, unbien.getChambre2());
				unStat.setInt(10, unbien.getEau2());
				unStat.setInt(11, unbien.getSurface_terrain());
				unStat.setInt(12, unbien.getCave());
				unStat.setInt(13, unbien.getGrenier());
				unStat.setString(14,unbien.getType());
				unStat.executeUpdate();
				unStat.close();
				uneBdd.seDeconnecter();
			}catch(SQLException exp) {
				System.out.println("Erreur dans l'éxecution de la requete : "+ requete);
			}
		}
	}
	
	
	
	
	/* ------------------------------------------------ Modèle des visites ------------------------------------------------ */

	public static ArrayList<Visite> SelectAllVisite(){
		ArrayList <Visite> lesvisites = new ArrayList<Visite>();
		String requete ="Select * from visite ;";
		Bdd uneBdd = new Bdd ("localhost","essaippe",modele.user_bdd,modele.mdp_bdd);
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnection().createStatement();;
			ResultSet unRes = unStat.executeQuery(requete);
			while(unRes.next()) {
				int id_bien = unRes.getInt("id_bien");
				int id_personne = unRes.getInt("id_personne");
				int id_visite = unRes.getInt("id_visite");
				String etat = unRes.getString("etat");
				String heure = unRes.getString("heure");
				String date = unRes.getString("date_visite");
				Visite unevisite = new Visite(id_visite,id_personne,id_bien,etat,date,heure);
				lesvisites.add(unevisite);

			}
			unStat.close();
			unRes.close();
			uneBdd.seDeconnecter();
			
		}catch(SQLException exp) {
			System.out.println("Erreur de requete : "+requete);
		}
		return lesvisites;
	}
	
	public static Visite SelectWhereVisite(Visite unevisite) {
		String requete = "Select * from bien where id_bien = "+ unevisite.getId_visite()+" and id_personne = "+ unevisite.getId_personne() + " and id_visite = "+unevisite.getId_visite()+";";
		Visite unevisiteresultat = null;
		Bdd uneBdd = new Bdd ("localhost","essaippe",modele.user_bdd,modele.mdp_bdd);
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnection().createStatement();;
			ResultSet unRes = unStat.executeQuery(requete);
			if(unRes.next()) {
				int id_bien = unRes.getInt("id_bien");
				int id_personne = unRes.getInt("id_personne");
				int id_visite = unRes.getInt("id_visite");
				String etat = unRes.getString("etat");
				String heure = unRes.getString("heure");
				String date = unRes.getString("date");
				unevisiteresultat = new Visite(id_bien,id_visite,id_personne,etat,heure,date);

			}
			unStat.close();
			unRes.close();
			uneBdd.seDeconnecter();
			
		}catch(SQLException exp) {
			System.out.println("Erreur de requete : "+requete);
		}
		return unevisiteresultat;
	}
	
	public static void insertVisite(Visite unevisite) {
		String requete = "insert into visite (date_visite,heure,etat,id_bien,id_personne) values ('"+unevisite.getDate()+"','"+unevisite.getHeure()+"','"+unevisite.getEtat()+"',"+unevisite.getId_bien()+","+unevisite.getId_personne() + ");";
		Bdd uneBdd = new Bdd ("localhost","essaippe",modele.user_bdd,modele.mdp_bdd);
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnection().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}catch(SQLException exp) {
			System.out.println("Erreur dans l'éxecution de la requete : "+ requete);
		}
	}
	public static void deletevisite(int idvisite) {
		String requete = "delete from visite where id_visite = "+idvisite+";";
		Bdd uneBdd = new Bdd ("localhost","essaippe",modele.user_bdd,modele.mdp_bdd);
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnection().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}catch(SQLException exp) {
			System.out.println("Erreur dans l'éxecution de la requete : "+ requete);
		}
	}
	
	public static void updatevisite(Visite unevisite) {
		String requete = "update visite set date_visite ='"+unevisite.getDate()+"',heure ='"+unevisite.getHeure()+"',etat = '"+unevisite.getEtat()+"',id_bien = "+unevisite.getId_bien()+", id_personne = "+unevisite.getId_personne()+" where id_visite = "+unevisite.getId_visite()+";";
		Bdd uneBdd = new Bdd ("localhost","essaippe",modele.user_bdd,modele.mdp_bdd);
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnection().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}catch(SQLException exp) {
			System.out.println("Erreur dans l'éxecution de la requete : "+ requete);
		}
	}
	
	public static ArrayList<Bien> recherchebien(String motcle) {
		String requete = "select * from bien where ville like '%"+motcle+"%' or statut like '%"+motcle+"%' or adresse like '%"+motcle+"%';";
		ArrayList <Bien> lesbiens = new ArrayList<Bien>();
		Bdd uneBdd = new Bdd ("localhost","essaippe",modele.user_bdd,modele.mdp_bdd);
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnection().createStatement();;
			ResultSet unRes = unStat.executeQuery(requete);
			if(unRes.next()) {
				int id_bien = unRes.getInt("id_bien");
				int surface = unRes.getInt("surface");
				int prix = unRes.getInt("prix");
				String statut = unRes.getString("statut");
				String adresse = unRes.getString("adresse");
				String ville = unRes.getString("ville");
				int piece = unRes.getInt("piece");
				int chambre = unRes.getInt("chambre");
				int eau = unRes.getInt("eaux");
				Bien unbien = new Bien(id_bien,surface,prix,statut,adresse,ville,piece,chambre,eau);
				lesbiens.add(unbien);
			}
			unStat.close();
			unRes.close();
			uneBdd.seDeconnecter();
		}catch(SQLException exp) {
			System.out.println("Erreur dans l'éxecution de la requete : "+requete);
		}
		return lesbiens;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
