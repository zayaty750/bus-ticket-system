
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import javafx.beans.property.SimpleStringProperty;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Zeyad
 */
public class ADMIN extends USER implements Serializable {

    BUS bus;
    SimpleStringProperty data, data1, data2, data3, data4, data5;
    String Role = "ADM", adminID, fName, age, gender, phoneNum, role;
    ArrayList<String> Admin_Data = new ArrayList<>();
    FILE_Handler admin_file = new FILE_Handler();
    private ArrayList<Integer> ID = new ArrayList<>();
    ADMIN()
    {
        
    }
    ADMIN(BUS bus) {
        this.bus = bus;
    }

    public void set_data(String admin_id) {
        Read_data_from_file();
        Search_admin(admin_id);
    }
    

    ADMIN(String data2, String data3, String data4, String data5) {
        this.data = new SimpleStringProperty(adminID);
        this.data1 = new SimpleStringProperty(Role);
        this.data2 = new SimpleStringProperty(data2);
        this.data3 = new SimpleStringProperty(data3);
        this.data4 = new SimpleStringProperty(data4);
        this.data5 = new SimpleStringProperty(data5);
    }

    public void add_Admin(String fName, String age, String gender, String phoneNum) {
        this.adminID = generateID();
        this.fName = fName;
        this.age = age;
        this.gender = gender;
        this.phoneNum = phoneNum;

        admin_file.Write("admin_regestration.txt", this.adminID + " ");
        admin_file.Write("admin_regestration.txt", this.Role + " ");
        admin_file.Write("admin_regestration.txt", this.fName + " ");
        admin_file.Write("admin_regestration.txt", this.age + " ");
        admin_file.Write("admin_regestration.txt", this.gender + " ");
        admin_file.Write("admin_regestration.txt", this.phoneNum + " ");
        admin_file.Write("admin_regestration.txt", "\n");
    }

    public void Search_admin(String adminID) {
        Read_data_from_file();
        boolean found = false;

        for (int i = 0; i < Admin_Data.size(); i++) {
            if (adminID.equals(Admin_Data.get(i))) {
                this.adminID = Admin_Data.get(i);
                this.role = Admin_Data.get(i + 1);
                this.fName = Admin_Data.get(i + 2);
                this.age = Admin_Data.get(i + 3);
                this.gender = Admin_Data.get(i + 4);
                this.phoneNum = Admin_Data.get(i + 5);
                found = true;
                break;
            }
        }
        if (found == false) {
            this.adminID = "-Not Found-";
            this.role = "-Not Found-";
            this.fName = "-Not Found-";
            this.age = "-Not Found-";
            this.gender = "-Not Found-";
            this.phoneNum = "-Not Found-";
        }
    }

    //Delete admin function.
    public void delete_Admin(String id_from_user) {

        Read_data_from_file();

        if (id_from_user.equals(Admin_Data.get(0))) {
            System.out.print("illegle");
        } else {
            for (int i = 0; i < Admin_Data.size(); i++) {
                if (id_from_user.equals(Admin_Data.get(i))) {
                    //remove all alternative data
                    Admin_Data.remove(i);
                    Admin_Data.remove(i);
                    Admin_Data.remove(i);
                    Admin_Data.remove(i);
                    Admin_Data.remove(i);
                    Admin_Data.remove(i);
                }
            }

            admin_file.Delete_file("admin_regestration.txt");

            for (int i = 0; i < Admin_Data.size(); i++) {
                //rewriting data to file
                if (i % 6 == 0) {
                    admin_file.Write("admin_regestration.txt", "\n");
                    admin_file.Write("admin_regestration.txt", Admin_Data.get(i) + " ");
                } else {
                    admin_file.Write("admin_regestration.txt", Admin_Data.get(i) + " ");
                }
            }
        }
    }
    //Generate Function.

    public String generateID() {
        //Condition.
        boolean found = false;
        //Generate random ID.
        Random rand = new Random();
        int num = rand.nextInt(5000);

        for (int i = 0; i < Admin_Data.size(); i++) {
            if (Admin_Data.get(i).equals(String.valueOf(num))) {
                //Same username used twice.
                found = true;
                break;
            }
        }
        if (found == false) {
            ID.add(num);
        } else {
            generateID();
        }
        //convert int to string
        return Integer.toString(num);
    }

    public void Read_data_from_file() {
        //taking the data from file to array list 
        Admin_Data.clear();
        Admin_Data = admin_file.Read("admin_regestration.txt");
    }
}
