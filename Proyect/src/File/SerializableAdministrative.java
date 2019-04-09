/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import Domain.Administrative;
import Domain.Driver;
import java.io.File;
import java.io.FileInputStream;
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
public class SerializableAdministrative {
    private String path;

    /**
     * 
     * @param path_
     */
    public SerializableAdministrative(String path_) {
        super();
        
        //ruta del archivo
        this.path = path_;
    }

    
    /**
     * Guarda en archivo un objeto de tipo Person
     * @param administrative_
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void serialize(Administrative administrative_) throws IOException, ClassNotFoundException{
        
        //instancia de file
        File myFile = new File(path);
        
        //lista que se obtiene y se guarda en archivo
        List<Administrative> administrativeList = new ArrayList<Administrative>();
        
        //si el archivo existe, recupero la lista
        if(myFile.exists()){
            ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInput.readObject();
            
            //casting a lista
            administrativeList = (List<Administrative>)aux;
            objectInput.close();  
        }
        
        //agrego la persona a la lista
        administrativeList.add(administrative_);
        
        //escribo el objeto lista (que contiene objetos de tipo Person) en archivo
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
        output.writeUnshared(administrativeList);
        
        //cierro el archivo
        output.close();
    }
    
    /**
     * Busca en el archivo la persona y la retorna como Objeto Person
     * @param name_ nombre de la persona que se busca en el archivo
     * @return objeto de tipo Person, con los datos de la persona que se busca
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Administrative getPerson(String name_) throws IOException, ClassNotFoundException {
        
        //instancia de file
        File myFile = new File(path);
        
        //lista que voy a recorrer para buscar a una persona
        List<Administrative> administrativeList = new ArrayList<Administrative>();
        
        //si el archivo existe entonces recupero a la persona
        if(myFile.exists()){
            //llevo a cabo una lectura de la lista
            ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInput.readObject();
            
            //casting del objeto
            administrativeList = (List<Administrative>)aux;
            objectInput.close();  
        }
        
        //mi instancia a retornar
        Administrative administrative = new Administrative();
        
        //recorro la lista en busca de la persona que me interesa
        for(int i = 0; i < administrativeList.size(); i++){
            
            //pregunta si es la persona
            if(administrativeList.get(i).getName().equalsIgnoreCase(name_)){
                //
                administrative = administrativeList.get(i);
                
                //esta linea me hace salir del ciclo
                break;
            }
        }
        
        //retorna la persona ya sea con datos nulos o con la persona buscada
        return administrative;
    }
}
