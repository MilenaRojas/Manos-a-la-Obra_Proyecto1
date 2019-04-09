/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import Domain.HeavyMachinery;
import Domain.Vehicle;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 
 */
public class FileHeavyMachinery {
   //atributos
    /**
     * 
     */
    public RandomAccessFile randomAccessFile;
    private int regsQuantity;//me indica la cantidad de registros
    private int regSize;//tamaño de registro
    private String myFilePath;//ruta
    
    //constructor
    /**
     * 
     * @param file
     * @throws IOException
     */
    public FileHeavyMachinery(File file) throws IOException{
        start(file);
    }
    
    /**
     * instancia el random access file y coloca el valor
     * de mis variables privadas
     * @param file
     * @throws IOException
     */
    private void start(File file) throws IOException{
        //almaceno la ruta
        myFilePath = file.getPath();
        
        //tamanno maximo de los registros dentro de esta 
        //clase
        this.regSize = 140;
        
        //una validacion basica
        if(file.exists() && !file.isFile()){
            throw new IOException(file.getName() 
                    + " is an invalid file");
        }
        else{
            //crear la nueva instancia de randomAccessFile
            randomAccessFile = new RandomAccessFile(file, "rw");
            
            //necesitamos indicar cuantos registros tiene el archivo
            this.regsQuantity = (int)Math.ceil((double)randomAccessFile.length() / (double)regSize);
        }
    }//fin start
    
    /**
     * cierra la conexion de mi programa con el archivo que
     * estoy manipulando
     * @throws IOException
     */
    public void close() throws IOException{
        randomAccessFile.close();
    }
    
    /**
     * indica la cantidad de registros del archivo actual
     * @return cantidad de registros
     */
    public int fileSize(){
        return regsQuantity;
    }
    
    /**
     * inserta un nuevo registro pero en una posicion existente
     * @param position
     * @param vehicle
     * @return
     * @throws IOException
     */
    public boolean putValue(int position, HeavyMachinery heavyMachinery) throws IOException{
        //una pequenna validacion antes de insertar
        if(position >= 0 && position <= regsQuantity){
            if(heavyMachinery.size() > regSize){
                System.err.print("7001 record size is out of bounds");
                return false;
            }
            else{
                //escribimos en archivo
                randomAccessFile.seek(position * regSize);
                randomAccessFile.writeInt(heavyMachinery.getWeight());
                randomAccessFile.writeUTF(heavyMachinery.getName());
                randomAccessFile.writeInt(heavyMachinery.getAge());
                randomAccessFile.writeFloat(heavyMachinery.getMileage());
                randomAccessFile.writeBoolean(heavyMachinery.isAmericano());
                randomAccessFile.writeInt(heavyMachinery.getSerie());
                return true;
            }
        }
        else{
            System.err.print("7002 position is "
                    + "out of bounds of this file");
                return false;
        }
        
    }//fin metodo
    
    /**
     * agrega un registro nuevo pero al final del archivo, por esa razon
     * se incrementa la cantidad de registros
     * @param vehicle
     * @return
     * @throws IOException
     */
    public boolean addEndRecord(HeavyMachinery heavyMachinery) throws IOException{
        //insertar al final del archivo
       HeavyMachinery heavyMachineryTemp= searchBySeries(heavyMachinery.getSerie());
        if(heavyMachineryTemp != null){
            if(heavyMachineryTemp.getName().equalsIgnoreCase("deleted")){
                updateRecord(heavyMachinery);
                return true;
            }
                System.err.print("7009 the record already exists");
                
                return false;
            }
          
        boolean success = putValue(regsQuantity, heavyMachinery);
        
        if(success){
            ++regsQuantity;
        }
        return success;
    }
    
    
    /**
     * obtiene un registro de una vehiclea en la posicion indicada
     * @param position
     * @return objeto de tipo Vehicle con los datos del registro de esa vehiclea
     * @throws IOException
     */
    public HeavyMachinery getHeavyMachinery(int position) throws IOException{
        //validacion de la posicion
        if(position >= 0 && position <= regsQuantity){
            //colocamos el puntero en el lugar 
            randomAccessFile.seek(position * regSize);
            
            //instancia de vehicle
            HeavyMachinery myHeavyMachinery = new HeavyMachinery();
            
            //llevamos a cabo las lecturas
            myHeavyMachinery.setTypeMachinery(randomAccessFile.readUTF());
            myHeavyMachinery.setWeight(randomAccessFile.readInt());
            myHeavyMachinery.setName(randomAccessFile.readUTF());
            myHeavyMachinery.setAge(randomAccessFile.readInt());
            myHeavyMachinery.setMileage(randomAccessFile.readFloat());
            myHeavyMachinery.setAmericano(randomAccessFile.readBoolean());
            myHeavyMachinery.setSerie(randomAccessFile.readInt());
            
            //si es delete no retorno
            if(myHeavyMachinery.getName().equalsIgnoreCase("delete")){
                return null;
            }
            else{
                return myHeavyMachinery;
            }
            
        }
        else{
            System.err.println("6001 position is out of bounds");
            return null;
        }
    }//fin de metodo
    
