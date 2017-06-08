package repositories;

import java.util.List;
import javafx.collections.ObservableList;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import models.DoneTest;
import models.Test;
import propertymodels.StudentAnswer;

public class TestRepository {

    Client client;

    public TestRepository() {
    }

    public List<Test> getTests() {
        client = ClientBuilder.newClient();

        List<Test> tests;
        tests = client.target("http://localhost:8080/TestverktygDesktop/webapi/tests")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Test>>() {
                });
        System.out.println("test 1-----------" + tests.get(0).getQuestions().size());
        System.out.println("test 2-----------" + tests.get(1).getQuestions().size());
        System.out.println("test 3-----------" + tests.get(2).getQuestions().size());
        client.close();
        return tests;
    }

    public Test getTest(int id) {
        client = ClientBuilder.newClient();

        Test test;
        test = client.target("http://localhost:8080/TestverktygDesktop/webapi/tests")
                .path(String.valueOf(id))
                .request(MediaType.APPLICATION_JSON)
                .get(Test.class);

        client.close();
        return test;
    }

    public models.Test addTest(int teacher_id, Test newTest) {

        client = ClientBuilder.newClient();
        String teacherIdPath = Integer.toString(teacher_id);

        models.Test testFromDatabase = client.target("http://localhost:8080/TestverktygDesktop/webapi/teachers")
                .path(teacherIdPath)
                .path("/tests")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(newTest), Test.class);

        return testFromDatabase;

    }

}
