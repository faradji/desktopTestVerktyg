package com.mycompany.testverktygdesktop.resources;

import com.mycompany.testverktygdesktop.models.Test;
import com.mycompany.testverktygdesktop.repositories.TestRepository;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;

@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class TestResource {

    TestRepository tr = new TestRepository();

    @Path("/{testId}")
    @GET
    public Test getTest(@PathParam("testId") int testId) {
        Test test = tr.getTest(testId);
        System.out.println(test);

        return test;
    }

    @GET
    public List<Test> getTests() {
        return tr.getTests();
    }

    @POST
    public Test addTest(Test test) {
        return tr.addTest(test);
    }

    @PUT
    public Test updateTest(Test test) {
        return tr.updateTest(test);
    }

    @DELETE
    @Path("/{testId}")
    public void deleteTest(@PathParam("testId") int testId) {
        tr.deleteTest(testId);
    }

    @Path("/{testId}/question")
    public QuestionResource question() {
        return new QuestionResource();
    }

}
