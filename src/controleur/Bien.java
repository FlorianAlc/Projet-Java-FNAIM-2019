package controleur;

public class Bien {
	private static int nbchampsbiens = 17;
	private int id_bien,etage,ascenseur,balcon,parking,Surface_terrain,cave,grenier,piece2,chambre2,eau2,surface2,prix2,nbvisite;
	private String adresse,prix,statut,ville,surface,piece,chambre,eau,type;
	
	public Bien() {
		this.id_bien = 0;
		this.adresse = "";
		this.prix = "";
		this.statut = "";
	}
	public Bien (String adresse, String prix,String surface,String ville, String piece,String chambre, String eau, String statut, String type, int nbvisite, int etage, int ascenseur, int balcon, int place_parking) {
		// Constructeur pour insertappart
		this.id_bien = 0;
		this.adresse = adresse;
		this.prix = prix;
		this.statut = statut;
		this.surface = surface;
		this.ville = ville;
		this.piece = piece;
		this.chambre = chambre;
		this.eau = eau;
		this.type = type;
		this.nbvisite = nbvisite;
		this.etage = etage;
		this.ascenseur = ascenseur;
		this.balcon = balcon;
		this.parking = place_parking;
	}
	public Bien (String adresse, String prix,String surface,String ville, int piece2,int chambre2, int eau2, String statut, String type, int nbvisite, int surface_terrain, int cave, int grenier) {
		// Constructeur pour insertmaison
		this.id_bien = 0;
		this.adresse = adresse;
		this.prix = prix;
		this.statut = statut;
		this.surface = surface;
		this.ville = ville;
		this.piece2 = piece2;
		this.chambre2 = chambre2;
		this.eau2 = eau2;
		this.type = type;
		this.nbvisite = nbvisite;
		this.Surface_terrain = surface_terrain;
		this.cave = cave;
		this.grenier = grenier;
	}
	public Bien (int id_bien, String adresse, String prix,String surface,String ville, int piece2,int chambre2, int eau2, String statut, String type, int nbvisite, int etage, int ascenseur, int balcon, int place_parking) {
		// Constructeur pour selectappart
		this.id_bien = id_bien;
		this.adresse = adresse;
		this.prix = prix;
		this.statut = statut;
		this.surface = surface;
		this.ville = ville;
		this.piece2 = piece2;
		this.chambre2 = chambre2;
		this.eau2= eau2;
		this.type = type;
		this.nbvisite = nbvisite;
		this.etage = etage;
		this.ascenseur = ascenseur;
		this.balcon = balcon;
		this.parking = place_parking;
	}
	public Bien (int id_bien,String adresse, String prix,String surface,String ville, int piece2,int chambre2, int eau2, String statut, String type, int nbvisite, int surface_terrain, int cave, int grenier) {
		// Constructeur pour selectmaison
		this.id_bien = id_bien;
		this.adresse = adresse;
		this.prix = prix;
		this.statut = statut;
		this.surface = surface;
		this.ville = ville;
		this.piece2 = piece2;
		this.chambre2 = chambre2;
		this.eau2 = eau2;
		this.type = type;
		this.nbvisite = nbvisite;
		this.Surface_terrain = surface_terrain;
		this.cave = cave;
		this.grenier = grenier;
	}
	public Bien (int id_bien, String adresse, int prix2,int surface2,String ville, int piece2,int chambre2, int eau2, String statut, String type, int etage, int ascenseur, int balcon, int place_parking) {
		// Constructeur pour updateappart
		this.id_bien = id_bien;
		this.adresse = adresse;
		this.prix2 = prix2;
		this.statut = statut;
		this.surface2 = surface2;
		this.ville = ville;
		this.piece2 = piece2;
		this.chambre2 = chambre2;
		this.eau2= eau2;
		this.type = type;
		this.etage = etage;
		this.ascenseur = ascenseur;
		this.balcon = balcon;
		this.parking = place_parking;
	}
	public Bien (int id_bien,String adresse, int prix2,int surface2,String ville, int piece2,int chambre2, int eau2, String statut, String type, int surface_terrain, int cave, int grenier) {
		// Constructeur pour updatemaison
		this.id_bien = id_bien;
		this.adresse = adresse;
		this.prix2 = prix2;
		this.statut = statut;
		this.surface2 = surface2;
		this.ville = ville;
		this.piece2 = piece2;
		this.chambre2 = chambre2;
		this.eau2 = eau2;
		this.type = type;
		this.Surface_terrain = surface_terrain;
		this.cave = cave;
		this.grenier = grenier;
	}
	
