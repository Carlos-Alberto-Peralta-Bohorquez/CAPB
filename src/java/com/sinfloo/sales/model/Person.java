
package com.sinfloo.sales.model;

import java.time.LocalDate;


public class Person {
    private int personId;
    private String name;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String civilState;
    private String gender;

    public Person() {
    }

    public Person(int personId, String name, String firstName, String lastName, LocalDate birthDate, String civilState, String gender) {
        this.personId = personId;
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.civilState = civilState;
        this.gender = gender;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCivilState() {
        return civilState;
    }

    public void setCivilState(String civilState) {
        this.civilState = civilState;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    
}
