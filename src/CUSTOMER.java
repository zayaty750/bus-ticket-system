import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;


public class CUSTOMER extends USER implements Serializable
{
   
    //Booking book;
    BOOKING book;
    SimpleStringProperty data,data1,data2,data3,data4;
    String cust_id,username,firstname,lastname,password,email,phone,Role = "CUST";;
    ArrayList<Integer> ID = new ArrayList<>();
    ArrayList<String> Data = new ArrayList<>(); 
    FILE_Handler Customer_file = new FILE_Handler();
    CUSTOMER()
    {
        
    }
    CUSTOMER(BOOKING book)
    {
        this.book = book;
    }
    CUSTOMER(String Role,String cust_id,String username,String email,String phone)
    {
            this.data = new SimpleStringProperty(Role);
            this.data1  = new SimpleStringProperty(cust_id);
            this.data2 = new SimpleStringProperty(username);
            this.data3 = new SimpleStringProperty(email);
            this.data4 = new SimpleStringProperty(phone);    
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

    
    //registration function for both admin and customer
    public void registration(String firstname,String lastname,String password,String email,String phone)   
    {
    	Read_data_from_file();
    	//to compare with one in the file
    	boolean repeat = false;
    	this.username = firstname + lastname;
        for(int i =0 ;i<Data.size();i++)
    	{
            if(Data.get(i).equals(username))
            {
   		//same username used twice;
   		repeat = true;
   		//ytla3 ba3d lama la2a l 3aizo msh 3aiz l data l ba3daha
                break;
            }
        }
   	if(repeat == false)
   	{
            //sending data to file
            this.cust_id = generateID();
            this.password  = password;
            this.email     = email;
            this.phone     = phone;
            Customer_file.Write("regestration.txt",Role + "  " );
	    Customer_file.Write("regestration.txt",this.cust_id + "  " );
	    Customer_file.Write("regestration.txt",this.username+ "  " );
	    Customer_file.Write("regestration.txt",this.password+ " ");
	    Customer_file.Write("regestration.txt",this.email + " ");
	    Customer_file.Write("regestration.txt",this.phone + " ");
	    Customer_file.Write("regestration.txt","\n");
   	}	

    }
    
    public String generateID() 
    {
    	Read_data_from_file();
    	//Condition.
        boolean found = false;
        //Generate random ID.
        Random rand = new Random();
        int num = rand.nextInt(5000,10000);

        for(int i= 0;i<Data.size();i++)
        {
            if(Data.get(i).equals(String.valueOf(num)))
            {
                //Same username used twice.
                found = true;
                break;
            }
        }
        if(found == false)
        {
            ID.add(num);
        }
        else
        {
            generateID();
        }
        //convert int to string
        return Integer.toString(num);
    }
    
    
    public void set_data(String customer_id) {
        Read_data_from_file();
        Search_admin(customer_id);
    }
    

    public void Search_admin(String customer_id) {
        Read_data_from_file();
        boolean found = false;

        for (int i = 0; i < Data.size(); i++) {
            if (customer_id.equals(Data.get(i+1)))
            {    
                this.cust_id = Data.get(i+1);
                this.username = Data.get(i + 2);
                this.email = Data.get(i + 4);
                this.phone = Data.get(i + 5);
                found = true;
                break;
            }
        }
        if (found == false) {
            this.cust_id = "-Not Found-";
            this.username = "-Not Found-";
            this.email = "-Not Found-";
            this.phone = "-Not Found-";
        }
    }

    String Customer_counter() 
    {
                int Counter=0;

                    Read_data_from_file();
                
                for(int i= 0;i<Data.size();i++)
                {
                    if(i%8 == 0)
                    {
                        Counter++;
                    }
                }
                return Integer.toString(Counter);
    }
    //Send data to file Function.
    public void Read_data_from_file()  
    {
   	 	//taking the data from file to array list
                Data.clear();
  	 	Data = Customer_file.Read("regestration.txt");
    }
 }


