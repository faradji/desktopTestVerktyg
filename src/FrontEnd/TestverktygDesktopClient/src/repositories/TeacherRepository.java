package repositories;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import models.Participant;
import models.Teacher;

public class TeacherRepository {
    
    Client client;

    public TeacherRepository() {
       
    }
//    public Teacher getTeacher(int participantId) {
//    
//        return t;
//    }

    public List<Teacher> getTeachers() {
        client = ClientBuilder.newClient();
        
        List <Teacher> teachers;
        
        teachers = client.target("http://localhost:8080/TestverktygDesktop/webapi/teachers")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Teacher>>(){});
        
        client.close();
        
        return teachers;
    }
    
}
