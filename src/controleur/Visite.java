package controleur;

public class Visite {
	private static int nbchampsvisites = 6;
	private int id_visite,id_bien,id_personne;
	private String etat, heure, date;
	
	public Visite() {
		this.id_bien = 0;
		this.id_visite = 0;
		this.id_personne = 0;
		this.etat = "";
		this.heure = "";
		this.date = "";
	}
	public Visite (int id_personne,int id_bien, String etat, String date, String heure) {
		this.id_visite = 0;
		this.id_personne = id_personne;
		this.id_bien = id_bien;
		this.etat = etat;
		this.heure = heure;
		this.date = date;
	}
	public Visite (int id_visite, int id_personne, int id_bien, String etat, String date, String heure) {
		this.id_visite = id_visite;
		this.id_personne = id_personne;
		this.id_bien = id_bien;
		this.etat = etat;
		this.heure = heure;
		this.date = date;
	}
	public int getId_visite() {
		return id_visite;
	}
	public void setId_visite(int id_visite) {
		this.id_visite = id_visite;
	}
	public int getId_bien() {
		return id_bien;
	}
	public void setId_bien(int id_bien) {
		this.id_bien = id_bien;
	}
	public int getId_personne() {
		return id_personne;
	}
	public void setId_personne(int id_personne) {
		this.id_personne = id_personne;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getHeure() {
		return heure;
	}
	public void setHeure(String heure) {
		this.heure = heure;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public static int getNbchampsvisites() {
		return nbchampsvisites;
	}
	public static void setNbchampsvisites(int nbchampsvisites) {
		Visite.nbchampsvisites = nbchampsvisites;
	}
	
}
