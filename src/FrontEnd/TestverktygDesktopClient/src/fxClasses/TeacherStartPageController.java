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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Test;
import propertymodels.Student;
import propertymodels.StudentAnswer;
import repositories.ParticipantRepository;
import repositories.TestRepository;





public class TeacherStartPageController implements Initializable {
    
    
    @FXML TableView tableDoneTests;
    @FXML Label teacherName;
    @FXML TableColumn columnStudent, columnCourse, columnTest;
    
    TestRepository tr = new TestRepository();
    
    
    public void addTest(ActionEvent event){
        
        //todo
        
    }
    
    
    private void populateTableViewTitle()
    {
        ObservableList<AuthorProp> temp = logicClass.getObservableListOfAuthors();
        titleColumn.setCellValueFactory(new PropertyValueFactory<BookProp, String>("title"));
        tableViewTitle.setItems(logicClass.getObservableListOfBooks());

        columnBoTitle.setCellValueFactory(new PropertyValueFactory<BookProp, String>("title"));
        columnBoAuName.setCellValueFactory(new PropertyValueFactory<BookProp, String>("author"));
        columnBoAbout.setCellValueFactory(new PropertyValueFactory<BookProp, String>("aboutBook"));
        columnBoCovUrl.setCellValueFactory(new PropertyValueFactory<BookProp, String>("bookImageURL"));
        columnBoISBN.setCellValueFactory(new PropertyValueFactory<BookProp, String>("ISBNorASIN"));
        columnBoLang.setCellValueFactory(new PropertyValueFactory<BookProp, String>("language"));
        columnBoNumPage.setCellValueFactory(new PropertyValueFactory<BookProp, Integer>("numOfPages"));

        //tableViewBooks.setItems(logicClass.getObservableListOfBooks());
    }
    
    public void populateTableDoneTests(){
        ObservableList<StudentAnswer> temp = tr.getStudentAnswers();
        tableDoneTests.getColumns().addAll(columnStudent, columnCourse, columnTest);
        tableDoneTests.setItems(temp);
        ParticipantRepository pr= new ParticipantRepository();
        List<Student> students = new ArrayList();
        temp.stream().forEach((t)->{
            students.add(pr.getParticipant(t.getParticipant_Id()));
        });
        columnStudent.setCellValueFactory(new PropertyValueFactory<, String>(""));
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        populateTableDoneTests();
    }    
    
}
