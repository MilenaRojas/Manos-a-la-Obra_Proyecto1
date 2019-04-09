
package Domain;

public class HeavyMachinery extends Vehicle {
    //atributos
     private String typeMachinery;
    
     //Constructors 

       public HeavyMachinery() {
        super();
        this.typeMachinery = "";
    } 
       
    public HeavyMachinery(int weight, String name, int age, float mileage, boolean americano, int serie, String typeMachinery) {
        super(weight, name, age, mileage, americano, serie);
        this.typeMachinery = typeMachinery;
    }

    
   //get's and set's

    public String getTypeMachinery() {
        return typeMachinery;
    }

    public void setTypeMachinery(String typeMachinery) {
        this.typeMachinery = typeMachinery;
    }

    @Override
    public String toString() {
        return super.toString()+"typeMachinery:" + typeMachinery;
    }
   
}//End class
