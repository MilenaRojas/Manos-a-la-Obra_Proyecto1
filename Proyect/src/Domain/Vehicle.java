

package Domain;

public class Vehicle {
    //atributos
    private int weight;
    private String name ;
    private int age; 
    private float mileage;
    private boolean americano;
    private int serie;
    
    
    //Constructors
    public Vehicle(int weight, String name,int age,float mileage,boolean americano,int serie) {
        this.weight = weight;
        this.name = name;
        this.age=age;
        this.americano= americano;
        this.mileage= mileage;
        this.serie=serie;
    }
    public Vehicle() {
        this.weight = 0;
        this.name = "";
         this.age=0;
        this.americano= false;
        this.mileage= 0;
        this.serie=0;

    }
    //get's and set's

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getMileage() {
        return mileage;
    }

    public void setMileage(float mileage) {
        this.mileage = mileage;
    }

    public boolean isAmericano() {
        return americano;
    }

    public void setAmericano(boolean americano) {
        this.americano = americano;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }
     public int size(){
        //tamanno de las variables en bytes
        //LONG: necesita dos bytes
        //String: cada caracter necesita dos bytes de espacio,
        //esto si se utiliza UTF
        return 4+ this.getName().length()*2+ 4 + 4+1+4;
    }

    @Override
    public String toString() {
        return "Vehicle:\n" + "Weight=" + weight + " kilos\n" +
                "Name=" + name + "\nYear=" + age + "\n" +
                "Mileage=" + mileage + "\n" +
                "American=" + americano + "\nSerie=" + serie;
    }

  
       
   
    
    
    
}//end class
