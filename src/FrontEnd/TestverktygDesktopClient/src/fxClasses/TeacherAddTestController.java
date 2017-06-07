package fxClasses;

import static fxClasses.LoginController.currentTeacher;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import models.Question;
import repositories.QuestionRepository;
import repositories.TestRepository;

/**
 * FXML Controller class
 *
 * @author Allan
 */
public class TeacherAddTestController implements Initializable
{
    TestRepository tr = new TestRepository();
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
    private TextField textFieldTestName;
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

    List<models.Question> newQuestions = new ArrayList();
    ArrayList<String> tempAnswers = new ArrayList<>();
    int idOfLastTestInList;

    int chosenCheckBoxId = 0;
    int questionNumCount = 1;

    int isAutoCorrected;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        labelQuestionNr.setText("Fråga nummer " + questionNumCount);
        
        chckBxYes.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue){
                chckBxNo.setSelected(false);
                isAutoCorrected = 1;
                
            }
        });
        
        chckBxNo.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue){
                chckBxYes.setSelected(false);
                isAutoCorrected = 0;
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
        labelTeacherName.setText(currentTeacher.getName());
        labelSubject.setText(currentTeacher.getSubject());

    }

    @FXML
    private void btnSaveAction(ActionEvent event)
    {
        models.Question q = new Question();

        q.setqText(textFieldQuestionText.getText());
        tempAnswers.add(textFieldQuestionAlt1.getText());
        tempAnswers.add(textFieldQuestionAlt2.getText());
        tempAnswers.add(textFieldQuestionAlt3.getText());
        tempAnswers.add(textFieldQuestionAlt4.getText());
        q.setImageURL(textFieldImageUrl.getText());
        q.setAnswers(tempAnswers);

        if (chosenCheckBoxId > 0)
        {
            q.setCorrectAnswer(chosenCheckBoxId - 0);//om denna variabel ska visa vart i arrayen som svaret finns så måste det bli ett minus 1?
            
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

        questionNumCount++;

    }

    @FXML
    private void btnDoneAction(ActionEvent event)
    {
        QuestionRepository qr = new QuestionRepository();
        
        models.Test t = new models.Test();
        t.setName(textFieldTestName.getText());
        t.setAutoCorrectedTest(isAutoCorrected);
        t.setSubject(LoginController.currentTeacher.getSubject());
        int totalTime = Integer.parseInt(textFieldTimeLeft.getText());
        totalTime = totalTime *60;
        t.setTotalTime(totalTime);
        
        models.Test newTest = tr.addTest(t);
        
        
        for(int i = 0; i < newQuestions.size(); i++)
        {
            models.Question q = new models.Question();
            q.setqText(newQuestions.get(i).getqText());
            q.setAnswers(newQuestions.get(i).getAnswers());
            q.setImageURL(newQuestions.get(i).getImageURL());
            q.setCorrectAnswer(newQuestions.get(i).getCorrectAnswer());
            q.setTest_Id(newTest.getId());
            
            qr.addQuestion(newTest.getId(), q);
            
        }
        
    }

}
