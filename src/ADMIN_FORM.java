
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.print.PrinterJob;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Zeyad
 */
public final class ADMIN_FORM implements Serializable {

    private final String style = getClass().getResource("application.css").toExternalForm();
    private Button PROFILE, BUSES, CUSTOMER, PERMISIONS;
    private VBox LEFT_pane, RIGHT_Pane;
    private Pane TOP_pane;
    private final Scene scene;
    Pane pane;
    private final BorderPane root;
    private Label text, data;
    Image icon;
    ImageView imageview;
    String id;

    CUSTOMER customer = new CUSTOMER();
    TRIP trip = new TRIP();
    TERMINAL terminal = new TERMINAL();
    BUS bus = new BUS(trip, terminal);
    ADMIN admin = new ADMIN(bus);
    MANAGER manager = new MANAGER(admin);
    PERMISSION permission = new PERMISSION(manager, admin);

    public ADMIN_FORM() {

        root = new BorderPane();

        root.setTop(TOP_pane());
        root.setLeft(LEFT_pane());
        root.setRight(RIGHT_Pane());
        root.setCenter(center_home_Pane());

        scene = new Scene(root, 1920, 1080);
        scene.getStylesheets().add(style);

    }

    public Pane TOP_pane() {
        TOP_pane = new Pane();
        TOP_pane.setMinWidth(100);
        TOP_pane.setMinHeight(120);

        icon = new Image(getClass().getResourceAsStream("bus-stop.png"));
        imageview = new ImageView(icon);

        Image home_photo = new Image(getClass().getResourceAsStream("Homebtn.png"));
        ImageView home_photo_view = new ImageView(home_photo);

        Image logout_photo = new Image(getClass().getResourceAsStream("logout.png"));
        ImageView logout_photo_view = new ImageView(logout_photo);

        Button Home_btn = new Button("", home_photo_view);
        Button logout_btn = new Button("", logout_photo_view);

        TOP_pane.setStyle("-fx-background-color:  white ; ");

        text = new Label("MIU");
        TOP_pane.getChildren().addAll(imageview, text, Home_btn, logout_btn);

        imageview.setFitHeight(70);
        imageview.setFitWidth(70);

        imageview.setLayoutX(80);
        imageview.setLayoutY(15);

        text.setLayoutX(98);
        text.setLayoutY(90);
        text.setId("style");

        Home_btn.setLayoutX(400);
        Home_btn.setLayoutY(0);
        Home_btn.setMinWidth(100);
        Home_btn.setMinHeight(130);
        Home_btn.setId("buttons");

        logout_btn.setLayoutX(1000);
        logout_btn.setLayoutY(0);
        logout_btn.setMinWidth(100);
        logout_btn.setMinHeight(130);
        logout_btn.setId("buttons");

        Home_btn.setOnAction((ActionEvent e)
                -> {
            PROFILE.setId("buttons");
            CUSTOMER.setId("buttons");
            BUSES.setId("buttons");

            root.setCenter(center_home_Pane());

        });
            logout_btn.setOnAction((ActionEvent e) -> 
                {

                    System.exit(0);
        });
        return TOP_pane;
    }

