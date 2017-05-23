package com.mycompany.testverktygdesktop.repositories;

import com.mycompany.testverktygdesktop.models.Teacher;
import com.mycompany.testverktygdesktop.models.Test;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TeacherRepository {
    SessionFactory sessionFactory;

    public TeacherRepository() {
        sessionFactory = myHibernateUtil.getSessionFactory();
    }
    public Teacher getTeacher(int participantId) {
        Session session = sessionFactory.openSession();
        Teacher t = (Teacher) session.get(Teacher.class, participantId);
        t.getTests().size();
        session.close();
        return t;
    }
    

    public List<Teacher> getTeachers() {
        Session session = sessionFactory.openSession();
        List<Teacher> teachers = session.createCriteria(Teacher.class).list();

        for (int i = 0; i < teachers.size(); i++) {
            teachers.get(i).getTests().size();
        }

        session.close();
        return teachers;
    }
    
}
