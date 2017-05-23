package com.mycompany.testverktygdesktop.resources;

import com.mycompany.testverktygdesktop.models.Question;
import com.mycompany.testverktygdesktop.repositories.QuestionRepository;
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

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class QuestionResource {

    QuestionRepository qr = new QuestionRepository();

    @GET
    @Path("/{questionId}")
    public Question getQuestion(@PathParam("questionId") int questionId) {

        return qr.getQuestion(questionId);
    }

    @GET
    public List<Question> getQuestions(@PathParam("testId") int testId) {
        return qr.getQuestions(testId);
    }

    @PUT
    public Question updateQuestion(@PathParam("testId") int testId, Question question) {
        return qr.updateQuestion(testId, question);
    }

    @POST
    public Question addQuestion(@PathParam("testId") int testId, Question question) {
        return qr.addQuestion(testId, question);
    }

    @DELETE
    @Path("/{questionId}")
    public void deleteQuestion(@PathParam("questionId") int questionId) {
        qr.deleteQuestion(questionId);
    }

}
