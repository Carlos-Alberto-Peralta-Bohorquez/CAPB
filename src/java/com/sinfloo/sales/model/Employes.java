
package com.sinfloo.sales.model;


public class Employes extends Person{
    private int employeId;
    private String employeCode;
    private String typeDoc;
    private String numDoc;
    private String address;
    private String numberPhone;
    private String email;
    private User user;
    private Ubigeo ubigeo;
    private String state;

    public Employes() {
    }

    public Employes(int employeId, String employeCode, String typeDoc, String numDoc, String address, String numberPhone, String email, User user, Ubigeo ubigeo, String state) {
        this.employeId = employeId;
        this.employeCode = employeCode;
        this.typeDoc = typeDoc;
        this.numDoc = numDoc;
        this.address = address;
        this.numberPhone = numberPhone;
        this.email = email;
        this.user = user;
        this.ubigeo = ubigeo;
        this.state = state;
    }

    public int getEmployeId() {
        return employeId;
    }

    public void setEmployeId(int employeId) {
        this.employeId = employeId;
    }

    public String getEmployeCode() {
        return employeCode;
    }

    public void setEmployeCode(String employeCode) {
        this.employeCode = employeCode;
    }

    public String getTypeDoc() {
        return typeDoc;
    }

    public void setTypeDoc(String typeDoc) {
        this.typeDoc = typeDoc;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Ubigeo getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(Ubigeo ubigeo) {
        this.ubigeo = ubigeo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    
}
