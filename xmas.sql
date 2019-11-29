-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Nov 28, 2019 at 04:32 PM
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

CREATE TABLE Address
(
    id   int(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    text varchar(255)     NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Child`
--

CREATE TABLE Child
(
    id         int(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name       varchar(255)     NOT NULL,
    address_id int(10) UNSIGNED NOT NULL REFERENCES Address (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Gift`
--

CREATE TABLE Gift
(
    id          int(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    description varchar(255)     NOT NULL,
    child_id    int(10) UNSIGNED NOT NULL REFERENCES Child (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;