package Domain;

import java.io.Serializable;

public class Administrative extends Employee implements Serializable{

    //Atributos
    private int categoryType;
    private int timeWorked;
    

    //constructors
    public Administrative() {
        this.categoryType = 0;
        this.timeWorked = 0;
       
    }

    public Administrative(int categoryType, int timeWorked, boolean qualified) {
        this.categoryType = categoryType;
        this.timeWorked = timeWorked;
        
    }

    public Administrative(int categoryType, int timeWorked,  String name, String lastName, int identification) {
        super(name, lastName, identification);
        this.categoryType = categoryType;
        this.timeWorked = timeWorked;
       
    }

  

    //get´s and set´s
    public int getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(int categoryType) {
        this.categoryType = categoryType;
    }

    public int getTimeWorked() {
        return timeWorked;
    }

    public void setTimeWorked(int timeWorked) {
        this.timeWorked = timeWorked;
    }

    

    String id = "22";
    //return  te ID of the administrative

    public String assigmenteID() {
        int randomNumber = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                randomNumber = (int) (Math.random() * 10);
                id = id + randomNumber;
            }
        }
        return id;
    }

    @Override
    public String toString() {
        return "Administrative{" + "categoryType=" + categoryType + ", timeWorked=" + timeWorked + ", id=" + id + '}';
    }

    
}//end class
