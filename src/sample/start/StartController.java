package sample.start;

import io.micronaut.context.ApplicationContext;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Singleton
public class StartController implements Initializable {
    public Button button;
    public TextField textField;

    @Inject
    ApplicationContext applicationContext;

    @Inject
    Stage stage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        button.setOnAction(this::changeScene);
        this.textField.setText(textField.getText());
    }

    private void changeScene(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../different/different.fxml"));
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        try {
            Parent root = fxmlLoader.load();
            stage.setScene(new Scene(root,300, 275));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
