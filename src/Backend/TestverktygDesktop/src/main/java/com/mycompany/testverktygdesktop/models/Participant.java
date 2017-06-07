package com.mycompany.testverktygdesktop.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Participant implements Serializable {

    @Id
    @GeneratedValue
    int id;
    String name;
    String password;
    @Column(insertable = false, updatable = false) private String DTYPE;


    public Participant() {
    }

    public Participant(int id, String name, String password, String DTYPE) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.DTYPE = DTYPE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDTYPE() {
        return DTYPE;
    }

    public void setDTYPE(String DTYPE) {
        this.DTYPE = DTYPE;
    }

}
