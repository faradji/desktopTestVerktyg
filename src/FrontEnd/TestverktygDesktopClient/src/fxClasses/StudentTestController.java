package fxClasses;

//import static fxClasses.LoginController.currentStudent;
import java.io.IOException;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import propertymodels.Question;
import propertymodels.StudentAnswer;
import propertymodels.Test;
import repositories.QuestionRepository;
import repositories.StudentAnswerRepository;

public class StudentTestController implements Initializable {

    QuestionRepository qr = new QuestionRepository();
    ObservableList<Question> observableQuestions = FXCollections.observableArrayList();
    List<StudentAnswer> answers = new ArrayList();
    List<models.Question> questions;
    Question currentQ;
    Timeline timeline = null;
    Test currentTest;

    Integer startTime;
    IntegerProperty timeSeconds;
    int chosenCheckBoxId;
    String emptyUrl = "http://www.jennybeaumont.com/wp-content/uploads/2015/03/placeholder-800x423.gif";

    @FXML private Label lblTestSubject, lblTimeLeft, lblTeacherSubject, lblcurrentQuestionNR, lblQuestionText;
    @FXML private Label quealternativ1, quealternativ2, quealternativ3, quealternativ4;
    @FXML private Label lblCorrectAnswers;
    
    @FXML private ListView lvQuestionsNR;
    @FXML private ListView lvCorrectedQuestion;
    
    @FXML private CheckBox chbxalternativ1;
    @FXML private CheckBox chbxalternativ3;
    @FXML private CheckBox chbxalternativ4;
    @FXML private CheckBox chbxalternativ2;
    
    @FXML private ImageView ivImage;
    @FXML private Button btnSaveTest, btnDone;

    private void populateListView()
    {
        //populate listview
        System.out.println("Antalet frågor i provet: " + questions.size());
        for (int i = 0; i < questions.size(); i++)
        {
                if (currentTest.getId()== questions.get(i).getTest_Id()) 
                {
                    models.Question q = questions.get(i);
                    observableQuestions.add(new Question(q.getId(), q.getqText(), q.getCorrectAnswer(),
                        q.getImageURL(), q.getAnswers(), q.getTest_Id()));
                }
        }

        lvQuestionsNR.setItems(observableQuestions);
    }

    @FXML
    private void btnSaveTestAction()
    {
        System.out.println("btnSaveTestAction");
        chbxalternativ1.setDisable(true);
        chbxalternativ2.setDisable(true);
        chbxalternativ3.setDisable(true);
        chbxalternativ4.setDisable(true);
        
        btnDone.setVisible(true);
        
        int correctAnswers = 0;
        
        if (currentTest.getAutoCorrectedTest() >= 1)
        {
            for (int i = 0; i < questions.size(); i++)
            {
                for (int j = 0; j < answers.size(); j++)
                {
                    if (questions.get(i).getId() == answers.get(j).getQuestion_Id())
                    {
                        if (questions.get(i).getCorrectAnswer() == answers.get(j).getGivenAnswer())
                        {
                            correctAnswers++;
                        }
                    }
                }
            }
        }
        
        lblCorrectAnswers.setText("Points: " + correctAnswers + "/" + questions.size());
    }
    
