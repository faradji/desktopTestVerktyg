package propertymodels;

import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Teacher extends Participant {

    StringProperty subject;

    List<Test> tests;

    public Teacher() {
        super();
    }

    public Teacher(int id, String name, String password, String DTYPE, String subject) {
        super(id, name, password, DTYPE);
        this.subject = new SimpleStringProperty(subject);
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

    @Override
    public String getDTYPE() {
        return DTYPE.get();
    }

    @Override
    public void setDTYPE(String DTYPE) {
        this.DTYPE.set(DTYPE);
    }
}
