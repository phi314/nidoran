-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 05, 2015 at 12:27 
-- Server version: 5.6.21
-- PHP Version: 5.5.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `nidoran_library`
--

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE IF NOT EXISTS `buku` (
`id` int(11) NOT NULL,
  `isbn` varchar(20) NOT NULL,
  `judul` varchar(100) NOT NULL,
  `penerbit` varchar(50) NOT NULL,
  `penulis` varchar(50) NOT NULL,
  `tahun` varchar(4) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`id`, `isbn`, `judul`, `penerbit`, `penulis`, `tahun`, `created_at`, `updated_at`) VALUES
(1, '978', 'Dilanku', 'Pastel Books', 'Pidi Baiq', '2009', '2015-12-04 10:45:30', '2015-12-04 03:45:30'),
(6, '413', 'Dilanku Buku kedua', 'Pastel Books', 'Pidi Baiq', '2008', '2015-12-04 11:32:20', '2015-12-04 14:33:02'),
(8, '678', 'Pulang', 'Mizan', 'Tara Liye', '2013', '2015-12-04 12:24:40', '2015-12-04 05:24:40'),
(9, '983', 'Buku Pintar', 'Neo', 'Maman Abdurrahman', '2004', '2015-12-04 12:27:16', '2015-12-04 06:25:07'),
(11, '435', 'Drunken Monster', 'Pastel Books', 'Pidi Baiq', '2009', '2015-12-04 21:32:47', '2015-12-04 14:33:18');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE IF NOT EXISTS `member` (
`id` int(11) NOT NULL,
  `nis` varchar(15) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `jk` varchar(1) NOT NULL,
  `tempat_lahir` varchar(50) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `kelas` varchar(10) NOT NULL,
  `telepon` varchar(15) NOT NULL,
  `alamat` varchar(200) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`id`, `nis`, `nama`, `jk`, `tempat_lahir`, `tanggal_lahir`, `kelas`, `telepon`, `alamat`, `created_at`, `updated_at`) VALUES
(1, '123', 'Ajat Sudrajat', 'l', 'Jakarta', '2015-12-23', '3 IPA 2', '085233423211', 'Jl. MaharMeru No. 32 Bandung	', '2015-12-05 00:06:05', '2015-12-04 17:06:05');

-- --------------------------------------------------------

--
-- Table structure for table `petugas`
--

CREATE TABLE IF NOT EXISTS `petugas` (
`id` int(11) NOT NULL,
  `nip` varchar(20) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `jk` varchar(1) NOT NULL,
  `telepon` varchar(15) NOT NULL,
  `level` varchar(20) NOT NULL,
  `username` varchar(32) NOT NULL,
  `password` varchar(50) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `petugas`
--

INSERT INTO `petugas` (`id`, `nip`, `nama`, `jk`, `telepon`, `level`, `username`, `password`, `created_at`, `updated_at`) VALUES
(1, '123', 'Asep Ahmad', 'l', '081123343', 'Front Office', 'asd', 'asd', '2015-12-04 21:04:10', '2015-12-04 14:04:10'),
(3, '1234', 'Nidoran', 'p', '02384387', 'Back Office', 'asd', 'f10e2821bbbea527ea02200352313bc059445190', '2015-12-04 21:15:46', '2015-12-04 14:15:46');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `isbn` (`isbn`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `petugas`
--
ALTER TABLE `petugas`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `nip` (`nip`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `buku`
--
ALTER TABLE `buku`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `petugas`
--
ALTER TABLE `petugas`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
