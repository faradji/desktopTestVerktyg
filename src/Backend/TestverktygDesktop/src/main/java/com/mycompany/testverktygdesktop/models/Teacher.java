/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testverktygdesktop.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity

public class Teacher extends Participant implements Serializable{
    
    String subject;
    
    @OneToMany(mappedBy="teacher")
    @JsonBackReference
    List <Test> tests;
    
    public Teacher(){
        super();
    }

    public Teacher(int id, String name, String password, String subject) {
        super(id, name, password);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    
}
