package sample.different;

import io.micronaut.context.annotation.Prototype;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.start.StartController;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.net.URL;
import java.util.ResourceBundle;

@Singleton
public class DifferentController implements Initializable {
    public Label label;
    @Inject
    StartController controller;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        label.setText(controller.textField.getText() + " is the text");
    }
}
