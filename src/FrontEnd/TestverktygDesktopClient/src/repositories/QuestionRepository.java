package repositories;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import models.Question;
import java.util.List;
import javax.ws.rs.core.GenericType;
import models.Test;

public class QuestionRepository {
    
    Client client;
    
    public QuestionRepository() {}
        
    public void addQuestion(int testId, Question newQuestion){
        String testIdPath = Integer.toString(testId);
        client = ClientBuilder.newClient();
        client.target("http://localhost:8080/TestverktygDesktop/webapi/questions/")
                .path(testIdPath)
//                .path("/questions")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(newQuestion), Question.class);
      
    }

//    public Question getQuestion(int testId,int questionId) {
//        Session session = sessionFactory.openSession();
//        Test test=(Test) session.get(Test.class, testId);
//        Question question = null;
//        test.getQuestions().stream().forEach((t)->{
//        if(t.getId()==questionId){
//            question.setAnswers(t.getAnswers());
//            question.setCorrectAnswer(t.getCorrectAnswer());
//            question.setId(t.getId());
//            question.setqText(t.getqText());
//            question.setTest(test);
//        }else{
//            System.out.println("Question not found in QuestionRepository/getQuestion()");
//        }
//        });
//        
//        session.close();
//        return question;
//    }

    public List<Question> getQuestions() {
        List<Question> questions;
        
        Client client = ClientBuilder.newClient();

        questions = client.target("http://localhost:8080/TestverktygDesktop/webapi/questions")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType <List<Question>>() {
                });

        client.close();
        return questions;

    }

//    public Question updateQuestion(int testId, Question question) {
//       
//        return question;
//    }
//
//    public void deleteQuestion(int questionId) {
//
//
//    }

}
