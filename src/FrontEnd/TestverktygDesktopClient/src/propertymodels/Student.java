package propertymodels;

import java.io.Serializable;
import java.util.List;
import javafx.beans.property.StringProperty;

public class Student extends Participant implements Serializable {

    List<Test> tests;

    public Student() {
        super();
    }

    public Student(int id, String name,String DTYPE, String password) {
        super(id, name, password,DTYPE);
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
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
