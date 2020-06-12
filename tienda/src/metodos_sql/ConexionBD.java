/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos_sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author nanis
 */
public class ConexionBD {
    static Connection cnx = null;
   
    public static Connection conectar() {
        
        
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection("jdbc:Mysql://localhost/dbtienda?user=root&password=");
            //JOptionPane.showMessageDialog(null, "Conectado"); cnx = DriverManager.getConnection("jdbc:Mysql://localhost/login_bd?user=root&password=");
            //JOptionPane.showMessageDial

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al conectar");
        }
        return cnx;
    }
   //
}

