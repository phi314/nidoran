-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 09, 2016 at 01:46 
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
CREATE DATABASE IF NOT EXISTS `nidoran_library` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `nidoran_library`;

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE IF NOT EXISTS `buku` (
`id` int(11) NOT NULL,
  `kode_buku` varchar(20) NOT NULL,
  `isbn` varchar(20) NOT NULL,
  `judul` varchar(100) NOT NULL,
  `penerbit` varchar(50) NOT NULL,
  `penulis` varchar(50) NOT NULL,
  `tahun` varchar(4) NOT NULL,
  `kategori` varchar(100) DEFAULT NULL,
  `jenis` varchar(30) NOT NULL,
  `sumber` varchar(15) DEFAULT NULL,
  `is_tersedia` tinyint(1) NOT NULL DEFAULT '1',
  `id_peminjaman` int(11) DEFAULT NULL,
  `id_petugas` int(11) NOT NULL,
  `keterangan` varchar(20) DEFAULT '0',
  `jumlah` int(11) NOT NULL,
  `lokasi` varchar(30) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`id`, `kode_buku`, `isbn`, `judul`, `penerbit`, `penulis`, `tahun`, `kategori`, `jenis`, `sumber`, `is_tersedia`, `id_peminjaman`, `id_petugas`, `keterangan`, `jumlah`, `lokasi`, `created_at`, `updated_at`) VALUES
(1, 'BSAFRA1001', '123', 'Gaya Gerak', 'Yudistira', 'Wawan S.', '1993', 'A - IPA', 'F - Fisika', 'pembelian', 1, NULL, 3, 'Siswa', 3, 'RA1 - IPA Kelas 1', '2016-01-07 12:28:22', '2016-01-08 18:45:04'),
(2, 'BSAFRA1002', '321', 'Atomic', 'Majapahit', 'Gajahmada', '2009', 'A - IPA', 'F - Fisika', 'sumbangan', 1, NULL, 3, 'Siswa', 1, 'RA1 - IPA Kelas 1', '2016-01-07 13:41:11', '2016-01-08 18:37:46'),
(3, 'BPSSRA1001', '976', 'Bersosialisasi', 'Yudisiwa', 'Banhur', '1991', 'S - IPS', 'S - Sosiologi', 'pembelian', 1, NULL, 3, 'Paket', 2, 'RA1 - IPA Kelas 1', '2016-01-09 01:14:23', '2016-01-08 18:45:04'),
(4, 'BSUARU1003', '8839', 'Pendidikan Agama Hindu', 'Wisnu', 'Hegarmana', '2008', 'U - Umum', 'A - Agama', 'pembelian', 1, NULL, 3, 'Siswa', 2, 'RU1 - Umum Kelas 1', '2016-01-09 01:15:16', '2016-01-08 18:15:16');

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
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detail_peminjaman`
--

INSERT INTO `detail_peminjaman` (`id`, `id_peminjaman`, `id_buku`, `created_at`, `updated_at`) VALUES
(43, 28, 1, '2016-01-09 01:20:14', '2016-01-08 18:20:14'),
(44, 28, 3, '2016-01-09 01:20:14', '2016-01-08 18:20:14'),
(45, 29, 2, '2016-01-09 01:34:37', '2016-01-08 18:34:37');

-- --------------------------------------------------------

--
-- Table structure for table `jenis`
--

CREATE TABLE IF NOT EXISTS `jenis` (
`id` int(11) NOT NULL,
  `kode` varchar(5) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `kode_kategori` varchar(5) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jenis`
--

INSERT INTO `jenis` (`id`, `kode`, `nama`, `kode_kategori`) VALUES
(1, 'F', 'Fisika', 'A'),
(2, 'B', 'Biologi', 'A'),
(3, 'K', 'Kimia', 'A'),
(4, 'G', 'Geografi', 'S'),
(5, 'S', 'Sosiologi', 'S'),
(6, 'E', 'Ekonomi', 'S'),
(7, 'I', 'Indonesia', 'B'),
(8, 'E', 'Inggris', 'B'),
(9, 'J', 'Jepang', 'B'),
(10, 'S', 'Seni', 'U'),
(11, 'H', 'Hiburan', 'U'),
(12, 'A', 'Agama', 'U');

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

CREATE TABLE IF NOT EXISTS `kategori` (
`id` int(11) NOT NULL,
  `kode` varchar(10) DEFAULT NULL,
  `nama` varchar(60) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`id`, `kode`, `nama`) VALUES
(1, 'A', 'IPA'),
(2, 'S', 'IPS'),
(3, 'B', 'Bahasa'),
(4, 'U', 'Umum');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE IF NOT EXISTS `member` (
`id` int(11) NOT NULL,
  `nomor` varchar(10) NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`id`, `nomor`, `nis`, `nama`, `jk`, `tempat_lahir`, `tanggal_lahir`, `kelas`, `telepon`, `alamat`, `id_petugas`, `created_at`, `updated_at`) VALUES
