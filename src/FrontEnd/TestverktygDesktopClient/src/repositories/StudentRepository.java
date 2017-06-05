
package repositories;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;


public class StudentRepository
{

    Client client;

    public StudentRepository() {

    }

    public List<models.Student> getStudents() {

        client = ClientBuilder.newClient();

        List<models.Student> Students;
        Students = client.target("http://localhost:8080/TestverktygDesktop/webapi/students")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<models.Student>>() {
                });

        client.close();

        return Students;
    }

    public models.Student getStudent(int id) {

        client = ClientBuilder.newClient();

        models.Student Student;
        Student = client.target("http://localhost:8080/TestverktygDesktop/webapi/students")
                .path(String.valueOf(id))
                .request(MediaType.APPLICATION_JSON)
                .get(models.Student.class);

        client.close();

        return Student;
    }
    
    
    public models.Student getStudentByName(String name) {

        client = ClientBuilder.newClient();

        models.Student Student;
        Student = client.target("http://localhost:8080/TestverktygDesktop/webapi/participants")
                .path(name)
                .request(MediaType.APPLICATION_JSON)
                .get(models.Student.class);

        client.close();

        return Student;
    }
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
