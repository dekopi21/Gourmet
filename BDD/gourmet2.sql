-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Sam 28 Juillet 2018 à 00:59
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `gourmet`
--

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE IF NOT EXISTS `categorie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` longtext,
  `nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `categorie`
--

INSERT INTO `categorie` (`id`, `description`, `nom`) VALUES
(1, 'Plat de résistance', 'RESISTANCE'),
(2, 'Plat qui facilite la digestion', 'DESSERT'),
(3, 'Plat qui donne l’appétit', 'ENTREE'),
(4, 'uuu', 'ppoo');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE IF NOT EXISTS `commande` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dateComm` datetime DEFAULT NULL,
  `etatComm` varchar(255) DEFAULT NULL,
  `prixComm` double NOT NULL,
  `valide` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `com_cli_plat`
--

CREATE TABLE IF NOT EXISTS `com_cli_plat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Id_CLient` bigint(20) DEFAULT NULL,
  `Id_Commade` bigint(20) DEFAULT NULL,
  `Id_Plat` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_1w1dmo95y2rnoergh00sgc35p` (`Id_CLient`),
  KEY `FK_bpy7b06erkd6w24i524ei62jd` (`Id_Commade`),
  KEY `FK_g46m2hxt26b7m6es8khsqp93w` (`Id_Plat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `dateprix`
--

CREATE TABLE IF NOT EXISTS `dateprix` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dateModification` datetime DEFAULT NULL,
  `montant` double NOT NULL,
  `plat_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_li7w3ccujm6tbnxbrhk0kskct` (`plat_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `dateprix`
--

INSERT INTO `dateprix` (`id`, `dateModification`, `montant`, `plat_id`) VALUES
(1, '2018-07-26 11:06:18', 500, 1),
(2, '2018-07-26 11:06:37', 1250, 2),
(3, '2018-07-26 11:07:02', 400, 3);

-- --------------------------------------------------------

--
-- Structure de la table `lignecommande`
--

