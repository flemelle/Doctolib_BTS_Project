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
-- Table structure for table `btsProject_User`
--

CREATE TABLE `btsProject_User` (
  `idUser` mediumint(9) NOT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `age` mediumint(9) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `btsProject_User`
--

INSERT INTO `btsProject_User` (`idUser`, `firstName`, `lastName`, `age`, `mail`, `address`, `password`, `role`) VALUES
(2, 'Rhonald', 'Octavia', 99, 'mauris.a@protonmail.org', '669-7337 Enim Road', 'GAK11VIO2IP', 'doctor'),
(3, 'Alvin', 'Abraham', 96, 'erat.sed.nunc@outlook.net', 'P.O. Box 433, 7441 Duis Street', 'IGG27KYH3MQ', 'doctor'),
(4, 'Hayfa', 'Upton', 46, 'quam.vel@hotmail.ca', 'P.O. Box 918, 5289 Erat, Av.', 'NFS68PQN2OW', 'patient'),
(5, 'Dennis', 'Raymonde', 76, 'eu@google.edu', 'Ap #815-7945 Neque Road', 'DSK53LJY7BF', 'doctor'),
(7, 'Jolie', 'Raja', 32, 'enim.consequat@yahoo.org', '984-633 Fringilla. Rd.', 'UOS27HLV8TH', 'patient'),
(8, 'Shellie', 'Jameson', 17, 'faucibus.orci@outlook.net', 'P.O. Box 702, 5795 Nisl. Rd.', 'CFX17FIM5OH', 'doctor'),
(9, 'Moses', 'Lael', 40, 'lorem@outlook.edu', '108-4121 Ultricies St.', 'FRN72DTD4HW', 'patient'),
(10, 'Leigh', 'Allen', 5, 'quis.lectus@google.org', 'P.O. Box 280, 731 Pellentesque, Rd.', 'PFQ66PVN7YX', 'doctor'),
(11, 'Melodie', 'Cora', 16, 'odio.nam@yahoo.couk', 'P.O. Box 306, 1886 Molestie Street', 'ARE45UWB4DM', 'doctor'),
(12, 'Carly', 'Jessica', 3, 'feugiat.tellus@aol.ca', 'P.O. Box 411, 7186 Nec Rd.', 'EYN17KQC7TR', 'doctor'),
(13, 'Daria', 'Nathaniel', 15, 'eros.proin@protonmail.couk', '778-7813 Integer Rd.', 'ZQM72DEC0FY', 'patient'),
(14, 'Craig', 'Bianca', 0, 'eu.eros@hotmail.ca', 'Ap #907-3244 Elit. Avenue', 'ZWE52UIY0CE', 'doctor'),
(15, 'Summer', 'Zena', 22, 'et.risus@hotmail.edu', '303-5086 Auctor Rd.', 'KYN23PRZ9QG', 'patient'),
(16, 'Aline', 'Abbot', 22, 'nisl.elementum.purus@yahoo.net', '882-9067 Scelerisque St.', 'YHW79PZX0WT', 'patient'),
(17, 'Ivory', 'Ila', 23, 'quam.quis@icloud.couk', '453-5415 Fermentum Street', 'UWU47FDQ2VM', 'doctor'),
(18, 'Vladimir', 'Walter', 95, 'est.mauris@outlook.org', '222-3131 Nec Avenue', 'SIE83PES7AD', 'doctor'),
(19, 'Lesley', 'Dane', 60, 'arcu@protonmail.com', '925-381 Lacinia St.', 'HFS67WCY7GB', 'patient'),
(20, 'Katell', 'Josephine', 52, 'velit.pellentesque@protonmail.net', '314-3334 Enim Street', 'LVN62WHW3BD', 'patient'),
(21, 'Aristotle', 'Amal', 13, 'neque@hotmail.com', 'Ap #853-8712 Mi Road', 'LGY51XCH6VL', 'doctor'),
(22, 'Tanner', 'Jasper', 16, 'tristique.pharetra.quisque@yahoo.ca', '788-2542 Odio St.', 'YLF14HJJ6IT', 'doctor'),
(23, 'Harlan', 'Zachary', 56, 'nunc@protonmail.net', 'Ap #111-8555 Natoque St.', 'BQK83ZDB3KO', 'patient'),
(24, 'Brenden', 'Justin', 12, 'dictum.augue.malesuada@hotmail.couk', 'P.O. Box 837, 9857 Varius Road', 'JGI03CTB8US', 'patient'),
(25, 'Risa', 'Dominique', 98, 'est@google.net', 'Ap #409-5451 Et Rd.', 'OVL36OQL1NB', 'patient'),
(26, 'Jolie', 'Illiana', 15, 'arcu.vestibulum@outlook.net', 'P.O. Box 318, 3732 Arcu St.', 'HEM30LUH1PD', 'patient'),
(27, 'Tiger', 'Dennis', 61, 'nam.porttitor@outlook.com', 'P.O. Box 409, 9117 Lorem. Av.', 'WKJ76QSK6OU', 'doctor'),
(28, 'Martin', 'Kennan', 36, 'nulla.donec@google.net', '388-5520 Congue, Road', 'YAB65PIP4LH', 'doctor'),
(29, 'Fiona', 'Galvin', 52, 'sapien.imperdiet@aol.ca', 'Ap #130-9524 Eros Rd.', 'ADV46TDU3WA', 'patient'),
(30, 'Ivan', 'Lael', 53, 'neque@aol.net', 'P.O. Box 526, 2494 Ut, Avenue', 'VRW56HVN5WY', 'doctor'),
(31, 'Nash', 'Jolie', 47, 'a.facilisis@protonmail.com', '517-8198 Neque Rd.', 'PBG87TNI0DD', 'patient'),
(32, 'Denton', 'Jane', 89, 'pede.ultrices.a@google.edu', '525-5161 Ac Road', 'IZH21UJW2VS', 'patient'),
(33, 'Zoe', 'Anjolie', 54, 'consectetuer@aol.edu', 'P.O. Box 552, 4082 Vel Avenue', 'PNP67BAN3TL', 'doctor'),
(34, 'Odette', 'Aimee', 8, 'arcu.imperdiet.ullamcorper@google.com', 'Ap #970-4382 Integer Rd.', 'GTJ17JXW1QD', 'doctor'),
(35, 'Karleigh', 'Cairo', 65, 'ipsum.primis.in@aol.couk', '480-1724 In Av.', 'JHN85RLX0TK', 'doctor'),
(36, 'Oleg', 'Trevor', 57, 'sagittis.nullam@hotmail.edu', '720-8622 Nunc St.', 'EKC62NLE2PK', 'patient'),
(37, 'Adrian', 'Kelsie', 37, 'quis.accumsan@outlook.org', '683-4826 Convallis St.', 'UGJ63QLH3HV', 'patient'),
(38, 'Cara', 'Madaline', 17, 'sed@icloud.org', '7618 Vel, Street', 'SPE50NJT3XS', 'doctor'),
(39, 'Henry', 'Shelley', 18, 'dictum.magna.ut@icloud.com', '855-1662 Interdum St.', 'ENI85KDQ5DG', 'doctor'),
(40, 'Yvonne', 'Raya', 81, 'augue.malesuada@hotmail.com', 'P.O. Box 807, 8276 Cum Rd.', 'DCF55ZIT1RL', 'doctor'),
(41, 'Brock', 'Ingrid', 26, 'curae.donec@aol.org', '7770 Mauris Rd.', 'QMA35MBR6EU', 'doctor'),
(42, 'Penelope', 'Kenneth', 15, 'tempor.bibendum@yahoo.couk', '9267 Donec Av.', 'IIN22ALU4GM', 'patient'),
(43, 'Lucian', 'Caesar', 45, 'cras.lorem@aol.net', 'P.O. Box 518, 895 Diam St.', 'UXX06OSC1MN', 'patient'),
(44, 'Sybill', 'Oren', 46, 'amet.diam.eu@hotmail.net', 'Ap #329-2202 Imperdiet Avenue', 'YAQ15FKO8FK', 'patient'),
(45, 'Wynter', 'Michael', 57, 'justo.faucibus@protonmail.couk', '172-2145 Nullam Rd.', 'XUX18TML3WT', 'patient'),
(46, 'Fletcher', 'Troy', 35, 'fringilla@google.edu', '3060 Blandit Road', 'JPC01UCM6NU', 'patient'),
(47, 'Palmer', 'Keely', 13, 'quam@icloud.com', 'P.O. Box 619, 9769 Tristique Road', 'TLT43EKS5ZD', 'doctor'),
(48, 'Rashad', 'Brian', 53, 'augue.eu@aol.ca', 'Ap #672-316 Quis Rd.', 'KRB15MII3MC', 'patient'),
(49, 'Xander', 'Adria', 67, 'lectus.pede@yahoo.couk', 'Ap #858-1890 Inceptos Avenue', 'JKS89ASO8JJ', 'patient'),
(50, 'Olivia', 'Ina', 49, 'suspendisse.tristique@google.net', 'Ap #781-2498 Sodales Ave', 'PWZ78RNI5TE', 'doctor'),
(51, 'Rogan', 'Jamalia', 60, 'pede.sagittis@icloud.net', '939-9138 Nibh Rd.', 'MYO81WQQ3CU', 'patient'),
(52, 'Dustin', 'Emerson', 56, 'fusce@hotmail.edu', '5716 Lacus Rd.', 'OHJ39OUF4GN', 'patient'),
(53, 'Octavia', 'Debra', 81, 'quisque.imperdiet@hotmail.ca', '727-1365 Dictum Avenue', 'ERS63YBU4KK', 'doctor'),
(54, 'Chava', 'Elmo', 46, 'et@outlook.net', 'P.O. Box 426, 3644 Donec Street', 'QHN64LLF8BF', 'doctor'),
(55, 'Whoopi', 'Chiquita', 63, 'fusce.dolor@aol.ca', 'Ap #778-8748 Ultrices. Street', 'FGE76VYW1FI', 'patient'),
(56, 'Brandon', 'Sydnee', 91, 'molestie.arcu@aol.ca', '386-5280 Maecenas Ave', 'EPR84SKN8SW', 'doctor'),
(57, 'Candice', 'Callum', 14, 'dui@outlook.ca', '139-8894 In Rd.', 'HKH75ICC5MR', 'doctor'),
(58, 'Mia', 'Chloe', 0, 'in.lobortis@hotmail.couk', 'Ap #650-705 Non St.', 'PWP78FPX3TD', 'doctor'),
(59, 'Kelsie', 'Patricia', 57, 'risus.morbi@google.net', '811-9680 Sodales St.', 'DQO62KVA5DO', 'doctor'),
(60, 'Hilda', 'Jocelyn', 21, 'sem@google.couk', '834-5372 Lorem Ave', 'JSH24EIK5FG', 'doctor'),
(61, 'Trevor', 'Keane', 9, 'odio@protonmail.couk', '5152 Fames Ave', 'ZVN52KTV0BP', 'doctor'),
(62, 'Natalie', 'Ava', 26, 'commodo.tincidunt@protonmail.edu', 'Ap #920-4845 Orci Avenue', 'DFY56WVE1DQ', 'doctor'),
(63, 'Zeus', 'Patrick', 87, 'dis@outlook.edu', '880-6482 Ipsum Av.', 'EFL14SZH2OD', 'doctor'),
(64, 'Nita', 'Thane', 68, 'nec.metus@google.couk', '212 Rhoncus. Av.', 'IHD68OBO8BC', 'doctor'),
(65, 'Beck', 'Sierra', 90, 'odio.tristique.pharetra@hotmail.couk', 'P.O. Box 849, 148 Elit, Ave', 'TJI91MTE0UE', 'doctor'),
(66, 'Cullen', 'Glenna', 45, 'sit.amet.consectetuer@hotmail.couk', 'Ap #926-7966 Bibendum Ave', 'KMZ82QHM1YL', 'doctor'),
(67, 'Rashad', 'Vanna', 77, 'mi@outlook.org', '2032 Duis Rd.', 'CCL67IHY7UO', 'patient'),
(68, 'Yvette', 'Hermione', 10, 'vestibulum.lorem@outlook.org', '348-3730 Diam St.', 'VDH08RAP4QI', 'patient'),
(69, 'Ali', 'Winifred', 85, 'amet@hotmail.com', 'Ap #407-3588 Diam. Avenue', 'IZY17TYS4CW', 'patient'),
(70, 'TaShya', 'Chloe', 18, 'donec.nibh@outlook.org', '552-4376 Senectus Av.', 'ROW52IMP6HO', 'doctor'),
(71, 'Basil', 'Odysseus', 6, 'malesuada.id@google.net', 'Ap #431-6311 Massa St.', 'DZW11ZJD7TA', 'patient'),
(72, 'Darius', 'Fulton', 8, 'mauris.ipsum.porta@protonmail.edu', 'Ap #874-8704 Nunc Street', 'HJX30ORT0HO', 'doctor'),
(73, 'Lacey', 'Nolan', 74, 'eu.augue.porttitor@aol.edu', 'Ap #897-1662 Quis Street', 'DTG18EDD8OE', 'doctor'),
(74, 'Griffin', 'Ariana', 80, 'eu.eros@outlook.edu', 'Ap #989-4146 Ornare Rd.', 'EZS74PRM8GX', 'patient'),
(75, 'Ainsley', 'Nevada', 96, 'augue@aol.com', 'P.O. Box 603, 4551 Dictum Rd.', 'NLY52UXU6AN', 'doctor'),
(76, 'Ferdinand', 'Abbot', 10, 'eu.tellus@google.net', '490-4154 Malesuada Road', 'BHO16WJB5EC', 'doctor'),
(77, 'Tana', 'Paul', 58, 'lobortis@outlook.org', '770-2740 Non Av.', 'KIS03ISS4SJ', 'patient'),
(78, 'Brenden', 'Jesse', 23, 'nam@protonmail.edu', 'Ap #479-7229 Amet St.', 'TNM64CYB3RM', 'patient'),
(79, 'Armando', 'Daphne', 99, 'risus.varius@outlook.couk', 'P.O. Box 861, 2030 Vivamus Road', 'HVW67XKN4KE', 'doctor'),
(80, 'Craig', 'Hyacinth', 52, 'suspendisse@hotmail.edu', 'Ap #681-1983 Nunc, St.', 'XDM74RUD5UP', 'patient'),
(81, 'Tallulah', 'Adam', 29, 'varius@outlook.org', '894-8524 Ut, Rd.', 'SZE42IIF7AY', 'doctor'),
(82, 'Idona', 'Addison', 81, 'a.felis@aol.net', '250-5427 Lorem Street', 'NBG83VRT4XU', 'doctor'),
(83, 'Lawrence', 'Christen', 78, 'pharetra.quisque@yahoo.edu', 'P.O. Box 282, 3586 Rutrum Street', 'HCK20RBV6HU', 'doctor'),
(84, 'Ali', 'Jeanette', 28, 'lectus.convallis.est@hotmail.com', 'P.O. Box 160, 165 Amet Rd.', 'CVD17IQO1CB', 'doctor'),
(85, 'Shoshana', 'Odessa', 50, 'lectus.nullam@aol.net', 'Ap #683-8059 Pede St.', 'JAN68NVY2NR', 'doctor'),
(86, 'Ivan', 'Iona', 28, 'arcu.aliquam.ultrices@outlook.net', '730-7043 Morbi St.', 'OLS16BQB8OI', 'patient'),
(87, 'Hayfa', 'Callie', 97, 'mauris.eu@yahoo.com', 'P.O. Box 436, 5359 Lacus. Street', 'RQS20KKX7WS', 'patient'),
(88, 'Jarrod', 'Gray', 46, 'nisl@google.net', 'Ap #375-5429 Nisi. Rd.', 'LMT80TQH8PL', 'patient'),
(89, 'Julian', 'Medge', 89, 'facilisis@outlook.ca', '7524 Consectetuer Rd.', 'RHC26HDK7TY', 'doctor'),
(90, 'Shaeleigh', 'Judith', 29, 'mi@icloud.net', 'P.O. Box 224, 2123 Luctus St.', 'LDP59OKT4WS', 'patient'),
(91, 'Dana', 'Hanna', 84, 'molestie.dapibus@protonmail.org', 'Ap #721-4729 Metus Av.', 'PVR16GGQ6CP', 'doctor'),
(92, 'Jasper', 'Latifah', 86, 'ut.pharetra@aol.com', '887-4806 Cubilia Road', 'HFW82DMS7GY', 'doctor'),
(93, 'Preston', 'Quemby', 56, 'curabitur.consequat@aol.net', 'Ap #334-556 Libero Road', 'FIF82EXQ7EV', 'doctor'),
(94, 'Kibo', 'Catherine', 89, 'sed.turpis@outlook.edu', 'Ap #956-847 Quis, Rd.', 'JGH12YLF2CZ', 'doctor'),
(95, 'Fredericka', 'Jaime', 27, 'proin.velit@hotmail.com', 'P.O. Box 858, 7441 In, Ave', 'BJM46HGF1IT', 'patient'),
(96, 'Boris', 'Chester', 68, 'non.bibendum@protonmail.net', '497-2762 Aliquam St.', 'GDC85IXP3UP', 'patient'),
(97, 'Quinn', 'Idona', 33, 'turpis.vitae@google.ca', '513-1783 Fusce Ave', 'FOY52XPB8SZ', 'patient'),
(98, 'Cain', 'Ian', 23, 'volutpat@icloud.edu', 'P.O. Box 353, 5315 Nam Avenue', 'YOE32KWI3BV', 'doctor'),
(99, 'Beck', 'William', 28, 'vestibulum.mauris@yahoo.net', 'Ap #496-8873 Id, St.', 'HHP31MHP4FI', 'doctor'),
(100, 'Eleanor', 'Mark', 23, 'rhoncus.donec@hotmail.com', 'Ap #692-127 Porta Rd.', 'PEI18KUN2PD', 'doctor'),
(101, 'test', 'tasty', 43, 'test@test.test', NULL, NULL, 'doctor'),
(102, 'first', 'last', NULL, 'provider@mail.com', NULL, 'pass', 'doctor'),
(201, 'test', 'trésor', 22, 'test@test.test', '', 'test', 'patient'),
(202, 'Admin', NULL, 10, 'admin@admin.admin', NULL, 'admin', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `btsProject_User`
--
ALTER TABLE `btsProject_User`
  ADD PRIMARY KEY (`idUser`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `btsProject_User`
--
ALTER TABLE `btsProject_User`
  MODIFY `idUser` mediumint(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=203;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
