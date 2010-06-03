README 
========================

Persiapan yang harus dilakukan sebelum menjalankan contoh TableIndexHibernate :
1. Buat database dengan nama lat_hibernate dengan cara sbb :
mysql> create database lat_hibernate;

Catatan :
- username database : root
- password database : root
- File konfigurasi ada di file jdbc.properties

2. Masuk dahulu ke direktori TableIndexHibernate kemudian jalankan aplikasinya dengan perintah sebagai berikut :

martinus@martinusadyh:[~/Desktop/TableIndexHibernate]$ java -jar dist/*.jar
...............
...............
...............
02:22:04.133 [main] DEBUG o.s.b.f.s.DefaultListableBeanFactory - Returning cached instance of singleton bean 'lifecycleProcessor'
martinus@martinusadyh:[~/Desktop/TableIndexHibernate]$

3. Sekarang cek di MySQL apakah index sudah dibuat atau belum dengan perintah seperti dibawah ini :

mysql> show create table master_buku\G
*************************** 1. row ***************************
       Table: master_buku
Create Table: CREATE TABLE `master_buku` (
  `id` bigint(20) NOT NULL auto_increment,
  `kategori` varchar(255) default NULL,
  `nama_pengarang` varchar(255) default NULL,
  `nomor_seri` varchar(255) default NULL,
  `penerbit` varchar(255) default NULL,
  `tanggal_masuk` date default NULL,
  PRIMARY KEY  (`id`),
  KEY `nama_pengarang` (`nama_pengarang`),
  KEY `nomor_seri` (`nomor_seri`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1
1 row in set (0.00 sec)

mysql> show index from master_buku;
+-------------+------------+----------------+--------------+----------------+-----------+-------------+----------+--------+------+------------+---------+
| Table       | Non_unique | Key_name       | Seq_in_index | Column_name    | Collation | Cardinality | Sub_part | Packed | Null | Index_type | Comment |
+-------------+------------+----------------+--------------+----------------+-----------+-------------+----------+--------+------+------------+---------+
| master_buku |          0 | PRIMARY        |            1 | id             | A         |           0 |     NULL | NULL   |      | BTREE      |         | 
| master_buku |          1 | nama_pengarang |            1 | nama_pengarang | A         |           0 |     NULL | NULL   | YES  | BTREE      |         | 
| master_buku |          1 | nomor_seri     |            1 | nomor_seri     | A         |           0 |     NULL | NULL   | YES  | BTREE      |         | 
+-------------+------------+----------------+--------------+----------------+-----------+-------------+----------+--------+------+------------+---------+
3 rows in set (0.00 sec)

mysql> 

Tutorial bisa diakses di :
- http://martinusadyh.web.id/2010/06/04/table-index-on-hibernate/