    public StackPane center_home_Pane() {
        StackPane center_home_Pane = new StackPane();

        Pane permission = new Pane();
        Pane income = new Pane();

        //
        Pane Bus = new Pane();
        Bus.setId("red");
        Bus.setMaxSize(300, 200);
        center_home_Pane.setAlignment(Bus, Pos.TOP_LEFT);
        center_home_Pane.setMargin(Bus, new Insets(8, 8, 8, 8));

        Label text = new Label("BUSES");
        text.setId("title");
        text.setLayoutX(65);
        text.setLayoutY(10);

        Label text2 = new Label();
        text2.setText(bus.bus_counter());
        text2.setStyle(" -fx-text-fill: white;\n" + " -fx-font-weight: bold;\n" + " -fx-font-size: 60;");
        text2.setLayoutX(80);
        text2.setLayoutY(80);

        Bus.getChildren().addAll(text, text2);
        //
        Pane admin = new Pane();
        admin.setId("red");
        admin.setMaxSize(300, 200);
        center_home_Pane.setAlignment(admin, Pos.TOP_CENTER);
        center_home_Pane.setMargin(admin, new Insets(8, 8, 8, 8));

        Label text3 = new Label("STAFF");
        text3.setId("title");
        text3.setLayoutX(65);
        text3.setLayoutY(10);

        Label text4 = new Label();
        text4.setText(manager.Staff_counter());
        text4.setStyle(" -fx-text-fill: white;\n" + " -fx-font-weight: bold;\n" + " -fx-font-size: 60;");
        text4.setLayoutX(80);
        text4.setLayoutY(80);

        admin.getChildren().addAll(text3, text4);
        //
        Pane Customer = new Pane();
        Customer.setId("red");
        Customer.setMaxSize(300, 200);
        center_home_Pane.setAlignment(Customer, Pos.TOP_RIGHT);
        center_home_Pane.setMargin(Customer, new Insets(8, 8, 8, 8));

        Label text5 = new Label("CUSTOMERS");
        text5.setId("title");
        text5.setLayoutX(65);
        text5.setLayoutY(10);

        Label text6 = new Label();
        text6.setText(customer.Customer_counter());
        text6.setStyle(" -fx-text-fill: white;\n" + " -fx-font-weight: bold;\n" + " -fx-font-size: 60;");
        text6.setLayoutX(80);
        text6.setLayoutY(80);

        Customer.getChildren().addAll(text5, text6);
        //
        center_home_Pane.setId("pane");
        center_home_Pane.getChildren().addAll(Bus, admin, Customer);

        return center_home_Pane;
    }

    public VBox LEFT_pane() {
        LEFT_pane = new VBox();
        //
        LEFT_pane.setMinWidth(280);
        LEFT_pane.setMinHeight(300);
        //
        icon = new Image(getClass().getResourceAsStream("user.png"));
        imageview = new ImageView(icon);

        Image customer_icon = new Image(getClass().getResourceAsStream("Customer.png"));
        ImageView customer_icon_view = new ImageView(customer_icon);

        Image admin_icon = new Image(getClass().getResourceAsStream("admin (3).png"));
        ImageView admin_icon_view = new ImageView(admin_icon);

        Image bus_icon = new Image(getClass().getResourceAsStream("bus.png"));
        ImageView bus_icon_view = new ImageView(bus_icon);

        Image Permission_icon = new Image(getClass().getResourceAsStream("permission.png"));
        ImageView Permission_icon_view = new ImageView(Permission_icon);

        //BUSES,ADMIN,CUSTOMER
        PROFILE = new Button("PROFILE", imageview);
        CUSTOMER = new Button("CUSTOMERS", customer_icon_view);
        BUSES = new Button("BUSES", bus_icon_view);
        PERMISIONS = new Button("PERMISIONS", Permission_icon_view);
        //
        PROFILE.setMinWidth(255);
        PROFILE.setMinHeight(100);
        PROFILE.setPadding(new Insets(10, 100, 10, 10));
        PROFILE.setId("buttons");
        //
        CUSTOMER.setMinWidth(250);
        CUSTOMER.setMinHeight(100);
        CUSTOMER.setId("buttons");
        CUSTOMER.setPadding(new Insets(10, 70, 10, 10));
        //
        BUSES.setMinWidth(255);
        BUSES.setMinHeight(100);
        BUSES.setId("buttons");
        BUSES.setPadding(new Insets(10, 120, 10, 10));
        //
        PERMISIONS.setMinWidth(250);
        PERMISIONS.setMinHeight(100);
        PERMISIONS.setId("buttons");
        PERMISIONS.setPadding(new Insets(10, 70, 10, 10));
        //
        LEFT_pane.setStyle("-fx-background-color: white;");
        LEFT_pane.getChildren().addAll(PROFILE, CUSTOMER, BUSES, PERMISIONS);
        //

//      out of the object                           top  right  bottom  left
        VBox.setMargin(PROFILE, new Insets(100, 0, 15, 12));
        VBox.setMargin(CUSTOMER, new Insets(0, 0, 15, 12));
        VBox.setMargin(BUSES, new Insets(0, 0, 15, 12));
        VBox.setMargin(PERMISIONS, new Insets(0, 0, 15, 12));
//       

        CUSTOMER.setOnAction((ActionEvent e)
                -> {
            PROFILE.setId("buttons");
            CUSTOMER.setId("change");
            BUSES.setId("buttons");

            center_Customer_Pane();

        });
        PROFILE.setOnAction((ActionEvent arg0)
                -> {
            PROFILE.setId("change");
            CUSTOMER.setId("buttons");
            BUSES.setId("buttons");

            center_Profile_Pane();

        });
        BUSES.setOnAction((ActionEvent arg0)
                -> {
            PROFILE.setId("buttons");
            CUSTOMER.setId("buttons");
            BUSES.setId("change");
            center_bus_Pane();
        });
        PERMISIONS.setOnAction((ActionEvent arg0)
                -> {
            PROFILE.setId("buttons");
            CUSTOMER.setId("buttons");
            BUSES.setId("buttons");
            PERMISIONS.setId("change");
            center_Permission_Pane();
        });

        return LEFT_pane;
    }

