/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package portingreportbeanscollection.service;

import portingreportbeanscollection.domain.Kategori;

/**
 *
 * @author martin
 */
public interface IMaster {

    public Kategori findKategoriByKode(String prmKodeKategori);

}
