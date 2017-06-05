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
    List<StudentAnswer> answers = new ArrayList();
    List<models.Question> questions = qr.getQuestions();
    ObservableList<Question> observableQuestions = FXCollections.observableArrayList();
    Question currentQ;
    final Integer startTime = 10;
    Timeline timeline = null;
    IntegerProperty timeSeconds = new SimpleIntegerProperty(startTime);

    Test currentTest = StudentStartPageController.currentTest;

    int chosenCheckBoxId = 0;
    String emptyUrl = "http://www.jennybeaumont.com/wp-content/uploads/2015/03/placeholder-800x423.gif";

    @FXML
    private Label lblTestSubject, lblTimeLeft, lblTeacherSubject, lblcurrentQuestionNR, lblQuestionText;
    @FXML
    private Label quealternativ1, quealternativ2, quealternativ3, quealternativ4;
    @FXML private Label lblCorrectAnswers;
    @FXML
    private ListView lvQuestionsNR;
    @FXML
    private ListView lvCorrectedQuestion;
    @FXML
    private CheckBox chbxalternativ1;
    @FXML
    private CheckBox chbxalternativ3;
    @FXML
    private CheckBox chbxalternativ4;
    @FXML
    private CheckBox chbxalternativ2;
    @FXML
    private ImageView ivImage;
    @FXML
    private Button btnSaveTest, btnDone;

    public void populateListView()
    {
        //populate listview
        System.out.println(questions.size());
        for (int i = 0; i < questions.size(); i++)
        {
            //      if (currentTest.getId()== questions.get(i).getTest_Id()) {
            observableQuestions.add(new Question(questions.get(i).getId(), questions.get(i).getqText(),
                    questions.get(i).getCorrectAnswer(), questions.get(i).getImageURL(),
                    questions.get(i).getAnswers(), questions.get(i).getTest_Id()));
            //    }
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
    private void btnDoneClicked()
    {
        StudentAnswerRepository saRepo = new StudentAnswerRepository();
        
        
    }
    
    @FXML
    public void checkBoxHandler(MouseEvent event)
    {
        String source1 = event.getSource().toString().substring(12, 27);
        System.out.println(source1);
        switch (source1)
        {
            case "chbxalternativ1":
            {
                chbxalternativ1.selectedProperty().set(true);

                chbxalternativ2.selectedProperty().set(false);
                chbxalternativ3.selectedProperty().set(false);
                chbxalternativ4.selectedProperty().set(false);
                chosenCheckBoxId = 1;

                saveDoneQuestion();
                emptyCheckboxes();
                break;
            }

            case "chbxalternativ2":
            {
                chbxalternativ2.selectedProperty().set(true);

                chbxalternativ1.selectedProperty().set(false);
                chbxalternativ3.selectedProperty().set(false);
                chbxalternativ4.selectedProperty().set(false);
                chosenCheckBoxId = 2;

                saveDoneQuestion();
                emptyCheckboxes();
                break;
            }

            case "chbxalternativ3":
            {
                chbxalternativ3.selectedProperty().set(true);

                chbxalternativ1.selectedProperty().set(false);
                chbxalternativ2.selectedProperty().set(false);
                chbxalternativ4.selectedProperty().set(false);
                chosenCheckBoxId = 3;

                saveDoneQuestion();
                emptyCheckboxes();
                break;
            }

            case "chbxalternativ4":
            {
                chbxalternativ4.selectedProperty().set(true);

                chbxalternativ1.selectedProperty().set(false);
                chbxalternativ2.selectedProperty().set(false);
                chbxalternativ3.selectedProperty().set(false);
                chosenCheckBoxId = 4;

                saveDoneQuestion();
                emptyCheckboxes();
                break;
            }

        }
    }

    public void saveDoneQuestion()
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
//        if (answers.size() == observableQuestions.size()) {
//            //byt till startpage för student
//            try {
//                // go to create account scene
//                Stage goToNextStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                Parent p = FXMLLoader.load(getClass().getResource("createAccount.fxml"));
//                Scene GoToNextScene = new Scene(p);
//
//                goToNextStage.setScene(GoToNextScene);
//                goToNextStage.setResizable(false);
//                goToNextStage.setTitle("Create a new account");
//                goToNextStage.show();
//
//            } catch (IOException e) {
//                System.out.println(e.getCause());
//            }
//        }
    }

    @FXML
    public void lvQuestionsNRSelected()
    {
        lblcurrentQuestionNR.setText("Question: " + String.valueOf(lvQuestionsNR.getSelectionModel().getSelectedIndex() + 1));
        currentQuestion();

        System.out.println("Answers: " + answers);
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

    public void currentQuestion()
    {
        // hålla reda på current question
        currentQ = (Question) lvQuestionsNR.getSelectionModel().getSelectedItem();
        Image image;
        if (currentQ != null)
        {
            lblQuestionText.setText(currentQ.getqText());

            if (currentQ.getImageURL() == null)
            {
                currentQ.setImageURL(emptyUrl);
            }
            image = new Image(currentQ.getImageURL());
            ivImage.setImage(image);
            for (int i = 0; i < currentQ.getAnswers().size(); i++)
            {

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
        }
    }

    public void startTimer()
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

    private void emptyCheckboxes()
    {
        lvQuestionsNR.getSelectionModel().select(lvQuestionsNR.getSelectionModel().getSelectedIndex() + 1);
        currentQuestion();

        chbxalternativ1.selectedProperty().set(false);
        chbxalternativ2.selectedProperty().set(false);
        chbxalternativ3.selectedProperty().set(false);
        chbxalternativ4.selectedProperty().set(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        startTimer();
        populateListView();
        currentQuestion();

        lvQuestionsNR.getSelectionModel().select(0);
        currentQuestion();

        //populate labels med info
        //lblTeacherSubject.setText(currentTest.getSubject());
        lblTestSubject.setText("Subject: " + currentTest.getSubject());
    }

}
