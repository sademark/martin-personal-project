/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package portingreportbeanscollection.domain;

/**
 *
 * @author martin
 */
public class Barang {

    private Integer idBarang;
    private String kd_Barang;
    private String kodeKategori;
    private String nm_Barang;

    public Integer getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(Integer idBarang) {
        this.idBarang = idBarang;
    }

    public String getKd_Barang() {
        return kd_Barang;
    }

    public void setKd_Barang(String kd_Barang) {
        this.kd_Barang = kd_Barang;
    }

    public String getKodeKategori() {
        return kodeKategori;
    }

    public void setKodeKategori(String kodeKategori) {
        this.kodeKategori = kodeKategori;
    }

    public String getNm_Barang() {
        return nm_Barang;
    }

    public void setNm_Barang(String nm_Barang) {
        this.nm_Barang = nm_Barang;
    }
}
