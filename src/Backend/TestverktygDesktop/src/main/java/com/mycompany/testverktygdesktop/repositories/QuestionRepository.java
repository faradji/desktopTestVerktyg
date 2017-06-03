package com.mycompany.testverktygdesktop.repositories;

import com.mycompany.testverktygdesktop.models.Question;
import com.mycompany.testverktygdesktop.models.Test;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class QuestionRepository {

    SessionFactory sessionFactory;
    TestRepository testRepo = new TestRepository();

    public QuestionRepository() {
        sessionFactory = myHibernateUtil.getSessionFactory();
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
        Session session = sessionFactory.openSession();
        
        List<Question> questions =session.createCriteria(Question.class).list();

        session.close();
        return questions;

    }

    public Question updateQuestion(int testId, Question question) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Test test = (Test) session.get(Test.class, testId);
        question.setTest(test);
        session.update(question);

        session.getTransaction().commit();
        session.close();
        return question;
    }

    public Question addQuestion(int testId, Question question) {
        Session session = myHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Test test = (Test) session.get(Test.class, testId);
        
        
        question.setTest(test);
        
//        test.getQuestions().size();
//        test.getQuestions().add(question);
        
        session.save(test);
        
        session.getTransaction().commit();
        session.close();
        return question;
        
//        Test test = (Test) session.get(Test.class, testId);
//        Question q = new Question();
//        q.setTest(test);
//        
//        List<String> answers = question.getAnswers();
//        q.setAnswers((ArrayList) answers);
//        
//        q.setCorrectAnswer(question.getCorrectAnswer());
//        q.setqText(question.getqText());
//        q.setImageURL(question.getImageURL());
        
        
    }

    public void deleteQuestion(int questionId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Question question = (Question) session.get(Question.class, questionId);

        session.delete(question);
        session.getTransaction().commit();
        session.close();

    }

}
