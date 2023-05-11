

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
import javafx.scene.Node;
import javafx.scene.Scene;
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

public final class MANAGER_FORM implements Serializable
{
    private final String  style= getClass().getResource("application.css").toExternalForm();
    private Button PROFILE,BUSES,ADMIN,CUSTOMER,PERMISIONS;
    private VBox LEFT_pane,RIGHT_Pane;
    private Pane TOP_pane ;
    private final Scene scene;
    Pane pane;
    private final BorderPane root;
    private Label text,data;
    Image icon;
    ImageView imageview;
    
    
    
    CUSTOMER customer = new CUSTOMER();
    BUS bus = new BUS();
    ADMIN admin = new ADMIN(bus);
    MANAGER manager = new MANAGER(admin);
    PERMISSION permission = new PERMISSION(manager,admin);
    
    
    public MANAGER_FORM()   
    {
    	root = new BorderPane();  	
    	
	root.setTop(TOP_pane());
        root.setLeft(LEFT_pane());
        root.setRight(RIGHT_Pane());
         root.setCenter(center_home_Pane());
         
        scene = new Scene(root,1920,1080);
        scene.getStylesheets().add(style);
    }
    public Pane TOP_pane ()
    {
    	TOP_pane = new Pane();
    	TOP_pane.setMinWidth(100);
    	TOP_pane.setMinHeight(120);

    	icon = new Image (getClass().getResourceAsStream("bus-stop.png"));
    	imageview = new ImageView(icon);
    	
    	Image home_photo = new Image (getClass().getResourceAsStream("Homebtn.png"));
    	ImageView home_photo_view = new ImageView(home_photo);
    	
    	
    	Image logout_photo = new Image (getClass().getResourceAsStream("logout.png"));
    	ImageView logout_photo_view = new ImageView(logout_photo);
    	
    	Button Home_btn = new Button("",home_photo_view);
    	Button logout_btn = new Button("",logout_photo_view);
    	
    	TOP_pane.setStyle("-fx-background-color:  white ; ");
    	
    	text = new Label("MIU");
    	TOP_pane.getChildren().addAll(imageview,text,Home_btn,logout_btn);
	    
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
		
                Home_btn.setOnAction((ActionEvent e) -> 
                {
                    PROFILE.setId("buttons");
                    ADMIN.setId("buttons");
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
    public StackPane center_home_Pane()   
    {
        StackPane center_home_Pane = new StackPane();
        
        Pane permission = new Pane();
        Pane income = new Pane();
        
        
        //
        Pane Bus = new Pane();
        Bus.setId("red");
        Bus.setMaxSize(300,200);
        center_home_Pane.setAlignment(Bus, Pos.TOP_LEFT);
        center_home_Pane.setMargin(Bus, new Insets(8,8,8,8));
        
        Label text = new Label("BUSES");
        text.setId("title");
        text.setLayoutX(65);
        text.setLayoutY(10);      
        
        Label text2 = new Label();
       text2.setText(bus.bus_counter());
        text2.setStyle(" -fx-text-fill: white;\n" +" -fx-font-weight: bold;\n" +" -fx-font-size: 60;");
        text2.setLayoutX(80);
        text2.setLayoutY(80); 
       
        Bus.getChildren().addAll(text,text2);
        //
        Pane admin = new Pane();
        admin.setId("red");
        admin.setMaxSize(300,200);
        center_home_Pane.setAlignment(admin, Pos.TOP_CENTER);
        center_home_Pane.setMargin(admin, new Insets(8,8,8,8));
        
        Label text3 = new Label("STAFF");
        text3.setId("title");
        text3.setLayoutX(65);
        text3.setLayoutY(10);      
        
        Label text4 = new Label();
        text4.setText(manager.Staff_counter());
        text4.setStyle(" -fx-text-fill: white;\n" +" -fx-font-weight: bold;\n" +" -fx-font-size: 60;");
        text4.setLayoutX(80);
        text4.setLayoutY(80); 
       
        admin.getChildren().addAll(text3,text4);
        //
        Pane Customer = new Pane();
        Customer.setId("red");
        Customer.setMaxSize(300,200);
        center_home_Pane.setAlignment(Customer, Pos.TOP_RIGHT);
        center_home_Pane.setMargin(Customer, new Insets(8,8,8,8));
        
        Label text5 = new Label("CUSTOMERS");
        text5.setId("title");
        text5.setLayoutX(65);
        text5.setLayoutY(10);      
        
        Label text6 = new Label();
        text6.setText(customer.Customer_counter());
        text6.setStyle(" -fx-text-fill: white;\n" +" -fx-font-weight: bold;\n" +" -fx-font-size: 60;");
        text6.setLayoutX(80);
        text6.setLayoutY(80); 
       
        Customer.getChildren().addAll(text5,text6);
        //
        center_home_Pane.setId("pane");
        center_home_Pane.getChildren().addAll(Bus,admin,Customer);
        
        return center_home_Pane;
    }
    public VBox LEFT_pane()
    {
    	LEFT_pane = new VBox();
    	//
    	LEFT_pane.setMinWidth(280);
    	LEFT_pane.setMinHeight(300);
    	//
    	icon = new Image (getClass().getResourceAsStream("user.png"));
    	imageview = new ImageView(icon);
        
        Image customer_icon = new Image (getClass().getResourceAsStream("Customer.png"));
    	ImageView customer_icon_view = new ImageView(customer_icon);
        
        Image admin_icon = new Image (getClass().getResourceAsStream("admin (3).png"));
    	ImageView admin_icon_view = new ImageView(admin_icon);
        
        Image bus_icon = new Image (getClass().getResourceAsStream("bus.png"));
    	ImageView bus_icon_view = new ImageView(bus_icon);
        
        Image Permission_icon = new Image (getClass().getResourceAsStream("permission.png"));
    	ImageView Permission_icon_view = new ImageView(Permission_icon);
        
    	 //BUSES,ADMIN,CUSTOMER
    	PROFILE = new Button("PROFILE",imageview);
        ADMIN = new Button("ADMIN",admin_icon_view);
        CUSTOMER = new Button("CUSTOMERS",customer_icon_view);
        BUSES = new Button("BUSES",bus_icon_view);
        PERMISIONS = new Button("PERMISIONS",Permission_icon_view);
        //
        PROFILE.setMinWidth(255);
        PROFILE.setMinHeight(100);
        PROFILE.setPadding(new Insets(10,100,10,10));
        PROFILE.setId("buttons");
        //
        ADMIN.setMinWidth(255);
        ADMIN.setMinHeight(100);
        ADMIN.setId("buttons");
        ADMIN.setPadding(new Insets(10,110,10,10));
        //
        CUSTOMER.setMinWidth(250);
        CUSTOMER.setMinHeight(100);
        CUSTOMER.setId("buttons");
        CUSTOMER.setPadding(new Insets(10,70,10,10));
        //
        BUSES.setMinWidth(255);
        BUSES.setMinHeight(100);
        BUSES.setId("buttons");
        BUSES.setPadding(new Insets(10,120,10,10));
        //
        PERMISIONS.setMinWidth(250);
        PERMISIONS.setMinHeight(100);
        PERMISIONS.setId("buttons");
        PERMISIONS.setPadding(new Insets(10,70,10,10));
        //
        LEFT_pane.setStyle("-fx-background-color: white;");
        LEFT_pane.getChildren().addAll(PROFILE,ADMIN,CUSTOMER,BUSES,PERMISIONS);
        //
        
//      out of the object                           top  right  bottom  left
        VBox.setMargin(PROFILE   , new Insets(100, 0, 15, 12));
        VBox.setMargin(ADMIN     , new Insets(0, 0, 15, 12));
        VBox.setMargin(CUSTOMER  , new Insets(0, 0, 15, 12));
        VBox.setMargin(BUSES, new Insets(0, 0, 15, 12));
        VBox.setMargin(PERMISIONS, new Insets(0, 0, 15, 12));
        
//       
         
        ADMIN.setOnAction((ActionEvent e) -> 
        {
            PROFILE.setId("buttons");
            ADMIN.setId("change");
            CUSTOMER.setId("buttons");
            BUSES.setId("buttons");
            PERMISIONS.setId("buttons");
            center_Admin_Pane() ;

        });
        CUSTOMER.setOnAction((ActionEvent e) -> 
        {
            PROFILE.setId("buttons");
            ADMIN.setId("buttons");
            CUSTOMER.setId("change");
            BUSES.setId("buttons");
            PERMISIONS.setId("buttons");
            center_Customer_Pane() ;

        });
         PROFILE.setOnAction((ActionEvent arg0) -> 
         {
            PROFILE.setId("change");
            ADMIN.setId("buttons");
            CUSTOMER.setId("buttons");
            BUSES.setId("buttons");
            PERMISIONS.setId("buttons");

                try {
                    center_Profile_Pane();
                } catch (IOException ex) {
                    Logger.getLogger(MANAGER_FORM.class.getName()).log(Level.SEVERE, null, ex);
                }
  
            });
         BUSES.setOnAction((ActionEvent arg0) -> 
         {
            PROFILE.setId("buttons");
            ADMIN.setId("buttons");
            CUSTOMER.setId("buttons");
            BUSES.setId("change");
            PERMISIONS.setId("buttons");

            center_BUS_Pane();
  
            });

         
          PERMISIONS.setOnAction((ActionEvent arg0) -> 
         {
            PROFILE.setId("buttons");
            ADMIN.setId("buttons");
            CUSTOMER.setId("buttons");
            BUSES.setId("buttons");
            PERMISIONS.setId("change");
            center_Permission_Pane();
         });
         
         
        return LEFT_pane;
    }
    public VBox RIGHT_Pane()
    {
    	RIGHT_Pane = new VBox();
    
    	RIGHT_Pane.setStyle("-fx-background-color: white;");
    	
    	RIGHT_Pane.setMinWidth(300);
    	RIGHT_Pane.setMinHeight(300);
       
        
        return RIGHT_Pane;
    }
    public void center_Profile_Pane() throws IOException 
    {
         //fill the variables with data in manager class
            
            StackPane secondpane = new StackPane();
            
            Rectangle frame = new Rectangle(10,10,700,500);
            frame.setStroke(Color.BLACK);
            frame.setFill(Color.WHITE);
            manager.set_data();
            pane = new Pane();
            secondpane.setId("pane");
            
            Label MAIN_TEXT = new Label("Your Info");
            MAIN_TEXT.setLayoutX(50);
            MAIN_TEXT.setLayoutY(30);
            MAIN_TEXT.setId("title");
            
            Label ID = new Label("ID: ");
            TextField ID_data = new TextField();
            ID_data.setText(manager.mang_id);
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
            Role_data.setText(manager.man_role);
            
            Role.setLayoutX(300);
            Role.setLayoutY(200);
            Role_data.setLayoutX(450);
            Role_data.setLayoutY(200);
            Role_data.setDisable(true);
            
            Label FName = new Label("First Name: ");
            TextField FName_data = new TextField();
            FName.setId("style");
            FName_data.setId("style");
            FName_data.setText(manager.man_fame);
            
            FName.setLayoutX(300);
            FName.setLayoutY(250);
            FName_data.setLayoutX(450);
            FName_data.setLayoutY(250);
           
            Label AGE = new Label("Age: ");
            TextField AGE_data = new TextField();
            AGE.setId("style");
            AGE_data.setId("style");
            AGE_data.setText(manager.man_age);
            
            AGE.setLayoutX(300);
            AGE.setLayoutY(300);
            AGE_data.setLayoutX(450);
            AGE_data.setLayoutY(300);
            
            Label GENDER = new Label("Gender: ");
            TextField GENDER_data = new TextField();
            GENDER.setId("style");
            GENDER_data.setId("style");
            GENDER_data.setText(manager.man_gender);
            
            GENDER.setLayoutX(300);
            GENDER.setLayoutY(350);
            GENDER_data.setLayoutX(450);
            GENDER_data.setLayoutY(350);
            
            Label PHONE_NUMBER = new Label("Phone Number: ");
            TextField PHONE_NUMBER_data = new TextField();
            PHONE_NUMBER.setId("style");
            PHONE_NUMBER_data.setId("style");
            PHONE_NUMBER_data.setText(manager.man_phonenum);
            
            PHONE_NUMBER.setLayoutX(300);
            PHONE_NUMBER.setLayoutY(400);
            PHONE_NUMBER_data.setLayoutX(450);
            PHONE_NUMBER_data.setLayoutY(400);
            
            
            Button Save = new Button("SAVE");
            Save.setId("dark-blue");
            Save.setLayoutX(460);
            Save.setLayoutY(500);
            
            
            Save.setOnAction((ActionEvent arg1) -> {
                
            if( FName_data.getText().isEmpty()||AGE_data.getText().isEmpty()||GENDER_data.getText().isEmpty()||PHONE_NUMBER_data.getText().isEmpty())
            {
               System.out.print("cant opertate");
            }
             else
            {
                manager.edit_man_data(FName_data.getText(),
                        AGE_data.getText(), GENDER_data.getText(), PHONE_NUMBER_data.getText());
            }
            });
        
            // Place nodes in the pane
            pane.getChildren().addAll(MAIN_TEXT,ID
                    ,ID_data ,FName,FName_data  , Role,
                    Role_data ,AGE ,AGE_data ,GENDER ,GENDER_data
                    ,PHONE_NUMBER ,PHONE_NUMBER_data ,Save);
            
            secondpane.getChildren().addAll(frame,pane);
            root.setCenter(secondpane);
    }
    public void center_Admin_Pane() 
    {     
    	Pane center_Admin_Pane = new Pane();
        center_Admin_Pane.setId("pane");
        //  
        ObservableList<MANAGER> data = FXCollections.observableArrayList();
        //
        TableView<MANAGER> table = new TableView<>();
        table.setEditable(true);
        table.setLayoutX(10);
        table.setLayoutY(10);
        table.setMinWidth(930);
        //Filling data to table//
        manager.Read_data_from_file();
        for(int i =0;i<manager.Manager_Data.size();i++)
        {
            data.add(new MANAGER(manager.Manager_Data.get(i),manager.Manager_Data.get(i+1),manager.Manager_Data.get(i+2),
            manager.Manager_Data.get(i+3),manager.Manager_Data.get(i+4),manager.Manager_Data.get(i+5)));
            i+=5;
        }
        table.setItems(data);
        //end//
        
        TableColumn ID_col = new TableColumn("ID");
        ID_col.setMinWidth(100);
        ID_col.setCellValueFactory(
                new PropertyValueFactory<MANAGER, String>("data"));
        //
        TableColumn Role_col = new TableColumn("Role");
        Role_col.setMinWidth(100);
        Role_col.setCellValueFactory(
                new PropertyValueFactory<MANAGER, String>("data1"));
        //
        TableColumn fname_col = new TableColumn("First Name");
        fname_col.setMinWidth(100);
        fname_col.setCellValueFactory(
                new PropertyValueFactory<MANAGER, String>("data2"));
        //
        TableColumn age_col = new TableColumn("Age");
        age_col.setMinWidth(100);
        age_col.setCellValueFactory(
                new PropertyValueFactory<MANAGER, String>("data3"));
        //
        TableColumn gender_col = new TableColumn("Gender");
        gender_col.setMinWidth(100);
        gender_col.setCellValueFactory(
                new PropertyValueFactory<MANAGER, String>("data4"));
        //
        TableColumn phoneNum_col = new TableColumn("Phone Number");
        phoneNum_col.setMinWidth(100);
        phoneNum_col.setCellValueFactory(
                new PropertyValueFactory<MANAGER, String>("data5"));
        //
        table.getColumns().addAll(ID_col,Role_col,fname_col, age_col, gender_col,
                phoneNum_col);
        //
        
              
        TextField add_fName = new TextField();
        add_fName.setMinWidth(200);
        add_fName.setPromptText("First Name");
        add_fName.setLayoutX(200);
        add_fName.setLayoutY(420);
        add_fName.setVisible(false);
        //
        TextField add_age= new TextField();
        add_age.setPromptText("Age");
        add_age.setMinWidth(200);
        add_age.setLayoutX(200);
        add_age.setLayoutY(460);
        add_age.setVisible(false);
        //
        TextField add_gender = new TextField();
        add_gender.setMinWidth(200);
        add_gender.setPromptText("Gender");
        add_gender.setLayoutX(500);
        add_gender.setLayoutY(420);
        add_gender.setVisible(false);                                   
        //
        TextField add_phonenumber = new TextField();
        add_phonenumber.setMinWidth(200);
        add_phonenumber.setPromptText("Phone Number");                
        add_phonenumber.setLayoutX(500);
        add_phonenumber.setLayoutY(460);
        add_phonenumber.setVisible(false);
        //
        TextField ID = new TextField();
        add_fName.setMinWidth(200);
        ID.setPromptText("ID");
        ID.setLayoutX(400);
        ID.setLayoutY(430);
        ID.setVisible(false);
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
        id.setDisable(true);
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
        TextField age= new TextField();
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
        //
        add_Button.setOnAction((ActionEvent e) -> 
        {
            ID.setVisible(false);
            
            ID_2.setVisible(false);
            id.setVisible(false);
            role.setVisible(false);
            fName.setVisible(false);
            age.setVisible(false);
            gender.setVisible(false);                                   
            phonenumber.setVisible(false);
            
            id.clear();
            role.clear();
            fName.clear();
            age.clear();
            gender.clear();                 
            phonenumber.clear();
            
            ID_2.clear();
            ID.clear();
            if(add_fName.isVisible()==false)
            {                     
                add_fName.setVisible(true);
                add_age.setVisible(true);
                add_gender.setVisible(true);                                   
                add_phonenumber.setVisible(true);
            }
            if( add_fName.getText().isEmpty()||add_age.getText().isEmpty()||add_gender.getText().isEmpty()||add_phonenumber.getText().isEmpty())
            {
               System.out.print("cant opertate");
            }
             else
            {
                manager.admin.add_Admin( add_fName.getText(),add_age.getText(),add_gender.getText(),
                        add_phonenumber.getText());
               
                    data.add(new MANAGER( new ADMIN (add_fName.getText(),add_age.getText(),add_gender.getText(),add_phonenumber.getText())));

                    //update the data
                    center_Admin_Pane();
            }    

        });
            delete_Button.setOnAction((ActionEvent e) -> 
            {   
                add_fName.clear();
                add_age.clear();
                add_gender.clear();
                add_phonenumber.clear();
                ID_2.clear();
                
                add_fName.setVisible(false);
                add_age.setVisible(false);
                add_gender.setVisible(false);                                   
                add_phonenumber.setVisible(false);
                
                ID_2.setVisible(false);
                id.setVisible(false);
                role.setVisible(false);
                fName.setVisible(false);
                age.setVisible(false);
                gender.setVisible(false);                                   
                phonenumber.setVisible(false);
                
                id.clear();
                role.clear();
                fName.clear();
                age.clear();
                gender.clear();                 
                phonenumber.clear();
                
                if(ID.isVisible()==false)
                {
                    ID.setVisible(true);
                }
                if(ID.getText().isEmpty())
                {
                    System.out.print("invalid");
                }
                else
                {
                    //update the data
                    manager.admin.delete_Admin(ID.getText());
                    center_Admin_Pane();
                        ID.clear();
            }
        });
            
        search_Button.setOnAction((ActionEvent e) -> 
        {
            add_fName.clear();
            add_age.clear();
            add_gender.clear();
            add_phonenumber.clear();
            ID.clear();
            
            add_fName.setVisible(false);
            add_age.setVisible(false);
            add_gender.setVisible(false);                                   
            add_phonenumber.setVisible(false);
            
            ID.setVisible(false);
            
            if(id.isVisible()==false)
            {
                ID_2.setVisible(true);
                id.setVisible(true);
                role.setVisible(true);
                fName.setVisible(true);
                age.setVisible(true);
                gender.setVisible(true);                                   
                phonenumber.setVisible(true);
            }
            else
            {
                manager.admin.Search_admin(ID_2.getText());
                    id.setText(admin.adminID);
                    role.setText(admin.role);
                    fName.setText(admin.fName);
                    age.setText(admin.age);
                    gender.setText(admin.gender);                                   
                    phonenumber.setText(admin.phoneNum);
            }
        });                
        
        PRINT.setOnAction((ActionEvent e) -> 
        {
            print(table);
        });  
        center_Admin_Pane.getChildren().addAll(table,PRINT,ID_2,add_Button,search_Button,add_fName,add_age,add_gender,add_phonenumber,ID,delete_Button,role,id,fName,age,gender,phonenumber);
        root.setCenter(center_Admin_Pane);
    }
    public void center_Customer_Pane()  
    {     
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
        for(int i =0;i<customer.Data.size();i++)
        {
           data.add(new CUSTOMER(customer.Data.get(i),customer.Data.get(i+1),customer.Data.get(i+2), customer.Data.get(i+4),customer.Data.get(i+5)));
           i+=5;
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
        table.getColumns().addAll(role_col,ID_col,username_col, email_col, phone_col);
        //
        center_Customer__Pane.getChildren().addAll(table);
        //

        root.setCenter(center_Customer__Pane);
    }
    public void center_BUS_Pane() 
    {     
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

//        bus.Read_data_from_file();
            
        for(int i =0;i<bus.Bus_Data.size();i++)
        {
           data.add(new BUS(bus.Bus_Data.get(i) ,bus.Bus_Data.get(i+1),bus.Bus_Data.get(i+2), bus.Bus_Data.get(i+3),bus.Bus_Data.get(i+4),
           bus.Bus_Data.get(i+5),bus.Bus_Data.get(i+6),bus.Bus_Data.get(i+7), bus.Bus_Data.get(i+8),bus.Bus_Data.get(i+9),
           bus.Bus_Data.get(i+10),bus.Bus_Data.get(i+11)));
           i+=11;
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
      table.getColumns().addAll(Bus_ID_col,Seats_col,stop_1_col,time_1_col,stop_2_col,time_2_col
              ,stop_3_col, time_3_col,stop_4_col,time_4_col,start_point_col,ending_point_col);
        //
        center_BUS_Pane.getChildren().add(table);
        
        root.setCenter(center_BUS_Pane);
    }
    public void center_Permission_Pane() 
    {
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

        for(int i =0;i<permission.Permission_Data.size();i++)
        {
            data.add(new PERMISSION(permission.Permission_Data.get(i),permission.Permission_Data.get(i+1)));
            i+=1;
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
        table.getColumns().addAll(admin_ID_col,permission_col);
        //     
        Button add_Button = new Button("SAVE");
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
        replay.getItems().addAll("True","False");
        replay.setMinWidth(200);
        replay.setPromptText("Replay");
        replay.setLayoutX(600);
        replay.setLayoutY(200);
        //
        add_Button.setOnAction((ActionEvent e) -> 
        {
            if(ID.getText().isEmpty())
            {
               System.out.print("cant opertate");
            }
             else
            {
                permission.Reply_Permission(ID.getText(),replay.getSelectionModel().getSelectedItem().toString());
                
                    data.add(new PERMISSION(ID.getText(),replay.getSelectionModel().getSelectedItem().toString()));
                    //update the data
                    center_Permission_Pane();
            }    
          ID.clear();
        });
        center_Permission_Pane.getChildren().addAll(table,ID,replay,add_Button);
        root.setCenter(center_Permission_Pane);
    }
    private void print(Node node)
    {
        PrinterJob PRINT;
        PRINT =  PrinterJob.createPrinterJob();
        
        if(PRINT != null)
        {
            boolean printed = PRINT.printPage(node);
            
            if(printed)
            {
                PRINT.endJob();
            }
        }
        else
        {
            System.out.print("not printed");
        }
    }
    public Scene get_manager_pane()
    {
        return scene;
    }
    public void catch_main_stage(Stage scn)
    {		 
        //copy = scn;
    }
}
