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
    
    public TestRepository() {}

    public List<Test> getTests()
    {
        client = ClientBuilder.newClient();
        
        List <Test> tests;
        tests = client.target("http://localhost:8080/TestverktygDesktop/webapi/tests")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Test>>(){});
        
        client.close();
        return tests;
    }

    public ObservableList<StudentAnswer> getStudentAnswers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public models.Test addTest(Test newTest){
        
        client = ClientBuilder.newClient();
        models.Test testFromDatabase = client.target("http://localhost:8080/TestverktygDesktop/webapi/tests")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(newTest), Test.class);
        
        return testFromDatabase;
        
    }

}
