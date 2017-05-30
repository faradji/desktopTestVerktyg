/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testverktygdesktop.repositories;

import com.mycompany.testverktygdesktop.models.DoneTest;
import com.mycompany.testverktygdesktop.models.StudentAnswer;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author louiseahokas
 */
public class DoneTestsRepository {
    
    SessionFactory sessionFactory;

    public DoneTestsRepository() {
        sessionFactory = myHibernateUtil.getSessionFactory();
    }
    
                   
    public List<DoneTest> getDoneTests(int id)
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM Participant WHERE id = :id");
        query.setInteger("id", id);
        Query query2 = session.createQuery("FROM question.qText,studentanswer.givenAnswer,question.correctAnswer from question,studentanswer where question_Id=studentanswer.question_Id"); 
        
        
        List<DoneTest> doneTests = session.createCriteria(StudentAnswer.class).list();
        
        
        session.getTransaction().commit();
        return doneTests;
    }
    
}
