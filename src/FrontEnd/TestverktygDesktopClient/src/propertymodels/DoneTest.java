/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propertymodels;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author louiseahokas
 */
public class DoneTest {
    
    IntegerProperty studentid;
    StringProperty studentName;
    StringProperty course;
    StringProperty testName;
    StringProperty givenAnswer;
    
    List<propertymodels.Question> questions = new ArrayList();

    
    public DoneTest(){}
    
    public DoneTest(int studentid, String studentName, String course, String testName, String givenAnswer) {
        this.studentid = new SimpleIntegerProperty(studentid);
        this.studentName = new SimpleStringProperty(studentName);
        this.course = new SimpleStringProperty(course);
        this.testName = new SimpleStringProperty(testName);
        this.givenAnswer = new SimpleStringProperty(givenAnswer);
    }

    public int getStudentid() {
        return studentid.get();
    }

    public void setStudentid(int studentid) {
        this.studentid.set(studentid);
    }

    public String getStudentName() {
        return studentName.get();
    }

    public void setStudentName(String studentName) {
        this.studentName.set(studentName);
    }

    public String getCourse() {
        return course.get();
    }

    public void setCourse(String course) {
        this.course.set(course);
    }

    public String getTestName() {
        return testName.get();
    }

    public void setTestName(String testName) {
        this.testName.set(testName);
    }

    public String getGivenAnswer() {
        return givenAnswer.get();
    }

    public void setGivenAnswer(String givenAnswer) {
        this.givenAnswer.set(givenAnswer);
    }

    public List<propertymodels.Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<propertymodels.Question> questions) {
        this.questions = questions;
    }
    
    
    
}
