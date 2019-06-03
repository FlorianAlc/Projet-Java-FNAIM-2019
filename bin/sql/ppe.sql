drop database if exists essaippe;
create database essaippe;
use essaippe;
-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Lun 23 Avril 2018 à 10:20
-- Version du serveur :  10.1.19-MariaDB
-- Version de PHP :  7.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `essaippe`
--

DELIMITER $$
--
-- Procédures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteappart` (IN `daid_bien` INT(11))  begin 
  delete from appartement where id_bien = daid_bien;
  delete from bien where id_bien = daid_bien;

end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteclient` (IN `dcid_personne` INT(11))  begin 
  delete from client where id_personne = dcid_personne;
  delete from personne where id_personne = dcid_personne;

end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deletecommercial` (IN `dcid_personne` INT(11))  begin 
  delete from commercial where id_personne = dcid_personne;
  delete from personne where id_personne = dcid_personne;

end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deletemaison` (IN `dmid_bien` INT(11))  begin 
  delete from maison where id_bien = dmid_bien;
  delete from bien where id_bien = dmid_bien;

end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertappart` (IN `psurface` INT(11), IN `pprix` INT(11), IN `pstatut` VARCHAR(25), IN `padresse` VARCHAR(100), IN `pville` VARCHAR(45), IN `pid_map` INT(11), IN `ppiece` INT(11), IN `pchambre` INT(11), IN `peaux` INT(11), IN `pnbvisites` INT(11), IN `petage` INT(11), IN `pascenseur` TINYINT(1), IN `pbalcon` TINYINT(1), IN `pplace_parking` TINYINT(1))  begin 
  declare pid_bien int (11) ;
  insert into bien VALUES (null,psurface,pprix,pstatut,padresse,pville,pid_map,ppiece,pchambre,peaux,pnbvisites);
 
  select id_bien into pid_bien from bien where surface = psurface and adresse = padresse and ville = pville and id_bien = (select max(id_bien) from bien) ;

  insert into appartement VALUES(petage,pascenseur,pbalcon,pplace_parking,pid_bien);

end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertclient` (IN `cnom` VARCHAR(25), IN `cprenom` VARCHAR(25), IN `cemail` VARCHAR(25), IN `ctelephone` TEXT, IN `cpassword` VARCHAR(80), IN `csexe` VARCHAR(25), IN `cdate_naissance` DATE, IN `cdroits` ENUM('admin','user','autre'), IN `cdate_inscription` DATE, IN `cdepartement` INT(11))  begin 
  declare cid_personne int (11) ;
  insert into personne VALUES (null,cnom,cprenom,cemail,ctelephone,cpassword,csexe,cdate_naissance,cdroits);
 
  select id_personne into cid_personne from personne where email = cemail and telephone = ctelephone and password = cpassword and id_personne = (select max(id_personne) from personne) ;

  insert into client VALUES(cdate_inscription,cdepartement,cid_personne);

end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertcommercial` (IN `conom` VARCHAR(25), IN `coprenom` VARCHAR(25), IN `coemail` VARCHAR(25), IN `cotelephone` TEXT, IN `copassword` VARCHAR(80), IN `cosexe` VARCHAR(25), IN `codate_naissance` DATE, IN `codroits` ENUM('admin','user','autre'), IN `coperimetre_action` VARCHAR(25), IN `codate_embauche` DATE, IN `conb_visite` INT(11))  begin 
  declare coid_personne int (11) ;
  insert into personne VALUES (null,conom,coprenom,coemail,cotelephone,copassword,cosexe,codate_naissance,codroits);
 
  select id_personne into coid_personne from personne where email = coemail and telephone = cotelephone and password = copassword and id_personne = (select max(id_personne) from personne) ;

  insert into commercial VALUES(coperimetre_action,codate_embauche,conb_visite,coid_personne);

end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertmaison` (IN `msurface` INT(11), IN `mprix` INT(11), IN `mstatut` VARCHAR(25), IN `madresse` VARCHAR(100), IN `mville` VARCHAR(45), IN `mid_map` INT(11), IN `mpiece` INT(11), IN `mchambre` INT(11), IN `meaux` INT(11), IN `mnbvisites` INT(11), IN `msurface_terrain` INT(11), IN `mcave` TINYINT(1), IN `mgrenier` TINYINT(1))  begin 
  declare mid_bien int (11) ;
  insert into bien VALUES (null,msurface,mprix,mstatut,madresse,mville,mid_map,mpiece,mchambre,meaux,mnbvisites);
 
  select id_bien into mid_bien from bien where surface = msurface and adresse = madresse and ville = mville and id_bien = (select max(id_bien) from bien);

  insert into maison VALUES(msurface_terrain,mcave,mgrenier,mid_bien);

