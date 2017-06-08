/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxClasses;

import static fxClasses.LoginController.currentTeacher;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import propertymodels.DoneTest;
import propertymodels.Test;
import repositories.DoneTestRepository;

public class TeacherStartPageController implements Initializable {
    static DoneTest test;
    @FXML
    TableView tableDoneTest;
    @FXML
    Label teacherName;
    @FXML
    TableColumn columnStudent, columnCourse, columnTest;
    @FXML
    TextField searchBar;

    DoneTestRepository doneTestRepo = new DoneTestRepository();
    ObservableList<propertymodels.DoneTest> doneTests = FXCollections.observableArrayList();
    ObservableList<propertymodels.DoneTest> searchBarList = FXCollections.observableArrayList();

    public void goToTest(ActionEvent event){
       try {
            
           test = (propertymodels.DoneTest) tableDoneTest.getSelectionModel().getSelectedItem();
            Parent correctTest = FXMLLoader.load(getClass().getResource("TeacherCorrectTest.fxml"));
            
            Scene scene = new Scene(correctTest);
            //Scene scene = new Scene(studentScene);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } 
    }
    
    public void addTest(ActionEvent event) {

        try {
            Parent studentScene = FXMLLoader.load(getClass().getResource("TeacherAddTest.fxml"));
            
            Scene scene = new Scene(studentScene);
            //Scene scene = new Scene(studentScene);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void populateTableDoneTests() {

        List<models.DoneTest> temp = doneTestRepo.getDoneTests();

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

    public void searchBar() {

        FilteredList<propertymodels.DoneTest> filteredData = new FilteredList<>(doneTests, p -> true);

        searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(doneTest -> {
              
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

               
                String lowerCaseFilter = newValue.toLowerCase();

                if (doneTest.getStudentName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false; 
            });
        });

       
        SortedList<propertymodels.DoneTest> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableDoneTest.comparatorProperty());
        tableDoneTest.setItems(sortedData);

    }
public void txtFieldValidation() {
        searchBar.setOnKeyReleased((KeyEvent event) -> {
            String regex = "[A-Za-z\\s]+";
            if (!searchBar.getText().matches(regex)) {
                JOptionPane.showMessageDialog(null, "Name can only contain letters.", "Inane error", JOptionPane.ERROR_MESSAGE);
                searchBar.setText("");

            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        teacherName.setText(currentTeacher.getName());
        populateTableDoneTests();
        searchBar();
        txtFieldValidation();
        

    }

}
