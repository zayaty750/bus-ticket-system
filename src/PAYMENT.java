
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Zeyad
 */
public abstract class  PAYMENT  
{
    ArrayList<String> payment_Data = new ArrayList<>();
    FILE_Handler payment_file = new FILE_Handler();
    int income,total;
    
    PAYMENT()
    {
        
    }
    String total_amount()
    {      
        int Counter = 0;

        Read_data_from_file();

        for (int i = 0; i < payment_Data.size(); i++) {
            if (i % 5 == 0) {
                Counter+=200;
            }
        }
        return Integer.toString(Counter);
    
    }
        public void Read_data_from_file()   {
        //taking the data from file to array list
        payment_Data.clear();
        //if file not found
        payment_Data = payment_file.Read("payment_visa.txt");
    }
}
