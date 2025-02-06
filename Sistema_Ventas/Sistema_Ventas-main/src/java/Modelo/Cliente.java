/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


public class Cliente {
    int id;
    String Es;
    String dni;
    String Nom;
    String Dir;

    public Cliente() {
    }

    public Cliente(int id, String Es, String dni, String Nom, String Dir) {
        this.id = id;
        this.Es = Es;
        this.dni = dni;
        this.Nom = Nom;
        this.Dir = Dir;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEs() {
        return Es;
    }

    public void setEs(String Es) {
        this.Es = Es;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getDir() {
        return Dir;
    }

    public void setDir(String Dir) {
        this.Dir = Dir;
    }

    
    
    
}
