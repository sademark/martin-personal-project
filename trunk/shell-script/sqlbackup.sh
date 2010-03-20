#
# sqlbackup.sh
#      
# Copyright 2009 martin <mrt.itnewbies@gmail.com>
#      
# This program is free software; you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation; either version 2 of the License, or
# (at your option) any later version.
#      
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License for more details.
#      
# You should have received a copy of the GNU General Public License
# along with this program; if not, write to the Free Software
# Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
# MA 02110-1301, USA.
#########################################################################
#!/bin/sh

VERSION="1.0"
DBNAME=""
DBUSER=""
DBPASS=""
SAVEDIR=`pwd`

# Help sqlbackup script
usage() {
	echo "sqlbackup $VERSION is utility for backup and compressing sql"
	echo "Usage: $0 -u <database user> -p <database password> -B <database name> -d <save dir>"
	echo "Supported parameter :"
	echo " -h                   : Show help messages"
	echo " -u  <database user>  : Database username"
	echo " -p  <db password>    : Database password"
	echo " -B <database name>   : Pilih DataBase Yang Ingin DiBackup"
	echo " -d  <save directory> : Lokasi penyimpanan file backup, jika"
	echo "                        tanpa parameter direktori sekarang yg"
	echo "                        akan digunakan (.)"
	echo " "
	exit 1
}

# Parse the commandline options:
while getopts ":h:u:p:B:d:" Option
do
    case $Option in
    u ) DBUSER="$2"	
        ;;
    p ) DBPASS="$4"
        ;;
    B ) DBNAME="$6"
        ;;
    d ) SAVEDIR="$8"
        ;;
    h|* ) usage
        ;;
    : ) echo "Option -$OPTARG requires an argument" >&2
		exit 1
		;;
    \?)
      echo "Invalid option: -$OPTARG" >&2
      exit 1
      ;;
  esac
done

# End of option parsing.
shift $(($OPTIND - 1))

BACKUPTIME=`date +%Y%m%d`
BACKUPNAME=backup-$DBNAME-$BACKUPTIME.sql
SQLBACKUP=$SAVEDIR/$BACKUPNAME

# echo "DBUSER = $DBUSER, DBPASS = $DBPASS, DBNAME = $DBNAME, SAVEDIR = $SAVEDIR"

# Connecting to MySQL Server
mysqldump -B $DBNAME -u $DBUSER -p$DBPASS --complete-insert > $SQLBACKUP || exit
SIZEDUMP=`du -h $SQLBACKUP`
echo "Creating backup $SIZEDUMP "
echo "Compressing $SQLBACKUP"

cd $SAVEDIR
tar cjvf backup-$DBNAME-$BACKUPTIME.tar.bz2 $BACKUPNAME || exit
SIZETARBZ=`du -h backup-$DBNAME-$BACKUPTIME.tar.bz2`
echo "Done creating backup"
echo "$SIZEDUMP"
echo "$SIZETARBZ"

