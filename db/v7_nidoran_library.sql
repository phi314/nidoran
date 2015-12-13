-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 14, 2015 at 12:24 
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
  `kode_buku` varchar(10) NOT NULL,
  `isbn` varchar(20) NOT NULL,
  `judul` varchar(100) NOT NULL,
  `penerbit` varchar(50) NOT NULL,
  `penulis` varchar(50) NOT NULL,
  `tahun` varchar(4) NOT NULL,
  `is_tersedia` tinyint(1) NOT NULL DEFAULT '1',
  `id_peminjaman` int(11) DEFAULT NULL,
  `id_petugas` int(11) NOT NULL,
  `is_buku_paket` tinyint(1) DEFAULT '0',
  `lokasi` varchar(10) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`id`, `kode_buku`, `isbn`, `judul`, `penerbit`, `penulis`, `tahun`, `is_tersedia`, `id_peminjaman`, `id_petugas`, `is_buku_paket`, `lokasi`, `created_at`, `updated_at`) VALUES
(1, 'PBDL1', '978', 'Dilanku', 'Pastel Books', 'Pidi Baiq', '2009', 1, NULL, 0, 0, 'B2', '2015-12-04 10:45:30', '2015-12-13 15:08:52'),
(6, 'PBDL2', '413', 'Dilanku Buku kedua', 'Pastel Books', 'Pidi Baiq', '2008', 1, NULL, 0, 0, 'B2', '2015-12-04 11:32:20', '2015-12-13 15:56:39'),
(8, 'TYP', '678', 'Pulang', 'Mizan', 'Tara Liye', '2013', 0, 20, 0, 0, 'A1', '2015-12-04 12:24:40', '2015-12-13 16:22:21'),
(9, 'MABP', '983', 'Buku Pintar', 'Neo', 'Maman Abdurrahman', '2004', 1, NULL, 0, 1, 'C1', '2015-12-04 12:27:16', '2015-12-13 15:08:59'),
(11, 'PBDMON', '435', 'Drunken Monster', 'Pastel Books', 'Pidi Baiq', '2009', 1, NULL, 0, 0, 'A1', '2015-12-04 21:32:47', '2015-12-13 15:56:39'),
(12, 'PBDMOL', '564', 'Drunken Molen', 'Pastel Books', 'Pidi Baiq', '2008', 0, 20, 3, 0, 'A1', '2015-12-05 13:05:20', '2015-12-13 16:22:21'),
(13, 'YDSB', '123', 'Biologi Bersama Komo', 'Yudistira', 'Majapahit', '1998', 1, NULL, 3, 1, 'G5', '2015-12-10 14:35:40', '2015-12-13 15:09:06');

-- --------------------------------------------------------

--
-- Table structure for table `detail_peminjaman`
--

