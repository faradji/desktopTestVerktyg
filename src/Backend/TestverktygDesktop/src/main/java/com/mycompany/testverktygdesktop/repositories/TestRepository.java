/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testverktygdesktop.repositories;

import com.mycompany.testverktygdesktop.models.Question;
import com.mycompany.testverktygdesktop.models.Test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author louiseahokas
 */
public class TestRepository {
    
    SessionFactory sessionFactory; 
    
    public TestRepository(){
        sessionFactory = myHibernateUtil.getSessionFactory();
    }

    
    public Test addTest(Test test)
    {
       Session session= myHibernateUtil.getSession();
       session.beginTransaction();
       session.save(test);
       session.getTransaction().commit();
       session.close();
       return test;
    }
    
    public Test getTest(int testId) {
        Session session = myHibernateUtil.getSession();
        Test test = (Test)session.get(Test.class, testId);
        session.close();
        return test;  
    }
    
}
