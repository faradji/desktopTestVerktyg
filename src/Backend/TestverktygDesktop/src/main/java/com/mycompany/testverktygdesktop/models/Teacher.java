package com.mycompany.testverktygdesktop.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value = "Teacher")
public class Teacher extends Participant implements Serializable {

    String subject;

    @OneToMany(mappedBy = "teacher")
    @JsonBackReference
    List<Test> tests;

    public Teacher() {
        super();
    }

    public Teacher(int id, String name, String password,String DTYPE, String subject) {
        super(id, name, password,DTYPE);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<Test> getTests() {
        return tests;
    }
    
}
