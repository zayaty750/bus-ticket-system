
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
public class BUS implements Serializable {

    TRIP trip;
    TERMINAL terminal;
    SimpleStringProperty data, data1, data2, data3, data4, data5, data6, data7, data8, data9, data10, data11;
    ArrayList<String> Bus_Data = new ArrayList<>();
    //variables
    String bus_id, Seats,stop,stop2,stop3,stop4,start,end;
    private int Counter = 0;
    //files
    FILE_Handler Bus_file = new FILE_Handler();

    BUS() {

    }

    BUS(String bus_id, String Seats) {
        this.bus_id = bus_id;
        this.Seats = Seats;
    }
    //to store data in table view

    BUS(String data, String data1, String data2, String data3, String data4, String data5,
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

    BUS(TRIP trip, TERMINAL terminal) {
        this.trip = trip;
        this.terminal = terminal;
    }

    public void add_bus(String bus_id, String Seats) {
        Read_data_from_file();

        boolean found = false;
        for (int i = 0; i < Bus_Data.size(); i++) {
            if (bus_id.equals(Bus_Data.get(i))) {

                found = true;
                break;
            }

        }
        System.out.print(found + "  ");
        System.out.print(Bus_Data);
        if (!found) {
            Bus_file.Write("businfo.txt", bus_id + " ");
            Bus_file.Write("businfo.txt", Seats + " ");
            Bus_file.Write("businfo.txt", trip.getStop1() + " ");
            Bus_file.Write("businfo.txt", trip.getTime1() + " ");
            Bus_file.Write("businfo.txt", trip.getStop2() + " ");
            Bus_file.Write("businfo.txt", trip.getTime2() + " ");
            Bus_file.Write("businfo.txt", trip.getStop3() + " ");
            Bus_file.Write("businfo.txt", trip.getTime3() + " ");
            Bus_file.Write("businfo.txt", trip.getStop4() + " ");
            Bus_file.Write("businfo.txt", trip.getTime4() + " ");
            Bus_file.Write("businfo.txt", terminal.getStarting_Point() + " ");
            Bus_file.Write("businfo.txt", terminal.getEnding_Point() + "\n");
        } else {
            // throw invalid;
        }
    }

    public void search_bus(String bus_id_admin) {
        //data is saved in array list
        Read_data_from_file();
        for (int i = 0; i < Bus_Data.size(); i++) {
            if (Bus_Data.get(i).equals(bus_id_admin)) {
                bus_id = Bus_Data.get(i);                
                stop = Bus_Data.get(i + 2);
                stop2 = Bus_Data.get(i + 4);
                stop3 = Bus_Data.get(i + 6);
                stop4 = Bus_Data.get(i + 8);
                start = Bus_Data.get(i + 10);
                end = Bus_Data.get(i + 11);
                break;
            }
        }
    }

    public void delete_bus(String bus_number_user) {
        //data is saved in array list
        Read_data_from_file();

        boolean found = false;
        for (int i = 0; i < Bus_Data.size(); i++) {
            if (bus_number_user.equals(Bus_Data.get(i))) {
                int count = 0;
                while (count != 12) {
                    Bus_Data.remove(i);
                    count++;
                }
                found = true;
            }
        }
        Bus_file.Delete_file("businfo.txt");
        if (found) {
            for (int i = 0; i < Bus_Data.size(); i++) {
                //rewriting data to file
                if (i % 12 == 0) {
                    Bus_file.Write("businfo.txt", "\n");
                    Bus_file.Write("businfo.txt", Bus_Data.get(i) + " ");
                } else {
                    Bus_file.Write("businfo.txt", Bus_Data.get(i) + " ");
                }
            }
        }
    }

    public String bus_counter() {
        Counter = 0;
        Read_data_from_file();
        for (int i = 0; i < Bus_Data.size(); i++) {
            if (i % 12 == 0) {
                Counter++;
            }
        }
        return Integer.toString(Counter);
    }

    public void Read_data_from_file() {
        //taking the data from file to array list
        Bus_Data.clear();
        //if file not found
        Bus_Data = Bus_file.Read("businfo.txt");

    }
}
