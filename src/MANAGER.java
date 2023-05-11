
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import javafx.beans.property.SimpleStringProperty;

public class MANAGER extends USER implements Serializable {
    //Variables.

    ADMIN admin;
    SimpleStringProperty data, data1, data2, data3, data4, data5;
    String man_role, mang_id, man_fame, man_age, man_gender, man_phonenum;
    ArrayList<String> Manager_Data = new ArrayList<>();
    FILE_Handler admin_regestration_file = new FILE_Handler();

    MANAGER(ADMIN admin) {
        this.admin = admin;
    }

    MANAGER(String data, String data1, String data2, String data3, String data4, String data5) {
        this.data = new SimpleStringProperty(data);
        this.data1 = new SimpleStringProperty(data1);
        this.data2 = new SimpleStringProperty(data2);
        this.data3 = new SimpleStringProperty(data3);
        this.data4 = new SimpleStringProperty(data4);
        this.data5 = new SimpleStringProperty(data5);
    }

    public String getData() {
        return data.get();
    }

    public String getData1() {
        return data1.get();
    }

    public String getData2() {
        return data2.get();
    }

    public String getData3() {
        return data3.get();
    }

    public String getData4() {
        return data4.get();
    }

    public String getData5() {
        return data5.get();
    }

    public void set_data() {
        Read_data_from_file();
        this.mang_id = Manager_Data.get(0);
        this.man_role = Manager_Data.get(1);
        this.man_fame = Manager_Data.get(2);
        this.man_age = Manager_Data.get(3);
        this.man_gender = Manager_Data.get(4);
        this.man_phonenum = Manager_Data.get(5);
    }

    public void edit_man_data(String man_fame, String man_age, String man_gender, String man_phonenum) {
        //remove all alternative data
        Read_data_from_file();
        for (int i = 2; i < 6; i++) {
            Manager_Data.remove(2);
        }
        Manager_Data.add(2, man_fame);
        Manager_Data.add(3, man_age);
        Manager_Data.add(4, man_gender);
        Manager_Data.add(5, man_phonenum);

        admin_regestration_file.Delete_file("admin_regestration.txt");
        System.out.print(Manager_Data);

        for (int i = 0; i < Manager_Data.size(); i++) {
            if (i % 6 == 0) {
                admin_regestration_file.Write("admin_regestration.txt","\n"); 
                admin_regestration_file.Write("admin_regestration.txt",Manager_Data.get(i)+" ");
            } else {
                admin_regestration_file.Write("admin_regestration.txt",Manager_Data.get(i)+" ");
            }
        }
    }

    public String Staff_counter() {
        int Counter = 0;
        Read_data_from_file();

        for (int i = 0; i < Manager_Data.size(); i++) {
            if (i % 7 == 0) {
                Counter++;
            }
        }
        return Integer.toString(Counter);
    }
    //Send data to file Function.

    public void Read_data_from_file() {
        //taking the data from file to array list 
        Manager_Data.clear();
        Manager_Data = admin_regestration_file.Read("admin_regestration.txt");

    }
}
