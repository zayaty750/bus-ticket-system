
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Zeyad
 */
public class CASH extends PAYMENT
{
    int amount;
    
     public String generateID() 
    {
    	Read_data_from_file();
    	//Condition.
        boolean found = false;
        //Generate random ID.
        Random rand = new Random();
        int num = rand.nextInt(5000,10000);
        //convert int to string
        return Integer.toString(num);
    }
}
