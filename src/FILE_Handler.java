
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class FILE_Handler implements Serializable {

    ArrayList<String> Data = new ArrayList<>();

    public void Write(String file_name, String Data) {

        java.io.File Write_file = new java.io.File(file_name);
        try {
            java.io.PrintWriter Write = new java.io.PrintWriter(new FileWriter(Write_file, true));
            Write.print(Data);
            Write.close();
        } catch (IOException x) {
            x.printStackTrace();
        }
    }

    public ArrayList<String> Read(String file_name) {
        java.io.File Read_file = new java.io.File(file_name);
        try {
            Scanner read = new Scanner(Read_file);
            while (read.hasNext()) {
                String value = read.next();
                Data.add(value);
            }
            read.close();
        } catch (FileNotFoundException x) {
            x.printStackTrace();
        }
        return Data;
    }

    public void Delete_file(String file_name) {
        java.io.File Delete_file = new java.io.File(file_name);
        Delete_file.delete();
    }

   
}

/*ArrayList<String> Data = new ArrayList<>();
	
 	public void Write(String file_name,String Data)
	{
 		java.io.File Write_file = new java.io.File(file_name);
		try 
		{
			java.io.PrintWriter Write = new java.io.PrintWriter(new FileWriter(Write_file, true));
			Write.print(Data);
			Write.close();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	public ArrayList<String> Read(String file_name) throws FileNotFoundException
	{
		java.io.File Read_file = new java.io.File(file_name); 
		Scanner read = new Scanner(Read_file);
		
			while(read.hasNext())
			{
				String value = read.next();
				Data.add(value);
			}
		read.close();
		return Data;
	}
	public void Delete_file(String file_name)
	{
		java.io.File Delete_file = new java.io.File(file_name); 
		Delete_file.delete();
	}
 */
 /*
  ArrayList<Object> DATA = new ArrayList<>();
    ArrayList<Object> copy = new ArrayList<>();
    
    public void Write_binary(String file_name, Object Data) throws FileNotFoundException, IOException {
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file_name, true));
        output.writeObject(Data);
        output.close();
    }

    public ArrayList Read_binary(String file_name) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(file_name));
        
        try
        {
            while(true)
            {
                test a = (test) input.readObject();
                copy.add(a);
                System.out.print(a);  
            
            }
        }
        catch(EOFException e)
        {
                e.getMessage();
        }
          input.close();  
        return copy;
    }

*/
