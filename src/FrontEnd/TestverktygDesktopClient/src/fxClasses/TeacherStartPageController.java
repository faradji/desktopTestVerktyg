/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxClasses;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import repositories.DoneTestRepository;

public class TeacherStartPageController implements Initializable {

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
    public void addTest(ActionEvent event) {

        //todo
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
public void searchBar(){
//
//        searchBar.textProperty().addListener(new ChangeListener() {
//            @Override
//            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
//                if(newValue !=null){
//                      doneTests.stream().forEach((d)->{
//                    
//                        if(searchBar.getText().equalsIgnoreCase(d.getStudentName())){
//                            searchBarList.add(d);
//                        }
//                    
//                    });
//                    doneTests.clear();
//                    tableDoneTest.setItems(searchBarList);
//                }else{
//                    searchBarList.clear();
//                    populateTableDoneTests();
//                }
//                
//             }
//
//           
//
//        });

  FilteredList<propertymodels.DoneTest> filteredData = new FilteredList<>(doneTests, p -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(doneTest -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (doneTest.getStudentName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } 
                return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<propertymodels.DoneTest> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(tableDoneTest.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tableDoneTest.setItems(sortedData);

}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        populateTableDoneTests();
        searchBar();
       

    }

}
