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
import repositories.QuestionRepository;

public class StudentTestController implements Initializable {

    QuestionRepository qr = new QuestionRepository();
    List<StudentAnswer> answers = new ArrayList();
    List<models.Question> questions = qr.getQuestions();
    ObservableList<Question> observableQuestions = FXCollections.observableArrayList();
    Question currentQ;
    final Integer startTime = 60;
    Timeline timeline = null;
    IntegerProperty timeSeconds = new SimpleIntegerProperty(startTime);

    int chosenCheckBoxId = 0;

    @FXML
    private Label lblTestSubject;
    @FXML
    private Label lblTeacherSubject;
    @FXML
    private Label lblTimeLeft;
    @FXML
    private ListView lvQuestionsNR;
    @FXML
    private ListView lvCorrectedQuestion;
    @FXML
    private Label lblcurrentQuestionNR;
    @FXML
    private Label lblQuestionText;
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

    public void populateListView() {
        //populate listview

        for (int i = 0; i < questions.size(); i++) {
            //      if (currentTest.getId()== questions.get(i).getTest_Id()) {
            observableQuestions.add(new Question(questions.get(i).getId(), questions.get(i).getqText(),
                    questions.get(i).getCorrectAnswer(), questions.get(i).getImageURL(),
                    questions.get(i).getAnswers(), questions.get(i).getTest_Id()));
            //    }
        }

        lvQuestionsNR.setItems(observableQuestions);
    }

    @FXML
    public void checkBoxHandler(MouseEvent event) {
        String source1 = event.getSource().toString().substring(12, 27);
        System.out.println(source1);
        switch (source1) {
            case "checkBxQuestionAlt1": {
                System.out.println("tklasdlkj");
                chbxalternativ1.setSelected(true);

                chbxalternativ2.setSelected(false);
                chbxalternativ3.setSelected(false);
                chbxalternativ4.setSelected(false);
                chosenCheckBoxId = 0;
                saveDoneQuestion(event);
                break;
            }

            case "checkBxQuestionAlt2": {
                chbxalternativ2.setSelected(true);

                chbxalternativ1.setSelected(false);
                chbxalternativ3.setSelected(false);
                chbxalternativ4.setSelected(false);
                chosenCheckBoxId = 1;
                saveDoneQuestion(event);
                break;
            }

            case "checkBxQuestionAlt3": {
                chbxalternativ3.setSelected(true);

                chbxalternativ1.setSelected(false);
                chbxalternativ2.setSelected(false);
                chbxalternativ4.setSelected(false);
                chosenCheckBoxId = 2;
                saveDoneQuestion(event);
                break;
            }

            case "checkBxQuestionAlt4": {
                chbxalternativ4.setSelected(true);

                chbxalternativ1.setSelected(false);
                chbxalternativ2.setSelected(false);
                chbxalternativ3.setSelected(false);
                chosenCheckBoxId = 3;
                saveDoneQuestion(event);
                break;
            }

        }
    }

    public void saveDoneQuestion(MouseEvent event) {
        StudentAnswer answer = new StudentAnswer();
        answer.setDate(Date.valueOf(LocalDate.MAX));
        answer.setGivenAnswer(currentQ.getAnswers().get(chosenCheckBoxId).toString());
//        answer.setParticipant_Id(currentStudent.getId());
        answer.setQuestion_Id(currentQ.getId());
        answers.stream().forEach((a) -> {
            if (answer.getQuestion_Id() != a.getQuestion_Id()) {
                answers.add(answer);
            }

        });
        if (answers.size() == observableQuestions.size()) {
            //byt till startpage för student
            try {
                // go to create account scene
                Stage goToNextStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Parent p = FXMLLoader.load(getClass().getResource("createAccount.fxml"));
                Scene GoToNextScene = new Scene(p);

                goToNextStage.setScene(GoToNextScene);
                goToNextStage.setResizable(false);
                goToNextStage.setTitle("Create a new account");
                goToNextStage.show();

            } catch (IOException e) {
                System.out.println(e.getCause());
            }
        }

    }

    public void currentQuestion() {

        // hålla reda på current question
        lblcurrentQuestionNR.setText(String.valueOf(lvQuestionsNR.getSelectionModel().getSelectedIndex()));
        currentQ = (Question) lvQuestionsNR.getSelectionModel().getSelectedItem();
        Image image = null;
        if (currentQ != null) {
            lblQuestionText.setText(currentQ.getqText());
            image = new Image(currentQ.getImageURL());

            ivImage.setImage(image);
            for (int i = 0; i < currentQ.getAnswers().size(); i++) {

                switch (i) {
                    case 0:
                        chbxalternativ1.setText(currentQ.getAnswers().get(i).toString());
                        break;
                    case 1:
                        chbxalternativ2.setText(currentQ.getAnswers().get(i).toString());
                        break;
                    case 2:
                        chbxalternativ3.setText(currentQ.getAnswers().get(i).toString());
                        break;
                    case 3:
                        chbxalternativ4.setText(currentQ.getAnswers().get(i).toString());
                        break;

                }
            }
        }
    }

    public void startTimer() {
        //timer for time left
        lblTimeLeft.textProperty().bind(timeSeconds.asString());

        if (timeline != null) {
            timeline.stop();
        }
        timeSeconds.set(startTime);
        timeline = new Timeline();
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(startTime + 1),
                        new KeyValue(timeSeconds, 0)));
        timeline.playFromStart();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        startTimer();
        populateListView();
        currentQuestion();

        //populate labels med info
//        lblTeacherSubject.setText(currentTeacher.getSubject());
//        lblTestSubject.setText(currentTest.getSubject());
    }

}
