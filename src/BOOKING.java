
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Zeyad
 */
public class BOOKING implements Serializable {

    BUS bus;
    SimpleStringProperty data, data1, data2, data3, data4, data5, data6, data7, data8, data9, data10, data11;
    ArrayList<String> booking_Data = new ArrayList<>();
    ArrayList<String> seat_number = new ArrayList<>();
   
    //variables
    String bus_id, Seats,id;
    private int Counter = 0;
    //files
    FILE_Handler booking_file = new FILE_Handler();

    BOOKING(BUS bus) {
        this.bus = bus;
    }
    //to store data in table view

    BOOKING(String data, String data1, String data2, String data3, String data4, String data5,
            String data6, String data7, String data8, String data9, String data10, String data11) {
        this.data = new SimpleStringProperty(data);
        this.data1 = new SimpleStringProperty(data1);
        this.data2 = new SimpleStringProperty(data2);
        this.data3 = new SimpleStringProperty(data3);
        this.data4 = new SimpleStringProperty(data4);
        this.data5 = new SimpleStringProperty(data5);
        this.data6 = new SimpleStringProperty(data6);
        this.data7 = new SimpleStringProperty(data7);
        this.data8 = new SimpleStringProperty(data8);
        this.data9 = new SimpleStringProperty(data9);
        this.data10 = new SimpleStringProperty(data10);
        this.data11 = new SimpleStringProperty(data11);
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

    public String getData6() {
        return data6.get();
    }

    public String getData7() {
        return data7.get();
    }

    public String getData8() {
        return data8.get();
    }

    public String getData9() {
        return data9.get();
    }

    public String getData10() {
        return data10.get();
    }

    public String getData11() {
        return data11.get();
    }

    public void book_seat(String bus_id, String Seat, String admin_id)  
    {
        bus.Read_data_from_file();

        boolean found = false;
        for (int i = 0; i < bus.Bus_Data.size(); i++) {
            if (bus_id.equals(bus.Bus_Data.get(i))) {
                found = true;
                break;
            }

        }

        if (found) {
            this.bus_id = bus_id;
            this.Seats = Seat;

            booking_file.Write("booking.txt", this.bus_id + " ");
            booking_file.Write("booking.txt", this.Seats + " ");
            booking_file.Write("booking.txt", admin_id + "\n");
        } else {

        }
    }
    
    public boolean book_avaliable(String id_from_user)
    {
        Read_data_from_file();
        
        boolean booked = false;
        if(booking_Data.isEmpty()==false)
        {
        //getting the number of seats depending on bus id
        for (int i = 0; i < booking_Data.size(); i++) {
            //userid busid seatnumber 
            if (id_from_user.equals(booking_Data.get(i+2)))
             {    
                booked = true;
                break;
            }
        }
        }
        return booked;
    }
    
    public boolean view_seats(String bus_number,String seat)   
    {
        
    //data is saved in array list
        Read_data_from_file();

        boolean found = false;
        
        //getting the number of seats depending on bus id
        for (int i = 0; i < booking_Data.size(); i++) {
            //userid busid seatnumber 
            if (bus_number.equals(booking_Data.get(i))
                    && seat.equals(booking_Data.get(i+1)))
             {    
                found = true;
                break;
            }
        }

        return found;
    }

    public String book_count()   {
        Counter = 0;

        Read_data_from_file();

        for (int i = 0; i < booking_Data.size(); i++) {
            if (i % 3 == 0) {
                Counter++;
            }
        }
        return Integer.toString(Counter);
    }
    
    public boolean view(String user)
    {
        Read_data_from_file();
        boolean condition= false;
        if(booking_Data.isEmpty() == false)
        {
            for(int i =0 ;i<booking_Data.size();i++)
            {
                if(user.equals(booking_Data.get(i+2)))
                {
                    this.bus_id = booking_Data.get(i) ;
                    this.Seats = booking_Data.get(i+1);
                    this.id = booking_Data.get(i+2);
                    condition = true;
                    break;
                }
            }
        }
        return condition;
    }
    public void Read_data_from_file()   {
        //taking the data from file to array list
        booking_Data.clear();
        //if file not found
        booking_Data = booking_file.Read("booking.txt");
    }
}
