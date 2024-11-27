
package com.sinfloo.sales.model;

public class Departament {
    private String code;
    private String description;

    public Departament() {
    }

    public Departament(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
