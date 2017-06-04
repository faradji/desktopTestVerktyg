package com.mycompany.testverktygdesktop.repositories;

import com.mycompany.testverktygdesktop.models.Question;
import com.mycompany.testverktygdesktop.models.Test;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class QuestionRepository {

    SessionFactory sessionFactory;

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
        question.setTest_Id(test.getId());
        session.update(question);

        session.getTransaction().commit();
        session.close();
        return question;
    }

    public Question addQuestion(int testId, Question question) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
       // Test test = (Test) session.get(Test.class, testId);
       Question q = new Question(question.getId(), question.getqText(), question.getCorrectAnswer(),
               question.getAnswers(), question.getImageURL(),
               testId);
        session.save(q);
        session.getTransaction().commit();
        session.close();
        return question;
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