    public VBox RIGHT_Pane() {
        RIGHT_Pane = new VBox();

        RIGHT_Pane.setStyle("-fx-background-color: white;");

        RIGHT_Pane.setMinWidth(300);
        RIGHT_Pane.setMinHeight(300);

        return RIGHT_Pane;
    }
    

      
    public void center_Profile_Pane() 
    {
        //fill the variables with data in manager class

        StackPane secondpane = new StackPane();

        Rectangle frame = new Rectangle(10, 10, 700, 500);
        frame.setStroke(Color.BLACK);
        frame.setFill(Color.WHITE);
        pane = new Pane();
        secondpane.setId("pane");

        Label MAIN_TEXT = new Label("Your Info");
        MAIN_TEXT.setLayoutX(50);
        MAIN_TEXT.setLayoutY(30);
        MAIN_TEXT.setId("title");
        admin.set_data(id);
        Label ID = new Label("ID: ");
        TextField ID_data = new TextField();
        ID_data.setText(admin.role);
        ID.setId("style");
        ID_data.setId("style");

        ID.setLayoutX(300);
        ID.setLayoutY(150);
        ID_data.setLayoutX(450);
        ID_data.setLayoutY(150);
        ID_data.setDisable(true);

        Label Role = new Label("Role: ");
        TextField Role_data = new TextField();
        Role.setId("style");
        Role_data.setId("style");
        Role_data.setText(admin.adminID);

        Role.setLayoutX(300);
        Role.setLayoutY(200);
        Role_data.setLayoutX(450);
        Role_data.setLayoutY(200);
        Role_data.setDisable(true);

        Label FName = new Label("First Name: ");
        TextField FName_data = new TextField();
        FName.setId("style");
        FName_data.setId("style");
        FName_data.setText(admin.fName);
        FName_data.setDisable(true);

        FName.setLayoutX(300);
        FName.setLayoutY(250);
        FName_data.setLayoutX(450);
        FName_data.setLayoutY(250);

        Label AGE = new Label("Age: ");
        TextField AGE_data = new TextField();
        AGE.setId("style");
        AGE_data.setId("style");
        AGE_data.setText(admin.age);

        AGE.setLayoutX(300);
        AGE.setLayoutY(300);
        AGE_data.setLayoutX(450);
        AGE_data.setLayoutY(300);
        AGE_data.setDisable(true);

        Label GENDER = new Label("Gender: ");
        TextField GENDER_data = new TextField();
        GENDER.setId("style");
        GENDER_data.setId("style");
        GENDER_data.setText(admin.gender);

        GENDER.setLayoutX(300);
        GENDER.setLayoutY(350);
        GENDER_data.setLayoutX(450);
        GENDER_data.setLayoutY(350);
        GENDER_data.setDisable(true);

        Label PHONE_NUMBER = new Label("Phone Number: ");
        TextField PHONE_NUMBER_data = new TextField();
        PHONE_NUMBER.setId("style");
        PHONE_NUMBER_data.setId("style");
        PHONE_NUMBER_data.setText(admin.phoneNum);

        PHONE_NUMBER.setLayoutX(300);
        PHONE_NUMBER.setLayoutY(400);
        PHONE_NUMBER_data.setLayoutX(450);
        PHONE_NUMBER_data.setLayoutY(400);
        PHONE_NUMBER_data.setDisable(true);
        // Place nodes in the pane
        pane.getChildren().addAll(MAIN_TEXT, ID,
                ID_data, FName, FName_data, Role,
                Role_data, AGE, AGE_data, GENDER, GENDER_data,
                PHONE_NUMBER, PHONE_NUMBER_data);

        secondpane.getChildren().addAll(frame, pane);
        root.setCenter(secondpane);
    }

