/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Domain.Administrative;
import Domain.Driver;
import Domain.Janitor;
import File.SerializableAdministrative;
import File.SerializableDriver;
import File.SerializableJanitor;
import Utility.Path;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Milena
 */
public class SerializableDriverTest {
    
    public SerializableDriverTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    
     @Test
     public void DriverSerializable () throws IOException, ClassNotFoundException {
     
        
         Driver driver1= new Driver("B1", 1, 1, 1, true, "Margo", "Leiva", 1);
         Driver driver2= new Driver("C1", 5, 5, 5, false, "Marta", "Rojas", 5);
     
         //crea la instancia para la manipulacion de archivos serializables
         SerializableDriver driverData = new SerializableDriver(Path.pathDriver);
         
         //guardar el objeto en archivo
         driverData.serialize(driver1);
         driverData.serialize(driver2);
         
         System.out.println(driverData);
     
     }
     
     @Test
     public void JanitorSerializable () throws IOException, ClassNotFoundException {
     
        
         Janitor janitor1= new Janitor("Clean", 6, 2, true, "Marco", "Cañas", 1234);
         Janitor janitor2= new Janitor("rdi", 9, 1, false, "Mariana", "Bravo", 5678);
         
     
         //crea la instancia para la manipulacion de archivos serializables
         SerializableJanitor janitorData = new SerializableJanitor(Path.pathDriver);
         
         //guardar el objeto en archivo
         janitorData.serialize(janitor1);
         janitorData.serialize(janitor2);
         
         System.out.println(janitorData);
     
     }
     
     @Test
     public void AdministrativeSerializable () throws IOException, ClassNotFoundException {
     
        
         Administrative administrative1= new Administrative(2, 8, "Manuel", "Soza", 9864);
         Administrative administrative2= new Administrative(9, 12, "Javier", "Quiros", 98452);
     
         //crea la instancia para la manipulacion de archivos serializables
         SerializableAdministrative administrativeData = new SerializableAdministrative(Path.pathDriver);
         
         //guardar el objeto en archivo
         administrativeData.serialize(administrative1);
         administrativeData.serialize(administrative2);
         
         System.out.println(administrativeData);
     
     }
     

}
