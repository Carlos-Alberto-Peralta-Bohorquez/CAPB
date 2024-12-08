
package Modelo;

public class Persona {
    int id;
    String dni;
    String nom;
    String hab ;
    public Persona() {
    }

    public Persona(String dni, String nom,String hab) {
        this.dni = dni;
        this.nom = nom;
        this.hab = hab;
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
    
}
