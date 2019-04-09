/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

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
public class FileVehicle {
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
    public FileVehicle(File file) throws IOException{
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
    public boolean putValue(int position, Vehicle vehicle) throws IOException{
        //una pequenna validacion antes de insertar
        if(position >= 0 && position <= regsQuantity){
            if(vehicle.size() > regSize){
                System.err.print("7001 record size is out of bounds");
                return false;
            }
            else{
                //escribimos en archivo
                randomAccessFile.seek(position * regSize);
                randomAccessFile.writeInt(vehicle.getWeight());
                randomAccessFile.writeUTF(vehicle.getName());
                randomAccessFile.writeInt(vehicle.getAge());
                randomAccessFile.writeFloat(vehicle.getMileage());
                randomAccessFile.writeBoolean(vehicle.isAmericano());
                randomAccessFile.writeInt(vehicle.getSerie());
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
    public boolean addEndRecord(Vehicle vehicle) throws IOException{
        //insertar al final del archivo
       Vehicle vehicleTemp= searchBySeries(vehicle.getSerie());
        if(vehicleTemp != null){
            if(vehicleTemp.getName().equalsIgnoreCase("deleted")){
                updateRecord(vehicle);
                return true;
            }
                System.err.print("7009 the record already exists");
                
                return false;
            }
          
        boolean success = putValue(regsQuantity, vehicle);
        
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
    public Vehicle getVehicle(int position) throws IOException{
        //validacion de la posicion
        if(position >= 0 && position <= regsQuantity){
            //colocamos el puntero en el lugar 
            randomAccessFile.seek(position * regSize);
            
            //instancia de vehicle
            Vehicle myVehicle = new Vehicle();
            
            //llevamos a cabo las lecturas
            myVehicle.setWeight(randomAccessFile.readInt());
            myVehicle.setName(randomAccessFile.readUTF());
            myVehicle.setAge(randomAccessFile.readInt());
            myVehicle.setMileage(randomAccessFile.readFloat());
            myVehicle.setAmericano(randomAccessFile.readBoolean());
            myVehicle.setSerie(randomAccessFile.readInt());
            
            //si es delete no retorno
            if(myVehicle.getName().equalsIgnoreCase("delete")){
                return null;
            }
            else{
                return myVehicle;
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
    public List<Vehicle> getAllVehicles() throws IOException{
        
        //variables a retornar
        List<Vehicle> vehicles = new ArrayList<Vehicle>();
        
        //recorro todos mis registros y los inserto en la lista
        for(int i = 0; i < regsQuantity; i++){
            Vehicle vehicleTemp = this.getVehicle(i);
          if((vehicleTemp != null)  && (!vehicleTemp.getName().equalsIgnoreCase("deleted"))){
                vehicles.add(vehicleTemp);
            }
        }
        
        return vehicles;
    }//fin metodo
    
    
    public boolean deleteVehicle(int serie) throws IOException{
        Vehicle myVehicle;
        
        //buscar el registro para la eliminacion
        for(int i = 0; i < regsQuantity; i++){
            
            //obtengo a la vehiclea de esa posicion
            myVehicle = this.getVehicle(i);
                
            //pregunto si es la vehiclea que quiero eliminar
            if(myVehicle.getSerie()==serie){

                //marcar esta vehiclea como eliminada
                myVehicle.setName("deleted");

                return this.putValue(i, myVehicle);
            }
        }
        
        //si llega a este punto no encontro a la vehiclea
        return false;
    }

 public Vehicle searchBySeries(int serie) throws IOException{
        Vehicle myVehicle;
        
        //buscar el registro para la eliminacion
        for(int i = 0; i < regsQuantity; i++){
            
            //obtengo a la vehiclea de esa posicion
            myVehicle = this.getVehicle(i);
                
            //pregunto si es la vehiclea que quiero eliminar
            if(myVehicle.getSerie()== serie){

                //marcar esta vehiclea como eliminada

                return myVehicle;
            }
        }
        
        //si llega a este punto no encontro a la vehiclea
        return null;
    }
 
   public boolean updateRecord(Vehicle vehicle) throws IOException{
        Vehicle myVehicle;
        
        //buscar el registro para la eliminacion
        for(int i = 0; i < regsQuantity; i++){
            
            //obtengo a la vehiclea de esa posicion
            myVehicle = this.getVehicle(i);
                
            //pregunto si es la vehiclea que quiero eliminar
            if((vehicle.getSerie())==myVehicle.getSerie()){

                //marcar esta vehiclea como eliminada
                
                myVehicle.setName(vehicle.getName());
                myVehicle.setAge(vehicle.getAge());
                myVehicle.setAmericano(vehicle.isAmericano());
                myVehicle.setMileage(vehicle.getMileage());
                myVehicle.setWeight(vehicle.getWeight());
               
                
              
                

                return this.putValue(i, myVehicle);
            }
        }
        
        //si llega a este punto no encontro a la vehiclea
        return false;
    }
}