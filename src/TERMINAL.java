
import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Zeyad
 */
public class TERMINAL implements Serializable
{
    String Starting_Point,Ending_Point;
    
    void Add_Terminal(String Starting_Point,String Ending_Point) 
    {
            this.Starting_Point  = Starting_Point;
            this.Ending_Point  = Ending_Point;
    }

    public String getStarting_Point() 
    {
        return Starting_Point;
    }

    public String getEnding_Point() 
    {
        return Ending_Point;
    }
        
}