CREATE TABLE IF NOT EXISTS `detail_peminjaman` (
`id` int(11) NOT NULL,
  `id_peminjaman` int(11) NOT NULL,
  `id_buku` int(11) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detail_peminjaman`
--

INSERT INTO `detail_peminjaman` (`id`, `id_peminjaman`, `id_buku`, `created_at`, `updated_at`) VALUES
(20, 15, 6, '2015-12-08 12:42:58', '2015-12-08 05:42:58'),
(21, 15, 11, '2015-12-08 12:42:58', '2015-12-08 05:42:58'),
(22, 15, 1, '2015-12-08 12:42:58', '2015-12-08 05:42:58'),
(23, 15, 8, '2015-12-08 12:42:58', '2015-12-08 05:42:58'),
(24, 16, 9, '2015-12-10 15:31:23', '2015-12-10 08:31:23'),
(25, 16, 13, '2015-12-10 15:31:23', '2015-12-10 08:31:23'),
(26, 17, 6, '2015-12-10 18:04:23', '2015-12-10 11:04:23'),
(27, 17, 11, '2015-12-10 18:04:23', '2015-12-10 11:04:23'),
(28, 18, 12, '2015-12-13 22:34:22', '2015-12-13 15:34:22'),
(29, 19, 12, '2015-12-13 22:36:00', '2015-12-13 15:36:00'),
(30, 19, 11, '2015-12-13 22:36:00', '2015-12-13 15:36:00'),
(31, 20, 8, '2015-12-13 23:22:21', '2015-12-13 16:22:21'),
(32, 20, 12, '2015-12-13 23:22:21', '2015-12-13 16:22:21');

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
  `id_petugas` int(11) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`id`, `nis`, `nama`, `jk`, `tempat_lahir`, `tanggal_lahir`, `kelas`, `telepon`, `alamat`, `id_petugas`, `created_at`, `updated_at`) VALUES
(1, '123', 'Ajat Sudrajat', 'l', 'Jakarta', '2015-12-23', '3 IPA 2', '085233423211', 'Jl. MaharMeru No. 32 Bandung	', 0, '2015-12-05 00:06:05', '2015-12-04 17:06:05'),
(3, '321', 'Nurmalasari', 'p', 'Balikpapan', '1992-12-12', '2 IPS 2', '085822335544', 'Di Balikpapan	', 0, '2015-12-05 00:29:40', '2015-12-04 17:29:40'),
(4, '234', 'Lela Komala', 'p', 'Bandung', '1992-05-23', '3 IPA 2', '085733625776', 'Jl. Cimindi Raya Nomor 23', 1, '2015-12-05 13:10:45', '2015-12-05 06:10:45'),
(5, '344', 'Wanda Hamdida', 'p', 'Pontianak', '1998-04-23', '3 IPS 2', '081722365788', 'Jl. Mahameru No. 4', 1, '2015-12-05 13:16:56', '2015-12-05 06:16:56'),
(6, '445', 'Adam Jordan', 'l', 'Jakarta', '1998-01-05', '3 IPA 2', '0226087553', 'Jl. Permai No. 23', 1, '2015-12-14 00:16:24', '2015-12-13 17:16:24');

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE IF NOT EXISTS `peminjaman` (
`id` int(11) NOT NULL,
  `id_petugas` int(11) NOT NULL,
  `id_member` int(11) NOT NULL,
  `tanggal` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `tanggal_kembali` datetime DEFAULT NULL,
  `total_harga` int(11) NOT NULL,
  `jumlah_buku` int(11) NOT NULL,
  `denda` int(11) NOT NULL DEFAULT '0',
  `status` enum('pinjam','kembali') NOT NULL,
  `is_peminjaman_kelas` tinyint(1) NOT NULL DEFAULT '0',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `peminjaman`
--

INSERT INTO `peminjaman` (`id`, `id_petugas`, `id_member`, `tanggal`, `tanggal_kembali`, `total_harga`, `jumlah_buku`, `denda`, `status`, `is_peminjaman_kelas`, `created_at`, `updated_at`) VALUES
(15, 1, 1, '2015-12-08 12:42:58', '2015-12-10 16:28:56', 2000, 4, 0, 'kembali', 0, '2015-12-08 12:42:58', '2015-12-10 09:28:57'),
(16, 1, 1, '2015-12-10 15:31:23', '2015-12-10 16:28:37', 2000, 2, 0, 'kembali', 1, '2015-12-10 15:31:23', '2015-12-10 09:28:39'),
(17, 1, 1, '2015-12-10 18:04:23', '2015-12-13 22:56:35', 2000, 2, 0, 'kembali', 0, '2015-12-10 18:04:23', '2015-12-13 15:56:39'),
(18, 1, 1, '2015-01-02 00:00:00', '2015-12-13 22:53:00', 2000, 1, 0, 'kembali', 1, '2015-12-13 22:34:22', '2015-12-13 15:53:03'),
(19, 1, 1, '2015-01-02 00:00:00', '2015-01-07 00:00:00', 2000, 2, 0, 'pinjam', 0, '2015-12-13 22:36:00', '2015-12-13 15:36:00'),
(20, 1, 3, '2015-12-09 00:00:00', '2015-12-20 00:00:00', 2000, 2, 0, 'pinjam', 1, '2015-12-13 23:22:21', '2015-12-13 16:22:21');

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
(1, '123', 'Asep Ahmad', 'l', '081123343', 'Front Office', 'front', '1b78eb3be0ae3f0e1963a6a98ad72bdc7365d924', '2015-12-04 21:04:10', '2015-12-04 18:00:37'),
(3, '1234', 'Nidoran', 'p', '02384387', 'Back Office', 'back', '61bb8d29b5be7db307cb29005bff087ebe300454', '2015-12-04 21:15:46', '2015-12-04 18:00:37');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `isbn` (`isbn`), ADD KEY `id_petugas` (`id_petugas`);

--
-- Indexes for table `detail_peminjaman`
--
ALTER TABLE `detail_peminjaman`
 ADD PRIMARY KEY (`id`), ADD KEY `id_peminjaman` (`id_peminjaman`,`id_buku`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
 ADD PRIMARY KEY (`id`), ADD KEY `id_petugas` (`id_petugas`);

--
-- Indexes for table `peminjaman`
--
ALTER TABLE `peminjaman`
 ADD PRIMARY KEY (`id`), ADD KEY `id_petugas` (`id_petugas`,`id_member`);

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
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `detail_peminjaman`
--
ALTER TABLE `detail_peminjaman`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=33;
--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `peminjaman`
--
ALTER TABLE `peminjaman`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `petugas`
--
ALTER TABLE `petugas`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
