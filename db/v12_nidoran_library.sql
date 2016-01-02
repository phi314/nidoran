-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 03, 2016 at 06:00 
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
  `kode_buku` varchar(10) NOT NULL,
  `isbn` varchar(20) NOT NULL,
  `judul` varchar(100) NOT NULL,
  `penerbit` varchar(50) NOT NULL,
  `penulis` varchar(50) NOT NULL,
  `tahun` varchar(4) NOT NULL,
  `kategori` varchar(100) DEFAULT NULL,
  `sumber` varchar(15) DEFAULT NULL,
  `is_tersedia` tinyint(1) NOT NULL DEFAULT '1',
  `id_peminjaman` int(11) DEFAULT NULL,
  `id_petugas` int(11) NOT NULL,
  `is_buku_paket` tinyint(1) DEFAULT '0',
  `lokasi` varchar(10) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`id`, `kode_buku`, `isbn`, `judul`, `penerbit`, `penulis`, `tahun`, `kategori`, `sumber`, `is_tersedia`, `id_peminjaman`, `id_petugas`, `is_buku_paket`, `lokasi`, `created_at`, `updated_at`) VALUES
(1, '800/001', '978', 'Dilanku', 'Pastel Books', 'Pidi Baiq', '2009', '800 - Kesusasteraan\r\n', '', 1, NULL, 0, 0, 'Bahasa', '2015-12-04 10:45:30', '2016-01-02 21:34:06'),
(6, '800/002', '413', 'Dilanku Buku kedua', 'Pastel Books', 'Pidi Baiq', '2008', '800 - Kesusasteraan\r\n', '', 1, NULL, 0, 0, 'Bahasa', '2015-12-04 11:32:20', '2016-01-02 21:34:46'),
(8, '233.7/001', '678', 'Pulang', 'Mizan', 'Tara Liye', '2013', '233.7 - Kebebasan Memilih antara yang Baik dan Jahat\r\n', '', 1, NULL, 0, 0, 'IPA', '2015-12-04 12:24:40', '2016-01-02 21:32:31'),
(9, '010/001', '983', 'Buku Pintar', 'Neo', 'Maman Abdurrahman', '2004', '030 - Ensiklopedia Umum\r\n', '', 0, 26, 0, 1, 'IPA', '2015-12-04 12:27:16', '2016-01-02 21:33:16'),
(11, '800/004', '435', 'Drunken Monster', 'Pastel Books', 'Pidi Baiq', '2009', '800 - Kesusasteraan\r\n', '', 1, NULL, 0, 0, 'Bahasa', '2015-12-04 21:32:47', '2016-01-02 21:35:29'),
(12, '800/003', '564', 'Drunken Molen', 'Pastel Books', 'Pidi Baiq', '2008', '800 - Kesusasteraan\r\n', '', 1, NULL, 3, 0, 'Bahasa', '2015-12-05 13:05:20', '2016-01-02 21:34:59'),
(13, '233.5/001', '123', 'Biologi Bersama Komo', 'Yudistira', 'Majapahit', '1999', '233.5 - Hakikat\r\n', '', 1, NULL, 3, 1, 'IPA', '2015-12-10 14:35:40', '2016-01-02 22:19:16'),
(14, '070/001', '112', 'Kamus Besar Bahasa Sunda', 'Mangle', 'Jajang S', '1991', '070 - Jurnalistik dan Penerbitan\r\n', '', 1, NULL, 3, 0, 'IPA', '2015-12-28 16:32:11', '2016-01-02 21:32:02'),
(18, '310/002', '333', 'Statistika Dasar 3', 'Binus', 'Adam Sahdan', '2003', '310 - Statistika\r\n', 'sumbangan', 1, NULL, 3, 0, 'IPS', '2016-01-03 04:36:53', '2016-01-02 21:40:00'),
(20, '330/001', '849', 'Hukum IHSG', 'Mine', 'Marshall Mathers', '2008', '330 - Ekonomi\r\n', 'pembelian', 1, NULL, 3, 0, 'IPS', '2016-01-03 04:39:40', '2016-01-02 21:39:40');

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
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detail_peminjaman`
--

INSERT INTO `detail_peminjaman` (`id`, `id_peminjaman`, `id_buku`, `created_at`, `updated_at`) VALUES
(36, 23, 8, '2015-12-16 22:08:05', '2015-12-16 15:08:05'),
(37, 24, 12, '2015-12-18 23:02:49', '2015-12-18 16:02:49'),
(38, 24, 11, '2015-12-18 23:02:49', '2015-12-18 16:02:49'),
(39, 25, 8, '2015-12-18 23:10:31', '2015-12-18 16:10:31'),
(40, 26, 9, '2015-12-18 23:12:08', '2015-12-18 16:12:08');

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

CREATE TABLE IF NOT EXISTS `kategori` (
`id` int(11) NOT NULL,
  `kode` varchar(10) DEFAULT NULL,
  `nama` varchar(60) NOT NULL,
  `id_petugas` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=282 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`id`, `kode`, `nama`, `id_petugas`) VALUES
(1, '000', 'Umum\r\n', 3),
(2, '010', 'Bibliografi dan Katalog\r\n', 3),
(3, '020', 'Ilmu Kepustakaan\r\n', 3),
(4, '030', 'Ensiklopedia Umum\r\n', 3),
(5, '050', 'Serials/Jurnal\r\n', 3),
(6, '060', 'Organisasi Umum dan Ilmu tentang Musium\r\n', 3),
(7, '070', 'Jurnalistik dan Penerbitan\r\n', 3),
(8, '080', 'Koleksi Umum (esai, kutipan, wawancara, kuliah, dll)\r\n', 3),
(9, '090', 'Manuskrip dan Buku Langka\r\n', 3),
(10, '100', 'Filsafat\r\n', 3),
(11, '110', 'Metafisika\r\n', 3),
(12, '120', 'Epistemologi\r\n', 3),
(13, '130', 'Fenomena Paranormal\r\n', 3),
(14, '140', 'Pandangan Filsafat tertentu\r\n', 3),
(15, '150', 'Psikologi\r\n', 3),
(16, '160', 'Logika\r\n', 3),
(17, '170', 'Etika\r\n', 3),
(18, '180', 'Filsafat Kuno, Abad Pertengahan & Timur\r\n', 3),
(19, '190', 'Filsafat Barat Modern\r\n', 3),
(20, '200', 'Agama Kristen\r\n', 3),
(21, '210', 'Filsafat & Teori Agama\r\n', 3),
(22, '220', 'Alkitab (subdivisi standard)\r\n', 3),
(23, '221', 'Perjanjian Lama\r\n', 3),
(24, '222', 'Kitab-kitab Taurat\r\n', 3),
(25, '223', 'Kitab-kitab Sastra\r\n', 3),
(26, '224', 'Kitab-kitab Nubuat\r\n', 3),
(27, '225', 'Perjanjian Baru\r\n', 3),
(28, '226', 'Injil dan Kisah Para Rasul\r\n', 3),
(29, '227', 'Surat-surat\r\n', 3),
(30, '228', 'Wahyu\r\n', 3),
(31, '229', 'Apokrifa, Pseudepigrafa & Karya-karya antar Perjanjian\r\n', 3),
(32, '230', 'Teologi Kristen\r\n', 3),
(33, '231', 'Allah\r\n', 3),
(34, '231.1', 'Allah Bapa\r\n', 3),
(35, '231.2', 'Allah Anak\r\n', 3),
(36, '231.3', 'Allah Roh Kudus\r\n', 3),
(37, '231.4', 'Sifat\r\n', 3),
(38, '231.5', 'Pemeliharaan\r\n', 3),
(39, '231.6', 'Cinta Kasih dan Kebijaksanaan\r\n', 3),
(40, '231.7', 'Hubungan dengan Dunia; Kehendak Allah\r\n', 3),
(41, '231.8', 'Keadilan dan Kebaikan\r\n', 3),
(42, '232', 'Yesus Kristus (Kristologi)\r\n', 3),
(43, '232.1', 'Inkarnasi dan Kemesiasan Kristus\r\n', 3),
(44, '232.2', 'Kristus sebagai Logos\r\n', 3),
(45, '232.3', 'Kristus sebagai Penebus\r\n', 3),
(46, '232.4', 'Pengorbanan Kristus\r\n', 3),
(47, '232.5', 'Kebangkitan Kristus\r\n', 3),
(48, '232.8', 'Keilahian dan Kemanusiaan Kristus\r\n', 3),
(49, '232.9', 'Keluarga dan Kehidupan Kristus\r\n', 3),
(50, '233', 'Manusia\r\n', 3),
(51, '233.1', 'Penciptaan dan Kejatuhan Manusia dalam Dosa\r\n', 3),
(52, '233.2', 'Dosa\r\n', 3),
(53, '233.4', 'Rasa Bersalah\r\n', 3),
(54, '233.5', 'Hakikat\r\n', 3),
(55, '233.7', 'Kebebasan Memilih antara yang Baik dan Jahat\r\n', 3),
(56, '234', 'Keselamatan (Soteriologi) dan Anugerah\r\n', 3),
(57, '235', 'Makhluk-makhluk Roh\r\n', 3),
(58, '236', 'Eskatologi\r\n', 3),
(59, '237', 'Roh Kudus\r\n', 3),
(60, '238', 'Pengakuan Iman\r\n', 3),
(61, '239', 'Apologetika dan Polemik\r\n', 3),
(62, '240', 'Moral Kristen & Teologi Devosi\r\n', 3),
(63, '241', 'Teologi Moral\r\n', 3),
(64, '242', 'Literatur Devosi\r\n', 3),
(65, '243', 'Karya-karya Penginjilan untuk Pribadi dan Keluarga\r\n', 3),
(66, '244', 'Teologi Feminis\r\n', 3),
(67, '246', 'Penggunaan Seni dalam Kristen\r\n', 3),
(68, '246.7', 'Drama, Seni Musik & Ritme\r\n', 3),
(69, '246.9', 'Arsitektur\r\n', 3),
(70, '247', 'Perlengkapan Gereja\r\n', 3),
(71, '248', 'Kehidupan dan Praktek Hidup Kekristenan\r\n', 3),
(72, '248.2', 'Pengalaman Rohani\r\n', 3),
(73, '248.22', 'Mistisisme\r\n', 3),
(74, '248.24', 'Pertobatan dan Pindah Agama\r\n', 3),
(75, '248.25', 'Pembaruan Moral dan Komitmen\r\n', 3),
(76, '248.29', 'Pengalaman Rohani lainnya (stigmata/dll)\r\n', 3),
(77, '248.3', 'Ibadah\r\n', 3),
(78, '248.32', 'Doa\r\n', 3),
(79, '248.34', 'Meditasi dan Kontemplasi\r\n', 3),
(80, '248.4', 'Kehidupan Kristen (Kepemimpinan, Keluarga)\r\n', 3),
(81, '248.46', 'Peringatan/perayaan Individual\r\n', 3),
(82, '248.47', 'Asketisme\r\n', 3),
(83, '248.48', 'Bimbingan Hidup Kristen per Denominasi\r\n', 3),
(84, '248.5', 'Kesaksian\r\n', 3),
(85, '248.6', 'Jabatan Gereja\r\n', 3),
(86, '248.8', 'Bimbingan untuk orang-orang khusus\r\n', 3),
(87, '248.82', 'Anak\r\n', 3),
(88, '248.83', 'Remaja dan Pelajar\r\n', 3),
(89, '248.84', 'Dewasa\r\n', 3),
(90, '248.85', 'Lanjut Usia\r\n', 3),
(91, '248.86', 'Orang Sakit, Susah, Duka\r\n', 3),
(92, '248.87', 'Orang-orang berprofesi tertentu\r\n', 3),
(93, '248.89', 'Kaum Rohaniwan\r\n', 3),
(94, '249', 'Ibadah dalam Keluarga\r\n', 3),
(95, '250', 'Gereja Lokal dan Ordo Kristen\r\n', 3),
(96, '251', 'Khotbah\r\n', 3),
(97, '252', 'Teks Khotbah\r\n', 3),
(98, '253', 'Pekerjaan Pendeta (Teologi Pastoral)\r\n', 3),
(99, '254', 'Administrasi Jemaat\r\n', 3),
(100, '255', 'Konggregasi dan Ordo\r\n', 3),
(101, '259', 'Kegiatan Pastoral untuk Keluarga/Orang tertentu\r\n', 3),
(102, '260', 'Teologi Sosial dan Teologi Eklesiastikal\r\n', 3),
(103, '261', 'Teologi Sosial & Hubungan antar Agama\r\n', 3),
(104, '262', 'Eklesiologi\r\n', 3),
(105, '263', 'Hari Raya Kristen dan Tempat Sucinya\r\n', 3),
(106, '264', 'Ibadah Umum\r\n', 3),
(107, '265', 'Sakramen dan Upacara lain\r\n', 3),
(108, '266', 'Misi\r\n', 3),
(109, '267', 'Perkumpulan untuk Pekerjaan Keagamaan\r\n', 3),
(110, '268', 'Pendidikan Kristen\r\n', 3),
(111, '269', 'Pembaharuan Rohani\r\n', 3),
(112, '270', 'Sejarah Gereja\r\n', 3),
(113, '276', 'Sejarah Gereja di Indonesia\r\n', 3),
(114, '280', 'Denominasi dan Sekte\r\n', 3),
(115, '290', 'Perbandingan Agama dan Agama-agama Non Kristen\r\n', 3),
(116, '291', 'Perbandingan Agama\r\n', 3),
(117, '292', 'Agama-agama Yunani dan Roma Klasik\r\n', 3),
(118, '293', 'Agama Jerman\r\n', 3),
(119, '294', 'Agama yang berasal dari India\r\n', 3),
(120, '295', 'Zoroastrianisme\r\n', 3),
(121, '296', 'Yudaisme\r\n', 3),
(122, '297', 'Islam\r\n', 3),
(123, '299', 'Agama-agama lain\r\n', 3),
(124, '300', 'Ilmu Sosial\r\n', 3),
(125, '301', 'Sosiologi dan Antropologi\r\n', 3),
(126, '302', 'Hubungan Sosial\r\n', 3),
(127, '303', 'Proses Sosial\r\n', 3),
(128, '304', 'Faktor-faktor Perilaku Sosial\r\n', 3),
(129, '304.2', 'Ekologi Manusia\r\n', 3),
(130, '304.5', 'Faktor Genetika\r\n', 3),
(131, '304.6', 'Populasi\r\n', 3),
(132, '304.8', 'Migrasi\r\n', 3),
(133, '305', 'Kelompok Sosial\r\n', 3),
(134, '306', 'Kebudayaan dan Lembaga-lembaga\r\n', 3),
(135, '307', 'Masyarakat\r\n', 3),
(136, '307.1', 'Perencanaan dan Pembangunan\r\n', 3),
(137, '307.2', 'Migrasi antar komunitas\r\n', 3),
(138, '307.3', 'Struktur\r\n', 3),
(139, '307.6', 'Sosiologi Industri\r\n', 3),
(140, '307.7', 'Jenis Komunitas\r\n', 3),
(141, '307.72', 'Pedesaan\r\n', 3),
(142, '307.74', 'Sub-urban\r\n', 3),
(143, '307.76', 'Kota\r\n', 3),
(144, '310', 'Statistika\r\n', 3),
(145, '320', 'Ilmu Politik\r\n', 3),
(146, '330', 'Ekonomi\r\n', 3),
(147, '340', 'Hukum\r\n', 3),
(148, '350', 'Ilmu Administrasi Umum dan Militer\r\n', 3),
(149, '360', 'Masalah Sosial dan Pelayanannya\r\n', 3),
(150, '361', 'Masalah & Kesejahteraan Sosial\r\n', 3),
(151, '362', 'Masalah Kesejahteraan Sosial & Pelayanannya\r\n', 3),
(152, '363', 'Masalah Sosial lainnya\r\n', 3),
(153, '363.49', 'Homoseksual\r\n', 3),
(154, '364', 'Kriminologi\r\n', 3),
(155, '365', 'Lembaga Pemasyarakatan\r\n', 3),
(156, '366', 'Asosiasi Sosial\r\n', 3),
(157, '367', 'Klub Umum\r\n', 3),
(158, '368', 'Asuransi\r\n', 3),
(159, '369', 'Berbagai Asosiasi\r\n', 3),
(160, '370', 'Pendidikan\r\n', 3),
(161, '371', 'Sekolah\r\n', 3),
(162, '372', 'Pendidikan Dasar\r\n', 3),
(163, '373', 'Pendidikan Menengah\r\n', 3),
(164, '374', 'Pendidikan Orang Dewasa\r\n', 3),
(165, '375', 'Kurikulum\r\n', 3),
(166, '376', 'Pendidikan Tinggi\r\n', 3),
(167, '379', 'Kebijakan dalam Pendidikan\r\n', 3),
(168, '400', 'Bahasa\r\n', 3),
(169, '410', 'Bahasa Indonesia\r\n', 3),
(170, '420', 'Bahasa Inggris\r\n', 3),
(171, '430', 'Bahasa Jerman\r\n', 3),
(172, '440', 'Bahasa Perancis\r\n', 3),
(173, '450', 'Bahasa Italia\r\n', 3),
(174, '460', 'Bahasa Ibrani\r\n', 3),
(175, '470', 'Bahasa Latin\r\n', 3),
(176, '480', 'Bahasa Yunani\r\n', 3),
(177, '490', 'Bahasa lainnya\r\n', 3),
(178, '500', 'Ilmu Murni\r\n', 3),
(179, '510', 'Matematika\r\n', 3),
(180, '520', 'Astronomi\r\n', 3),
(181, '530', 'Fisika\r\n', 3),
(182, '540', 'Kimia\r\n', 3),
(183, '550', 'Geologi\r\n', 3),
(184, '560', 'Paleontologi\r\n', 3),
(185, '570', 'Ilmu tentang Kehidupan\r\n', 3),
(186, '580', 'Ilmu tentang Tumbuh-tumbuhan\r\n', 3),
(187, '590', 'Zoologi\r\n', 3),
(188, '600', 'Ilmu Terapan\r\n', 3),
(189, '610', 'Ilmu Kedokteran\r\n', 3),
(190, '620', 'Ilmu Teknik\r\n', 3),
(191, '630', 'Ilmu Pertanian\r\n', 3),
(192, '640', 'Kesejahteraan Keluarga\r\n', 3),
(193, '650', 'Manajemen\r\n', 3),
(194, '660', 'Teknologi Kimia\r\n', 3),
(195, '670', 'Perindustrian/Manufaktur\r\n', 3),
(196, '680', 'Manufaktur Barang-barang Khusus\r\n', 3),
(197, '690', 'Gedung\r\n', 3),
(198, '700', 'Kesenian\r\n', 3),
(199, '710', 'Tata Kota & Pertamanan\r\n', 3),
(201, '730', 'Seni Pahat\r\n', 3),
(202, '740', 'Seni Gambar & Dekorasi\r\n', 3),
(203, '750', 'Seni Lukis\r\n', 3),
(204, '760', 'Seni Cetak/Grafika\r\n', 3),
(205, '770', 'Seni Potret/Fotografi\r\n', 3),
(206, '780', 'Musik\r\n', 3),
(207, '781', 'Prinsip-prinsip Umum dan Bentuk Musik\r\n', 3),
(208, '782', 'Musik Vokal\r\n', 3),
(209, '783', 'Musik untuk Suara Tunggal (Solo)\r\n', 3),
(210, '784', 'Instrumen dan Ensamble\r\n', 3),
(211, '785', 'Ensamble dgn hanya 1 instrumen per bagiannya\r\n', 3),
(212, '786', 'Instrumen Keyboard, Elektronik, dan Perkusi\r\n', 3),
(213, '787', 'Instrumen Bersenar\r\n', 3),
(214, '788', 'Instrumen Tiup\r\n', 3),
(215, '789', 'Penggubah dan Tradisi-tradisi Musik\r\n', 3),
(216, '790', 'Seni Rekreasi dan Pertunjukkan\r\n', 3),
(217, '800', 'Kesusasteraan\r\n', 3),
(219, '811', 'Puisi Indonesia\r\n', 3),
(220, '812', 'Drama Indonesia\r\n', 3),
(221, '813', 'Fiksi Indonesia\r\n', 3),
(222, '814', 'Esai Indonenesia\r\n', 3),
(223, '815', 'Pidato Indonesia\r\n', 3),
(224, '816', 'Surat-surat Indonesia\r\n', 3),
(225, '817', 'Satir&Humor Indonesia\r\n', 3),
(226, '818', 'Penulis Indonesia\r\n', 3),
(227, '819', 'KesusasTeraan Bahasa Daareah Indonesia\r\n', 3),
(228, '820', 'Sastra Inggris\r\n', 3),
(229, '830', 'Sasrtra Jerman\r\n', 3),
(230, '840', 'Sastra Prancis\r\n', 3),
(231, '850', 'Sastra Spanyol\r\n', 3),
(232, '860', 'Sastra Ibrani\r\n', 3),
(233, '870', 'Sastra latin\r\n', 3),
(234, '880', 'Sastra Yunani\r\n', 3),
(235, '890', 'Sastra Bahasa lain\r\n', 3),
(236, '900', 'ILMU BUMI DAN SEJARAH\r\n', 3),
(237, '910', 'Geografi Umum\r\n', 3),
(238, '920', 'Biografi/Geneologi\r\n', 3),
(239, '921', 'Giografi Filsuf & Psikolog\r\n', 3),
(240, '922', 'Biografi Rohaniwan/Teolog\r\n', 3),
(241, '923', 'Biografi Ilmuwan Sosial\r\n', 3),
(242, '928', 'Biografi Sastrawan, Sejarahwan, dll\r\n', 3),
(243, '930', 'Sejarah Dunia Kuno sampai tahun 499\r\n', 3),
(244, '931', 'Sejarah Cina sampai tahun 420\r\n', 3),
(245, '932', 'Sejarah Mesir sampai tahun 640\r\n', 3),
(246, '933', 'Sejarah Palestina sampai tahu 70\r\n', 3),
(247, '934', 'Sejarah India sampai tahun 647\r\n', 3),
(248, '935', 'Sejarah Mesopotamia & Iran sampai tahun 637\r\n', 3),
(249, '936', 'Sejarah Eropa Utara & Barat sampai tahun 499\r\n', 3),
(250, '937', 'Sejarah Italia sampai tahun 476\r\n', 3),
(251, '938', 'Sejarah Yunani sampai tahun 323\r\n', 3),
(252, '939', 'Bagian dunia lainnya sampai tahun 640\r\n', 3),
(253, '940', 'Sejarah Eropa Barat\r\n', 3),
(254, '950', 'Sejarah Asia\r\n', 3),
(255, '951', 'Sejarah Cina\r\n', 3),
(256, '952', 'Sejarah Jepang\r\n', 3),
(257, '953', 'Sejarah Semenanjung Arab\r\n', 3),
(258, '954', 'Sejarah India\r\n', 3),
(259, '955', 'Sejarah Iran\r\n', 3),
(260, '956', 'Sejarah Timur Tengah\r\n', 3),
(261, '957', 'Sejarah Siberia\r\n', 3),
(262, '958', 'Sejarah Asia Tengah\r\n', 3),
(263, '959', 'Sejarah Asia Tenggara\r\n', 3),
(264, '959.1', 'Myanmar\r\n', 3),
(265, '959.3', 'Thailand\r\n', 3),
(266, '959.4', 'Laos\r\n', 3),
(267, '959.5', 'Malaysia\r\n', 3),
(268, '959.6', 'Kamboja\r\n', 3),
(269, '959.7', 'Vietnam\r\n', 3),
(270, '959.8', 'Indonesia :\r\n', 3),
(271, '959.81', 'Zaman Purba s/d tahun 1478\r\n', 3),
(272, '959.82', 'Zaman Penjajahan Belanda 1602-1945\r\n', 3),
(273, '959.83', 'Zaman Republik, 1945-sekarang\r\n', 3),
(274, '959.9', 'Filipina\r\n', 3),
(275, '960', 'Sejarah Afrika\r\n', 3),
(276, '970', 'Sejarah Amerika Utara\r\n', 3),
(277, '971', 'Sejarah Kanada\r\n', 3),
(278, '972', 'Sejarah Amerika Tengah - Meksiko\r\n', 3),
(279, '973', 'Sejarah Amerika Serikat\r\n', 3),
(280, '980', 'Sejarah Amerika Selatan\r\n', 3),
(281, '990', 'Sejarah bagian Dunia lainnya (termasuk kepulauan Pasifik)\r\n', 3);

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`id`, `nomor`, `nis`, `nama`, `jk`, `tempat_lahir`, `tanggal_lahir`, `kelas`, `telepon`, `alamat`, `id_petugas`, `created_at`, `updated_at`) VALUES
(1, 'AP001', '123', 'Ajat Sudrajat', 'l', 'Jakarta', '2015-12-23', '3 IPA 2', '085233423211', 'Jl. MaharMeru No. 32 Bandung	', 0, '2015-12-05 00:06:05', '2015-12-13 18:53:20'),
(3, 'AP002', '321', 'Nurmalasari', 'p', 'Balikpapan', '1992-12-12', '2 IPS 2', '085822335544', 'Di Balikpapan	', 0, '2015-12-05 00:29:40', '2015-12-13 18:53:24'),
(4, 'AP003', '234', 'Lela Komala', 'p', 'Bandung', '1992-05-23', '3 IPA 2', '085733625776', 'Jl. Cimindi Raya Nomor 23', 1, '2015-11-16 13:10:45', '2015-12-24 12:13:18'),
(5, 'AP004', '344', 'Wanda Hamdida', 'p', 'Pontianak', '1998-04-23', '3 IPS 2', '081722365788', 'Jl. Mahameru No. 4', 1, '2015-12-05 13:16:56', '2015-12-13 18:53:29'),
(6, 'AP005', '445', 'Adam Jordan', 'l', 'Jakarta', '1998-01-05', '3 IPA 2', '0226087553', 'Jl. Permai No. 23', 1, '2015-12-14 00:16:24', '2015-12-13 18:53:33'),
(7, 'AP006', '254', 'Jenny Lockheart', 'p', 'Balikpapan', '1995-02-25', '2 IPS 2', '0356084558', 'Jl. Merdeka 23', 1, '2015-11-02 02:08:15', '2015-12-24 12:13:11');

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
  `subtotal` int(11) NOT NULL,
  `jumlah_buku` int(11) NOT NULL,
  `denda` int(11) NOT NULL DEFAULT '0',
  `total_bayar` int(11) DEFAULT NULL,
  `kembali` int(11) DEFAULT NULL,
  `status` enum('pinjam','kembali') NOT NULL,
  `is_peminjaman_kelas` tinyint(1) NOT NULL DEFAULT '0',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `peminjaman`
--

INSERT INTO `peminjaman` (`id`, `kode`, `id_petugas`, `id_member`, `tanggal`, `tanggal_kembali`, `subtotal`, `jumlah_buku`, `denda`, `total_bayar`, `kembali`, `status`, `is_peminjaman_kelas`, `created_at`, `updated_at`) VALUES
(23, 'PS001', 1, 6, '2015-12-16 00:00:00', '2015-12-16 22:09:35', 2000, 1, 0, 2000, 0, 'kembali', 0, '2015-12-16 22:08:05', '2015-10-05 14:55:57'),
(24, 'PS002', 1, 7, '2015-12-18 00:00:00', '2015-12-18 23:12:17', 0, 2, 0, 0, 0, 'kembali', 0, '2015-12-18 23:02:49', '2015-12-18 16:12:39'),
(25, 'PS003', 1, 6, '2015-12-10 00:00:00', '2015-12-18 23:12:45', 0, 1, 2000, 2000, 0, 'kembali', 0, '2015-12-18 23:10:31', '2015-12-18 16:13:55'),
(26, 'PS004', 1, 6, '2015-12-18 00:00:00', '2015-12-25 00:00:00', 0, 1, 0, NULL, NULL, 'pinjam', 0, '2015-12-18 23:12:08', '2015-12-18 16:12:08');

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
-- Indexes for table `kategori`
--
ALTER TABLE `kategori`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `nama` (`nama`), ADD KEY `id_petugas` (`id_petugas`);

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
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `detail_peminjaman`
--
ALTER TABLE `detail_peminjaman`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=41;
--
-- AUTO_INCREMENT for table `kategori`
--
ALTER TABLE `kategori`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=282;
--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `peminjaman`
--
ALTER TABLE `peminjaman`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=27;
--
-- AUTO_INCREMENT for table `petugas`
--
ALTER TABLE `petugas`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
