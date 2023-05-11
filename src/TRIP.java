
import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Zeyad
 */

public class TRIP implements Serializable
{
        BUS bus;
	String stop1,time1,stop2,time2,stop3,time3,stop4,time4;
	
	void Add_trip(String stop1,String time1,String stop2,String time2,String stop3,String time3,String stop4,String time4)
	{
            this.stop1  = stop1;
            this.time1  = time1;
	    
            this.stop2  = stop2;
            this.time2  = time2;
	    
            this.stop3  = stop3;
	    this.time3  = time3;
            
            this.stop4  = stop4;
	    this.time4  = time4;
	}	

    public String getStop1() {
        return stop1;
    }

    public String getTime1() {
        return time1;
    }

    public String getStop2() {
        return stop2;
    }

    public String getTime2() {
        return time2;
    }

    public String getStop3() {
        return stop3;
    }

    public String getTime3() {
        return time3;
    }

    public String getStop4() {
        return stop4;
    }

    public String getTime4() {
        return time4;
    }
        
}

