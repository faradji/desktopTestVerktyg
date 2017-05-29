/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxClasses;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Ali
 */



public class TeacherStartPageController implements Initializable {
    
    
    @FXML TableView tableDoneTests;
    @FXML Label teacherName;
    @FXML TableColumn columnStudent, columnCourse, columnTest;
    
    
    public void addTest(ActionEvent event){
        
        //todo
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
