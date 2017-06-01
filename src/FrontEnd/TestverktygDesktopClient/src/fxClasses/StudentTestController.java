package fxClasses;

import static fxClasses.LoginController.currentStudent;
import static fxClasses.LoginController.currentTeacher;

import static fxClasses.LoginController.currentTest;
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
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import propertymodels.Question;
import propertymodels.StudentAnswer;
import repositories.QuestionRepository;

public class StudentTestController implements Initializable {

    QuestionRepository qr = new QuestionRepository();
    List<StudentAnswer> answers = new ArrayList();
    List<models.Question> questions = qr.getQuestions();
    Question currentQ;
    final Integer startTime = 15;//currentTest.getTotalTime();
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
    private CheckBox chbxalternativOne;
    @FXML
    private CheckBox chbxalternativThree;
    @FXML
    private CheckBox chbxalternativFour;
    @FXML
    private CheckBox chbxalternativTwo;
    @FXML
    private ImageView ivImage;

    public void populateListView() {
        //populate listview

        ObservableList<Question> observableQuestions = FXCollections.observableArrayList();
        questions.stream().forEach((q) -> {
            observableQuestions.add(new Question(q.getId(), q.getqText(), q.getCorrectAnswer(), q.getImageURL(), q.getAnswers()));

        });
        lvQuestionsNR.setItems(observableQuestions);
    }

    @FXML
    public void checkBoxHandler(MouseEvent event) {
        String source1 = event.getSource().toString().substring(12, 31);

        switch (source1) {
            case "checkBxQuestionAlt1": {
                chbxalternativOne.selectedProperty().set(true);

                chbxalternativTwo.selectedProperty().set(false);
                chbxalternativThree.selectedProperty().set(false);
                chbxalternativFour.selectedProperty().set(false);
                chosenCheckBoxId = 0;
                saveDoneQuestion();
                break;
            }

            case "checkBxQuestionAlt2": {
                chbxalternativTwo.selectedProperty().set(true);

                chbxalternativOne.selectedProperty().set(false);
                chbxalternativThree.selectedProperty().set(false);
                chbxalternativFour.selectedProperty().set(false);
                chosenCheckBoxId = 1;
                saveDoneQuestion();
                break;
            }

            case "checkBxQuestionAlt3": {
                chbxalternativThree.selectedProperty().set(true);

                chbxalternativOne.selectedProperty().set(false);
                chbxalternativTwo.selectedProperty().set(false);
                chbxalternativFour.selectedProperty().set(false);
                chosenCheckBoxId = 2;
                saveDoneQuestion();
                break;
            }

            case "checkBxQuestionAlt4": {
                chbxalternativFour.selectedProperty().set(true);

                chbxalternativOne.selectedProperty().set(false);
                chbxalternativTwo.selectedProperty().set(false);
                chbxalternativThree.selectedProperty().set(false);
                chosenCheckBoxId = 3;
                saveDoneQuestion();
                break;
            }

        }
    }

    public void saveDoneQuestion() {
        StudentAnswer answer = new StudentAnswer();
        answer.setDate(Date.valueOf(LocalDate.MAX));
        answer.setGivenAnswer(currentQ.getAnswers().get(chosenCheckBoxId).toString());
        answer.setParticipant_Id(currentStudent.getId());
        answer.setQuestion_Id(currentQ.getId());
        answers.stream().forEach((a)->{
        if(answer.getQuestion_Id() != a.getQuestion_Id()){
                    answers.add(answer);
        }
        
        });

    }

    public void currentQuestion() {

        // hålla reda på current question
        lblcurrentQuestionNR.setText(String.valueOf(lvQuestionsNR.getSelectionModel().getSelectedIndex()));
        currentQ = (Question) lvQuestionsNR.getSelectionModel().getSelectedItem();
        lblQuestionText.setText(currentQ.getqText());
        Image image = new Image(currentQ.getImageURL());
        ivImage.setImage(image);
        for (int i = 0; i < currentQ.getAnswers().size(); i++) {

            switch (i) {
                case 0:
                    chbxalternativOne.setText(currentQ.getAnswers().get(i).toString());
                    break;
                case 1:
                    chbxalternativTwo.setText(currentQ.getAnswers().get(i).toString());
                    break;
                case 2:
                    chbxalternativThree.setText(currentQ.getAnswers().get(i).toString());
                    break;
                case 3:
                    chbxalternativFour.setText(currentQ.getAnswers().get(i).toString());
                    break;

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
        lblTeacherSubject.setText(currentTeacher.getSubject());
        lblTestSubject.setText(currentTest.getSubject());
    }

}
