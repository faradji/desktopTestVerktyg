/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testverktygdesktop.repositories;

import com.mycompany.testverktygdesktop.models.Question;
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
        Session session = myHibernateUtil.getSession();
        Question question = (Question)session.get(Question.class, questionId);
        session.close();
        return question;  
    }

//    public List<Question> getQuestions(int testId) {
//        
//    }
//
//    public Question updateQuestion(int testId, Question question) {
//        
//    }
//
//    public Question addQuestion(int testId, Question question) {
//        
//    }
//
//    public void deleteQuestion(int questionId) {
//        
//    }
    
}
