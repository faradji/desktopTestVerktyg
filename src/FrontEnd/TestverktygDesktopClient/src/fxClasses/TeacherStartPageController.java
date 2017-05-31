/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxClasses;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import propertymodels.DoneTest;
import propertymodels.Student;
import propertymodels.StudentAnswer;
import repositories.DoneTestRepository;
import repositories.ParticipantRepository;
import repositories.TestRepository;

public class TeacherStartPageController implements Initializable
{

    @FXML
    TableView tableDoneTests;
    @FXML
    Label teacherName;
    @FXML
    TableColumn columnStudent, columnCourse, columnTest;

    DoneTestRepository doneTestRepo = new DoneTestRepository();

    public void addTest(ActionEvent event)
    {

        //todo
    }

    private void populateTableViewTitle()
    {
//        ObservableList<AuthorProp> temp = logicClass.getObservableListOfAuthors();
//        titleColumn.setCellValueFactory(new PropertyValueFactory<BookProp, String>("title"));
//        tableViewTitle.setItems(logicClass.getObservableListOfBooks());
//
//        columnBoTitle.setCellValueFactory(new PropertyValueFactory<BookProp, String>("title"));
//        columnBoAuName.setCellValueFactory(new PropertyValueFactory<BookProp, String>("author"));
//        columnBoAbout.setCellValueFactory(new PropertyValueFactory<BookProp, String>("aboutBook"));
//        columnBoCovUrl.setCellValueFactory(new PropertyValueFactory<BookProp, String>("bookImageURL"));
//        columnBoISBN.setCellValueFactory(new PropertyValueFactory<BookProp, String>("ISBNorASIN"));
//        columnBoLang.setCellValueFactory(new PropertyValueFactory<BookProp, String>("language"));
//        columnBoNumPage.setCellValueFactory(new PropertyValueFactory<BookProp, Integer>("numOfPages"));

        //tableViewBooks.setItems(logicClass.getObservableListOfBooks());
    }

    public void populateTableDoneTests()
    {
        
        List<models.DoneTest> temp = doneTestRepo.getDoneTests();
        ObservableList<propertymodels.DoneTest> doneTests = FXCollections.observableArrayList();
        System.out.println("utanför for loopen" + temp.get(0).getCourse());
        propertymodels.DoneTest tempProp = new propertymodels.DoneTest();
        
        for(int i = 0; i < temp.size(); i++){
            
            System.out.println("i for loopen" + temp.get(i).getCourse());
            tempProp.setCourse(temp.get(i).getCourse());
            tempProp.setGivenAnswer(temp.get(i).getGivenAnswer());
            tempProp.setStudentName(temp.get(i).getStudentName());
            tempProp.setStudentid(temp.get(i).getStudentid());
            tempProp.setTestName(temp.get(i).getTestName());
            
            for(int j = 0; j < temp.get(i).getQuestions().size(); j++){
                List<propertymodels.Question> tempQ = new ArrayList();
                propertymodels.Question q = new propertymodels.Question();
                propertymodels.Test tempTest = new propertymodels.Test();
                
                q.setAnswers(temp.get(i).getQuestions().get(j).getAnswers());
                q.setCorrectAnswer(temp.get(i).getQuestions().get(j).getCorrectAnswer());
                q.setId(temp.get(i).getQuestions().get(j).getId());
                //q.setTest(temp.get(i).getQuestions().get(j).getTest());
            }
//tempProp.setQuestions(temp.get(i).getQuestions());
            
            
            doneTests.add(tempProp);   
        }
        tableDoneTests.getColumns().addAll(columnStudent, columnCourse, columnTest);
        
        
        columnStudent.setCellValueFactory(new PropertyValueFactory<propertymodels.DoneTest, String>("studentName"));
        columnCourse.setCellValueFactory(new PropertyValueFactory<propertymodels.DoneTest, String>("course"));
        columnTest.setCellValueFactory(new PropertyValueFactory<propertymodels.DoneTest, String>("testName"));
        tableDoneTests.setItems(doneTests);
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        populateTableDoneTests();
    }

}
