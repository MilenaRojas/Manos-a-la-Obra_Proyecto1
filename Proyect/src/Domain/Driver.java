package Domain;

import java.io.Serializable;

public class Driver extends Employee implements Serializable {
    //atributes

    private String licenseType;
    private int dayTimHours;
    private int nigthHours;
    private int timeWorked;
    private boolean qualified;
    
    //Constructor
    public Driver(String licenseType_, int dayTimHours_, int nigthHours_, int timeWorked_, boolean qualified_, String name_, String lastName_, int identification_) {
        super(name_, lastName_, identification_);
        this.licenseType = licenseType_;
        this.dayTimHours = dayTimHours_;
        this.nigthHours = nigthHours_;
        this.timeWorked = timeWorked_;
        this.qualified = qualified_;
    }


    public Driver() {
        super();
        this.licenseType = "";
        this.dayTimHours = 0;
        this.nigthHours = 0;
        this.timeWorked = 0;
        this.qualified = false;
    }

    //get's and set's
    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType_) {
        this.licenseType = licenseType_;
    }

    public int getDayTimHours() {
        return dayTimHours;
    }

    public void setDayTimHours(int dayTimHours_) {
        this.dayTimHours = dayTimHours_;
    }

    public int getNigthHours() {
        return nigthHours;
    }

    public void setNigthHours(int nigthHours_) {
        this.nigthHours = nigthHours_;
    }

    public int getTimeWorked() {
        return timeWorked;
    }

    public void setTimeWorked(int timeWorked_) {
        this.timeWorked = timeWorked_;
    }

    public boolean getQualified() {
        return qualified;
    }

    public void setQualified(boolean qualified_) {
        this.qualified = qualified_;
    }

//    String id="00";
//   // assigment ID of the emplyoee
//     public String employeeNomber(){
//       
//        int randomNumber=0;
//        
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 2; j++) {
//            randomNumber=(int)(Math.random()*10);
//            id= id + randomNumber;
//            }
//        }
//      return id;
//    } 
    @Override
    public String toString() {
        return "Driver{" + "licenseType=" + licenseType + ", dayTimHours=" + dayTimHours + ", nigthHours=" + nigthHours + ", timeWorked=" + timeWorked + ", qualified=" + qualified + super.toString() + '}';
    }

    public int size() {
        return getLicenseType().length() * 2
                + 4 + 4 + 4 + 1 + getName().length() * 2 + getLastName().length() * 2 + 4;
    }

}//end class
