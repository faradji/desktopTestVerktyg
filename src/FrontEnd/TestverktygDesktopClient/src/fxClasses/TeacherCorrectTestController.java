/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxClasses;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import models.DoneTest;
import propertymodels.Question;
import models.Teacher;
import models.Test;
import repositories.DoneTestRepository;
import repositories.QuestionRepository;

/**
 * FXML Controller class
 *
 * @author Ali
 */
public class TeacherCorrectTestController implements Initializable {
    
    //Objekt
    Teacher currentTeacher;
    Test currentTest;
    DoneTestRepository doneTestRepo = new DoneTestRepository();
    ObservableList<Question> observableQuestionList = FXCollections.observableArrayList();
    List<models.Question> questionList = new ArrayList();
    List<DoneTest> doneTests = doneTestRepo.getDoneTests();

    //FXML-fält
    @FXML ListView lvQuestionList;
    @FXML Button btnGoBack;
    
    @FXML Label lblTestName;
    @FXML Label lblOptionOne, lblOptionTwo, lblOptionThree, lblOptionFour, lblGivenAnswer, lblCorrectAnswer;
    
    //Metoden är länkad till btnGoBack
    @FXML private void btnGoBackAction(ActionEvent event) throws IOException
    {
        //Stänger scenen och går tillbaka
        Parent studentTestParent = FXMLLoader.load(getClass().getResource("TeacherStartPage.fxml"));
        Scene studentTestScene = new Scene(studentTestParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(studentTestScene);
        window.show();
    }
    
    //Metoden är länkad till en ListView med frågorna på provet
    @FXML private void lvQuestionListSelected()
    {
        Question currentQuestion = (Question) lvQuestionList.getSelectionModel().getSelectedItem();
        
        for (int i = 0; i < currentQuestion.getAnswers().size(); i++)
            {
                //Dessa rader kommer alltid att få ut värdet på svaret i en sträng
                String currentQue = currentQuestion.getAnswers().get(i).toString().substring(20);
                currentQue = currentQue.substring(0, currentQue.length() - 1);

                switch (i)
                {
                    case 0:
                        lblOptionOne.setText("Option 1: " + currentQue);
                        break;
                    case 1:
                        lblOptionTwo.setText("Option 2: " + currentQue);
                        break;
                    case 2:
                        lblOptionThree.setText("Option 3: " + currentQue);
                        break;
                    case 3:
                        lblOptionFour.setText("Option 4: " + currentQue);
                        break;

                }
            }
        
        int index = lvQuestionList.getSelectionModel().getSelectedIndex();
        lblGivenAnswer.setText("The student chose option " + doneTests.get(index).getGivenAnswer());
        lblCorrectAnswer.setText("Correct answer was: " + questionList.get(index).getCorrectAnswer());
    }
    
    //Metoden filtrerar frågorna i databasen så man får dem som tillhör det nuvarande provet
    private List<models.Question> loadQuestions()
    {
        QuestionRepository qr = new QuestionRepository();
        List<models.Question> allQuestions = qr.getQuestions();
        System.out.println(allQuestions);
        List<models.Question> filteredQuestions = new ArrayList();
        
        allQuestions.stream().filter((q) -> (currentTest.getId() == q.getTest_Id())).forEach((q) ->
        {
            filteredQuestions.add(q);
        });
        
        return filteredQuestions;
    }
    
    //Anropas i initialize, visar frågorna på provet i en listview
    private void populateListView()
    {
        //populate listview
        for (int i = 0; i < currentTest.getQuestions().size(); i++)
        {
                if (currentTest.getId()== currentTest.getQuestions().get(i).getTest_Id()) 
                {
                    models.Question q = currentTest.getQuestions().get(i);
                    observableQuestionList.add(new propertymodels.Question(q.getId(), q.getqText(), q.getCorrectAnswer(),
                        q.getImageURL(), q.getAnswers(), q.getTest_Id()));
                }
        }

        lvQuestionList.setItems(observableQuestionList);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        currentTeacher = new Teacher(); //Ändra till den inloggade läraren senare
        currentTeacher.setName("Test"); //Ta bort sen
        currentTest = new Test(); //Ändra till det valda provet senare
        currentTest.setName("Musikhistoria"); //Ta bort sen
        currentTest.setId(1); //Ta bort sen
        currentTest.setQuestions(loadQuestions()); //Ta bort sen
        
        questionList = loadQuestions();
        populateListView();
        
        lblTestName.setText(currentTest.getName());
    }    
    
}