    public void center_Permission_Pane() {
        Pane center_Permission_Pane = new Pane();
        center_Permission_Pane.setId("pane");
        //  
        ObservableList<PERMISSION> data = FXCollections.observableArrayList();
        //
        TableView<PERMISSION> table = new TableView<>();
        table.setEditable(true);
        table.setLayoutX(10);
        table.setLayoutY(10);
        table.setMinHeight(630);
        table.setMinWidth(400);
        //Filling data to table//
        permission.Read_data_from_file();

        for (int i = 0; i < permission.Permission_Data.size(); i++) {
            data.add(new PERMISSION(permission.Permission_Data.get(i), permission.Permission_Data.get(i + 1)));
            i += 1;
        }
        table.setItems(data);
        //end//

        TableColumn admin_ID_col = new TableColumn("Admin_ID");
        admin_ID_col.setMinWidth(100);
        admin_ID_col.setCellValueFactory(
                new PropertyValueFactory<MANAGER, String>("data"));
        //
        TableColumn permission_col = new TableColumn("Permission");
        permission_col.setMinWidth(100);
        permission_col.setCellValueFactory(
                new PropertyValueFactory<MANAGER, String>("data1"));
        //
        table.getColumns().addAll(admin_ID_col, permission_col);
        //     
        Button add_Button = new Button("Send");
        add_Button.setMinWidth(200);
        add_Button.setLayoutX(600);
        add_Button.setLayoutY(300);

        //
        TextField ID = new TextField();
        ID.setMinWidth(200);
        ID.setPromptText("ID");
        ID.setLayoutX(600);
        ID.setLayoutY(100);
        //
        ComboBox replay = new ComboBox();
        replay.getItems().addAll("True", "False");
        replay.setMinWidth(200);
        replay.setPromptText("Replay");
        replay.setLayoutX(600);
        replay.setLayoutY(200);
        //
        add_Button.setOnAction((ActionEvent e)
                -> {

                permission.Send_Permission(id);

                data.add(new PERMISSION(id, "false"));
                //update the data
                center_Permission_Pane();
            
            ID.clear();
        });
        center_Permission_Pane.getChildren().addAll(table, add_Button);
        root.setCenter(center_Permission_Pane);
    }

