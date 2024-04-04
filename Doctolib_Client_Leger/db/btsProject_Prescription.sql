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
-- Table structure for table `btsProject_Prescription`
--

CREATE TABLE `btsProject_Prescription` (
  `idPrescription` int(11) NOT NULL,
  `datePrescription` date DEFAULT NULL,
  `content` text,
  `idPatient` int(11) DEFAULT NULL,
  `idDoctor` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `btsProject_Prescription`
--

INSERT INTO `btsProject_Prescription` (`idPrescription`, `datePrescription`, `content`, `idPatient`, `idDoctor`) VALUES
(1, '2023-12-03', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean pulvinar mauris justo, a ultrices arcu rutrum in. Sed vel pulvinar urna, non pulvinar libero. Cras tincidunt consequat nunc et ultrices. Aenean convallis feugiat erat ac iaculis. Suspendisse volutpat posuere rhoncus. Suspendisse mattis, velit eget elementum egestas, dolor purus euismod ex, sit amet eleifend lorem ligula nec est. Nam lobortis nibh accumsan, efficitur erat eu, luctus sapien. Etiam varius venenatis dignissim. Nam a efficitur purus, at eleifend tellus. Nunc mattis lacinia nulla, quis rhoncus sem tincidunt ullamcorper. Nunc vehicula nisl sapien, quis consequat ex mollis vel. Proin ut turpis lobortis, porta urna sed, efficitur purus. ', 201, 102),
(2, '2023-12-09', 'Duis aliquam laoreet mollis. Maecenas leo libero, lobortis pellentesque justo quis, convallis placerat sapien. In eu leo dui. Curabitur urna erat, pretium sed diam sed, eleifend ullamcorper mauris. Etiam et hendrerit diam. Fusce sed lectus eget ipsum suscipit egestas. Nam pellentesque risus turpis, quis ultrices metus sollicitudin at. Cras nibh velit, porttitor id ultrices eu, tincidunt quis magna. Cras at pellentesque elit. ', 201, 102),
(3, '2023-12-05', '', 201, 102);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `btsProject_Prescription`
--
ALTER TABLE `btsProject_Prescription`
  ADD PRIMARY KEY (`idPrescription`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `btsProject_Prescription`
--
ALTER TABLE `btsProject_Prescription`
  MODIFY `idPrescription` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
