-- Database untuk latihan pembuatan report Master-Detail

drop database if exists rptmasterdetail;
create database rptmasterdetail;
use rptmasterdetail;

drop table if exists T_BARANG;
drop table if exists T_KATEGORI;

-- Bikin table Master
create table T_KATEGORI(
	kd_Kategori varchar(5) not null primary key,
	nm_Kategori varchar(30) not null,
	index kd_Kategori(kd_Kategori)
) type = innodb;

-- Bikin table Detail
create table T_BARANG(
	id_Barang integer auto_increment primary key,
	kd_Barang varchar(10) not null,
	kd_Kategori varchar(5) not null,	
	nm_Barang varchar(50) not null,
	index (kd_Kategori),
	foreign key(kd_Kategori) references T_KATEGORI(kd_Kategori) on update cascade 
) type = innodb;
	
/* Proses Insert Data Table Master */
insert into T_KATEGORI(kd_Kategori, nm_Kategori) values("HAAP", "Home Application");
insert into T_KATEGORI(kd_Kategori, nm_Kategori) values("AUD", "Audio");
insert into T_KATEGORI(kd_Kategori, nm_Kategori) values("VID", "Video");

/* Proses Insert Data Table Detail */
insert into T_BARANG(kd_Barang, kd_Kategori, nm_Barang) values("1", "AUD", "MP3 Player");
insert into T_BARANG(kd_Barang, kd_Kategori, nm_Barang) values("2", "VID", "VCD Player");
insert into T_BARANG(kd_Barang, kd_Kategori, nm_Barang) values("3", "HAAP", "Kulkas");
insert into T_BARANG(kd_Barang, kd_Kategori, nm_Barang) values("4", "HAAP", "Rice Cooker");
insert into T_BARANG(kd_Barang, kd_Kategori, nm_Barang) values("5", "AUD", "iPod");
insert into T_BARANG(kd_Barang, kd_Kategori, nm_Barang) values("6", "HAAP", "Blender");
insert into T_BARANG(kd_Barang, kd_Kategori, nm_Barang) values("7", "VID", "DVD Player");
insert into T_BARANG(kd_Barang, kd_Kategori, nm_Barang) values("8", "AUD", "USB MP3 Player");
insert into T_BARANG(kd_Barang, kd_Kategori, nm_Barang) values("9", "AUD", "MP4 Player");
