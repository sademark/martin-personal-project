/*
 *  Copyright (c) 2009 Martinus Ady H <mrt.itnewbies@gmail.com>.
 *  All rights reserved.
 * 
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions
 *  are met:
 * 
 *  o Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *  o Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *  o Neither the name of the <ORGANIZATION> nor the names of its contributors
 *    may be used to endorse or promote products derived from this software
 *    without specific prior written permission.
 * 
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 *  "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 *  TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 *  PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 *  EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 *  PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 *  OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 *  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
 *  OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *  
 *  Main.java
 *  
 *  Created on Nov 8, 2009, 10:56:37 PM
 */

package id.web.martinusadyh.menulogin;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import id.web.martinusadyh.menulogin.service.LoginService;
import id.web.martinusadyh.menulogin.service.LoginServiceImpl;
import id.web.martinusadyh.menulogin.ui.LoginDialog;
import id.web.martinusadyh.menulogin.ui.MainForm;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Martinus Ady H <mrt.itnewbies@gmail.com>
 */
public class Main {

    private static MainForm mainForm;
    private static LoginService loginService;

    public static MainForm getMainForm() {
        return mainForm;
    }

    public static LoginService getLoginService() {
        return loginService;
    }

    /** Method ini akan menginisialisassi Form Utama kemudian akan melakukan
     * proses <code>loop</code> untuk menampilkan login dialog sampai nilai
     * notLogin = FALSE baru menampilkan Menu Utama */
    public static void initLogin() {
        if (mainForm == null) mainForm = new MainForm();
        boolean notLogin = Boolean.TRUE;
        while (notLogin) {
            notLogin = new LoginDialog().showDialog();
        }
        mainForm = new MainForm();
        mainForm.setVisible(true);
    }
    
    /** Method ini akan menginisialisasi object koneksi ke database yang akan 
     * digunakan di seluruh aplikasi. */
    private static void initDataBaseConnection() {
        try {
            MysqlDataSource dataSource = new MysqlDataSource();
            /* Setting koneksi ke database */
            dataSource.setUser("root");
            dataSource.setPassword("admin");
            dataSource.setDatabaseName("menulogin");
            dataSource.setServerName("localhost");
            dataSource.setPortNumber(3306);
            
            loginService = new LoginServiceImpl(dataSource.getConnection());
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        initDataBaseConnection();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                initLogin();
            }
        });
    }
}
