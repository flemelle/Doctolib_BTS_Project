-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: korradr1.mysql.db
-- Generation Time: Dec 11, 2023 at 02:28 AM
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
-- Table structure for table `btsProject_Appointment`
--

CREATE TABLE `btsProject_Appointment` (
  `idAppointment` int(11) NOT NULL,
  `dateAppointment` date DEFAULT NULL,
  `timeAppointment` time DEFAULT NULL,
  `reason` text,
  `idPatient` int(11) DEFAULT NULL,
  `idDoctor` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `btsProject_Appointment`
--

INSERT INTO `btsProject_Appointment` (`idAppointment`, `dateAppointment`, `timeAppointment`, `reason`, `idPatient`, `idDoctor`) VALUES
(1, '2023-12-03', NULL, 'Maux de têtes', 201, 102),
(2, '2023-12-05', '10:00:00', 'Nausées', 201, 102);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `btsProject_Appointment`
--
ALTER TABLE `btsProject_Appointment`
  ADD PRIMARY KEY (`idAppointment`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `btsProject_Appointment`
--
ALTER TABLE `btsProject_Appointment`
  MODIFY `idAppointment` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
