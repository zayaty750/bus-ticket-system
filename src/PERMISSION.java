
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
public class PERMISSION implements Serializable
{
	MANAGER manager;
	ADMIN admin;
        SimpleStringProperty data,data1;
	String permission = "false";
	ArrayList<String> Permission_Data = new ArrayList<>();
	FILE_Handler  Permission_file = new FILE_Handler();
    
    PERMISSION(String data, String data1)
    {
            this.data  = new SimpleStringProperty(data);
            this.data1 = new SimpleStringProperty(data1);
    }
    PERMISSION(MANAGER manager,ADMIN admin)
    {
	this.manager = manager;		
        this.admin = admin;
    }
    public void Send_Permission(String admin)   
    {
               Read_data_from_file();
               boolean cond =  false;
       for(int i=0 ;  i < Permission_Data.size()    ;   i++)
       {
            if(Permission_Data.get(i).equals(admin))
            {
                cond = true;
                break;
            }
       }
       if(cond == false)
       {
        Permission_file.Write("permission.txt", admin+" ");
        Permission_file.Write("permission.txt", permission+"\n ");
       }
    }
    public void Reply_Permission(String id,String permission) 
    {
       Read_data_from_file();
       for(int i=0 ;    i < Permission_Data.size()    ;   i++)
       {
            if(Permission_Data.get(i).equals(id))
            {
                Permission_Data.remove(i+1);
                Permission_Data.add(i+1,permission);
            }
       }
       
       Permission_file.Delete_file("permission.txt");
        
       for(int i=0 ;    i < Permission_Data.size()    ;   i++)
        {
              if(i%2 == 0)
              {
                Permission_file.Write( "permission.txt","\n");
                Permission_file.Write("permission.txt", Permission_Data.get(i)+" ");
              }else
              {
                  Permission_file.Write("permission.txt", Permission_Data.get(i)+" ");
              }
        }
    }
    public void View_Permission()  
    {
        Read_data_from_file();
    }
    public void Read_data_from_file()  
    {
   	//taking the data from file to array list 
    	Permission_Data.clear();
    	Permission_Data = Permission_file.Read("permission.txt");
    } 
    
    public String getData() 
    {
        return data.get();
    }
    public String getData1() 
    {
        return data1.get();
    }
}
