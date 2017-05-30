
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
    List<Integer> givenAnswers=new ArrayList();
    List<String> questions =new ArrayList();
    
    public DoneTest()
    {

    }

    public DoneTest(int studentid, String studentName, String course, String testName) {
        this.studentid = studentid;
        this.studentName = studentName;
        this.course = course;
        this.testName = testName;
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

    public List<Integer> getGivenAnswers() {
        return givenAnswers;
    }

    public void setGivenAnswers(List<Integer> givenAnswers) {
        this.givenAnswers = givenAnswers;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }

}
