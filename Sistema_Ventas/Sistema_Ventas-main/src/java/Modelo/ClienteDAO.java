package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    Conexion cn = new Conexion();
    Connection con; 
    PreparedStatement ps; 
    ResultSet rs; 
    int r; 
    
    public Cliente buscar(String dni) {
        Cliente c = new Cliente();
        String sql = "select * from cliente where Dni = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);  // Usamos parámetros en la consulta SQL para evitar SQL Injection
            rs = ps.executeQuery();
            if (rs.next()) {
                c.setId(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setNom(rs.getString(3));
                c.setDir(rs.getString(4));
                c.setEs(rs.getString(5));
            }
            ps.close();
            con.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return c;
    }
    
    public List<Cliente> listar() {
        String sql = "select * from cliente";
        List<Cliente> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cl = new Cliente();
                cl.setId(rs.getInt(1));
                cl.setDni(rs.getString(2));
                cl.setNom(rs.getString(3));
                cl.setDir(rs.getString(4));
                cl.setEs(rs.getString(5));
                lista.add(cl);
            }
            ps.close();
            con.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return lista;
    }
    
    public int agregar(Cliente cl) {
        String sql = "insert into cliente(Dni, Nombres, Direccion, Estado) values(?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getDni());
            ps.setString(2, cl.getNom());
            ps.setString(3, cl.getDir());
            ps.setString(4, cl.getEs());
            r = ps.executeUpdate();  // Aquí guardamos el número de filas afectadas
            ps.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return r;
    }
}



