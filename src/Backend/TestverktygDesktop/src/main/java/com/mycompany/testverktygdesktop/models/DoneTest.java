
package com.mycompany.testverktygdesktop.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diddi
 */
public class DoneTest implements Serializable{

    int studentid;
    String studentName;
    String course;
    String testName;
    int givenAnswer;
    List<Question> questions =new ArrayList();
    
    public DoneTest()
    {

    }

    public DoneTest(int studentid, String studentName, String course, int givenAnswer, String testName) {
        this.studentid = studentid;
        this.studentName = studentName;
        this.course = course;
        this.testName = testName;
        this.givenAnswer = givenAnswer;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public int getGivenAnswer() {
        return givenAnswer;
    }

    public void setGivenAnswer(int givenAnswers) {
        this.givenAnswer = givenAnswers;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

}
