-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: korradr1.mysql.db
-- Generation Time: Dec 11, 2023 at 02:29 AM
-- Server version: 5.7.42-log
-- PHP Version: 8.1.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `korradr1`
--

-- --------------------------------------------------------

--
-- Structure for view `btsProject_User_Doctor`
--

CREATE ALGORITHM=UNDEFINED SQL SECURITY DEFINER VIEW `btsProject_User_Doctor`  AS SELECT `btsProject_User`.`idUser` AS `idUser`, `btsProject_User`.`firstName` AS `firstName`, `btsProject_User`.`lastName` AS `lastName`, `btsProject_User`.`age` AS `age`, `btsProject_User`.`mail` AS `mail`, `btsProject_User`.`address` AS `address`, `btsProject_User`.`password` AS `password`, `btsProject_User`.`role` AS `role` FROM `btsProject_User` WHERE (`btsProject_User`.`role` = 'doctor') ;

--
-- VIEW `btsProject_User_Doctor`
-- Data: None
--

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