    @FXML
    private void btnDoneClicked(ActionEvent event) throws IOException
    {
        StudentAnswerRepository saRepo = new StudentAnswerRepository();
        
        
        //Stänger scenen och går tillbaka
        Parent studentTestParent = FXMLLoader.load(getClass().getResource("StudentStartPage.fxml"));
        Scene studentTestScene = new Scene(studentTestParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(studentTestScene);
        window.show();
    
    }
    
    @FXML
    private void checkBoxHandler(MouseEvent event)
    {
        String source1 = event.getSource().toString().substring(12, 27);
        System.out.println(source1);
        switch (source1)
        {
            case "chbxalternativ1":
            {
                chbxalternativ1.selectedProperty().set(true);
                chosenCheckBoxId = 1;

                saveDoneQuestion();
                emptyCheckBoxes(true);
                break;
            }

            case "chbxalternativ2":
            {
                chbxalternativ2.selectedProperty().set(true);
                chosenCheckBoxId = 2;

                saveDoneQuestion();
                emptyCheckBoxes(true);
                break;
            }

            case "chbxalternativ3":
            {
                chbxalternativ3.selectedProperty().set(true);
                chosenCheckBoxId = 3;

                saveDoneQuestion();
                emptyCheckBoxes(true);
                break;
            }

            case "chbxalternativ4":
            {
                chbxalternativ4.selectedProperty().set(true);
                chosenCheckBoxId = 4;

                saveDoneQuestion();
                emptyCheckBoxes(true);
                break;
            }

        }
    }

    private void saveDoneQuestion()
    {
        System.out.println("CurrentQuestion: " + currentQ.getId());
        StudentAnswer answer = new StudentAnswer(3, currentQ.getId(), chosenCheckBoxId, Date.valueOf(LocalDate.MAX));
        //answer.setDate(Date.valueOf(LocalDate.MAX));

        //answer.setGivenAnswer(chosenCheckBoxId);
        System.out.println("Rätt svar: " + currentQ.getCorrectAnswer());
        System.out.println("Givet svar: " + chosenCheckBoxId);
        
        //answer.setParticipant_Id(3);
        //answer.setQuestion_Id(currentQ.getId());
        if (answers.isEmpty())
        {
            answers.add(answer);
            System.out.println("Answer added to empty array");
        } else 
        {
            for (int i = 0; i < answers.size(); i++)
            {
                System.out.println("Answer.getQuestion_Id(): " + answer.getQuestion_Id());
                System.out.println("answers.get(i).getQuestion_Id(): " + answers.get(i).getQuestion_Id());
                if (answer.getQuestion_Id() == answers.get(i).getQuestion_Id())
                {
                    answers.set(i, answer);
                    System.out.println("Answer replaced");
                    break;
                } else
                {
                    if (i == answers.size() - 1)
                    {
                        answers.add(answer);
                        System.out.println("Answer added to existing array");
                        break;
                    }
                }
            }
        }

//        answers.stream().forEach((a) -> {
//            if (answer.getQuestion_Id() == a.getQuestion_Id() && answers != null) {
//                answers.remove(a);
//                answers.add(answer);
//                System.out.println("Answer replaced");
//            }
//            else
//            {
//                answers.add(answer);
//                System.out.println("Answer added");
//            }
//        });
        if (answers.size() == observableQuestions.size()) 
        {
            btnSaveTestAction();
        }
    }

    @FXML
    private void lvQuestionsNRSelected()
    {
        emptyCheckBoxes(false);
        currentQuestion();

        fillCheckBox();
    }

    private void currentQuestion()
    {
        // hålla reda på current question
        currentQ = (Question) lvQuestionsNR.getSelectionModel().getSelectedItem();
        lblcurrentQuestionNR.setText("Question: " + String.valueOf(lvQuestionsNR.getSelectionModel().getSelectedIndex() + 1));
        Image image;
        
        if (currentQ != null)
        {
            lblQuestionText.setText(currentQ.getqText());

            if (currentQ.getImageURL() == null)
            {
                currentQ.setImageURL(emptyUrl); //emptyIrl finns definierad längst upp
            }
            
            image = new Image(currentQ.getImageURL());
            ivImage.setImage(image);
            
            for (int i = 0; i < currentQ.getAnswers().size(); i++)
            {
                //Dessa rader kommer alltid att få ut värdet på svaret i en sträng
                String currentQue = currentQ.getAnswers().get(i).toString().substring(20);
                currentQue = currentQue.substring(0, currentQue.length() - 1);

                switch (i)
                {
                    case 0:
                        quealternativ1.setText(currentQue);
                        break;
                    case 1:
                        quealternativ2.setText(currentQue);
                        break;
                    case 2:
                        quealternativ3.setText(currentQue);
                        break;
                    case 3:
                        quealternativ4.setText(currentQue);
                        break;

                }
            }
            
            for (int i = 0; i < answers.size(); i++)
            {
                System.out.println("For-loop startad");
                System.out.println("currentQ.getId(): " + currentQ.getId());
                System.out.println("answers.get(i).getQuestion_Id(): " + answers.get(i).getQuestion_Id());
                System.out.println("currentQ.getText(): " + currentQ.getqText());
                if (currentQ.getId() == answers.get(i).getQuestion_Id())
                {
                    fillCheckBox();
                }
            }
        }
    }

    private void startTimer()
    {
        //timer for time left
        lblTimeLeft.textProperty().bind(timeSeconds.asString());

        if (timeline != null)
        {
            timeline.stop();
        }
        timeSeconds.set(startTime);
        timeline = new Timeline();
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(startTime + 1),
                        new KeyValue(timeSeconds, 0)));
        timeline.playFromStart();
        
