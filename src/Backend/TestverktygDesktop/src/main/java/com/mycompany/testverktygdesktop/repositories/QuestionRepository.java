/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testverktygdesktop.repositories;

import com.mycompany.testverktygdesktop.models.Question;
import com.mycompany.testverktygdesktop.models.Test;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author louiseahokas
 */
public class QuestionRepository {
    
    SessionFactory sessionFactory; 
    
    public QuestionRepository(){
        sessionFactory = myHibernateUtil.getSessionFactory();
    }

    public Question getQuestion(int questionId) {
        Session session= sessionFactory.openSession();
        Question question = (Question)session.get(Question.class, questionId);
        session.close();
        return question;  
    }

    public List<Question> getQuestions(int testId) {
        Session session= sessionFactory.openSession();
        
        List <Question> questions = session.createCriteria(Question.class).list();
        
        session.close();
        return questions;
        
    }

    public Question updateQuestion(int testId, Question question) {
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        Test test = (Test)session.get(Test.class, testId);
        question.setTest(test);
        session.update(question);
        
        session.getTransaction().commit();
        session.close();
        return question;
    }

    public Question addQuestion(int testId, Question question) {
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        Test test = (Test)session.get(Test.class, testId);
        question.setTest(test);
        session.save(question);
        session.getTransaction().commit();
        session.close();
        return question;
    }

    public void deleteQuestion(int questionId) {
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        Question question = (Question)session.get(Question.class, questionId);
        
        session.delete(question);
        session.getTransaction().commit();
        session.close();
        
    }
    
}