CREATE TABLE IF NOT EXISTS `lignecommande` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `commande_id` bigint(20) DEFAULT NULL,
  `menu_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_fxlqmobtcqhka3vd1thx8363j` (`commande_id`),
  KEY `FK_c5jvh94yrv56l3e5ha2djk8s3` (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `livraison`
--

CREATE TABLE IF NOT EXISTS `livraison` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `adresseLivraison` varchar(255) DEFAULT NULL,
  `dateLivraison` datetime DEFAULT NULL,
  `livre` tinyint(1) NOT NULL,
  `modeLivraison` varchar(255) DEFAULT NULL,
  `agent_id` bigint(20) DEFAULT NULL,
  `commande_id` bigint(20) DEFAULT NULL,
  `livreur_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_pkm4gn8rx2xoew5udnpfanxxb` (`agent_id`),
  KEY `FK_1nl3j7yj3yq91ul57uujh5lrw` (`commande_id`),
  KEY `FK_oyydpv1avhtaurkyvia0vtv3` (`livreur_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `menu`
--

CREATE TABLE IF NOT EXISTS `menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `calendrie` datetime DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `typeMenu_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_f9rct5pbkimyf3d4elyt06ttm` (`typeMenu_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `menu`
--

INSERT INTO `menu` (`id`, `calendrie`, `libelle`, `typeMenu_id`) VALUES
(1, '2018-07-25 10:38:54', 'Enfant', 1),
(2, '2018-07-25 10:39:36', 'Noèl', 2);

-- --------------------------------------------------------

--
-- Structure de la table `menuplat`
--

CREATE TABLE IF NOT EXISTS `menuplat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `menu_id` bigint(20) DEFAULT NULL,
  `plat_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_6ee3xlq4vba1vtjjymxt6l8h9` (`menu_id`),
  KEY `FK_e3kv67wau7b0dr6fragvme2sc` (`plat_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `menuplat`
--

INSERT INTO `menuplat` (`id`, `menu_id`, `plat_id`) VALUES
(1, 1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `menu_restaurant`
--

CREATE TABLE IF NOT EXISTS `menu_restaurant` (
  `menu_id` bigint(20) NOT NULL,
  `restaurants_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_3cxw6v3atgrknrcr40j1mscw6` (`restaurants_id`),
  KEY `FK_3cxw6v3atgrknrcr40j1mscw6` (`restaurants_id`),
  KEY `FK_ejma8u56xma8if2nkdhvn1rw8` (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `plat`
--

CREATE TABLE IF NOT EXISTS `plat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` longtext,
  `disponible` tinyint(1) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `nomPlat` varchar(255) DEFAULT NULL,
  `categorie_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_p1p71cp418y1tj57hb93mttef` (`categorie_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `plat`
--

INSERT INTO `plat` (`id`, `description`, `disponible`, `image`, `nomPlat`, `categorie_id`) VALUES
(1, 'Plat réalisé a bas de la farine de mais', 1, '/public/data/PLATS/20182543_104341.jpg', 'Patte', 1),
(2, 'Plat fait a bas de pattes alimentaire', 1, '/public/data/PLATS/20182549_104956.jpg', 'Spagetti', 1),
(3, 'Thé', 1, '/public/data/PLATS/20182600_010014.jpg', 'Café', 3),
(4, 'tttttt', 0, '/public/data/PLATS/20182600_010014.jpg', 'ssss', 2);

-- --------------------------------------------------------

--
-- Structure de la table `reglement`
--

CREATE TABLE IF NOT EXISTS `reglement` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dateReglement` datetime DEFAULT NULL,
  `montant` double NOT NULL,
  `commande_id` bigint(20) DEFAULT NULL,
  `typeReglement_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_8w8ysyj5imef5iquxs6e9nolk` (`commande_id`),
  KEY `FK_42vqr4dnjub126lu0kraf9fd6` (`typeReglement_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `restaurant`
--

CREATE TABLE IF NOT EXISTS `restaurant` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `image` varchar(255) DEFAULT NULL,
  `localisation` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `raisonSocial` varchar(255) DEFAULT NULL,
  `menu_id` bigint(20) DEFAULT NULL,
  `typeMenu_id` bigint(20) DEFAULT NULL,
  `horaire` varchar(255) DEFAULT NULL,
  `specialite` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_p2wequs7l5t5h2gqld4961ucs` (`menu_id`),
  KEY `FK_1vt2bqcnkil2n4ckf212yqwkx` (`typeMenu_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `restaurant`
--

INSERT INTO `restaurant` (`id`, `image`, `localisation`, `nom`, `raisonSocial`, `menu_id`, `typeMenu_id`, `horaire`, `specialite`) VALUES
(1, '/public/images/resto/olodge.jpg', 'Adidogome', 'Gourmet', 'Proposer une restauration en temps réel au public', NULL, NULL, '9h30 - 23h59', 'Cuisine africaine;Cuisine libanaise;');

-- --------------------------------------------------------

--
-- Structure de la table `restaurant_utilisateur`
--

CREATE TABLE IF NOT EXISTS `restaurant_utilisateur` (
  `restaurant_id` bigint(20) NOT NULL,
  `livreurs_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_el8v9v9rb1f2my3s5yw8owbpo` (`livreurs_id`),
  KEY `FK_el8v9v9rb1f2my3s5yw8owbpo` (`livreurs_id`),
  KEY `FK_jdr1upg2j05f3oj8hw8319fwa` (`restaurant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `typemenu`
--

CREATE TABLE IF NOT EXISTS `typemenu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` longtext,
  `libelle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `typemenu`
--

INSERT INTO `typemenu` (`id`, `description`, `libelle`) VALUES
(1, 'menu dont les plat ne change pas', 'Fixe'),
(2, 'menu dont les plats peuvent changer', 'Dynamique'),
(3, 'menu qui peut changer mais très rarement', 'Mixte');

-- --------------------------------------------------------

--
-- Structure de la table `typereglement`
--

CREATE TABLE IF NOT EXISTS `typereglement` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=15 ;

--
-- Contenu de la table `typereglement`
--

INSERT INTO `typereglement` (`id`, `libelle`, `logo`) VALUES
(9, 'Porte-monaie éléctronique', '/public/data/TYPEREGLEMENTS/20182640_064031.png'),
(10, 'Cheque', '/public/data/TYPEREGLEMENTS/20182640_064052.jpg'),
(11, 'T-Money', '/public/data/TYPEREGLEMENTS/20182641_064143.jpg'),
(12, 'Flooz', '/public/data/TYPEREGLEMENTS/20182641_064159.jpg'),
(13, 'Cache', '/public/data/TYPEREGLEMENTS/20182642_064247.jpg'),
(14, 'Cache Pieces', '/public/data/TYPEREGLEMENTS/20182648_064808.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `DTYPE` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `civilite` longtext,
  `email` varchar(30) DEFAULT NULL,
  `image` varchar(60) DEFAULT NULL,
  `login` varchar(25) DEFAULT NULL,
  `nomUtilisateur` varchar(20) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL,
  `prenomUtilisateur` varchar(50) DEFAULT NULL,
  `profile` varchar(60) DEFAULT NULL,
  `quartier` varchar(30) DEFAULT NULL,
  `sexe` char(1) NOT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `ville` varchar(30) DEFAULT NULL,
  `dateConnexion` datetime DEFAULT NULL,
  `restaurant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_kmw1w139mxftir6ce47jrbxac` (`login`),
  UNIQUE KEY `UK_rgg45370vmd11q9ngtngcue3u` (`password`),
  KEY `FK_hioffk0ttd2eyo4vf9b32wml6` (`restaurant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `com_cli_plat`
--
ALTER TABLE `com_cli_plat`
  ADD CONSTRAINT `FK_1w1dmo95y2rnoergh00sgc35p` FOREIGN KEY (`Id_CLient`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `FK_bpy7b06erkd6w24i524ei62jd` FOREIGN KEY (`Id_Commade`) REFERENCES `commande` (`id`),
  ADD CONSTRAINT `FK_g46m2hxt26b7m6es8khsqp93w` FOREIGN KEY (`Id_Plat`) REFERENCES `plat` (`id`);

--
-- Contraintes pour la table `dateprix`
--
ALTER TABLE `dateprix`
  ADD CONSTRAINT `FK_li7w3ccujm6tbnxbrhk0kskct` FOREIGN KEY (`plat_id`) REFERENCES `plat` (`id`);

--
-- Contraintes pour la table `lignecommande`
--
ALTER TABLE `lignecommande`
  ADD CONSTRAINT `FK_c5jvh94yrv56l3e5ha2djk8s3` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`),
  ADD CONSTRAINT `FK_fxlqmobtcqhka3vd1thx8363j` FOREIGN KEY (`commande_id`) REFERENCES `commande` (`id`);

--
-- Contraintes pour la table `livraison`
--
ALTER TABLE `livraison`
  ADD CONSTRAINT `FK_1nl3j7yj3yq91ul57uujh5lrw` FOREIGN KEY (`commande_id`) REFERENCES `commande` (`id`),
  ADD CONSTRAINT `FK_oyydpv1avhtaurkyvia0vtv3` FOREIGN KEY (`livreur_id`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `FK_pkm4gn8rx2xoew5udnpfanxxb` FOREIGN KEY (`agent_id`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `menu`
--
ALTER TABLE `menu`
  ADD CONSTRAINT `FK_f9rct5pbkimyf3d4elyt06ttm` FOREIGN KEY (`typeMenu_id`) REFERENCES `typemenu` (`id`);

--
-- Contraintes pour la table `menuplat`
--
ALTER TABLE `menuplat`
  ADD CONSTRAINT `FK_6ee3xlq4vba1vtjjymxt6l8h9` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`),
  ADD CONSTRAINT `FK_e3kv67wau7b0dr6fragvme2sc` FOREIGN KEY (`plat_id`) REFERENCES `plat` (`id`);

--
-- Contraintes pour la table `menu_restaurant`
--
ALTER TABLE `menu_restaurant`
  ADD CONSTRAINT `FK_3cxw6v3atgrknrcr40j1mscw6` FOREIGN KEY (`restaurants_id`) REFERENCES `restaurant` (`id`),
  ADD CONSTRAINT `FK_ejma8u56xma8if2nkdhvn1rw8` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`);

--
-- Contraintes pour la table `plat`
--
ALTER TABLE `plat`
  ADD CONSTRAINT `FK_p1p71cp418y1tj57hb93mttef` FOREIGN KEY (`categorie_id`) REFERENCES `categorie` (`id`);

--
-- Contraintes pour la table `reglement`
--
ALTER TABLE `reglement`
  ADD CONSTRAINT `FK_42vqr4dnjub126lu0kraf9fd6` FOREIGN KEY (`typeReglement_id`) REFERENCES `typereglement` (`id`),
  ADD CONSTRAINT `FK_8w8ysyj5imef5iquxs6e9nolk` FOREIGN KEY (`commande_id`) REFERENCES `commande` (`id`);

--
-- Contraintes pour la table `restaurant`
--
ALTER TABLE `restaurant`
  ADD CONSTRAINT `FK_1vt2bqcnkil2n4ckf212yqwkx` FOREIGN KEY (`typeMenu_id`) REFERENCES `typemenu` (`id`),
  ADD CONSTRAINT `FK_p2wequs7l5t5h2gqld4961ucs` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`);

--
-- Contraintes pour la table `restaurant_utilisateur`
--
ALTER TABLE `restaurant_utilisateur`
  ADD CONSTRAINT `FK_el8v9v9rb1f2my3s5yw8owbpo` FOREIGN KEY (`livreurs_id`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `FK_jdr1upg2j05f3oj8hw8319fwa` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurant` (`id`);

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `FK_hioffk0ttd2eyo4vf9b32wml6` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurant` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
