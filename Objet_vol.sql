-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : mer. 09 avr. 2025 à 12:22
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `Objet_vol`
--

-- --------------------------------------------------------

--
-- Structure de la table `Objet`
--

CREATE TABLE `Objet` (
  `id` int(11) NOT NULL,
  `Numeroserie` varchar(250) NOT NULL,
  `Type` varchar(20) NOT NULL,
  `Description` varchar(30) NOT NULL,
  `ContactPerso` int(20) NOT NULL,
  `Date` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `Objet`
--

INSERT INTO `Objet` (`id`, `Numeroserie`, `Type`, `Description`, `ContactPerso`, `Date`) VALUES
(1, '123456', 'dell', 'deeeee', 324225252, '2025-04-09');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `Objet`
--
ALTER TABLE `Objet`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `Objet`
--
ALTER TABLE `Objet`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
