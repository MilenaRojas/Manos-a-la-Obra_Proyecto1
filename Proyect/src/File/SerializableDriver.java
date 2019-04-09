/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import Domain.Driver;
import Domain.Employee;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author beatriz
 */
public class SerializableDriver {

    private String path;

    /**
     *
     * @param path_
     */
    public SerializableDriver(String path_) {
        super();

        //ruta del archivo
        this.path = path_;
    }

    /**
     * Guarda en archivo un objeto de tipo Driver
     *
     * @param driver_
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void serialize(Driver driver_) throws IOException, ClassNotFoundException {

        //instancia de file
        File myFile = new File(path);

        //lista que se obtiene y se guarda en archivo
        List<Driver> driverList = new ArrayList<Driver>();

        //si el archivo existe, recupero la lista
        if (myFile.exists()) {
            ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInput.readObject();

            //casting a lista
            driverList = (List<Driver>) aux;
            objectInput.close();
        }

        //agrego la drivera a la lista
        driverList.add(driver_);
        
        //escribo el objeto lista (que contiene objetos de tipo Driver) en archivo
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
        output.writeUnshared(driverList);

        //cierro el archivo
        output.close();
    }

    /**
     * Busca en el archivo la drivera y la retorna como Objeto Driver
     *
     * @param name_ nombre de la drivera que se busca en el archivo
     * @return objeto de tipo Driver, con los datos de la drivera que se busca
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Driver getDriver(String name_) throws IOException, ClassNotFoundException {

        //instancia de file
        File myFile = new File(path);

        //lista que voy a recorrer para buscar a una drivera
        List<Driver> driverList = new ArrayList<Driver>();

        //si el archivo existe entonces recupero a la drivera
        if (myFile.exists()) {
            //llevo a cabo una lectura de la lista
            ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInput.readObject();

            //casting del objeto
            driverList = (List<Driver>) aux;
            objectInput.close();
        }

        //mi instancia a retornar
        //recorro la lista en busca de la drivera que me interesa
        for (int i = 0; i < driverList.size(); i++) {
            System.out.println("-------"+driverList.get(i).getName()+"Nameee objeto");
            System.out.println(name_+"Name a buscar");
            
            if (driverList.get(i).getName().equalsIgnoreCase(name_)) {
                Driver myDriver = driverList.get(i);
            
                //esta linea me hace salir del ciclo
                break;
            }
        }

        //retorna la drivera ya sea con datos nulos o con la drivera buscada
        return null;
    }

}
