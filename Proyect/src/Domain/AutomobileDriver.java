package Domain;

import Domain.Driver;

public class AutomobileDriver extends Driver {

    //Atributos 
    private int experience;
//constructor

    public AutomobileDriver() {
        this.experience = 0;
    }
    //set's and get's

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

}//end class