    public void center_bus_Pane() {
        Pane center_bus_Pane = new Pane();
        center_bus_Pane.setId("pane");
        ObservableList<String> time = FXCollections.observableArrayList(
                "1am", "2am", "3am", "4am", "5am", "6am", "7am", "8am", "9am", "10am", "11am", "12am",
                "1pm", "2pm", "3pm", "4pm", "6pm", "7pm", "8pm", "9pm", "10pm", "11pm", "12pm"
        );
        ObservableList<BUS> data = FXCollections.observableArrayList();
        //
        TableView<BUS> table = new TableView<>();
        table.setEditable(true);
        table.setLayoutX(10);
        table.setLayoutY(10);
        table.setMinWidth(930);
        table.setMaxWidth(930);
        table.setMinHeight(400);
        //Filling data to table//
        bus.Read_data_from_file();

        for (int i = 0; i < bus.Bus_Data.size(); i++) {
            data.add(new BUS(bus.Bus_Data.get(i), bus.Bus_Data.get(i + 1), bus.Bus_Data.get(i + 2), bus.Bus_Data.get(i + 3), bus.Bus_Data.get(i + 4),
                    bus.Bus_Data.get(i + 5), bus.Bus_Data.get(i + 6), bus.Bus_Data.get(i + 7), bus.Bus_Data.get(i + 8), bus.Bus_Data.get(i + 9),
                    bus.Bus_Data.get(i + 10), bus.Bus_Data.get(i + 11)));
            i += 11;
        }

        table.setItems(data);
        //end//
        TableColumn Bus_ID_col = new TableColumn("Bus_ID");
        Bus_ID_col.setPrefWidth(100);
        Bus_ID_col.setCellValueFactory(
                new PropertyValueFactory<BUS, String>("data"));
        //
        TableColumn Seats_col = new TableColumn("Seats");
        Seats_col.setCellValueFactory(
                new PropertyValueFactory<BUS, String>("data1"));
        Seats_col.setPrefWidth(60);
        //
        TableColumn stop_1_col = new TableColumn("Stop");
        stop_1_col.setCellValueFactory(
                new PropertyValueFactory<BUS, String>("data2"));
        stop_1_col.setPrefWidth(80);
        //
        TableColumn time_1_col = new TableColumn("Time");
        time_1_col.setCellValueFactory(
                new PropertyValueFactory<BUS, String>("data3"));
        time_1_col.setPrefWidth(40);
        //
        TableColumn stop_2_col = new TableColumn("Stop");
        stop_2_col.setCellValueFactory(
                new PropertyValueFactory<BUS, String>("data4"));
        stop_2_col.setPrefWidth(80);
        //
        TableColumn time_2_col = new TableColumn("Time");
        time_2_col.setCellValueFactory(
                new PropertyValueFactory<BUS, String>("data5"));
        time_2_col.setPrefWidth(40);
        //
        TableColumn stop_3_col = new TableColumn("stop");
        stop_3_col.setCellValueFactory(
                new PropertyValueFactory<BUS, String>("data6"));
        stop_3_col.setPrefWidth(80);
        //
        TableColumn time_3_col = new TableColumn("Time");
        time_3_col.setCellValueFactory(
                new PropertyValueFactory<BUS, String>("data7"));
        time_3_col.setPrefWidth(40);
        //
        TableColumn stop_4_col = new TableColumn("Stop");
        stop_4_col.setCellValueFactory(
                new PropertyValueFactory<CUSTOMER, String>("data8"));
        stop_4_col.setPrefWidth(80);
        //
        TableColumn time_4_col = new TableColumn("Time");
        time_4_col.setCellValueFactory(
                new PropertyValueFactory<BUS, String>("data9"));
        time_4_col.setPrefWidth(40);
        //
        TableColumn start_point_col = new TableColumn("Starting Point");
        start_point_col.setCellValueFactory(
                new PropertyValueFactory<BUS, String>("data10"));
        start_point_col.setPrefWidth(150);
        //
        TableColumn ending_point_col = new TableColumn("Ending Point");
        ending_point_col.setCellValueFactory(
                new PropertyValueFactory<BUS, String>("data11"));
        ending_point_col.setPrefWidth(150);

        //
        table.getColumns().addAll(Bus_ID_col, Seats_col, stop_1_col, time_1_col, stop_2_col, time_2_col,
                stop_3_col, time_3_col, stop_4_col, time_4_col, start_point_col, ending_point_col);
        //

        TextField add_id = new TextField();
        add_id.setMinWidth(50);
        add_id.setPromptText("Bus Id");
        add_id.setLayoutX(50);
        add_id.setLayoutY(440);
        add_id.setVisible(false);
        //
        TextField add_seats = new TextField();
        add_seats.setPromptText("Seats");
        add_seats.setMinWidth(50);
        add_seats.setLayoutX(50);
        add_seats.setLayoutY(480);
        add_seats.setVisible(false);
        //
        TextField add_stop1 = new TextField();
        add_stop1.setMinWidth(50);
        add_stop1.setPromptText("Stop 1");
        add_stop1.setLayoutX(50);
        add_stop1.setLayoutY(520);
        add_stop1.setVisible(false);
        //
        ComboBox<String> add_time1 = new ComboBox<>();
        add_time1.setPromptText("Time");
        add_time1.setLayoutX(200);
        add_time1.setLayoutY(520);
        add_time1.setVisible(false);
        add_time1.setItems(time);
        //
        TextField add_stop2 = new TextField();
        add_stop2.setMinWidth(50);
        add_stop2.setPromptText("Stop 2");
        add_stop2.setLayoutX(350);
        add_stop2.setLayoutY(440);
        add_stop2.setVisible(false);
        //
        ComboBox<String> add_time2 = new ComboBox<>();
        add_time2.setPromptText("Time");
        add_time2.setLayoutX(500);
        add_time2.setLayoutY(440);
        add_time2.setVisible(false);
        add_time2.setItems(time);
        //
        TextField add_stop3 = new TextField();
        add_stop3.setPromptText("Stop 3");
        add_stop3.setMinWidth(50);
        add_stop3.setLayoutX(350);
        add_stop3.setLayoutY(480);
        add_stop3.setVisible(false);
        //
        ComboBox<String> add_time3 = new ComboBox<>();
        add_time3.setPromptText("Time");
        add_time3.setLayoutX(500);
        add_time3.setLayoutY(480);
        add_time3.setVisible(false);
        add_time3.setItems(time);
        //
        TextField add_stop4 = new TextField();
        add_stop4.setPromptText("Stop 4");
        add_stop4.setMinWidth(50);
        add_stop4.setLayoutX(350);
        add_stop4.setLayoutY(520);
        add_stop4.setVisible(false);
        //
        ComboBox<String> add_time4 = new ComboBox<>();
        add_time4.setPromptText("Time");
        add_time4.setLayoutX(500);
        add_time4.setLayoutY(520);
        add_time4.setVisible(false);
        add_time4.setItems(time);
        //
        TextField add_starting_point = new TextField();
        add_starting_point.setPromptText("Starting Point");
        add_starting_point.setMinWidth(200);
        add_starting_point.setLayoutX(650);
        add_starting_point.setLayoutY(440);
        add_starting_point.setVisible(false);
        //
        TextField add_ending_point = new TextField();
        add_ending_point.setPromptText("Ending Point");
        add_ending_point.setMinWidth(200);
        add_ending_point.setLayoutX(650);
        add_ending_point.setLayoutY(480);
        add_ending_point.setVisible(false);
        //
        Button add_Button = new Button("Add");
        add_Button.setId("dark-blue");
        add_Button.setMinWidth(200);
        add_Button.setMaxHeight(100);
        add_Button.setLayoutX(20);
        add_Button.setLayoutY(600);
        //
        Button search_Button = new Button("Search");
        search_Button.setId("dark-blue");
        search_Button.setMinWidth(200);
        search_Button.setMaxHeight(100);
        search_Button.setLayoutX(260);
        search_Button.setLayoutY(600);
        //
        Button delete_Button = new Button("Delete");
        delete_Button.setId("dark-blue");
        delete_Button.setMinWidth(200);
        delete_Button.setMaxHeight(100);
        delete_Button.setLayoutX(500);
        delete_Button.setLayoutY(600);
        //
        Button PRINT = new Button("print");
        PRINT.setId("dark-blue");
        PRINT.setMinWidth(200);
        PRINT.setMaxHeight(100);
        PRINT.setLayoutX(730);
        PRINT.setLayoutY(600);
        //
        TextField id = new TextField();
        id.setPromptText("Id");
        id.setMinWidth(200);
        id.setLayoutX(160);
        id.setLayoutY(480);
        id.setVisible(false);
        //
        TextField ID_2 = new TextField();
        ID_2.setMinWidth(100);
        ID_2.setPromptText("ID");
        ID_2.setLayoutX(400);
        ID_2.setLayoutY(430);
        ID_2.setVisible(false);
        //
        TextField role = new TextField();
        role.setPromptText("Role");
        role.setMinWidth(200);
        role.setLayoutX(160);
        role.setLayoutY(510);
        role.setVisible(false);
        role.setDisable(true);
        //
        TextField fName = new TextField();
        fName.setPromptText("First Name");
        fName.setMinWidth(200);
        fName.setLayoutX(160);
        fName.setLayoutY(540);
        fName.setVisible(false);
        fName.setDisable(true);
        //
        TextField age = new TextField();
        age.setPromptText("Age");
        age.setMinWidth(200);
        age.setLayoutX(600);
        age.setLayoutY(480);
        age.setVisible(false);
        age.setDisable(true);
        //
        TextField gender = new TextField();
        gender.setPromptText("Gender");
        gender.setMinWidth(200);
        gender.setLayoutX(600);
        gender.setLayoutY(510);
        gender.setVisible(false);
        gender.setDisable(true);
        //
        TextField phonenumber = new TextField();
        phonenumber.setPromptText("Phone Number");
        phonenumber.setMinWidth(200);
        phonenumber.setLayoutX(600);
        phonenumber.setLayoutY(540);
        phonenumber.setVisible(false);
        phonenumber.setDisable(true);

        add_Button.setOnAction((ActionEvent e)
                -> {

            ID_2.setVisible(false);
            id.setVisible(false);
            role.setVisible(false);
            fName.setVisible(false);
            age.setVisible(false);
            gender.setVisible(false);
            phonenumber.setVisible(false);

            if (add_id.isVisible() == false) {
                add_id.setVisible(true);
                add_seats.setVisible(true);
                add_stop1.setVisible(true);
                add_time1.setVisible(true);
                add_stop2.setVisible(true);
                add_time2.setVisible(true);
                add_stop3.setVisible(true);
                add_time3.setVisible(true);
                add_stop4.setVisible(true);
                add_time4.setVisible(true);
                add_starting_point.setVisible(true);
                add_ending_point.setVisible(true);
            }
            //throw exception if combo box value with null
            if (add_id.getText().isEmpty() || add_seats.getText().isEmpty() || add_stop1.getText().isEmpty() || add_ending_point.getText().isEmpty()
                    || add_stop2.getText().isEmpty() || add_stop3.getText().isEmpty() || add_stop4.getText().isEmpty() || add_starting_point.getText().isEmpty()) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("NOTE...");
                alert.setHeaderText("error will occur!");
                alert.setContentText("you can't add empty data,all fields must be filled with data");
                alert.showAndWait();

            } else {
                trip.Add_trip(add_stop1.getText(), add_time1.getSelectionModel().getSelectedItem(), add_stop2.getText(),
                        add_time2.getSelectionModel().getSelectedItem(), add_stop3.getText(),
                        add_time3.getSelectionModel().getSelectedItem(), add_stop4.getText(),
                        add_time4.getSelectionModel().getSelectedItem());

                terminal.Add_Terminal(add_starting_point.getText(), add_ending_point.getText());

                bus.add_bus(add_id.getText(), add_seats.getText());

                data.add(new BUS(add_id.getText(), add_seats.getText(), add_stop1.getText(), add_time1.getSelectionModel().getSelectedItem(), add_stop2.getText(),
                        add_time2.getSelectionModel().getSelectedItem(), add_stop3.getText(),
                        add_time3.getSelectionModel().getSelectedItem(), add_stop4.getText(),
                        add_time4.getSelectionModel().getSelectedItem(), add_starting_point.getText(), add_ending_point.getText()));

                add_id.clear();
                add_seats.clear();
                add_stop1.clear();
                add_stop2.clear();
                add_time2.setPromptText("time");
                add_stop3.clear();
                add_time3.setPromptText("time");
                add_stop4.clear();
                add_time4.setPromptText("time");
                add_starting_point.clear();
                add_ending_point.clear();
            }

        });
        delete_Button.setOnAction((ActionEvent e)
                -> {
            add_id.setVisible(false);
            add_seats.setVisible(false);
            add_stop1.setVisible(false);
            add_time1.setVisible(false);
            add_stop2.setVisible(false);
            add_time2.setVisible(false);
            add_stop3.setVisible(false);
            add_time3.setVisible(false);
            add_stop4.setVisible(false);
            add_time4.setVisible(false);
            add_starting_point.setVisible(false);
            add_ending_point.setVisible(false);

            if (ID_2.isVisible() == false) {
                ID_2.setVisible(true);
            }
            if (ID_2.getText().isEmpty()) {
                System.out.print("invalid");
            } else {
                //update the data
                bus.delete_bus(ID_2.getText());
                center_bus_Pane();
            }

        });

//        search_Button.setOnAction((ActionEvent e) -> 
//        {
//            add_fName.clear();
//            add_age.clear();
//            add_gender.clear();
//            add_phonenumber.clear();
//            ID.clear();
//            
//            add_fName.setVisible(false);
//            add_age.setVisible(false);
//            add_gender.setVisible(false);                                   
//            add_phonenumber.setVisible(false);
//            
//            ID.setVisible(false);
//            
//            if(id.isVisible()==false)
//            {
//                ID_2.setVisible(true);
//                id.setVisible(true);
//                role.setVisible(true);
//                fName.setVisible(true);
//                age.setVisible(true);
//                gender.setVisible(true);                                   
//                phonenumber.setVisible(true);
//            }
//            else
//            {
//                try 
//                {
//                    manager.Search_admin(ID_2.getText());
//                    id.setText(manager.adminID);
//                    role.setText(manager.role);
//                    fName.setText(manager.fName);
//                    age.setText(manager.age);
//                    gender.setText(manager.gender);                                   
//                    phonenumber.setText(manager.phoneNum);
//                }
//                catch (IOException ex) 
//                {
//                    Logger.getLogger(MANAGER_FORM.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });                
        PRINT.setOnAction((ActionEvent e)
                -> {
            print(table);
        });
        center_bus_Pane.getChildren().addAll(table, PRINT, add_Button, add_id, add_seats, add_stop1, add_ending_point,
                add_stop2, add_time1, ID_2, add_time2, add_time3, add_time4, add_stop3, add_stop4, add_starting_point, delete_Button);
        root.setCenter(center_bus_Pane);
    }

    public void center_Customer_Pane() {
        Pane center_Customer__Pane = new Pane();
        center_Customer__Pane.setId("pane");
        //  
        ObservableList<CUSTOMER> data = FXCollections.observableArrayList();
        //
        TableView<CUSTOMER> table = new TableView<>();
        table.setEditable(true);
        table.setLayoutX(10);
        table.setLayoutY(10);
        table.setMinWidth(930);
        table.setMinHeight(640);
        //Filling data to table//
        customer.Read_data_from_file();
        for (int i = 0; i < customer.Data.size(); i++) {
            data.add(new CUSTOMER(customer.Data.get(i), customer.Data.get(i + 1), customer.Data.get(i + 2), customer.Data.get(i + 4), customer.Data.get(i + 5)));
            i += 5;
        }

        table.setItems(data);
        //end//
        TableColumn role_col = new TableColumn("Role");
        role_col.setMinWidth(100);
        role_col.setCellValueFactory(
                new PropertyValueFactory<CUSTOMER, String>("data"));
        //
        TableColumn ID_col = new TableColumn("ID");
        ID_col.setMinWidth(100);
        ID_col.setCellValueFactory(
                new PropertyValueFactory<CUSTOMER, String>("data1"));
        //
        TableColumn username_col = new TableColumn("UserName");
        username_col.setMinWidth(100);
        username_col.setCellValueFactory(
                new PropertyValueFactory<CUSTOMER, String>("data2"));
        //
        TableColumn email_col = new TableColumn("Email");
        email_col.setMinWidth(100);
        email_col.setCellValueFactory(
                new PropertyValueFactory<CUSTOMER, String>("data3"));
        //
        TableColumn phone_col = new TableColumn("Phone");
        phone_col.setMinWidth(100);
        phone_col.setCellValueFactory(
                new PropertyValueFactory<CUSTOMER, String>("data4"));
        //
        table.getColumns().addAll(role_col, ID_col, username_col, email_col, phone_col);
        //
        center_Customer__Pane.getChildren().addAll(table);
        //

        root.setCenter(center_Customer__Pane);
    }

    private void print(Node node) {
        PrinterJob PRINT;
        PRINT = PrinterJob.createPrinterJob();

        if (PRINT != null) {
            boolean printed = PRINT.printPage(node);

            if (printed) {
                PRINT.endJob();
            }
        } else {
            System.out.print("not printed");
        }
    }

    public Scene get_admin_scene() {
        return scene;
    }

    public void get_id(String id) {
        this.id = id;
    }

    public void catch_main_stage(Stage scn) {
        //copy = scn;
    }
}