	public Bien (int id_bien, String type) {
		// Constructeur pour suppression
		this.id_bien = id_bien;
		this.type = type;
	}
	public Bien (int id_bien, String surface, String prix,String statut,String adresse, String ville,int piece2, int chambre2, int eau2, String type) {
		this.id_bien = id_bien;
		this.adresse = adresse;
		this.prix = prix;
		this.statut = statut;
		this.surface = surface;
		this.ville = ville;
		this.piece2 = piece2;
		this.chambre2 = chambre2;
		this.eau2 = eau2;
		this.type = type;
	}
	public Bien (int id_bien, int surface, int prix,String statut,String adresse, String ville,int piece2, int chambre2, int eau2) {
		this.id_bien = id_bien;
		this.adresse = adresse;
		this.prix2 = prix;
		this.statut = statut;
		this.surface2 = surface;
		this.ville = ville;
		this.piece2 = piece2;
		this.chambre2 = chambre2;
		this.eau2 = eau2;
	}
	public int getIdBien() {
		return id_bien;
	}
	public void setIdBien(int id_bien) {
		this.id_bien = id_bien;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getPrix() {
		return prix;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getSurface() {
		return surface;
	}
	public void setSurface(String surface) {
		this.surface = surface;
	}
	public String getPiece() {
		return piece;
	}
	public void setPiece(String piece) {
		this.piece = piece;
	}
	public String getChambre() {
		return chambre;
	}
	public void setChambre(String chambre) {
		this.chambre = chambre;
	}
	public String getEau() {
		return eau;
	}
	public void setEau(String eau) {
		this.eau = eau;
	}
	public int getEtage() {
		return etage;
	}
	public void setEtage(int etage) {
		this.etage = etage;
	}
	public int getAscenseur() {
		return ascenseur;
	}
	public void setAscenseur(int ascenseur) {
		this.ascenseur = ascenseur;
	}
	public int getBalcon() {
		return balcon;
	}
	public void setBalcon(int balcon) {
		this.balcon = balcon;
	}
	public int getParking() {
		return parking;
	}
	public void setParking(int parking) {
		this.parking = parking;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public int getSurface_terrain() {
		return Surface_terrain;
	}
	public void setSurface_terrain(int surface_terrain) {
		Surface_terrain = surface_terrain;
	}
	public int getCave() {
		return cave;
	}
	public void setCave(int cave) {
		this.cave = cave;
	}
	public int getGrenier() {
		return grenier;
	}
	public void setGrenier(int grenier) {
		this.grenier = grenier;
	}
	public static int getNbchampsbiens() {
		return nbchampsbiens;
	}
	public static void setNbchampsbiens(int nbchampsbiens) {
		Bien.nbchampsbiens = nbchampsbiens;
	}
	public int getPiece2() {
		return piece2;
	}
	public void setPiece2(int piece2) {
		this.piece2 = piece2;
	}
	public int getChambre2() {
		return chambre2;
	}
	public void setChambre2(int chambre2) {
		this.chambre2 = chambre2;
	}
	public int getEau2() {
		return eau2;
	}
	public void setEau2(int eau2) {
		this.eau2 = eau2;
	}
	public int getSurface2() {
		return surface2;
	}
	public void setSurface2(int surface2) {
		this.surface2 = surface2;
	}
	public int getPrix2() {
		return prix2;
	}
	public void setPrix2(int prix2) {
		this.prix2 = prix2;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
