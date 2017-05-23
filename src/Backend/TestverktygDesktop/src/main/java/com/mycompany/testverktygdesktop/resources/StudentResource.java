package com.mycompany.testverktygdesktop.resources;

import com.mycompany.testverktygdesktop.models.Student;
import com.mycompany.testverktygdesktop.models.Test;
import com.mycompany.testverktygdesktop.repositories.StudentRepository;
import com.mycompany.testverktygdesktop.repositories.TestRepository;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/student")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class StudentResource
{

//    StudentRepository sr = new StudentRepository();
//
//    @GET
//    @Path("/{studentId}")
//    public Student getStudent(@PathParam("studentId") int studentId)
//    {
//        System.out.println("resource");
//        return sr.getStudent(studentId);
//    }
//
//    @GET
//    public List<Student> getStudents()
//    {
//        System.out.println("resource");
//        return sr.getStudents();
//    }
//
//    @POST
//    public Student addStudent(Student student)
//    {
//        return sr.addStudent(student);
//    }
//
//    @PUT
//    public Student updateStudent(Student student)
//    {
//        return sr.updateStudent(student);
//    }
//
//    @DELETE
//    @Path("/{studentId}")
//    public void deleteStudent(@PathParam("studentId") int studentId)
//    {
//        sr.deleteStudent(studentId);
//    }

//    @Path("/{studentId}/doneTests")
//    public QuestionResource question()
//    {
//        return new QuestionResource();
//    }
}
