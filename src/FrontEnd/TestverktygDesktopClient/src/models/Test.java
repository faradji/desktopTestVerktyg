package models;

import models.*;
import java.io.Serializable;
import java.util.List;


public class Test implements Serializable {

    int id;
    String name;
    String subject;
    int autoCorrectedTest;
    int totalTime;
    int teacher_id;
    List<Question> questions;

    List<Student> students;

    Teacher teacher;

    public Test() {
    }

    public Test(int id, String name, String subject, int autoCorrectedTest, int totalTime, int teacher_id) {
        System.out.println("new user");
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.autoCorrectedTest = autoCorrectedTest;
        this.totalTime = totalTime;
        this.teacher_id = teacher_id;
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

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
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
    
    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
    }
}
