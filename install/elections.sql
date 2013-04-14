-- phpMyAdmin SQL Dump
-- version 2.11.11.3
-- http://www.phpmyadmin.net
--
-- Masin: localhost
-- Tegemisaeg: 13.04.2013 kell 14:12:49
-- Serveri versioon: 5.5.24
-- PHP versioon: 5.3.17

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Andmebaas: `elections`
--
CREATE DATABASE `elections` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `elections`;

-- --------------------------------------------------------

--
-- Struktuur tabelile `candidate`
--

CREATE TABLE IF NOT EXISTS `candidate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `person` int(11) NOT NULL,
  `party` varchar(3) NOT NULL,
  `region` varchar(2) NOT NULL,
  `votes` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=38 ;

--
-- Tabeli andmete salvestamine `candidate`
--

INSERT INTO `candidate` (`id`, `person`, `party`, `region`, `votes`) VALUES
(11, 1, 'AAE', 'HR', 0),
(12, 2, 'EKE', 'HI', 2),
(13, 3, 'KRE', 'IV', 0),
(14, 4, 'KOE', 'JG', 1),
(15, 5, 'OVP', 'JA', 0),
(16, 6, 'AAE', 'LA', 0),
(17, 7, 'EKE', 'LV', 2),
(18, 8, 'KRE', 'PO', 3),
(19, 9, 'KOE', 'PA', 2),
(20, 10, 'OVP', 'RP', 0),
(21, 11, 'AAE', 'SA', 0),
(22, 12, 'EKE', 'TA', 2),
(23, 13, 'KRE', 'VA', 0),
(24, 14, 'KOE', 'VD', 0),
(25, 15, 'OVP', 'VO', 0),
(26, 16, 'AAE', 'TN', 0),
(27, 17, 'EKE', 'HR', 1),
(28, 18, 'KRE', 'HI', 1),
(29, 19, 'KOE', 'IV', 1),
(30, 20, 'OVP', 'JG', 0),
(31, 137, 'EKE', 'HI', 0),
(32, 137, 'EKE', 'IV', 0),
(33, 137, 'AAE', 'HI', 0),
(34, 137, 'KOE', 'HI', 0),
(35, 137, 'EKE', 'JG', 0),
(36, 137, 'EKE', 'HR', 0),
(37, 137, 'EKE', 'IV', 0);

-- --------------------------------------------------------

--
-- Struktuur tabelile `party`
--

CREATE TABLE IF NOT EXISTS `party` (
  `id` varchar(3) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tabeli andmete salvestamine `party`
--

INSERT INTO `party` (`id`, `name`) VALUES
('AAE', 'Anonüümsete Aneemikute Erakond'),
('EKE', 'Eesti Konservierakond'),
('KRE', 'Koondatud Reisisaatjate Erakond'),
('KOE', 'Korruptsioonierakond'),
('OVP', 'Ootamatu Vastupanu Erakond');

-- --------------------------------------------------------

--
-- Struktuur tabelile `person`
--

CREATE TABLE IF NOT EXISTS `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `vote` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=21 ;

--
-- Tabeli andmete salvestamine `person`
--

INSERT INTO `person` (`id`, `name`, `vote`) VALUES
(1, 'Edgar Kardigan', NULL),
(2, 'Tõnu Tõukemõnu', NULL),
(3, 'Liia Üleliia', NULL),
(4, 'Liisa Kisa', NULL),
(5, 'Kaarel Haavel', NULL),
(6, 'Anu Vastupanu', NULL),
(7, 'Klaarika Harmoonika', NULL),
(8, 'Moonika Iroonika', NULL),
(9, 'Karl Laatsaret', NULL),
(10, 'Piia Annasiia', NULL),
(11, 'Endel Mandel', NULL),
(12, 'Max Pax', NULL),
(13, 'Lennart Retard', NULL),
(14, 'Tambet Hambad', NULL),
(15, 'Püro Maan', NULL),
(16, 'Siim Lehmapiim', 27),
(17, 'Taavi Mudaravi', NULL),
(18, 'Eha Keha', NULL),
(19, 'Mait Pipraviin', NULL),
(20, 'Jäger Meister', NULL);

-- --------------------------------------------------------

--
-- Struktuur tabelile `region`
--

CREATE TABLE IF NOT EXISTS `region` (
  `id` varchar(2) NOT NULL,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tabeli andmete salvestamine `region`
--

INSERT INTO `region` (`id`, `name`) VALUES
('HR', 'Harjumaa'),
('HI', 'Hiiumaa'),
('IV', 'Ida-Virumaa'),
('JA', 'Järvamaa'),
('JG', 'Jõgevamaa'),
('LV', 'Lääne-Virumaa'),
('LA', 'Läänemaa'),
('PA', 'Pärnumaa'),
('PO', 'Põlvamaa'),
('RP', 'Raplamaa'),
('SA', 'Saaremaa'),
('TN', 'Tallinn'),
('TA', 'Tartumaa'),
('VA', 'Valgamaa'),
('VD', 'Viljandimaa'),
('VO', 'Võrumaa');
