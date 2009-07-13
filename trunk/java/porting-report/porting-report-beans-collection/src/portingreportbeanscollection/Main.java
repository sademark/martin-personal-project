/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package portingreportbeanscollection;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import portingreportbeanscollection.domain.Barang;
import portingreportbeanscollection.domain.Kategori;
import portingreportbeanscollection.service.IMaster;
import portingreportbeanscollection.service.impl.IMasterImpl;

/**
 *
 * @author martin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setServerName("localhost");
            dataSource.setDatabaseName("rptmasterdetail");
            dataSource.setUser("root");
            dataSource.setPassword("admin");

            final IMaster imaster = new IMasterImpl(dataSource.getConnection());
            Kategori k = imaster.findKategoriByKode("HAAP");
            if (k != null) {
                System.out.println("Kode : " + k.getKd_Kategori());
                System.out.println("Nama : " + k.getNm_Kategori());
                System.out.println("JmlBrg: " + k.getListBarang().size());
                for (Barang b : k.getListBarang()) {
                    System.out.println("ID : " + b.getIdBarang() + " KODE : " + b.getKd_Barang() + " NAME : " + b.getNm_Barang());
                }

                List<Kategori> listKategori = new ArrayList<Kategori>();
                listKategori.add(k);

                /* Sudah mendapat object Kategori beserta data barangnya,
                 * sekarang siapkan parameter untuk reportnya */
                Map<String, Object> parameter = new HashMap<String, Object>();

                /* Sekarang tidak perlu lagi mencari report path, report bisa
                 * dicemplungin ke dalam jar sekalian ^_^ */
                parameter.put("SUBREPORT_DIR",
                        Main.class.getResourceAsStream(
                        "/portingreportbeanscollection/report/RptDetail.jasper"));
                
                /* Mengisi detail report */
                parameter.put("PRM_DETAIL_VALUE", k.getListBarang());

                /* Proses compilasi report */
                JasperReport jp = JasperCompileManager.compileReport(
                    Main.class.getResourceAsStream(
                    "/portingreportbeanscollection/report/RptMaster.jrxml"));

                /* Proses pengisian report dengan data */
                JasperPrint jasperPrint = JasperFillManager.fillReport(jp, parameter,
                    new JRBeanCollectionDataSource(listKategori));

                /* Sudah semua? Maka tampilkan :) */
                JasperViewer.viewReport(jasperPrint);
            }
        } catch (JRException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
