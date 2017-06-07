/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testverktygdesktop.repositories;

import com.mycompany.testverktygdesktop.models.DoneTest;
import com.mycompany.testverktygdesktop.models.Question;
import com.mycompany.testverktygdesktop.models.Student;
import com.mycompany.testverktygdesktop.models.StudentAnswer;
import com.mycompany.testverktygdesktop.models.Test;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 */
public class DoneTestsRepository {

    SessionFactory sessionFactory;

    public DoneTestsRepository() {
        sessionFactory = myHibernateUtil.getSessionFactory();
    }

    public List<DoneTest> getDoneTests() {
        System.out.println("getDoneTests repository");
        List<DoneTest> doneTests = new ArrayList();
//        session.getTransaction().commit();
//        
    //olika sessions för varje hämtning från DBn
        Session session = sessionFactory.openSession();
        Session sessionGetStudent = sessionFactory.openSession();
        Session sessionGetQ = sessionFactory.openSession();
        Session sessionGetQuestions = sessionFactory.openSession();
        Session sessionGetTest = sessionFactory.openSession();

//        session.beginTransaction();
//        Runnable r = () -> {
        //hämtar lista med studentanswers från DBn
        List<StudentAnswer> studentAnswers = session.createCriteria(StudentAnswer.class).list();
        System.out.println("studentAnswer" + studentAnswers.size());

        List<Question> questions = sessionGetQuestions.createCriteria(Question.class).list();
        List<Question> tempQ = new ArrayList();
        
        // studentAnswer.stream().forEach((StudentAnswer s) -> {
        for (int i =0;i<studentAnswers.size();i++) {
            //hämta studenten som finns i listan på plats "i"
            Student student = (Student) sessionGetStudent.get(Student.class, studentAnswers.get(i).getParticipant_Id());
           
            //hämta frågan som finns på plats "i"
            Question q = (Question) sessionGetQ.get(Question.class, studentAnswers.get(i).getQuestion_Id());
            //hämta test från DBn som q finns i
            Test test = (Test) sessionGetTest.get(Test.class, q.getTest_Id());
            System.out.println("studentid i studentanswers: -------------------------__" + student.getId());
            System.out.println("studentnamn i studentanswers: -------------------------__" + student.getName());
            System.out.println("testämne i test: -------------------------__" + test.getSubject());
            System.out.println("givenanswer i studentanswers: -------------------------__" + studentAnswers.get(i).getGivenAnswer());
            System.out.println("testnamn i test: -------------------------__" + test.getName());
            
            doneTests.add(new DoneTest(student.getId(), student.getName(), test.getSubject(), studentAnswers.get(i).getGivenAnswer(), test.getName()));
            
            for(int j = 0; j < doneTests.size(); j++){
               
               if (doneTests.get(j).getTestName().equalsIgnoreCase(test.getName())) {
                        tempQ = doneTests.get(j).getQuestions();
                        
                        break;
                }
            }
            System.out.println("storlek på frågelistan: --------------------------" + tempQ.size());
            
            doneTests.get(i).setQuestions(tempQ);
            
           
        }// });
        session.close();
        sessionGetStudent.close();
        sessionGetQ.close();
        sessionGetQuestions.close();
        sessionGetTest.close();
//        };
//        session.getTransaction().commit();
//        Thread t = new Thread(r);
//        t.start();
//        try {
//            t.join();
//        } catch (InterruptedException ex) {
//            System.out.println(ex.getMessage());
//        }

        return doneTests;
    }

}
