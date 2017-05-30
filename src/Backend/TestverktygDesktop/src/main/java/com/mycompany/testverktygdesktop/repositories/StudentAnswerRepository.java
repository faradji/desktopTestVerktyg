/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testverktygdesktop.repositories;

import com.mycompany.testverktygdesktop.models.Student;
import com.mycompany.testverktygdesktop.models.StudentAnswer;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Allan
 */
public class StudentAnswerRepository
{
    SessionFactory sessionFactory;

    public StudentAnswerRepository() {
        sessionFactory = myHibernateUtil.getSessionFactory();
    }
    
                   
    public List<StudentAnswer> getStudentAnswers()
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query=session.createQuery("FROM ");
        List<StudentAnswer> doneTests = session.createCriteria(StudentAnswer.class).list();
        
        return doneTests;
    }
    
}
