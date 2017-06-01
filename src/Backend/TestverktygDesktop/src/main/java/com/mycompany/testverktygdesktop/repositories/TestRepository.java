package com.mycompany.testverktygdesktop.repositories;

import com.mycompany.testverktygdesktop.models.Test;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestRepository {

    SessionFactory sessionFactory;

    public TestRepository() {
        sessionFactory = myHibernateUtil.getSessionFactory();
    }

    public Test addTest(Test test) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(test);
        session.getTransaction().commit();
        session.close();
        return test;
    }

    public Test getTest(int testId) {
        Session session = sessionFactory.openSession();
        Test test = (Test) session.get(Test.class, testId);
        test.getQuestions().size();
        session.close();
        return test;
    }

    public List<Test> getTests() {
        Session session = sessionFactory.openSession();
        List<Test> tests = session.createCriteria(Test.class).list();

        for (int i = 0; i < tests.size(); i++) {
            tests.get(i).getQuestions().size();
        }
//        tests.stream().forEach((t)->{
//            t.getQuestions().size();});

        session.close();
        return tests;

    }

    public Test updateTest(Test test) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.update(test);

        session.getTransaction().commit();
        session.close();
        return test;
    }

    public void deleteTest(int testId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Test test = (Test) session.get(Test.class, testId);

        session.delete(test);
        session.getTransaction().commit();
        session.close();

    }

    public List<Test> getTeacherTests(int participantId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
