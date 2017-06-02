package repositories;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

public class TeacherRepository {

    Client client;

    public TeacherRepository() {

    }

    public List<models.Teacher> getTeachers() {

        client = ClientBuilder.newClient();

        List<models.Teacher> Teachers;
        Teachers = client.target("http://localhost:8080/TestverktygDesktop/webapi/participants")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<models.Teacher>>() {
                });

        client.close();

        return Teachers;
    }

    public models.Teacher getTeacher(int id) {

        client = ClientBuilder.newClient();

        models.Teacher Teacher;
        Teacher = client.target("http://localhost:8080/TestverktygDesktop/webapi/participants")
                .path(String.valueOf(id))
                .request(MediaType.APPLICATION_JSON)
                .get(models.Teacher.class);

        client.close();

        return Teacher;
    }
    
    public models.Teacher getTeacherByName(String name) {

        client = ClientBuilder.newClient();

        models.Teacher teacher;
        teacher = client.target("http://localhost:8080/TestverktygDesktop/webapi/participants")
                .path(name)
                .request(MediaType.APPLICATION_JSON)
                .get(models.Teacher.class);

        client.close();

        return teacher;
    }

}
