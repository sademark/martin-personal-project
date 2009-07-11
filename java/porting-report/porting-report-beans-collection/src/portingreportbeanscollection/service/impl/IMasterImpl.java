/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package portingreportbeanscollection.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import portingreportbeanscollection.domain.Barang;
import portingreportbeanscollection.domain.Kategori;
import portingreportbeanscollection.service.IMaster;

/**
 *
 * @author martin
 */
public class IMasterImpl implements IMaster {

    private Connection connection;
    private PreparedStatement sqlSearchKategoriByKode;
    private final String qrySearchKategoriByKode = 
            "select * from T_BARANG, T_KATEGORI where " +
            "T_KATEGORI.kd_Kategori = T_BARANG.kd_Kategori " +
            "AND T_KATEGORI.kd_Kategori = ?";

    public IMasterImpl(Connection connection) {
        try {
            this.connection = connection;
            sqlSearchKategoriByKode = this.connection.prepareStatement(qrySearchKategoriByKode);
        } catch (SQLException ex) {
            Logger.getLogger(IMasterImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Kategori findKategoriByKode(String prmKodeKategori) {
        Kategori resultKategori = new Kategori();
        try {
            sqlSearchKategoriByKode.setString(1, prmKodeKategori);
            ResultSet rs = sqlSearchKategoriByKode.executeQuery();
            List<Barang> listBarang = new ArrayList<Barang>();
            
            while (rs.next()) {
                resultKategori.setKd_Kategori(rs.getString("kd_Kategori"));
                resultKategori.setNm_Kategori(rs.getString("nm_Kategori"));

                /* Ambil object barang */
                Barang b = new Barang();
                b.setIdBarang(rs.getInt("id_Barang"));
                b.setKd_Barang(rs.getString("kd_Barang"));
                b.setNm_Barang(rs.getString("nm_Barang"));
                b.setKodeKategori(rs.getString("kd_Kategori"));

                /* Masukkan ke dalam list of barang */
                listBarang.add(b);
            }

            /* Tambahkan list of barang ke dalam object kategori */
            resultKategori.setListBarang(listBarang);
        } catch (SQLException ex) {
            Logger.getLogger(IMasterImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultKategori;
    }
}
