-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Nov 24, 2019 at 10:56 AM
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
  `id` int(11) UNSIGNED NOT NULL,
  `text` varchar(255) NOT NULL,
  `child_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Children`
--

CREATE TABLE `Children` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  ADD PRIMARY KEY (`id`),
  ADD KEY `child` (`child_id`);

--
-- Indexes for table `Children`
--
ALTER TABLE `Children`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Gift`
--
ALTER TABLE `Gift`
  ADD PRIMARY KEY (`id`),
  ADD KEY `gift` (`child_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Address`
--
ALTER TABLE `Address`
  ADD CONSTRAINT `child` FOREIGN KEY (`child_id`) REFERENCES `Children` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Gift`
--
ALTER TABLE `Gift`
  ADD CONSTRAINT `gift` FOREIGN KEY (`child_id`) REFERENCES `Children` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
