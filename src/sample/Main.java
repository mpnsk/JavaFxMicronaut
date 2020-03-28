package sample;

import io.micronaut.context.ApplicationContext;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.inject.Named;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        ApplicationContext injectionContext = ApplicationContext.run();
        injectionContext.registerSingleton(injectionContext);
        injectionContext.registerSingleton(primaryStage);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("start/start.fxml"));
        fxmlLoader.setControllerFactory(injectionContext::getBean);
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
