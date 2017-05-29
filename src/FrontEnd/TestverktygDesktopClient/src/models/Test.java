package models;

import java.io.Serializable;
import java.util.List;


public class Test implements Serializable {

    int id;
    String name;
    String subject;
    int autoCorrectedTest;
    int totalTime;
    List<Question> questions;

    List<Student> students;

    Teacher teacher;

    public Test() {
    }

    public Test(int id, String name, String subject, int autoCorrectedTest, int totalTime) {
        System.out.println("new user");
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.autoCorrectedTest = autoCorrectedTest;
        this.totalTime = totalTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public int getAutoCorrectedTest() {
        return autoCorrectedTest;
    }

    public void setAutoCorrectedTest(int autoCorrectedTest) {
        this.autoCorrectedTest = autoCorrectedTest;
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
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

}
