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
import repositories.DoneTestRepository;

public class TeacherStartPageController implements Initializable {

    @FXML
    TableView tableDoneTest;
    @FXML
    Label teacherName;
    @FXML
    TableColumn columnStudent, columnCourse, columnTest;

    DoneTestRepository doneTestRepo = new DoneTestRepository();

    public void addTest(ActionEvent event) {

        //todo
    }

    private void populateTableViewTitle() {
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

    public void populateTableDoneTests() {

        List<models.DoneTest> temp = doneTestRepo.getDoneTests();
        ObservableList<propertymodels.DoneTest> doneTests = FXCollections.observableArrayList();

        for (int i = 0; i < temp.size(); i++) {

            propertymodels.DoneTest tempProp = new propertymodels.DoneTest(temp.get(i).getStudentid(),
                    temp.get(i).getStudentName(),
                    temp.get(i).getCourse(),
                    temp.get(i).getTestName(),
                    temp.get(i).getGivenAnswer());

//            for(int j = 0; j < temp.get(i).getQuestions().size(); j++){
//                List<propertymodels.Question> tempQ = new ArrayList();
//                propertymodels.Question q = new propertymodels.Question();
//            }
//tempProp.setQuestions(temp.get(i).getQuestions());
            doneTests.add(tempProp);

        }

        tableDoneTest.setEditable(false);

        
        columnStudent.setCellValueFactory(
                new PropertyValueFactory<propertymodels.DoneTest, String>("studentName")
        );
        columnCourse.setCellValueFactory(
                new PropertyValueFactory<propertymodels.DoneTest, String>("course")
        );
        columnTest.setCellValueFactory(
                new PropertyValueFactory<propertymodels.DoneTest, String>("testName")
        );

        tableDoneTest.setItems(doneTests);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        populateTableDoneTests();
    }

}
