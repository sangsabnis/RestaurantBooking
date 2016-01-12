/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Sangram
 */
public class Reservation {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String dateTime;
    private String partySize;
    private int tableNumber;
    
    public int getID(){
        return id;
    }
    public void setID(int id){
        this.id = id;
    }
    
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    
    public String getDateTime(){
        return dateTime;
    }
    public void setDateTime(String dateTime){
        this.dateTime = dateTime;
    }
    
    public String getPartySize(){
        return partySize;
    }
    public void setPartySize(String partySize){
        this.partySize = partySize;
    }
    
    public int getTableNumber(){
        return tableNumber;
    }
    public void setTableNumber(int tableNumber){
        this.tableNumber = tableNumber;
    }
    
}
