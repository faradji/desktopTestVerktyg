package propertymodels;

import java.util.List;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Test{

    IntegerProperty id;
    StringProperty name;
    StringProperty subject;
    IntegerProperty autoCorrectedTest;
    IntegerProperty totalTime;
    List<Question> questions;

    List<Student> students;

    Teacher teacher;

    public Test() {
    }

    public Test(int id, String name, String subject, int autoCorrectedTest, int totalTime) {
        System.out.println("new user");
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.subject = new SimpleStringProperty(subject);
        this.autoCorrectedTest = new SimpleIntegerProperty(autoCorrectedTest);
        this.totalTime = new SimpleIntegerProperty(totalTime);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSubject() {
        return subject.get();
    }

    public void setSubject(String subject) {
        this.subject.set(subject);
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public int getAutoCorrectedTest() {
        return autoCorrectedTest.get();
    }

    public void setAutoCorrectedTest(int autoCorrectedTest) {
        this.autoCorrectedTest.set(autoCorrectedTest);
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Student> getStudents() {
        return students;
    }
       
//
//    public void setStudents(List<Student> students) {
//        this.students = students;
//    }

    public int getTotalTime() {
        return totalTime.get();
    }

    public void setTotalTime(int totalTime) {
        this.totalTime.set(totalTime);
    }

}