(1, 'APL0116001', '123', 'Ajat Sudrajat', 'l', 'Jakarta', '2015-12-23', '3 IPA 2', '085233423211', 'Jl. MaharMeru No. 32 Bandung	', 0, '2015-12-05 00:06:05', '2016-01-08 18:33:21'),
(3, 'APP0116002', '321', 'Nurmalasari', 'p', 'Balikpapan', '1992-12-12', '2 IPS 2', '085822335544', 'Di Balikpapan	', 0, '2015-12-05 00:29:40', '2016-01-08 18:33:28'),
(4, 'APP0116003', '234', 'Lela Komala', 'p', 'Bandung', '1992-05-23', '3 IPA 2', '085733625776', 'Jl. Cimindi Raya Nomor 23', 1, '2015-11-16 13:10:45', '2016-01-08 18:33:38'),
(5, 'APP0116004', '344', 'Wanda Hamdida', 'p', 'Pontianak', '1998-04-23', '3 IPS 2', '081722365788', 'Jl. Mahameru No. 4', 1, '2015-12-05 13:16:56', '2016-01-08 18:33:46'),
(6, 'APL0116005', '445', 'Adam Jordan', 'l', 'Jakarta', '1998-01-05', '3 IPA 2', '0226087553', 'Jl. Permai No. 23', 1, '2015-12-14 00:16:24', '2016-01-08 18:33:51'),
(7, 'APP0116006', '254', 'Jenny Lockheart', 'p', 'Balikpapan', '1995-02-25', '2 IPS 2', '0356084558', 'Jl. Merdeka 23', 1, '2015-11-02 02:08:15', '2016-01-08 18:33:58'),
(8, 'APL0116007', '1923123', 'Jaka Rukmana', 'l', 'Bandung', '1991-08-23', '2 IPS 1', '022b038726', 'Jl. Leuwi Bandung', 1, '2016-01-08 23:16:19', '2016-01-08 18:33:12');

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE IF NOT EXISTS `peminjaman` (
`id` int(11) NOT NULL,
  `kode` varchar(20) NOT NULL,
  `id_petugas` int(11) NOT NULL,
  `id_member` int(11) NOT NULL,
  `tanggal` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `tanggal_kembali` datetime DEFAULT NULL,
  `tanggal_kembali_temp` date NOT NULL,
  `jangka_waktu` int(11) NOT NULL,
  `subtotal` int(11) NOT NULL,
  `jumlah_buku` int(11) NOT NULL,
  `denda` int(11) NOT NULL DEFAULT '0',
  `total_bayar` int(11) DEFAULT NULL,
  `kembali` int(11) DEFAULT NULL,
  `status` enum('pinjam','kembali') NOT NULL,
  `tipe_peminjaman` varchar(10) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `peminjaman`
--

INSERT INTO `peminjaman` (`id`, `kode`, `id_petugas`, `id_member`, `tanggal`, `tanggal_kembali`, `tanggal_kembali_temp`, `jangka_waktu`, `subtotal`, `jumlah_buku`, `denda`, `total_bayar`, `kembali`, `status`, `tipe_peminjaman`, `created_at`, `updated_at`) VALUES
(28, 'PS0116001', 1, 8, '2016-01-09 00:00:00', '2016-01-09 01:44:52', '2016-01-16', 7, 0, 2, 0, 20000, 20000, 'kembali', 'Siswa', '2016-01-09 01:20:14', '2016-01-08 18:45:04'),
(29, 'PS0116002', 1, 1, '2016-01-01 00:00:00', '2016-01-09 01:37:23', '2016-01-08', 7, 0, 1, 2000, 3000, 0, 'kembali', 'Siswa', '2016-01-09 01:34:37', '2016-01-08 18:37:46');

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
(1, '123', 'Asep Ahmad', 'l', '081123343', 'Sirkulasi', 'front', '1b78eb3be0ae3f0e1963a6a98ad72bdc7365d924', '2015-12-04 21:04:10', '2016-01-02 20:06:48'),
(3, '1234', 'Desi Komala', 'p', '02384387', 'Pengolahan', 'back', '61bb8d29b5be7db307cb29005bff087ebe300454', '2015-12-04 21:15:46', '2016-01-02 22:33:22');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `isbn` (`isbn`), ADD KEY `id_petugas` (`id_petugas`), ADD KEY `id_kategori` (`kategori`);

--
-- Indexes for table `detail_peminjaman`
--
ALTER TABLE `detail_peminjaman`
 ADD PRIMARY KEY (`id`), ADD KEY `id_peminjaman` (`id_peminjaman`,`id_buku`);

--
-- Indexes for table `jenis`
--
ALTER TABLE `jenis`
 ADD PRIMARY KEY (`id`), ADD KEY `id_kategori` (`kode_kategori`);

--
-- Indexes for table `kategori`
--
ALTER TABLE `kategori`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `nama` (`nama`);

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
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `detail_peminjaman`
--
ALTER TABLE `detail_peminjaman`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=46;
--
-- AUTO_INCREMENT for table `jenis`
--
ALTER TABLE `jenis`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `kategori`
--
ALTER TABLE `kategori`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `peminjaman`
--
ALTER TABLE `peminjaman`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=30;
--
-- AUTO_INCREMENT for table `petugas`
--
ALTER TABLE `petugas`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
