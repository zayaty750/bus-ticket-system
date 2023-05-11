//
//
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException, ClassNotFoundException {
        //Main pane
        Pane Mainpane = new Pane();
        //elements
        Image icon = new Image(getClass().getResourceAsStream("bus-stop.png"));
        ImageView imageview = new ImageView(icon);
        imageview.setFitHeight(200);
        imageview.setFitWidth(200);
        imageview.setLayoutX(650);
        imageview.setLayoutY(30);
        Button Login = new Button("Login");
        Button Registration = new Button("Registration");
        Label text = new Label("MIU BUSES");
        text.setMinWidth(200);
        text.setLayoutX(690);
        text.setLayoutY(250);
        text.setId("title");
        //login button properties
        Login.setMinWidth(200);
        Login.setLayoutX(400);
        Login.setLayoutY(600);
        Login.setId("red");
        Login.setCursor(Cursor.HAND);
        //Registration button properties
        Registration.setMinWidth(200);
        Registration.setLayoutX(900);
        Registration.setLayoutY(600);
        Registration.setId("red");
        Registration.setCursor(Cursor.HAND);

        Mainpane.getChildren().addAll(Login, Registration, imageview, text);
        Mainpane.setId("pane");

        Scene scene = new Scene(Mainpane);
        //
        String style = getClass().getResource("application.css").toExternalForm();
        scene.getStylesheets().add(style);

    Login.setOnAction(new EventHandler<ActionEvent>()
    {
    	@Override
    	public void handle(ActionEvent arg0) 
    	{
                LOGIN_FORM  form = new LOGIN_FORM();
    		primaryStage.setScene(form.get_login_scene());
                form.get_login_scene(primaryStage);
    		primaryStage.show();
    	}
    }
    );
        Registration.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {

                Registration_Form form  = new Registration_Form();
                form.catch_main_stage(primaryStage);
                primaryStage.setScene(form.get_registration_scene());
                primaryStage.setMaximized(true);
                primaryStage.show();
            }
        }
        );

        primaryStage.setTitle("Bus application"); // Set the stage title
        primaryStage.getIcons().add(icon);
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.setMaximized(true);
        primaryStage.show(); // Display the stage
    }


    /*	
  * The main method is only needed /for the IDE with limited
  * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }

}
