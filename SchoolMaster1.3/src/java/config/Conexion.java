/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Danny
 */
public class Conexion {
    private static Connection conn = null;
    private static String login = "sm_administrador";
    private static String clave = "sm001";
    private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    
    public static Connection getConexion(){
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(url, login, clave);
//            conn.setAutoCommit(false);
            if(conn != null){
                System.out.println("Conexion exitosa");
            }else{
                System.out.println("Conexion erronea");
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "conexion erronea " + e.getMessage());
            System.out.println (" SQLException : " + e. getMessage () );
        }
        return conn;
    }
    
    public void desconexion(){
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("Error al desconectar " + e.getMessage());
        }
    }
    
//    public static void main(String[] args) {
//        Conexion con=new Conexion();
//        con.getConexion();
//    }

}
