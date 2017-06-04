package models;

import java.io.Serializable;
import java.util.List;

public class Teacher extends Participant implements Serializable {

    String subject;

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
