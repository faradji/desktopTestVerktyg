package com.mycompany.testverktygdesktop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity

@DiscriminatorValue(value = "Student")
public class Student extends Participant implements Serializable {

    @ManyToMany
    @JsonIgnore
    List<Test> tests;

    public Student() {
        super();
    }

    public Student(int id, String name, String password,String DTYPE, List<Test> tests) {
        super(id, name, password,DTYPE);
        this.tests = tests;
    }

    public List<Test> getTests() {
        return tests;
    }


}
