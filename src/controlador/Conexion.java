/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author profe
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    Connection con = null;

    String base = "instituto"; //Nombre de la base de datos
    String url = "jdbc:mysql://localhost:3306/" + base; //Direccion, puerto y nombre de la Base de Datos
    String user = "root"; //Usuario de Acceso a MySQL
    String password = ""; //Password del usuario

    public Connection getConexion() {
        System.out.println("getConexion()...");
        try {              
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Bien, conectados a instituto");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Conexión no lograda...");
            System.err.println(e);
        }
        return con;
    }
}

