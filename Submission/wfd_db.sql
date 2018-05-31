-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 25, 2018 at 06:27 AM
-- Server version: 5.7.17
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `wfd_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `allergies`
--

CREATE TABLE `allergies` (
  `User_id` int(5) NOT NULL,
  `allergen` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `allergies`
--

INSERT INTO `allergies` (`User_id`, `allergen`) VALUES
(7, 'gluten'),
(13, 'egg'),
(13, 'figs'),
(13, 'milk'),
(13, 'mushroom'),
(13, 'nuts'),
(23, 'egg'),
(28, 'apples'),
(28, 'bananas'),
(28, 'fish'),
(28, 'nuts');

-- --------------------------------------------------------

--
-- Table structure for table `fav_recipes`
--

CREATE TABLE `fav_recipes` (
  `User_id` int(5) NOT NULL,
  `recipe_id` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `fav_recipes`
--

INSERT INTO `fav_recipes` (`User_id`, `recipe_id`) VALUES
(7, '218311'),
(7, '25128'),
(13, '25128'),
(23, '234674'),
(23, '257193'),
(27, '235195'),
(27, '7385'),
(28, '10917'),
(29, '10917');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `User_id` int(5) NOT NULL,
  `email_address` varchar(50) NOT NULL,
  `password` char(60) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `dietary_req` varchar(100) DEFAULT NULL,
  `verified` bit(1) NOT NULL DEFAULT b'1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`User_id`, `email_address`, `password`, `dietary_req`, `verified`) VALUES
(7, 'bloubulle@pretoria.co.za', '$2y$10$qDHXY1vdUiHIghQKH1liouFHal94h8OdqwM6djqCLP2gXJPIEDQy.', NULL, b'1'),
(13, 'sid@gmail.com', '$2y$10$RiLwC05nL87W8bvtb9XcZe5CPp0zQnL1qzrGcIXz9eQNTrNBHOXpG', NULL, b'1'),
(23, 'pieter@vanDieOosrand.com', '$2y$10$lwjwvQY5P4YM0zhtuzoG0eLiUGZoqeeTdc4cJwzUO0MmnMKMe1F1i', 'meat', b'1'),
(27, 'laduma@gmail.com', '$2y$10$wiEFvjTIOyRIzJkN7ne00O6GOcTITgnaF5RkFbS.Uu68lGGc1etEi', 'meat', b'1'),
(28, 'sid.aranya@gmail.com', '$2y$10$KGPJSa97xwskCI8MLffNW.xFo5zyT4boCgRHz0JoLxrdk3HFk9Xl6', 'meat,egg', b'1'),
(29, 'abby.alyssa@gmail.com', '$2y$10$aVqHlvl3oTmT3dxhbwapkeKIx4kUASNlxxMAdf.jJPk17MDNNQxzm', 'chocolate', b'1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `allergies`
--
ALTER TABLE `allergies`
  ADD PRIMARY KEY (`User_id`,`allergen`);

--
-- Indexes for table `fav_recipes`
--
ALTER TABLE `fav_recipes`
  ADD PRIMARY KEY (`User_id`,`recipe_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`User_id`),
  ADD UNIQUE KEY `User_id` (`User_id`),
  ADD UNIQUE KEY `email_address` (`email_address`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `User_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `allergies`
--
ALTER TABLE `allergies`
  ADD CONSTRAINT `allergies_ibfk_1` FOREIGN KEY (`User_id`) REFERENCES `users` (`User_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `fav_recipes`
--
ALTER TABLE `fav_recipes`
  ADD CONSTRAINT `fav_recipes_ibfk_1` FOREIGN KEY (`User_id`) REFERENCES `users` (`User_id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
