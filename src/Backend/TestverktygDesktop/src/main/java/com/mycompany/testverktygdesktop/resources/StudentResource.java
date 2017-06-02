package com.mycompany.testverktygdesktop.resources;

import com.mycompany.testverktygdesktop.models.Participant;
import com.mycompany.testverktygdesktop.models.Student;
import com.mycompany.testverktygdesktop.models.Test;
import com.mycompany.testverktygdesktop.repositories.StudentRepository;
import com.mycompany.testverktygdesktop.repositories.TestRepository;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class StudentResource
{

    StudentRepository sr = new StudentRepository();

//    @GET
//    @Path("/{studentId}")
//    public Student getStudent(@PathParam("studentId") int studentId)
//    {
//        System.out.println("resource");
//        return sr.getStudent(studentId);
//    }
            @GET
    @Path("/{studentName}")
    public Student getStudentByName(@PathParam("studentName") String studentName)
    {
        return sr.getStudentByName(studentName);
    }

    @GET
    public List<Student> getStudents()
    {
        System.out.println("resource");
        return sr.getStudents();
    }

}
