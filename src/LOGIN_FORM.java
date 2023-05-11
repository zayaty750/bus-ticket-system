
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

public final class LOGIN_FORM {

    private final String style = getClass().getResource("application.css").toExternalForm();
    private final Scene scene;
    private Stage copy;
    String role;
    CUSTOMER_FORM form = new CUSTOMER_FORM();
    MANAGER_FORM form2 = new MANAGER_FORM();
    ADMIN_FORM form3 = new ADMIN_FORM();
    
    public LOGIN_FORM() {
               
        BorderPane root = new BorderPane();

        root.setLeft(LEFT_pane());
        root.setRight(RIGHT_Pane());
        root.setCenter(center_home_Pane());

        scene = new Scene(root);
        scene.getStylesheets().add(style);
        
    }

    public VBox LEFT_pane() {
        VBox LEFT_pane = new VBox();
        LEFT_pane.setStyle("-fx-background-color: white;");
        LEFT_pane.setMinWidth(400);
        
        return LEFT_pane;
    }

    public VBox RIGHT_Pane() {
        VBox RIGHT_Pane = new VBox();
        RIGHT_Pane.setStyle("-fx-background-color: white;");
        RIGHT_Pane.setMinWidth(400);
       RIGHT_Pane.setMinHeight(300);

        return RIGHT_Pane;
    }
    
     public Pane center_home_Pane() {
         
         Pane center_home_Pane = new Pane();
         center_home_Pane.setMinWidth(900);
        //
        Image icon = new Image(getClass().getResourceAsStream("bus-stop.png"));
        ImageView imageview = new ImageView(icon);

        center_home_Pane.setId("pane");
        //elements
        Button Login = new Button("Login");
        Button man_button = new Button("MANAGER");
        Button cust_button = new Button("CUSTOMER");
        Button adm_button = new Button("ADMIN");
        Label name = new Label("Login Page");
        Label name1 = new Label("Customer Form");
        Label name2 = new Label("Admin Form");
        Label name3 = new Label("Manager Form");
        Label Username = new Label("Username");
        TextField UsernameU = new TextField();
        Label Password = new Label("Password");
        PasswordField PasswordU = new PasswordField();
        Label ID=new Label("ID");
        TextField IDU =new TextField ();
        Label warning = new Label("Password or username are not correct!!");
        //
        imageview.setFitHeight(70);
        imageview.setFitWidth(70);
        imageview.setLayoutX(20);
        imageview.setLayoutY(20);
        //
        name.setLayoutX(130);
        name.setLayoutY(40);
        name.setId("title");
        //text user name
        Username.setLayoutX(100);
        Username.setLayoutY(400);
        Username.setId("text");
        Username.setVisible(false);
        //text field of user name
        UsernameU.setLayoutX(180);
        UsernameU.setLayoutY(400);
        UsernameU.setVisible(false);
        //text password
        Password.setLayoutX(350);
        Password.setLayoutY(400);
        Password.setId("text");
        Password.setVisible(false);
        //text field of password
        PasswordU.setLayoutX(430);
        PasswordU.setLayoutY(400);
        PasswordU.setVisible(false);
        //Label ID
        ID.setLayoutX(620);
        ID.setLayoutY(400);
        ID.setVisible(false);
        ID.setId("text");
        //TextField ID
        IDU.setLayoutX(645);
        IDU.setLayoutY(400);
        IDU.setVisible(false);
        //button Login 
        Login.setMinWidth(150);
        Login.setLayoutX(700);
        Login.setLayoutY(700);
        Login.setId("red");
        Login.setCursor(Cursor.OPEN_HAND);
        //
        man_button.setMinWidth(150);
        man_button.setLayoutX(100);
        man_button.setLayoutY(200);
        man_button.setId("dark-blue");
        man_button.setCursor(Cursor.OPEN_HAND);
        //
        cust_button.setMinWidth(150);
        cust_button.setLayoutX(400);
        cust_button.setLayoutY(200);
        cust_button.setId("dark-blue");
        cust_button.setCursor(Cursor.OPEN_HAND);
        //
        adm_button.setMinWidth(150);
        adm_button.setLayoutX(700);
        adm_button.setLayoutY(200);
        adm_button.setId("dark-blue");
        adm_button.setCursor(Cursor.OPEN_HAND);
        //warning 3
        warning.setLayoutX(70);
        warning.setLayoutY(460);
        warning.setStyle(" -fx-text-fill: red;");
        //hiding the warning
        warning.setVisible(false);
        USER user = new USER();
        
        cust_button.setOnAction((ActionEvent arg0) -> {
            role = "CUST";
            if(Username.isVisible())
            {
                ID.setVisible(false);
                IDU.setVisible(false);
                Username.setVisible(false);
                UsernameU.setVisible(false);
                Password.setVisible(false);
                PasswordU.setVisible(false);
            }
            else
            {
                ID.setVisible(true);
                IDU.setVisible(true);
                Username.setVisible(true);
                UsernameU.setVisible(true);
                Password.setVisible(true);
                PasswordU.setVisible(true);
            }

         });
        man_button.setOnAction((ActionEvent arg0) -> {
            role = "MANG"; 
            if(ID.isVisible())
            {
                ID.setVisible(false);
                IDU.setVisible(false);
                Username.setVisible(false);
                UsernameU.setVisible(false);
                Password.setVisible(false);
                PasswordU.setVisible(false);
            }
            else
            {
                ID.setVisible(true);
                IDU.setVisible(true);
                Password.setVisible(true);
                PasswordU.setVisible(true);
            }
         });
        adm_button.setOnAction((ActionEvent arg0) -> {
             role = "ADM"; 
                if(ID.isVisible())
                {
                ID.setVisible(false);
                IDU.setVisible(false);
                Username.setVisible(false);
                UsernameU.setVisible(false);
                Password.setVisible(false);
                PasswordU.setVisible(false);
            }
            else
            {
                ID.setVisible(true);
                IDU.setVisible(true);
                Password.setVisible(true);
                PasswordU.setVisible(true);
            }
         });
        //
        
        Login.setOnAction((ActionEvent arg0) -> {
         if(role=="CUST")
          {
              if(user.login(IDU.getText(),UsernameU.getText(), PasswordU.getText(),role))

              {
                  form.get_id_tocust(IDU.getText());
                  copy.setScene(form.get_customer_pane());
                  copy.show();
              }
              else
              {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("NOTE...");
                    alert.setHeaderText("error will occur!");
                    alert.setContentText("false");
                    alert.showAndWait();
              }
                
          }
         else if(role=="MANG")
          {
             if(user.login(IDU.getText()," ",PasswordU.getText(), role))
              {
                
                  
                copy.setScene(form2.get_manager_pane());
                copy.show();
               }
          }
         else if(role=="ADM")
          {
              if(user.login(IDU.getText(),"", PasswordU.getText(), role))
              {
                form3.get_id(IDU.getText());
                copy.setScene(form3.get_admin_scene());
                copy.show();
              }
          }
        });
center_home_Pane.getChildren().addAll(Username, UsernameU, Password, PasswordU, Login, warning, imageview, name
,adm_button,cust_button,man_button ,ID,IDU);
        return center_home_Pane;
    }
     
    public Scene get_login_scene() {
        return scene;
    }

    public void get_login_scene(Stage str) {
        copy = str;
    }
}