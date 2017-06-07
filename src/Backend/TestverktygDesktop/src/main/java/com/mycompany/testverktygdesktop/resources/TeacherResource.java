package com.mycompany.testverktygdesktop.resources;

import com.mycompany.testverktygdesktop.models.Teacher;
import com.mycompany.testverktygdesktop.repositories.TeacherRepository;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/teachers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeacherResource {

    TeacherRepository t = new TeacherRepository();

    @GET
    @Path("/{participantId}")
    public Teacher getTeacher(@PathParam("participantId") int participantId) {
        
        return t.getTeacher(participantId);
    }
    @GET
//    @Path("/teacherlist")
    public List<Teacher> getTeachers() {
        System.out.println(t.getTeachers().size());
        return t.getTeachers();
    }

    @Path("/{participantId}/tests")
    public TestResource getTeacherTests() {
        return new TestResource();
    }

}
