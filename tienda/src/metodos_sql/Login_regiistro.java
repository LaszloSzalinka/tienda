
package metodos_sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Login_regiistro {
    
    public static ConexionBD conexion = new ConexionBD();

    public static PreparedStatement sentencia_preparada;
    public static ResultSet resultado;
    public static String sql;
    public static int resultado_numero = 0;

    public int guardar(String nombre, String apellido, String usuario, String contraseña,int cargo) {
        int resultado = 0;
        Connection conexion = null;

        String sentencia_guardar = ("INSERT INTO usuarios (nombre,apellidos,correo,contraseña) VALUES (?,?,?,?)");

        try {
            conexion = ConexionBD.conectar();
            sentencia_preparada = conexion.prepareStatement(sentencia_guardar);
            sentencia_preparada.setString(1, nombre);
            sentencia_preparada.setString(2, apellido);
            sentencia_preparada.setString(3, usuario);
            sentencia_preparada.setString(4, contraseña);
            sentencia_preparada.setInt(5, cargo);
            resultado = sentencia_preparada.executeUpdate();
            sentencia_preparada.close();
            conexion.close();
        } catch (Exception e) {

            System.out.println(e);
        }
        return resultado;
    }

    public static String buscarNombre(String correo) {

        String busqueda_nombre = null;
        Connection conexion = null;
        try {
            conexion = ConexionBD.conectar();
            String sentencia_buscar = ("SELECT nombre, apellidos FROM usuarios WHERE correo = '" + correo + "'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {
                String nombre = resultado.getString("nombre");
                String apellidos = resultado.getString("apellidos");
                busqueda_nombre = (nombre + " " + apellidos);
            }
            conexion.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return busqueda_nombre;
    }

    public static String buscarUsuarioRegistrado(String usuario, String contraseña,int area) { //recibe el usuario, la contraseña y el area
        String busqueda_usuario = null;
        Connection conexion = null;

        try {
            conexion = ConexionBD.conectar();
            //ese es el codigo sql para verificar en la base de datos los datos
            String sentencia_buscar_usuario = ("SELECT nombre,contraseña,area FROM usuarios WHERE usuario = '" + usuario + "' && contraseña = '" + contraseña + "'&&  area = '"+area+"' ");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar_usuario);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) { //si el susuario se encuentra entonces la variable busqueda_usuario tendra el valor usuario encontrado
                busqueda_usuario = "usuario encontrado";
            } else {//esta es la validación que se realiza en la interfaz del login
                busqueda_usuario = "usuario no encontrado";
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return busqueda_usuario; //devuelve ese valor a la interfaz del login 
    }
}
