/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class ProductoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public List listar () {
        String sql="select *from producto";
        List <Producto> lista=new ArrayList<> ();
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                Producto em=new Producto();
                em.setId(rs.getInt(1));
                em.setNom(rs.getString(2));
                em.setPre(rs.getDouble(3));
                em.setStock(rs.getInt(4));
                em.setEstado(rs.getString(5));
                lista.add(em);
            }
        }catch(SQLException e){ 
        }
        return lista;
    }

    public int agregar(Producto p){
        String sql="insert into produto(Nombres, Precio, Stock, Estado)values(?,?,?,?)";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, p.getNom());
            ps.setDouble(2, p.getPre());
            ps.setInt(3, p.getStock());
            ps.setString(4, p.getEstado());
            ps.executeUpdate();
        }catch(SQLException e){
        }
        return r;
    }

    public Producto listarId (int id){
        Producto pr = new Producto();
        String sql ="select * from producto where IdProducto"+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                pr.setId(rs.getInt(1));
                pr.setNom(rs.getString(2));
                pr.setPre(rs.getDouble(3));
                pr.setStock(rs.getInt(4));
                pr.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return pr;

    }
    
    public int actualizar(Producto em){
         String sql="update producto set Nombres=?, Precio=?, Stock=?, Estado=? where IdProducto=?";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, em.getNom());
            ps.setDouble(2, em.getPre());
            ps.setInt(3, em.getStock());
            ps.setString(4, em.getEstado());
            ps.setInt(5, em.getId());
            }catch(SQLException e){
            } 
        return r;
    }
    public void delete(int id ){
        String sql="delete from producto where IdProducto="+id;
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            }catch(SQLException e){
            } 
    }
}

