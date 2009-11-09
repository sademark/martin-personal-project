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
 *  LoginServiceImpl.java
 *  
 *  Created on Nov 8, 2009, 11:07:12 PM
 */

package id.web.martinusadyh.menulogin.service;

import id.web.martinusadyh.menulogin.domain.UserApp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martinus Ady H <mrt.itnewbies@gmail.com>
 */
public class LoginServiceImpl implements LoginService {

    private Connection connection;
    private PreparedStatement findUserByUserAndPassword;
    private final String QRY_LOGIN = "select * from T_USER where" +
            " T_USER.username = ? and T_USER.password = ?";

    public LoginServiceImpl(Connection connection) {
        try {
            this.connection = connection;
            findUserByUserAndPassword = this.connection.prepareStatement(QRY_LOGIN);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public UserApp login(String username, String password) {
        try {
            /* Lakukan pencarian berdasarkan username dan password */
            findUserByUserAndPassword.setString(1, username);
            findUserByUserAndPassword.setString(2, password);

            /* Ambil resultset-nya */
            ResultSet rs = findUserByUserAndPassword.executeQuery();
            while (rs.next()) {
                UserApp userApp = new UserApp();
                userApp.setId(rs.getInt("id"));
                userApp.setUserName(rs.getString("username"));
                userApp.setPassword(rs.getString("password"));
                
                return userApp;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}