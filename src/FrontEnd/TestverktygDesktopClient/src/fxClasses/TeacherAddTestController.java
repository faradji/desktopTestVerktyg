/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxClasses;

import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import models.Question;

/**
 * FXML Controller class
 *
 * @author Allan
 */
public class TeacherAddTestController implements Initializable
{

    @FXML
    private Label labelTeacherName;
    @FXML
    private Label labelResponseAlt;
    @FXML
    private Label labelSubject;
    @FXML
    private Label labelSeeResult;
    @FXML
    private Label labelTimeLeft;
    @FXML
    private Label labelQuestionNr;
    @FXML
    private Label labelCheckBoxCorrect;
    @FXML
    private Label labelAddPic;
    @FXML
    private CheckBox chckBxYes;
    @FXML
    private CheckBox chckBxNo;
    @FXML
    private TextField textFieldTimeLeft;
    @FXML
    private TextField textFieldQuestionText;
    @FXML
    private TextField textFieldQuestionAlt1;
    @FXML
    private CheckBox checkBxQuestionAlt1;
    @FXML
    private TextField textFieldQuestionAlt2;
    @FXML
    private CheckBox checkBxQuestionAlt2;
    @FXML
    private CheckBox checkBxQuestionAlt3;
    @FXML
    private TextField textFieldQuestionAlt4;
    @FXML
    private CheckBox checkBxQuestionAlt4;
    @FXML
    private TextField textFieldQuestionAlt3;
    @FXML
    private ImageView imageViewImage;
    @FXML
    private TextField textFieldImageUrl;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnDone;

    List<Question> newQuestions = new ArrayList();

    int chosenCheckBoxId = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        chckBxYes.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue){
                chckBxNo.setSelected(false);
            }
        });
        
        chckBxNo.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue){
                chckBxYes.setSelected(false);
            }
        });
        //setLabelsOfTeacher();
    }

    @FXML
    private void checkBoxHandler(MouseEvent event)
    {
        String source1 = event.getSource().toString().substring(12, 31);

        switch (source1)
        {
            case "checkBxQuestionAlt1":
            {
                checkBxQuestionAlt1.selectedProperty().set(true);

                checkBxQuestionAlt2.selectedProperty().set(false);
                checkBxQuestionAlt3.selectedProperty().set(false);
                checkBxQuestionAlt4.selectedProperty().set(false);
                chosenCheckBoxId = 1;
                break;
            }

            case "checkBxQuestionAlt2":
            {
                checkBxQuestionAlt2.selectedProperty().set(true);

                checkBxQuestionAlt1.selectedProperty().set(false);
                checkBxQuestionAlt3.selectedProperty().set(false);
                checkBxQuestionAlt4.selectedProperty().set(false);
                chosenCheckBoxId = 2;
                break;
            }

            case "checkBxQuestionAlt3":
            {
                checkBxQuestionAlt3.selectedProperty().set(true);

                checkBxQuestionAlt1.selectedProperty().set(false);
                checkBxQuestionAlt2.selectedProperty().set(false);
                checkBxQuestionAlt4.selectedProperty().set(false);
                chosenCheckBoxId = 3;
                break;
            }

            case "checkBxQuestionAlt4":
            {
                checkBxQuestionAlt4.selectedProperty().set(true);

                checkBxQuestionAlt1.selectedProperty().set(false);
                checkBxQuestionAlt2.selectedProperty().set(false);
                checkBxQuestionAlt3.selectedProperty().set(false);
                chosenCheckBoxId = 4;
                break;
            }

        }
        labelTeacherName.setText(source1);
    }

    public void setLabelsOfTeacher()
    {
        labelTeacherName.setText(LoginController.currentTeacher.getName());
        labelSubject.setText(LoginController.currentTeacher.getSubject());
    }

    @FXML
    private void btnSaveAction(ActionEvent event)
    {
        Question q = new Question();

        q.setqText(textFieldQuestionText.getText());
        ArrayList<String> tempAnswers = new ArrayList<>();
        tempAnswers.add(textFieldQuestionAlt1.getText());
        tempAnswers.add(textFieldQuestionAlt2.getText());
        tempAnswers.add(textFieldQuestionAlt3.getText());
        tempAnswers.add(textFieldQuestionAlt4.getText());
        q.setImageURL(textFieldImageUrl.getText());
        q.setAnswers(tempAnswers);

        if (chosenCheckBoxId > 0)
        {
            q.setCorrectAnswer(chosenCheckBoxId-0);//om denna variabel ska visa vart i arrayen som svaret finns så måste det bli ett minus 1?
            
            newQuestions.add(q);

            textFieldQuestionText.clear();
            textFieldQuestionAlt1.clear();
            textFieldQuestionAlt2.clear();
            textFieldQuestionAlt3.clear();
            textFieldQuestionAlt4.clear();

            checkBxQuestionAlt1.selectedProperty().set(false);
            checkBxQuestionAlt2.selectedProperty().set(false);
            checkBxQuestionAlt3.selectedProperty().set(false);
            checkBxQuestionAlt4.selectedProperty().set(false);
        } else
        {
            System.out.println("Felmeddelande i GUI");
        }

    }

    @FXML
    private void btnDoneAction(ActionEvent event)
    {
        
    }

}
