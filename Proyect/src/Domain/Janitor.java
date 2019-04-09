
package Domain;

import java.io.Serializable;

public class Janitor extends Employee implements Serializable{
     //atributes
    private String workFunction;
    private int timeWorked;
    private int extraHour;
    private boolean qualified;

    //constructors
    public Janitor() {
        super();
        this.workFunction = "";
        this.timeWorked = 0;
        this.extraHour=0;
        this.qualified=false;
        
    }

    public Janitor(String workFunction, int timeWorked, int extraHour, boolean qualified) {
        this.workFunction = workFunction;
        this.timeWorked = timeWorked;
        this.extraHour = extraHour;
        this.qualified = qualified;
    }

   

    public Janitor(String workFunction, int timeWorked, int extraHour, boolean qualified, String name, String lastName, int identification) {
        super(name, lastName, identification);
        this.workFunction = workFunction;
        this.timeWorked = timeWorked;
        this.extraHour = extraHour;
        this.qualified = qualified;
    }
    
   

  
    
    //get´s and set´s 

    public String getWorkFunction() {
        return workFunction;
    }

    public void setWorkFunction(String workFunction) {
        this.workFunction = workFunction;
    }

    public int getTimeWorked() {
        return timeWorked;
    }

    public void setTimeWorked(int timeWorked) {
        this.timeWorked = timeWorked;
    }
    
    public int getExtraHour() {
        return extraHour;
    }

    public void setExtraHour(int extraHour) {
        this.extraHour = extraHour;
    }
    
    public boolean getQualified() {
        return qualified;
    }

    public void setQualified(boolean qualified) {
        this.qualified = qualified;
    }
    
    String id="11";
   
     public String assigmentID(){
       
        int randomNumber=0;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
            randomNumber=(int)(Math.random()*10);
            id= id + randomNumber;
            }
        }
      return id;
    } 
 
    @Override
    public String toString() {
        return super.toString()+"\nWork Function:" + workFunction + "\nTime Worked:" + timeWorked + "\nEmployee Number:" + assigmentID()+ "\nExtra Hour:"+extraHour+"\nQualified:"+qualified+ "\nSalary:$"+ calculateSalary(id, this.extraHour,0,qualified);
    }
}//end class
