
package repositories;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import models.Student;


public class StudentRepository
{

   Client client;

    public StudentRepository()
    {

    }
    public List<Student> getStudents() {
        
        client = ClientBuilder.newClient();
        
        List<Student> students;
        students = client.target("http://localhost:8080/TestverktygDesktop/webapi/students/studentlist")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Student>>(){});
        
        System.out.println("Studentlist: " + students);
        
        client.close();

        return students;
    }
//    public List<Student> getStudents(int studentId)
//    {
//         return students;
//    }

//    public List<Student> getStudents()
//    {
//      
//        return students;
//    }
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
