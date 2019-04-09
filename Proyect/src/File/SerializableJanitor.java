/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import Domain.Driver;
import Domain.Janitor;
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
public class SerializableJanitor {
  private String path;

    /**
     * 
     * @param path_
     */
    public SerializableJanitor(String path_) {
        super();
        
        //ruta del archivo
        this.path = path_;
    }

    
    /**
     * Guarda en archivo un objeto de tipo Person
     * @param janitor_
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void serialize(Janitor janitor_) throws IOException, ClassNotFoundException{
        
        //instancia de file
        File myFile = new File(path);
        
        //lista que se obtiene y se guarda en archivo
        List<Janitor> janitorList = new ArrayList<Janitor>();
        
        //si el archivo existe, recupero la lista
        if(myFile.exists()){
            ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInput.readObject();
            
            //casting a lista
            janitorList = (List<Janitor>)aux;
            objectInput.close();  
        }
        
        //agrego la persona a la lista
        janitorList.add(janitor_);
        
        //escribo el objeto lista (que contiene objetos de tipo Person) en archivo
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
        output.writeUnshared(janitorList);
        
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
    public Janitor getPerson(String name_) throws IOException, ClassNotFoundException {
        
        //instancia de file
        File myFile = new File(path);
        
        //lista que voy a recorrer para buscar a una persona
        List<Janitor> janitorList = new ArrayList<Janitor>();
        
        //si el archivo existe entonces recupero a la persona
        if(myFile.exists()){
            //llevo a cabo una lectura de la lista
            ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInput.readObject();
            
            //casting del objeto
            janitorList = (List<Janitor>)aux;
            objectInput.close();  
        }
        
        //mi instancia a retornar
        Janitor janitor = new Janitor();
        
        //recorro la lista en busca de la persona que me interesa
        for(int i = 0; i < janitorList.size(); i++){
            
            //pregunta si es la persona
            if(janitorList.get(i).getName().equalsIgnoreCase(name_)){
                //
                janitor = janitorList.get(i);
                
                //esta linea me hace salir del ciclo
                break;
            }
        }
        
        //retorna la persona ya sea con datos nulos o con la persona buscada
        return janitor;
    }  
}//end class
