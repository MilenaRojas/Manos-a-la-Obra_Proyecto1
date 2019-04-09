
package Domain;

public class HeavyMachineryDriver extends Driver {
    //atributos
     private int typeHeavyMachineryDriver;
   //Constructors
    public HeavyMachineryDriver() {
        this.typeHeavyMachineryDriver=0;
    }
    
    public HeavyMachineryDriver(int typeHeavyMachineryDriver) {
        this.typeHeavyMachineryDriver = typeHeavyMachineryDriver;
    }

    public HeavyMachineryDriver(int typeHeavyMachineryDriver, String licenseType, int dayTimHours, int nigthHours, int timeWorked, boolean qualified, String name, String lastName, int identification) {
        super(licenseType, dayTimHours, nigthHours, timeWorked, qualified, name, lastName, identification);
        this.typeHeavyMachineryDriver = typeHeavyMachineryDriver;
    }

   
    
        
    
    
    
   
     public String employeeNomber(){
       String id="";
       int randomNumber=0;
       
         if("02".equals(typeHeavyMachineryDriver)){
           id="02";
             for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
            randomNumber=(int)(Math.random()*10);
            id= id + randomNumber;
            }
        }
      
         } else if("03".equals(typeHeavyMachineryDriver)){
           id="03";
             for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
            randomNumber=(int)(Math.random()*10);
            id= id + randomNumber;
            }
        }
      
         } else if("04".equals(typeHeavyMachineryDriver)){
           id="04";
             for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
            randomNumber=(int)(Math.random()*10);
            id= id + randomNumber;
            }
        }
      
         }
        
      return id;
    } 

    @Override
    public String toString() {
        return super.toString()+"\nEmployee Number:"+employeeNomber(); //To change body of generated methods, choose Tools | Templates.
    }
     
     
    
}//end class
