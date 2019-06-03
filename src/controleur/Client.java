package controleur;

public class Client {
	private static int nbchampsclients = 14;
	private int idclient,nb_visite,departement,statut,telephone2;
	private String nom,prenom,email,telephone,password,sexe,date_naissance,droits,date_insc,date_embauche,perimetre_action;
	
	public Client() {
		this.idclient = this.departement = this.statut = this.telephone2 = 0;
		this.nom = this.prenom = this.email = this.telephone = this.password = this.sexe = this.date_naissance = this.droits = this.date_insc = this.perimetre_action = "";
	}

	public Client(int idclient, String nom, String prenom, String email, String telephone, String password, String sexe, String date_naissance, String droits, int statut) {
		// Constructeur de selectAllPersonne
		this.idclient = idclient;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.password = password;
		this.sexe = sexe;
		this.date_naissance = date_naissance;
		this.droits = droits;
		this.statut = statut;
	}
	public Client(int idclient, String nom, String prenom, String email, String telephone, String password, String sexe, String date_naissance, String droits, int statut,String date_insc, int departement) {
		// Constructeur de selectJoinClient
		this.idclient = idclient;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.password = password;
		this.sexe = sexe;
		this.date_naissance = date_naissance;
		this.droits = droits;
		this.statut = statut;
		this.date_insc = date_insc;
		this.departement = departement;
	}
	public Client(int idclient, String nom, String prenom, String email, String telephone, String password, String sexe, String date_naissance, String droits, int statut,String perimetre_action, String date_embauche) {
		// Constructeur de selectJoinCommerciale
		this.idclient = idclient;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.password = password;
		this.sexe = sexe;
		this.date_naissance = date_naissance;
		this.droits = droits;
		this.statut = statut;
		this.perimetre_action = perimetre_action;
		this.date_embauche = date_embauche;
	}
	public Client(String nom, String prenom, String email, String telephone, String password, String sexe, String date_naissance, String droits, int statut,String date_insc, int departement) {
		// Constructeur de insertClient
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.password = password;
		this.sexe = sexe;
		this.date_naissance = date_naissance;
		this.droits = droits;
		this.statut = statut;
		this.date_insc = date_insc;
		this.departement = departement;
	}
	public Client(String nom, String prenom, String email, String telephone, String password, String sexe, String date_naissance, String droits, int statut,String perimetre_action, String date_embauche) {
		// Constructeur de insertCommerciale
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.password = password;
		this.sexe = sexe;
		this.date_naissance = date_naissance;
		this.droits = droits;
		this.statut = statut;
		this.perimetre_action = perimetre_action;
		this.date_embauche = date_embauche;
	}
	public Client(int idclient, String nom, String prenom, String email, int telephone2, String password, String sexe, String date_naissance, String droits, int statut, int departement) {
		// Constructeur de updateClient
		this.idclient = idclient;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone2 = telephone2;
		this.password = password;
		this.sexe = sexe;
		this.date_naissance = date_naissance;
		this.droits = droits;
		this.statut = statut;
		this.departement = departement;
	}
	public Client(int idclient, String nom, String prenom, String email, String telephone, String password, String sexe, String date_naissance, String droits, int statut, String perimetre_action) {
		// Constructeur de updateCommerciale
		this.idclient = idclient;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.password = password;
		this.sexe = sexe;
		this.date_naissance = date_naissance;
		this.droits = droits;
		this.statut = statut;
		this.perimetre_action = perimetre_action;
	}
	public Client(int idclient, int statut) {
		// Constructeur de deletePersonne
		this.idclient = idclient;
		this.statut = statut;
	}
	public int getIdclient() {
		return idclient;
	}
	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public static int getNbchampsclients() {
		return nbchampsclients;
	}
	public static void setNbchampsclients(int nbchampsclients) {
		Client.nbchampsclients = nbchampsclients;
	}
	public String getDroits() {
		return droits;
	}
	public void setDroits(String droits) {
		this.droits = droits;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}
	public String getDate_insc() {
		return date_insc;
	}
	public void setDate_insc(String date_insc) {
		this.date_insc = date_insc;
	}
	public int getDepartement() {
		return departement;
	}
	public void setDepartement(int departement) {
		this.departement = departement;
	}
	public int getNb_visite() {
		return nb_visite;
	}
	public void setNb_visite(int nb_visite) {
		this.nb_visite = nb_visite;
	}
	public String getPerimetre_action() {
		return perimetre_action;
	}
	public void setPerimetre_action(String perimetre_action) {
		this.perimetre_action = perimetre_action;
	}
	public String getDate_embauche() {
		return date_embauche;
	}
	public void setDate_embauche(String date_embauche) {
		this.date_embauche = date_embauche;
	}

	public int getStatut() {
		return statut;
	}

	public void setStatut(int statut) {
		this.statut = statut;
	}

	public int getTelephone2() {
		return telephone2;
	}

	public void setTelephone2(int telephone2) {
		this.telephone2 = telephone2;
	}
	
	
}
