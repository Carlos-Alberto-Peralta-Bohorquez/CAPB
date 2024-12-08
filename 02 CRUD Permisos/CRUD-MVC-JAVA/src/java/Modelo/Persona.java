
package Modelo;

public class Persona {
    int id;
    String dni;
    String nom;
    String hab ;
     String mot ;
    public Persona() {
    }

    public Persona(String dni, String nom,String hab,String mot) {
        this.dni = dni;
        this.nom = nom;
        this.hab = hab;
        this.mot = mot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getHab() {
        return hab;
    }

    public void setHab(String hab) {
        this.hab = hab;
    }

    public String getMot() {
        return mot;
    }

    public void setMot(String mot) {
        this.mot = mot;
    }
    
}
