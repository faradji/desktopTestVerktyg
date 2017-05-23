
package com.mycompany.testverktygdesktop.repositories;

import com.mycompany.testverktygdesktop.models.Student;
import com.mycompany.testverktygdesktop.models.Test;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author louiseahokas
 */
public class StudentRepository
{

    SessionFactory sessionFactory;

    public StudentRepository()
    {
        sessionFactory = myHibernateUtil.getSessionFactory();
    }

    public Student getStudent(int studentId)
    {
        Session session = sessionFactory.openSession();
        Student student = (Student) session.get(Student.class, studentId);
        student.getTests();
        session.close();
        System.out.println("repo");
        return student;
    }

    public List<Student> getStudents()
    {
        Session session = sessionFactory.openSession();
        List<Student> students = session.createCriteria(Student.class).list();

        System.out.println("repo");

        for (int i = 0; i < students.size(); i++)
        {
            students.get(i).getTests().size();
        }

        session.close();
        return students;
    }

    public Student addStudent(Student student)
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
        return student;
    }

    public Student updateStudent(Student student)
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.update(student);

        session.getTransaction().commit();
        session.close();
        return student;
    }

    public void deleteStudent(int studentId)
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Student student = (Student) session.get(Student.class, studentId);

        session.delete(student);
        session.getTransaction().commit();
        session.close();
    }

}

package com.mycompany.testverktygdesktop.repositories;

<<<<<<< Temporary merge branch 1
import com.mycompany.testverktygdesktop.models.Student;
import com.mycompany.testverktygdesktop.models.Test;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author louiseahokas
 */
public class StudentRepository
{

    SessionFactory sessionFactory;

    public StudentRepository()
    {
        sessionFactory = myHibernateUtil.getSessionFactory();
    }

    public Student getStudent(int studentId)
    {
        Session session = sessionFactory.openSession();
        Student student = (Student) session.get(Student.class, studentId);
        student.getTests();
        session.close();
        System.out.println("repo");
        return student;
    }

    public List<Student> getStudents()
    {
        Session session = sessionFactory.openSession();
        List<Student> students = session.createCriteria(Student.class).list();

        System.out.println("repo");

        for (int i = 0; i < students.size(); i++)
        {
            students.get(i).getTests().size();
        }

        session.close();
        return students;
    }

    public Student addStudent(Student student)
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
        return student;
    }

    public Student updateStudent(Student student)
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.update(student);

        session.getTransaction().commit();
        session.close();
        return student;
    }

    public void deleteStudent(int studentId)
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Student student = (Student) session.get(Student.class, studentId);

        session.delete(student);
        session.getTransaction().commit();
        session.close();
    }

=======
public class StudentRepository {
    
>>>>>>> Temporary merge branch 2
}

package com.mycompany.testverktygdesktop.repositories;


import com.mycompany.testverktygdesktop.models.Student;
import com.mycompany.testverktygdesktop.models.Test;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author louiseahokas
 */
public class StudentRepository
{

    SessionFactory sessionFactory;

    public StudentRepository()
    {
        sessionFactory = myHibernateUtil.getSessionFactory();
    }

    public Student getStudent(int studentId)
    {
        Session session = sessionFactory.openSession();
        Student student = (Student) session.get(Student.class, studentId);
        student.getTests();
        session.close();
        System.out.println("repo");
        return student;
    }

    public List<Student> getStudents()
    {
        Session session = sessionFactory.openSession();
        List<Student> students = session.createCriteria(Student.class).list();

        System.out.println("repo");

        for (int i = 0; i < students.size(); i++)
        {
            students.get(i).getTests().size();
        }

        session.close();
        return students;
    }
//
//    public Student addStudent(Student student)
//    {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        session.save(student);
//        session.getTransaction().commit();
//        session.close();
//        return student;
//    }
//
//    public Student updateStudent(Student student)
//    {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        session.update(student);
//
//        session.getTransaction().commit();
//        session.close();
//        return student;
//    }
//
//    public void deleteStudent(int studentId)
//    {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        Student student = (Student) session.get(Student.class, studentId);
//
//        session.delete(student);
//        session.getTransaction().commit();
//        session.close();
//    }

}