end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateappart` (IN `uid_bien` INT(11), IN `usurface` INT(11), IN `uprix` INT(11), IN `ustatut` VARCHAR(25), IN `uadresse` VARCHAR(100), IN `uville` VARCHAR(45), IN `uid_map` INT(11), IN `upiece` INT(11), IN `uchambre` INT(11), IN `ueaux` INT(11))  begin 
  update bien set surface = usurface, prix = uprix, statut = ustatut, adresse = uadresse, ville = uville, id_map = uid_map, piece = upiece, chambre = uchambre, eaux = ueaux where id_bien = uid_bien;

end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updatecommercial` (IN `coid_personne` INT(11), IN `conom` VARCHAR(25), IN `coprenom` VARCHAR(25), IN `coemail` VARCHAR(25), IN `copwd` VARCHAR(25), IN `cosexe` VARCHAR(25), IN `codate_naissance` VARCHAR(25), IN `codroits` VARCHAR(25))  begin

  update personne set nom = conom ,prenom = coprenom,email = coemail, password = copwd, sexe = cosexe, date_naissance = codate_naissance, droits = codroits where id_personne = coid_personne;

end$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `appartement`
--

CREATE TABLE `appartement` (
  `etage` int(11) NOT NULL,
  `ascenseur` tinyint(1) NOT NULL,
  `balcon` tinyint(1) NOT NULL,
  `place_parking` tinyint(1) NOT NULL,
  `id_bien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `appartement`
--

INSERT INTO `appartement` (`etage`, `ascenseur`, `balcon`, `place_parking`, `id_bien`) VALUES
(1, 1, 0, 1, 5),
(1, 1, 0, 1, 6),
(2, 1, 1, 1, 7),
(2, 1, 1, 1, 8),
(2, 1, 1, 1, 9),
(2, 1, 1, 1, 10),
(2, 1, 1, 1, 11),
(2, 1, 1, 1, 12),
(2, 1, 1, 1, 13),
(2, 1, 1, 1, 14);

-- --------------------------------------------------------

--
-- Structure de la table `bien`
--

CREATE TABLE `bien` (
  `id_bien` int(11) NOT NULL,
  `surface` int(11) NOT NULL,
  `prix` int(11) NOT NULL,
  `statut` varchar(25) NOT NULL,
  `adresse` varchar(100) NOT NULL,
  `ville` varchar(45) NOT NULL,
  `id_map` int(11) DEFAULT NULL,
  `piece` int(11) NOT NULL,
  `chambre` int(11) NOT NULL,
  `eaux` int(11) NOT NULL,
  `nbvisites` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `bien`
--

INSERT INTO `bien` (`id_bien`, `surface`, `prix`, `statut`, `adresse`, `ville`, `id_map`, `piece`, `chambre`, `eaux`, `nbvisites`) VALUES
(2, 50, 25000, 'louer', '20 rue de nantes', 'Nantes', NULL, 5, 2, 1, 4),
(5, 30, 26000, 'dispo', '20 rue de paris', 'paris', 1, 3, 2, 1, 0),
(6, 50, 40000, 'dispo', '20 rue de lyon', 'Lyon', 1, 5, 2, 1, 0),
(7, 25, 15000, 'dispo', '20 rue de Marseille', 'Marseille', NULL, 3, 1, 1, 0),
(8, 30, 20000, 'a louer', '20 rue de Nantes', 'Nantes', NULL, 3, 1, 1, 0),
(9, 35, 25000, 'en attente', '20 rue de Lyon', 'Lyon', NULL, 3, 1, 1, 0),
(10, 40, 30000, 'dispo', '20 rue de Strasbourg', 'Strasbourg', NULL, 3, 1, 1, 0),
(11, 45, 35000, 'dispo', '20 rue de Monpellier', 'Monpellier', NULL, 3, 1, 1, 0),
(12, 50, 40000, 'en attente', '20 rue de Lille', 'Lille', NULL, 3, 1, 1, 0),
(13, 55, 45000, 'dispo', '20 rue de Roubaix', 'Roubaix', NULL, 3, 1, 1, 0),
(14, 60, 50000, 'a louer', '20 rue du Havre', 'Le Havre', NULL, 3, 1, 1, 0);

--
-- Déclencheurs `bien`
--
DELIMITER $$
CREATE TRIGGER `afterdeletebien` AFTER DELETE ON `bien` FOR EACH ROW begin
  delete from visite
    where id_bien = old.id_bien;
  end
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `date_inscription` date NOT NULL,
  `departement` int(11) NOT NULL,
  `id_personne` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`date_inscription`, `departement`, `id_personne`) VALUES
('2018-04-23', 78, 11);

-- --------------------------------------------------------

--
-- Structure de la table `commercial`
--

CREATE TABLE `commercial` (
  `perimetre_action` varchar(25) NOT NULL,
  `date_embauche` date NOT NULL,
  `nb_visite` int(11) NOT NULL,
  `id_personne` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `maison`
--

CREATE TABLE `maison` (
  `surface_terrain` int(11) NOT NULL,
  `cave` tinyint(1) NOT NULL,
  `grenier` tinyint(1) NOT NULL,
  `id_bien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `maison`
--

INSERT INTO `maison` (`surface_terrain`, `cave`, `grenier`, `id_bien`) VALUES
(150, 1, 1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE `personne` (
  `id_personne` int(11) NOT NULL,
  `nom` varchar(25) NOT NULL,
  `prenom` varchar(25) NOT NULL,
  `email` varchar(25) NOT NULL,
  `telephone` text,
  `password` varchar(80) NOT NULL,
  `sexe` varchar(25) NOT NULL,
  `date_naissance` date NOT NULL,
  `droits` enum('admin','user','autre') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `personne`
--

INSERT INTO `personne` (`id_personne`, `nom`, `prenom`, `email`, `telephone`, `password`, `sexe`, `date_naissance`, `droits`) VALUES
(11, 'theo', 'uzan', 'theo.uzan@hotmail.fr', '695350959', '9d4e1e23bd5b727046a9e3b4b7db57bd8d6ee684', 'M', '2018-01-01', 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `visite`
--

CREATE TABLE `visite` (
  `id_visite` int(11) NOT NULL,
  `date_visite` date NOT NULL,
  `heure` time NOT NULL,
  `etat` varchar(25) NOT NULL,
  `id_bien` int(11) DEFAULT NULL,
  `id_personne` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `visite`
--

INSERT INTO `visite` (`id_visite`, `date_visite`, `heure`, `etat`, `id_bien`, `id_personne`) VALUES
(1, '2018-03-12', '17:00:00', 'en cours', 2, 11),
(2, '2018-03-14', '12:00:00', 'en cours', 2, 11),
(3, '2018-03-15', '15:00:00', 'terminé', 2, 11),
(5, '2018-03-17', '17:00:00', 'planifié', 2, 11);

--
-- Déclencheurs `visite`
--
DELIMITER $$
CREATE TRIGGER `afterdeletevisite` AFTER DELETE ON `visite` FOR EACH ROW begin
  update bien set nbvisites = nbvisites - 1
    where id_bien = old.id_bien;
  end
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `afterinsertvisite` AFTER INSERT ON `visite` FOR EACH ROW begin
  update bien set nbvisites = nbvisites + 1
    where id_bien = new.id_bien;
  end
$$
DELIMITER ;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `appartement`
--
ALTER TABLE `appartement`
  ADD PRIMARY KEY (`id_bien`);

--
-- Index pour la table `bien`
--
ALTER TABLE `bien`
  ADD PRIMARY KEY (`id_bien`),
  ADD KEY `FK_bien_id_map` (`id_map`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id_personne`);

--
-- Index pour la table `commercial`
--
ALTER TABLE `commercial`
  ADD PRIMARY KEY (`id_personne`);

--
-- Index pour la table `maison`
--
ALTER TABLE `maison`
  ADD PRIMARY KEY (`id_bien`);

--
-- Index pour la table `personne`
--
ALTER TABLE `personne`
  ADD PRIMARY KEY (`id_personne`);

--
-- Index pour la table `visite`
--
ALTER TABLE `visite`
  ADD PRIMARY KEY (`id_visite`),
  ADD KEY `FK_visite_id_bien` (`id_bien`),
  ADD KEY `FK_visite_id_personne` (`id_personne`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `bien`
--
ALTER TABLE `bien`
  MODIFY `id_bien` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT pour la table `personne`
--
ALTER TABLE `personne`
  MODIFY `id_personne` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT pour la table `visite`
--
ALTER TABLE `visite`
  MODIFY `id_visite` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `appartement`
--
ALTER TABLE `appartement`
  ADD CONSTRAINT `FK_appartement_id_bien` FOREIGN KEY (`id_bien`) REFERENCES `bien` (`id_bien`);

--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `FK_client_id_personne` FOREIGN KEY (`id_personne`) REFERENCES `personne` (`id_personne`);

--
-- Contraintes pour la table `commercial`
--
ALTER TABLE `commercial`
  ADD CONSTRAINT `FK_commercial_id_personne` FOREIGN KEY (`id_personne`) REFERENCES `personne` (`id_personne`);

--
-- Contraintes pour la table `maison`
--
ALTER TABLE `maison`
  ADD CONSTRAINT `FK_maison_id_bien` FOREIGN KEY (`id_bien`) REFERENCES `bien` (`id_bien`);

--
-- Contraintes pour la table `visite`
--
ALTER TABLE `visite`
  ADD CONSTRAINT `FK_visite_id_bien` FOREIGN KEY (`id_bien`) REFERENCES `bien` (`id_bien`),
  ADD CONSTRAINT `FK_visite_id_personne` FOREIGN KEY (`id_personne`) REFERENCES `personne` (`id_personne`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
