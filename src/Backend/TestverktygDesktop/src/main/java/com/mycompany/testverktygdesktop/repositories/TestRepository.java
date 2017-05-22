/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testverktygdesktop.repositories;

import com.mycompany.testverktygdesktop.models.Test;
import java.util.List;
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
       Session session= sessionFactory.openSession();
       session.beginTransaction();
       session.save(test);
       session.getTransaction().commit();
       session.close();
       return test;
    }
    
    public Test getTest(int testId) {
        Session session= sessionFactory.openSession();
        Test test = (Test)session.get(Test.class, testId);
        test.getQuestions();
        session.close();
        System.out.println("repo");
        return test;  
    }

    public List<Test> getTests() {
        Session session= sessionFactory.openSession();
        List <Test> tests = session.createCriteria(Test.class).list();
        
        System.out.println("repo");
        
         for (int i = 0; i < tests.size(); i++){
            tests.get(i).getQuestions().size();
        }
//        tests.stream().forEach((t)->{
//            t.getQuestions().size();});
        
        session.close();
        return tests;
        
    }
    

    public Test updateTest(Test test) {
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        
        session.update(test);
        
        session.getTransaction().commit();
        session.close();
        return test;
    }


    public void deleteTest(int testId) {
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        Test test = (Test)session.get(Test.class, testId);
        
        session.delete(test);
        session.getTransaction().commit();
        session.close();
        
    }
    
}
