package propertymodels;

import models.*;
import java.io.Serializable;
import java.util.List;

public class Student extends Participant implements Serializable {

    List<Test> tests;

    public Student() {
        super();
    }

    public Student(int id, String name, String password, String dtype, List<Test> tests) {
        super(id, name, password, dtype);
        this.tests = tests;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

}
