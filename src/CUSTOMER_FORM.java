
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.print.PrinterJob;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public final class CUSTOMER_FORM implements Serializable {

    private final String style = getClass().getResource("application.css").toExternalForm();
    private Button PROFILE, BUSES, TICKET, seat_1, seat_2, seat_3, seat_4, seat_5,
            seat_6, seat_7, seat_8, seat_9, seat_10, seat_11,
            seat_12, seat_13, seat_14, seat_15, seat_16, seat_17,
            seat_18, seat_19, seat_20, seat_21,
            seat_22, seat_23, seat_24, seat_25;
    private VBox LEFT_pane;
    private VBox RIGHT_Pane;
    private Pane TOP_pane;
    private Scene scene;
    String seat;
    Pane pane;
    private final BorderPane root;
    private Label text, data;
    Image icon;
    ImageView imageview;
    String id_from_login;

    BUS bus = new BUS();
    ADMIN admin = new ADMIN(bus);
    MANAGER manager = new MANAGER(admin);
    PERMISSION permission = new PERMISSION(manager, admin);
    BOOKING booking = new BOOKING(bus);
    CUSTOMER customer = new CUSTOMER(booking);

    public CUSTOMER_FORM() {
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

        Image bus_icon = new Image(getClass().getResourceAsStream("bus.png"));
        ImageView bus_icon_view = new ImageView(bus_icon);

        PROFILE = new Button("PROFILE", imageview);
        BUSES = new Button("BUSES", bus_icon_view);
        TICKET = new Button("Ticket");
        //
        PROFILE.setMinWidth(255);
        PROFILE.setMinHeight(100);
        PROFILE.setPadding(new Insets(10, 100, 10, 10));
        PROFILE.setId("buttons");
        //
        BUSES.setMinWidth(255);
        BUSES.setMinHeight(100);
        BUSES.setId("buttons");
        BUSES.setPadding(new Insets(10, 120, 10, 10));
        //
        TICKET.setMinWidth(250);
        TICKET.setMinHeight(100);
        TICKET.setId("buttons");
        TICKET.setPadding(new Insets(10, 70, 10, 10));
        //
        LEFT_pane.setStyle("-fx-background-color: white;");
        LEFT_pane.getChildren().addAll(PROFILE, BUSES, TICKET);
        //

//      out of the object                           top  right  bottom  left
        VBox.setMargin(PROFILE, new Insets(100, 0, 15, 12));
        VBox.setMargin(BUSES, new Insets(0, 0, 15, 12));
        VBox.setMargin(TICKET, new Insets(0, 0, 15, 12));
//       
        PROFILE.setOnAction((ActionEvent arg0)
                -> {
            PROFILE.setId("change");
            BUSES.setId("buttons");
            TICKET.setId("buttons");
            center_Profile_Pane();

        });

        BUSES.setOnAction((ActionEvent arg0)
                -> {
            PROFILE.setId("buttons");
            BUSES.setId("change");
            TICKET.setId("buttons");
            center_BUS_Pane();

        });

        TICKET.setOnAction((ActionEvent arg0)
                -> {
            PROFILE.setId("buttons");
            BUSES.setId("buttons");
            TICKET.setId("change");
            center_ticket_Pane();

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

    public void center_Profile_Pane() {
        //fill the variables with data in manager class

        StackPane secondpane = new StackPane();

        Rectangle frame = new Rectangle(10, 10, 700, 500);
        frame.setStroke(Color.BLACK);
        frame.setFill(Color.WHITE);

        customer.set_data(id_from_login);
        pane = new Pane();
        secondpane.setId("pane");

        Label MAIN_TEXT = new Label("Your Info");
        MAIN_TEXT.setLayoutX(50);
        MAIN_TEXT.setLayoutY(30);
        MAIN_TEXT.setId("title");

        Label ID = new Label("ID: ");
        TextField ID_data = new TextField();
        ID_data.setText(customer.cust_id);
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
        Role_data.setText(customer.Role);

        Role.setLayoutX(300);
        Role.setLayoutY(200);
        Role_data.setLayoutX(450);
        Role_data.setLayoutY(200);
        Role_data.setDisable(true);

        Label FName = new Label("User Name: ");
        TextField username_data = new TextField();
        FName.setId("style");
        username_data.setId("style");
        username_data.setText(customer.username);

        FName.setLayoutX(300);
        FName.setLayoutY(250);
        username_data.setLayoutX(450);
        username_data.setLayoutY(250);
        username_data.setDisable(true);

        Label AGE = new Label("Email: ");
        TextField email_data = new TextField();
        AGE.setId("style");
        email_data.setId("style");
        email_data.setText(customer.email);

        AGE.setLayoutX(300);
        AGE.setLayoutY(300);
        email_data.setLayoutX(450);
        email_data.setLayoutY(300);
        email_data.setDisable(true);

        Label GENDER = new Label("Phone Number: ");
        TextField phonenumber_data = new TextField();
        GENDER.setId("style");
        phonenumber_data.setId("style");
        phonenumber_data.setText(customer.phone);

        GENDER.setLayoutX(300);
        GENDER.setLayoutY(350);
        phonenumber_data.setLayoutX(450);
        phonenumber_data.setLayoutY(350);
        phonenumber_data.setDisable(true);

        // Place nodes in the pane
        pane.getChildren().addAll(MAIN_TEXT, ID,
                ID_data, FName, username_data, Role,
                Role_data, AGE, email_data, GENDER, phonenumber_data);

        secondpane.getChildren().addAll(frame, pane);
        root.setCenter(secondpane);
    }

    public void center_BUS_Pane() {
        Pane center_BUS_Pane = new Pane();
        center_BUS_Pane.setId("pane");
        //  
        ObservableList<BUS> data = FXCollections.observableArrayList();
        //
        TableView<BUS> table = new TableView<>();
        table.setEditable(true);
        table.setLayoutX(10);
        table.setLayoutY(10);
        table.setMinWidth(930);
        table.setMaxWidth(930);
        table.setMinHeight(640);
        //Filling data to table//

        bus.Read_data_from_file();

        for (int i = 0; i < bus.Bus_Data.size(); i++) {
            data.add(new BUS(bus.Bus_Data.get(i), bus.Bus_Data.get(i + 1), bus.Bus_Data.get(i + 2), bus.Bus_Data.get(i + 3), bus.Bus_Data.get(i + 4),
                    bus.Bus_Data.get(i + 5), bus.Bus_Data.get(i + 6), bus.Bus_Data.get(i + 7), bus.Bus_Data.get(i + 8), bus.Bus_Data.get(i + 9),
                    bus.Bus_Data.get(i + 10), bus.Bus_Data.get(i + 11)));
            i += 12;
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
        table.setOnMouseClicked((MouseEvent e)
                -> {
            System.out.println("Clicked on " + (table.getSelectionModel().getSelectedItem().getData()));

            center_booking_Pane((table.getSelectionModel().getSelectedItem().getData()));
        });
        center_BUS_Pane.getChildren().add(table);

        root.setCenter(center_BUS_Pane);
    }
///////////////////////////////////////////////////////////////////////////

    public void center_booking_Pane(String id) {
        Pane center_Permission_Pane = new Pane();
        center_Permission_Pane.setId("pane");

        bus.search_bus(id);
        Label text = new Label("BUS_Seats");
        text.setLayoutX(780);
        text.setLayoutY(50);
        text.setId("title");

        TextField bus_id = new TextField();
        bus_id.setMinWidth(200);
        bus_id.setPromptText(bus.bus_id);
        bus_id.setLayoutX(50);
        bus_id.setLayoutY(100);
        //
        TextField text1 = new TextField();
        text1.setPromptText(bus.stop);
        text1.setMinWidth(200);
        text1.setLayoutX(50);
        text1.setLayoutY(160);
        //
        TextField text2 = new TextField();
        text2.setMinWidth(200);
        text2.setPromptText(bus.stop2);
        text2.setLayoutX(50);
        text2.setLayoutY(220);
        //
        TextField text3 = new TextField();
        text3.setMinWidth(200);
        text3.setPromptText(bus.stop3);
        text3.setLayoutX(50);
        text3.setLayoutY(280);
        //
        TextField text4 = new TextField();
        text4.setMinWidth(200);
        text4.setPromptText(bus.stop4);
        text4.setLayoutX(50);
        text4.setLayoutY(340);
        //
        TextField start = new TextField();
        start.setMinWidth(200);
        start.setPromptText(bus.start);
        start.setLayoutX(50);
        start.setLayoutY(400);
        //
        TextField end = new TextField();
        end.setMinWidth(200);
        end.setPromptText(bus.end);
        end.setLayoutX(50);
        end.setLayoutY(460);
        //
        Button BOOK_Button = new Button("BOOK");
        BOOK_Button.setId("dark-blue");
        BOOK_Button.setMinWidth(200);
        BOOK_Button.setMaxHeight(100);
        BOOK_Button.setLayoutX(700);
        BOOK_Button.setLayoutY(600);
        //
        seat_1 = new Button("1");
        seat_1.setLayoutX(700);
        seat_1.setLayoutY(100);

        seat_2 = new Button("2");
        seat_2.setLayoutX(750);
        seat_2.setLayoutY(100);

        seat_3 = new Button("3");
        seat_3.setLayoutX(850);
        seat_3.setLayoutY(100);

        seat_4 = new Button("4");
        seat_4.setLayoutX(900);
        seat_4.setLayoutY(100);

        seat_5 = new Button("5");
        seat_5.setLayoutX(700);
        seat_5.setLayoutY(150);

        seat_6 = new Button("6");
        seat_6.setLayoutX(750);
        seat_6.setLayoutY(150);

        seat_7 = new Button("7");
        seat_7.setLayoutX(850);
        seat_7.setLayoutY(150);

        seat_8 = new Button("8");
        seat_8.setLayoutX(900);
        seat_8.setLayoutY(150);

        seat_9 = new Button("9");
        seat_9.setLayoutX(700);
        seat_9.setLayoutY(200);

        seat_10 = new Button("10");
        seat_10.setLayoutX(750);
        seat_10.setLayoutY(200);

        seat_11 = new Button("11");
        seat_11.setLayoutX(850);
        seat_11.setLayoutY(200);
        seat_12 = new Button("12");

        seat_12.setLayoutX(900);
        seat_12.setLayoutY(200);
        seat_13 = new Button("13");

        seat_13.setLayoutX(700);
        seat_13.setLayoutY(250);
        seat_14 = new Button("14");

        seat_14.setLayoutX(750);
        seat_14.setLayoutY(250);

        seat_15 = new Button("15");
        seat_15.setLayoutX(850);
        seat_15.setLayoutY(250);

        seat_16 = new Button("16");
        seat_16.setLayoutX(900);
        seat_16.setLayoutY(250);

        seat_17 = new Button("17");
        seat_17.setLayoutX(700);
        seat_17.setLayoutY(300);

        seat_18 = new Button("18");
        seat_18.setLayoutX(750);
        seat_18.setLayoutY(300);

        seat_19 = new Button("19");
        seat_19.setLayoutX(850);
        seat_19.setLayoutY(300);

        seat_20 = new Button("20");
        seat_20.setLayoutX(900);
        seat_20.setLayoutY(300);

        seat_21 = new Button("21");
        seat_21.setLayoutX(700);
        seat_21.setLayoutY(350);
        seat_22 = new Button("22");
        seat_22.setLayoutX(750);
        seat_22.setLayoutY(350);
        seat_23 = new Button("23");
        seat_23.setLayoutX(800);
        seat_23.setLayoutY(350);
        seat_24 = new Button("24");
        seat_24.setLayoutX(850);
        seat_24.setLayoutY(350);
        seat_25 = new Button("25");
        seat_25.setLayoutX(900);
        seat_25.setLayoutY(350);

        seat_1.setId("default_seat");
        seat_2.setId("default_seat");
        seat_3.setId("default_seat");
        seat_4.setId("default_seat");

        seat_5.setId("default_seat");

        seat_6.setId("default_seat");

        seat_7.setId("default_seat");

        seat_8.setId("default_seat");

        seat_9.setId("default_seat");

        seat_10.setId("default_seat");

        seat_11.setId("default_seat");

        seat_12.setId("default_seat");

        seat_13.setId("default_seat");

        seat_14.setId("default_seat");

        seat_15.setId("default_seat");

        seat_16.setId("default_seat");

        seat_17.setId("default_seat");

        seat_18.setId("default_seat");

        seat_19.setId("default_seat");

        seat_20.setId("default_seat");

        seat_21.setId("default_seat");

        seat_22.setId("default_seat");

        seat_23.setId("default_seat");

        seat_24.setId("default_seat");

        seat_25.setId("default_seat");

        book_seat_handler handler = new book_seat_handler();

        seat_1.setOnAction(handler);
        seat_2.setOnAction(handler);
        seat_3.setOnAction(handler);
        seat_4.setOnAction(handler);
        seat_5.setOnAction(handler);
        seat_6.setOnAction(handler);
        seat_7.setOnAction(handler);
        seat_8.setOnAction(handler);
        seat_9.setOnAction(handler);
        seat_10.setOnAction(handler);
        seat_11.setOnAction(handler);
        seat_12.setOnAction(handler);
        seat_13.setOnAction(handler);
        seat_14.setOnAction(handler);
        seat_15.setOnAction(handler);
        seat_16.setOnAction(handler);
        seat_17.setOnAction(handler);
        seat_18.setOnAction(handler);
        seat_19.setOnAction(handler);
        seat_20.setOnAction(handler);
        seat_21.setOnAction(handler);
        seat_22.setOnAction(handler);
        seat_23.setOnAction(handler);
        seat_24.setOnAction(handler);
        seat_25.setOnAction(handler);

        if (booking.view_seats(id, seat_1.getText())) {
            seat_1.setDisable(true);
        }
        if (booking.view_seats(id, seat_2.getText())) {
            seat_2.setDisable(true);
        }
        if (booking.view_seats(id, seat_3.getText())) {
            seat_3.setDisable(true);
        }
        if (booking.view_seats(id, seat_4.getText())) {
            seat_4.setDisable(true);
        }
        if (booking.view_seats(id, seat_5.getText())) {
            seat_5.setDisable(true);
        }
        if (booking.view_seats(id, seat_6.getText())) {
            seat_6.setDisable(true);
        }
        if (booking.view_seats(id, seat_7.getText())) {
            seat_7.setDisable(true);
        }
        if (booking.view_seats(id, seat_8.getText())) {
            seat_8.setDisable(true);
        }
        if (booking.view_seats(id, seat_9.getText())) {
            seat_9.setDisable(true);
        }
        if (booking.view_seats(id, seat_10.getText())) {
            seat_10.setDisable(true);
        }
        if (booking.view_seats(id, seat_11.getText())) {
            seat_11.setDisable(true);
        }
        if (booking.view_seats(id, seat_12.getText())) {
            seat_12.setDisable(true);
        }
        if (booking.view_seats(id, seat_13.getText())) {
            seat_13.setDisable(true);
        }
        if (booking.view_seats(id, seat_14.getText())) {
            seat_14.setDisable(true);
        }

        if (booking.view_seats(id, seat_15.getText())) {
            seat_15.setDisable(true);
        }
        if (booking.view_seats(id, seat_16.getText())) {
            seat_16.setDisable(true);
        }
        if (booking.view_seats(id, seat_17.getText())) {
            seat_17.setDisable(true);
        }
        if (booking.view_seats(id, seat_18.getText())) {
            seat_18.setDisable(true);
        }

        if (booking.view_seats(id, seat_19.getText())) {
            seat_19.setDisable(true);
        }
        if (booking.view_seats(id, seat_20.getText())) {
            seat_20.setDisable(true);
        }
        if (booking.view_seats(id, seat_21.getText())) {
            seat_21.setDisable(true);
        }
        if (booking.view_seats(id, seat_22.getText())) {
            seat_22.setDisable(true);
        }

        if (booking.view_seats(id, seat_23.getText())) {
            seat_23.setDisable(true);
        }

        if (booking.view_seats(id, seat_24.getText())) {
            seat_24.setDisable(true);
        }

        if (booking.view_seats(id, seat_25.getText())) {
            seat_25.setDisable(true);
        }

        BOOK_Button.setOnMouseClicked((MouseEvent e) -> {

            if (seat.isEmpty() == true || booking.book_avaliable(id_from_login) == true) {
                BUSES.setDisable(true);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("NOTE...");
                alert.setHeaderText("error will occur!");
                alert.setContentText("you already booked a seat in a bus!!");
                alert.showAndWait();
                BUSES.setId("buttons");
                center_home_Pane();

            } else {
                customer.book.book_seat(id, seat, id_from_login);
                center_payment_Pane();
            }

        });
        center_Permission_Pane.getChildren().addAll(seat_1, seat_2, seat_3, seat_4, seat_5, seat_6, seat_7, seat_8,
                seat_9, seat_10, seat_11, seat_12, seat_13, seat_14, seat_15, seat_16, seat_17, seat_18, seat_19, seat_20,
                seat_21, seat_22, seat_23, seat_24, seat_25, text, text1, text2, text3, text4, start, end, bus_id, BOOK_Button);

        root.setCenter(center_Permission_Pane);
    }

    class book_seat_handler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {

            seat_1.setId("default_seat");
            seat_2.setId("default_seat");
            seat_3.setId("default_seat");
            seat_4.setId("default_seat");

            seat_5.setId("default_seat");

            seat_6.setId("default_seat");

            seat_7.setId("default_seat");

            seat_8.setId("default_seat");

            seat_9.setId("default_seat");

            seat_10.setId("default_seat");

            seat_11.setId("default_seat");

            seat_12.setId("default_seat");

            seat_13.setId("default_seat");

            seat_14.setId("default_seat");

            seat_15.setId("default_seat");

            seat_16.setId("default_seat");

            seat_17.setId("default_seat");

            seat_18.setId("default_seat");

            seat_19.setId("default_seat");

            seat_20.setId("default_seat");

            seat_21.setId("default_seat");

            seat_22.setId("default_seat");

            seat_23.setId("default_seat");

            seat_24.setId("default_seat");

            seat_25.setId("default_seat");

            if (e.getSource() == seat_1) {
                seat_1.setId("book_seat");
                seat = seat_1.getText();
            }
            if (e.getSource() == seat_2) {
                seat_2.setId("book_seat");
                seat = seat_2.getText();
            }
            if (e.getSource() == seat_3) {
                seat_3.setId("book_seat");
                seat = seat_3.getText();
            }
            if (e.getSource() == seat_4) {
                seat_4.setId("book_seat");
                seat = seat_4.getText();
            }
            if (e.getSource() == seat_5) {
                seat_5.setId("book_seat");
                seat = seat_5.getText();
            }
            if (e.getSource() == seat_6) {
                seat_6.setId("book_seat");
                seat = seat_6.getText();
            }
            if (e.getSource() == seat_7) {
                seat_7.setId("book_seat");
                seat = seat_7.getText();
            }
            if (e.getSource() == seat_8) {
                seat_8.setId("book_seat");
                seat = seat_8.getText();
            }
            if (e.getSource() == seat_9) {
                seat_9.setId("book_seat");
                seat = seat_9.getText();
            }
            if (e.getSource() == seat_10) {
                seat_10.setId("book_seat");
                seat = seat_10.getText();
            }
            if (e.getSource() == seat_11) {
                seat_11.setId("book_seat");
                seat = seat_11.getText();
            }
            if (e.getSource() == seat_12) {
                seat_12.setId("book_seat");
                seat = seat_12.getText();
            }
            if (e.getSource() == seat_13) {
                seat_13.setId("book_seat");
                seat = seat_13.getText();
            }
            if (e.getSource() == seat_14) {
                seat_14.setId("book_seat");
                seat = seat_14.getText();
            }
            if (e.getSource() == seat_15) {
                seat_15.setId("book_seat");
                seat = seat_15.getText();
            }
            if (e.getSource() == seat_16) {
                seat_16.setId("book_seat");
                seat = seat_16.getText();
            }
            if (e.getSource() == seat_17) {
                seat_17.setId("book_seat");
                seat = seat_17.getText();
            }
            if (e.getSource() == seat_18) {
                seat_18.setId("book_seat");
                seat = seat_18.getText();
            }
            if (e.getSource() == seat_19) {
                seat_19.setId("book_seat");
                seat = seat_19.getText();
            }
            if (e.getSource() == seat_20) {
                seat_20.setId("book_seat");
                seat = seat_20.getText();
            }
            if (e.getSource() == seat_21) {
                seat_21.setId("book_seat");
                seat = seat_21.getText();
            }
            if (e.getSource() == seat_22) {
                seat_22.setId("book_seat");
                seat = seat_22.getText();
            }
            if (e.getSource() == seat_23) {
                seat_23.setId("book_seat");
                seat = seat_23.getText();
            }
            if (e.getSource() == seat_24) {
                seat_24.setId("book_seat");
                seat = seat_24.getText();
            }
            if (e.getSource() == seat_25) {
                seat_25.setId("book_seat");
                seat = seat_25.getText();
            }
        }
    }

    public void center_payment_Pane() {

        Pane center_payment_Pane = new Pane();
        center_payment_Pane.setMaxWidth(1000);
        //
//        Image icon = new Image(getClass().getResourceAsStream("default_qrcode.png"));
        //      ImageView imageview = new ImageView(icon);

        center_payment_Pane.setId("pane");
        //elements
        Button Pay = new Button("Pay");
        Button Cash = new Button("Cash");
        Button Visa = new Button("Visa");

        Label CardName = new Label("Card Name holder");
        TextField CardNameU = new TextField();
        Label CardNumber = new Label("Card Number");
        TextField CardNumberU = new TextField();
        Label ExpiryDate = new Label("Expiry Date");
        TextField ExpiryDateU = new TextField();
        Label BankName = new Label("Bank Name");
        TextField BankNameU = new TextField();
        Label Price = new Label("Price");
        Label Amount = new Label("200$");

        Label ScreenShot = new Label("Screenshot this QR Code");
        Label warning = new Label("password or username are not correct!!");
        //Image
//        imageview.setFitHeight(300);
//        imageview.setFitWidth(300);
//        imageview.setLayoutX(75);
//        imageview.setLayoutY(260);
//        imageview.setVisible(false);
        //
        //Label of BankName
        BankName.setLayoutX(50);
        BankName.setLayoutY(300);
        BankName.setId("text");
        BankName.setVisible(false);
        //TextField of BankName
        BankNameU.setLayoutX(190);
        BankNameU.setLayoutY(300);
        BankNameU.setVisible(false);
        //Label of CardName
        CardName.setLayoutX(50);
        CardName.setLayoutY(400);
        CardName.setId("text");
        CardName.setVisible(false);
        //TextField of CardName
        CardNameU.setLayoutX(190);
        CardNameU.setLayoutY(400);
        CardNameU.setVisible(false);
        //Label of CardNumber
        CardNumber.setLayoutX(50);
        CardNumber.setLayoutY(500);
        CardNumber.setId("text");
        CardNumber.setVisible(false);
        //TextField of CardNumber
        CardNumberU.setLayoutX(190);
        CardNumberU.setLayoutY(500);
        CardNumberU.setVisible(false);
        //Label of Expiry Date
        ExpiryDate.setLayoutX(50);
        ExpiryDate.setLayoutY(600);
        ExpiryDate.setId("text");
        ExpiryDate.setVisible(false);
        //TextField of ExpiryDate
        ExpiryDateU.setLayoutX(190);
        ExpiryDateU.setLayoutY(600);
        ExpiryDateU.setVisible(false);
        //Label of Price
        Price.setLayoutX(495);
        Price.setLayoutY(450);
        Price.setId("text");
        //Label of Amount
        Amount.setLayoutX(650);
        Amount.setLayoutY(450);
        Amount.setId("text");
        //button Pay 
        Pay.setMinWidth(150);
        Pay.setLayoutX(700);
        Pay.setLayoutY(600);
        Pay.setId("red");
        Pay.setCursor(Cursor.OPEN_HAND);
        //Label of ScreenShot
        ScreenShot.setLayoutX(450);
        ScreenShot.setLayoutY(600);
        ScreenShot.setId("text");
        ScreenShot.setVisible(false);
        //warning 3
        warning.setLayoutX(70);
        warning.setLayoutY(460);
        warning.setStyle(" -fx-text-fill: red;");
        //hiding the warning
        warning.setVisible(false);
        Cash.setMinWidth(150);
        Cash.setLayoutX(180);
        Cash.setLayoutY(100);
        Cash.setId("dark-blue");
        Cash.setCursor(Cursor.OPEN_HAND);
        Visa.setMinWidth(150);
        Visa.setLayoutX(600);
        Visa.setLayoutY(100);
        Visa.setId("dark-blue");
        Visa.setCursor(Cursor.OPEN_HAND);

        Pay.setOnAction((ActionEvent arg0) -> {
            center_ticket_Pane();
        });
        Visa.setOnAction((ActionEvent arg0) -> {
            imageview.setVisible(false);
            ScreenShot.setVisible(false);
            if (CardName.isVisible()) {
                CardName.setVisible(false);
                CardNameU.setVisible(false);
            } else {
                CardName.setVisible(true);
                CardNameU.setVisible(true);
            }
            if (CardNumber.isVisible()) {
                CardNumber.setVisible(false);
                CardNumberU.setVisible(false);
            } else {
                CardNumber.setVisible(true);
                CardNumberU.setVisible(true);
            }
            if (BankName.isVisible()) {
                BankName.setVisible(false);
                BankNameU.setVisible(false);
            } else {
                BankName.setVisible(true);
                BankNameU.setVisible(true);
            }
            if (ExpiryDate.isVisible()) {
                ExpiryDate.setVisible(false);
                ExpiryDateU.setVisible(false);
            } else {
                ExpiryDate.setVisible(true);
                ExpiryDateU.setVisible(true);
            }
        });
        Cash.setOnAction((ActionEvent arg0) -> {
            CardName.setVisible(false);
            CardNameU.setVisible(false);
            CardNumber.setVisible(false);
            CardNumberU.setVisible(false);
            BankName.setVisible(false);
            BankNameU.setVisible(false);
            ExpiryDate.setVisible(false);
            ExpiryDateU.setVisible(false);
//                if (imageview.isVisible()) {
//                    imageview.setVisible(false);
//                    ScreenShot.setVisible(false);
//                } else {
//                    imageview.setVisible(true);
//                    ScreenShot.setVisible(true);
//                }
        });
        center_payment_Pane.getChildren().addAll(CardName, CardNameU, CardNumber, CardNumberU, ExpiryDate, ExpiryDateU, Price, Amount, Pay, warning, Cash, Visa, BankName, BankNameU, ScreenShot);
        root.setCenter(center_payment_Pane);
    }

    //nour
    public void center_ticket_Pane() {

        Pane center_ticket_Pane = new Pane();
        center_ticket_Pane.setMaxWidth(1000);
        //
        Image icon = new Image(getClass().getResourceAsStream("qrcode.jpg"));
        ImageView imageview = new ImageView(icon);
        center_ticket_Pane.setId("pane");
        //elements
        Button Print = new Button("Print");
        Label name = new Label("Ticket");

        Label ID = new Label("ID");

        Label Bus_ID = new Label("Bus ID");

        Label Price = new Label("Price");
        Label Amount = new Label("200$");
        Label data1=new Label("No Data!");
        Label data2=new Label("NO Data!");
        imageview.setVisible(false);
        
        if (booking.view(id_from_login)) 
        {
            data1.setText(booking.id);
            data2.setText(booking.bus_id);
            imageview.setVisible(true);
        }

        //Ticket label
        name.setLayoutX(350);
        name.setLayoutY(40);
        name.setId("title");
        //Image
        imageview.setFitHeight(250);
        imageview.setFitWidth(250);
        imageview.setLayoutX(600);
        imageview.setLayoutY(5);
        
        //ID label
        ID.setLayoutX(50);
        ID.setLayoutY(300);
        ID.setId("text");
        //Data1 label
        data1.setLayoutX(100);
        data1.setLayoutY(300);
        data1.setId("text");

        
        //BusID label
        Bus_ID.setLayoutX(50);
        Bus_ID.setLayoutY(400);
        Bus_ID.setId("text");
        
        
        //data2 label
        data2.setLayoutX(100);
        data2.setLayoutY(400);
        data2.setId("text");
        //Label of Price
        Price.setLayoutX(50);
        Price.setLayoutY(600);
        Price.setId("text");
        //Label of Amount
        Amount.setLayoutX(100);
        Amount.setLayoutY(600);
        Amount.setId("text");
        //button Pay 
        Print.setMinWidth(150);
        Print.setLayoutX(700);
        Print.setLayoutY(600);
        Print.setId("red");
        Print.setCursor(Cursor.OPEN_HAND);
        Print.setOnAction((ActionEvent arg0) -> {
            print(center_ticket_Pane);
        });
        
        //
        center_ticket_Pane.getChildren().addAll(ID, Bus_ID, Price, Amount, Print, name,data1,data2,imageview);
        root.setCenter(center_ticket_Pane);
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

    public Scene get_customer_pane() {
        return scene;
    }

    public void get_id_tocust(String id) {
        this.id_from_login = id;
    }

    public void catch_main_stage(Stage scn) {

    }
}
