-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Nov 29, 2019 at 03:54 PM
-- Server version: 5.7.26
-- PHP Version: 7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `xmas`
--

-- --------------------------------------------------------

--
-- Table structure for table `Address`
--

CREATE TABLE `Address` (
  `id` int(10) UNSIGNED NOT NULL,
  `text` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Address`
--

INSERT INTO `Address` (`id`, `text`) VALUES
(1, 'Planckstraße 2, 4020 Linz'),
(2, 'Softwarepark 42, 4232 Hagenberg im Mühlkreis'),
(3, 'Planckstraße 2, 4020 Linz'),
(4, 'Softwarepark 42, 4232 Hagenberg im Mühlkreis');

-- --------------------------------------------------------

--
-- Table structure for table `Child`
--

CREATE TABLE `Child` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL,
  `address_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Child`
--

INSERT INTO `Child` (`id`, `name`, `address_id`) VALUES
(3, 'Thomas', 3),
(4, 'Thomas', 3),
(5, 'Thomas', 3),
(7, 'Thomas', 3),
(9, 'Richard Josef', 3),
(11, 'Thomas', 3),
(13, 'Thomas', 3),
(15, 'Thomas', 3),
(16, 'Richard', 3),
(18, 'Thomas', 3),
(24, 'Thomas', 3),
(25, 'Richard', 3);

-- --------------------------------------------------------

--
-- Table structure for table `Gift`
--

CREATE TABLE `Gift` (
  `id` int(10) UNSIGNED NOT NULL,
  `description` varchar(255) NOT NULL,
  `child_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Address`
--
ALTER TABLE `Address`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Child`
--
ALTER TABLE `Child`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Gift`
--
ALTER TABLE `Gift`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Address`
--
ALTER TABLE `Address`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `Child`
--
ALTER TABLE `Child`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `Gift`
--
ALTER TABLE `Gift`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;