        timeline.setOnFinished((event) -> 
        {
            //Tiden för testet ska gå ut
            System.out.println("Tiden för testet har gått ut");
            btnSaveTestAction();
        });
    }

    private void emptyCheckBoxes(boolean goToNextQuestion)
    {
        if (goToNextQuestion)
        {
            lvQuestionsNR.getSelectionModel().select(lvQuestionsNR.getSelectionModel().getSelectedIndex() + 1);
            currentQuestion();
        }
        
        chbxalternativ1.selectedProperty().set(false);
        chbxalternativ2.selectedProperty().set(false);
        chbxalternativ3.selectedProperty().set(false);
        chbxalternativ4.selectedProperty().set(false);
    }
    
    private List<models.Question> loadQuestions()
    {
        List<models.Question> allQuestions = qr.getQuestions();
        List<models.Question> filteredQuestions = new ArrayList();
        
        for (models.Question q : allQuestions)
        {
            if (currentTest.getId() == q.getTest_Id())
            {
                filteredQuestions.add(q);
            }
        }
        
        return filteredQuestions;
    }
    
    private void fillCheckBox()
    {
        for (int i = 0; i < answers.size(); i++)
        {
            if (currentQ.getId() == answers.get(i).getQuestion_Id())
            {
                switch (answers.get(i).getGivenAnswer())
                {
                    case 1:
                        chbxalternativ1.selectedProperty().set(true);
                        
                        chbxalternativ2.selectedProperty().set(false);
                        chbxalternativ3.selectedProperty().set(false);
                        chbxalternativ4.selectedProperty().set(false);
                        break;
                    case 2:
                        chbxalternativ2.selectedProperty().set(true);
                        
                        chbxalternativ1.selectedProperty().set(false);
                        chbxalternativ3.selectedProperty().set(false);
                        chbxalternativ4.selectedProperty().set(false);
                        break;
                    case 3:
                        chbxalternativ3.selectedProperty().set(true);
                        
                        chbxalternativ1.selectedProperty().set(false);
                        chbxalternativ2.selectedProperty().set(false);
                        chbxalternativ4.selectedProperty().set(false);
                        break;
                    case 4:
                        chbxalternativ4.selectedProperty().set(true);
                        
                        chbxalternativ1.selectedProperty().set(false);
                        chbxalternativ2.selectedProperty().set(false);
                        chbxalternativ3.selectedProperty().set(false);
                        break;
                    default:
                        break;
                }
                break;
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        currentTest = StudentStartPageController.currentTest;
        startTime = currentTest.getTotalTime();
        timeSeconds = new SimpleIntegerProperty(startTime);
        chosenCheckBoxId = 0;
        
        startTimer();
        questions = loadQuestions();
        populateListView();

        lvQuestionsNR.getSelectionModel().select(0);
        currentQuestion();

        //populate labels med info
        //lblTeacherSubject.setText(currentTest.getSubject());
        lblTestSubject.setText("Subject: " + currentTest.getSubject());
    }

}
