/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package portingreportbeanscollection.domain;

import java.util.List;

/**
 *
 * @author martin
 */
public class Kategori {
    
    private String kd_Kategori;
    private String nm_Kategori;
    private List<Barang> listBarang;

    public String getKd_Kategori() {
        return kd_Kategori;
    }

    public void setKd_Kategori(String kd_Kategori) {
        this.kd_Kategori = kd_Kategori;
    }

    public String getNm_Kategori() {
        return nm_Kategori;
    }

    public void setNm_Kategori(String nm_Kategori) {
        this.nm_Kategori = nm_Kategori;
    }

    public List<Barang> getListBarang() {
        return listBarang;
    }

    public void setListBarang(List<Barang> listBarang) {
        this.listBarang = listBarang;
    }
}
