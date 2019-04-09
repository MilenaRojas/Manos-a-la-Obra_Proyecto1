package Domain;

public class Automobile extends Vehicle {

    //Atributos
    private int quantityRider;//cant de pasajeros 
    private String typeAuto;

    //Constructors
    public Automobile(int quantityRide, String typeCar) {
        this.quantityRider = quantityRide;
        this.typeAuto = typeCar;
    }

    public Automobile() {
        this.quantityRider = 0;
        this.typeAuto = "";
    }
    //set's and get's

    public int getQuantityRider() {
        return quantityRider;
    }

    public void setQuantityRider(int quantityRider) {
        this.quantityRider = quantityRider;
    }

    public String getTypeAuto() {
        return typeAuto;
    }

    public void setTypeAuto(String typeAuto) {
        this.typeAuto = typeAuto;
    }

}// End class
