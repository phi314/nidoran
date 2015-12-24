SELECT peminjaman.*, member.nama, member.kelas
FROM peminjaman
JOIN member ON member.id=peminjaman.id
WHERE MONTH(NOW())=MONTH(peminjaman.tanggal)
ORDER BY peminjaman.kode ASC;