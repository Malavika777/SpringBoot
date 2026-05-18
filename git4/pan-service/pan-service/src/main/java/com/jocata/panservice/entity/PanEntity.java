package com.jocata.panservice.entity;

import java.util.Date;

public class PanEntity {

    private int Id;
    private String panNumber;
    private String firstName;
    private String lastName;
    private Date Dob;
    private Boolean status;


    public int getId(){
        return Id;
    }
    public void setId(int Id){
        this.Id=Id;
    }
    public String getPanNumber(){
        return panNumber;
    }
    public void setPanNumber(String panNumber){
        this.panNumber=panNumber;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }
    public Date getDob(){
        return Dob;
    }
    public void setDob(Date dob){
        Dob=dob;
    }
    public Boolean getStatus(){
        return status;
    }
    public void setStatus(Boolean status){
        this.status=status;
    }
}
