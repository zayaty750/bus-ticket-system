/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Zeyad
 */
public class VISA extends PAYMENT
{
     int amount;
     String  id ,code , expiry_date , bank_name;
     
     void take_data(String id,String code,String expiry_date,String bank_name,int amount)
     {
         this.id = id;
         this.code = code ;
         this.expiry_date = expiry_date;
         this.bank_name = bank_name;
         this.amount = amount;
         
         payment_file.Write("payment_visa", this.id);
         payment_file.Write("payment_visa", this.code );
         payment_file.Write("payment_visa", this.expiry_date);
         payment_file.Write("payment_visa", this.bank_name);
         payment_file.Write("payment_visa", Integer.toString(this.amount));
     }
     
     
}
