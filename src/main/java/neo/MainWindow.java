package neo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * Controller for MainWindow. Provides the layout for the other controls.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Neo neo;
    private final Intro intro = new Intro();

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/User.jpg"));
    private Image dukeImage = new Image(this.getClass().getResourceAsStream("/images/Duke.jpg"));

    /**
     * This method initializes the main GUI window with the welcome message.
     */
    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        dialogContainer.getChildren().add(
                DialogBoxNeo.getNeoDialog(intro.printIntro(), dukeImage)
        );
    }

    public void setNeo(Neo neo) {
        this.neo = neo;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other
     * containing Duke's reply and then appends them to the dialog container.
     * Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = neo.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBoxNeo.getNeoDialog(response, dukeImage)
        );
        userInput.clear();
    }
}