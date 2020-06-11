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
     public static String url = "jdbc:mysql://localhost:3307/";
    public static String usuario = "root";
    public static String contraseña = "root";
    public static String clase = "com.mysql.jdbc.Driver";

    public static Connection conectar() {
        Connection conexion = null;

        try {
            Class.forName(clase);
            conexion = (Connection) DriverManager.getConnection(url,usuario,contraseña);
            System.out.println("conexion establecida");
            JOptionPane.showMessageDialog(null,"Conexion establecida...");
        } catch (ClassNotFoundException | SQLException e) {


            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Conexion no establecida..." +e.getMessage());
        }
        return conexion;
    }
   //
}

