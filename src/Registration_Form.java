
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public final class Registration_Form {

    private String style = getClass().getResource("application.css").toExternalForm();
    private Scene scene;
    private Stage copy;
    String id;
    LOGIN_FORM form = new LOGIN_FORM();

    public Registration_Form() {

        BorderPane root = new BorderPane();
        //root.setTop(TOP_pane());
        root.setLeft(LEFT_pane());
        root.setRight(RIGHT_Pane());
        root.setCenter(center_home_Pane());
        
        scene = new Scene(root);
        scene.getStylesheets().add(style);

    }

    public Pane TOP_pane() {
        Pane TOP_pane = new Pane();
        TOP_pane.setStyle("-fx-background-color: white;");
        TOP_pane.setMinWidth(100);
        TOP_pane.setMinHeight(120);

        return TOP_pane;
    }

    public VBox LEFT_pane() {
        VBox LEFT_pane = new VBox();
        LEFT_pane.setStyle("-fx-background-color: white;");
        LEFT_pane.setMinWidth(300);

        return LEFT_pane;
    }

    public VBox RIGHT_Pane() {
        VBox RIGHT_Pane = new VBox();
        RIGHT_Pane.setStyle("-fx-background-color: white;");
        RIGHT_Pane.setMinWidth(300);
        RIGHT_Pane.setMinHeight(300);

        return RIGHT_Pane;
    }

    public Pane center_home_Pane() {

        Pane center_home_Pane = new Pane();
        center_home_Pane.setMaxWidth(1000);
        //
        Image icon = new Image(getClass().getResourceAsStream("bus-stop.png"));
        ImageView imageview = new ImageView(icon);

        center_home_Pane.setId("pane");
        //elements
        Button Regirstartion = new Button("Registration");

        Label name = new Label("Regirstartion Page");
        Label FirstName = new Label("First Name");
        TextField FirstNameU = new TextField();
        Label LastName = new Label("Last Name");
        TextField LastNameU = new TextField();
        Label Password = new Label("Password");
        PasswordField PasswordU = new PasswordField();
        Label Email = new Label("Email");
        TextField EmailU = new TextField();
        Label ConfirmEmail = new Label("Confirm your Email");
        TextField ConfirmEmailU = new TextField();
        Label Phone = new Label("Phone Number");
        TextField PhoneU = new TextField();

        Label warning = new Label("password or username are not correct!!");
        //
        imageview.setFitHeight(70);
        imageview.setFitWidth(70);
        imageview.setLayoutX(20);
        imageview.setLayoutY(20);
        //
        name.setLayoutX(130);
        name.setLayoutY(40);
        name.setId("title");
        //Label FirstName
        FirstName.setLayoutX(50);
        FirstName.setLayoutY(250);
        FirstName.setId("text");
        //TextField of FirstName
        FirstNameU.setLayoutX(150);
        FirstNameU.setLayoutY(250);
        //Label of LastName
        LastName.setLayoutX(50);
        LastName.setLayoutY(350);
        LastName.setId("text");
        //TextField of LastName
        LastNameU.setLayoutX(150);
        LastNameU.setLayoutY(350);
        //Label of Password
        Password.setLayoutX(50);
        Password.setLayoutY(450);
        Password.setId("text");
        //TextField of password
        PasswordU.setLayoutX(150);
        PasswordU.setLayoutY(450);
        //Label Email
        Email.setLayoutX(600);
        Email.setLayoutY(250);
        Email.setId("text");
        //TextField of Email
        EmailU.setLayoutX(650);
        EmailU.setLayoutY(250);
        //Label of ConfirmEmail
        ConfirmEmail.setLayoutX(495);
        ConfirmEmail.setLayoutY(350);
        ConfirmEmail.setId("text");
        //TextField of ConfirmEmail
        ConfirmEmailU.setLayoutX(650);
        ConfirmEmailU.setLayoutY(350);
        //Label of PhoneNumber
        Phone.setLayoutX(530);
        Phone.setLayoutY(450);
        Phone.setId("text");
        //TextField of PhoneNumber
        PhoneU.setLayoutX(650);
        PhoneU.setLayoutY(450);
        //button Registration 
        Regirstartion.setMinWidth(150);
        Regirstartion.setLayoutX(700);
        Regirstartion.setLayoutY(700);
        Regirstartion.setId("red");
        Regirstartion.setCursor(Cursor.OPEN_HAND);
        //
        //warning 3
        warning.setLayoutX(70);
        warning.setLayoutY(460);
        warning.setStyle(" -fx-text-fill: red;");
        //hiding the warning
        warning.setVisible(false);

        Regirstartion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                boolean error = false;
                CUSTOMER customer = new CUSTOMER();

                if (PhoneU.getText().isEmpty() || FirstNameU.getText().isEmpty() || LastNameU.getText().isEmpty()
                        || PasswordU.getText().isEmpty() || ConfirmEmailU.getText().isEmpty() || EmailU.getText().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("NOTE...");
                    alert.setHeaderText("error will occur!");
                    alert.setContentText("you can't add empty data,all fields must be filled with data");
                    alert.showAndWait();
                } else {
                    if(PasswordU.getText().length()<5)
                    {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("NOTE...");
                        alert.setHeaderText("error will occur!");
                        alert.setContentText("Password length must be 8 or more char");
                        alert.showAndWait();
                        error = true;
                    }
                    if(ConfirmEmailU.getText().length()<5)
                    {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("NOTE...");
                        alert.setHeaderText("error will occur!");
                        alert.setContentText("Email length must be 5 or more");
                        alert.showAndWait();
                        error = true;
                    }
                    if(FirstNameU.getText().length()<5)
                    {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("NOTE...");
                        alert.setHeaderText("error will occur!");
                        alert.setContentText("Firstname length must be 5 or more");
                        alert.showAndWait();
                        error = true;
                    }
                    if(LastNameU.getText().length()<5)
                    {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("NOTE...");
                        alert.setHeaderText("error will occur!");
                        alert.setContentText("Lastname length must be 5 or more");
                        alert.showAndWait();
                        error = true;
                    }
                    if(error == false)
                    {
                    customer.registration(FirstNameU.getText(), LastNameU.getText(), PasswordU.getText(), ConfirmEmailU.getText(), PhoneU.getText());
                    copy.setScene(form.get_login_scene());
                    copy.show();
                    }
                }

            }
        });
        center_home_Pane.getChildren().addAll(FirstName, FirstNameU, LastName,
                LastNameU, Password, PasswordU, Email, EmailU, ConfirmEmail,
                ConfirmEmailU, Phone, PhoneU, Regirstartion, warning, name, imageview);
        return center_home_Pane;
    }

    public Scene get_registration_scene() {
        return scene;
    }

    public void catch_main_stage(Stage scn) {
        copy = scn;
    }

}
