/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import com.sun.jdi.connect.spi.Connection;
import config.Conexion;

/**
 *
 * @author user
 */
public class ClienteDAO {

    Conexion cn = new Conexion();
    Connection con; 
    PreparedStatement ps; 
    ResultSet rs; 
    int r; 
}

public Cliente buscar(String dni){
       String sql="Select * from cliente where Dni= "+dni;
       try {
        con=cn.Conexion();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery();
        while (rs.next()){
            c.setId(rs.getInt(1));
            c.setDni(rs.getString(2));
            c.setNom(rs.getString(3));
            c.setDir(rs.getString(4));
            c.setDir(rs.getString(5));
        }
    } catch (Exception e) {
    }
    return c;
}

