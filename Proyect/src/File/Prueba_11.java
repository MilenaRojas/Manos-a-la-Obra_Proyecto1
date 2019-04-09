/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import Domain.Driver;
import Utility.Path;
import java.io.IOException;

/**
 *
 * @author Milena
 */
public class Prueba_11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
           String path = "./Driver.dat"; 
             SerializableDriver serializableDriver = new SerializableDriver(Path.pathDriver);
           

    Driver driver1= new Driver("32", 0, 0, 0, true, "Mile", "Rojas", 0);
    
  Driver driver2= new Driver("2", 2, 2, 2, true, "2", "2",2);
  serializableDriver.serialize(driver1);
  serializableDriver.serialize(driver2);
  
  Driver driverTemp = serializableDriver.getDriver("Mile");

       

    }
    
}
