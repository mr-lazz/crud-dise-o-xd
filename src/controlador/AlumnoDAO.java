/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AlumnoDAO{
    static private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    static private ArrayList<Alumno> alumnos = new ArrayList<>();
    

    public static boolean agregar(Alumno alumno) {
        PreparedStatement ps = null;
        Connection con = new Conexion().getConexion();
        //System.out.println(alumno.getFechaNac());

        String sql = "INSERT INTO alumno (rut, nombre, fechaNac , carrera) VALUES(?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, alumno.getRut());
            ps.setString(2, alumno.getNombre());
            ps.setDate(3, java.sql.Date.valueOf(sdf.format(alumno.getFechaNac())));
            ps.setString(4, alumno.getCarrera());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public static boolean modificar(Alumno alumno) {
        PreparedStatement ps = null;
        Connection con = new Conexion().getConexion();

        String sql = "UPDATE alumno SET nombre=?, fechaNac=?, carrera=? WHERE rut=? ";

        try {
            ps = con.prepareStatement(sql);            
            ps.setString(1, alumno.getNombre());
            ps.setDate(2, java.sql.Date.valueOf(sdf.format(alumno.getFechaNac())));
            ps.setString(3, alumno.getCarrera());
            ps.setString(4, alumno.getRut());
            ps.execute();      
            return true;
        } catch (SQLException e) {
            System.out.println("Modificar error-> "+e.getMessage());
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public static boolean eliminar(String rut) {
        PreparedStatement ps = null;
        Connection con = new Conexion().getConexion();

        String sql = "DELETE FROM alumno WHERE rut=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, rut );
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public static Alumno buscar(String rut) throws Exception{
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = new Conexion().getConexion();
        Alumno alumno=null;

        String sql = "SELECT * FROM alumno WHERE rut=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, rut);
            rs = ps.executeQuery();

            if (rs.next()) {
                
                String nombre=rs.getString("nombre");
                Date fechaNac= rs.getDate("fechaNac");
                String carrera =rs.getString("carrera");
                
                alumno = new Alumno(carrera,rut, nombre, fechaNac);
                
                return alumno;
            }
           
        } catch (SQLException e) {
          //mensaje error
        }
        return alumno;
    }
    
    public static ArrayList<Alumno> obtenerDatos() throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = new Conexion().getConexion();
        Alumno alumno=null;

        String sql = "SELECT * FROM alumno";
        //System.out.println("obtenerDatos---->");
        try {
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery();
            alumnos.clear();
            while(rs.next()) {                
                String rut =rs.getString("rut");
                String nombre=rs.getString("nombre");
                Date fechaNac= rs.getDate("fechaNac");
                String carrera =rs.getString("carrera");
                
                alumno = new Alumno(carrera,rut, nombre, fechaNac);
                
                alumnos.add(alumno);
            }
           
        } catch (SQLException e) {
            System.out.println("obteberDatos, error-> "+e.getMessage());
        }
        System.out.println("obtenerDatos-> "+alumnos);
        return alumnos;
    }
}
