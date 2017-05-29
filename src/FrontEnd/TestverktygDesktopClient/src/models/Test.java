package models;

import java.io.Serializable;
import java.util.List;


public class Test implements Serializable {

    int id;
    String name;
    String subject;

    List<Question> questions;

    List<Student> students;

    Teacher teacher;

    public Test() {
    }

    public Test(int id, String name, String subject) {
        System.out.println("new user");
        this.id = id;
        this.name = name;
        this.subject = subject;
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

}
