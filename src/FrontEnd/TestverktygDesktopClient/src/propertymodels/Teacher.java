package propertymodels;

import models.*;
import java.io.Serializable;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Teacher extends Participant {

    StringProperty subject;

    List<Test> tests;

    public Teacher() {
        super();
    }

<<<<<<< HEAD
    public Teacher(int id, String name, String password, String subject) {
        super(id, name, password);
        this.subject = new SimpleStringProperty(subject);
=======
    public Teacher(int id, String name, String password, String dtype, String subject) {
        super(id, name, password, dtype);
        this.subject = subject;
>>>>>>> henrik2
    }

    public String getSubject() {
        return subject.get();
    }

    public void setSubject(String subject) {
        this.subject.set(subject);
    }

    public List<Test> getTests() {
        return tests;
    }
    
}
