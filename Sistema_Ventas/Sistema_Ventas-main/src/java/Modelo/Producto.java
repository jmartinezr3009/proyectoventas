/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Producto {
    
    int Id;
    String Nom;
    Double Pre;
    int Stock;
    String Estado;

    public Producto() {
    }

    public Producto(int Id, String Nom, Double Pre, int Stock, String Estado) {
        this.Id = Id;
        this.Nom = Nom;
        this.Pre = Pre;
        this.Stock = Stock;
        this.Estado = Estado;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public Double getPre() {
        return Pre;
    }

    public void setPre(Double Pre) {
        this.Pre = Pre;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    
}
