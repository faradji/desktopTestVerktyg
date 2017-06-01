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
import javafx.scene.input.MouseEvent;
import propertymodels.Test;
import repositories.TestRepository;

/**
 * FXML Controller class
 *
 * @author louiseahokas
 */
public class StudentStartPageController implements Initializable
{
    @FXML
    private Label labelStudentName;
    @FXML
    private TableView tableCourse;
    @FXML
    private TableColumn columnCourseName;
    @FXML
    private TableView tableTest;
    @FXML
    private TableColumn columnTestName;

    TestRepository testRepo = new TestRepository();
    public static Test currentTest;//fyll den med det test som studenten väljer

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        populateTableCourse();
        
        tableCourse.setOnMouseClicked((MouseEvent event)->
        {
            propertymodels.Test test = new propertymodels.Test();
            test = (propertymodels.Test) tableCourse.getSelectionModel().getSelectedItem();
            populateTableTests(test);
        });
    }

    public ObservableList getAndConvertTests()
    {
        List<models.Test> temp = testRepo.getTests();
        ObservableList<propertymodels.Test> tests = FXCollections.observableArrayList();

        for (int i = 0; i < temp.size(); i++)
        {

            propertymodels.Test tempProp = new propertymodels.Test(temp.get(i).getId(),
                    temp.get(i).getName(),
                    temp.get(i).getSubject(),
                    temp.get(i).getAutoCorrectedTest(),
                    temp.get(i).getTotalTime());
            
            tests.add(tempProp);
            
        }
        return tests;
    }
    
    public void populateTableCourse()
    {
        ObservableList<propertymodels.Test> tests = FXCollections.observableArrayList();

        tests = getAndConvertTests();

        tableCourse.setEditable(false);
        //tableCourse.getColumns().add(columnCourseName);

        columnCourseName.setCellValueFactory(new PropertyValueFactory<Test, String>("subject"));
        tests.setAll(getNoDuplicates(tests));
        tableCourse.setItems(tests);

    }
    
    
    public void populateTableTests(propertymodels.Test test)
    {
        ObservableList<propertymodels.Test> testsList = FXCollections.observableArrayList();
        testsList = getAndConvertTests(); 
        ObservableList<propertymodels.Test> testsFromSelectedCourse = FXCollections.observableArrayList();
        
        for(int i = 0; i < testsList.size(); i++)
        {
            if(testsList.get(i).getSubject().equals(test.getSubject()))
            {
                testsFromSelectedCourse.add(testsList.get(i));
            }
        }
        
        columnTestName.setCellValueFactory(new PropertyValueFactory<Test, String>("name"));
        tableTest.setItems(testsFromSelectedCourse);
        
    }

    public List<propertymodels.Test> getNoDuplicates(List<propertymodels.Test> tests)
    {
        List<propertymodels.Test> noDupeList = new ArrayList<>();
        int noDupeCounter = 0;
        noDupeList.add(tests.get(0));

        for (int i = 0; i < tests.size(); i++)
        {
            if (!tests.get(i).getSubject().equals(noDupeList.get(noDupeCounter).getSubject()))
            {
                noDupeList.add(tests.get(i));
                noDupeCounter += 1;

            }
        }
        
        return noDupeList;
    }

    @FXML
    private void goToTest(ActionEvent event)
    {
        
    }

}
