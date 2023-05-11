
import java.io.Serializable;
import java.util.ArrayList;

public class USER implements Serializable {

    ArrayList<String> Data_adm = new ArrayList<>();
    ArrayList<String> Data_cust = new ArrayList<>();
    String username, id, password;
    FILE_Handler registration_file = new FILE_Handler();
    FILE_Handler admin_regestration_file = new FILE_Handler();

    public boolean login(String id, String username, String password, String Role)   {
        Read_data_from_file(Role);
        
        boolean Access = false;
        if (Role.equals("CUST")) {
            for (int i = 0; i < Data_cust.size(); i++) {
                
                if (Data_cust.get(i + 2).equals(username) && Data_cust.get(i + 3).equals(password)) {
                    Access = true;
                    break;  
                }
            }
        } 
        if(Role.equals("ADM")||Role.equals("MANG")){
            
            for (int i = 0; i < Data_adm.size(); i++) {
                if (Data_adm.get(i).equals(id)&&password.equals("0000")) 
                {
                    Access = true;
                    
                    break;
                }
            }
        }
        
        return Access;
    }

    public String getUsername() {
        return username;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void Read_data_from_file(String Role)  {
        //taking the data from file to array list 
        if (Role.equals("ADM") || Role.equals("MANG")) {
            Data_adm = admin_regestration_file.Read("admin_regestration.txt");
        } else {
            Data_cust = registration_file.Read("regestration.txt");
        }
    }
}