    /**
     * consulta todos los registros de mi archivo
     * @return una lista de objetos tipo Vehicle
     * @throws IOException
     */
    public List<HeavyMachinery> getAllHeavyMachinery() throws IOException{
        
        //variables a retornar
        List<HeavyMachinery> heavyMachinerys = new ArrayList<HeavyMachinery>();
        //recorro todos mis registros y los inserto en la lista
        for(int i = 0; i < regsQuantity; i++){
          HeavyMachinery heavyMachineryTemp =this.getHeavyMachinery(i);
          if((heavyMachineryTemp != null)  && (!heavyMachineryTemp.getName().equalsIgnoreCase("deleted"))){
                heavyMachinerys.add(heavyMachineryTemp);
            }
        }
        
        return heavyMachinerys;
    }//fin metodo
    
    
    public boolean deleteHeavyMachinery(int serie) throws IOException{
        HeavyMachinery myHeavyMachinery;
        
        //buscar el registro para la eliminacion
        for(int i = 0; i < regsQuantity; i++){
            
            //obtengo a la vehiclea de esa posicion
            myHeavyMachinery =this.getHeavyMachinery(i);
                
            //pregunto si es la vehiclea que quiero eliminar
            if(myHeavyMachinery.getSerie()==serie){

                //marcar esta vehiclea como eliminada
                myHeavyMachinery.setName("deleted");

                return this.putValue(i,myHeavyMachinery);
            }
        }
        
        //si llega a este punto no encontro a la vehiclea
        return false;
    }

 public HeavyMachinery searchBySeries(int serie) throws IOException{
        HeavyMachinery myHeavyMachinery;
        
        //buscar el registro para la eliminacion
        for(int i = 0; i < regsQuantity; i++){
            
            //obtengo a la vehiclea de esa posicion
            myHeavyMachinery = (HeavyMachinery) this.getHeavyMachinery(i);
                
            //pregunto si es la vehiclea que quiero eliminar
            if(myHeavyMachinery.getSerie()== serie){

                //marcar esta vehiclea como eliminada

                return myHeavyMachinery;
            }
        }
        
        //si llega a este punto no encontro a la vehiclea
        return null;
    }
 
   public boolean updateRecord(HeavyMachinery heavyMachinery) throws IOException{
        HeavyMachinery myHeavyMachinery;
        
        //buscar el registro para la eliminacion
        for(int i = 0; i < regsQuantity; i++){
            
            //obtengo a la vehiclea de esa posicion
            myHeavyMachinery = (HeavyMachinery) this.getHeavyMachinery(i);
                
            //pregunto si es la vehiclea que quiero eliminar
            if((heavyMachinery.getSerie())==myHeavyMachinery.getSerie()){

                //marcar esta vehiclea como eliminada
                
                myHeavyMachinery.setName(heavyMachinery.getName());
                myHeavyMachinery.setAge(heavyMachinery.getAge());
                myHeavyMachinery.setAmericano(heavyMachinery.isAmericano());
                myHeavyMachinery.setMileage(heavyMachinery.getMileage());
                myHeavyMachinery.setWeight(heavyMachinery.getWeight());
                myHeavyMachinery.setTypeMachinery(heavyMachinery.getTypeMachinery());
                
              
                

                return this.putValue(i, heavyMachinery);
            }
        }
        
        //si llega a este punto no encontro a la vehiclea
        return false;
    }
}